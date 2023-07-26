package org.sp.app0726.calendar;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

//달력에 사용할 사각형 셀을 정의함
public class Cell extends JPanel{
	JLabel la_title;
	
	public Cell(Color color, int width, int height) {
		this.setPreferredSize(new Dimension(width, height));
		setBackground(color);
		
		la_title=new JLabel();
		this.add(la_title);
		
	}
	
	public void setTitile(String title) {
		la_title.setText(title);
	}
}
