package mg.toy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mg.toy.domain.Post;
import mg.toy.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    public String getPostList(@RequestParam(name = "pageNumber", defaultValue = "1") int pageNumber,
                              @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
                              Model model) {
        int totalPages = postService.countTotalPost();
        List<Post> postList =  postService.selectPostList(pageNumber, pageSize);
        model.addAttribute("postList", postList);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", pageSize);
        return "post/postList";
    }

    @GetMapping("/{postId}")
    public String getPost(@PathVariable("postId") Long postId, Model model) {
        Post post =  postService.selectPost(postId);
        model.addAttribute("post", post);
        log.debug("post: {}", post);
        return "post/detailPost";
    }

    @GetMapping("/add")
    public String addPost(Model model) {
        return "post/addPost";
    }

    @PostMapping("/add")
    public String insertPost(@ModelAttribute Post post, Model model) {
        log.debug("insertPost");
        log.debug("post = {}", post.toString());
        int result = postService.savePost(post);
        log.debug("result = {}", result);
        return "post/detailPost";
    }

    @GetMapping("/edit/{postId}")
    public String editPost(@PathVariable("postId") Long postId, Model model) {
        log.debug("editPost");
        Post post = postService.selectPost(postId);
        log.debug("post = {}", post.toString());
        model.addAttribute("post", post);
        return "post/editPost";
    }

    @PostMapping("/delete/{postId}")
    public String deletePost(@PathVariable("postId") Long postId, Model model) {
        log.debug("deletePost");

        int result = postService.deletePost(postId);
        log.debug("result = {}", result);
        return "redirect:/post";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Post post, Model model) {
        log.debug("updatePost");
        log.debug("postId = {}", post.getPostId());

        int result = postService.updatePost(post);
        log.debug("result = {}", result);
        model.addAttribute("post", post);
        return "post/detailPost";
    }
}
