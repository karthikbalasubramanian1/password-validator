package com.example.domain;

import java.util.List;

/**
 * Validator that defines the rules to be applied for a password creation
 */
public class PasswordValidator {
    private static final List<PasswordCriteria> allCriteria =
            List.of(new LengthCriteria(), new LowerCaseCriteria(), new UpperCaseCriteria(), new NumericCriteria());

    /**
     * Validate password against all the given criteria
     * @return true if the password passes all the password criteria rules, else false
     */
    public boolean passwordWithAllCriteria(String text) {
        Password password = Password.createPassword(text);
        return allCriteria.stream().allMatch(criteria -> criteria.validate(password).isValid());
    }


    /**
     * Validate password against at least 3 criteria
     * @return true if the password passes at least 3 of the password criteria rules, else false
     */
    public boolean passwordWithMinimumCriteria(String text) {
        final int minimumCriteria = 2; // null check is implicitly applied to the password
        Password password = Password.createPassword(text);
        return allCriteria.stream()
                .filter(criteria -> criteria.validate(password).isValid())
                .limit(minimumCriteria)
                .count() >= 2;
    }

}
