package com.github.magicmouse.helpers;

import com.github.magicmouse.Models.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by Peter on 2016-09-18.
 */
public class WordCounter {


    List<Word> wordList;


    public WordCounter() {
        wordList = new ArrayList<Word>();
    }

    public List<Word> getWordList() {
        //Collections.sort(wordList);
        return wordList;
    }

    public void countWord(String word) {

        if (quickFilter(word)) return;

        Word word1 = wordList.stream()
                .filter(filteredWord ->
                {
                   if(word.equals(filteredWord.getWord())){
                       filteredWord.stepCount();
                       return true;
                   }
                     return false;
                }).findAny().orElse(null);

        if(word1 == null) {
            Word word2 = new Word();
            word2.setWord(word);
            word2.setCount(1);
            wordList.add(word2);
        }


    }

    private boolean quickFilter(String word) {
        if(word.equals("RT")){
            return true;
        }
        if(word.contains("@")){
            return true;
        }
        if(word.contains("#")){
            return true;
        }
        if(word.toLowerCase().contains("http")){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "WordCounter{" +
                "wordList=" + wordList +
                '}';
    }
}
