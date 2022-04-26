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

//    public static List<OutputString> findLongestSubString(String arr[])
//    {
//        // Determine size of the array
//        int n = arr.length;
//
//        // Take first word from array as reference
//        String s = arr[0];
//        int len = s.length();
//        int maxLen = 0;
//        String res = "";
//        List<String> r = new ArrayList<>();
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j <= len; j++) {
//
//                // generating all possible substrings
//                // of our reference string arr[0] i.e s
//                String stem = s.substring(i, j);
//                int k = 1;
//                for (k = 1; k < n; k++)
//
//                    // Check if the generated stem is
//                    // common to all words
//                    if (!arr[k].contains(stem))
//                        break;
//
//                // If current substring is present in
//                // all strings and its length is greater
//                // than current result
//                if (k == n && res.length() <= stem.length()){
//                    res = stem;
//                    r.add(stem);
//                    maxLen = res.length();
//                }
//            }
//        }
//
//        List<OutputString> endResult = new ArrayList<>();
//        Collections.sort(r); //If there is more than one LCS return them all in alphabetic order.
//        for(int i = 0; i < r.size(); i++){
//            if(r.get(i).length() == maxLen){
//                endResult.add(new OutputString(r.get(i)));
//            }
//        }
//
//        return endResult;
//    }
}
