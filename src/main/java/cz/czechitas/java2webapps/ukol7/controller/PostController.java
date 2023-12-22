package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.service.PostService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {

    PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView index(@PageableDefault(size = 20) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("postList", service.listOfPublishedPosts(pageable));
        return modelAndView;
    }

    @GetMapping("/post/{slug}")
    public ModelAndView detail(@PathVariable String slug) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("post", service.singlePost(slug));
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView adminPage(@PageableDefault(size = 20) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("adminPage");
        modelAndView.addObject("postList", service.listOfPublishedAndFuturePosts(pageable));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deletePost(long id) {
        service.deletePostById(id);
        return "redirect:/admin";
    }

    @GetMapping("/new")
    public ModelAndView getNewPostPage() {
        ModelAndView result = new ModelAndView("form");
        result.addObject("post", new Post());
        result.addObject("action", "/new");
        result.addObject("title", "Add new post");
        return  result;
    }

    @PostMapping("/new")
    public Object saveNewPost(@Valid @ModelAttribute Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("form").addObject("post", new Post())
                    .addObject("action", "/new")
                    .addObject("title", "Add new post");
        }
        service.saveNewPost(post);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{slug}")
    public ModelAndView getEditPostPage(@PathVariable String slug) {
        ModelAndView result = new ModelAndView("form");
        result.addObject("post", service.singlePost(slug));
        result.addObject("action", "/edit/" + slug);
        result.addObject("title", "Edit post");
        return result;
    }

    @PostMapping("/edit/{slug}")
    public Object saveEditedPost(@Valid @ModelAttribute Post post, BindingResult bindingResult,@PathVariable String slug) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("form").addObject("post", service.singlePost(slug))
                    .addObject("action", "/edit/" + slug)
                    .addObject("title", "Edit post");
        }
        service.saveEditedPost(post, slug);
        return "redirect:/admin";
    }
}
