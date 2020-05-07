package bookList;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginWithJava.Admin;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

public class bookList1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookList1 frame = new bookList1();
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
	public bookList1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u4E00\u89A7\u8868\u793A");
		btnNewButton.setFont(new Font("HGPºÞ¼¯¸M", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Connection conn = null ;
				 PreparedStatement statement = null;
					
					try {
						
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306"
								+ "/miniproject?serverTimezone=JST","root","voice008");
				        String query ="Select * from book";
				        statement = conn.prepareStatement(query);
				        ResultSet rs = statement.executeQuery();
				        table.setModel(DbUtils.resultSetToTableModel(rs));
				        
			} catch (Exception ex) {
				ex.printStackTrace();
			}}}
					
					
		);
		btnNewButton.setBounds(167, 33, 91, 21);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 66, 452, 227);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("\u56F3\u66F8\u4E00\u89A7");
		lblNewLabel.setFont(new Font("HGPºÞ¼¯¸M", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 10, 104, 31);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("\u65B0\u898F\u767B\u9332");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(12, 64, 98, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("\u7DE8\u96C6");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(12, 99, 98, 21);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("\u524A\u9664");
		btnNewButton_3.setBounds(12, 139, 98, 21);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("\u623B\u308B");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin a = new Admin();
				a.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(29, 234, 68, 21);
		contentPane.add(btnNewButton_4);
	}

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
