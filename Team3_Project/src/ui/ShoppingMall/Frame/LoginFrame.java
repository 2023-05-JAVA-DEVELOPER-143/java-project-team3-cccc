package ShoppingMall.Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField passWord;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		

		setTitle("안드로이드 로그인");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\2023-05-JAVA-DEVELOPER\\workspaceSE\\workspaceSE\\22.GUI[swing]\\src\\Image's\\2553038_android_logo_market_marketplace_device_icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 368);
		contentPane = new JPanel();
		contentPane.setToolTipText("안드로이드 로그인");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(5, 5));
		
		
		
		JPanel loginPanel = new JPanel();
		contentPane.add(loginPanel, "name_1662939054785700");
		loginPanel.setLayout(null);
		
		id = new JTextField();
		id.setBounds(148, 156, 128, 21);
		loginPanel.add(id);
		id.setColumns(10);
		
		passWord = new JTextField();
		passWord.setColumns(10);
		passWord.setBounds(148, 187, 128, 21);
		loginPanel.add(passWord);
		
		JLabel idKorean = new JLabel("아 이 디:");
		idKorean.setBounds(79, 159, 57, 15);
		loginPanel.add(idKorean);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호:");
		lblNewLabel_1.setBounds(79, 190, 70, 15);
		loginPanel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				id.getText(); // Id에 입력된 데이터 가져오기
				/* if() {
				--> id.getText랑 DB에 있는 로그인 데이터(Id) 비교
				}*/
				
				passWord.getText(); // password에 입력된 데이터 가져오기
				/* if() {
				--> password.getText랑 DB에 있는 로그인 데이터(password) 비교
				}*/
				

				
			}
		});
		btnNewButton.setBounds(79, 236, 91, 23);
		loginPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setBounds(185, 236, 91, 23);
		loginPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/ShoppingMall/image/5087579.png")));
		lblNewLabel_2.setBounds(121, 28, 122, 116);
		loginPanel.add(lblNewLabel_2);
		
	}
}
