package org.example;

import java.util.HashMap;

public class StringOperations {
    public HashMap<Character, Integer> countChars(String s){
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()){
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c)+1);
            }
            else {
                charCount.put(c, 1);
            }
        }
        return charCount;
    }
}
