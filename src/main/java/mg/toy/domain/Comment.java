package mg.toy.domain;

import lombok.Data;


@Data
public class Comment {
    private Long commentId;
    private Long postId;
    private String authorId;
    private String content;
    private String createdAt;
    private String updatedAt;
    private Long parentId;
    private String delYn;
}
