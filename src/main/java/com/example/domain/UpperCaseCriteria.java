package com.example.domain;

import java.util.Optional;

import static com.example.domain.CriteriaResult.createFailureResult;
import static com.example.domain.CriteriaResult.createSuccessResult;

/**
 * Validation rules for uppercase criteria check
 */
public class UpperCaseCriteria implements PasswordCriteria {
    @Override
    public CriteriaResult validate(Password password) {
        return Optional.ofNullable(password)
                .filter(p -> p.getText().chars().anyMatch(Character::isUpperCase))
                .map(p -> createSuccessResult())
                .orElseGet(() -> createFailureResult("Password should have at least one uppercase"));
    }
}
