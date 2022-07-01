package model.blog;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ArticleMetadata {

    private ArticleMetadata() {
    }

    public ArticleMetadata(Article article) {
        id = article.getId();
        title = article.getTitle();
        offsetDateTime = article.getOffsetDateTime();
        authorId = article.getAuthorId();
        subtitle = article.getSubtitle();
    }

    private long id;

    private String title;

    private OffsetDateTime offsetDateTime;

    private String authorId;

    private String subtitle;

}
