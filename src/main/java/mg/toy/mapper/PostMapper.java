package mg.toy.mapper;


import mg.toy.domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> selectPostList(@Param("startRow") int startRow, @Param("endRow") int endRow);
    int countTotalPost();
    Post selectPostDetail(@Param("postId") Long postId);
    void incrementViewCount(@Param("postId") Long postId);
    int savePost(Post post);
    int deletePost(@Param("postId") Long postId);
    int updatePost(Post post);

}

