package mg.toy.domain;

import lombok.Data;

import java.util.List;

@Data
public class Comment {
    private Long commentId;
    private Long postId;
    private String authorId;
    private String content;
    private String createdAt;
    private String updatedAt;
    private Long parentId;
}
