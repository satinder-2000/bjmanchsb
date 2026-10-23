package org.bjm.utils;

import org.bjm.dtos.UserDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileOrPhoneValidator
        implements ConstraintValidator<RequireMobileOrPhone, UserDto> {

    @Override
    public boolean isValid(
            UserDto userDto,
            ConstraintValidatorContext context) {

        if (userDto == null) {
            return true;
        }

        String mobile = userDto.getMobile();
        String phone = userDto.getPhone();

        boolean mobileProvided =
                mobile != null && !mobile.isBlank();

        boolean phoneProvided =
                phone != null && !phone.isBlank();

        // At least one number must be provided.
        return mobileProvided || phoneProvided;
    }
}