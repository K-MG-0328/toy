package mg.toy.controller;

import lombok.RequiredArgsConstructor;
import mg.toy.model.Post;
import mg.toy.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    //조회
    @GetMapping
    public String selectPost(Model model) {
        /* 2024.04.09 전체 조회만 구현해놓았다.
           TODO 검색조건 구현
           TODO 페이징 구현
         */

        List<Post> postList = postService.selectPost();
        model.addAttribute("postList", postList);

        return "post/post";
    }

    // 게시글 상세 조회
    @GetMapping("/{postId}")
    public String getPostById(@PathVariable Long postId) {
        System.out.println("test");
        Post postDetail = postService.selectPostDetail(postId);
        return "post/postDetail";
    }

    // 게시글 생성
   /* @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        return postService.updatePost(id, postDetails);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }*/
}
