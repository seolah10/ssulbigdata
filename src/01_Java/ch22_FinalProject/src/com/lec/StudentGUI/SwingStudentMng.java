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
		
		contentPane = getContentPane(); // 화면 구현
		contentPane.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(4,3));
		jpbtn = new JPanel(new FlowLayout());
		
		txtSno = new JTextField(10);
		txtSname = new JTextField(10);
		mNames = dao.getNamelist();
		comMname = new JComboBox<String>(mNames);
		txtScore = new JTextField(10);
		
		btnSnoSearch = new JButton("학번검색");
		btnSnameSearch = new JButton("이름검색");
		btnMnameSearch = new JButton("전공검색");
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpelOut = new JButton("제적자출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
		
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		
		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtSno);
		jpup.add(btnSnoSearch);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtSname);
		jpup.add(btnSnameSearch);
		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMnameSearch);
		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
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
		if(e.getSource()==btnSnoSearch) { //학번 검색
			String sno = txtSno.getText().trim();
			
			if(sno.equals("")) {
				txtSname.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("학번을 입력해주세요.");
				return;
			}
			StudentSwingDto dto = dao.sNoGetStudent(sno);
			
			if(dto!=null) { // 학번이 검색된 경우
				txtSname.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				//txtScore.setText(""+dto.getScore()); // score값을 스트링으로 바꿔서 txtField에 넣음
				txtScore.setText(String.valueOf(dto.getScore()));
				txtPool.setText(sno + "검색 완료");				
			} else { // 학번이 DB에 없는 경우
				txtSname.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
				txtPool.setText(sno + "학번이 유효하지 않습니다.");
			}
		} else if (e.getSource()==btnSnameSearch) { // 이름 검색 
			String sname = txtSname.getText().trim();
			
			if(sname.length()==0) {
				txtSno.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("이름을 입력해주세요.");
				return;
			}
			ArrayList<StudentSwingDto> students = dao.snameGetStudent(sname);
			
			if(students.size()>1) { 
				txtPool.setText("\t학번\t이름\t학과명\t점수\n");
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
				txtPool.setText("해당 이름의 학생이 없습니다.");
			}
		} else if (e.getSource()==btnMnameSearch) { // 전공검색 
			txtSno.setText("");
			txtSname.setText("");
			txtScore.setText("");
			String mname = comMname.getSelectedItem().toString();
			
			if(mname.equals("")) {
				txtPool.setText("전공을 선택해주세요.");
				return;
			}
			ArrayList<StudentSwingDto> students = dao.mnameGetStudent(mname);
			
			if(students.size()!=0) {
				txtPool.setText("\t학번\t이름\t학과명\t점수\n");
				txtPool.append("\t----------------------------------\n");
				
				for(StudentSwingDto student : students) {
					txtPool.append("\t" + student.toString() + "\n");
				}
			} else { 
				txtPool.setText("해당 학과에 학생이 없습니다.");	
			}
		} else if (e.getSource()==btnInput) { // 학생 입력
			String sname = txtSname.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			
			if(sname.equals("") || mname.equals("")) {
				txtPool.setText("학번, 이름, 전공을 입력해야 합니다.");
				return;
			}
			txtPool.setText("");
			int score = 0;
			
			try {
				score = Integer.parseInt(txtScore.getText().trim());
				if(score<0 || score>100) {
					txtPool.append("유효한 점수가 아니므로 0점 처리합니다. \n");
					score = 0;
				}
			} catch (NumberFormatException e1) {
				txtPool.append("점수를 입력하지 않거나 문자를 입력시 0점 처리합니다.\n");
			}
//			StudentSwingDto newStudent = new StudentSwingDto(0, sName, mName, score);
//			int result = dao.insertStudent(newStudent);
			int result = dao.insertStudent(sname, mname, score);
			
			if (result == StudentSwingDao.SUCCESS) { 
				txtPool.append(sname + "학생, 입력 성공");
				txtSno.setText("");
				txtSname.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			}
		} else if (e.getSource()==btnUpdate) { // 학생수정
			String sno = txtSno.getText().trim();
			String sname = txtSname.getText().trim();
			String mname = comMname.getSelectedItem().toString();
			
			if(sno.equals("") || sname.equals("") || mname.equals("")) {
				txtPool.setText("학번, 이름, 전공을 입력해주세요.");
				return;
			}
			txtPool.setText("");
			int score = 0;
			
			try { 
				score = Integer.parseInt(txtScore.getText().trim());
				if(score<0 || score>100) {
					txtPool.append("유효한 점수가 아니면 0점 처리합니다.");
					score = 0;					
				}
			} catch (NumberFormatException e1) {
				txtPool.append("점수를 입력하지 않거나 문자로 입력시 0점 처리합니다.");
			}
			StudentSwingDto student = new StudentSwingDto(sno, sname, mname, score);
			int result = dao.updateStudent(student);
			
			if(result == StudentSwingDao.SUCCESS) { 
				txtPool.append(sname + "학생, 정보 수정 완료");
			}
		} else if (e.getSource()==btnStudentOut) { // 학생 출력 (제적자 제외)
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			ArrayList<StudentSwingDto> students = dao.getStudents();
				
			if(students.size()!=0) {
				txtPool.setText("\t학번\t이름\t학과명\t점수\n");
				txtPool.append("\t──────────────────────────\n");
				for(StudentSwingDto student : students) {
					txtPool.append("\t" + student.toString() + "\n");
				}
			} else { 
				txtPool.setText("학생 정보가 없습니다.");
			}
		} else if (e.getSource()==btnExpelOut) { // 제적자만 출력
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			ArrayList<StudentSwingDto> students = dao.getStudentsExpel();
			
			if(students.size()!=0) {
				txtPool.setText("\t학번\t이름\t학과명\t점수\n");
				txtPool.append("\t──────────────────────────\n");
				for(StudentSwingDto student : students) {
					txtPool.append("\t"+student.toString()+"\n");
				}
			} else { 
				txtPool.setText("제적 학생 정보가 없습니다.");
			}
		} else if (e.getSource()==btnExpel) { // 제적 처리
			String sno = txtSno.getText().trim();
			if(sno.length()==0) { 
				txtPool.setText("학번을 입력해주세요.");
				return;
			}
			int result = dao.snoExpel(sno);
			if(result == StudentSwingDao.SUCCESS) { 
				txtPool.setText(sno + "학생, 제적처리 완료");
			}
		} else if (e.getSource()==btnExit) { // 종료 버튼
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new SwingStudentMng("학사 관리");
	}
}
