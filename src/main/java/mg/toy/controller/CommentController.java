package mg.toy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mg.toy.domain.Comment;
import mg.toy.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("{postId}")
    public ResponseEntity<?> getComments(@PathVariable("postId") Long postId) {
        log.debug("getComments");
        log.debug("postId :: {}", postId);
        List<Comment> comments = commentService.selectComments(postId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody Comment comment) {
        log.debug("Comment : {}", comment.toString());
        Map<String, Object> response = new HashMap<>();
        commentService.addComment(comment);
        response.put("success", true);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{commentId}")
    public ResponseEntity<?> updateComment(@RequestBody Comment comment) {
        log.debug("UpdateComment : {}", comment.toString());
        Map<String, Object> response = new HashMap<>();
        commentService.updateComment(comment);
        response.put("success", true);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteComment(@RequestBody Comment comment) {
        log.debug("DeleteComment : {}", comment);
        Map<String, Object> response = new HashMap<>();
        commentService.deleteComment(comment);
        response.put("success", true);
        return ResponseEntity.ok(response);
    }
}
