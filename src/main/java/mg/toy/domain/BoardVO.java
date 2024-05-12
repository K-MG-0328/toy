package mg.toy.domain;

import lombok.Value;

import java.util.Date;

@Value
public class BoardVO {
    private Long boardId;
    private String title;
    private String content;
    private String authorId;
    private Date createdAt;
    private Date updatedAt;
    private Integer viewCount;
    private Integer commentCount;
}
