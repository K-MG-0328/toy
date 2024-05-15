package mg.toy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mg.toy.domain.BoardVO;
import mg.toy.domain.PostVO;
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
        List<PostVO> postList =  postService.selectPostList(pageNumber, pageSize);
        model.addAttribute("postList", postList);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", pageSize);
        return "post/postList";
    }

    @GetMapping("/{postId}")
    public String getPost(@PathVariable("postId") Long postId, Model model) {
        PostVO postInfo =  postService.selectPost(postId);
        model.addAttribute("postInfo", postInfo);
        return "post/detailPost";
    }

    @GetMapping("add")
    public String addPost(Model model) {
        return "post/addPost";
    }

    @PostMapping("add/{postId}")
    public String insertPost(@ModelAttribute PostVO post, Model model) {
        int result = postService.savePost(post);
        log.debug("result = {}", result); //확인해볼것.
        return "post/detailPost";
    }

    @GetMapping("edit")
    public String editPost(Model model) {
        log.debug("editPost");
        return "post/editPost";
    }

    @PostMapping("save")
    public String savePost(Model model) {
        log.debug("savePost");
        return "post/detailPost";
    }
}
