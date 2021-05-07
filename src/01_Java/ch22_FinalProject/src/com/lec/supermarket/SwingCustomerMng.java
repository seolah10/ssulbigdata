package com.lec.supermarket;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingCustomerMng extends JFrame implements ActionListener {
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField txtCId, txtCTel, txtCName, txtCPoint, txtCAmount;
	private Vector<String> levelNames;
	private JComboBox<String> comLevelName;
	private JButton btnCIdSearch, btnCTelSearch, btnCNameSearch, btnBuyWithPoint;
	private JButton btnBuy, btnLevelNameOutput, btnAllOutput, 
					btnInsert, btnCTelUpdate, btnDelete, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	CustomerDao dao = CustomerDao.getInstance();
	
	public SwingCustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		container = getContentPane();
		container.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(6,3));
		jpbtn = new JPanel();
		
		txtCId = new JTextField(20);
		txtCTel = new JTextField(20);
		txtCName = new JTextField(20);
		txtCPoint = new JTextField(20);
		txtCAmount = new JTextField(20);
		
		levelNames = dao.getLevelNames();
		comLevelName = new JComboBox<String>(levelNames);
		
		btnCIdSearch = new JButton("아이디 검색");
		btnCTelSearch = new JButton("폰 번호(4자리 or 전체) 검색");
		btnCNameSearch = new JButton("고객명 검색");
		btnBuyWithPoint = new JButton("포인트로 구매");
		
		jpup.add(new JLabel("아 이 디", (int) CENTER_ALIGNMENT));
		jpup.add(txtCId);
		jpup.add(btnCIdSearch);
		jpup.add(new JLabel("고 객 전 화", (int) CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);
		jpup.add(new JLabel("고 객 이 름", (int) CENTER_ALIGNMENT));
		jpup.add(txtCName) ;
		jpup.add(btnCNameSearch);
		jpup.add(new JLabel("포 인 트", (int) CENTER_ALIGNMENT));
		jpup.add(txtCPoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("구 매 금 액", (int) CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel(""));
		jpup.add(new JLabel("고 객 등 급", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		
		btnBuy = new JButton("물품 구매");
		btnLevelNameOutput = new JButton("등급별출력");
		btnAllOutput = new JButton("전체출력");
		btnInsert = new JButton("회원가입");
		btnCTelUpdate = new JButton("번호수정");
		btnDelete = new JButton("회원탈퇴");
		btnExit = new JButton("나가기");
		
		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOutput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCTelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);
		
		txtPool = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);
		
		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);
		
		setSize(new Dimension(800, 400));
		setLocation(200, 200);
		setVisible(true);
		
		txtPool.setText("\t 고객을 검색한 후 구매하세요.");
		
		btnCIdSearch.addActionListener(this);
		btnCTelSearch.addActionListener(this);
		btnCNameSearch.addActionListener(this);
		btnBuyWithPoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLevelNameOutput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCTelUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCIdSearch) { // 아이디검색 
			int cId = 0;
			
			try { 
				cId = Integer.parseInt(txtCId.getText().trim());
			} catch (NumberFormatException e1) {
				txtPool.setText("유효한 아이디가 아닙니다.");
				return;
			}
			CustomerDto customer = dao.cIdGetCustomer(cId);
			
			if(customer!=null) {
				txtPool.setText("ID\t전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업까지 구매할 금액\n");
				txtPool.append("────────────────────────────────────────────────────────\n");
				txtPool.append(customer.toString()+"\n");
				txtCTel.setText(customer.getcTel());
				txtCName.setText(customer.getcName());
				txtCPoint.setText(String.valueOf(customer.getcPoint()));
				txtCAmount.setText("");
				comLevelName.setSelectedItem(customer.getLevelName());				
			} else {
				txtPool.setText("ID를 찾을 수 없습니다.");
			}
		} else if(e.getSource()==btnCTelSearch) { // 폰번호로 검색 
			String cTel = txtCTel.getText().trim();
			
			if(cTel.length()<4) {
				txtPool.setText("4자리 이상의 수를 입력해주세요.");
				return;
			}
			ArrayList<CustomerDto> customers = dao.cTelGetCustomer(cTel);
			
			if(customers.size()>=1) { 
				txtPool.setText("ID\t전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업까지 구매할 금액\n");
				txtPool.append("────────────────────────────────────────────────────────\n");
				for(CustomerDto customer : customers) { 
					txtPool.append(customer.toString()+"\n");
					txtCId.setText(String.valueOf(customer.getcId()));
					txtCTel.setText(customer.getcTel());
					txtCName.setText(customer.getcName());
					txtCPoint.setText(String.valueOf(customer.getcPoint()));
					txtCAmount.setText("");
					comLevelName.setSelectedItem(customer.getLevelName());				
				}				
			} else {
				txtPool.setText("해당 번호의 고객을 찾을 수 없습니다.");
				txtCId.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				comLevelName.setSelectedIndex(0);
			}
		} else if (e.getSource()==btnCNameSearch) { // 고객이름 검색 
			String cName = txtCName.getText().trim();
			
			if(cName.length()==0) {
				txtPool.setText("고객이름을 입력 후 검색해주세요.");
			}
			ArrayList<CustomerDto> customers = dao.cNameGetCustomer(cName);
			
			if(customers.size()>=1) {
				txtPool.setText("ID\t전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업까지 구매할 금액\n");
				txtPool.append("────────────────────────────────────────────────────────\n");
				for(CustomerDto customer : customers) { 
					txtPool.append(customer.toString()+"\n");
					txtCId.setText(String.valueOf(customer.getcId()));
					txtCTel.setText(customer.getcTel());
					txtCPoint.setText(String.valueOf(customer.getcPoint()));
					txtCAmount.setText("");
					comLevelName.setSelectedItem(customer.getLevelName());	
				}
			} else { 
				txtPool.setText("해당 이름의 고객을 찾을 수 없습니다.");
				txtCId.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				comLevelName.setSelectedIndex(0);
			}
		} else if(e.getSource()==btnBuyWithPoint) { // 포인트로 고매
			int cId=0, cAmount = 0, cPoint = 0;
			
			try { 
				cId = Integer.parseInt(txtCId.getText().trim());
				cAmount = Integer.parseInt(txtCAmount.getText().trim());
				cPoint = Integer.parseInt(txtCPoint.getText().trim());
				if(cPoint>cAmount) {
					txtPool.setText("포인트가 부족하여 구매가 불가능합니다.");
					return;
				}
			} catch (NumberFormatException e1) {
				txtPool.setText("유효한 아이디와 구매금액을 입력해주시고, 유효한 포인트로 입력하세요.");
				return;
			}
			int result = dao.buyWithPoint(cAmount, cId);
			
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("포인트 구매 성공");
				txtCPoint.setText(String.valueOf(cPoint-cAmount));
				txtCAmount.setText("");
			} else {
				txtPool.setText("아이디가 유효하지 않습니다.");
			}
		} else if(e.getSource()==btnBuy) { // 물품 구매 
			int cId=0, cAmount = 0, cPoint = 0;
			
			try { 
				cId = Integer.parseInt(txtCId.getText().trim());
				cAmount = Integer.parseInt(txtCAmount.getText().trim());
				cPoint = Integer.parseInt(txtCPoint.getText().trim());
				if(cPoint>cAmount) {
					txtPool.setText("포인트가 부족하여 구매가 불가능합니다.");
					return;
				}
			} catch (NumberFormatException e1) {
				txtPool.setText("유효한 아이디와 구매금액을 입력해주시고, 유효한 포인트로 입력하세요.");
				return;
			}
			int result = dao.buy(cAmount, cId);
			
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("물품 구매 및 레벨 조정 성공");
				txtCPoint.setText(String.valueOf((int)(cPoint-cAmount*0.05)));
				txtCAmount.setText("");
			} else {
				txtPool.setText("아이디가 유효하지 않습니다.");
			}
		} else if(e.getSource()==btnLevelNameOutput) { // 등급별 출력 
			txtCId.setText("");
			txtCTel.setText("");
			txtCName.setText("");
			txtCPoint.setText("");
			String levelName = comLevelName.getSelectedItem().toString();
			if(levelName.equals("")) {
				txtPool.setText("등급을 선택해주세요.");
				return;
			}
			ArrayList<CustomerDto> customers = dao.levelNameGetCustomers(levelName);
			
			if(customers.size()!=0) {
				txtPool.setText("ID\t전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업까지 구매할 금액\n");
				txtPool.append("────────────────────────────────────────────────────────\n");
				for (CustomerDto customer : customers) { 
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("총" + customers.size() + "명");
			} else { 
				txtPool.setText("해당 레벨의 고객이 존재하지 않습니다.");
			}
		} else if(e.getSource()==btnInsert) { // 회원가입
			txtCId.setText("");
			txtCAmount.setText("");
			String cTel = txtCTel.getText().trim();
			String cName = txtCName.getText().trim();
			
			if(cTel.equals("") || cName.equals("")) {
				txtPool.setText("전화번호와 이름을 입력해주세요.");
				return;
			}
			int result = dao.insertCustomer(cTel, cName);
			
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("가입해주셔서 감사합니다. 포인트 1000점을 선물로 드립니다.");
				txtCPoint.setText("1000");
				comLevelName.setSelectedIndex(1);
			}
		} else if(e.getSource()==btnCTelUpdate) { // 번호 수정
			int cId = 0;
			String cTel;
			
			try { 
				cId = Integer.parseInt(txtCId.getText().trim());
				cTel = txtCTel.getText().trim();
				if(cTel.equals("")) {
					txtPool.setText("변경할 번호를 입력해주세요.");
					return;
				}
			} catch (NumberFormatException e1) {
				txtPool.setText("유효한 아이디를 입력해주세요.");
				return;
			}
			int result = dao.updateCustomer(cTel, cId);
			if(result==CustomerDao.SUCCESS) { 
				txtPool.setText("전화번호가 수정되었습니다.");			
			} else {
				txtPool.setText("유효한 아이디를 검색후 변경해주세요.");
			}
		} else if(e.getSource()==btnDelete) { // 회원 탈퇴
			String cId = txtCId.getText().trim();
			if(cId.equals("")) { 
				txtPool.setText("아이디를 입력해주세요.");
				return;
			}
			int result = dao.deleteCustomer(cId);
			
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText(cId + "님의 회원 탈퇴가 완료되었습니다.");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				comLevelName.setSelectedIndex(0);
			} else {
				txtPool.setText("유효한 아이디가 아닙니다. 다시 입력해주세요.");
			}
		} else if(e.getSource()==btnExit) { // 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new SwingCustomerMng("슈퍼마켓 관리");
	}
}
