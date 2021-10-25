package com.nepalaya.studentmgmt.validators;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.stream.Collectors;

public class ModelConstraintValidator {

    public static List<String> performValidation(Object object) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator
                .validate(object)
                .stream()
                .map(v -> "Invalid tag " + v.getPropertyPath() + ": " + v.getMessage())
                .collect(Collectors.toList());
    }
}
