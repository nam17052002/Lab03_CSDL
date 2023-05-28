package lab3.vuphuongnam.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Valid;
import lab3.vuphuongnam.Validator.annotation.ValidUsername;
import lab3.vuphuongnam.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername,String> {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public boolean isValid(String username,ConstraintValidatorContext context){
        if(userRepository == null){
            return true;
        }
        return userRepository.findByUsername(username) == null;
    }
}
