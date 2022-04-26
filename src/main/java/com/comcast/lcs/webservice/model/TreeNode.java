package com.comcast.lcs.webservice.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@Getter
public class TreeNode {
    String value;
    HashSet<Integer> indexSet;
    HashMap<Character, TreeNode> children;
    int level;

    public TreeNode(String value, int level){
        this.value = value;
        children = new HashMap<>();
        indexSet = new HashSet();
        this.level = level;
    }

    public TreeNode addChild(char c, int index, String value) {
        TreeNode child =  children.get(c);
        if(child == null){
            child = new TreeNode(value, this.level + 1);
            children.put(c, child);
        }
        child.indexSet.add(index);
        return child;
    }

    public void deepTraverse(Consumer<TreeNode> fn) {
        for(TreeNode child : children.values()){
            child.deepTraverse(fn);
        }
        fn.accept(this);
    }
}
