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

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Part;

public class ProfileFileUtil {

	private static final Logger LOGGER = LogManager.getLogger();

	@Value("${imageSize}")
	private String imageSizeStr;
	@Value("${imageFormat}")
	private String imageFormat;

	public UserDto processUserProfileFile(UserDto userDto) {
		BufferedImage profileBufferedImage = null;
		Part profileFile = userDto.getProfileFile();
		if (profileFile == null) {// User did not Upload the Profile file. Make Avatar with the Initials
			try {
				char[] chars = new char[2];
				chars[0] = userDto.getFirstName().charAt(0);
				chars[1] = userDto.getLastName().charAt(0);
				int imageSize = Integer.parseInt(imageSizeStr);

				String text = new String(chars);
				profileBufferedImage = ImageUtil.drawIcon(imageSize, text);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(profileBufferedImage, imageFormat, baos);
				baos.flush();
				byte[] imgData = baos.toByteArray();
				baos.close();
				userDto.setProfileImageType(text + "." + imageFormat);
				userDto.setProfileImage(imgData);
				LOGGER.info("Initials Logo text in userDto: " + text);
				System.out.println();
				System.out.println("Initials Logo byte{} size in userDto: " + imgData.length);
			} catch (IOException ex) {
				LOGGER.error(ex.getMessage());
			}

		} else {
			try {
				InputStream inputStream = profileFile.getInputStream();
				int imageSize = (int) profileFile.getSize();
				if (imageSize > (1024 * 1000)) {
					// FacesContext.getCurrentInstance().addMessage("profileImage",
					// new FacesMessage(FacesMessage.SEVERITY_ERROR, "Profile Image size exceeds
					// 1MB.", "Profile Image size exceeds 1MB."));
					// TODO
				} else {
					String fullFileName = profileFile.getSubmittedFileName();
					// String fileType=fullFileName.substring(fullFileName.indexOf('.'));
					byte[] imageData = new byte[inputStream.available()];
					inputStream.read(imageData);
					userDto.setProfileImageType(fullFileName);
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
