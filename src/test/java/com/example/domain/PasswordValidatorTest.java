package com.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PasswordValidatorTest {

    @Test
    @DisplayName("Password with all criteria match")
    void passwordWithAllCriteria() {
        Assertions.assertTrue(new PasswordValidator().isPasswordWithAllCriteria("Password123"));
    }

    @Test
    @DisplayName("Password with a missing number criteria")
    void passwordWithMissingCriteria() {
        Assertions.assertFalse(new PasswordValidator().isPasswordWithAllCriteria("Password"));
    }

    @Test
    @DisplayName("Password with a minimum criteria - violation of number criteria")
    void passwordWithMinCriteria() {
        Assertions.assertTrue(new PasswordValidator().isPasswordWithMinimumCriteria("Password"));
    }

    @Test
    @DisplayName("Password with violation of minimum criteria - violation of number criteria, length criteria, and uppercase")
    void invalidPasswordMinCriteria() {
        Assertions.assertFalse(new PasswordValidator().isPasswordWithMinimumCriteria("pass"));
    }

    @Test
    @DisplayName("Password with mandatory lower case check")
    void validPasswordWithLowerCase() {
        Assertions.assertTrue(new PasswordValidator().isPasswordWithMandatoryLowerCase("Password1"));
    }

    @Test
    @DisplayName("Password violating mandatory lower case check")
    void invalidPasswordWithLowerCase() {
        Assertions.assertFalse(new PasswordValidator().isPasswordWithMandatoryLowerCase("PASSWORD1"));
    }
    @Test
    @DisplayName("Valid password result for lowercase check")
    void passwordStatusForValidLowerCase() {
        PasswordValidatorResult result = new PasswordValidator().passwordWithMandatoryLowerCase("Password1");
        Assertions.assertEquals(PasswordStatus.OK, result.getPasswordStatus());
    }

    @Test
    @DisplayName("Valid password result for lowercase violation")
    void passwordStatusForInvalidLowerCase() {
        PasswordValidatorResult result = new PasswordValidator().passwordWithMandatoryLowerCase("PASSWORD1");
        Assertions.assertEquals(PasswordStatus.NOT_OK, result.getPasswordStatus());
    }

    @Test
    @DisplayName("Valid password status for minimum criteria check -  violation of number criteria")
    void passwordStatusForMinimumCriteria() {
        PasswordValidatorResult result = new PasswordValidator().passwordWithMinimumCriteria("Password");
        Assertions.assertEquals(PasswordStatus.OK, result.getPasswordStatus());
    }

    @Test
    @DisplayName("Valid password status for minimum criteria check -  violation of number criteria, length criteria, and uppercase")
    void passwordStatusInvalidMinimumCriteria() {
        PasswordValidatorResult result = new PasswordValidator().passwordWithMinimumCriteria("pass");
        Assertions.assertEquals(PasswordStatus.NOT_OK, result.getPasswordStatus());
        Assertions.assertEquals(4,result.getCriteriaResults().size());
    }

    @Test
    @DisplayName("Faster validation of lower case and minimum criteria")
    void fasterValidation() {
        List<PasswordValidatorResult> results = new PasswordValidator().fasterPasswordCheck("pass");
        Assertions.assertEquals(2, results.size());
    }

}