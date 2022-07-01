package model.blog;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.util.List;

@Document(collection = "article")
@Data
public class Article {

    public Article() {
    }

    @Id
    private Long id;

    private String title;

    private OffsetDateTime offsetDateTime;

    private String authorId;

    private String subtitle;

    private String content;

    private List<String> paragraphs;

}
