package com.lec.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex02Frame extends JFrame implements ActionListener{
		
		private JPanel jPanel;
		private Container container;
		private JLabel jl;
		private ImageIcon icon;
		private JButton jbtn;
		private JTextField jtxtField;
		private Vector<String> item;
		private String[] items = {"A","B","C"};	// 체크박스에 들어갈 목록 설정 
		private JComboBox<String> jCombo;
		private JCheckBox jcheck;
		private JLabel jlBlank;
		private JButton jBtnExit;
		
		public Ex02Frame(String title) {  // 타이틀을 넣고 싶다면 ()안에 입력 후 super(title) 생성
				super(title);
				setDefaultCloseOperation(EXIT_ON_CLOSE); // x버튼 누르면 종료
				container = getContentPane();			 // 컨테이너 얻어오기
				container.setLayout(new FlowLayout());	 // layout setting
				//jPanel = (JPanel) getContentPane();		 // 컨테이너 얻어오기
				//jPanel.setLayout(new FlowLayout());        // 레이아웃 셋팅
				jl = new JLabel("Label");
				icon = new ImageIcon("icon/moomin.png");
				jbtn = new JButton("Button", icon);
				jtxtField = new JTextField(20);	// 20글자 정도 넣을 수 있는 가로 넓이의 textField 생성
				item = new Vector<String>(); 	// 콤보박스 안에 들어갈 리스트
				item.add("A");
				item.add("B");
				item.add("C");
				jCombo = new JComboBox<String>(item);	// vector로 생성
				//jCombo = new JComboBox<String>(items); 	// 배열로 생성
				jcheck = new JCheckBox("checkbox");
				jlBlank = new JLabel(); 
				jBtnExit = new JButton("Exit");
				
				// 컴포넌트 크기 조정
				jl.setPreferredSize(new Dimension(50,50));
				jbtn.setPreferredSize(new Dimension(200,50));
				jtxtField.setPreferredSize(new Dimension(300,50));
				jCombo.setPreferredSize(new Dimension(100,50));
				jcheck.setPreferredSize(new Dimension(100,50));
				jlBlank.setPreferredSize(new Dimension(200,50));
				jBtnExit.setPreferredSize(new Dimension(100,50));
				
				container.add(jl);
				container.add(jbtn);
				container.add(jtxtField);
				container.add(jCombo);
				container.add(jcheck);
				container.add(jlBlank);
				container.add(jBtnExit);
				
				setVisible(true);
				pack(); // 컴포넌트들이 배치될 수 있는 최소한의 화면 사이즈
				
				// 이벤트 리스너 추가
				jbtn.addActionListener(this);
				jCombo.addActionListener(this);
				jcheck.addActionListener(this);
				jBtnExit.addActionListener(this);
				
		}

		@Override
		public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jbtn) {
						String temp = jtxtField.getText().trim();
						if(!temp.equals("")) {
								// temp를 jlBlank에 넣고 jcombo 추가
								jlBlank.setText(temp);
								jCombo.addItem(temp);
								System.out.println(item); // 콤보박스에 추가
								jtxtField.setText("");
								String name = JOptionPane.showInputDialog("이름은? ");
								if(name!=null) { 
										jcheck.setText(name);
								}
						}
				} else if(e.getSource() == jCombo) {
						jlBlank.setText(jCombo.getSelectedItem().toString()); 
						
				} else if (e.getSource() == jcheck) {
						if(jcheck.isSelected()) { // 체크박스 체크 여부
								jlBlank.setText(jcheck.getText());
						} else {
								System.out.println("체크박스 언체크");
						}
				} else if (e.getSource() == jBtnExit) {
							setVisible(false);
							dispose();
							System.exit(0);
				}
			
		}
		public static void main(String[] args) {
				new Ex02Frame("");
		}
}














