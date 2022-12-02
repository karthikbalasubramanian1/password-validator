package com.example.domain;

/**
 * A generic abstraction for implementing various password validation criteria
 */
public interface PasswordCriteria {

    ValidationResult validate(Password password);
}
