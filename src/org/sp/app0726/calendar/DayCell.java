package org.sp.app0726.calendar;

import java.awt.Color;
import java.awt.Font;

//요일을 표현할 박스 정의
public class DayCell extends Cell{

	public DayCell(Color color, int width, int height) {
		super(color, width, height);
		
		la_title.setForeground(Color.WHITE); //폰트 색상 설정
		
	}
}
