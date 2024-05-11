package mg.toy.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Comment {
    private Long commentId;
    private Long postId;
    private String authorId;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private Long parentId;
    private Comment parentComment;
    private List<Comment> childComments;


}
