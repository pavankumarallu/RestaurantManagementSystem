package Suggest_package;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Suggestions extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suggestions frame = new Suggestions();
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
	public Suggestions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 735);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel img_dis = new JLabel("");
		img_dis.setBounds(342, 10, 299, 164);
		Image img = new ImageIcon(this.getClass().getResource("/restaurant_logo.jfif")).getImage();
		img_dis.setIcon(new ImageIcon(img));
		contentPane.add(img_dis);
		
		JLabel lblNewLabel = new JLabel("The Alpha");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(373, 163, 268, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblRestaurant = new JLabel("Restaurant");
		lblRestaurant.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurant.setForeground(Color.WHITE);
		lblRestaurant.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));
		lblRestaurant.setBounds(373, 206, 268, 54);
		contentPane.add(lblRestaurant);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 24));
		textArea.setBackground(Color.ORANGE);
		textArea.setBounds(256, 310, 677, 158);
		contentPane.add(textArea);
		
		JLabel lblLeaveYourSuggestions = new JLabel("Leave your ");
		lblLeaveYourSuggestions.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaveYourSuggestions.setForeground(Color.WHITE);
		lblLeaveYourSuggestions.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		lblLeaveYourSuggestions.setBounds(55, 334, 175, 54);
		contentPane.add(lblLeaveYourSuggestions);
		
		JLabel lblRateUs = new JLabel("Rate us");
		lblRateUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblRateUs.setForeground(Color.WHITE);
		lblRateUs.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		lblRateUs.setBounds(359, 520, 143, 54);
		contentPane.add(lblRateUs);
		
		JLabel lblRateUs_1 = new JLabel("/ 5");
		lblRateUs_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRateUs_1.setForeground(Color.WHITE);
		lblRateUs_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 36));
		lblRateUs_1.setBounds(554, 520, 63, 72);
		contentPane.add(lblRateUs_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		textField.setBounds(519, 534, 35, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ask me later");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 27));
		btnNewButton.setBounds(151, 612, 241, 54);
		contentPane.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tempus Sans ITC", Font.BOLD, 27));
		btnSubmit.setBackground(Color.ORANGE);
		btnSubmit.setBounds(571, 612, 241, 54);
		contentPane.add(btnSubmit);
		
		JLabel lblSuggestions = new JLabel("Suggestions");
		lblSuggestions.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuggestions.setForeground(Color.WHITE);
		lblSuggestions.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		lblSuggestions.setBounds(55, 366, 175, 54);
		contentPane.add(lblSuggestions);
	}
}
