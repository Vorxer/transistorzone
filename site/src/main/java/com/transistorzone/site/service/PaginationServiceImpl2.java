package com.transistorzone.site.service;

import com.transistorzone.site.model.Article;
import com.transistorzone.site.model.ArticleMetadata;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

//@Service
public class PaginationServiceImpl2 {//implements PaginationService {

    //@Override
    public List<ArticleMetadata> blog(int from, int to){
        List<ArticleMetadata> articleMetadata = new ArrayList<>();
        articleMetadata.add(new ArticleMetadata(1, "How to dance", OffsetDateTime.now(), "Jhon Williams"
                , "Ï took Dance in college"));
        articleMetadata.add(new ArticleMetadata(1, "Why Mars is cool", OffsetDateTime.now(), "Martha Stewart"
                , "Its red everywhere"));
        articleMetadata.add(new ArticleMetadata(1, "How to Produce Music", OffsetDateTime.now(), "Ricky Martin"
                , "Wait I already do this"));
        articleMetadata.add(new ArticleMetadata(1, "Advanced Cooking techniques", OffsetDateTime.now(), "James May"
                , "I actually beat Gordon Ramsay once"));
        articleMetadata.add(new ArticleMetadata(1, "Naval Warfare 101", OffsetDateTime.now(), "Bll Nye"
                , "From a former Spanish Armada Admiral"));
        articleMetadata.forEach(ArticleMetadata::setDate);
        return articleMetadata;
    }

    //@Override
    public List<ArticleMetadata> blog(int no){
        List<ArticleMetadata> articleMetadata = new ArrayList<>();
        articleMetadata.add(new ArticleMetadata(1, "How to dance", OffsetDateTime.now(), "Jhon Williams"
                , "Ï took Dance in college"));
        articleMetadata.add(new ArticleMetadata(1, "Why Mars is cool", OffsetDateTime.now(), "Martha Stewart"
                , "Its red everywhere"));
        articleMetadata.add(new ArticleMetadata(1, "How to Produce Music", OffsetDateTime.now(), "Ricky Martin"
                , "Wait I already do this"));
        articleMetadata.add(new ArticleMetadata(1, "Advanced Cooking techniques", OffsetDateTime.now(), "James May"
                , "I actually beat Gordon Ramsay once"));
        articleMetadata.add(new ArticleMetadata(1, "Naval Warfare 101", OffsetDateTime.now(), "Bll Nye"
                , "From a former Spanish Armada Admiral"));
        articleMetadata.forEach(ArticleMetadata::setDate);
        return articleMetadata;
    }

    //@Override
    public Article article(int id){
        List<String> paragraphs = new ArrayList<>();
        paragraphs.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sit amet fermentum orci, et ultrices risus. Sed iaculis vitae sapien sit amet laoreet. Maecenas semper fermentum enim, ac blandit nunc efficitur et. Morbi elementum, nibh sed convallis efficitur, tellus arcu aliquet lectus, consectetur lobortis elit velit aliquet magna. Pellentesque hendrerit scelerisque nulla id congue. Integer id risus purus. Quisque vel lorem vel metus facilisis pretium. Donec sollicitudin erat eu congue egestas. Duis non tincidunt orci, quis sodales velit. Sed vel odio metus. Proin vitae mi interdum, accumsan lectus placerat, faucibus nibh. Sed vitae porttitor diam.");
        paragraphs.add("Donec mattis ligula neque, nec tempus nibh malesuada non. Ut consequat, nulla a volutpat iaculis, nibh velit dapibus eros, ut posuere lectus tellus et elit. Phasellus aliquet quam quis lectus viverra sodales. Fusce mollis sem at eros pulvinar, vel gravida enim convallis. Mauris et aliquet justo. Donec ultricies nisi ac turpis porttitor auctor. Suspendisse eu volutpat justo. Fusce nec cursus purus.");
        paragraphs.add("Ut eleifend metus ac arcu consectetur, fringilla varius urna feugiat. In tempus dictum congue. Etiam dictum consequat magna in posuere. Vivamus quis tempor nunc. Aliquam at turpis a nibh vulputate imperdiet eget sed diam. Nulla facilisi. Fusce id ultrices lorem. Nam pharetra ipsum vel purus vehicula, ac congue ante auctor. Donec dui ligula, vulputate non ultrices aliquam, lacinia eget quam. Etiam posuere pellentesque elit, at sagittis odio placerat auctor. Sed non arcu eget augue vulputate lobortis id sed leo. Duis lacinia augue nisl, ac cursus eros aliquet eget. Ut tempus tincidunt nibh ac consequat. Quisque et rutrum ante.");
        paragraphs.add("Suspendisse mollis dapibus magna, at feugiat lacus aliquet quis. Mauris a viverra lacus, in rhoncus odio. In hac habitasse platea dictumst. Integer auctor sed nisl tincidunt consectetur. Mauris elementum arcu orci, blandit lacinia nibh bibendum eu. Suspendisse nec vehicula quam, sit amet hendrerit ante. Nam pellentesque lacinia consectetur. Integer neque metus, sodales sed orci ut, tempor interdum neque. Vivamus dictum lorem sit amet nunc finibus mattis. Nulla tincidunt viverra metus non placerat. Proin non leo in magna vehicula iaculis tempor interdum massa. Ut feugiat maximus libero, et hendrerit nisi rhoncus non.");
        paragraphs.add("Donec iaculis sapien ac justo bibendum efficitur. Fusce maximus lorem nulla, nec ultrices eros semper quis. Proin vehicula mollis dolor. Nam finibus vehicula risus, ac aliquet libero gravida id. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque ac placerat metus. Etiam euismod odio eget nisi venenatis, eget malesuada est ultricies. Mauris volutpat dui vitae lectus sodales pulvinar. Fusce eros risus, venenatis non nibh sed, auctor egestas ante. Nam est quam, posuere at nibh a, commodo pellentesque dolor. Aliquam erat volutpat. Mauris commodo viverra tempor.");

        Article article = new Article();
        article.setAuthorId("James May");
        article.setParagraphs(paragraphs);
        article.setSubtitle("I actually beat Gordon Ramsay once");
        article.setTitle("Advanced Cooking techniques");
        article.setOffsetDateTime(OffsetDateTime.now());

        return article;
    }

}
