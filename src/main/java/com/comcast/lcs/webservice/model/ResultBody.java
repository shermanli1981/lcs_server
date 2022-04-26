package com.comcast.lcs.webservice.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultBody {
    private List<OutputString> lcs;
}
