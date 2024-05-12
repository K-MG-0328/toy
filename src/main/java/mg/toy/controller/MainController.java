package mg.toy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private final PostController postController;

    @GetMapping
    public String main(Model model) {
        String defaultPage = postController.selectPost(model);
        model.addAttribute("contentPage", defaultPage);
        log.debug(defaultPage);
        return "layout/layout";
    }
}
