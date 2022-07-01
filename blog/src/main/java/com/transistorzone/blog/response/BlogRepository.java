package com.transistorzone.blog.response;

import com.transistorzone.blog.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends MongoRepository<Article,Long> {
}
