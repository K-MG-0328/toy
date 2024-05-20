package mg.toy.mapper;

import mg.toy.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> selectComments(@Param("postId") Long postId);

    void addComment(Comment comment);

    void updateComment(Comment comment);

    void deleteComment(Comment comment);

    int selectChildComments(Comment comment);
}

