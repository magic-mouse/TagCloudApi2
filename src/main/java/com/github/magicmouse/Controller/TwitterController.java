package com.github.magicmouse.Controller;


import com.github.magicmouse.Models.TwitterModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwitterController {

    @RequestMapping("/api/twitter")
    public TwitterModel greeting(@RequestParam(value="q") String query) {
        return new TwitterModel();
    }
}