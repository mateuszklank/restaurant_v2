package com.packt.webstore.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;

public class CategoryValidator implements ConstraintValidator<Category, String> {

    private List<String> allowedCategories;

    public CategoryValidator() {
        allowedCategories = new ArrayList<>();
        allowedCategories.add("Obiad");
        allowedCategories.add("Śniadanie");
        allowedCategories.add("Deser");
    }

    public void initialize(Category constraintAnnotation) {
        // intentionally left blank; this is the place to initialize the
        // constraint annotation for any sensible default values.
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {

        try {
            if (allowedCategories.contains(value))
                return true;

        } catch (NoProductsFoundUnderCategoryException e) {
            return false;
        }

        return false;
    }

}