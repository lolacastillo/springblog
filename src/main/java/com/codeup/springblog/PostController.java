package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        Post post = new Post("hello1","hello1");
        Post post2 = new Post("hello2","hello2");
        Post post3 = new Post("hello3","hello3");
        posts.add(post);
        posts.add(post2);
        posts.add(post3);
        model.addAttribute("posts",posts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsId(@PathVariable int id, Model model) {
        Post post = new Post("hello", "hello world");
        model.addAttribute("post",post);
        return "/posts/show";
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
