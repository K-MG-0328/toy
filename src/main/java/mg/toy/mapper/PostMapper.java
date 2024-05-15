package mg.toy.mapper;


import mg.toy.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostVO> selectPostList(@Param("startRow") int startRow, @Param("endRow") int endRow);
    int countTotalPost();
    PostVO selectPostDetail(Long postId);
    int savePost(PostVO post);
}

