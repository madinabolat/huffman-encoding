package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class HuffmanTree {
    CharFreqNode root;

    public HuffmanTree(String s){
        buildTree(s);
    }

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
                return "0"+result;
            }
        }

        if (node.right != null){
            String result = encodeChar(c, node.right);
            if (result != null){
                return "1"+result;
            }
        }
        return null;
    }

    public HashMap<Character, String> buildEncodingDict(String s){
        HashMap<Character, String> encodingDict = new HashMap<>();
        for (char c : s.toCharArray()){
            encodingDict.put(c, encodeChar(c, this.root));
        }
        return encodingDict;
    }

    public String encodeString(String s){
        String encodedString = new String();
        for (char c : s.toCharArray()){
            encodedString += encodeChar(c, this.root);
        }
        return encodedString;
    }

    public String decodeString(String s){
        String decodedString = new String();
        CharFreqNode currentNode = root;
        for (char c : s.toCharArray()) {
            if (c=='0') {
                currentNode = currentNode.left;
            } else if (c=='1') {
                currentNode = currentNode.right;
            }
            if (currentNode.left == null && currentNode.right == null){
                decodedString += String.valueOf(currentNode.ch);
                currentNode = root;
            }
        }
        return decodedString;
    }

    public String decodeChar(char c, CharFreqNode node){
        if (node.ch == c && node.left == null && node.right == null){
            return String.valueOf(c);
        }
        return null;
    }


    public byte[] encodeToBytes(String binaryString){
        int numZerosToAppend = 8 - binaryString.length() % 8;
        if (numZerosToAppend != 0){
            for (int i = 0; i < numZerosToAppend; i++){
                binaryString+="0";
            }
        }
        int n = binaryString.length() / 8 + 1; //extra cell to store the number of appended zeros
        byte[] bytesArray = new byte[n];
        bytesArray[0] = (byte) numZerosToAppend;
        int k = 1;
        for (int i = 0; i < binaryString.length()-7; i+=8){
            byte b = (byte) Integer.parseInt(binaryString.substring(i,i+8), 2);
            //Byte.parseByte(binaryString.substring(i,i+8), 2) wont work when the substring is >128. byte will throw an error.
            //when we use Integer.parseInt - java forces it to turn into byte (uses two's complement)
            bytesArray[k] = b;
            k += 1;
        }
        return bytesArray;
    }

    public String convertBytesToBinaryString(byte[] bytesArray){
        int numZerosAppended = bytesArray[0];
        String s = new String();
        for (int i = 1; i<bytesArray.length; i++){
            String s1 =Integer.toBinaryString(bytesArray[i] & 0xFF);
            while (s1.length()<8){
                s1 = "0"+s1;
            }
            s += s1;
        }
        //remove padded zeros
        s = s.substring(0,s.length()-numZerosAppended);
        return s;
    }

    public String decodeFromBytes(byte[] bytesArray){
        String binaryString = convertBytesToBinaryString(bytesArray);
        return decodeString(binaryString);
    }


}
