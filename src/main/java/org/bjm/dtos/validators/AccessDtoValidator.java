package org.bjm.dtos.validators;

import org.bjm.dtos.AccessDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AccessDtoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return AccessDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "password", "confirmPassword");
		AccessDto accessDto=(AccessDto) target;
		if (accessDto.getPassword().length()<10) {
			errors.rejectValue("password", "Password must be at least 10 characters");
		}else if (accessDto.getPassword().equals(accessDto.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Passwords do not match");
			
		}

	}

}
