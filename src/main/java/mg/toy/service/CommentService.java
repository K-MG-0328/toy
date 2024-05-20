package mg.toy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mg.toy.domain.Comment;
import mg.toy.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    public List<Comment> selectComments(Long postId) {
        return commentMapper.selectComments(postId);
    }

    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    public void updateComment(Comment comment) {
        commentMapper.updateComment(comment);
    }

    public void deleteComment(Comment comment) {
        commentMapper.deleteComment(comment);
       /* int parentCommnet = commentMapper.selectChildComments(comment);
        if (parentCommnet > 0) {
            comment.setContent("삭제가 되었습니다.");
            comment.setDelYn("Y");
            commentMapper.updateComment(comment);
        }else{
            commentMapper.deleteComment(comment);
        }*/
    }

}
