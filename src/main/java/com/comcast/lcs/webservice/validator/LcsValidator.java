package com.comcast.lcs.webservice.validator;

import com.comcast.lcs.webservice.exceptions.BadRequestException;
import com.comcast.lcs.webservice.exceptions.InputBodyNotFoundException;
import com.comcast.lcs.webservice.exceptions.StringsNotFoundOrEmptyException;
import com.comcast.lcs.webservice.model.InputBody;
import com.comcast.lcs.webservice.model.InputString;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LcsValidator {
    public void validateInputBody(InputBody inputBody){
//        If there is no POST body in the request or if the POST body is not in the correct
//        format the server should respond with an appropriate HTTP status code,
//        and a response body explaining that the format of the request was not acceptable.
        if(inputBody == null){
            throw new InputBodyNotFoundException("Input body is null");
        }

        if(inputBody.getSetOfStrings() == null || inputBody.getSetOfStrings().isEmpty() || inputBody.getSetOfStrings().size() == 0){
            throw new StringsNotFoundOrEmptyException("Input strings is null or empty");
        }

//        if the setOfStrings supplied is not a set (i.e. all strings are not unique)
//        the server should respond with an appropriate HTTP status code, and a response
//        body explaining that "setOfStrings" must be a Set
        if(listContainsDuplicates(inputBody.getSetOfStrings())){
            throw new BadRequestException("Found duplicate string");
        }
    }
// if the setOfStrings supplied is not a set (i.e. all strings are not unique)
// the server should respond with an appropriate HTTP status code, and a response
// body explaining that "setOfStrings" must be a Set
    private boolean listContainsDuplicates(List<InputString> list){
        Set<String> set = new HashSet<>();
        for(InputString value : list){
            if(set.contains(value.getValue())){
                return  true;
            }
            set.add(value.getValue());
        }
        return false;
    }
}
