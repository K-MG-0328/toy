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

    public List<Comment> selectComments() {
        return commentMapper.selectComments();
    }

    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    public void updateComment(Comment comment) {
        commentMapper.updateComment(comment);
    }

    public void deleteComment(Comment comment) {
        commentMapper.deleteComment(comment);
    }
}
