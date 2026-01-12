package org.example;

import java.util.HashSet;
import java.util.PriorityQueue;

public class HuffmanTree {
    CharFreqNode root;

    public void buildTree(String s){
        StringCharOperations stringCharOperations = new StringCharOperations();
        PriorityQueue<CharFreqNode> charFreqsQueued = stringCharOperations.charFreqsQueued(s);

        while (charFreqsQueued.size()>1){
            CharFreqNode childNode1 = charFreqsQueued.poll();
            CharFreqNode childNode2 = charFreqsQueued.poll();
            CharFreqNode parentNode = new CharFreqNode('\0', childNode1.freq+childNode2.freq); //null char
            parentNode.right = childNode1;
            parentNode.left = childNode2;
            charFreqsQueued.add(parentNode);
        }
        root = charFreqsQueued.peek();
    }

    public void preOrderTraverse(CharFreqNode node){
        if (node == null){
            return;
        }
        System.out.println(node);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public String encode(char c, CharFreqNode node){
        if (node.left == null && node.right == null){
            return "";
        }

        //fix here: 
        if (node.left.ch == c){
            return encode(c, node)+'0';
        } else {
            return encode(c, node)+'1';
        }
    }

    public void encodeChars(String s){
        StringCharOperations stringCharOperations = new StringCharOperations();
        HashSet<Character> uniqueChars = stringCharOperations.uniqueChars(s);
        for (char c : uniqueChars){

        }

    }
}
