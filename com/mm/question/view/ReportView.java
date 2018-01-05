package com.mm.question.view;

import java.awt.Font;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mm.question.operations.QuestionOperations;
import com.mm.question.operations.Questions;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReportView extends JFrame {

	private JPanel contentPane;
	private JLabel lblscore;
	private JLabel lblrightans;
	private JLabel lblurans1;
	private JLabel lblques1;
	private JLabel lblques2;
	private JLabel lblNewLabel_3;
	private JLabel lblurans2;
	private JLabel lblNewLabel_4;
	private JLabel lblrightans2;
	private JLabel lblNewLabel_5;
	private JLabel lblscore2;
	private JLabel lblques3;
	private JLabel lblNewLabel_6;
	private JLabel lblurans3;
	private JLabel lblNewLabel_7;
	private JLabel lblrightans3;
	private JLabel lblNewLabel_8;
	private JLabel lblscore3;
	private JLabel lblTotalScore;
	private JLabel lbltscore;
	private HashSet<Questions> quesSet;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReportView frame = new ReportView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ReportView() {
		quesSet=QuestionOperations.getInstance().getList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REPORT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(165, 11, 67, 23);
		contentPane.add(lblNewLabel);
		
		lblques1 = new JLabel("");
		lblques1.setBounds(20, 52, 384, 44);
		contentPane.add(lblques1);
		
		JLabel lblYourAnswer = new JLabel("your answer:");
		lblYourAnswer.setBounds(20, 121, 88, 14);
		contentPane.add(lblYourAnswer);
		
		lblurans1 = new JLabel("");
		lblurans1.setBounds(137, 121, 46, 14);
		contentPane.add(lblurans1);
		
		JLabel lblNewLabel_1 = new JLabel("Right ans:");
		lblNewLabel_1.setBounds(245, 121, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		lblrightans = new JLabel("");
		lblrightans.setBounds(343, 121, 46, 14);
		contentPane.add(lblrightans);
		
		JLabel lblNewLabel_2 = new JLabel("score:");
		lblNewLabel_2.setBounds(109, 160, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblscore = new JLabel("");
		lblscore.setBounds(207, 160, 46, 14);
		contentPane.add(lblscore);
		
		lblques2 = new JLabel("");
		lblques2.setBounds(20, 185, 384, 37);
		contentPane.add(lblques2);
		
		lblNewLabel_3 = new JLabel("Your Answer:");
		lblNewLabel_3.setBounds(20, 258, 88, 14);
		contentPane.add(lblNewLabel_3);
		
		lblurans2 = new JLabel("");
		lblurans2.setBounds(137, 258, 46, 14);
		contentPane.add(lblurans2);
		
		lblNewLabel_4 = new JLabel("Right ans:");
		lblNewLabel_4.setBounds(260, 258, 61, 14);
		contentPane.add(lblNewLabel_4);
		
		lblrightans2 = new JLabel("");
		lblrightans2.setBounds(358, 258, 46, 14);
		contentPane.add(lblrightans2);
		
		lblNewLabel_5 = new JLabel("score:");
		lblNewLabel_5.setBounds(109, 294, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		lblscore2 = new JLabel("");
		lblscore2.setBounds(207, 294, 46, 14);
		contentPane.add(lblscore2);
		
		lblques3 = new JLabel("");
		lblques3.setBounds(20, 333, 371, 23);
		contentPane.add(lblques3);
		
		lblNewLabel_6 = new JLabel("Your answer:");
		lblNewLabel_6.setBounds(31, 389, 75, 14);
		contentPane.add(lblNewLabel_6);
		
		lblurans3 = new JLabel("");
		lblurans3.setBounds(137, 389, 46, 14);
		contentPane.add(lblurans3);
		
		lblNewLabel_7 = new JLabel("Right ans:");
		lblNewLabel_7.setBounds(260, 389, 61, 14);
		contentPane.add(lblNewLabel_7);
		
		lblrightans3 = new JLabel("");
		lblrightans3.setBounds(358, 389, 46, 14);
		contentPane.add(lblrightans3);
		
		lblNewLabel_8 = new JLabel("score:");
		lblNewLabel_8.setBounds(109, 424, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		lblscore3 = new JLabel("");
		lblscore3.setBounds(207, 424, 46, 14);
		contentPane.add(lblscore3);
		
		lblTotalScore = new JLabel("TOTAL SCORE:");
		lblTotalScore.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalScore.setBounds(20, 483, 98, 14);
		contentPane.add(lblTotalScore);
		
		lbltscore = new JLabel("");
		lbltscore.setBounds(121, 483, 46, 14);
		contentPane.add(lbltscore);
		
		JButton btnPrintPdf = new JButton("Print PDF");
		btnPrintPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstPdf pdf= new FirstPdf();
				Object message="PDF saved in C:/temp";
				JOptionPane.showMessageDialog(QuestionView.getReportObj(),message);
			}
		});
		btnPrintPdf.setBounds(260, 479, 89, 23);
		contentPane.add(btnPrintPdf);
	}
	private Questions q1;
	private Questions q2;
	private Questions q3;
	public void setValues() {
		Iterator<Questions> itr=quesSet.iterator();
		while(itr.hasNext()) {
			q1=itr.next();
			q2=itr.next();
			q3=itr.next();}
		lblques1.setText(q1.getQuestion());
		lblurans1.setText(String.valueOf(q1.getUrans()));
		lblrightans.setText(String.valueOf(q1.getRans()));
		q1.setScore();
		lblscore.setText(String.valueOf(q1.getScore()));
		lblques2.setText(q2.getQuestion());
		lblurans2.setText(String.valueOf(q2.getUrans()));
		lblrightans2.setText(String.valueOf(q2.getRans()));
		q2.setScore();
		lblscore2.setText(String.valueOf(q2.getScore()));
		lblques3.setText(q3.getQuestion());
		lblurans3.setText(String.valueOf(q3.getUrans()));
		lblrightans3.setText(String.valueOf(q3.getRans()));
		q3.setScore();
		lblscore3.setText(String.valueOf(q3.getScore()));
		lbltscore.setText(String.valueOf(setTScore()));}

	
	public int setTScore() {
		return quesSet.stream().mapToInt(score->score.getScore()).sum();
	}
}
