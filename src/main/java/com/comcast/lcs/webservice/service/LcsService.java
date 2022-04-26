package com.comcast.lcs.webservice.service;


import com.comcast.lcs.webservice.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LcsService implements IService{

    @Override
    public ResultBody findLongestCommonSubstring(InputBody inputBody) {
        List<InputString> inputStrings = inputBody.getSetOfStrings();
        String arr[] = new String[inputStrings.size()];
        for(int i = 0; i < inputStrings.size(); i++){
            arr[i] = inputStrings.get(i).getValue();
        }
        List<OutputString> result = findLongestSubString(arr);
        return ResultBody.builder().lcs(result).build();
    }

    public static List<OutputString> findLongestSubString(String arr[]){
        SuffixTree tree = new SuffixTree();
        tree.buildTree(arr);

        int[] len = new int[]{0};

        List<OutputString> res = new ArrayList<>();
        tree.deepTraverse(treeNode -> {
            if(treeNode.getIndexSet().size() == arr.length){
                if(treeNode.getLevel() > len[0]){
                    res.clear();
                    res.add(new OutputString(treeNode.getValue()));
                    len[0] = treeNode.getLevel();
                }
                else if(treeNode.getLevel() == len[0]) {
                    res.add(new OutputString(treeNode.getValue()));
                }
            }
        });

        Collections.sort(res, Comparator.comparing(OutputString::getValue));
        return res;
    }
}
