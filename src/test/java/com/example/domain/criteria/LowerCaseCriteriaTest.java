package com.example.domain.criteria;

import com.example.domain.CriteriaResult;
import com.example.domain.Password;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LowerCaseCriteriaTest {

    @Test
    @DisplayName("Valid lower case password")
    void testValidLowerCase() {
        Password password = Password.createPassword("asd");
        Assertions.assertTrue(new LowerCaseCriteria().validate(password).isValid());
    }

    @Test
    @DisplayName("Validate violation of lower case")
    void testInvalidLowerCase() {
        Password password = Password.createPassword("ASD");
        CriteriaResult result = new LowerCaseCriteria().validate(password);
        Assertions.assertFalse(result.isValid());
        Assertions.assertEquals("Password should have at least one lowercase", result.getResult());
    }

}