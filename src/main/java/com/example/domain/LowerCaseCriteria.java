package com.example.domain;

import java.util.Optional;

import static com.example.domain.ValidationResult.createFailureResult;
import static com.example.domain.ValidationResult.createSuccessResult;

/**
 * Validation rules for lowercase criteria check
 */
public class LowerCaseCriteria implements PasswordCriteria {
    @Override
    public ValidationResult validate(Password password) {
        return Optional.ofNullable(password)
                .filter(p -> p.getText().chars().anyMatch(Character::isLowerCase))
                .map(p -> createSuccessResult())
                .orElseGet(() -> createFailureResult("Password should have at least one lowercase"));
    }
}
