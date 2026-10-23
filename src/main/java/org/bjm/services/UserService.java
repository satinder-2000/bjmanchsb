package org.bjm.services;


import java.time.LocalDateTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bjm.dtos.UserDto;
import org.bjm.entities.Access;
import org.bjm.entities.User;
import org.bjm.entities.repositories.AccessRepository;
import org.bjm.entities.repositories.UserRepository;
import org.bjm.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private AccessRepository accessRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean registerUser(UserDto userDto) {
		//Firstly, sort out the User profile File
		User user = new User();
		Access access = new Access();
		access.setEmail(userDto.getEmail());
		access.setFailedAttempts(0);
		access.setCreatedOn(LocalDateTime.now());
		access.setUpdatedOn(LocalDateTime.now());
		access.setImage(userDto.getProfileImage());
		access.setProfileFile(userDto.getProfileFile().getOriginalFilename());
		access =accessRepository.save(access);
		LOGGER.info("Access created successfully !!");
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		//DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//LocalDate dobUser=LocalDate.parse(userDto.getDob(), dateTimeFormatter);
		//user.setDob(dobUser);
		user.setDob(DateUtils.parseDate(userDto.getDob()));
		user.setMobile(userDto.getMobile());
		user.setPhone(userDto.getPhone());
		user.setStateCode(userDto.getStateCode());
		user.setStateName(userDto.getStateName());
		user.setLokSabhaConstituency(userDto.getLokSabhaConstituency());
		user.setVidhanSabhaConstituency(userDto.getVidhanSabhaConstituency());
		user.setCreatedOn(LocalDateTime.now());
		user.setUpdatedOn(LocalDateTime.now());
		user = userRepository.save(user);
		LOGGER.info("User created successfully !!");
		return true;
	}
	
	

}
