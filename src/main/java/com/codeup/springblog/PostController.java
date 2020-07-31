package com.codeup.springblog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "This is the post page!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsId(@PathVariable int id) {
        return "This is " + id + "the post page!";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreate() {
        return "This is the page for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreated() {
        return "This is the page for creating a post";
    }


}
