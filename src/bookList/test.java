package bookList;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox categoryName = new JComboBox();
		categoryName.setBounds(75, 61, 74, 19);
		contentPane.add(categoryName);
		try {
			String sql = "Select name from category";
		    Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject?serverTimezone=JST","root","voice008");
		    PreparedStatement st = conn.prepareStatement(sql);
		    ResultSet rs = st.executeQuery();
            while (rs.next()) {
            	categoryName.addItem(rs.getString(1));
            }
		    conn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		

	}
	
}
