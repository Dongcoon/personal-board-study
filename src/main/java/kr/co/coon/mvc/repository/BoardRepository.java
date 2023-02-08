package kr.co.coon.mvc.repository;

import kr.co.coon.mvc.domain.Board;
import kr.co.coon.mvc.parameter.BoardParameter;
import kr.co.coon.mvc.parameter.BoardSearchParameter;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 게시판 Repository
 * @author coon
 */

@Repository
public interface BoardRepository {
	
    List<Board> getList(BoardSearchParameter parameter);
    
    Board get(int boardSeq);

    void save(BoardParameter board);
    void saveList(Map<String, Object> paramMap);

    void update(BoardParameter board);

    void delete(int boardSeq);

}
