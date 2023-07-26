package org.sp.app0726.calendar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JPanel;

import util.StringManager;

//날짜를 표현할 셀
public class NumCell extends Cell{
	DiaryMain diaryMain; //메인 프레임에 캘린더 객체가 존재하기 때문에 접근을 위해 보유함
	JPanel iconBox; //아이콘들이 배치될 패널
	
	public NumCell(DiaryMain diaryMain, Color color, int width, int height) {
		super(color, width, height);
		
		this.diaryMain=diaryMain;
		//this.setAlignmentX(LEFT_ALIGNMENT);
		iconBox=new JPanel();
		
		iconBox.setBackground(Color.CYAN);
		add(iconBox);
		
		//라벨의 텍스트 크기 조정
		la_title.setFont(new Font("맑은고딕", Font.TRUETYPE_FONT, 13));
		
		//마우스 이벤트 연결
		this.addMouseListener(new MouseAdapter() {
			//클릭 구현
			@Override
			public void mouseClicked(MouseEvent e) {
				int yy=diaryMain.cal.get(Calendar.YEAR);
				int mm=diaryMain.cal.get(Calendar.MONTH);
				int n=Integer.parseInt(la_title.getText());
				
				//System.out.println(yy+"-"+(mm+1)+"-"+n);
				diaryMain.popup.showPop(NumCell.this, yy+"-"+StringManager.getNumString(mm+1)+"-"+StringManager.getNumString(n));
		
			}
		});
	}
}
