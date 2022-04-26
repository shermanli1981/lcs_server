package com.comcast.lcs.webservice.service;

import com.comcast.lcs.webservice.model.InputBody;
import com.comcast.lcs.webservice.model.InputString;
import com.comcast.lcs.webservice.model.OutputString;
import com.comcast.lcs.webservice.model.ResultBody;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class LcsServiceTest {
    @InjectMocks
    LcsService lcsServiceService;

    @Test
    void findLongestCommonSubstringsReturnOnlyOneResult(){
        InputBody inputBody = new InputBody();
        List<InputString> inputStrings = new ArrayList<>();
        inputStrings.add(InputString.builder()
                .value("comcast")
                .build());
        inputStrings.add(InputString.builder()
                .value("comcastic")
                .build());
        inputStrings.add(InputString.builder()
                .value("broadcaster")
                .build());
        inputBody.setSetOfStrings(inputStrings);
        ResultBody resultBody = lcsServiceService.findLongestCommonSubstring(inputBody);
        Assert.assertEquals(1, resultBody.getLcs().size());
        Assert.assertEquals("cast", resultBody.getLcs().get(0).getValue());
    }

    @Test
    void findLongestCommonSubstringsReturnTwoResult(){
        InputBody inputBody = new InputBody();
        List<InputString> inputStrings = new ArrayList<>();
        inputStrings.add(InputString.builder()
                .value("abcdfg")
                .build());
        inputStrings.add(InputString.builder()
                .value("abfg")
                .build());
        inputStrings.add(InputString.builder()
                .value("abfgcd")
                .build());
        inputBody.setSetOfStrings(inputStrings);
        ResultBody resultBody = lcsServiceService.findLongestCommonSubstring(inputBody);
        Assert.assertEquals(2, resultBody.getLcs().size());

        List<OutputString> outputStrings = resultBody.getLcs();

        Assert.assertTrue(outputStrings.get(0).getValue().equals("ab"));
        Assert.assertTrue(outputStrings.get(1).getValue().equals("fg"));
    }

    @Test
    void findLongestCommonSubstringsReturnThreeResult(){
        InputBody inputBody = new InputBody();
        List<InputString> inputStrings = new ArrayList<>();
        inputStrings.add(InputString.builder()
                .value("abcdefxyz")
                .build());
        inputStrings.add(InputString.builder()
                .value("defxyzabc")
                .build());
        inputStrings.add(InputString.builder()
                .value("xyzabcdef")
                .build());
        inputBody.setSetOfStrings(inputStrings);
        ResultBody resultBody = lcsServiceService.findLongestCommonSubstring(inputBody);
        Assert.assertEquals(3, resultBody.getLcs().size());

        List<OutputString> outputStrings = resultBody.getLcs();

        Assert.assertTrue(outputStrings.get(0).getValue().equals("abc"));
        Assert.assertTrue(outputStrings.get(1).getValue().equals("def"));
        Assert.assertTrue(outputStrings.get(2).getValue().equals("xyz"));
    }

}