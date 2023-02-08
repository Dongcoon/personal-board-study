package kr.co.coon.mvc.parameter;

import java.util.List;

import kr.co.coon.mvc.domain.BoardType;
import lombok.Data;

@Data
public class BoardSearchParameter {
	
	private String keyword;
	private List<BoardType> boardTypes;
	
	public BoardSearchParameter() {
		
	}

}
