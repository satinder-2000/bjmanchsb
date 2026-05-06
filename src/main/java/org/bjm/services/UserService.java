package org.bjm.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bjm.dtos.UserDto;
import org.bjm.entities.Access;
import org.bjm.entities.User;
import org.bjm.entities.repositories.AccessRepository;
import org.bjm.entities.repositories.UserRepository;
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
		User user = new User();
		Access access = new Access();
		
		access =accessRepository.save(access);
		LOGGER.info("Access created successfully !!");
		
		user = userRepository.save(user);
		LOGGER.info("User created successfully !!");
		return true;
	}
	
	

}
