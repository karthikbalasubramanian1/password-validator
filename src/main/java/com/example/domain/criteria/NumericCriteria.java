package com.example.domain.criteria;

import com.example.domain.CriteriaResult;
import com.example.domain.Password;

import java.util.Optional;

import static com.example.domain.CriteriaResult.createFailureResult;
import static com.example.domain.CriteriaResult.createSuccessResult;

/**
 * Validation rules for numeric criteria check
 */
public class NumericCriteria implements PasswordCriteria {
    @Override
    public CriteriaResult validate(Password password) {
        return Optional.ofNullable(password)
                .filter(p -> p.getText().chars().anyMatch(Character::isDigit))
                .map(p -> createSuccessResult())
                .orElseGet(() -> createFailureResult("Password should have at least one number"));
    }
}
