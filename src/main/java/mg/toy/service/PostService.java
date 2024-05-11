package mg.toy.service;

import lombok.RequiredArgsConstructor;
import mg.toy.mapper.PostMapper;
import mg.toy.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostMapper postMapper;

    public List<Post> selectPost() {
        List<Post> result = postMapper.selectPost();
        return result;
    }

    public Post selectPostDetail(Long postId) {
        Post result = postMapper.selectPostDetail(postId);
        return result;
    }
}
