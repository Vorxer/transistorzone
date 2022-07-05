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

    String blogUrl = "http://localhost:8080/blog/";

    @Override
    public List<ArticleMetadata> getMetadata(int from, int to) {
        HttpEntity<Object> httpEntity = new HttpEntity<>(new Object());
        String url = blogUrl + "page" + "/" + from + "/" + to;
        ResponseEntity<ArticleMetaDataList> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null, ArticleMetaDataList.class);
        return Objects.requireNonNull(responseEntity.getBody()).getArticleMetaData();
    }

    @Override
    public List<ArticleMetadata> getMetadata(int no) {
        HttpEntity<Object> httpEntity = new HttpEntity<>(new Object());
        String url = blogUrl + "page/0/10";
        ResponseEntity<ArticleMetaDataList> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null, ArticleMetaDataList.class);
        return Objects.requireNonNull(responseEntity.getBody()).getArticleMetaData();
    }

    @Override
    public Article getArticle(int id) {
        HttpEntity<Object> httpEntity = new HttpEntity<>(new Object());
        String url = UriComponentsBuilder.fromHttpUrl(blogUrl + "/article")
                .queryParam("id", id).toUriString();
        ResponseEntity<Response> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null, Response.class);
        return responseEntity.getBody().getBody();
    }

    private void appendAuthor(){

    }
}
