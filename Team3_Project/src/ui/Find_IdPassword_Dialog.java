package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user.User;
import user.UserService;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class Find_IdPassword_Dialog extends JDialog {
	/**********1.UserService객체멤버필드로선언*******/
	private UserService userService;
	/************************************************/
	
	/*****FindDailog객체는 ShopMainFrame객체의참조변수를 멤버변수로가져야한다.*******/
	private ShoppingMallFrame shoppingMallFrame;
	public void setShopMainFrame(ShoppingMallFrame shoppingMallFrame) {
		this.shoppingMallFrame = shoppingMallFrame;
	}
	/***********************************************************************************/
	private final JPanel contentPanel = new JPanel();
	private JTextField userNameTextField;
	private JTextField usePhoneTextField;
	private JTextField find_PasswordNameLabel;
	private JTextField find_PasswordPhoneLabel;
	private JTextField find_PasswordIdLabel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingMallFrame frame = new ShoppingMallFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the dialog.
	 */
	public Find_IdPassword_Dialog() throws Exception{
		getContentPane().setBackground(Color.WHITE);
		setTitle("아이디·비밀번호 찾기");
		setBounds(100, 100, 350, 193);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
	
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton FindButton = new JButton("아이디 찾기");
				FindButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/******** 아이디 찾기 버튼클릭시*********/
						//아이디 찾기
						String name = userNameTextField.getText();
						String phone= usePhoneTextField.getText();
						try {							
					
							User user = userService.findId(name, phone);
							if(user == null) {
								JOptionPane.showMessageDialog(null, "이름 또는 전화번호를 확인하세요");
							}else {
								JOptionPane.showMessageDialog(null, "아이디: "+user.getUserId());
							}
							
						}catch (Exception ex) {
							ex.printStackTrace();
						}
						/******************************************************/
					}
				});
				FindButton.setActionCommand("OK");
				buttonPane.add(FindButton);
				getRootPane().setDefaultButton(FindButton);
			}
			{
				JButton loginCancelButton = new JButton("비밀번호 찾기");
				loginCancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/******** 비밀번호 찾기 버튼클릭시*********/
						//아이디 찾기
						String userid = find_PasswordIdLabel.getText();
						String name = find_PasswordNameLabel.getText();
						String phone= find_PasswordPhoneLabel.getText();
						try {							
					
							User user = userService.findId(name, phone);
							if(user == null) {
								JOptionPane.showMessageDialog(null, "아이디 이름 또는 전화번호를 확인하세요");
							}else {
								JOptionPane.showMessageDialog(null, "비밀번호: "+user.getPassword());
							}
							
						}catch (Exception ex) {
							ex.printStackTrace();
						}
						/******************************************************/
					}
				});
				loginCancelButton.setActionCommand("Cancel");
				buttonPane.add(loginCancelButton);
			}
		}
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel findIdpanel = new JPanel();
		tabbedPane.addTab("아이디찾기", null, findIdpanel, null);
		findIdpanel.setLayout(null);
		
		JLabel find_IdNameLabel = new JLabel("이     름");
		find_IdNameLabel.setBounds(67, 22, 56, 15);
		findIdpanel.add(find_IdNameLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(135, 19, 132, 21);
		userNameTextField.setColumns(10);
		findIdpanel.add(userNameTextField);
		
		JLabel find_IdPhoneLabel = new JLabel("전화번호");
		find_IdPhoneLabel.setBounds(67, 53, 72, 15);
		findIdpanel.add(find_IdPhoneLabel);
		
		usePhoneTextField = new JTextField();
		usePhoneTextField.setColumns(10);
		usePhoneTextField.setBounds(135, 50, 132, 21);
		findIdpanel.add(usePhoneTextField);
		
		JPanel findPasswordPanel = new JPanel();
		tabbedPane.addTab("비밀번호찾기", null, findPasswordPanel, null);
		findPasswordPanel.setLayout(null);
		
		JLabel login_IdLabel_2 = new JLabel("이     름");
		login_IdLabel_2.setBounds(68, 37, 56, 15);
		findPasswordPanel.add(login_IdLabel_2);
		
		find_PasswordNameLabel = new JTextField();
		find_PasswordNameLabel.setColumns(10);
		find_PasswordNameLabel.setBounds(136, 35, 132, 21);
		findPasswordPanel.add(find_PasswordNameLabel);
		
		find_PasswordPhoneLabel = new JTextField();
		find_PasswordPhoneLabel.setColumns(10);
		find_PasswordPhoneLabel.setBounds(136, 63, 132, 21);
		findPasswordPanel.add(find_PasswordPhoneLabel);
		
		JLabel login_IdLabel_1_1 = new JLabel("전화번호");
		login_IdLabel_1_1.setBounds(68, 63, 72, 15);
		findPasswordPanel.add(login_IdLabel_1_1);
		
		JLabel login_IdLabel_2_1 = new JLabel("아 이 디");
		login_IdLabel_2_1.setBounds(68, 11, 56, 15);
		findPasswordPanel.add(login_IdLabel_2_1);
		
		find_PasswordIdLabel = new JTextField();
		find_PasswordIdLabel.setColumns(10);
		find_PasswordIdLabel.setBounds(136, 7, 132, 21);
		findPasswordPanel.add(find_PasswordIdLabel);
		/**********2.UserService객체생성초기화*******/
		userService=new UserService();
		/********************************************/
	}//end constructor
}//end class
