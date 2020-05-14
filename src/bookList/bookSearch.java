package bookList;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.SystemColor;
import javax.swing.JRadioButton;

public class bookSearch extends JFrame {
	
	private JPanel contentPane;
	private JTextField author_sea;
	private JTextField title_sea;
	private JTable table_1;
	private JTextField title_edit;
	private JTextField publicDate_edit;
	private JTextField author_edit;
	private JTextField quantity_edit;
	private JTextField overview_edit;
	private JTextField ID;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookSearch frame = new bookSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public bookSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7DE8\u96C6\u307E\u305F\u306F\u524A\u9664\u3057\u305F\u3044\u8457\u8005\u3001\u30BF\u30A4\u30C8\u30EB\u3092\r\n\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044\u3002");
		lblNewLabel.setFont(new Font("HGPｺﾞｼｯｸM", Font.PLAIN, 12));
		lblNewLabel.setBounds(12, 10, 239, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8457\u8005");
		lblNewLabel_1.setFont(new Font("HGPｺﾞｼｯｸM", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(40, 53, 50, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u30BF\u30A4\u30C8\u30EB");
		lblNewLabel_1_1.setFont(new Font("HGPｺﾞｼｯｸM", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(30, 82, 50, 16);
		contentPane.add(lblNewLabel_1_1);
		
		author_sea = new JTextField();
		author_sea.setBounds(107, 53, 137, 19);
		contentPane.add(author_sea);
		author_sea.setColumns(10);
		
		title_sea = new JTextField();
		title_sea.setBounds(107, 81, 137, 19);
		contentPane.add(title_sea);
		title_sea.setColumns(10);
		
		JButton btnSearch = new JButton("\u691C\u7D22");
		btnSearch.addActionListener(new ActionListener() {
			//private JTable table;

			public void actionPerformed(ActionEvent e) {
				String inpAuthor= author_sea.getText();
				String inpTitle = title_sea.getText();
				Connection conn = null;
		        PreparedStatement statement = null;
				try {
					
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject?serverTimezone=JST","root","voice008");
					String sql ="Select id,title,publicDate,author,quantity,overview from book where author like  ? and title like ?  ";
					statement = conn.prepareStatement(sql);
					statement.setString(1,inpAuthor+"%");
					statement.setString(2,inpTitle+"%");
					ResultSet rs = statement.executeQuery();
					if(inpAuthor.equals("") && inpTitle.equals("")) {
						JOptionPane.showMessageDialog(btnSearch, "著者又はタイトルを入力してください。");
					}else {
						
						table_1.setModel(DbUtils.resultSetToTableModel(rs));;}
					}catch (SQLException ex) {
					ex.printStackTrace();
				}}});
		
		btnSearch.setFont(new Font("HGPｺﾞｼｯｸM", Font.PLAIN, 12));
		btnSearch.setBounds(165, 110, 79, 21);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int i =  table_1.getSelectedRow();
				TableModel model = table_1.getModel();
				
				ID.setText(model.getValueAt(i,0).toString());
				title_edit.setText(model.getValueAt(i,1).toString());
				publicDate_edit.setText(model.getValueAt(i,2).toString());
				author_edit.setText(model.getValueAt(i,3).toString());
				quantity_edit.setText(model.getValueAt(i,4).toString());
				overview_edit.setText(model.getValueAt(i,5).toString());
				
			}
		});
		scrollPane.setBounds(260, 0, 492, 384);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {},new String[] {"id","title", "publicDate", "overview", "author", "quantity"}));
	
		title_edit = new JTextField();
		title_edit.setColumns(10);
		title_edit.setBounds(107, 201, 137, 19);
		contentPane.add(title_edit);
		
		publicDate_edit = new JTextField();
		publicDate_edit.setColumns(10);
		publicDate_edit.setBounds(107, 230, 137, 19);
		contentPane.add(publicDate_edit);
		
		author_edit = new JTextField();
		author_edit.setColumns(10);
		author_edit.setBounds(107, 259, 137, 19);
		contentPane.add(author_edit);
		
		quantity_edit = new JTextField();
		quantity_edit.setColumns(10);
		quantity_edit.setBounds(107, 288, 137, 19);
		contentPane.add(quantity_edit);
		
		overview_edit = new JTextField();
		overview_edit.setColumns(10);
		overview_edit.setBounds(107, 320, 137, 19);
		contentPane.add(overview_edit);
		
		JLabel lblNewLabel_2 = new JLabel("title");
		lblNewLabel_2.setBounds(40, 204, 31, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("publicDate");
		lblNewLabel_2_1.setBounds(30, 233, 60, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("overview");
		lblNewLabel_2_2.setBounds(30, 323, 60, 13);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("author");
		lblNewLabel_2_3.setBounds(30, 262, 50, 13);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("quantity");
		lblNewLabel_2_4.setBounds(30, 291, 50, 13);
		contentPane.add(lblNewLabel_2_4);
		
		JButton btnDone = new JButton("\u5B8C\u4E86");
		btnDone.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Connection conn;
				PreparedStatement statement;
		        try {
		        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject?serverTimezone=JST","root","voice008");
                    String query = "UPDATE book SET title=?,publicDate=?,author=?,quantity=?,overview=? WHERE id= ? ";
                    statement = conn.prepareStatement(query);
                    statement.setString(6, ID.getText());
                    statement.setString(1, title_edit.getText()); 
                    statement.setString(2, publicDate_edit.getText()); 
                    statement.setString(3, author_edit.getText()); 
                    statement.setString(4, quantity_edit.getText()); 
                    statement.setString(5, overview_edit.getText()); 
                    statement.executeUpdate();
                       JOptionPane.showMessageDialog(null," successfully");
             } catch (Exception ex) {
            	 	   ex.printStackTrace();
             }
			
			    }});
		
		btnDone.setFont(new Font("HGPｺﾞｼｯｸM", Font.PLAIN, 11));
		btnDone.setBounds(176, 349, 67, 21);
		contentPane.add(btnDone);
		
		ID = new JTextField();
		ID.setEnabled(false);
		ID.setBounds(107, 171, 31, 19);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JLabel IDtx = new JLabel("ID");
		IDtx.setBounds(40, 174, 31, 13);
		contentPane.add(IDtx);
		
		JButton btnDelete = new JButton("\u524A\u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int art = JOptionPane.showConfirmDialog(null,"本当に削除しますか？","Delete",JOptionPane.YES_NO_OPTION);
				if (art==0) {
		        try {
		        	Connection conn;
					PreparedStatement statement;
		        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject?serverTimezone=JST","root","voice008");
                    String query = "delete from book where id = ? ";
                    statement = conn.prepareStatement(query);
                    statement.setString(1, ID.getText());
                    
                    statement.executeUpdate();
                       JOptionPane.showMessageDialog(null,"削除が完了しました");
             } catch (Exception ex) {
            	 	   ex.printStackTrace();
             }}
				
			
			}});
		btnDelete.setForeground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("HGPｺﾞｼｯｸM", Font.PLAIN, 12));
		btnDelete.setBounds(83, 349, 67, 21);
		//btnDelete.setBorder(new LineBorder(Color.RED, 1, false));
		contentPane.add(btnDelete);
		
		
		
		
		
			}
	}
