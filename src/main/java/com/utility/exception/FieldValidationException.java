package com.utility.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Harshal Patil
 */
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldValidationException extends RuntimeException {

    private String errorMessage;
    private List<Error> listError;
}
