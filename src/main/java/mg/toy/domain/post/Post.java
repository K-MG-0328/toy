package mg.toy.domain.post;

import lombok.Data;

import java.util.Date;
import java.util.List;

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
