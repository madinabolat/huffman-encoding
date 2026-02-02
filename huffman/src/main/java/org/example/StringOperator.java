package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class StringOperator {

    public HashSet<Character> uniqueChars(String s){
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()){
            uniqueChars.add(c);
        }
        return uniqueChars;
    }

    public HashMap<Character, Integer> charFreqsMap(String s){
        HashMap<Character, Integer> charFreqsMap = new HashMap<>();
        for (char c : s.toCharArray()){
            if (charFreqsMap.containsKey(c)) {
                charFreqsMap.put(c, charFreqsMap.get(c)+1);
            }
            else {
                charFreqsMap.put(c, 1);
            }
        }
        return charFreqsMap;
    }

    public PriorityQueue<CharFreqNode> charFreqsQueued(HashMap<Character, Integer> charFreqsMap){
        PriorityQueue<CharFreqNode> charFreqsQueued = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : charFreqsMap.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            CharFreqNode charFreqEntry = new CharFreqNode(key, value);
            charFreqsQueued.add(charFreqEntry);
        }

        return charFreqsQueued;
    }
}
