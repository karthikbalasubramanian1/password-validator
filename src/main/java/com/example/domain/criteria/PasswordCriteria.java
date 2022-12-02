package com.example.domain.criteria;

import com.example.domain.CriteriaResult;
import com.example.domain.Password;

/**
 * A generic abstraction for implementing various password validation criteria
 */
public interface PasswordCriteria {

    CriteriaResult validate(Password password);
}
