package com.transistorzone.pagination.controller;

import com.transistorzone.pagination.model.Article;
import com.transistorzone.pagination.model.ArticleMetaDataList;
import com.transistorzone.pagination.model.ArticleMetadata;
import com.transistorzone.pagination.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/pagination")
public class PaginationController {

    @Autowired
    BlogService blogService;

    @GetMapping("/article")
    public Article article(@RequestParam int id){
        return blogService.getArticle(id);
    }

    @GetMapping("/articleMetadata/{from}/{to}")
    public ArticleMetaDataList articleMetadata(@PathVariable int from, @PathVariable int to){
        return new ArticleMetaDataList(blogService.getMetadata(from, to));
    }

    @GetMapping("/articleMetadata/{number}")
    public ArticleMetaDataList  articleMetadata(@PathVariable int number){
        return new ArticleMetaDataList(blogService.getMetadata(number));
    }
}
