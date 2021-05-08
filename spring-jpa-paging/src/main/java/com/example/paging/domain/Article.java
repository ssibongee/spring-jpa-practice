package com.example.paging.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ARTICLE_ID")
    private Long id;

    private String title;

    private String category;

    private String author;

    @Lob
    private String content;

    private String state;
    private String city;
    private String street;

    @Builder
    public Article(Long id, String title, String category, String author, String content, String state, String city, String street) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.content = content;
        this.state = state;
        this.city = city;
        this.street = street;
    }
}
