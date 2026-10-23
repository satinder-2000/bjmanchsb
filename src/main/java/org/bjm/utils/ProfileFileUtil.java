package org.bjm.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bjm.dtos.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;


public class ProfileFileUtil {

	private static final Logger LOGGER = LogManager.getLogger();

	@Value("${logoSize}")
	private int logoSize;
	@Value("${logoFormat}")
	private String logoFormat;//includes . prefix
	private int maxProfileFileSize;
	private UserDto userDto;
	private BindingResult bindingResult;
	
	public ProfileFileUtil(int logoSize, String logoFormat, int maxProfileFileSize,  UserDto userDto, BindingResult bindingResult) {
		super();
		this.logoSize = logoSize;
		this.logoFormat = logoFormat;
		this.maxProfileFileSize=maxProfileFileSize;
		this.userDto = userDto;
		this.bindingResult = bindingResult;
	}



	public UserDto processUserProfileFile() {
		BufferedImage profileBufferedImage = null;
		MultipartFile profileFile = userDto.getProfileFile();
		if (profileFile.isEmpty()) {// User did not Upload the Profile file. Make Avatar with the Initials
				char[] chars = new char[2];
				chars[0] = userDto.getFirstName().charAt(0);
				chars[1] = userDto.getLastName().charAt(0);
				String text = new String(chars);
				profileBufferedImage = ImageUtil.drawIcon(logoSize, text);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] imgData = null;
				try {
					ImageIO.write(profileBufferedImage, logoFormat, baos);
					baos.flush();
					imgData = baos.toByteArray();
					baos.close();
					userDto.setProfileImageType(text +  logoFormat);
					userDto.setProfileImage(imgData);
					LOGGER.info("Initials Logo text in userDto: " + text);
					LOGGER.info("Initials Logo byte{} size in userDto: " + imgData.length);
					
				}catch(IOException ex) {
					ex.printStackTrace();
				}
		} else {
			try {
				InputStream inputStream = profileFile.getInputStream();
				int imageSize = (int) profileFile.getSize();
				if (imageSize > maxProfileFileSize) {
					bindingResult.rejectValue("profileFile", "File size must not exceed 500 KB.",
	      					"File size must not exceed 500 KB.");
	      			return null;
				} else {
					String fullFileName = profileFile.getOriginalFilename();
					// String fileType=fullFileName.substring(fullFileName.indexOf('.'));
					byte[] imageData = new byte[inputStream.available()];
					inputStream.read(imageData);
					String profileImgType=fullFileName.substring(fullFileName.indexOf("."));
					userDto.setProfileImageType(profileImgType);
					userDto.setProfileImage(imageData);
					System.out.println("User profile file name in userDto: " + fullFileName);
					System.out.println("User profile file byte{} size in userDto: " + userDto.getProfileImage().length);
				}
			} catch (IOException ex) {
				LOGGER.error(ex.getMessage());
				throw new RuntimeException(ex.getMessage());
			}
		}
		return userDto;

	}

}
