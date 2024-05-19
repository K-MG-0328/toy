package mg.toy.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Board {
    private Long boardId;
    private String title;
    private String content;
    private String authorId;
    private Date createdAt;
    private Date updatedAt;
    private Integer viewCount;
    private Integer commentCount;
}
