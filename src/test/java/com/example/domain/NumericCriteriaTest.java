package com.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumericCriteriaTest {

    @Test
    @DisplayName("Valid numeric password")
    void testNumericPassword() {
        Password password = Password.createPassword("password1");
        Assertions.assertTrue(new NumericCriteria().validate(password).isValid());
    }

    @Test
    @DisplayName("Validate violation of upper case")
    void testInvalidNumeric() {
        Password password = Password.createPassword("password");
        CriteriaResult result = new NumericCriteria().validate(password);
        Assertions.assertFalse(result.isValid());
        Assertions.assertEquals("Password should have at least one number", result.getResult());
    }

}