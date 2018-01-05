package com.mm.question.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.mm.question.operations.QuestionOperations;
import com.mm.question.operations.Questions;
import com.mm.question.operations.Status;

public class QuestionView extends JFrame implements Status {

	private JPanel contentPane;
	private JLabel lblQues;
	private JButton btnNext;
	private JButton btnPrevious;
	private Questions ques;
	private JRadioButton rdbtnD;
	private JRadioButton rdbtnB;
	private JRadioButton rdbtnA;
	private JRadioButton rdbtnC;
	private int qcount=0;

	public void loadQues() {
		HashSet<Questions> quesSet = QuestionOperations.getInstance().getList();
		String a[]= {"yes","no","maybe","none"};
		String b[]= {"int","double","char","Float"};
		Questions q1=new Questions("Java follows WORA",a,"A");
		Questions q2=new Questions("Full form of JRE is Java Runs Everywhere",a,"B");
		Questions q3=new Questions("which one among these is not a primitive datatype",b,"D");
		quesSet.add(q1);
		quesSet.add(q2);
		quesSet.add(q3);
	}
	/**
	 * Create the frame.
	 */
	public QuestionView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblQues = new JLabel("");
		lblQues.setBounds(19, 90, 382, 37);
		contentPane.add(lblQues);
		
		rdbtnA = new JRadioButton("");
		rdbtnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit(e);
			}
		});
		rdbtnA.setBounds(19, 134, 109, 23);
		contentPane.add(rdbtnA);
		
		rdbtnC = new JRadioButton("");
		rdbtnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit(e);
			}
		});
		rdbtnC.setBounds(22, 176, 109, 23);
		contentPane.add(rdbtnC);
		
		rdbtnB = new JRadioButton("");
		rdbtnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit(e);
			}
		});
		rdbtnB.setBounds(221, 134, 109, 23);
		contentPane.add(rdbtnB);
		
		rdbtnD = new JRadioButton("");
		rdbtnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit(e);
			}
		});
		rdbtnD.setBounds(221, 176, 109, 23);
		contentPane.add(rdbtnD);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.setEnabled(false);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qcount--;
				displayQues();
				if(qcount==0)
					btnPrevious.setEnabled(false);
			}
		});
		btnPrevious.setBounds(10, 228, 89, 23);
		contentPane.add(btnPrevious);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qcount++;
				btnPrevious.setEnabled(true);
				displayQues();
				repaint();
			}
		});
		btnNext.setBounds(324, 228, 89, 23);
		contentPane.add(btnNext);
		
		
		group.add(rdbtnA);
		group.add(rdbtnB);
		group.add(rdbtnC);
		group.add(rdbtnD);
		loadQues();
	}
	ButtonGroup group=new ButtonGroup();
		
	public void displayQues() {
		String a[];	
		ques=QuestionOperations.getInstance().getQuestion(qcount);
			if(ques!=null) {
			lblQues.setText(ques.getQuestion());
			ques.setFlag(false);
			if(ques.getUrans()==null)
			ques.setStatus(WAIT);
			a=ques.getAnswer();
				rdbtnA.setText(a[0]);
				rdbtnB.setText(a[1]);
				rdbtnC.setText(a[2]);
				rdbtnD.setText(a[3]);
				if(ques.getUrans()==null)
					group.clearSelection();
				else {
					switch(ques.getUrans()) {
					case "A":rdbtnA.setSelected(true);
						break;
					case "B":rdbtnB.setSelected(true);
						break;
					case "C": rdbtnC.setSelected(true);
						break;
					case "D": rdbtnD.setSelected(true);
					}
				}
			}
			else {
				report= new ReportView();
				report.setVisible(true);
				report.setValues();
			}
	}
	static ReportView report;
	public void submit(ActionEvent e) {
		if(e.getSource()==rdbtnA)
			ques.setUrans("A");
		else if(e.getSource()==rdbtnB)
			ques.setUrans("B");
		else if(e.getSource()==rdbtnC)
			ques.setUrans("C");
		else if(e.getSource()==rdbtnD)
			ques.setUrans("D");
		if(ques.getUrans().length()>0)
		ques.setStatus(DONE);
	}
public static ReportView getReportObj() {
	return report;
}

	
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		draw(g);
	}
	public void draw(Graphics g) {
		
		// Image q1
		
		if(QuestionOperations.getInstance().getQuestion(0).getStatus()==DONE)
			QuestionOperations.getInstance().drawGreen(g, 50, 50);
		else if(QuestionOperations.getInstance().getQuestion(0).getStatus()==WAIT)
			QuestionOperations.getInstance().drawYellow(g, 50, 50);
		else if(QuestionOperations.getInstance().getQuestion(0).getStatus()==UNREAD)
			QuestionOperations.getInstance().drawRed(g, 50, 50);
		//q2
		if(QuestionOperations.getInstance().getQuestion(1).getStatus()==DONE)
			QuestionOperations.getInstance().drawGreen(g, 110, 50);
		else if(QuestionOperations.getInstance().getQuestion(1).getStatus()==WAIT)
			QuestionOperations.getInstance().drawYellow(g, 110, 50);
		else if(QuestionOperations.getInstance().getQuestion(1).getStatus()==UNREAD)
			QuestionOperations.getInstance().drawRed(g, 110, 50);
		//q3
		if(QuestionOperations.getInstance().getQuestion(2).getStatus()==DONE)
			QuestionOperations.getInstance().drawGreen(g, 170, 50);
		else if(QuestionOperations.getInstance().getQuestion(2).getStatus()==WAIT)
			QuestionOperations.getInstance().drawYellow(g, 170, 50);
		else if(QuestionOperations.getInstance().getQuestion(2).getStatus()==UNREAD)
			QuestionOperations.getInstance().drawRed(g, 170, 50);
	}
	}
