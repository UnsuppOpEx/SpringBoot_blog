package com.antonzemskov.blog.controllers;

import com.antonzemskov.blog.model.Post;
import com.antonzemskov.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String blogMain(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @RequestMapping(value = "blog/add", method = RequestMethod.GET)
    public String blogAdd(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-add";
    }

    @RequestMapping(value = "blog/add", method = RequestMethod.POST)
    public String blogPostAdd(@RequestParam(value = "title") String title,
                              @RequestParam(value = "anons") String anons,
                              @RequestParam(value = "full_text") String full_text,
                              Model model) {
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }

}
