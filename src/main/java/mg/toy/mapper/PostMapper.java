package mg.toy.mapper;


import mg.toy.model.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> selectPost();
    Post selectPostDetail(Long postId);
}

