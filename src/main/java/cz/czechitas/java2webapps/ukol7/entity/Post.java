package cz.czechitas.java2webapps.ukol7.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "SLUG", nullable = false, length = 100)
    private String slug;

    @Size(max = 100)
    @NotNull
    @Column(name = "AUTHOR", nullable = false, length = 100)
    private String author;

    @Size(max = 255)
    @NotNull
    @Column(name = "TITLE", nullable = false)
    private String title;

    @NotNull
    @Column(name = "PEREX", nullable = false)
    private String perex;

    @NotNull
    @Column(name = "BODY", nullable = false)
    private String body;

    @Column(name = "PUBLISHED")
    private LocalDate published;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerex() {
        return perex;
    }

    public void setPerex(String perex) {
        this.perex = perex;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

}