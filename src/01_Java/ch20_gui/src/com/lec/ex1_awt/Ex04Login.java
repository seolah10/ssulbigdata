package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

// ppt 2�� �����̵�
public class Ex04Login extends Frame {
	
		private Panel panel;
		private TextField txtId, txtPw;
		private Button btnLogin;
		
		public Ex04Login(String title) {	// ��ü ����
				super(title);
				//setLayout(new BorderLayout()); // �⺻��
				panel = new Panel(new GridLayout(2, 2));
				//panel.setLayout(new GridLayout(2, 2));
				txtId = new TextField("ID", 20);
				txtPw = new TextField(20);
				txtPw.setEchoChar('*');
				btnLogin = new Button("�α���");
				
				panel.add(new Label("�α���"));
				panel.add(txtId);
				panel.add(new Label("��й�ȣ"));
				panel.add(txtPw);
				
				add(panel, BorderLayout.NORTH);
				add(btnLogin, BorderLayout.SOUTH);
				
				setSize(new Dimension(400, 200));
				//setLocation(0,0); // �⺻��
				setVisible(true);
		}
		public static void main(String[] args) {
				new Ex04Login("�α��� ����");
		}
		
}
