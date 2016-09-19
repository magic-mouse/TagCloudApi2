package com.github.magicmouse.helpers;

import com.github.magicmouse.Models.Word;

import java.util.ArrayList;
import java.util.Arrays;
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
        // Sorting
        Collections.sort(wordList);
        // Take top 100 words or if there is less, take what we got
        List<Word> words = new ArrayList<>(wordList.subList(0, (wordList.size() > 100) ? 100 : wordList.size()));
        return words;
    }

    public void countWord(String word) {

        if (quickFilter(word)) return;

        Word word1 = wordList.stream()
                .filter(filteredWord ->
                {
                   if(word.equals(filteredWord.getText())){
                       filteredWord.stepCount();
                       return true;
                   }
                     return false;
                }).findAny().orElse(null);

        if(word1 == null) {
            Word word2 = new Word();
            word2.setText(word);
            word2.setWeight(1);
            wordList.add(word2);
        }


    }

    /**
     *
     * Filters some of the common "non-essentials" from tweets like usernames, other hashtags and retweets.
     *
     * @param word
     * @return
     */
    private boolean quickFilter(String word) {
        // This could be replaced by an array with contains, but i like the "step by step"
        // String[] strings = new String[]{"RT", "@", "#"};
        // System.out.println(Arrays.asList(strings).contains(word));

        if(word.isEmpty()){
            return true;
        }
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
