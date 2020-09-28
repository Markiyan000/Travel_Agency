package app.annotation;

import app.validator.LocalDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LocalDateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LocalDateConstraint {
    String message() default "Invalid date!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
