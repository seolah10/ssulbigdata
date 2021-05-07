package com.lec.ex1_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class Ex03Login extends Frame {
		
		private Label lbl1;
		private TextField txtId;
		private Label lbl2;
		private TextField txtPw;
		private Button btnLogin;
		
		public Ex03Login(String title) {
				super(title);
				setLayout(new FlowLayout()); // frame의 layout setting
				lbl1 = new Label("아 이 디");
				txtId = new TextField("ID",20);
				lbl2 = new Label("비밀번호");
				txtPw = new TextField(20);
				txtPw.setEchoChar('*');		// 입력한 것이 그대로 보이지 않고 *로 처리되도록 설정
				btnLogin = new Button("로그인");
				
				add(lbl1);
				add(txtId);
				add(lbl2);
				add(txtPw);
				add(btnLogin);
				
				setSize(new Dimension(300, 150));
				setResizable(false); // 사용자가 frame 크기 조정 불가
				setLocation(100, 100);
				setVisible(true);
		}
		
		public static void main(String[] args) {
				new Ex03Login("로그인 화면");
		}
}
