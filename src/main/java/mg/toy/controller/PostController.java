package mg.toy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    @GetMapping
    public String selectPost(Model model) {
        log.debug("post");
        return "post/post";
    }

    @GetMapping("addPost")
    public String addPost(Model model) {
        log.debug("addPost");
        return "post/addPost";
    }

    @GetMapping("editPost")
    public String editPost(Model model) {
        log.debug("editPost");
        return "post/editPost";
    }

    @PostMapping("updatePost")
    public String updatePost(Model model) {
        log.debug("editPost");
        return "post/detailPost";
    }
}
