package com.lec.StudentGUI;

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

public class SwingStudentMng extends JFrame implements ActionListener {
	private Container contentPane;
	private JPanel jpup, jpbtn;
	private JTextField txtSno, txtSname, txtScore;
	private Vector<String> mNames;
	private JComboBox<String> comMname;
	private JButton btnSnoSearch, btnSnameSearch, btnMnameSearch;
	private JButton btnInput, btnUpdate;
	private JButton btnStudentOut, btnExpelOut, btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	StudentSwingDao dao = StudentSwingDao.getInstance();
	
	public SwingStudentMng(String title) { 
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contentPane = getContentPane(); // ȭ�� ����
		contentPane.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(4,3));
		jpbtn = new JPanel(new FlowLayout());
		
		txtSno = new JTextField(10);
		txtSname = new JTextField(10);
		mNames = dao.getNamelist();
		comMname = new JComboBox<String>(mNames);
		txtScore = new JTextField(10);
		
		btnSnoSearch = new JButton("�й��˻�");
		btnSnameSearch = new JButton("�̸��˻�");
		btnMnameSearch = new JButton("�����˻�");
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpelOut = new JButton("���������");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
		
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		
		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSno);
		jpup.add(btnSnoSearch);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSname);
		jpup.add(btnSnameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMnameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
		
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);
		
		contentPane.add(jpup);
		contentPane.add(jpbtn);
		contentPane.add(scrollPane);
		
		setSize(new Dimension(600, 400));
		setLocation(200, 150);
		setVisible(true);
		
		btnSnoSearch.addActionListener(this);
		btnSnameSearch.addActionListener(this);
		btnMnameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSnoSearch) { //�й� �˻�
			String sno = txtSno.getText().trim();
			
			if(sno.equals("")) {
				txtSname.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("�й��� �Է����ּ���.");
				return;
			}
			StudentSwingDto dto = dao.sNoGetStudent(sno);
			
			if(dto!=null) { // �й��� �˻��� ���
				txtSname.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				//txtScore.setText(""+dto.getScore()); // score���� ��Ʈ������ �ٲ㼭 txtField�� ����
				txtScore.setText(String.valueOf(dto.getScore()));
				txtPool.setText(sno + "�˻� �Ϸ�");				
			} else { // �й��� DB�� ���� ���
				txtSname.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
				txtPool.setText(sno + "�й��� ��ȿ���� �ʽ��ϴ�.");
			}
		} else if (e.getSource()==btnSnameSearch) { // �̸� �˻� 
			String sname = txtSname.getText().trim();
			
			if(sname.length()==0) {
				txtSno.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("�̸��� �Է����ּ���.");
				return;
			}
			ArrayList<StudentSwingDto> students = dao.snameGetStudent(sname);
			
			if(students.size()>1) { 
				txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtPool.append("\t----------------------------------\n");
				
				for(StudentSwingDto student : students) {
					txtPool.append("\t" + student.toString() + "\n");
					txtSno.setText(student.getSno());
					comMname.setSelectedItem(student.getMname());
					//txtScore.setText(""+student.getScore());
					txtScore.setText(String.valueOf(student.getScore()));
				}
			} else if(students.size()==1) {
				txtSno.setText(students.get(0).getSno());
				comMname.setSelectedItem(students.get(0).getMname());
				//txtScore.setText(""+students.get(0).getScore());
				txtScore.setText(String.valueOf(students.get(0).getScore()));
			} else {
				txtSno.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
				txtPool.setText("�ش� �̸��� �л��� �����ϴ�.");
			}
		} else if (e.getSource()==btnMnameSearch) { // �����˻� 
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
			String mname = comMname.getSelectedItem().toString();
			
			if(mname.equals("")) {
				txtPool.setText("������ �������ּ���.");
				return;
			}
			ArrayList<StudentSwingDto> students = dao.mnameGetStudent(mname);
			
			if(students.size()!=0) {
				txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtPool.append("\t----------------------------------\n");
				
				for(StudentSwingDto student : students) {
					txtPool.append("\t" + student.toString() + "\n");
				}
			} else { 
				txtPool.setText("�ش� �а��� �л��� �����ϴ�.");	
			}
		} else if (e.getSource()==btnInput) { // �л� �Է�
			String sname = txtSname.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			
			if(sname.equals("") || mname.equals("")) {
				txtPool.setText("�й�, �̸�, ������ �Է��ؾ� �մϴ�.");
				return;
			}
			txtPool.setText("");
			int score = 0;
			
			try {
				score = Integer.parseInt(txtScore.getText().trim());
				if(score<0 || score>100) {
					txtPool.append("��ȿ�� ������ �ƴϹǷ� 0�� ó���մϴ�. \n");
					score = 0;
				}
			} catch (NumberFormatException e1) {
				txtPool.append("������ �Է����� �ʰų� ���ڸ� �Է½� 0�� ó���մϴ�.\n");
			}
//			StudentSwingDto newStudent = new StudentSwingDto(0, sName, mName, score);
//			int result = dao.insertStudent(newStudent);
			int result = dao.insertStudent(sname, mname, score);
			
			if (result == StudentSwingDao.SUCCESS) { 
				txtPool.append(sname + "�л�, �Է� ����");
				txtSno.setText("");
				txtSname.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			}
		} else if (e.getSource()==btnUpdate) { // �л�����
			String sno = txtSno.getText().trim();
			String sname = txtSname.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			
			if(sno.equals("") || sname.equals("") || mname.equals("")) {
				txtPool.setText("�й�, �̸�, ������ �Է����ּ���.");
				return;
			}
			txtPool.setText("");
			int score = 0;
			
			try { 
				score = Integer.parseInt(txtScore.getText().trim());
				if(score<0 || score>100) {
					txtPool.append("��ȿ�� ������ �ƴϸ� 0�� ó���մϴ�.");
					score = 0;					
				}
			} catch (NumberFormatException e1) {
				txtPool.append("������ �Է����� �ʰų� ���ڷ� �Է½� 0�� ó���մϴ�.");
			}
			StudentSwingDto student = new StudentSwingDto(sno, sname, mname, score);
			int result = dao.updateStudent(student);
			
			if(result == StudentSwingDao.SUCCESS) { 
				txtPool.append(sname + "�л�, ���� ���� �Ϸ�");
			}
		} else if (e.getSource()==btnStudentOut) { // �л� ��� (������ ����)
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			ArrayList<StudentSwingDto> students = dao.getStudents();
				
			if(students.size()!=0) {
				txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtPool.append("\t����������������������������������������������������\n");
				for(StudentSwingDto student : students) {
					txtPool.append("\t" + student.toString() + "\n");
				}
			} else { 
				txtPool.setText("�л� ������ �����ϴ�.");
			}
		} else if (e.getSource()==btnExpelOut) { // �����ڸ� ���
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			ArrayList<StudentSwingDto> students = dao.getStudentsExpel();
			
			if(students.size()!=0) {
				txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtPool.append("\t����������������������������������������������������\n");
				for(StudentSwingDto student : students) {
					txtPool.append("\t"+student.toString()+"\n");
				}
			} else { 
				txtPool.setText("���� �л� ������ �����ϴ�.");
			}
		} else if (e.getSource()==btnExpel) { // ���� ó��
			String sno = txtSno.getText().trim();
			if(sno.length()==0) { 
				txtPool.setText("�й��� �Է����ּ���.");
				return;
			}
			int result = dao.snoExpel(sno);
			if(result == StudentSwingDao.SUCCESS) { 
				txtPool.setText(sno + "�л�, ����ó�� �Ϸ�");
			}
		} else if (e.getSource()==btnExit) { // ���� ��ư
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new SwingStudentMng("�л� ����");
	}
}
