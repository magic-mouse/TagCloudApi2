package com.github.magicmouse.Controller;

import com.github.magicmouse.Models.Word;
import com.github.magicmouse.helpers.WordCounter;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import  com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RssController {



    @RequestMapping("/rss")
    public List<Word> greeting(@RequestParam(value="q") String query) {

        List<String> rssLineStrings = new ArrayList<String>();
        List<String> rssWordStrings = new ArrayList<String>();
        WordCounter wordCounter;
        URL url;
        try {
            url = new URL(query);
        }catch(MalformedURLException e){
            throw new BadInputUrlException();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        XmlReader xmlReader;
        try{
            xmlReader = new XmlReader(url);
            SyndFeed feed = new SyndFeedInput().build(xmlReader);

            List<SyndEntry> entry = feed.getEntries();
            entry.stream().forEach(x -> rssLineStrings.add(x.getDescription().getValue()));

            rssLineStrings.stream().forEach(tweStr -> rssWordStrings.addAll(Arrays.asList(tweStr.split(" "))));


            wordCounter = new WordCounter();
            rssWordStrings.stream().forEach(str -> wordCounter.countWord(str));


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (FeedException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return wordCounter.getWordList();
    }


    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Bad request, input invalid")  // 404
    public class BadInputUrlException extends RuntimeException {

    }
}