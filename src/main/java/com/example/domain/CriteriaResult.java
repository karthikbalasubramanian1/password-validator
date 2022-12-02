package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

/**
 * Represents the response of password validation criteria
 */
@Getter
@AllArgsConstructor(access = PRIVATE)
public class CriteriaResult {
    /**
     *  Status of the validation criteria
     *  true for successful validation, false for any violation in criteria
     */
    private final boolean isValid;
    /**
     *  Optional message for the validation failures
     */
    private final String result;

    /**
     *  Creates a Validation result representing a successful validation of criteria
     */
    public static CriteriaResult createSuccessResult() {
        return new CriteriaResult(true, "");
    }

    /**
     *  Creates a Validation result representing a failure of validation of criteria
     */
    public static CriteriaResult createFailureResult(final String error) {
        return new CriteriaResult(false, Optional.ofNullable(error).orElse(""));
    }
}
