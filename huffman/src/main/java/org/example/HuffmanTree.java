package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class HuffmanTree {
    String s;
    CharFreqNode root;

    public HuffmanTree(String s){
        this.s = s;
        buildTree();
    }

    public void buildTree(){
        StringCharOperations stringCharOperations = new StringCharOperations();
        PriorityQueue<CharFreqNode> charFreqsQueued = stringCharOperations.charFreqsQueued(this.s);

        while (charFreqsQueued.size()>1){
            CharFreqNode childNode1 = charFreqsQueued.poll();
            CharFreqNode childNode2 = charFreqsQueued.poll();
            CharFreqNode parentNode = new CharFreqNode('\0', childNode1.freq+childNode2.freq); //null char
            parentNode.right = childNode1;
            parentNode.left = childNode2;
            charFreqsQueued.add(parentNode);
        }
        this.root = charFreqsQueued.peek();
    }

    public void preOrderTraverse(CharFreqNode node){
        if (node == null){
            return;
        }
        System.out.println(node);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public String encodeChar(char c, CharFreqNode node){
        if (node.ch == c && node.left == null && node.right == null){
            return "";
        }

        if (node.left != null){
            String result = encodeChar(c, node.left);
            if (result != null){
                return result+"0";
            }
        }

        if (node.right != null){
            String result = encodeChar(c, node.right);
            if (result != null){
                return result+"1";
            }
        }
        return null;
    }

    public HashMap<Character, String> buildEncodingDict(){
        HashMap<Character, String> encodingDict = new HashMap<>();
        for (char c : this.s.toCharArray()){
            encodingDict.put(c, encodeChar(c, this.root));
        }
        return encodingDict;
    }

    public String encodeString(){
        String encodedString = new String();
        for (char c : this.s.toCharArray()){
            encodedString += encodeChar(c, this.root);
        }
        return encodedString;
    }

}
