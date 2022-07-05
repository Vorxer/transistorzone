package com.transistorzone.site.controller;

import com.transistorzone.site.model.Article;
import com.transistorzone.site.service.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {


    @Autowired
    PaginationService paginationService;

    @GetMapping("/blog")
    Object blog(Model model){
        return paginationService.blog(1,20).toArray();
    }

    @GetMapping("/article")
    Object article(Model model){
        List<Object> list = new ArrayList<>();
        list.add(paginationService.article(1));
        list.add(paginationService.blog(5).toArray());
        return list;
    }

}
