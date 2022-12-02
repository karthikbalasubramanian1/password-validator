package com.example.domain.criteria;

import com.example.domain.CriteriaResult;
import com.example.domain.Password;

import java.util.Optional;

import static com.example.domain.CriteriaResult.createFailureResult;
import static com.example.domain.CriteriaResult.createSuccessResult;

/**
 * Validation rules for lowercase criteria check
 */
public class LowerCaseCriteria implements PasswordCriteria {
    @Override
    public CriteriaResult validate(Password password) {
        return Optional.ofNullable(password)
                .filter(p -> p.getText().chars().anyMatch(Character::isLowerCase))
                .map(p -> createSuccessResult())
                .orElseGet(() -> createFailureResult("Password should have at least one lowercase"));
    }
}
