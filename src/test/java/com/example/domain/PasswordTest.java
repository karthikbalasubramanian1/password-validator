package com.example.domain;

import com.example.domain.exception.InvalidPasswordException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PasswordTest {

    @Test
    @DisplayName("Password is created with a text value")
    void testPasswordCreation() {
        final String text = "random text";
        final Password randomPassword = Password.createPassword(text);
        Assertions.assertEquals(text, randomPassword.getText());
    }

    @Test
    @DisplayName("Null and blank passwords cannot be created")
    void testForBlankText() {
        Assertions.assertThrows(InvalidPasswordException.class, () -> Password.createPassword(null));
        Assertions.assertThrows(InvalidPasswordException.class, () -> Password.createPassword("   "));
    }

}