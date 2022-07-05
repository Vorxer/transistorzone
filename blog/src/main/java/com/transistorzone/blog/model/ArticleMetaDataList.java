package com.transistorzone.blog.model;

import java.util.List;

public class ArticleMetaDataList {

    public ArticleMetaDataList(List<ArticleMetadata> articleMetaData) {
        this.articleMetaData = articleMetaData;
    }

    public ArticleMetaDataList() {
    }

    List<ArticleMetadata> articleMetaData;

    public List<ArticleMetadata> getArticleMetaData() {
        return articleMetaData;
    }

    public void setArticleMetaData(List<ArticleMetadata> articleMetaData) {
        this.articleMetaData = articleMetaData;
    }
}
