package com.codeup.springblog;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import com.codeup.springblog.models.User;
import com.codeup.springblog.models.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){this.postDao = postDao;
        this.userDao = userDao;
    }

//    public PostController(PostRepository postDao){
//        this.postDao = postDao;
//    }
//    public PostController(UserRepository userDao){
//        this.userDao = userDao;
//    }

    @GetMapping("/posts")
        public String index(Model model){
        model.addAttribute("users",userDao.findAll());
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
    public String postsId(@PathVariable long id, Model model) {
        Post pulledPost = postDao.getOne(id);
//        Post post = new Post("hello", "hello world");
        model.addAttribute("user",pulledPost.getParentUser());
        model.addAttribute("post",pulledPost);
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
        Post newPost = new Post();
//        newPost.setParentUser(userDao.getOne(id));
        return "This is the page for creating a post";
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model){
        model.addAttribute("post",postDao.getOne(id));
        return "/posts/edit";
    }

    @PostMapping(value = "/posts/{id}/edit")
    public String update(@PathVariable Long id,
                         @RequestParam(name="title") String title,
                         @RequestParam(name="body") String body){
        Post post = postDao.getOne(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts/{id}";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }


}
