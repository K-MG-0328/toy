package mg.toy.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    //조회
    @GetMapping("/post")
    public String find(Model model) {
        List<Post> boardList = postService.findAll();
        model.addAttribute("BoardList", boardList);

        return "post/post";
    }
}
