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
        Files.writeString(path, "test");

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



//    Empty file
//    Larger content
//    Compress non-existent file (doesn't crash)
//    Decompress non-existent file (doesn't crash)


}