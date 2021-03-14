package Admin_package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Db_Models.Admin_model;
import Db_Models.EmployeeDetails;
import Db_Models.MenuItems;
//import Db_Models.Employdetail;
//import Db_Models.Menu_Items;
import Db_Models.Userdetails;
import db_Connection_Package.Admin_db;
//import Db_Models.customer_details;
import db_Connection_Package.EmployConnections;
import db_Connection_Package.SaveMenuItems;
import db_Connection_Package.UserConnections;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JSpinner.DateEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class Admin_Display_Pages extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	DefaultTableModel model2,model1;
	JLayeredPane layeredPane;
	
	private JTable table;
	private JTextField Item_id;
	private JTextField Item_name;
	private JTextField Item_Price;
	private JTextField item_Quantity;
	private JTextField Item_Review;
	private JTable table_1;
	private JTable table_2;
	private JTextField Employname_field;
	private JTextField Employ_phone;
	private JPasswordField passwordField_Emloy;
	private JTable table_3;
	
	public void switchPanels(JPanel jPanel)
	{
		layeredPane.removeAll();
		layeredPane.add(jPanel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public Admin_Display_Pages() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		SaveMenuItems smi = new SaveMenuItems();
		UserConnections uc =  new UserConnections();
		EmployConnections ec = new EmployConnections();
		Admin_db adb = new Admin_db();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1064, 686);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 156, 1050, 493);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel Display_menu = new JPanel();
		Display_menu.setBackground(Color.ORANGE);
		layeredPane.add(Display_menu, "name_15059102451800");
		Display_menu.setLayout(null);
		
		JTextArea menuitem_display = new JTextArea();
		menuitem_display.setEditable(false);
		menuitem_display.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		menuitem_display.setBackground(Color.ORANGE);
		menuitem_display.setBounds(129, 44, 800, 414);
		
		menuitem_display.append("~~~~~~~~~~~~~~~~~~~~0  MENU CARD  0~~~~~~~~~~~~~~~~~~~~~\n");
		ArrayList<MenuItems> menulist1  = new ArrayList<MenuItems>();
		try {
			menulist1 = smi.getmenu();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<menulist1.size();i++)
		{
			menuitem_display.append("                                "+menulist1.get(i).getItem_name()+"     -------------------------   Rs "+menulist1.get(i).getItem_price()+"\n");
		}
		
		
		Display_menu.add(menuitem_display);
		
		
		
		
		JPanel Edit_menu = new JPanel();
		Edit_menu.setBackground(Color.ORANGE);
		layeredPane.add(Edit_menu, "name_15062897246100");
		Edit_menu.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 24, 927, 222);
		Edit_menu.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		table.setBackground(Color.WHITE);
		table.setEnabled(true);
		
		Object[] column = {"Item Id", "Item Name", "Item Price", "Item Quantity", "Item review"};
		model = new DefaultTableModel();
		table.setModel(model);
		model.setColumnIdentifiers(column);
		final Object[] row = new Object[5];
		for(int i=0; i<menulist1.size();i++) {
			row[0] = String.valueOf(i+1);
			row[1] = menulist1.get(i).getItem_name();
			row[2] = "Rs " + menulist1.get(i).getItem_price();
			row[3] =  menulist1.get(i).getQuantity();
			row[4] =  menulist1.get(i).getReview();
			model.addRow(row);
			
		}
		Item_id = new JTextField();
		Item_id.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Item_id.setBounds(699, 298, 163, 26);
		Edit_menu.add(Item_id);
		Item_id.setColumns(10);
		
		Item_name = new JTextField();
		Item_name.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Item_name.setColumns(10);
		Item_name.setBounds(699, 334, 163, 26);
		Edit_menu.add(Item_name);
		
		Item_Price = new JTextField();
		Item_Price.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Item_Price.setColumns(10);
		Item_Price.setBounds(699, 370, 163, 26);
		Edit_menu.add(Item_Price);
		
		item_Quantity = new JTextField();
		item_Quantity.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		item_Quantity.setColumns(10);
		item_Quantity.setBounds(699, 406, 163, 26);
		Edit_menu.add(item_Quantity);
		
		Item_Review = new JTextField();
		Item_Review.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Item_Review.setColumns(10);
		Item_Review.setBounds(699, 442, 163, 26);
		Edit_menu.add(Item_Review);
		
		
		
		scrollPane.setViewportView(table);
		
		JButton add_btn = new JButton("Add");
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				if (Item_id.getText().equals("")||Item_name.getText().equals("")||Item_Price.getText().equals("")||Item_Review.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "Please fill the Information");
				}
				else {
				row[0] = Item_id.getText();
				row[1] = Item_name.getText();
				row[2] = Item_Price.getText();
				row[3] = item_Quantity.getText();
				row[4] = Item_Review.getText();
				
				MenuItems m = new MenuItems();
				m.setItem_name(Item_name.getText());
				double d = Double.parseDouble(Item_Price.getText());
				m.setItem_price(d);
				m.setReview(Item_Review.getText());
				m.setQuantity(Integer.parseInt(item_Quantity.getText()));
				
				smi.setmenu(m);
				model.addRow(row);
				
				Item_id.setText("");
				Item_name.setText("");
				item_Quantity.setText("");
				Item_Price.setText("");
				Item_Review.setText("");
				JOptionPane.showMessageDialog(null, "Saved Successfully");
				}
			}
		});
		add_btn.setBackground(Color.BLACK);
		add_btn.setFont(new Font("Times New Roman", Font.BOLD, 29));
		add_btn.setForeground(Color.WHITE);
		add_btn.setBounds(79, 369, 317, 54);
		Edit_menu.add(add_btn);
		
		JButton delete_btn = new JButton("Delete");
		delete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ii = table.getSelectedRow();
				String cell = table.getModel().getValueAt(ii, 1).toString();
				model.removeRow(ii);
				smi.deleteMenu(cell);
				
				
				
			}
		});
		delete_btn.setBackground(Color.BLACK);
		delete_btn.setForeground(Color.WHITE);
		delete_btn.setFont(new Font("Times New Roman", Font.BOLD, 29));
		delete_btn.setBounds(79, 297, 317, 54);
		Edit_menu.add(delete_btn);
		
		JLabel lblNewLabel_1 = new JLabel("Item name");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		lblNewLabel_1.setBounds(487, 333, 122, 26);
		Edit_menu.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Item Price");
		lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(487, 365, 122, 26);
		Edit_menu.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Item Quantity");
		lblNewLabel_1_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(487, 401, 163, 26);
		Edit_menu.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Item Review");
		lblNewLabel_1_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel_1_3.setBounds(487, 437, 163, 26);
		Edit_menu.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Item Id");
		lblNewLabel_1_4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		lblNewLabel_1_4.setBounds(487, 297, 99, 26);
		Edit_menu.add(lblNewLabel_1_4);
		
		
		JPanel Customer_list = new JPanel();
		Customer_list.setBackground(Color.ORANGE);
		layeredPane.add(Customer_list, "name_15064947373900");
		Customer_list.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(69, 104, 914, 314);
		Customer_list.add(scrollPane_1);
		
		
		table_1 = new JTable();
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		
		Object[] column2 = {"Customer Name", "Phone Number"};
		model2 = new DefaultTableModel();
		table_1.setModel(model2);
		model2.setColumnIdentifiers(column2);
		final Object[] row2 = new Object[2];
		ArrayList<Userdetails> cl = new ArrayList<Userdetails>();
		cl = uc.getUsers();
		for(int i=0; i<cl.size();i++) {	
			row2[0] = cl.get(i).getName();
			row2[1] = "+91 " + cl.get(i).getPhoneNo();
			model2.addRow(row2);			
		}
		
		
		scrollPane_1.setViewportView(table_1);
		
		JPanel Delivery_boys_Panel = new JPanel();
		Delivery_boys_Panel.setLayout(null);
		Delivery_boys_Panel.setBackground(Color.ORANGE);
		layeredPane.add(Delivery_boys_Panel, "name_18413995017700");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(62, 52, 921, 230);
		Delivery_boys_Panel.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Object[] column_2= {"Employee Name", "Phone number"};
		model1 = new DefaultTableModel();
		table_2.setModel(model1);
		model1.setColumnIdentifiers(column_2);
		final Object[] row3 = new Object[2];
		ArrayList<EmployeeDetails> ed = new ArrayList<EmployeeDetails>();
		ed = ec.getEmploys();
		for(int i=0; i<ed.size();i++) {	
			row3[0] = ed.get(i).getname();
			row3[1] = "+91 " + ed.get(i).getnumber();
			model1.addRow(row3);			
		}
		scrollPane_2.setViewportView(table_2);
		Employname_field = new JTextField();
		Employname_field.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		Employname_field.setBounds(701, 320, 183, 27);
		Delivery_boys_Panel.add(Employname_field);
		Employname_field.setColumns(10);
		
		Employ_phone = new JTextField();
		Employ_phone.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		Employ_phone.setColumns(10);
		Employ_phone.setBounds(701, 413, 183, 27);
		Delivery_boys_Panel.add(Employ_phone);
		
		passwordField_Emloy = new JPasswordField();
		passwordField_Emloy.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField_Emloy.setBounds(701, 365, 183, 27);
		Delivery_boys_Panel.add(passwordField_Emloy);
		
		JButton Add_employ_button = new JButton("Add");
		Add_employ_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeDetails ee = new EmployeeDetails();
				ee.setname(Employname_field.getText());
				ee.setPassword(passwordField_Emloy.getText());
				ee.setnumber(Employ_phone.getText());
				ec.registerEmployes(ee);
				row3[0] = Employname_field.getText();
				row3[1] = "+91 " + Employ_phone.getText();
				model1.addRow(row3);
				Employ_phone.setText("");
				Employname_field.setText("");
				passwordField_Emloy.setText("");
				
			}
		});
		Add_employ_button.setForeground(Color.WHITE);
		Add_employ_button.setFont(new Font("Tempus Sans ITC", Font.BOLD, 42));
		Add_employ_button.setBackground(Color.BLACK);
		Add_employ_button.setBounds(100, 353, 212, 79);
		Delivery_boys_Panel.add(Add_employ_button);
		
		JLabel lblNewLabel_2 = new JLabel("Employe Name");
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		lblNewLabel_2.setBounds(477, 308, 183, 50);
		Delivery_boys_Panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		lblNewLabel_2_1.setBounds(477, 353, 183, 50);
		Delivery_boys_Panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Phonenumber");
		lblNewLabel_2_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		lblNewLabel_2_2.setBounds(477, 399, 183, 50);
		Delivery_boys_Panel.add(lblNewLabel_2_2);
		
		
		
		JPanel orders_panel = new JPanel();
		orders_panel.setLayout(null);
		orders_panel.setBackground(Color.ORANGE);
		layeredPane.add(orders_panel, "name_18520568449000");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(64, 97, 941, 231);
		orders_panel.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Object[] column3 = { "Date","Customer Name","Item Name","Item Quantity","Delivery Boy","Delivary Status"};
		DefaultTableModel model4 = new DefaultTableModel();
		table_3.setModel(model4);
		model4.setColumnIdentifiers(column3);
		final Object[] row4 = new Object[5];
		ArrayList<Admin_model> am = new ArrayList<Admin_model>();
		am = adb.getorders();
		for(int i=0; i<am.size();i++) {	
			row4[0] = am.get(i).getDate().toString();
			row4[1] = am.get(i).getCustomer_name();
			row4[2] = am.get(i).getItemname();
			row4[3] = am.get(i).getQuantity();
			row4[4] = am.get(i).getDelivery_boy();
			
			model4.addRow(row4);			
		}
		
		scrollPane_3.setViewportView(table_3);
		
		JLabel lblNewLabel_3 = new JLabel("Assign Orders");
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 29));
		lblNewLabel_3.setBounds(398, 27, 197, 46);
		orders_panel.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 23));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(325, 395, 191, 40);
		comboBox.addItem("Select");
		for(int i=0; i<ed.size();i++) {	
			comboBox.addItem(ed.get(i).getname());	
		}
		orders_panel.add(comboBox);
		
		JLabel lblNewLabel_3_1 = new JLabel("Delivery Boys");
		lblNewLabel_3_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 29));
		lblNewLabel_3_1.setBounds(100, 391, 197, 46);
		orders_panel.add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("Assign");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ii = table_3.getSelectedRow();
				Date date;
				String customer_name = table_3.getModel().getValueAt(ii, 1).toString();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String dd = table_3.getModel().getValueAt(ii, 0).toString();
				try {
					date = formatter.parse(dd);
					String Deliveryboy = comboBox.getSelectedItem().toString();
					String Itemname = table_3.getModel().getValueAt(ii, 2).toString();
					int quant =Integer.valueOf(table_3.getModel().getValueAt(ii, 3).toString()) ;
					adb.assignOrders(customer_name,Deliveryboy,date,Itemname,quant);
					table_3.getModel().setValueAt(Deliveryboy, ii, 4);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		btnNewButton.setBounds(598, 366, 173, 97);
		orders_panel.add(btnNewButton);
		
		
		
		JButton MenuCard_display_btn = new JButton("Menu card");
		
		JButton Editmenu_btn = new JButton("Edit Menu");
		
		JButton Display_cust_btn = new JButton("Customers");
		
		JButton delivery_boys_btn = new JButton("Delivery Boys");
		
		JButton orser_btn = new JButton("Orders");
		
		MenuCard_display_btn.setBackground(Color.WHITE);
		MenuCard_display_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		MenuCard_display_btn.setBounds(219, 10, 179, 48);
		MenuCard_display_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Display_menu);
				Editmenu_btn.setBackground(Color.ORANGE);
				Display_cust_btn.setBackground(Color.ORANGE);
				MenuCard_display_btn.setBackground(new Color(255,255,255));
				delivery_boys_btn.setBackground(Color.ORANGE);
				orser_btn.setBackground(Color.ORANGE);
			}
		});
		contentPane.add(MenuCard_display_btn);
		
		
		Editmenu_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		Editmenu_btn.setBackground(Color.ORANGE);
		Editmenu_btn.setBounds(219, 88, 280, 48);
		Editmenu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Edit_menu);
				MenuCard_display_btn.setBackground(Color.ORANGE);
				Display_cust_btn.setBackground(Color.ORANGE);
				Editmenu_btn.setBackground(new Color(255,255,255));
				delivery_boys_btn.setBackground(Color.ORANGE);
				orser_btn.setBackground(Color.ORANGE);
			}
		});
		contentPane.add(Editmenu_btn);
		
		
		Display_cust_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		Display_cust_btn.setBackground(Color.ORANGE);
		Display_cust_btn.setBounds(438, 10, 179, 48);
		Display_cust_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Customer_list);
				Editmenu_btn.setBackground(Color.ORANGE);
				MenuCard_display_btn.setBackground(Color.ORANGE);
				Display_cust_btn.setBackground(new Color(255,255,255));
				delivery_boys_btn.setBackground(Color.ORANGE);
				orser_btn.setBackground(Color.ORANGE);
			}
		});
		contentPane.add(Display_cust_btn);
		
		JLabel lblNewLabel = new JLabel("Hello Admin");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(853, 63, 234, 48);
		contentPane.add(lblNewLabel);
		
		JLabel img_dis = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/restaurant_logo.jfif")).getImage();
		img_dis.setIcon(new ImageIcon(img));
		img_dis.setBounds(-42, 10, 234, 136);
		contentPane.add(img_dis);
		
		
		delivery_boys_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Delivery_boys_Panel);
				Editmenu_btn.setBackground(Color.ORANGE);
				MenuCard_display_btn.setBackground(Color.ORANGE);
				Display_cust_btn.setBackground(Color.ORANGE);
				delivery_boys_btn.setBackground(Color.WHITE);
				orser_btn.setBackground(Color.ORANGE);
			}
		});
		delivery_boys_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		delivery_boys_btn.setBackground(Color.ORANGE);
		delivery_boys_btn.setBounds(546, 88, 280, 48);
		contentPane.add(delivery_boys_btn);
		
		
		orser_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(orders_panel);
				Editmenu_btn.setBackground(Color.ORANGE);
				MenuCard_display_btn.setBackground(Color.ORANGE);
				Display_cust_btn.setBackground(Color.ORANGE);
				delivery_boys_btn.setBackground(Color.ORANGE);
				orser_btn.setBackground(Color.WHITE);
			}
		});
		orser_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		orser_btn.setBackground(Color.ORANGE);
		orser_btn.setBounds(649, 10, 179, 48);
		contentPane.add(orser_btn);

	}
}