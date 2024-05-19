package mg.toy.mapper;

import mg.toy.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> selectComments();

    void addComment(Comment comment);

    void updateComment(Comment comment);

    void deleteComment(Comment comment);
}

