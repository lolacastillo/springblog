package com.codeup.springblog;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
@Controller
public class PostController {
    @Autowired
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
        public String index(Model model){
        model.addAttribute("posts",postDao.findAll());
        return "posts/index";
    }

//    @GetMapping("/posts")
//    public String posts(Model model) {
//        ArrayList<Post> posts = new ArrayList<>();
//        Post post = new Post("hello1","hello1");
//        Post post2 = new Post("hello2","hello2");
//        Post post3 = new Post("hello3","hello3");
//        posts.add(post);
//        posts.add(post2);
//        posts.add(post3);
//        model.addAttribute("posts",posts);
//        return "/posts/index";
//    }

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

    @GetMapping("/posts/edit")
    public String getEditPost(Model model){
        System.out.println("getting");
        model.addAttribute("posts",postDao.findAll());
        return "/posts/edit";
    }

    @PostMapping(value = "/posts/edit/{id}")
    public String editPost(@PathVariable Long id, @RequestParam(name="title") String title, @RequestParam("body") String body, Model model){
        Post post = postDao.getOne(id);
        System.out.println("editing post");
        post.setTitle(title);
        post.setBody(body);
        System.out.println(id);
        postDao.save(post);
        return "redirect:/posts/edit";
    }

    @PostMapping(value= "/post/delete/{id}")
    public String deletePost(@PathVariable Long id, @RequestParam(name="title") String title, @RequestParam("body") String body){
        postDao.deleteById(id);
        return "redirect:/post";
    }


}
