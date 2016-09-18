package com.github.magicmouse.Models;

import java.util.Comparator;

/**
 * Created by Peter on 2016-09-18.
 */
public class Word implements Comparable<Word>{

    String word;
    int count;

    public Word() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }

    public void stepCount() {
        count++;
    }

    @Override
    public int compareTo(Word o) {
        return  o.getCount() - this.getCount() ;
    }
}
