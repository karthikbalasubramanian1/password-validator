package com.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UpperCaseCriteriaTest {

    @Test
    @DisplayName("Valid upper case password")
    void testValidLowerCase() {
        Password password = Password.createPassword("ABcd");
        Assertions.assertTrue(new UpperCaseCriteria().validate(password).isValid());
    }

    @Test
    @DisplayName("Validate violation of upper case")
    void testInvalidLowerCase() {
        Password password = Password.createPassword("password");
        CriteriaResult result = new UpperCaseCriteria().validate(password);
        Assertions.assertFalse(result.isValid());
        Assertions.assertEquals("Password should have at least one uppercase", result.getResult());
    }
}