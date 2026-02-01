package org.example;

import java.util.PriorityQueue;

public class HuffmanCompressor {
    FileOperator fileOperator = new FileOperator();
    HuffmanTree huffmanTree;

    public void compress(String inputPath, String outputPath){
        String originalText = fileOperator.readFromFile(inputPath);
        huffmanTree = new HuffmanTree(originalText);
        fileOperator.writeToByteFile(huffmanTree.encodeToBytes(huffmanTree.encodeString(originalText)), outputPath);
    }

    public void decompress(String inputPath, String outputPath){
        //read char freqs from file
        //rebuild charFreqs
        PriorityQueue<CharFreqNode> charFreqsQueued = new PriorityQueue<>(); //update -> read from file
        huffmanTree = new HuffmanTree(charFreqsQueued);
        fileOperator.writeToFile(huffmanTree.decodeFromBytes(fileOperator.readByteFile(inputPath)), outputPath);
    }
}
