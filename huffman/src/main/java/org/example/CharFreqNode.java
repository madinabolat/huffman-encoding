package org.example;

public class CharFreqNode implements Comparable<CharFreqNode>{
    public char ch;
    public int freq;
    CharFreqNode left;
    CharFreqNode right;

    public CharFreqNode(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }

    @Override
    public int compareTo(CharFreqNode other) {
        return this.freq - other.freq;
    }

    @Override
    public String toString(){
        return "'" + this.ch + "'" + " - " + this.freq;
    }
}
