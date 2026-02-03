package org.example;

import java.nio.ByteBuffer;

public class Main {
    public static void main(String[] args) {
        HuffmanCompressor huffmanCompressor = new HuffmanCompressor();

        if (args[0].equals("compress")){
            huffmanCompressor.compress(args[1], args[1].replace(".txt", "")+"_encoded.hf");
        } else if (args[0].equals("decompress")){
            huffmanCompressor.decompress(args[1], args[1].replace(".hf", "")+"_decoded.txt");
        } else {
            System.out.println("Enter valid function: compress or decompress");
        }
    }
}