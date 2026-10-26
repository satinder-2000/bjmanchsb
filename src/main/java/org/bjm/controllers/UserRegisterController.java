package org.bjm.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bjm.dtos.StateDto;
import org.bjm.dtos.UserDto;
import org.bjm.services.ReferenceDataService;
import org.bjm.services.UserService;
import org.bjm.utils.BjmConstants;
import org.bjm.utils.ImageUtil;
import org.bjm.utils.ImageVO;
import org.bjm.utils.ProfileFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

/**
 *
 * @author user
 */
@Controller
@SessionAttributes("userDto")
public class UserRegisterController {
    
    private static final Logger LOGGER = LogManager.getLogger();
    private UserDto userDto;
    
    @Value("${logoSize}")
    private int logoSize;
    @Value("${logoFormat}")
    private String logoFormat;
    @Value("${maxProfileFileSize}")
    private String maxProfileFileSize;
    
    @ModelAttribute("userDto")
    public UserDto createUserDto() {
    	return new UserDto();
    }
    
    
    
    @Autowired
    ReferenceDataService referenceDataService;
 

    
    @Autowired
    private UserService userService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
            String.class,
            new StringTrimmerEditor(true)
        );
    }
    
    @GetMapping("/registerUser")
    private ModelAndView registerUserForm() {
    	ModelAndView modelAndView = new ModelAndView("register/userRegister");
    	userDto=createUserDto();
    	userDto.setStateDtos(referenceDataService.getAllStates());
    	modelAndView.addObject("userDto", userDto);
    	return modelAndView;
    }
        
    @PostMapping(path="/registerUser", consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ModelAndView registerUser(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, HttpServletRequest httpServletRequest) throws IOException {
    	//Only StateCode is populated from the page but in the Confirmation Page, we need to display the State Name
    	userDto.setStateDtos(referenceDataService.getAllStates());
    	List<StateDto> stateDtos = userDto.getStateDtos();
    	for(StateDto stateDto: stateDtos) {
    		if (stateDto.getCode().equals(userDto.getStateCode())){
    			userDto.setStateName(stateDto.getName());
    			break;
    		}
    		
    	}
    	//If User has not uploaded the profile file, we need to handle that first
    	try {
			userDto = processProfileFile(userDto,bindingResult);
		}catch(Exception ex) {
			LOGGER.error(ex.getMessage());
			ex.printStackTrace();
		}
    	
    	if (bindingResult.hasErrors()) {
    		ModelAndView modelAndView = new ModelAndView("register/userRegister");
			modelAndView.addObject("userDto", userDto);
	    	return modelAndView;
		}else {
			//We would need to display the Image in the ConfirmPage, which is next in the Flow.
	        //There is no solution for that - only a workaround.
	        //We put this image in the session for now and once the Deeder data has been persisted in the Database the image from the session will be removed.
	        userDto =processProfileFile(userDto, bindingResult);
			ModelAndView modelAndView = new ModelAndView("register/userRegisterConfirm");
			modelAndView.addObject("userDto", userDto);
	    	return modelAndView;
		}
    	
    }
    
    private UserDto processProfileFile(UserDto userDto, BindingResult bindingResult) {
    	BufferedImage profileBufferedImage = null;
		MultipartFile profileFile = userDto.getProfileFile();
		if (profileFile.isEmpty()) {// User did not Upload the Profile file. Make Avatar with the Initials
				char[] chars = new char[2];
				chars[0] = userDto.getFirstName().charAt(0);
				chars[1] = userDto.getLastName().charAt(0);
				String text = new String(chars).toUpperCase();
				profileBufferedImage = ImageUtil.drawIcon(logoSize, text);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] imgData = null;
				try {
					boolean written = ImageIO.write(profileBufferedImage, logoFormat, baos);
					if(!written) {
						FieldError fe = new FieldError("userDto","profileFile","Unsupported image format: "+logoFormat);
						bindingResult.addError(fe);
					}
					baos.flush();
					imgData = baos.toByteArray();
					baos.close();
					userDto.setProfileImageType(logoFormat);
					userDto.setProfileImage(imgData);
					LOGGER.info("Initials Logo text in userDto: " + text);
					LOGGER.info("Initials Logo byte{} size in userDto: " + imgData.length);
					
				}catch(IOException ex) {
					LOGGER.error("Failed to generate avatar", ex);
					FieldError fe = new FieldError("userDto","profileFile","Failed to generate avatar");
					bindingResult.addError(fe);
				}
		} else {
			try {
				InputStream inputStream = profileFile.getInputStream();
				int imageSize = (int) profileFile.getSize();
				if (imageSize > Integer.valueOf(maxProfileFileSize)) {
					bindingResult.rejectValue("profileFile", "File size must not exceed 500 KB.",
	      					"File size must not exceed 500 KB.");
	      		} else {
					String fullFileName = profileFile.getOriginalFilename();
					// String fileType=fullFileName.substring(fullFileName.indexOf('.'));
					byte[] imageData = new byte[inputStream.available()];
					inputStream.read(imageData);
					String profileImgType=fullFileName.substring(fullFileName.indexOf("."));
					userDto.setProfileImageType(profileImgType);
					userDto.setProfileImage(imageData);
					LOGGER.info("User profile file name in userDto: " + fullFileName);
					LOGGER.info("User profile file byte{} size in userDto: " + userDto.getProfileImage().length);
				}
			} catch (IOException ex) {
				LOGGER.error(ex.getMessage());
				FieldError fe = new FieldError("userDto","profileFile",ex.getMessage());
				bindingResult.addError(fe);
			}
		}
		return userDto;
    }
    
    @PostMapping("/amendRegistration")
    public ModelAndView amendRegistration(@ModelAttribute("userDto") UserDto userDto) {
    	ModelAndView modelAndView = new ModelAndView("register/userRegister");
    	userDto.setStateDtos(referenceDataService.getAllStates());
    	modelAndView.addObject("userDto", userDto);
    	return modelAndView;
    }


	@PostMapping("/confirmRegistration")
	public String confirmRegistration(@Valid UserDto userDto, BindingResult bindingResult) {
    	
		if (bindingResult.hasErrors()) {
			return "register/userRegister";
		}else {
			userService.registerUser(userDto);
		}
		//Process to register the User
		LOGGER.info("User Registered Successfully!!");
		return "register/userRegisterSuccess";
	}
	
	@ResponseBody
	@GetMapping("/images/UserProfileImage")
	public ResponseEntity<byte[]> getProfileImage(
	        @ModelAttribute("userDto") UserDto userDto) {

	    byte[] imageBytes = userDto.getProfileImage();

	    if (imageBytes == null || imageBytes.length == 0) {
	        return ResponseEntity.notFound().build();
	    }

	    String imgType = userDto.getProfileImageType();
	    MediaType mediaType;
	    if ("png".equalsIgnoreCase(imgType)) {
	        mediaType = MediaType.IMAGE_PNG;
	    } else if ("jpeg".equalsIgnoreCase(imgType)
	            || "jpg".equalsIgnoreCase(imgType)) {
	        mediaType = MediaType.IMAGE_JPEG;
	    }else if("gif".equalsIgnoreCase(imgType)){
	    	mediaType = MediaType.IMAGE_GIF;
	    } else {
	        return ResponseEntity.badRequest().build();
	    }

	    if ("png".equalsIgnoreCase(imgType)) {
	        return ResponseEntity.ok()
	                .contentType(MediaType.IMAGE_PNG)
	                .body(imageBytes);
	    }

	    return ResponseEntity.badRequest().build();
	}
    
}
