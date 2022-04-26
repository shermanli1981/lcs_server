package com.comcast.lcs.webservice.model;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class SuffixTreeTest {

    @Test
    public void buildTreeTest(){
        SuffixTree tree = new SuffixTree();
        tree.buildTree(new String[]{"ABAB",  "BABA", "ABBA"});
        TreeNode root = tree.getRoot();
        assertEquals(2, root.children.size());
        HashMap<Character, TreeNode> map = root.getChildren();
        assertTrue(map.containsKey('A'));
        assertTrue(map.containsKey('B'));
    }
}