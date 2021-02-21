package Customer_Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LoginPages_Package.Admin_Customer_Login;

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
//
//	/**
//	 * Launch the application.
//	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Display_page frame = new Customer_Display_page("kumpelli");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//
	/**
//	 * Create the frame.
//	 */
	public void switchPanels(JPanel jPanel)
	{
		layeredPane.removeAll();
		layeredPane.add(jPanel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	public Customer_Display_page(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//		ArrayList<Menuitems> menulist1 = new ArrayList<Menuitems>();
//		Customer_db cdb = new Customer_db(name);
//		
//		Save_Menu sm = new Save_Menu();
//		menulist1 = sm.getMenu();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1064, 686);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 157, 1050, 492);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
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
//		for(int i=0;i<menulist1.size();i++)
//		{
//			
//			menudis.append("                        "+menulist1.get(i).getItemname()+"     -------------------------   Rs "+menulist1.get(i).getItemprice()+"\n");
//		}
		Display_menu_items.add(menudis);
		
		JPanel MakeOrder = new JPanel();
		MakeOrder.setBackground(Color.ORANGE);
		MakeOrder.setLayout(null);
		layeredPane.add(MakeOrder, "name_46061419026800");
		
		JComboBox Menulist_disp_select = new JComboBox();
		Menulist_disp_select.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		Menulist_disp_select.setBackground(Color.WHITE);
		Menulist_disp_select.setBounds(218, 103, 177, 43);
//		for(int i=0;i<menulist1.size();i++)
//		{
//			Menulist_disp_select.addItem(menulist1.get(i).getItemname());
//		}
		
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
		Object[] column = {"Item Name","Item Quantity", "Item Price",};
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.setColumnIdentifiers(column);
		
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Add");
		final Object[] row = new Object[3];
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String item =  Menulist_disp_select.getSelectedItem().toString();
//				int quan = Integer.parseInt(quantity_select.getText());
//				double price_each = cdb.getpriceofItem(item);
//				double ttp = price_each*quan;
//				
//				row[0] = item;
//				row[1] = quan;
//				row[2] = ttp;
//				bill = bill+ttp;
//				
//				cdb.sendData(item, ttp);
//				
//				model.addRow(row);
//				
//			}
//		});
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(10, 300, 190, 53);
		MakeOrder.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 27));
		lblNewLabel_2.setBounds(618, 401, 259, 53);
		MakeOrder.add(lblNewLabel_2);
		
		JButton btnGenerateBill = new JButton("Generate Bill");
		btnGenerateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setText("Total    :  "+bill);
				
				
			}
		});
		btnGenerateBill.setForeground(Color.WHITE);
		btnGenerateBill.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		btnGenerateBill.setBackground(Color.BLACK);
		btnGenerateBill.setBounds(244, 298, 185, 56);
		MakeOrder.add(btnGenerateBill);
		
		JButton btnPayBill = new JButton("Pay Bill");
		btnPayBill.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JOptionPane.showConfirmDialog(null, "Pay "+bill);
				JOptionPane.showMessageDialog(null, "Payment Successfull");
				try {
					btnLoginActionPerformed(evt);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		
		JLabel lblNewLabel = new JLabel("Hello "+name);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(850, 54, 216, 55);
		contentPane.add(lblNewLabel);
		
		JButton MenuCard_btn = new JButton("Menu Card");
		JButton MakeOrder_btn = new JButton("Order Now");
		JButton btnPreviousOrders = new JButton("My Orders");
		
		MenuCard_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Display_menu_items);
				MenuCard_btn.setBackground(Color.WHITE);
				MakeOrder_btn.setBackground(Color.ORANGE);
				btnPreviousOrders.setBackground(Color.ORANGE);
			}
		});
		MenuCard_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		MenuCard_btn.setBackground(Color.WHITE);
		MenuCard_btn.setForeground(Color.BLACK);
		MenuCard_btn.setBounds(283, 56, 152, 51);
		contentPane.add(MenuCard_btn);
		
		
		MakeOrder_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(MakeOrder);
				MenuCard_btn.setBackground(Color.ORANGE);
				MakeOrder_btn.setBackground(Color.WHITE);
				btnPreviousOrders.setBackground(Color.ORANGE);
				
			}
		});
		MakeOrder_btn.setForeground(Color.BLACK);
		MakeOrder_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		MakeOrder_btn.setBackground(Color.ORANGE);
		MakeOrder_btn.setBounds(470, 55, 152, 53);
		contentPane.add(MakeOrder_btn);
		
		
		btnPreviousOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Order_History);
				btnPreviousOrders.setBackground(Color.WHITE);
				MakeOrder_btn.setBackground(Color.ORANGE);
				MenuCard_btn.setBackground(Color.ORANGE);
			}
		});
		btnPreviousOrders.setForeground(Color.BLACK);
		btnPreviousOrders.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btnPreviousOrders.setBackground(Color.ORANGE);
		btnPreviousOrders.setBounds(658, 54, 152, 55);
		contentPane.add(btnPreviousOrders);
		
		JLabel Img_dis = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/restaurant_logo.jfif")).getImage();
		Img_dis.setIcon(new ImageIcon(img));
		Img_dis.setBounds(-27, 10, 216, 137);
		contentPane.add(Img_dis);
	}
	
private void btnLoginActionPerformed(final java.awt.event.ActionEvent evt) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Admin_Customer_Login r = new Admin_Customer_Login();
        r.setVisible(true);
        this.dispose();
    }
}
