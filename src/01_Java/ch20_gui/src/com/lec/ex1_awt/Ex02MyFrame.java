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
	
		private Label lbl1;	 	// �߰��� ������Ʈ(������)������ ����
		private Button btnExit;
		
		public Ex02MyFrame() {
			// �����ӿ� �󺧰� ��ư �߰��� setVisible�� setSize
			// �������� layout ��Ÿ���� flowLayout()���� - add������� ��������
			setLayout(new FlowLayout());
			//setLayout(new BorderLayout()); --�⺻
			//setLayout(new GridLayout(2,2)); -- 2�� 2��¥�� ���� layout
			
			lbl1 = new Label("��ſ� ������");
			lbl1.setPreferredSize(new Dimension(150, 200));	 // ������Ʈ ������
			btnExit = new Button("����");
			btnExit.setPreferredSize(new Dimension(200, 200));
			
			add(lbl1);
			add(btnExit);
			
			setVisible(true);
			setSize(new Dimension(500, 300));
			setLocation(100, 100); // ���� ��������  ������ ���� �� ���� ���� �ٴ´�.
			
			// btnExit Ŭ���̺�Ʈ �߻��Ǹ� this.actionPerformed(btnExit)ȣ��
			btnExit.addActionListener(this); // frame�� ������ ������ ��� listening
			
			addWindowListener(new WindowAdapter() { // X��ư ������ ����ǵ��� ���� 
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
				// btnExit Ŭ���̺�Ʈ �߻��Ǹ� this.actionPerformed(btnExit)ȣ��
				if(e.getSource() == btnExit) {
						setVisible(false);
						dispose();
						System.exit(0);
				}
			
		}
		public static void main(String[] args) {
				new Ex02MyFrame("�ι�° GUI ����");
		}	
		

}
