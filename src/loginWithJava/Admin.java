package loginWithJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u8005\u753B\u9762");
		lblNewLabel.setFont(new Font("HG�޼��M", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 10, 125, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u56F3\u66F8\u4E00\u89A7");
		btnNewButton.setFont(new Font("HGP�޼��M", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(22, 80, 115, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u30E6\u30FC\u30B6\u30FC\u4E00\u89A7");
		btnNewButton_1.setFont(new Font("HGP�޼��M", Font.PLAIN, 12));
		btnNewButton_1.setBounds(22, 129, 115, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u30ED\u30B0\u30A2\u30A6\u30C8");
		btnNewButton_2.setFont(new Font("HGS�޼��M", Font.PLAIN, 12));
		btnNewButton_2.setBounds(22, 208, 115, 21);
		contentPane.add(btnNewButton_2);
	}
}
