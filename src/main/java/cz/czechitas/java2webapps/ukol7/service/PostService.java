package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Page<Post> listOfPublishedPosts(Pageable pageable) {
        return repository.findByPublishedBeforeOrderByPublishedDesc(LocalDate.now().plusDays(1), pageable);
    }

    public Post singlePost(String slug) {
        return repository.findBySlug(slug)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Page<Post> listOfPublishedAndFuturePosts(Pageable pageable) {
        return repository.findByPublishedNotNullOrderByPublishedAsc(pageable);
    }

    public void deletePostById(long id) {
        repository.deleteById(id);
    }

    public void saveNewPost(Post post) {
        post.setPublished(LocalDate.now());
        post.setSlug(createSlugFromTitle(post.getTitle()));
        post.setBody(replaceNewLineCharactersWithHtmlNewLineCharacter(post.getBody()));
        repository.save(post);
    }

    public void saveEditedPost(Post post, String slug) {
        Post postToSave = singlePost(slug);
        postToSave.setAuthor(post.getAuthor());
        postToSave.setTitle(post.getTitle());
        postToSave.setPerex(post.getPerex());
        postToSave.setBody(replaceNewLineCharactersWithHtmlNewLineCharacter(post.getBody()));
        repository.save(postToSave);
    }

    private String createSlugFromTitle(String title) {
        return title.trim().replaceAll(" ", "-").toLowerCase();
    }

    private String replaceNewLineCharactersWithHtmlNewLineCharacter(String body) {
        return body.replaceAll("\n", " <br> ");
    }
}