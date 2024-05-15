package mg.toy.domain;

import lombok.Data;

@Data
public class PostVO {
    private Long postId;            //아이디
    private Long rn;                //순번
    private String title;           //제목
    private String content;         //내용
    private String authorId;        //작성자
    private String createdAt;       //작성일
    private String updatedAt;       //수정일
    private Integer viewCount;      //조회수
    private Integer commentCount;   //댓글 수
    private String boardId;
}
