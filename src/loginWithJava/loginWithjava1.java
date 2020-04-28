package loginWithJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.sql.Statement;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;



public class loginWithjava1 extends JFrame {

	private JPanel contentPane1;
	private JLabel lblUser;
	private JLabel lblPass;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginWithjava1 frame = new loginWithjava1();
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
	public loginWithjava1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("\u30ED\u30B0\u30A4\u30F3\u753B\u9762");
		lblNewLabel1.setFont(new Font("HGS恨集窶", Font.PLAIN, 20));
		lblNewLabel1.setBounds(171, 50, 177, 49);
		contentPane1.add(lblNewLabel1);

		
		lblUser = new JLabel("ID");
		lblUser.setFont(new Font("HGP恨集窶", Font.PLAIN, 12));
		lblUser.setBounds(105, 127, 35, 13);
		contentPane1.add(lblUser);
		
		lblPass = new JLabel("\u30D1\u30B9\u30EF\u30FC\u30C9");
		lblPass.setFont(new Font("HGP恨集窶", Font.PLAIN, 12));
		lblPass.setBounds(105, 171, 69, 13);
		contentPane1.add(lblPass);
		
		textField = new JTextField();
		textField.setBounds(186, 124, 116, 19);
		contentPane1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 168, 116, 19);
		contentPane1.add(textField_1);
		textField_1.setColumns(10);
		
		btnLogin = new JButton("\u30ED\u30B0\u30A4\u30F3");
		btnLogin.setFont(new Font("HGP恨集窶", Font.PLAIN, 10));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id1 = textField.getText();
				String pass1 = textField_1.getText();
				
				String iddb ;
				String passdb ;
				
				Connection conn;
				
				
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject?serverTimezone=JST","root","voice008");
					
			
					//@SuppressWarnings("rawtypes")
					Statement myst = conn.createStatement();
					
					ResultSet myRS =myst.executeQuery("Select id, password from customer");
					
					boolean isUser =false;
					
					while(myRS.next()){
						iddb = myRS.getString("id");
						passdb = myRS.getString("password");
					
						if(id1.equals(iddb) && pass1.equals(passdb)) {
							isUser = true;
							if(id1.equals("admin")) {
								Admin a = new Admin();
								a.setVisible(true);
							}else {
								serch v = new serch();
								v.setVisible(true);
							}
						}
					}
					if (isUser == false) {
						JOptionPane.showMessageDialog(btnLogin, "Id枖偼Password偑娫堘偭偰偄傑偡丅");
					}
			}catch (SQLException ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(213, 204, 76, 21);
		contentPane1.add(btnLogin);
	}
}
