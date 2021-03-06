package com.transistorzone.blog.controller;

import com.transistorzone.blog.Service.BlogService;
import com.transistorzone.blog.exceptions.BlogServiceException;
import com.transistorzone.blog.model.Article;
import com.transistorzone.blog.model.ArticleMetaDataList;
import com.transistorzone.blog.model.ArticleMetadata;
import com.transistorzone.blog.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class Controller {

    @Autowired
    BlogService service;

    @GetMapping("/article")
    public ResponseEntity<Response> article(@RequestParam long id){
        try {
            return new ResponseEntity<>(new Response("success",service.article(id)), HttpStatus.OK);
        }catch (BlogServiceException e){
            return createErrorResponse(e);
        }
    }

    @GetMapping("/page/{from}/{to}")
    public ResponseEntity<ArticleMetaDataList> getArticleDetails(@PathVariable long from, @PathVariable int to){
        try {
            return new ResponseEntity<>(new ArticleMetaDataList(service.getArticleDetails(from,to)), HttpStatus.OK);
        }catch (BlogServiceException e){
            return null;
        }
    }

    @PostMapping("/createPost")
    public ResponseEntity<Response> createPost(@RequestBody Article article){
        try {
            if(article.getOffsetDateTime() == null)
                article.setOffsetDateTime(OffsetDateTime.now().toEpochSecond());
            service.createPost(article);
        } catch (BlogServiceException e) {
            return createErrorResponse(e);
        }
        return new ResponseEntity<>(new Response("success",null), HttpStatus.OK);

    }

    private ResponseEntity<Response> createErrorResponse(BlogServiceException e){
        return new ResponseEntity<>(new Response(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
