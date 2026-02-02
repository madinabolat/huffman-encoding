package org.example;

import java.nio.ByteBuffer;

public class Main {
    public static void main(String[] args) {
        HuffmanCompressor huffmanCompressor = new HuffmanCompressor();
        huffmanCompressor.compress("../input.txt", "../encoded.hf");
        huffmanCompressor.decompress("../encoded.hf", "../output.txt");

    }
}