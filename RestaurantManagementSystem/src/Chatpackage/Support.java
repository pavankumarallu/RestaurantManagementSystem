package Chatpackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Support extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Support frame = new Support("pavan");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public Support(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1346, 739);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 426, 706);
		contentPane.add(panel);
		panel.setLayout(null);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(427, 76, 905, 535);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		textArea.setBackground(Color.ORANGE);
		scrollPane.setViewportView(textArea);
		textArea.append("Team Alpha  :   Hello "+name+", How may I help you\n");
		
		JLabel lblNewLabel_1 = new JLabel("General Queries");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(114, 179, 194, 44);
		panel.add(lblNewLabel_1);
		
		JButton Problem_7_btn = new JButton("Food taste is unsatisfactory");
		Problem_7_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("\t\t\t                     "+name+" :  Food taste is unsatisfactory\n");
				textArea.append("Team Alpha  :   Sorry for the inconvinience\n");
			}
		});
		Problem_7_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		Problem_7_btn.setBackground(Color.ORANGE);
		Problem_7_btn.setBounds(10, 462, 406, 37);
		Problem_7_btn.setVisible(false);
		panel.add(Problem_7_btn);
		
		JButton Problem_9_btn = new JButton("Burnt or oily food");
		Problem_9_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("\t\t\t                     "+name+" :  Burnt or oily food\n");
				textArea.append("Team Alpha  :   Sorry for the inconvinience\n");
			}
		});
		Problem_9_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		Problem_9_btn.setBackground(Color.ORANGE);
		Problem_9_btn.setBounds(10, 536, 406, 37);
		Problem_9_btn.setVisible(false);
		panel.add(Problem_9_btn);
		
		JButton Problem_8_btn = new JButton("Raw or Uncooked item(s)");
		Problem_8_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("\t\t\t                     "+name+" :  Raw or Uncooked item(s)\n");
				textArea.append("Team Alpha  :   Sorry for the inconvinience\n");
			}
		});
		Problem_8_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		Problem_8_btn.setBackground(Color.ORANGE);
		Problem_8_btn.setBounds(10, 499, 406, 37);
		Problem_8_btn.setVisible(false);
		panel.add(Problem_8_btn);
		
		JButton Problem_10_btn = new JButton("Unwanted object(s) in the food");
		Problem_10_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("\t\t\t                     "+name+" :  Unwanted object(s) in the food\n");
				textArea.append("Team Alpha  :   Sorry for the inconvinience\n");
			}
		});
		Problem_10_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		Problem_10_btn.setBackground(Color.ORANGE);
		Problem_10_btn.setBounds(10, 571, 406, 37);
		Problem_10_btn.setVisible(false);
		panel.add(Problem_10_btn);
		
		JButton Problem_11_btn = new JButton("Expired or stale item(s)");
		Problem_11_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		Problem_11_btn.setBackground(Color.ORANGE);
		Problem_11_btn.setBounds(10, 608, 406, 37);
		Problem_11_btn.setVisible(false);
		panel.add(Problem_11_btn);
		
		JButton Problem_12_btn = new JButton("Non-Veg item(s) received instead of Veg");
		Problem_12_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		Problem_12_btn.setBackground(Color.ORANGE);
		Problem_12_btn.setBounds(10, 644, 406, 37);
		Problem_12_btn.setVisible(false);
		panel.add(Problem_12_btn);
		
		JButton Problem_1_btn = new JButton("I have not received my order");
		Problem_1_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					textArea.append("\t\t\t                     "+name+" :  I have not received my order\n");
					textArea.append("Team Alpha  :   Sorry for the inconvinience\n");
					
			}
		});
		Problem_1_btn.setBackground(Color.ORANGE);
		Problem_1_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		Problem_1_btn.setBounds(10, 233, 406, 37);
		panel.add(Problem_1_btn);
		
		JButton Problem_2_btn = new JButton("I have packaging/spillage issue with my order");
		Problem_2_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Problem_7_btn.setVisible(false);
				Problem_8_btn.setVisible(false);
				Problem_9_btn.setVisible(false);
				Problem_10_btn.setVisible(false);
				Problem_11_btn.setVisible(false);
				Problem_12_btn.setVisible(false);
				
				textArea.append("\t\t                    "+name+" :  I have packaging/spillage issue with my order\n");
				textArea.append("Team Alpha  :   Sorry for the inconvinience\n");
			}
		});
		Problem_2_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		Problem_2_btn.setBackground(Color.ORANGE);
		Problem_2_btn.setBounds(10, 270, 406, 37);
		panel.add(Problem_2_btn);
		
		JButton Problem_3_btn = new JButton("Items are missing or incorrect in my order");
		Problem_3_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Problem_7_btn.setVisible(false);
				Problem_8_btn.setVisible(false);
				Problem_9_btn.setVisible(false);
				Problem_10_btn.setVisible(false);
				Problem_11_btn.setVisible(false);
				Problem_12_btn.setVisible(false);
				textArea.append("\t\t                        "+name+" :  Items are missing or incorrect in my order\n");
				textArea.append("Team Alpha  :   Sorry for the inconvinience\n");
				
			}
		});
		Problem_3_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		Problem_3_btn.setBackground(Color.ORANGE);
		Problem_3_btn.setBounds(10, 307, 406, 37);
		panel.add(Problem_3_btn);
		
		JButton Problem_4_btn = new JButton("I have food taste or quality issue with my order");
		Problem_4_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Problem_7_btn.setVisible(true);
				Problem_8_btn.setVisible(true);
				Problem_9_btn.setVisible(true);
				Problem_10_btn.setVisible(true);
				Problem_11_btn.setVisible(true);
				Problem_12_btn.setVisible(true);
			}
		});
		Problem_4_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		Problem_4_btn.setBackground(Color.ORANGE);
		Problem_4_btn.setBounds(10, 342, 406, 37);
		panel.add(Problem_4_btn);
		
		JButton Problem_5_btn = new JButton("The quantity of food is not satisfactory");
		Problem_5_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Problem_7_btn.setVisible(false);
				Problem_8_btn.setVisible(false);
				Problem_9_btn.setVisible(false);
				Problem_10_btn.setVisible(false);
				Problem_11_btn.setVisible(false);
				Problem_12_btn.setVisible(false);
				textArea.append("\t\t                           "+name+" :  The quantity of food is not satisfactory\n");
				textArea.append("Team Alpha  :   Sorry for the inconvinience\n");
			}
		});
		Problem_5_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		Problem_5_btn.setBackground(Color.ORANGE);
		Problem_5_btn.setBounds(10, 379, 406, 37);
		panel.add(Problem_5_btn);
		
		JButton Problem_6_btn = new JButton("I have payment and billing related query");
		Problem_6_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Problem_7_btn.setVisible(false);
				Problem_8_btn.setVisible(false);
				Problem_9_btn.setVisible(false);
				Problem_10_btn.setVisible(false);
				Problem_11_btn.setVisible(false);
				Problem_12_btn.setVisible(false);
				textArea.append("\t\t                           "+name+" :  I have payment and billing related query\n");
				textArea.append("Team Alpha  :   Sorry for the inconvinience\n");
			}
		});
		Problem_6_btn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		Problem_6_btn.setBackground(Color.ORANGE);
		Problem_6_btn.setBounds(10, 415, 406, 37);
		panel.add(Problem_6_btn);
		
		
		
		JLabel img_icom = new JLabel("");
		img_icom.setBounds(-73, 10, 242, 132);
		
		Image img = new ImageIcon(this.getClass().getResource("/restaurant_logo.jfif")).getImage();
		img_icom.setIcon(new ImageIcon(img));
		panel.add(img_icom);
		
		JLabel lblNewLabel_2 = new JLabel("The Alpha");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 33));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(160, 37, 169, 44);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Restaurant");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 33));
		lblNewLabel_2_1.setBounds(160, 82, 169, 51);
		panel.add(lblNewLabel_2_1);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		textField.setBounds(427, 635, 791, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton(">");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 54));
		btnNewButton.setBounds(1216, 635, 97, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Support");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 45));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(740, 15, 190, 51);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btnNewButton_1.setBounds(1195, 26, 97, 28);
		contentPane.add(btnNewButton_1);
	}
}
