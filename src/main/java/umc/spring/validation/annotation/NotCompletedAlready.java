package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.NotCompletedAlreadyValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotCompletedAlreadyValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotCompletedAlready {
    String message() default "_BAD_REQUEST";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
