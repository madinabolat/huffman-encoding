package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class HuffmanCompressorTest {

    @Test
    public void testCompressDecompressPreservesContent() throws IOException {
        Path path = Paths.get("test_input.txt");
        Files.writeString(path, "Hello world!");

        HuffmanCompressor hc = new HuffmanCompressor();
        String inputPath = path.toString();
        String encodedInputPath = inputPath.replace(".txt", "")+"_encoded.hf";
        String decodedOutputPath = encodedInputPath.replace(".hf", "")+"_decoded.txt";
        hc.compress(inputPath,encodedInputPath);
        hc.decompress(encodedInputPath, decodedOutputPath);
        long mismatch = Files.mismatch(path,Paths.get(decodedOutputPath));
        boolean match;
        match = mismatch == -1L;

        Files.delete(path);
        Files.delete(Paths.get(encodedInputPath));
        Files.delete(Paths.get(decodedOutputPath));

        assertTrue(match);
    }

    @Test
    public void testWhenInputFileDoesNotExist() throws IOException {
        Path path = Paths.get("non_existent_file.txt");

        HuffmanCompressor hc = new HuffmanCompressor();
        String inputPath = path.toString();
        String encodedInputPath = inputPath.replace(".txt", "")+"_encoded.hf";
        //Error: file not found - ../non_existent_file.txt
        assertDoesNotThrow(() -> hc.compress(inputPath,encodedInputPath));
    }

    @Test
    public void testWhenInputFileEmpty() throws IOException {
        Path path = Paths.get("test_input.txt");
        Files.writeString(path, "");

        HuffmanCompressor hc = new HuffmanCompressor();
        String inputPath = path.toString();
        String encodedInputPath = inputPath.replace(".txt", "")+"_encoded.hf";
        String decodedOutputPath = encodedInputPath.replace(".hf", "")+"_decoded.txt";
        hc.compress(inputPath,encodedInputPath);
        hc.decompress(encodedInputPath, decodedOutputPath);
        long mismatch = Files.mismatch(path,Paths.get(decodedOutputPath));
        boolean match;
        match = mismatch == -1L;

        Files.delete(path);
        Files.delete(Paths.get(encodedInputPath));
        Files.delete(Paths.get(decodedOutputPath));

        assertTrue(match);
    }

    @Test
    public void testWhenDecompressFileDoesNotExist() throws IOException {
        Path path = Paths.get("non_existent_file.hf");

        HuffmanCompressor hc = new HuffmanCompressor();
        String inputPath = path.toString();
        String decodedOutputPath = inputPath.replace(".hf", "")+"_decoded.txt";

        assertDoesNotThrow(() -> hc.decompress(inputPath, decodedOutputPath));
    }

}