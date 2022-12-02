package com.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationResultTest {

    @Test
    @DisplayName("Test the result on successful validation")
    void testSuccessResult() {
        Assertions.assertTrue(ValidationResult.createSuccessResult().isValid());
    }

    @Test
    @DisplayName("Test the result on validation failure")
    void testFailureResult() {
        final String message = "An error message";
        ValidationResult failure = ValidationResult.createFailureResult(message);
        Assertions.assertFalse(failure.isValid());
        Assertions.assertEquals(failure.getResult(), message);
    }

}