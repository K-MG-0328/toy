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
                              Model model) {
        int pageSize = 10;
        int totalPages = postService.countTotalPost(pageSize);
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
        return "post/detailPost";
    }

    @GetMapping("/add")
    public String addPost() {
        return "post/addPost";
    }

    @PostMapping("/add")
    public String insertPost(@ModelAttribute Post post) {
        postService.savePost(post);
        return "post/detailPost";
    }

    @GetMapping("/edit/{postId}")
    public String editPost(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.selectPost(postId);
        model.addAttribute("post", post);
        return "post/editPost";
    }

    @PostMapping("/delete/{postId}")
    public String deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
        return "redirect:/post";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Post post, Model model) {
        postService.updatePost(post);
        model.addAttribute("post", post);
        return "post/detailPost";
    }
}
