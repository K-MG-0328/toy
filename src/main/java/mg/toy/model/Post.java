package mg.toy.model;

import lombok.Data;

import java.util.Date;

@Data
public class Post {
    private Long postId;
    private String title;
    private String content;
    private String authorId;
    private Date createdAt;
    private Date updatedAt;
    private Integer viewCount;
    private Integer commentCount;
}
