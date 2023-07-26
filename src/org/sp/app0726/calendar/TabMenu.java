package org.sp.app0726.calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

//화면의 구석에 숨겨져 있다가 마우스 이벤트에 반응해 모습을 드러내는 탭 메뉴 구현
//현재 클래스가 이미 다른 클래스의 자식인 경우, 쓰레드를 재정의하지 못함
//왜? 다중 상속 금지원칙에 걸리므로. 이 경우 쓰레드의 run()메서드만을 보유한 인터페이스를 구현하면 됨
public class TabMenu extends JPanel implements Runnable{
	double x;
	double y;
	int width;
	int height;
	double a = 0.01; // 비율계수
	int targetX; // 목표지점

	public TabMenu(Color color, double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		this.setBackground(color);
		this.setPreferredSize(new Dimension(width, height));
		this.setBounds((int)x, (int)y, width, height);

		// 마우스 이벤트 구현하기
		this.addMouseListener(new MouseAdapter() {
			// 마우스 올릴 떄
			@Override
			public void mouseEntered(MouseEvent e) {
				//TabMenu.this.setBounds(-5, y, width, height); // 내부익명에서 바깥쪽에 접근하지 못할 떄는 TabMenu.this로 접근 가능
				targetX=-5;
			}

			// 마우스 내릴 때
			@Override
			public void mouseExited(MouseEvent e) {
				//TabMenu.this.setBounds(-80, y, width, height);
				targetX=-80;
			}
		});
	}

	// 감속도 공식
	public void tick() {
		// x값=기존ㅌ+비율계수*(목표x-현재x)
		this.x = this.x + a * (targetX - this.x);
	}

	public void render() {
		this.setBounds((int)x, (int)y, width, height);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tick();
			render();
		}
		
	}
}
