package com.example.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * This represents the aggregated results of each criteria check.
 * Password status may differ from individual criteria validation depending on the use case of password strength
 */

@Getter
@AllArgsConstructor()
public class PasswordValidatorResult {
    PasswordStatus passwordStatus;
    List<CriteriaResult> criteriaResults;

}

/**
 * Status of the password after applying the criteria
 */
enum PasswordStatus {
    OK, NOT_OK
}
