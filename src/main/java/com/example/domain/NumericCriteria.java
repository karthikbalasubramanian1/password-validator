package com.example.domain;

import java.util.Optional;

import static com.example.domain.ValidationResult.createFailureResult;
import static com.example.domain.ValidationResult.createSuccessResult;

/**
 * Validation rules for numeric criteria check
 */
public class NumericCriteria implements PasswordCriteria {
    @Override
    public ValidationResult validate(Password password) {
        return Optional.ofNullable(password)
                .filter(p -> p.getText().chars().anyMatch(Character::isDigit))
                .map(p -> createSuccessResult())
                .orElseGet(() -> createFailureResult("Password should have at least one number"));
    }
}
