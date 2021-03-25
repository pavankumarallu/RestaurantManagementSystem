package bill_package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Customer_Package.Customer_Display_page;
import Db_Models.BillModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bill_Section extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		ArrayList<BillModel> bmm = new ArrayList<BillModel>();
//		BillModel bm = new BillModel();
//		bm.setItemname("pappu");
//		bm.setQuantity(2);
//		bm.setRate(523.50);
//		bmm.add(bm);
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Bill_Section frame = new Bill_Section(bmm,"test2");
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Bill_Section(ArrayList<BillModel> bmlist,String custname) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 790);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnback(evt,custname);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnback(evt,custname);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPrint.setBackground(Color.BLACK);
		btnPrint.setBounds(337, 10, 85, 21);
		contentPane.add(btnPrint);
		
		JLabel lblNewLabel = new JLabel("The Alpha Hotel");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 22));
		lblNewLabel.setBounds(119, 61, 198, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("=====================================================");
		lblNewLabel_1.setBounds(20, 107, 412, 13);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 142, 432, 584);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		double total = 0;
		textArea.append("\n\n");
		for (int i = 0; i < bmlist.size(); i++) {
			textArea.append("                                "+bmlist.get(i).getItemname()+"        "+bmlist.get(i).getQuantity()+"       "+bmlist.get(i).getRate()+"\n");
			total = total + bmlist.get(i).getRate();
		}
		textArea.append("                =================================\n");
		textArea.append("                                Total             :  Rs. "+String.valueOf(total)+"\n");
		textArea.append("                                CGST             :  Rs. 5.50\n");
		textArea.append("                                SGST             :  Rs. 3.50\n");
		textArea.append("                =================================\n");
		textArea.append("                                Total             :  Rs. "+String.valueOf(total+5.50+3.50)+"\n");
		
		
		scrollPane.setViewportView(textArea);
		
	}

	private void btnback(java.awt.event.ActionEvent evt,String custname) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		// TODO Auto-generated method stub
		Customer_Display_page cdp = new Customer_Display_page(custname);
		cdp.setVisible(true);
		this.dispose();
	}
}
