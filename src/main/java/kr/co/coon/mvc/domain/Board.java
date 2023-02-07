package kr.co.coon.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	
    private int boardSeq;
    private BoardType boardType;
    private String title;
    private String contents;
    private Date regDate;	

}
