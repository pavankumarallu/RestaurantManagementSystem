package Customer_Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Chatpackage.Support;
import Db_Models.BillModel;
import Db_Models.CustomerEach;
import Db_Models.EmployeeEach;
import Db_Models.MenuItems;
import LoginPages_Package.Admin_Customer_Login;
import Suggest_package.Suggestions;
import bill_package.Bill_Section;
import db_Connection_Package.CustomerConnections;
import db_Connection_Package.SaveMenuItems;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Customer_Display_page extends JFrame {

	private JPanel contentPane;
	JLayeredPane layeredPane;
	private JTextField quantity_select;
	private JTable table;
	double bill = 0;
	public void switchPanels(JPanel jPanel)
	{
		layeredPane.removeAll();
		layeredPane.add(jPanel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	public Customer_Display_page(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		ArrayList<MenuItems> menulist1 = new ArrayList<MenuItems>();
		SaveMenuItems smi = new SaveMenuItems();
		CustomerConnections cc = new CustomerConnections(name);
		try {
			menulist1 = cc.getmenuPref();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setTitle("CUSTOMER PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1064, 686);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 157, 1070, 508);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel Trackorder_panel = new JPanel();
		
		JPanel Display_menu_items = new JPanel();
		Display_menu_items.setBackground(Color.ORANGE);
		layeredPane.add(Display_menu_items, "name_45985513417700");
		Display_menu_items.setLayout(null);
		
		JTextArea menudis = new JTextArea();
		menudis.setEditable(false);
		menudis.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 23));
		menudis.setBackground(Color.ORANGE);
		menudis.setBounds(94, 22, 846, 435);
		menudis.append("~~~~~~~~~~~~~~~~~0  MENU CARD  0~~~~~~~~~~~~~~~~~\n\n");
		
		for(int i=0;i<menulist1.size();i++)
		{
			
			menudis.append("                        "+menulist1.get(i).getItem_name()+"     -------------------------   Rs "+menulist1.get(i).getItem_price()+"\n");
		}
		Display_menu_items.add(menudis);
		
		JPanel MakeOrder = new JPanel();
		MakeOrder.setBackground(Color.ORANGE);
		MakeOrder.setLayout(null);
		layeredPane.add(MakeOrder, "name_46061419026800");
		
		JComboBox Menulist_disp_select = new JComboBox();
		Menulist_disp_select.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		Menulist_disp_select.setBackground(Color.WHITE);
		Menulist_disp_select.setBounds(218, 103, 177, 43);
		Menulist_disp_select.addItem("Select Item");
		for(int i=0;i<menulist1.size();i++)
		{
			Menulist_disp_select.addItem(menulist1.get(i).getItem_name());
		}
		
		MakeOrder.add(Menulist_disp_select);
		
		JLabel lblNewLabel_1 = new JLabel("Select Item");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		lblNewLabel_1.setBounds(47, 96, 124, 53);
		MakeOrder.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		lblNewLabel_1_1.setBounds(47, 200, 124, 53);
		MakeOrder.add(lblNewLabel_1_1);
		
		quantity_select = new JTextField();
		quantity_select.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 17));
		quantity_select.setForeground(new Color(0, 0, 0));
		quantity_select.setBackground(Color.WHITE);
		quantity_select.setBounds(218, 200, 177, 40);
		MakeOrder.add(quantity_select);
		quantity_select.setColumns(10);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(576, 48, 439, 305);
		MakeOrder.add(scrollPane);
		
		table = new JTable();
		Object[] column = {"Item Name","Item Quantity", "Item Price"};
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.setColumnIdentifiers(column);
		
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 27));
		lblNewLabel_2.setBounds(618, 401, 259, 53);
		
		JButton btnNewButton = new JButton("Add");
		ArrayList<BillModel> bmlist = new ArrayList<BillModel>();
		final Object[] row = new Object[3];
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillModel bm = new BillModel();
				String item =  Menulist_disp_select.getSelectedItem().toString();
				int quan = Integer.parseInt(quantity_select.getText());
				double price_each = smi.getpriceofItem(item);
				double ttp = price_each*quan;
				
				row[0] = item;
				row[1] = quan;
				row[2] = ttp;
				bill = bill+ttp;
				
				CustomerEach ce = new CustomerEach();
				ce.setitem_name(item);
				ce.setitem_price(ttp);
				ce.setquantity(quan);
				
				cc.MakeOrder(ce);
				
				model.addRow(row);
				
				bm.setItemname(item);
				bm.setQuantity(quan);
				bm.setRate(ttp);
				bmlist.add(bm);
				
				
				
				lblNewLabel_2.setText("    Rs. "+String.valueOf(bill));
				
				Menulist_disp_select.setSelectedIndex(0);
				quantity_select.setText("");
				
			}
		});
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(10, 300, 419, 53);
		MakeOrder.add(btnNewButton);
		
		
		MakeOrder.add(lblNewLabel_2);
		
		JButton btnPayBill = new JButton("Pay and Generate Bill");
		btnPayBill.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
				btnclickperformed(bmlist,name);
			}
		});
		btnPayBill.setForeground(Color.WHITE);
		btnPayBill.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		btnPayBill.setBackground(Color.BLACK);
		btnPayBill.setBounds(10, 377, 419, 56);
		MakeOrder.add(btnPayBill);
		
		
		
		JPanel Order_History = new JPanel();
		Order_History.setBackground(Color.ORANGE);
		Order_History.setLayout(null);
		layeredPane.add(Order_History, "name_46066417324100");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 1050, 492);
		Order_History.add(scrollPane_2);
		ArrayList<CustomerEach> eee = new ArrayList<CustomerEach>();
		eee = cc.getHistory();
		JTextArea textArea = new JTextArea();
		if (eee.size() == 0) {
			textArea.append("\n\n\n\n\n\n                                                                   NO Orders");
		}
		else {
			textArea.append("\n\n                                                                    History\n\n");
		
			for (int i = 0; i < eee.size(); i++) {
				textArea.append("                                                   Item name         :  "+eee.get(i).getitem_name()+"\n");
				textArea.append("                                                   Item quantity    :  "+eee.get(i).getquantity()+"\n");
				
				if (eee.get(i).getDelivaryStatus() == false) {
					textArea.append("                                                    Delivery Status   :  Not Delivered\n");
				}
				else
				{
					textArea.append("                                                    Delivery Status   :  Delivered\n");
				}
				textArea.append("                                            ---------------------------------------------------\n\n");
			}
		}
		
		textArea.setBackground(Color.ORANGE);
		textArea.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		scrollPane_2.setViewportView(textArea);
		
		
		Trackorder_panel.setLayout(null);
		Trackorder_panel.setBackground(Color.ORANGE);
		layeredPane.add(Trackorder_panel, "name_4951457090000");
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 1050, 492);
		Trackorder_panel.add(scrollPane_1);
		
		JTextArea TrackOrder_Area = new JTextArea();
		scrollPane_1.setViewportView(TrackOrder_Area);
		ArrayList<CustomerEach> celist = new ArrayList<CustomerEach>();
		
		celist = cc.getTrackdetails();
		
		if (celist.size() == 0) {
			TrackOrder_Area.append("\n\n\n\n\n\n                                                                   NO Orders");
		}
		else {
			TrackOrder_Area.append("\n\n                                                                     Tracking Details\n\n");
		
			for (int i = 0; i < celist.size(); i++) {
				TrackOrder_Area.append("                                                      Item name         :  "+celist.get(i).getitem_name()+"\n");
				TrackOrder_Area.append("                                                      Item quantity    :  "+celist.get(i).getquantity()+"\n");
				if (celist.get(i).getOrderstatus() == false && celist.get(i).getDelivaryStatus() == false) {
					TrackOrder_Area.append("                                                      OrderStatus       :  Order Received"+"\n");
				}
				else if(celist.get(i).getOrderstatus() == true && celist.get(i).getDelivaryStatus() == false) {
					TrackOrder_Area.append("                                                      OrderStatus       :  Ready for Delivery\n");
				}
				else if(celist.get(i).getOrderstatus() == true && celist.get(i).getDelivaryStatus() == true) {
					TrackOrder_Area.append("                                                      Delivery Status   :  Delivered\n");
				}
				TrackOrder_Area.append("                                                         Delivered By      :  "+celist.get(i).getDelivaryboy()+"\n");
			
				TrackOrder_Area.append("                                               ---------------------------------------------------\n\n");
			}
		}
		TrackOrder_Area.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		TrackOrder_Area.setLineWrap(true);
		
		TrackOrder_Area.setBackground(Color.ORANGE);
		
		
		JLabel lblNewLabel = new JLabel("Hello "+name);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(873, 10, 197, 55);
		contentPane.add(lblNewLabel);
		
		JButton MenuCard_btn = new JButton("Menu Card");
		JButton MakeOrder_btn = new JButton("Order Now");
		JButton btnPreviousOrders = new JButton("My Orders");
		JButton btnTrackOrder = new JButton("Track order");
		
		MenuCard_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Display_menu_items);
				MenuCard_btn.setBackground(Color.WHITE);
				MakeOrder_btn.setBackground(Color.ORANGE);
				btnPreviousOrders.setBackground(Color.ORANGE);
				btnTrackOrder.setBackground(Color.ORANGE);
				
			}
		});
		MenuCard_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		MenuCard_btn.setBackground(Color.WHITE);
		MenuCard_btn.setForeground(Color.BLACK);
		MenuCard_btn.setBounds(225, 12, 152, 51);
		contentPane.add(MenuCard_btn);
		
		
		MakeOrder_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(MakeOrder);
				MenuCard_btn.setBackground(Color.ORANGE);
				MakeOrder_btn.setBackground(Color.WHITE);
				btnPreviousOrders.setBackground(Color.ORANGE);
				btnTrackOrder.setBackground(Color.ORANGE);
				
			}
		});
		MakeOrder_btn.setForeground(Color.BLACK);
		MakeOrder_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		MakeOrder_btn.setBackground(Color.ORANGE);
		MakeOrder_btn.setBounds(225, 93, 152, 53);
		contentPane.add(MakeOrder_btn);
		
		
		btnPreviousOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Order_History);
				btnPreviousOrders.setBackground(Color.WHITE);
				MakeOrder_btn.setBackground(Color.ORANGE);
				MenuCard_btn.setBackground(Color.ORANGE);
				btnTrackOrder.setBackground(Color.ORANGE);
			}
		});
		btnPreviousOrders.setForeground(Color.BLACK);
		btnPreviousOrders.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btnPreviousOrders.setBackground(Color.ORANGE);
		btnPreviousOrders.setBounds(424, 10, 152, 55);
		contentPane.add(btnPreviousOrders);
		
		JLabel Img_dis = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/restaurant_logo.jfif")).getImage();
		Img_dis.setIcon(new ImageIcon(img));
		Img_dis.setBounds(-62, 10, 216, 137);
		contentPane.add(Img_dis);
		
		btnTrackOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Trackorder_panel);
				btnPreviousOrders.setBackground(Color.ORANGE);
				MakeOrder_btn.setBackground(Color.ORANGE);
				MenuCard_btn.setBackground(Color.ORANGE);
				btnTrackOrder.setBackground(Color.WHITE);
			}
		});
		btnTrackOrder.setForeground(Color.BLACK);
		btnTrackOrder.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btnTrackOrder.setBackground(Color.ORANGE);
		btnTrackOrder.setBounds(424, 92, 152, 55);
		contentPane.add(btnTrackOrder);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Logout(evt);
			}
		});
		btnNewButton_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnNewButton_1.setBounds(883, 75, 117, 35);
		contentPane.add(btnNewButton_1);
		
		JButton Supports = new JButton("Customer Support");
		Supports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnsupport(e,name);
			}
		});
		Supports.setBackground(Color.ORANGE);
		Supports.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		Supports.setBounds(601, 9, 229, 55);
		contentPane.add(Supports);
		
		JButton btnRateUs = new JButton("Rate us");
		btnRateUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taketorate(e,name);
			}
		});
		btnRateUs.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		btnRateUs.setBackground(Color.ORANGE);
		btnRateUs.setBounds(601, 93, 229, 55);
		contentPane.add(btnRateUs);
	}
	
private void taketorate(ActionEvent e, String name) {
		// TODO Auto-generated method stub
	Suggestions s = new Suggestions(name);
	s.setVisible(true);
	this.dispose();
		
	}

private void btnsupport(ActionEvent e, String name) {
		Support s = new Support(name);
		s.setVisible(true);
		this.dispose();
		
	}

private void btnclickperformed(ArrayList<BillModel> bmlist, String name) {
		if (bmlist.size() == 0) {
			JOptionPane.showMessageDialog(null, "Please Select items");
		}
		else
		{
			JOptionPane.showConfirmDialog(null, "Pay "+bill);
			JOptionPane.showMessageDialog(null, "Payment Successfull");
			Bill_Section bs = new Bill_Section(bmlist, name);
			bs.setVisible(true);
			this.dispose();
		}
		
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
