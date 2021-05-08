package com.example.paging.service;

import com.example.paging.domain.Article;
import com.example.paging.domain.ArticleRepository;
import com.example.paging.domain.dto.ArticlePageResponse;
import com.example.paging.domain.dto.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticlePageResponse findAll(Pageable pageable) {
        Page<Article> pages = articleRepository.findAll(pageable);

        int totalPages = pages.getTotalPages();

        List<ArticleResponse> articleResponses = pages.getContent().stream().map(ArticleResponse::of).collect(Collectors.toList());

        ArticlePageResponse page = new ArticlePageResponse();
        page.setCurrentPageNumber(pageable.getPageNumber());
        page.setTotalPages(totalPages);
        page.setArticles(articleResponses);

        return page;
    }
}
