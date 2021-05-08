package com.example.paging.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArticlePageResponse {

    private int totalPages;
    private int currentPageNumber;

    private List<ArticleResponse> articles;

}
