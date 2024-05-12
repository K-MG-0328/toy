package mg.toy.domain;

import lombok.Value;

import java.util.Date;

@Value
public class PostVO {
    private Long postId;            //아이디
    private String title;           //제목
    private String content;         //내용
    private String authorId;        //작성자
    private Date createdAt;         //작성일
    private Date updatedAt;         //수정일
    private Integer viewCount;      //조회수
    private Integer commentCount;   //댓글 수
}
