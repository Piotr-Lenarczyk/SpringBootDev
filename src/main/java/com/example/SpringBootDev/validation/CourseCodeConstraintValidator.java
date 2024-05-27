package com.example.SpringBootDev.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String prefix;

    @Override
    public void initialize(CourseCode courseCode) {
        this.prefix = courseCode.value();
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid;

        if (string != null) {
            valid = string.startsWith(this.prefix);
        } else {
            valid = true;
        }

        return valid;
    }
}
