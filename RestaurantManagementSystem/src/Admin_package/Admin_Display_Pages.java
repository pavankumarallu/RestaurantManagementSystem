package Admin_package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Admin_Display_Pages extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	DefaultTableModel model2;
	JLayeredPane layeredPane;
	
	private JTable table;
	private JTextField Item_id;
	private JTextField Item_name;
	private JTextField Item_Price;
	private JTextField item_Quantity;
	private JTextField Item_Review;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Display_Pages frame = new Admin_Display_Pages();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
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
//		for(int i=0;i<menulist1.size();i++)
//		{
//			menuitem_display.append("\n");
//			menuitem_display.append("                                "+menulist1.get(i).getItemname()+"     -------------------------   Rs "+menulist1.get(i).getItemprice()+"\n");
//		}
//		
		
		Display_menu.add(menuitem_display);
		
		
		
		
		JPanel Edit_menu = new JPanel();
		Edit_menu.setBackground(Color.ORANGE);
		layeredPane.add(Edit_menu, "name_15062897246100");
		Edit_menu.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 24, 927, 222);
		Edit_menu.add(scrollPane);
		
		table = new JTable();
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
//		for(int i=0; i<menulist1.size();i++) {
//			row[0] = String.valueOf(i+1);
//			row[1] = menulist1.get(i).getItemname();
//			row[2] = "Rs " + menulist1.get(i).getItemprice();
//			row[3] =  menulist1.get(i).getItemquantity();
//			row[4] =  menulist1.get(i).getItemreviews();
//			model.addRow(row);
//			
//		}
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
				//TODO
				
				
			}
		});
		delete_btn.setBackground(Color.BLACK);
		delete_btn.setForeground(Color.WHITE);
		delete_btn.setFont(new Font("Times New Roman", Font.BOLD, 29));
		delete_btn.setBounds(79, 297, 317, 54);
		Edit_menu.add(delete_btn);
		
		JLabel lblNewLabel_1 = new JLabel("Item name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(487, 333, 99, 26);
		Edit_menu.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Item Price");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(487, 365, 99, 26);
		Edit_menu.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Item Quantity");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1_2.setBounds(487, 401, 122, 26);
		Edit_menu.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Item Review");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1_3.setBounds(487, 437, 122, 26);
		Edit_menu.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Item Id");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
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
		table_1.setFont(new Font("Lucida Fax", Font.PLAIN, 18));
		
		Object[] column2 = {"Customer Name", "Phone Number"};
		model2 = new DefaultTableModel();
		table_1.setModel(model2);
		model2.setColumnIdentifiers(column2);
		final Object[] row2 = new Object[2];
	
		
		
		scrollPane_1.setViewportView(table_1);
		
		JPanel Delivery_boys_Panel = new JPanel();
		Delivery_boys_Panel.setLayout(null);
		Delivery_boys_Panel.setBackground(Color.ORANGE);
		layeredPane.add(Delivery_boys_Panel, "name_18413995017700");
		
		JPanel orders_panel = new JPanel();
		orders_panel.setLayout(null);
		orders_panel.setBackground(Color.ORANGE);
		layeredPane.add(orders_panel, "name_18520568449000");
		
		
		
		JButton MenuCard_display_btn = new JButton("Menu card");
		
		JButton Editmenu_btn = new JButton("Edit Menu");
		
		JButton Display_cust_btn = new JButton("Customers");
		
		
		
		MenuCard_display_btn.setBackground(Color.WHITE);
		MenuCard_display_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		MenuCard_display_btn.setBounds(219, 10, 179, 48);
		MenuCard_display_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Display_menu);
				Editmenu_btn.setBackground(Color.ORANGE);
				Display_cust_btn.setBackground(Color.ORANGE);
				MenuCard_display_btn.setBackground(new Color(255,255,255));
				
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
		
		JButton delivery_boys_btn = new JButton("Delivery Boys");
		delivery_boys_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Delivery_boys_Panel);
			}
		});
		delivery_boys_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		delivery_boys_btn.setBackground(Color.ORANGE);
		delivery_boys_btn.setBounds(546, 88, 280, 48);
		contentPane.add(delivery_boys_btn);
		
		JButton orser_btn = new JButton("Orders");
		orser_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(orders_panel);
			}
		});
		orser_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		orser_btn.setBackground(Color.ORANGE);
		orser_btn.setBounds(649, 10, 179, 48);
		contentPane.add(orser_btn);
		
		

	}
}
