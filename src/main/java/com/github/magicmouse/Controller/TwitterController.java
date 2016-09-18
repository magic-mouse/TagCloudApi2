package com.github.magicmouse.Controller;


import com.github.magicmouse.Models.TwitterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TwitterController {


    @Autowired
    Twitter twitter;

    @RequestMapping("/twitter")
    public List<Tweet> twitter(@RequestParam(value="q") String query) {
        return twitter.searchOperations().search(query, 10).getTweets();
    }

    @RequestMapping("/twitter_cloud")
    public List<String> twitterCloud(@RequestParam(value="q") String query,
                                     @RequestParam(value="count", defaultValue = "10") int count) {
        // String generics on ArrayList is defined because java wants it to make it secure.
        List<String> tweetStrings = new ArrayList<String>();
        // Twitter spring API
        List<Tweet> tweets = twitter.searchOperations().search(query, count).getTweets();

        tweets.stream().forEach(tweet -> tweetStrings.add(tweet.getText()));

        return tweetStrings;
    }

}