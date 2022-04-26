package com.comcast.lcs.webservice.validator;

import com.comcast.lcs.webservice.exceptions.BadRequestException;
import com.comcast.lcs.webservice.exceptions.InputBodyNotFoundException;
import com.comcast.lcs.webservice.exceptions.StringsNotFoundOrEmptyException;
import com.comcast.lcs.webservice.model.InputBody;
import com.comcast.lcs.webservice.model.InputString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class LcsValidatorTest {
    LcsValidator lcsValidator;
    InputBody inputBody;

    @BeforeEach
    void  setUp(){
        lcsValidator = new LcsValidator();
    }

    @Test
    void validateNullInputBody(){
        assertThrows(InputBodyNotFoundException.class, () -> lcsValidator.validateInputBody(inputBody));
    }

    @Test
    void validateEmptyInputStrings(){
        inputBody = new InputBody();
        List<InputString> inputStrings = new ArrayList<>();
        inputBody.setSetOfStrings(inputStrings);
        assertThrows(StringsNotFoundOrEmptyException.class, () -> lcsValidator.validateInputBody(inputBody));
    }

    @Test
    void validateDuplicateInputStrings(){
        inputBody = new InputBody();
        List<InputString> inputStrings = new ArrayList<>();
        inputStrings.add(InputString.builder()
                .value("abcd")
                .build());

        inputStrings.add(InputString.builder()
                .value("abcd")
                .build());
        inputBody.setSetOfStrings(inputStrings);
        assertThrows(BadRequestException.class, () -> lcsValidator.validateInputBody(inputBody));
    }
}