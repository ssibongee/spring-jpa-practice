package com.example.paging.domain.dto;

import com.example.paging.domain.Article;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleResponse {

    private long id;

    private String title;

    private String category;

    private String author;

    private String content;

    private String state;
    private String city;
    private String street;

    @Builder
    public ArticleResponse(long id, String title, String category, String author, String content, String state, String city, String street) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.content = content;
        this.state = state;
        this.city = city;
        this.street = street;
    }

    public static ArticleResponse of(Article article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .category(article.getCategory())
                .author(article.getAuthor())
                .content(article.getContent())
                .state(article.getState())
                .city(article.getCity())
                .street(article.getStreet())
                .build();
    }

}
