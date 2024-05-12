package mg.toy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    public PostService postService;

    @GetMapping
    public String getPostList(Model model) {
        List<PostVO> postList =  postService.selectPostList();
        model.addAttribute("postList", postList);
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

    @PostMapping("add")
    public String insertPost(@ModelAttribute PostVO post, Model model) {
        //잠깐만 굳이 post 객체에 조회해서 저장할 필요가 있나?
        return "post/detailPost";
    }

    @GetMapping("edit")
    public String editPost(Model model) {
        log.debug("editPost");
        return "post/editPost";
    }

    @PostMapping("update")
    public String updatePost(Model model) {
        log.debug("editPost");
        return "post/detailPost";
    }
}
