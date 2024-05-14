package mg.toy.mapper;


import mg.toy.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostVO> selectPostList();
    PostVO selectPostDetail(Long postId);
    int savePost(PostVO post);
}

