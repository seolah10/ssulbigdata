package com.lec.homework;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HomeworkArrayList extends JFrame implements ActionListener {
	private Container contenPane;
	private	JPanel jpup, jpdown;
	private JTextField txtPhone,  txtName, txtPoint;
	private JTextArea jta;
	private JScrollPane scrollbar;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;

	private ArrayList<Customer> customers;
	public HomeworkArrayList(String title) {
		super(title);
		customers = new ArrayList<Customer>();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane(); // 컨테이너 얻어오기
		contenPane.setLayout(new FlowLayout());
		
		jpup = new JPanel();
		jpup.setLayout(new GridLayout(3,2));
		jpdown = new JPanel();
		jpdown.setLayout(new FlowLayout());
	
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField("1000", 15);
		
		jta = new JTextArea(15,30);
		scrollbar = new JScrollPane(jta);
		
		btnJoin = new JButton("가입");
		btnSearch = new JButton("폰조회");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");
		
		jpup.add(new JLabel("폰번호", (int)CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("이 름", (int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("폰번호", (int)CENTER_ALIGNMENT));
		jpup.add(txtPoint);		
		
		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);
		
		contenPane.add(jpup);
		contenPane.add(jpdown);
		contenPane.add(scrollbar);
		
		setBounds(300, 300, 400, 450);
		setResizable(false);
		setVisible(true);
		
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	}
	public HomeworkArrayList() {
		this("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnJoin) {
			// customers에 put하고 jta에 출력후 textField지우기
			String phone, name;
			int point = 1000;
			phone = txtPhone.getText().trim();
			name = txtName.getText().trim();
			
			try {
				point = Integer.parseInt(txtPhone.getText());
			}catch (Exception e1) {
				
			}
			int preIdx = phone.indexOf("-");
			int postIdx = phone.lastIndexOf("-");
			if(!phone.trim().equals("") && !name.trim().equals("") && 
					preIdx < postIdx) {
				// 가입 
				Customer newCustomer = new Customer(phone, name, point);
				customers.add(newCustomer); // customer에 put
				System.out.println(newCustomer + "가입 성공");
				
				jta.append(newCustomer.toString() + "\r\n");
				//jta.setText(jta.getText()+newCustomer.toString()+"\r\n");
				
				txtPhone.setText("");
				txtName.setText("");
				txtPoint.setText("1000");
			}
							
		}else if (e.getSource() == btnSearch) {
			// 폰뒷4자리조회. 조회되면 textField에 뿌리기. 없는 번호면 없는 번호라고 뿌리기
			String searchPhone = txtPhone.getText().trim();
			int idx;
			for(idx=0; idx<customers.size(); idx++) {
				String phone = customers.get(idx).getPhone();
				String postPhone = phone.substring(phone.lastIndexOf('-')+1);
				
				if(postPhone.equals(searchPhone)) {
					txtPhone.setText(customers.get(idx).getPhone());
					txtName.setText(customers.get(idx).getName());
					//숫자 point를 문자로 바꿔 jtxtPoint에 넣음
					//txtPoint.setText(""+customers.get(idx).getPoint());
					txtPoint.setText(String.valueOf(customers.get(idx).getPoint()));
					break; // 번호 찾았으면 빠져나가기 
				}
			}
			if(idx == customers.size()) {
				txtPhone.setText("없는 회원님");
				txtName.setText("");
				txtPoint.setText("1000");
			}
		}else if (e.getSource() == btnOutput) {
			// 1. OutputStream 이용	
			OutputStream os = null;
			try {
				os = new FileOutputStream("src/com/lec/homework/customer1.txt", true);
				String fileOutputResult = "";
				for(Customer customer : customers) {
					System.out.println(customer);
					fileOutputResult += customer.toString()+"\r\n";
				}
				os.write(fileOutputResult.getBytes());				
			} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());	
			} catch (IOException e1){
				System.out.println(e1.getMessage());
			} finally {
				try {
					if(os!=null)
						os.close();
				} catch (Exception e1){
					
				}
			}			
			// 2. writer 이용 
			Writer writer = null;
			try { 
				writer = new FileWriter("src/com/lec/homework/customer2.txt", true);
				for(Customer customer : customers) {
					// System.out.println(customer);
					writer.write(customer.toString()+"\r\n");
				}
			} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			} finally {
				try {
					if(writer!=null)
						writer.close();
				} catch(Exception e1) {
					
				}
			}
			// 3. PrintWriter 보조 스트림 이용
			os = null; 
			PrintWriter printwriter = null;
			
			try { 
				os = new FileOutputStream("src/com/lec/homework/customer3.txt", true);
				printwriter = new PrintWriter(os);
				for(Customer customer : customers) {
					// System.out.println(customer);
					printwriter.write(customer.toString());
				}
			} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
			
			} finally {
				try {
					if(printwriter !=null)
						printwriter.close();
					if(os!=null)
						os.close();
				} catch(Exception e1) {					

				}
			}
		}else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		new HomeworkArrayList("회원관리");
	}
}
