package com.github.magicmouse.Controller;

import com.github.magicmouse.Models.RssModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RssController {



    @RequestMapping("/api/rss")
    public RssModel greeting(@RequestParam(value="q") String query) {
        return new RssModel(query);
    }
}