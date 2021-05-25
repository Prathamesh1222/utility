package com.utility.util;


import com.utility.exception.FieldValidationException;
import org.springframework.stereotype.Component;

import java.net.http.HttpHeaders;
import java.util.List;

/**
 * @author Harshal Patil
 */
@Component
public class CommonValidator {

    public boolean requestValidator(HttpHeaders httpHeaders, List<Error> errorList, List<String> nullFields, List<String> invalidFiledList, String requestFailedMsg, String hint) {

        if (!invalidFiledList.isEmpty()) {
            String invalidFiledString = String.join(",", invalidFiledList);
            errorList.add(new Error(""));
        }
        if (!errorList.isEmpty()) {
            throw new FieldValidationException(requestFailedMsg, errorList);
        } else {
            return true;
        }
    }

}
