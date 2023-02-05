package kr.co.coon.mvc.controller;

import kr.co.coon.mvc.domain.Board;
import kr.co.coon.mvc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 게시판 컨트롤러
 * @author coon
 */

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    /**
     * 목록 처리.
     * @return
     */
    @GetMapping
    public List<Board> getList(){

        return boardService.getList();
    }

    /**
     * 상세 정보 리턴
     * @param boardSeq
     * @return
     */
    @GetMapping("/{boardSeq}")
    public Board get(@PathVariable int boardSeq) {

        return boardService.get(boardSeq);
    }

    /**
     * 등록 수정 처리.
     * @param board
     */
    @GetMapping("/save")
    public int save(Board parameter){
        boardService.save(parameter);
        return parameter.getBoardSeq();
    }

    /**
     * 삭제 처리.
     * @param boardSeq
     */
    @GetMapping("/delete/{boardSeq}")
    public boolean delete(@PathVariable int boardSeq) {
    	Board board = boardService.get(boardSeq);
    	if(board == null) {
    		return false;
    	} else {
    		boardService.delete(boardSeq);
    		return true;
    	}
    }
}
