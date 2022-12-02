package com.example.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Validator that defines the rules to be applied for a password creation
 */
public class PasswordValidator {
    private static final List<PasswordCriteria> allCriteria =
            List.of(new LengthCriteria(), new LowerCaseCriteria(), new UpperCaseCriteria(), new NumericCriteria());

    /**
     * Validate password against all the given criteria
     *
     * @return true if the password passes all the password criteria rules, else false
     */
    public boolean isPasswordWithAllCriteria(String text) {
        Password password = Password.createPassword(text);
        return allCriteria.stream().allMatch(criteria -> criteria.validate(password).isValid());
    }

    /**
     * Validate password against at least 3 criteria
     *
     * @return true if the password passes at least 3 of the password criteria rules, else false
     */
    public boolean isPasswordWithMinimumCriteria(String text) {
        final int minimumCriteria = 2; // null check rule is implicitly applied to the password and not an explicit rule defined
        Password password = Password.createPassword(text);
        List<CriteriaResult> criteriaResults = allCriteria.stream()
                .map(criteria -> criteria.validate(password))
                .toList();

        return criteriaResults.stream()
                .filter(CriteriaResult::isValid).count() >= minimumCriteria;
    }

    public boolean isPasswordWithMandatoryLowerCase(String text) {
        final Password password = Password.createPassword(text);
        return new LowerCaseCriteria().validate(password).isValid();
    }


    public PasswordValidatorResult passwordWithMandatoryLowerCase(String text) {
        final Password password = Password.createPassword(text);
        CriteriaResult lowerCaseCriteria = new LowerCaseCriteria().validate(password);
        return Optional.of(lowerCaseCriteria)
                .filter(CriteriaResult::isValid)
                .map(c -> new PasswordValidatorResult(PasswordStatus.OK, Collections.emptyList()))
                .orElseGet(() -> new PasswordValidatorResult(PasswordStatus.NOT_OK, List.of(lowerCaseCriteria)));
    }

    public PasswordValidatorResult passwordWithMinimumCriteria(String text) {
        final int minimumCriteria = 2;
        final Password password = Password.createPassword(text);
        List<CriteriaResult> criteriaResults = allCriteria.stream()
                .map(criteria -> criteria.validate(password))
                .toList();

        boolean isPasswordOk = criteriaResults.stream()
                .filter(CriteriaResult::isValid)
                .count() >= minimumCriteria;

        if (isPasswordOk) {
            return new PasswordValidatorResult(PasswordStatus.OK, criteriaResults);
        } else {
            return new PasswordValidatorResult(PasswordStatus.NOT_OK, criteriaResults);
        }
    }

    /**
     * Combines the criteria but runs faster
     */
    public List<PasswordValidatorResult> fasterPasswordCheck(String text) {
        return Stream.<Supplier<PasswordValidatorResult>>of(() -> passwordWithMinimumCriteria(text), () -> passwordWithMandatoryLowerCase(text))
                .map(CompletableFuture::supplyAsync)
                .map(CompletableFuture::join).toList();
    }
}
