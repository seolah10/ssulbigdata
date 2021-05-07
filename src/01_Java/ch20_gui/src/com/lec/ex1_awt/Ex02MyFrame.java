package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02MyFrame extends Frame implements ActionListener {
	
		private Label lbl1;	 	// 추가할 컴포넌트(프레임)변수들 선언
		private Button btnExit;
		
		public Ex02MyFrame() {
			// 프레임에 라벨과 버튼 추가후 setVisible과 setSize
			// 프레임의 layout 스타일을 flowLayout()으로 - add순서대로 차곡차곡
			setLayout(new FlowLayout());
			//setLayout(new BorderLayout()); --기본
			//setLayout(new GridLayout(2,2)); -- 2행 2열짜리 격자 layout
			
			lbl1 = new Label("즐거운 월요일");
			lbl1.setPreferredSize(new Dimension(150, 200));	 // 컴포넌트 사이즈
			btnExit = new Button("종료");
			btnExit.setPreferredSize(new Dimension(200, 200));
			
			add(lbl1);
			add(btnExit);
			
			setVisible(true);
			setSize(new Dimension(500, 300));
			setLocation(100, 100); // 따로 설정하지  않으면 왼쪽 맨 위에 가서 붙는다.
			
			// btnExit 클릭이벤트 발생되면 this.actionPerformed(btnExit)호출
			btnExit.addActionListener(this); // frame이 떠있을 때까지 계속 listening
			
			addWindowListener(new WindowAdapter() { // X버튼 누르면 종료되도록 설정 
					@Override
					public void windowClosing(WindowEvent e) {
							setVisible(false);
							dispose();
							System.exit(0);
					}
				
			});
			
		}
		public Ex02MyFrame(String title) {
				this();
				setTitle(title);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
				// btnExit 클릭이벤트 발생되면 this.actionPerformed(btnExit)호출
				if(e.getSource() == btnExit) {
						setVisible(false);
						dispose();
						System.exit(0);
				}
			
		}
		public static void main(String[] args) {
				new Ex02MyFrame("두번째 GUI 예제");
		}	
		

}
