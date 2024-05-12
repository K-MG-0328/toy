package mg.toy.domain;

import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
public class CommentVO {
    private Long commentId;
    private Long postId;
    private String authorId;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private Long parentId;
    private CommentVO parentComment;
    private List<CommentVO> childComments;


}
