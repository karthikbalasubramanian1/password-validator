package com.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LengthCriteriaTest {

    @Test
    @DisplayName("Validate password creation with minimum length")
    void testPasswordWithValidLength() {
        Password longPassword = Password.createPassword("Password 1234");
        CriteriaResult result = new LengthCriteria().validate(longPassword);
        Assertions.assertTrue(result.isValid());
    }

    @Test
    @DisplayName("Validate error with short text")
    void testShortPassword() {
        Password shortPassword = Password.createPassword("Pass");
        CriteriaResult result = new LengthCriteria().validate(shortPassword);
        Assertions.assertFalse(result.isValid());
        Assertions.assertEquals("Password length should be at least 8", result.getResult());
    }

}