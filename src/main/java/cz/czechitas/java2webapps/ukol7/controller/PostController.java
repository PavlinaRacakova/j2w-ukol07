package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {

    PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("postList", service.list());
        return modelAndView;
    }

    @GetMapping("/post/{slug}")
    public ModelAndView detail(@PathVariable String slug) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("post", service.singlePost(slug));
        return modelAndView;
    }
}
