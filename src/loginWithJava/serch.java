package loginWithJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class serch extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					serch frame = new serch();
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
	public serch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u30E6\u30FC\u30B6\u30FC\u753B\u9762");
		lblNewLabel.setFont(new Font("HG恨集窶", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 10, 126, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u56F3\u66F8\u691C\u7D22");
		btnNewButton.setFont(new Font("HG恨集窶", Font.PLAIN, 12));
		btnNewButton.setBounds(22, 64, 116, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8CB8\u51FA\u78BA\u8A8D");
		btnNewButton_1.setFont(new Font("HG恨集窶", Font.PLAIN, 12));
		btnNewButton_1.setBounds(22, 101, 116, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u500B\u4EBA\u60C5\u5831");
		btnNewButton_2.setFont(new Font("HG恨集窶", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(22, 138, 116, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u30ED\u30B0\u30A2\u30A6\u30C8");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnNewButton_3.setFont(new Font("HG恨集窶", Font.PLAIN, 12));
		btnNewButton_3.setBounds(22, 217, 116, 21);
		contentPane.add(btnNewButton_3);
	}
}
