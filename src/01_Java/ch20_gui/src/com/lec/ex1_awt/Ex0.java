package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.border.Border;

public class Ex0 {
		
		public static void main(String[] args) {
				
				Frame frame = new Frame("title");
				Button btn = new Button("button");
				Button btn1 = new Button("�׳� button");
				
				frame.add(btn, BorderLayout.NORTH);
				frame.add(btn1, BorderLayout.CENTER);
				
				frame.setSize(new Dimension(300, 200));
				frame.setLocation(100, 50);
				frame.setVisible(true);
				
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					
				}
				frame.setVisible(false); // ȭ�鿡�� �Ⱥ��̰�
				frame.dispose();		 // �������� ��� �ڿ��� ����
				System.exit(0);		 // ���� ����
		}

}
