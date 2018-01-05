package com.mm.user.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mm.user.operations.UserLogin;
import com.mm.user.operations.UserLoginOperations;


public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField passwordField;
	JLabel lblValidatePass= new JLabel("");
	JLabel lblValidateUsername = new JLabel("");
	JLabel registered = new JLabel("");

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Register frame = new Register();
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
	public RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		lblNewLabel.setForeground(SystemColor.textText);
		lblNewLabel.setBounds(172, 27, 102, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(SystemColor.infoText);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(59, 95, 89, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(59, 165, 89, 21);
		contentPane.add(lblNewLabel_2);
		
		textUsername = new JTextField();
		textUsername.setBounds(186, 102, 121, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 165, 126, 20);
		contentPane.add(passwordField);
		
		
		lblValidateUsername.setBounds(186, 87, 160, 14);
		contentPane.add(lblValidateUsername);
		
		
		lblValidatePass.setBounds(186, 149, 160, 14);
		contentPane.add(lblValidatePass);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addUser();
				LoginView.getRegisterObj().dispose();
				}
		});
		btnRegister.setBounds(165, 228, 89, 23);
		contentPane.add(btnRegister);
		
		
		registered.setHorizontalAlignment(SwingConstants.CENTER);
		registered.setBounds(103, 197, 243, 14);
		contentPane.add(registered);
	}

	
public UserLogin getData() {
	return new UserLogin(textUsername.getText(),passwordField.getText());
}
	
public void addUser() {
	JOptionPane.showMessageDialog(this,	UserLoginOperations.getInstance().addUser(getData()) );
	UserLoginOperations.getInstance().viewList();
	
}

}

