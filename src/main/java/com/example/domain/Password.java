package com.example.domain;

import com.example.domain.exception.InvalidPasswordException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

/**
 * Represents a password object
 */
@Getter
@AllArgsConstructor(access = PRIVATE)
public class Password {
    private final String text;

    public static Password createPassword(final String text) {
        return Optional.ofNullable(text)
                .filter(StringUtils::isNotBlank)
                .map(Password::new)
                .orElseThrow(() -> new InvalidPasswordException("Password cannot be blank"));
    }
}
