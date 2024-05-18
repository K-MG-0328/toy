package mg.toy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mg.toy.domain.Post;
import mg.toy.mapper.PostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostMapper postMapper;

    public List<Post> selectPostList(int pageNumber, int pageSize) {
        int startRow = (pageNumber - 1) * pageSize + 1;
        int endRow = pageNumber * pageSize;
        return postMapper.selectPostList(startRow, endRow);
    }

    public int countTotalPost(int pageSize) {
        int postCnt = postMapper.countTotalPost();
        return postCnt / pageSize + 1;
    }

    @Transactional
    public Post selectPost(Long postId) {
        postMapper.incrementViewCount(postId);
        return postMapper.selectPostDetail(postId);
    }

    public int savePost(Post post) {
        return postMapper.savePost(post);
    }

    public int deletePost(Long postId) {
        return postMapper.deletePost(postId);
    }

    public int updatePost(Post post) {
        return postMapper.updatePost(post);
    }

}
