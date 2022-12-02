package com.example.domain;

import java.util.Optional;

import static com.example.domain.ValidationResult.createFailureResult;
import static com.example.domain.ValidationResult.createSuccessResult;

/**
 * Validation rules specific to the length of the password
 */
public class LengthCriteria implements PasswordCriteria {
    private static final int PASSWORD_MIN_LENGTH = 8;

    @Override
    public ValidationResult validate(Password password) {
        return Optional.ofNullable(password)
                .filter(p -> p.getText().length() > PASSWORD_MIN_LENGTH)
                .map(p -> createSuccessResult())
                .orElseGet(() -> createFailureResult("Password length should be at least %d".formatted(PASSWORD_MIN_LENGTH)));
    }
}
