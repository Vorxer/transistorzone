package com.transistorzone.pagination.service;

import com.transistorzone.pagination.model.Article;
import com.transistorzone.pagination.model.ArticleMetaDataList;
import com.transistorzone.pagination.model.ArticleMetadata;
import com.transistorzone.pagination.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    RestTemplate restTemplate;

    String blogUrl = "http://BLOG-SERVICE/blog/";

    String userUrl = "http://USER-SERVICE/user/";

    @Override
    public List<ArticleMetadata> getMetadata(int from, int to) {
        String url = blogUrl + "page" + "/" + from + "/" + to;
        ResponseEntity<ArticleMetaDataList> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null, ArticleMetaDataList.class);
        List<ArticleMetadata> articleMetadata = Objects.requireNonNull(responseEntity.getBody()).getArticleMetaData();
        articleMetadata.forEach(a -> a = appendAuthor(a));
        return articleMetadata;
    }

    @Override
    public List<ArticleMetadata> getMetadata(int no) {
        String url = blogUrl + "page/0/10";
        ResponseEntity<ArticleMetaDataList> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null, ArticleMetaDataList.class);
        List<ArticleMetadata> articleMetadata = Objects.requireNonNull(responseEntity.getBody()).getArticleMetaData();
        articleMetadata.forEach(a -> a = appendAuthor(a));
        return articleMetadata;
    }

    @Override
    public Article getArticle(int id) {
        String url = UriComponentsBuilder.fromHttpUrl(blogUrl + "/article")
                .queryParam("id", id).toUriString();
        ResponseEntity<Response> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null, Response.class);
        return appendAuthor(responseEntity.getBody().getBody());
    }

    private Article appendAuthor(Article article){
        String userName = getUser(article.getId());
        article.setAuthorId(userName);
        return article;
    }

    private ArticleMetadata appendAuthor(ArticleMetadata article){
        String userName = getUser(article.getId());
        article.setAuthorId(userName);
        return article;
    }

    @Override
    public String getUser(Long id) {
        String url = UriComponentsBuilder.fromHttpUrl(userUrl + "/userName")
                .queryParam("id", id).toUriString();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null, String.class);
        return responseEntity.getBody();
    }
}
