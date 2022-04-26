package com.comcast.lcs.webservice.model;

import com.sun.source.tree.Tree;
import lombok.Getter;

@Getter
public class SuffixTree {
    TreeNode root;

    public SuffixTree(){
        root = new TreeNode(null, 0);
    }

    public void buildTree(String[] input){
        for(int i = 0; i < input.length; i++){
            String v = input[i];
            for(int j = 0; j < v.length(); j++){
                addStringToTree(v.substring(j), i);
            }
        }
    }

    private void addStringToTree(String input, int index){
         char[] arr = input.toCharArray();
         TreeNode cur = root;
         for(int i = 0; i < arr.length; i++){
             char c = arr[i];
             cur = cur.addChild(c, index, input.substring(0, i + 1));
         }
    }

    public void deepTraverse(java.util.function.Consumer<TreeNode> fn){
        root.deepTraverse(fn);
    }
}
