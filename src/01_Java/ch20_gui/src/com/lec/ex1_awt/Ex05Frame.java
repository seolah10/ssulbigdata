package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex05Frame extends Frame implements ActionListener {

			private Panel panel; 
			private TextField txtField;
			private Button btnOk;
			private Button btnExit;
			private List list;
			
			public Ex05Frame() {
				// layOut셋팅, 컴포넌트 생성 후 add, setVisble, setSize
				//setLayout(new BorderLayout()); // 기본값이므로 생략 가능
				panel = new Panel(); // panel은 FlowLayout이 기본값이므로 ()안에 아무것도 안써도 된다.0
				txtField = new TextField(20);
				btnOk = new Button("OK");
				btnExit = new Button("EXIT");
				list = new List();
				
				panel.add(new Label("write"));	// 패널 구성
				panel.add(txtField);
				panel.add(btnOk);
				panel.add(btnExit);
				
				add(panel, BorderLayout.NORTH);	// 자리 배치 
				add(list, BorderLayout.CENTER);
				
				setVisible(true);
				setSize(new Dimension(400, 200));
				
				btnOk.addActionListener(this);
				btnExit.addActionListener(this);
			}

			@Override
			public void actionPerformed(ActionEvent e) {
					if(e.getSource() == btnOk) {
						// txtField의 텍스트를 list로 추가하고 txtField는 ""
						list.add(txtField.getText());
						txtField.setText("");
					} else if (e.getSource() == btnExit) { 
						//종료
						setVisible(false);
						dispose();
						System.exit(0);
					}
				
			}
			public static void main(String[] args) {
					new Ex05Frame();
			}
}















