package com.transistorzone.blog.model;

import java.time.OffsetDateTime;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OffsetDateTime getOffsetDateTime() {
        return offsetDateTime;
    }

    public void setOffsetDateTime(OffsetDateTime offsetDateTime) {
        this.offsetDateTime = offsetDateTime;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
