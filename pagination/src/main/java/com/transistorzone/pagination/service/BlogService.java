package com.transistorzone.pagination.service;

import com.transistorzone.pagination.model.Article;
import com.transistorzone.pagination.model.ArticleMetadata;

import java.util.List;

public interface BlogService {

Article getArticle(int id);

List<ArticleMetadata> getMetadata(int number);

List<ArticleMetadata> getMetadata(int from, int to);

String getUser(Long id);


}
