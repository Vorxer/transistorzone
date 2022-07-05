package com.transistorzone.site.controller;

import com.transistorzone.site.model.Article;
import com.transistorzone.site.service.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SiteController {

    @Autowired
    PaginationService paginationService;

    @GetMapping
    String defaultPage(Model model){
        return homepage(model);
    }

    @GetMapping("/homepage")
    String homepage(Model model){
        return "home";
    }

    @GetMapping("/blog")
    String blog(Model model){
        model.addAttribute("articlelist", paginationService.blog(1,20).toArray());
        return "tz-blog";
    }

    @GetMapping("/article")
    String article(Model model, @RequestParam int id){
        Article article = paginationService.article(id);
        model.addAttribute("article", article);
        model.addAttribute("date", article.getOffsetDateTime().toString().split("T")[0]);
        model.addAttribute("articlelist", paginationService.blog(5).toArray());
        return "article";
    }


}
