package mg.toy.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/blog")
public class BlogController {

    @GetMapping
    public String selectBlog(Model model) {
        log.debug("blog");
        //조회 로직
        //model에 담고 다시 반환.
        return "blog/blog";
    }


    // 게시글 상세 조회
 /*   @GetMapping("/{postId}")
    public String getPostById(@PathVariable Long postId) {
        System.out.println("test");
        Post postDetail = postService.selectPostDetail(postId);
        return "post/postDetail";
    }
*/
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
