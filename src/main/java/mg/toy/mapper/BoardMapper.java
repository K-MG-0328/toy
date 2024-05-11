package mg.toy.mapper;


import mg.toy.model.Board;

import java.util.List;

public interface BoardMapper {
    List<Board> selectBoard();
    Board selectBoardDetail(Long boardId);
}

