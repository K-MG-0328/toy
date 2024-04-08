package mg.toy.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostMapper postMapper;

    public List<Post> findAll() {
        List<Post> result = postMapper.selectBoard();
        return postMapper.selectBoard();
    }
}
