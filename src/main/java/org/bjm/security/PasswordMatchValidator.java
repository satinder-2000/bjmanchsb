package org.bjm.security;

import org.bjm.dtos.AccessDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



public class PasswordMatchValidator
        implements ConstraintValidator<PasswordMatch, AccessDto> {

    @Override
    public boolean isValid(
    		AccessDto accessDto,
            ConstraintValidatorContext context) {

        if (accessDto == null) {
            return true;
        }

        String password = accessDto.getPassword();
        String confirmPassword = accessDto.getConfirmPassword();

        // Let @NotBlank handle missing values.
        if (password == null || confirmPassword == null) {
            return true;
        }

        if (password.equals(confirmPassword)) {
            return true;
        }

        // Associate the error with the confirmPassword field.
        context.disableDefaultConstraintViolation();

        context.buildConstraintViolationWithTemplate(
                    context.getDefaultConstraintMessageTemplate())
                .addPropertyNode("confirmPassword")
                .addConstraintViolation();

        return false;
    }
}
