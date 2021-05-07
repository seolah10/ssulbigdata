package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

// ppt 2번 슬라이드
public class Ex04Login extends Frame {
	
		private Panel panel;
		private TextField txtId, txtPw;
		private Button btnLogin;
		
		public Ex04Login(String title) {	// 객체 생성
				super(title);
				//setLayout(new BorderLayout()); // 기본값
				panel = new Panel(new GridLayout(2, 2));
				//panel.setLayout(new GridLayout(2, 2));
				txtId = new TextField("ID", 20);
				txtPw = new TextField(20);
				txtPw.setEchoChar('*');
				btnLogin = new Button("로그인");
				
				panel.add(new Label("로그인"));
				panel.add(txtId);
				panel.add(new Label("비밀번호"));
				panel.add(txtPw);
				
				add(panel, BorderLayout.NORTH);
				add(btnLogin, BorderLayout.SOUTH);
				
				setSize(new Dimension(400, 200));
				//setLocation(0,0); // 기본값
				setVisible(true);
		}
		public static void main(String[] args) {
				new Ex04Login("로그인 예제");
		}
		
}
