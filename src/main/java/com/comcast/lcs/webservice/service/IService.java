package com.comcast.lcs.webservice.service;


import com.comcast.lcs.webservice.model.InputBody;
import com.comcast.lcs.webservice.model.OutputString;
import com.comcast.lcs.webservice.model.ResultBody;

import java.util.List;

public interface IService {
    ResultBody findLongestCommonSubstring(InputBody inputBody);
}
