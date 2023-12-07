package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PostService {

    PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Page<Post> list() {
        return repository.findByPublishedBeforeOrderByPublishedDesc(LocalDate.now(), PageRequest.of(0, 20));
    }

    public Post singlePost(String slug) {
        return repository.findBySlug(slug);
    }
}
