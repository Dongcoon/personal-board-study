package kr.co.coon.mvc.repository;

import kr.co.coon.mvc.domain.Board;
import kr.co.coon.mvc.parameter.BoardParameter;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 게시판 Repository
 * @author coon
 */

@Repository
public interface BoardRepository {
	
    List<Board> getList();
    
    Board get(int boardSeq);

    void save(BoardParameter board);

    void update(BoardParameter board);

    void delete(int boardSeq);

}
