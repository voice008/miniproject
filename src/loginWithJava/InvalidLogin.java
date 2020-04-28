package loginWithJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class InvalidLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvalidLogin frame = new InvalidLogin();
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
	public InvalidLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Invalid = new JLabel("Username\u307E\u305F\u306FPassword\u304C\u9593\u9055\u3063\u3066\u3044\u307E\u3059\u3002");
		Invalid.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
		Invalid.setBounds(72, 48, 350, 39);
		contentPane.add(Invalid);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(223, 152, 91, 21);
		contentPane.add(btnNewButton);
	}

	public static void showMessageDialog(JButton btnNewButton, String string) {
		// TODO Auto-generated method stub
		
	}
}
