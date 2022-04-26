package com.comcast.lcs.webservice.api.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.comcast.lcs.webservice.model.InputBody;
import com.comcast.lcs.webservice.model.InputString;
import com.comcast.lcs.webservice.model.OutputString;
import com.comcast.lcs.webservice.model.ResultBody;
import com.comcast.lcs.webservice.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class LcsControllerTest {

    @MockBean
    IService service;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    InputBody inputBody;
    ResultBody resultBody;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
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

        inputBody = new InputBody();
        inputBody.setSetOfStrings(inputStrings);

        List<OutputString> outputStrings = new ArrayList<>();
        outputStrings.add(OutputString.builder()
                .value("cast")
                .build());
        resultBody = new ResultBody();
        resultBody.setLcs(outputStrings);
    }


    @Test
    public void findLongestCommonSubstrings() throws Exception{
        Mockito.when(service.findLongestCommonSubstring(inputBody)).thenReturn(resultBody);
        MockHttpServletRequestBuilder requestBuilder = request(HttpMethod.POST, "/lcs")
                .content(objectMapper.writeValueAsString(inputBody))
                .contentType("application/json");
        mockMvc.perform(requestBuilder)
                .andExpect(status().is2xxSuccessful());
    }
}
