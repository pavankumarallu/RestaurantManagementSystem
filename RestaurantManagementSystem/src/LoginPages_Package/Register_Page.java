package LoginPages_Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Db_Models.Userdetails;
import db_Connection_Package.UserConnections;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class Register_Page extends JFrame {

	private JPanel contentPane;
	private JTextField Username_field;
	private JTextField Phone_number_field;
	private JPasswordField passwordField;
	private JPasswordField RepasswordField_1;
	private JTextField pin;

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public Register_Page() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("REGISTER");
		setBounds(100, 100, 1229, 788);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 438, 767);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alpha");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 56));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(116, 329, 193, 69);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Restaurant");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 50));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(78, 382, 327, 104);
		panel.add(lblNewLabel_1);
		
		JLabel Image_Display = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/restaurant_logo.jfif")).getImage();
		Image_Display.setIcon(new ImageIcon(img));
		Image_Display.setBounds(37, 32, 308, 366);
		
		panel.add(Image_Display);
		
		JLabel lblNewLabel_2 = new JLabel("Register");
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 50));
		lblNewLabel_2.setBounds(752, 29, 216, 62);
		contentPane.add(lblNewLabel_2);
		
		JLabel userfield_name = new JLabel("Username");
		userfield_name.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		userfield_name.setBounds(612, 153, 132, 46);
		contentPane.add(userfield_name);
		
		JLabel Password_name = new JLabel("Password");
		Password_name.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		Password_name.setBounds(612, 211, 132, 46);
		contentPane.add(Password_name);
		
		JLabel Password_name_1 = new JLabel("Re-Enter Password");
		Password_name_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		Password_name_1.setBounds(612, 267, 223, 46);
		contentPane.add(Password_name_1);
		
		JLabel phone_no_filed_name = new JLabel("Phone number");
		phone_no_filed_name.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		phone_no_filed_name.setBounds(612, 323, 186, 46);
		contentPane.add(phone_no_filed_name);
		
		Username_field = new JTextField();
		Username_field.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 23));
		Username_field.setBounds(863, 158, 202, 40);
		contentPane.add(Username_field);
		Username_field.setColumns(10);
		
		Phone_number_field = new JTextField();
		Phone_number_field.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 23));
		Phone_number_field.setColumns(10);
		Phone_number_field.setBounds(863, 328, 202, 40);
		contentPane.add(Phone_number_field);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(863, 220, 202, 40);
		contentPane.add(passwordField);
		
		RepasswordField_1 = new JPasswordField();
		RepasswordField_1.setBounds(863, 273, 202, 40);
		contentPane.add(RepasswordField_1);
		
		JLabel phone_no_filed_name_1 = new JLabel("Address");
		phone_no_filed_name_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		phone_no_filed_name_1.setBounds(612, 397, 186, 46);
		contentPane.add(phone_no_filed_name_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		textArea.setWrapStyleWord(true);
		textArea.setBounds(863, 402, 202, 90);
		contentPane.add(textArea);
		
		JLabel phone_no_filed_name_1_1 = new JLabel("Preferences");
		phone_no_filed_name_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		phone_no_filed_name_1_1.setBounds(612, 575, 186, 46);
		contentPane.add(phone_no_filed_name_1_1);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(863, 577, 202, 46);
		comboBox.addItem("Select Preferences");
		comboBox.addItem("Veg");
		comboBox.addItem("Non-Veg");
		contentPane.add(comboBox);
		
		pin = new JTextField();
		pin.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 23));
		pin.setColumns(10);
		pin.setBounds(863, 511, 202, 40);
		contentPane.add(pin);
		
		
		JButton Reg_btn = new JButton("Register");
		Reg_btn.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					String user = Username_field.getText();
					String pass = passwordField.getText();
					String repass = RepasswordField_1.getText();
					String ph = Phone_number_field.getText();
					String Address = textArea.getText();
					String pinc = pin.getText();
					String Pref = comboBox.getSelectedItem().toString();
					if(pass.equals(repass))
					{
						btnLoginActionPerformed(evt,user,pass,ph,Address,Pref,pinc);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Password not Matched.");
					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e.toString());
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e.toString());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e.toString());
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e.toString());
				}
				
			}
		});
		Reg_btn.setBackground(Color.BLACK);
		Reg_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
		Reg_btn.setForeground(new Color(255, 255, 255));
		Reg_btn.setBounds(752, 646, 210, 62);
		contentPane.add(Reg_btn);
		
		JLabel phone_no_filed_name_1_2 = new JLabel("Pincode");
		phone_no_filed_name_1_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		phone_no_filed_name_1_2.setBounds(612, 505, 186, 46);
		contentPane.add(phone_no_filed_name_1_2);
		
		
		
		
	}
	
	private void btnLoginActionPerformed(final java.awt.event.ActionEvent evt, String user, String pass, String ph,String Address,String Pref,String pinc) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        
		Userdetails uu = new Userdetails();
		uu.setName(user);
		uu.setPassword(pass);
		uu.setPhoneNo(ph);
		uu.setAddress(Address);
		uu.setPref(Pref);
		uu.setPincode(pinc);
		UserConnections uc = new UserConnections();
		uc.RegisterUser(uu);
		
		Admin_Customer_Login acl = new Admin_Customer_Login();
		acl.setVisible(true);
		this.dispose();
    }
}
