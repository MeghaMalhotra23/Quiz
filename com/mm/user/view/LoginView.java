package com.mm.user.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mm.question.view.QuestionView;
import com.mm.user.operations.UserLogin;
import com.mm.user.operations.UserLoginOperations;


public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JLabel lblValidateUsername = new JLabel("");
	private JLabel lblValidatePass = new JLabel("");
	private static LoginView frame;
	private JLabel lblInvalid = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				frame= new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(35, 70, 94, 27);
		contentPane.add(lblUsername);
		
		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setBounds(35, 131, 64, 20);
		contentPane.add(lblpassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(139, 73, 189, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setEnabled(false);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}});
		btnLogin.setBounds(191, 208, 89, 23);
		contentPane.add(btnLogin);
		
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				register= new RegisterView();
				register.setVisible(true);
				btnLogin.setEnabled(true);
				
			}
		});
		btnRegister.setBounds(444, 208, 89, 23);
		contentPane.add(btnRegister);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(new Color(51, 0, 0));
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblLogin.setBounds(180, 11, 86, 36);
		contentPane.add(lblLogin);
		lblValidatePass.setForeground(Color.RED);
		
		
		lblValidatePass.setBounds(139, 116, 251, 14);
		contentPane.add(lblValidatePass);
		lblValidateUsername.setForeground(Color.RED);
		
		
		lblValidateUsername.setBounds(139, 59, 251, 14);
		contentPane.add(lblValidateUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 131, 189, 20);
		contentPane.add(passwordField);
		
		JLabel lblUserName = new JLabel("");
		lblUserName.setBackground(Color.WHITE);
		lblUserName.setBounds(0, 0, 434, 262);
		contentPane.add(lblUserName);
		
		JLabel lblNewLabel = new JLabel("New user? REGISTER here.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(378, 111, 199, 40);
		contentPane.add(lblNewLabel);
		
		
		lblInvalid.setBounds(79, 184, 270, 14);
		contentPane.add(lblInvalid);
	}
	public UserLogin getData() {
	return new UserLogin(txtUsername.getText(),passwordField.getText());
	
	}
	private static RegisterView register;
	public void login() {
	if(UserLoginOperations.getInstance().searchUser(getData()).equals("Found")) {
	frame.dispose();
	QuestionView view=new QuestionView();
	view.setVisible(true);
	view.displayQues();}
	}
	
	public static RegisterView getRegisterObj() {
		return register;
	}
}
