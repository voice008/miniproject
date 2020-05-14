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
import javax.swing.JComboBox;
import java.awt.Font;

public class register1 extends JFrame {

	private JPanel contentPane;
	private JTextField textTitele;
	private JTextField textDay;
	private JTextField textView;
	private JTextField textAuthor;
	private JTextField textQty;
	private JComboBox comboBox;
	private JComboBox categoryName;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register1 frame = new register1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public register1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u30AB\u30C6\u30B4\u30EA\u30FC\u3000ID");
		lblNewLabel.setFont(new Font("HGP恨集窶", Font.PLAIN, 12));
		lblNewLabel.setBounds(87, 227, 88, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblTitle = new JLabel("\u30BF\u30A4\u30C8\u30EB");
		lblTitle.setFont(new Font("HGP恨集窶", Font.PLAIN, 12));
		lblTitle.setBounds(89, 60, 66, 25);
		contentPane.add(lblTitle);
		
		JLabel lblPublicdate = new JLabel("\u51FA\u7248\u65E5");
		lblPublicdate.setFont(new Font("HGP恨集窶", Font.PLAIN, 12));
		lblPublicdate.setBounds(89, 95, 66, 25);
		contentPane.add(lblPublicdate);
		
		JLabel lblOverview = new JLabel("\u6982\u8981");
		lblOverview.setFont(new Font("HGP恨集窶", Font.PLAIN, 12));
		lblOverview.setBounds(89, 130, 66, 25);
		contentPane.add(lblOverview);
		
		JLabel lblAuthor = new JLabel("\u8457\u8005");
		lblAuthor.setFont(new Font("HGP恨集窶", Font.PLAIN, 12));
		lblAuthor.setBounds(89, 165, 66, 25);
		contentPane.add(lblAuthor);
		
		JLabel lblQuantity = new JLabel("\u518A\u6570");
		lblQuantity.setFont(new Font("HGP恨集窶", Font.PLAIN, 12));
		lblQuantity.setBounds(89, 194, 66, 25);
		contentPane.add(lblQuantity);
		
		textTitele = new JTextField();
		textTitele.setBounds(177, 63, 137, 19);
		contentPane.add(textTitele);
		textTitele.setColumns(10);
		
		textDay = new JTextField();
		textDay.setColumns(10);
		textDay.setBounds(177, 98, 137, 19);
		contentPane.add(textDay);
		
		textView = new JTextField();
		textView.setColumns(10);
		textView.setBounds(177, 133, 137, 19);
		contentPane.add(textView);
		
		textAuthor = new JTextField();
		textAuthor.setColumns(10);
		textAuthor.setBounds(177, 168, 137, 19);
		contentPane.add(textAuthor);
		
		textQty = new JTextField();
		textQty.setColumns(10);
		textQty.setBounds(177, 197, 137, 19);
		contentPane.add(textQty);
		
		categoryName = new JComboBox();
		categoryName.setBounds(177, 230, 96, 19);
		contentPane.add(categoryName);
		
		JButton btn = new JButton("\u767B\u9332");
		btn.setFont(new Font("HGP恨集窶", Font.PLAIN, 12));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn;
				PreparedStatement statement;
		        try {
		        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject?serverTimezone=JST","root","voice008");
                    String query = "insert into book(title, publicDate, overview, author, quantity,category_id) values (?, ?, ?, ?, ?, ?)";
                    statement = conn.prepareStatement(query);

                    statement.setString(1, textTitele.getText()); 
                    statement.setString(2, textDay.getText()); 
                    statement.setString(3, textView.getText()); 
                    statement.setString(4, textAuthor.getText()); 
                    statement.setString(5, textQty.getText()); 
                    statement.setString(6, categoryName.getSelectedItem().toString());
                    statement.executeUpdate();
                    
                       JOptionPane.showMessageDialog(null,"register successfully");
             } catch (Exception ex) {
            	 	   JOptionPane.showMessageDialog(null,ex); 
             }
		        
			 }
			 });
		btn.setBounds(177, 296, 96, 21);
		contentPane.add(btn);
		JLabel lblNewLabel_1 = new JLabel("\u56F3\u66F8\u65B0\u898F\u767B\u9332");
		lblNewLabel_1.setFont(new Font("HGP恨集窶", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(175, 10, 159, 39);
		contentPane.add(lblNewLabel_1);
		
		try {
			String sql = "Select id from category";
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


