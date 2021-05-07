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
				// layOut����, ������Ʈ ���� �� add, setVisble, setSize
				//setLayout(new BorderLayout()); // �⺻���̹Ƿ� ���� ����
				panel = new Panel(); // panel�� FlowLayout�� �⺻���̹Ƿ� ()�ȿ� �ƹ��͵� �Ƚᵵ �ȴ�.0
				txtField = new TextField(20);
				btnOk = new Button("OK");
				btnExit = new Button("EXIT");
				list = new List();
				
				panel.add(new Label("write"));	// �г� ����
				panel.add(txtField);
				panel.add(btnOk);
				panel.add(btnExit);
				
				add(panel, BorderLayout.NORTH);	// �ڸ� ��ġ 
				add(list, BorderLayout.CENTER);
				
				setVisible(true);
				setSize(new Dimension(400, 200));
				
				btnOk.addActionListener(this);
				btnExit.addActionListener(this);
			}

			@Override
			public void actionPerformed(ActionEvent e) {
					if(e.getSource() == btnOk) {
						// txtField�� �ؽ�Ʈ�� list�� �߰��ϰ� txtField�� ""
						list.add(txtField.getText());
						txtField.setText("");
					} else if (e.getSource() == btnExit) { 
						//����
						setVisible(false);
						dispose();
						System.exit(0);
					}
				
			}
			public static void main(String[] args) {
					new Ex05Frame();
			}
}















