package lab3.vuphuongnam.Validator;

import lab3.vuphuongnam.entity.Category;
import lab3.vuphuongnam.Validator.annotation.ValidCategoryId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public  boolean isValid(Category category, ConstraintValidatorContext context) {
        return category != null && category.getId() != null;
    }

}