package bookList;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("book_id");
		lblNewLabel.setBounds(89, 60, 66, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblTitle = new JLabel("title");
		lblTitle.setBounds(89, 95, 66, 25);
		contentPane.add(lblTitle);
		
		JLabel lblPublicdate = new JLabel("publicDate");
		lblPublicdate.setBounds(89, 130, 66, 25);
		contentPane.add(lblPublicdate);
		
		JLabel lblOverview = new JLabel("overview");
		lblOverview.setBounds(89, 165, 66, 25);
		contentPane.add(lblOverview);
		
		JLabel lblAuthor = new JLabel("author");
		lblAuthor.setBounds(89, 192, 66, 25);
		contentPane.add(lblAuthor);
		
		JLabel lblQuantity = new JLabel("quantity");
		lblQuantity.setBounds(89, 227, 66, 25);
		contentPane.add(lblQuantity);
		
		textField = new JTextField();
		textField.setBounds(177, 63, 91, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(177, 98, 96, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(177, 133, 96, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(177, 168, 96, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(177, 197, 96, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(177, 230, 96, 19);
		contentPane.add(textField_5);
		
		new test();
		
		JButton btnNewButton = new JButton("register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection conn =null ;
				PreparedStatement statement =null  ;
				
		        try {
		        /*	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject?serverTimezone=JST","root","voice008");
                    String query = "insert into book(title, publicDate, overview, author, quantity,) values (?, ?, ?, ?, ?, ?)";
                    statement = conn.prepareStatement(query);*/

                    statement.setString(1, textField.getText()); 
                    statement.setString(2, textField_1.getText()); 
                    statement.setString(3, textField_2.getText()); 
                    statement.setString(4, textField_3.getText()); 
                    statement.setString(5, textField_4.getText()); 
                    statement.setString(6, textField_5.getText()); 
                    
                    
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(btnNewButton,"Your BookDate is sucessfully created");
		        
		       
             } catch (Exception exception) {
             	JOptionPane.showMessageDialog(btnNewButton, exception);
                
             }}
		        
		        
		        
		        
		        
				
			
		});
		btnNewButton.setBounds(229, 281, 91, 21);
		contentPane.add(btnNewButton);
	}
}
