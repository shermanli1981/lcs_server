package com.comcast.lcs.webservice.api.controller;


import com.comcast.lcs.webservice.model.InputBody;
import com.comcast.lcs.webservice.model.InputString;
import com.comcast.lcs.webservice.model.OutputString;
import com.comcast.lcs.webservice.model.ResultBody;
import com.comcast.lcs.webservice.service.IService;
import com.comcast.lcs.webservice.validator.LcsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class LcsController {
	@Autowired
	@Qualifier("lcsService")
	private IService lcsService;

	@Autowired
	private LcsValidator lcsValidator;

    @RequestMapping(method = RequestMethod.POST, path= "/lcs" )
	public ResponseEntity<ResultBody> findLongestCommonSubstring(@RequestBody (required = false) InputBody inputBody){
		lcsValidator.validateInputBody(inputBody);
		ResultBody result = lcsService.findLongestCommonSubstring(inputBody);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
