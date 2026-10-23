package org.bjm.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bjm.dtos.StateDto;
import org.bjm.dtos.UserDto;
import org.bjm.services.ReferenceDataService;
import org.bjm.services.UserService;
import org.bjm.utils.BjmConstants;
import org.bjm.utils.ImageVO;
import org.bjm.utils.ProfileFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
public class UserRegisterController {
    
    private static final Logger LOGGER = LogManager.getLogger();
    private UserDto userDto;
    
    @Value("${logoSize}")
    private int logoSize;
    @Value("${logoFormat}")
    private String logoFormat;
    @Value("${maxProfileFileSize}")
    private String maxProfileFileSize;
    
    
    
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
    	userDto=new UserDto();
    	userDto.setStateDtos(referenceDataService.getAllStates());
    	modelAndView.addObject("userDto", userDto);
    	return modelAndView;
    }
    
    
    @PostMapping(path="/registerUser", consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ModelAndView registerUser(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, HttpServletRequest httpServletRequest) {
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
			processProfileFile(userDto,bindingResult);
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
	        HttpSession session = httpServletRequest.getSession(true);
	        String originalFileName = userDto.getProfileFile().getOriginalFilename();
	        String imgType=originalFileName.substring(originalFileName.indexOf('.')+1);
	        ImageVO imageVO=new ImageVO(imgType,userDto.getProfileImage());
	        session.setAttribute(BjmConstants.USER_PROFILE_IMAGE, imageVO);//This Image will be removed from Session once the data has been persisted.
			ModelAndView modelAndView = new ModelAndView("register/userRegisterConfirm");
			modelAndView.addObject("userDto", userDto);
	    	return modelAndView;
		}
    	
    }
    
    private void processProfileFile(UserDto userDto, BindingResult bindingResult) {
    		ProfileFileUtil profileFileUtil = new ProfileFileUtil(logoSize, logoFormat, Integer.parseInt(maxProfileFileSize), userDto,bindingResult);
    		userDto = profileFileUtil.processUserProfileFile();
    }


	@PostMapping("/registerUserConfirm")
	public String registerUserConfirm(@Valid UserDto userDto, BindingResult bindingResult) {
    	
		if (bindingResult.hasErrors()) {
			return "register/userRegister";
		}else {
			userService.registerUser(userDto);
		}
		//Process to register the User
		LOGGER.info("User Registered Successfully!!");
		return "register/userRegisterSuccess";
	}
    
}
