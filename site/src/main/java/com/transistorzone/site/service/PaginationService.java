package com.transistorzone.site.service;

import com.transistorzone.site.model.Article;
import com.transistorzone.site.model.ArticleMetadata;

import java.util.List;

public interface PaginationService {
    List<ArticleMetadata> blog(int from, int to);

    List<ArticleMetadata> blog(int no);

    Article article(int id);
}
