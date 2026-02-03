package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCompressor {
    FileOperator fileOperator = new FileOperator();
    StringOperator stringOperator = new StringOperator();
    HuffmanTree huffmanTree;

    public void compress(String inputPath, String outputPath){
        String originalText;
        try {
            originalText = fileOperator.readTextFromFile(inputPath);
        } catch (FileNotFoundException e){
            System.out.println("Error: file not found - " + inputPath);
            return;
        }
        huffmanTree = new HuffmanTree(originalText);
        byte[] encodedBytes = huffmanTree.buildHuffmanFileBytes(originalText);
        fileOperator.writeToByteFile(encodedBytes, outputPath);
    }

    public void decompress(String inputPath, String outputPath){
        byte[] byteArray;
        try {
            byteArray = fileOperator.readByteFile(inputPath);
        } catch (IOException e){
            System.out.println("Error: file not found - " + inputPath);
            return;
        }

        int numUniqueChars = ByteBuffer.wrap(byteArray,0,4).getInt();
        HashMap<Character, Integer> charFreqsMap = new HashMap<>();
        for (int i = 0; i < 5*numUniqueChars; i+=5){
            char c = (char) ByteBuffer.wrap(byteArray,4+i,1).get();
            int freq = ByteBuffer.wrap(byteArray,5+i,4).getInt();
            charFreqsMap.put(c,freq);
        }

        PriorityQueue<CharFreqNode> charFreqsQueued = stringOperator.charFreqsQueued(charFreqsMap);
        huffmanTree = new HuffmanTree(charFreqsQueued);

        int charFreqsArrayLength =  4 + numUniqueChars * 5;
        int encodingArrayLength = byteArray.length-charFreqsArrayLength;
        byte[] encodingBytes = new byte[encodingArrayLength];
        System.arraycopy(byteArray,charFreqsArrayLength,encodingBytes,0,encodingArrayLength);
        String decodedString = huffmanTree.decodeFromBytes(encodingBytes);
        fileOperator.writeTextToFile(decodedString, outputPath);
    }
}
