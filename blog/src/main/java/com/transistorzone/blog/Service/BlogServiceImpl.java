package com.transistorzone.blog.Service;

import com.transistorzone.blog.exceptions.ArticleNotFoundException;
import com.transistorzone.blog.exceptions.BlogServiceException;
import com.transistorzone.blog.model.Article;
import com.transistorzone.blog.model.ArticleMetadata;
import com.transistorzone.blog.response.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository repository;

    @Override
    public Article article(long id) throws BlogServiceException {
        Optional<Article> articleOptional =repository.findById(id);
        if(articleOptional.isPresent())
            return articleOptional.get();
        throw new ArticleNotFoundException("The requested article : " + id +" could not be found");
    }


    @Override
    public List<ArticleMetadata> getArticleDetails(long from, int number) throws BlogServiceException{
        List<ArticleMetadata> articleMetadata = new ArrayList<>();
        Optional<Article> article;
        int tries = 0;
        long iterator = from;
        for (int i = 0; i < number;) {
            if (tries > 5)
                break;
            try{
                article = repository.findById(iterator);
                if(article.isPresent()){
                      tries = 0;
                      articleMetadata.add(new ArticleMetadata(article.get()));
                      i++;
                }
                else
                    tries++;

                iterator++;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        return articleMetadata;
    }

    @Override
    public void createPost(Article article) {
        repository.save(article);
    }
}
