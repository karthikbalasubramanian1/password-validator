package com.example.domain.criteria;

import com.example.domain.CriteriaResult;
import com.example.domain.Password;

import java.util.Optional;

import static com.example.domain.CriteriaResult.createFailureResult;
import static com.example.domain.CriteriaResult.createSuccessResult;

/**
 * Validation rules specific to the length of the password
 */
public class LengthCriteria implements PasswordCriteria {
    private static final int PASSWORD_MIN_LENGTH = 8;

    @Override
    public CriteriaResult validate(Password password) {
        return Optional.ofNullable(password)
                .filter(p -> p.getText().length() > PASSWORD_MIN_LENGTH)
                .map(p -> createSuccessResult())
                .orElseGet(() -> createFailureResult("Password length should be at least %d".formatted(PASSWORD_MIN_LENGTH)));
    }
}
