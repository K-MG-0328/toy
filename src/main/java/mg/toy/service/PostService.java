package mg.toy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mg.toy.domain.PostVO;
import mg.toy.mapper.PostMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostMapper postMapper;

    public List<PostVO> selectPostList(int pageNumber, int pageSize) {
        int startRow = (pageNumber - 1) * pageSize + 1;
        int endRow = pageNumber * pageSize;
        List<PostVO> postList = postMapper.selectPostList(startRow, endRow);
        return postList;
    }

    public int countTotalPost() {
        return postMapper.countTotalPost();
    }

    public PostVO selectPost(Long postId) {
        PostVO post = postMapper.selectPostDetail(postId);
        return post;
    }

    public int savePost(PostVO post) {
        int result = postMapper.savePost(post);
        return result;
    }
}
