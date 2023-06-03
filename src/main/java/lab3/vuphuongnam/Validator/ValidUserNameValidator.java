package lab3.vuphuongnam.Validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lab3.vuphuongnam.Validator.annotation.ValidUserName;
import lab3.vuphuongnam.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUserNameValidator implements ConstraintValidator<ValidUserName, String> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        if(userRepository == null)
            return true;
        return userRepository.findByUsername(username) == null;
    }
}
