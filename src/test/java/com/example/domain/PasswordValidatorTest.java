package com.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    @Test
    @DisplayName("Password with all criteria match")
    void passwordWithAllCriteria() {
        Assertions.assertTrue(new PasswordValidator().passwordWithAllCriteria("Password123"));
    }

    @Test
    @DisplayName("Password with a missing number criteria")
    void passwordWithMissingCriteria() {
        Assertions.assertFalse(new PasswordValidator().passwordWithAllCriteria("Password"));
    }

    @Test
    @DisplayName("Password with a minimum criteria - violation of number criteria")
    void passwordWithMinCriteria() {
        Assertions.assertTrue(new PasswordValidator().passwordWithMinimumCriteria("Password"));
    }

    @Test
    @DisplayName("Password with violation of minimum criteria - violation of number criteria, length criteria, and uppercase")
    void invalidPasswordMinCriteria() {
        Assertions.assertFalse(new PasswordValidator().passwordWithMinimumCriteria("pass"));
    }

}