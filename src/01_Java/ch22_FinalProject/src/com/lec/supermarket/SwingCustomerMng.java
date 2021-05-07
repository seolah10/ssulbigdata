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
		
		btnCIdSearch = new JButton("���̵� �˻�");
		btnCTelSearch = new JButton("�� ��ȣ(4�ڸ� or ��ü) �˻�");
		btnCNameSearch = new JButton("���� �˻�");
		btnBuyWithPoint = new JButton("����Ʈ�� ����");
		
		jpup.add(new JLabel("�� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtCId);
		jpup.add(btnCIdSearch);
		jpup.add(new JLabel("�� �� �� ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);
		jpup.add(new JLabel("�� �� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtCName) ;
		jpup.add(btnCNameSearch);
		jpup.add(new JLabel("�� �� Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCPoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("�� �� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel(""));
		jpup.add(new JLabel("�� �� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		
		btnBuy = new JButton("��ǰ ����");
		btnLevelNameOutput = new JButton("��޺����");
		btnAllOutput = new JButton("��ü���");
		btnInsert = new JButton("ȸ������");
		btnCTelUpdate = new JButton("��ȣ����");
		btnDelete = new JButton("ȸ��Ż��");
		btnExit = new JButton("������");
		
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
		
		txtPool.setText("\t ���� �˻��� �� �����ϼ���.");
		
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
		if(e.getSource()==btnCIdSearch) { // ���̵�˻� 
			int cId = 0;
			
			try { 
				cId = Integer.parseInt(txtCId.getText().trim());
			} catch (NumberFormatException e1) {
				txtPool.setText("��ȿ�� ���̵� �ƴմϴ�.");
				return;
			}
			CustomerDto customer = dao.cIdGetCustomer(cId);
			
			if(customer!=null) {
				txtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t���������� ������ �ݾ�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������\n");
				txtPool.append(customer.toString()+"\n");
				txtCTel.setText(customer.getcTel());
				txtCName.setText(customer.getcName());
				txtCPoint.setText(String.valueOf(customer.getcPoint()));
				txtCAmount.setText("");
				comLevelName.setSelectedItem(customer.getLevelName());				
			} else {
				txtPool.setText("ID�� ã�� �� �����ϴ�.");
			}
		} else if(e.getSource()==btnCTelSearch) { // ����ȣ�� �˻� 
			String cTel = txtCTel.getText().trim();
			
			if(cTel.length()<4) {
				txtPool.setText("4�ڸ� �̻��� ���� �Է����ּ���.");
				return;
			}
			ArrayList<CustomerDto> customers = dao.cTelGetCustomer(cTel);
			
			if(customers.size()>=1) { 
				txtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t���������� ������ �ݾ�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������\n");
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
				txtPool.setText("�ش� ��ȣ�� ���� ã�� �� �����ϴ�.");
				txtCId.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				comLevelName.setSelectedIndex(0);
			}
		} else if (e.getSource()==btnCNameSearch) { // ���̸� �˻� 
			String cName = txtCName.getText().trim();
			
			if(cName.length()==0) {
				txtPool.setText("���̸��� �Է� �� �˻����ּ���.");
			}
			ArrayList<CustomerDto> customers = dao.cNameGetCustomer(cName);
			
			if(customers.size()>=1) {
				txtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t���������� ������ �ݾ�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������\n");
				for(CustomerDto customer : customers) { 
					txtPool.append(customer.toString()+"\n");
					txtCId.setText(String.valueOf(customer.getcId()));
					txtCTel.setText(customer.getcTel());
					txtCPoint.setText(String.valueOf(customer.getcPoint()));
					txtCAmount.setText("");
					comLevelName.setSelectedItem(customer.getLevelName());	
				}
			} else { 
				txtPool.setText("�ش� �̸��� ���� ã�� �� �����ϴ�.");
				txtCId.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				comLevelName.setSelectedIndex(0);
			}
		} else if(e.getSource()==btnBuyWithPoint) { // ����Ʈ�� ���
			int cId=0, cAmount = 0, cPoint = 0;
			
			try { 
				cId = Integer.parseInt(txtCId.getText().trim());
				cAmount = Integer.parseInt(txtCAmount.getText().trim());
				cPoint = Integer.parseInt(txtCPoint.getText().trim());
				if(cPoint>cAmount) {
					txtPool.setText("����Ʈ�� �����Ͽ� ���Ű� �Ұ����մϴ�.");
					return;
				}
			} catch (NumberFormatException e1) {
				txtPool.setText("��ȿ�� ���̵�� ���űݾ��� �Է����ֽð�, ��ȿ�� ����Ʈ�� �Է��ϼ���.");
				return;
			}
			int result = dao.buyWithPoint(cAmount, cId);
			
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("����Ʈ ���� ����");
				txtCPoint.setText(String.valueOf(cPoint-cAmount));
				txtCAmount.setText("");
			} else {
				txtPool.setText("���̵� ��ȿ���� �ʽ��ϴ�.");
			}
		} else if(e.getSource()==btnBuy) { // ��ǰ ���� 
			int cId=0, cAmount = 0, cPoint = 0;
			
			try { 
				cId = Integer.parseInt(txtCId.getText().trim());
				cAmount = Integer.parseInt(txtCAmount.getText().trim());
				cPoint = Integer.parseInt(txtCPoint.getText().trim());
				if(cPoint>cAmount) {
					txtPool.setText("����Ʈ�� �����Ͽ� ���Ű� �Ұ����մϴ�.");
					return;
				}
			} catch (NumberFormatException e1) {
				txtPool.setText("��ȿ�� ���̵�� ���űݾ��� �Է����ֽð�, ��ȿ�� ����Ʈ�� �Է��ϼ���.");
				return;
			}
			int result = dao.buy(cAmount, cId);
			
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("��ǰ ���� �� ���� ���� ����");
				txtCPoint.setText(String.valueOf((int)(cPoint-cAmount*0.05)));
				txtCAmount.setText("");
			} else {
				txtPool.setText("���̵� ��ȿ���� �ʽ��ϴ�.");
			}
		} else if(e.getSource()==btnLevelNameOutput) { // ��޺� ��� 
			txtCId.setText("");
			txtCTel.setText("");
			txtCName.setText("");
			txtCPoint.setText("");
			String levelName = comLevelName.getSelectedItem().toString();
			if(levelName.equals("")) {
				txtPool.setText("����� �������ּ���.");
				return;
			}
			ArrayList<CustomerDto> customers = dao.levelNameGetCustomers(levelName);
			
			if(customers.size()!=0) {
				txtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t���������� ������ �ݾ�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDto customer : customers) { 
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("��" + customers.size() + "��");
			} else { 
				txtPool.setText("�ش� ������ ���� �������� �ʽ��ϴ�.");
			}
		} else if(e.getSource()==btnInsert) { // ȸ������
			txtCId.setText("");
			txtCAmount.setText("");
			String cTel = txtCTel.getText().trim();
			String cName = txtCName.getText().trim();
			
			if(cTel.equals("") || cName.equals("")) {
				txtPool.setText("��ȭ��ȣ�� �̸��� �Է����ּ���.");
				return;
			}
			int result = dao.insertCustomer(cTel, cName);
			
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("�������ּż� �����մϴ�. ����Ʈ 1000���� ������ �帳�ϴ�.");
				txtCPoint.setText("1000");
				comLevelName.setSelectedIndex(1);
			}
		} else if(e.getSource()==btnCTelUpdate) { // ��ȣ ����
			int cId = 0;
			String cTel;
			
			try { 
				cId = Integer.parseInt(txtCId.getText().trim());
				cTel = txtCTel.getText().trim();
				if(cTel.equals("")) {
					txtPool.setText("������ ��ȣ�� �Է����ּ���.");
					return;
				}
			} catch (NumberFormatException e1) {
				txtPool.setText("��ȿ�� ���̵� �Է����ּ���.");
				return;
			}
			int result = dao.updateCustomer(cTel, cId);
			if(result==CustomerDao.SUCCESS) { 
				txtPool.setText("��ȭ��ȣ�� �����Ǿ����ϴ�.");			
			} else {
				txtPool.setText("��ȿ�� ���̵� �˻��� �������ּ���.");
			}
		} else if(e.getSource()==btnDelete) { // ȸ�� Ż��
			String cId = txtCId.getText().trim();
			if(cId.equals("")) { 
				txtPool.setText("���̵� �Է����ּ���.");
				return;
			}
			int result = dao.deleteCustomer(cId);
			
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText(cId + "���� ȸ�� Ż�� �Ϸ�Ǿ����ϴ�.");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				comLevelName.setSelectedIndex(0);
			} else {
				txtPool.setText("��ȿ�� ���̵� �ƴմϴ�. �ٽ� �Է����ּ���.");
			}
		} else if(e.getSource()==btnExit) { // ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new SwingCustomerMng("���۸��� ����");
	}
}
