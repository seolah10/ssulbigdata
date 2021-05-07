package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScissorRockPaper extends Frame implements ActionListener {

		private Panel panel;
		private Button btn0, btn1, btn2, btnExit, btnRemove;
		private List list;
		
		public ScissorRockPaper(String title) {
				super(title);
				setLayout(new BorderLayout());
				panel = new Panel(new FlowLayout());				
				btn0 = new Button("가위");
				btn1 = new Button("바위");
				btn2 = new Button("보");
				btnRemove = new Button("지우기");
				btnExit = new Button("종료");
				list = new List(5); 
				
				panel.add(btn0);
				panel.add(btn1);
				panel.add(btn2);
				panel.add(btnRemove);
				
				add(panel, BorderLayout.NORTH);
				add(list, BorderLayout.CENTER);
				add(btnExit, BorderLayout.SOUTH);
				
				setSize(new Dimension(300, 200));
				setVisible(true);
				
				addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
								setVisible(false);
								dispose();
								System.exit(0);
						}
				});
				btn0.addActionListener(this);
				btn1.addActionListener(this);
				btn2.addActionListener(this);
				btnRemove.addActionListener(this);
				btnExit.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
				int computer = (int)(Math.random()*3); // 가위(0), 바위(1), 보(2)
				
				if(e.getSource() == btn0) { // 가위 
						switch(computer) {
						
						case 0: 
								list.add("비김. 우리 다 가위");					break;
						case 1: 
								list.add("컴퓨터가 이김. 당신은 가위, 컴퓨터는 바위");	 break;
						case 2: 
								list.add("당신이 이김. 당신은 가위, 컴퓨터는 보");	 break;
						}
						
				} else if (e.getSource() == btn1) { // 바위
						switch(computer) {
						
						case 0: 
							
								list.add("당신이 이김. 당신은 바위, 컴퓨터는 가위"); break;
						case 1: 
								list.add("비김. 우리 다 바위");	 break;
						case 2: 
								list.add("당신이 짐. 당신은 바위, 컴퓨터는 보");	 break;
						}
				} else if (e.getSource() == btn2) { // 보
						switch(computer) {
						
						case 0: 
								list.add("당신이 짐. 당신은 보. 컴퓨터는 가위");		break;
						case 1: 
								list.add("당신이 이김. 당신은 보, 컴퓨터는 바위");	 break;
						case 2: 
								list.add("비김. 우리 다 보");	 break;
						}
				} else if (e.getSource() == btnExit) { // 종료
						setVisible(false);
						dispose();
						System.exit(0);
				} else if (e.getSource() == btnRemove) { 
						list.removeAll();
				}
		}
		public static void main(String[] args) {
				new ScissorRockPaper("가위 바위 보!");
		}
}









