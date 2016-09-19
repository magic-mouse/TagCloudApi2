package com.github.magicmouse.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping(value = {"/", "/index", "/index.html"})
    public String indexPage(){

        return "default";
    }

    @RequestMapping(value = "/twitter")
    public String tweetPage(){

        return "tweet";
    }

    @RequestMapping(value = "/rss")
    public String rssPage(){

        return "rss";
    }



}
