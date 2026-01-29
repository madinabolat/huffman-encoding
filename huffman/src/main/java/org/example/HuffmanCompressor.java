package org.example;

public class HuffmanCompressor {
    FileOperator fileOperator = new FileOperator();
    HuffmanTree huffmanTree;

    public void compress(String inputPath, String outputPath){
        String originalText = fileOperator.readFromFile(inputPath);
        huffmanTree = new HuffmanTree(originalText);
        fileOperator.writeToByteFile(huffmanTree.encodeToBytes(huffmanTree.encodeString(originalText)), outputPath);
    }

    public void decompress(String inputPath, String outputPath){
        //but huffman tree is built based on string
        //we dont know that string yet
        //so i should have some kind of dict?
        fileOperator.writeToFile(huffmanTree.decodeFromBytes(fileOperator.readByteFile(inputPath)), outputPath);
    }
}
