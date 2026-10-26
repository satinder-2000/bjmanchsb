package org.bjm.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bjm.LoginException;
import org.bjm.dtos.AccessDto;
import org.bjm.dtos.LoginDto;
import org.bjm.entities.Access;
import org.bjm.entities.repositories.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccessService {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AccessRepository accessRepository;
	
	public Access getAccessForUser(String email) {
		return accessRepository.findByEmail(email);
	}
	
	@SuppressWarnings("null")
	public void createUserPassword(AccessDto accessDto) {
		//We need to endcode the password before persisting
		String encodedPassword=passwordEncoder.encode(accessDto.getPassword());
		Access access = accessRepository.findByEmail(accessDto.getEmail());
		access.setPassword(encodedPassword);
		access = accessRepository.save(access);
		LOGGER.info(String.format("Encoded password persisted for User %s ", access.getEmail()));
	}
	
	public boolean performLogin(String email, String password) throws LoginException {
		//All the attributes are in Access Entity. 
		//Lets fetch the Access object corresponding to the email param
		Access access=accessRepository.findByEmail(email);
		String accessPassword=access.getPassword();
		if(!passwordEncoder.matches(password, accessPassword)) {//PasswordEncoder specific step.
			int failedAttempts = access.getFailedAttempts();
			if (failedAttempts==3) {
				throw new LoginException("Max failed login attemts reached");
			}else {
				access.setFailedAttempts(access.getFailedAttempts()+1);
				accessRepository.save(access);
				throw new LoginException(String.format("Login Failed. Attempts left {d}", 3- access.getFailedAttempts()));
			}
		}else {
			access.setFailedAttempts(0);
			return true;
		}
		
	}
	
	

}
