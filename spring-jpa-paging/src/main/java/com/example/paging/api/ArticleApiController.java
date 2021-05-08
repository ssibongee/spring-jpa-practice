package com.example.paging.api;

import com.example.paging.domain.dto.ArticlePageResponse;
import com.example.paging.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/searches")
@RequiredArgsConstructor
public class ArticleApiController {

    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<ArticlePageResponse> getDefaultPage(Pageable pageable) {

        ArticlePageResponse page = articleService.findAll(pageable);

        return ResponseEntity.ok(page);
    }
}
