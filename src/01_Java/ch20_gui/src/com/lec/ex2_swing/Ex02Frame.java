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
		private String[] items = {"A","B","C"};	// üũ�ڽ��� �� ��� ���� 
		private JComboBox<String> jCombo;
		private JCheckBox jcheck;
		private JLabel jlBlank;
		private JButton jBtnExit;
		
		public Ex02Frame(String title) {  // Ÿ��Ʋ�� �ְ� �ʹٸ� ()�ȿ� �Է� �� super(title) ����
				super(title);
				setDefaultCloseOperation(EXIT_ON_CLOSE); // x��ư ������ ����
				container = getContentPane();			 // �����̳� ������
				container.setLayout(new FlowLayout());	 // layout setting
				//jPanel = (JPanel) getContentPane();		 // �����̳� ������
				//jPanel.setLayout(new FlowLayout());        // ���̾ƿ� ����
				jl = new JLabel("Label");
				icon = new ImageIcon("icon/moomin.png");
				jbtn = new JButton("Button", icon);
				jtxtField = new JTextField(20);	// 20���� ���� ���� �� �ִ� ���� ������ textField ����
				item = new Vector<String>(); 	// �޺��ڽ� �ȿ� �� ����Ʈ
				item.add("A");
				item.add("B");
				item.add("C");
				jCombo = new JComboBox<String>(item);	// vector�� ����
				//jCombo = new JComboBox<String>(items); 	// �迭�� ����
				jcheck = new JCheckBox("checkbox");
				jlBlank = new JLabel(); 
				jBtnExit = new JButton("Exit");
				
				// ������Ʈ ũ�� ����
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
				pack(); // ������Ʈ���� ��ġ�� �� �ִ� �ּ����� ȭ�� ������
				
				// �̺�Ʈ ������ �߰�
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
								// temp�� jlBlank�� �ְ� jcombo �߰�
								jlBlank.setText(temp);
								jCombo.addItem(temp);
								System.out.println(item); // �޺��ڽ��� �߰�
								jtxtField.setText("");
								String name = JOptionPane.showInputDialog("�̸���? ");
								if(name!=null) { 
										jcheck.setText(name);
								}
						}
				} else if(e.getSource() == jCombo) {
						jlBlank.setText(jCombo.getSelectedItem().toString()); 
						
				} else if (e.getSource() == jcheck) {
						if(jcheck.isSelected()) { // üũ�ڽ� üũ ����
								jlBlank.setText(jcheck.getText());
						} else {
								System.out.println("üũ�ڽ� ��üũ");
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














