package kr.co.coon.mvc.controller;

import kr.co.coon.configuration.http.BaseResponse;
import kr.co.coon.mvc.domain.Board;
import kr.co.coon.mvc.parameter.BoardParameter;
import kr.co.coon.mvc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * 게시판 컨트롤러
 * @author coon
 */

@RestController
@RequestMapping("/board")
@Api(tags ="게시판API")
public class BoardController {

    @Autowired
    private BoardService boardService;

    /**
     * 목록 처리.
     * @return
     */
    @GetMapping
    @ApiOperation(value = "목록 조회", notes = "게시물 목록 정보를 조회할 수 있습니다.")
    public BaseResponse<List<Board>> getList(){

        return new BaseResponse<List<Board>>(boardService.getList());
    }

    /**
     * 상세 정보 리턴
     * @param boardSeq
     * @return
     */
    @GetMapping("/{boardSeq}")
    @ApiOperation(value = "상세 조회", notes = "게시물 번호에 해당하는 상세 정보를 조회할 수 있습니다.")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="boardSeq", value="게시물 번호", example="1")
    })
    public BaseResponse<Board> get(@PathVariable int boardSeq) {

        return new BaseResponse<Board> (boardService.get(boardSeq));
    }

    /**
     * 등록 수정 처리.
     * @param board
     */
    @PutMapping
    @ApiOperation(value = "등록 / 수정 처리", notes = "신규 게시물 저장 및 기존 게시물 업데이트가 가능합니다.")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="boardSeq", value="게시물 번호", example="1"),
    	@ApiImplicitParam(name="title", value="제목", example="제목"),
    	@ApiImplicitParam(name="contents", value="내용", example="내용"),
    })
    public BaseResponse<Integer> save(BoardParameter parameter){
        boardService.save(parameter);
        return new BaseResponse<Integer>(parameter.getBoardSeq());
    }

    /**
     * 삭제 처리.
     * @param boardSeq
     */
    @DeleteMapping("/{boardSeq}")
    @ApiOperation(value = "삭제 처리", notes = "게시물 번호에 해당하는 정보를 삭제합니다.")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="boardSeq", value="게시물 번호", example="1"),
    })
    public BaseResponse<Boolean> delete(@PathVariable int boardSeq) {
    	Board board = boardService.get(boardSeq);
    	if(board == null) {
    		return new BaseResponse<Boolean>(false);
    	} else {
    		boardService.delete(boardSeq);
    		
    		return new BaseResponse<Boolean>(true);
    	}
    }
}
