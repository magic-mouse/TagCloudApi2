package com.github.magicmouse.Models;

/**
 * Created by Peter on 2016-09-18.
 */
public class Word implements Comparable<Word>{

    String text;
    int weight;

    public Word() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int count) {
        this.weight = count;
    }

    @Override
    public String toString() {
        return "Word{" +
                "text='" + text + '\'' +
                ", count=" + weight +
                '}';
    }

    public void stepCount() {
        weight++;
    }

    @Override
    public int compareTo(Word o) {
        return  o.getWeight() - this.getWeight() ;
    }
}
