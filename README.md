# HUFFMAN COMPRESSION UTILITY

A CLI tool using Huffman encoding to compress text files to reduce size. 


## Features
- **Compress:** converts text files to .hf files of reduced size. 
- **Decompress:** restores text files from .hf encoded files. 


## REQUIREMENTS 
- Java 22

## USAGE
Download ```huffman-1.0.jar``` from ```/target``` directory and run the following commands: 
### Compression
```bash
java -jar huffman-1.0.jar compress input.txt
```
Creates: ```input_encoded.hf```

### Decompression
```bash
java -jar huffman-1.0.jar decompress input_encoded.hf
```
Creates: ```input_encoded_decoded.txt```


