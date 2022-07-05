package com.transistorzone.site.service;

import com.transistorzone.site.model.Article;
import com.transistorzone.site.model.ArticleMetaDataList;
import com.transistorzone.site.model.ArticleMetadata;
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
public class PaginationServiceImpl implements PaginationService {

    @Autowired
    RestTemplate restTemplate;

    String paginationUrl = "http://localhost:8500/pagination/";

    @Override
    public List<ArticleMetadata> blog(int from, int to) {
        HttpEntity<Object> httpEntity = new HttpEntity<>(new Object());
        String url = paginationUrl+ "articleMetadata/"+ + from + "/" + to;
        ResponseEntity<ArticleMetaDataList> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null, ArticleMetaDataList.class);
        return Objects.requireNonNull(responseEntity.getBody()).getArticleMetaData();
    }

    @Override
    public List<ArticleMetadata> blog(int no) {
        HttpEntity<Object> httpEntity = new HttpEntity<>(new Object());
        String url = paginationUrl + "articleMetadata/" + no;
        ResponseEntity<ArticleMetaDataList> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null, ArticleMetaDataList.class);
        return Objects.requireNonNull(responseEntity.getBody()).getArticleMetaData();
    }

    @Override
    public Article article(int id) {
        HttpEntity<Object> httpEntity = new HttpEntity<>(new Object());
        String url = UriComponentsBuilder.fromHttpUrl(paginationUrl + "article/")
                .queryParam("id", id).toUriString();
        ResponseEntity<Article> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null, Article.class);
        return responseEntity.getBody();
    }
}
