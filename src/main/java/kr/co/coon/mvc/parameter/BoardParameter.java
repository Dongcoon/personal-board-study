package kr.co.coon.mvc.parameter;

import kr.co.coon.mvc.domain.BoardType;
import lombok.Data;


/**
 * 게시물 파라미터
 * @author Coon
 *
 */
@Data
public class BoardParameter {
	
    private int boardSeq;
    private BoardType boardType;
    private String title;
    private String contents;
    
    // 기본생성자
    public BoardParameter() {
    	
    }
    
    // 테스트용 생성자
	public BoardParameter(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
    
    

}
