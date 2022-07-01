package com.transistorzone.blog.Service;

import com.transistorzone.blog.exceptions.BlogServiceException;
import com.transistorzone.blog.model.Article;
import com.transistorzone.blog.model.ArticleMetadata;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BlogService {
    Article article(@PathVariable long id) throws BlogServiceException;

    List<ArticleMetadata> getArticleDetails(@PathVariable long from, @PathVariable int to) throws BlogServiceException;

    void createPost(Article article) throws BlogServiceException;
}
