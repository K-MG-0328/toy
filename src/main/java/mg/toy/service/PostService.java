package mg.toy.service;

import lombok.RequiredArgsConstructor;
import mg.toy.domain.PostVO;
import mg.toy.mapper.PostMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostMapper postMapper;

    public List<PostVO> selectPostList() {
        List<PostVO> postList = postMapper.selectPostList();
        return postList;
    }

    public PostVO selectPost(Long postId) {
        PostVO post = postMapper.selectPostDetail(postId);
        return post;
    }
}
