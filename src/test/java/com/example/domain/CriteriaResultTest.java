package com.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CriteriaResultTest {

    @Test
    @DisplayName("Test the result on successful validation")
    void testSuccessResult() {
        Assertions.assertTrue(CriteriaResult.createSuccessResult().isValid());
    }

    @Test
    @DisplayName("Test the result on validation failure")
    void testFailureResult() {
        final String message = "An error message";
        CriteriaResult failure = CriteriaResult.createFailureResult(message);
        Assertions.assertFalse(failure.isValid());
        Assertions.assertEquals(failure.getResult(), message);
    }

}