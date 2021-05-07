package com.lec.ex2_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex01Frame extends JFrame implements ActionListener{

		private JPanel panel;
		private JLabel jlbl;
		private JButton btn;
		
		public Ex01Frame(String title) {
				super(title);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				// 스윙은 컨테이너(프레임)를 먼저 얻어온다.
				panel = (JPanel) getContentPane();
				panel.setLayout(new FlowLayout());
				
				jlbl = new JLabel("goodbye2020", (int) CENTER_ALIGNMENT);
				jlbl.setPreferredSize(new Dimension(150, 200));
				btn = new JButton("종료");
				btn.setPreferredSize(new Dimension(200,200));
				
				panel.add(jlbl);
				panel.add(btn);
				
				setVisible(true);
				//pack(); // 최소한의 사이즈 셋팅
				setSize(new Dimension(500,300));
				
				btn.addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent e) { 
				if(e.getSource() == btn) {
						setVisible(false);
						dispose();
						System.exit(0);
				}
		
		}
		public static void main(String[] args) {
				new Ex01Frame("첫 스윙예제");
		}
		
	

}











