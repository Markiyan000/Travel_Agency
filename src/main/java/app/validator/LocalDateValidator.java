package app.validator;

import app.annotation.LocalDateConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class LocalDateValidator implements ConstraintValidator<LocalDateConstraint, LocalDate> {

    @Override
    public void initialize(LocalDateConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if(localDate == null) return false;
        LocalDate now = LocalDate.now();

        return localDate.isAfter(now) || localDate.isEqual(now);
    }
}
