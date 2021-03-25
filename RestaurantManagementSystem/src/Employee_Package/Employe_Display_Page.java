package Employee_Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Db_Models.EmployeeEach;
import LoginPages_Package.Admin_Customer_Login;
import db_Connection_Package.Employee_db;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Employe_Display_Page extends JFrame {

	private JPanel contentPane;
	private JTable table;
	

	
	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public Employe_Display_Page(String Name) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		Employee_db edb = new Employee_db(Name);
		
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1064, 686);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1050, 163);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLYOYEE PAGE");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(394, 58, 251, 59);
		panel.add(lblNewLabel);
		
		JLabel ImgDis = new JLabel("New label");
		ImgDis.setBounds(-30, 0, 282, 153);
		Image img = new ImageIcon(this.getClass().getResource("/restaurant_logo.jfif")).getImage();
		ImgDis.setIcon(new ImageIcon(img));
		panel.add(ImgDis);
		
		JLabel lblHi = new JLabel(Name);
		lblHi.setForeground(Color.WHITE);
		lblHi.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 28));
		lblHi.setBounds(812, 39, 211, 43);
		panel.add(lblHi);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Logout(evt);
			}
		});
		btnNewButton_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(835, 92, 106, 43);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("DONE");
		
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(437, 546, 207, 58);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 283, 971, 233);
		contentPane.add(scrollPane);
		
		table = new JTable();
		Object[] column = {"Customer Name", "Phone No.","Address","Pincode","Item Name", "Item Quantity"};
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		final Object[] row = new Object[6];
		
		ArrayList<EmployeeEach> eelist = new ArrayList<EmployeeEach>();
		eelist = edb.getmyOrders();
		
		model.setColumnIdentifiers(column);
		for(int i=0; i<eelist.size();i++) {
			row[0] = eelist.get(i).getcustomer_name();
			row[1] = eelist.get(i).getcust_ph_no();
			row[2] = eelist.get(i).getAddress();
			row[3] =  eelist.get(i).getPincode();
			row[4] = eelist.get(i).getmenu_item();
			row[5] = eelist.get(i).getquantity();
			model.addRow(row);
		}
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Assigned Orders");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 38));
		lblNewLabel_1.setBounds(374, 204, 301, 52);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ii = table.getSelectedRow();
				String itemname = table.getModel().getValueAt(ii, 4).toString();
				String custname = table.getModel().getValueAt(ii, 0).toString();
				model.removeRow(ii);
				edb.updatedeliverystatus(custname, itemname);
			}
		});
		contentPane.add(lblNewLabel_1);
	}
	private void Logout(ActionEvent evt) {
		Admin_Customer_Login acl;
		try {
			JOptionPane.showMessageDialog(null, "Logged Out Successfully");
			acl = new Admin_Customer_Login();
			acl.setVisible(true);
			this.dispose();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
