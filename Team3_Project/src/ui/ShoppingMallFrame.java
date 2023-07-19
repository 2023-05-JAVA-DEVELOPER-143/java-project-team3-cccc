package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTable;

import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JScrollBar;

@SuppressWarnings("serial")
public class ShoppingMallFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField join_PhoneTextField;
	private JTextField join_AddressTextField;
	private JTextField join_NameTextFiled;
	private JTextField join_IdTextField;
	private JPasswordField join_PasswordField;
	private JTextField login_IdTextField;
	private JPasswordField login_PasswordField;
	private JTable table;
	private JPanel subPanel;
	private JTabbedPane shopTabbedPane;
	private JTextField info_PhoneTextField;
	private JTextField info_AddressTextField;
	private JTextField info_NameTextField;
	private JTextField info_IdTextField;
	private JPasswordField info_PasswordField;

	/**
	 * Launch the application.
	 */
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
	 * Create the frame.
	 */
	public ShoppingMallFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShoppingMallFrame.class.getResource("/ui/image/로고1.png")));
		setTitle("TEAM_SAMJO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 582);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("ShoppingMall ");
		menuBar.add(mnNewMenu);
		
		textField = new JTextField();
		textField.setText("     ");
		menuBar.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		menuBar.add(separator);
		
		JLabel serchLabel = new JLabel("");
		serchLabel.setToolTipText("    ");
	
		menuBar.add(serchLabel);
		
		JLabel cartLabel = new JLabel("");
		cartLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cartLabel.setToolTipText("");
	
		menuBar.add(cartLabel);
		
		JLabel lblNewLabel_5 = new JLabel("장바구니");
		lblNewLabel_5.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		menuBar.add(lblNewLabel_5);
		
		JLabel loginLabel = new JLabel("  로그인");
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setToolTipText(" ");
		menuBar.add(loginLabel);
		
		JLabel joinLabel = new JLabel("  회원가입");
		menuBar.add(joinLabel);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		shopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.setBounds(0, 0, 449, 517);
		contentPane.add(shopTabbedPane);
		
		JPanel shop_MainPanel = new JPanel();
		shop_MainPanel.setToolTipText("");
		shopTabbedPane.addTab(" 상 품 ", null, shop_MainPanel, null);
		shop_MainPanel.setLayout(null);
		
		subPanel = new JPanel();
		subPanel.setBounds(0, 0, 444, 488);
		shop_MainPanel.add(subPanel);
		subPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		subPanel.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel homePanel = new JPanel();
		tabbedPane.addTab("HOME", null, homePanel, null);
		homePanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("패  션");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(62, 177, 57, 15);
		homePanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("스포츠");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(191, 177, 57, 15);
		homePanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("생  활");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setBounds(320, 177, 57, 15);
		homePanel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_3 = new JLabel("가  구");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setBounds(62, 332, 57, 15);
		homePanel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("디지털");
		lblNewLabel_3_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_1.setBounds(191, 332, 57, 15);
		homePanel.add(lblNewLabel_3_3_1);
		
		JLabel lblNewLabel_3_3_1_1 = new JLabel("음  식");
		lblNewLabel_3_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_1_1.setBounds(320, 332, 57, 15);
		homePanel.add(lblNewLabel_3_3_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/옷.png")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(52, 87, 77, 80);
		homePanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/스포츠레저.png")));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(181, 87, 77, 80);
		homePanel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/생활.png")));
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setBounds(310, 87, 77, 80);
		homePanel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("");
		lblNewLabel_4_1_1_1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/가구.png")));
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1.setBounds(52, 242, 77, 80);
		homePanel.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("");
		lblNewLabel_4_1_1_1_1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/디지털.png")));
		lblNewLabel_4_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1_1.setBounds(181, 242, 77, 80);
		homePanel.add(lblNewLabel_4_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("");
		lblNewLabel_4_1_1_1_1_1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/식품.png")));
		lblNewLabel_4_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1_1_1.setBounds(310, 242, 77, 80);
		homePanel.add(lblNewLabel_4_1_1_1_1_1);
		
		JPanel fashionPanel = new JPanel();
		tabbedPane.addTab("패 션", null, fashionPanel, null);
		
		JPanel sportPanel = new JPanel();
		tabbedPane.addTab("스포츠", null, sportPanel, null);
		
		JPanel dailyPane = new JPanel();
		tabbedPane.addTab("생 활", null, dailyPane, null);
		
		JPanel furniturePanel = new JPanel();
		tabbedPane.addTab("가 구", null, furniturePanel, null);
		
		JPanel digitalPanel = new JPanel();
		tabbedPane.addTab("디지털", null, digitalPanel, null);
		
		JPanel foodPanel = new JPanel();
		tabbedPane.addTab("음 식", null, foodPanel, null);
		foodPanel.setLayout(null);
		
		JPanel foodPanel_1 = new JPanel();
		foodPanel_1.setLayout(null);
		
		JLabel fashion_IconLabel_1 = new JLabel("");
		fashion_IconLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		fashion_IconLabel_1.setBounds(50, 90, 75, 81);
		foodPanel_1.add(fashion_IconLabel_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("패 션");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(60, 168, 57, 23);
		foodPanel_1.add(lblNewLabel_3_2);
		
		JLabel sport_IconLabel_1 = new JLabel("");
		sport_IconLabel_1.setBounds(179, 90, 75, 81);
		foodPanel_1.add(sport_IconLabel_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("스포츠");
		lblNewLabel_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_3_1_2.setBounds(189, 168, 57, 23);
		foodPanel_1.add(lblNewLabel_3_1_2);
		
		JLabel dailyItem_IconLabel_1 = new JLabel("");
		dailyItem_IconLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		dailyItem_IconLabel_1.setBounds(308, 90, 75, 81);
		foodPanel_1.add(dailyItem_IconLabel_1);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("생 활");
		lblNewLabel_3_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_3_1_1_2.setBounds(318, 172, 57, 23);
		foodPanel_1.add(lblNewLabel_3_1_1_2);
		
		JLabel furniture_IconLabel_1 = new JLabel("");
		furniture_IconLabel_1.setToolTipText("");
		furniture_IconLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		furniture_IconLabel_1.setBounds(50, 220, 75, 81);
		foodPanel_1.add(furniture_IconLabel_1);
		
		JLabel lblNewLabel_3_1_1_1_2 = new JLabel("가 구");
		lblNewLabel_3_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_3_1_1_1_2.setBounds(60, 301, 57, 23);
		foodPanel_1.add(lblNewLabel_3_1_1_1_2);
		
		JLabel digital_IconLabel_1 = new JLabel("");
		digital_IconLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		digital_IconLabel_1.setBounds(179, 220, 75, 81);
		foodPanel_1.add(digital_IconLabel_1);
		
		JLabel lblNewLabel_3_1_1_1_1_2 = new JLabel("디지털");
		lblNewLabel_3_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1_1_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_3_1_1_1_1_2.setBounds(189, 305, 57, 23);
		foodPanel_1.add(lblNewLabel_3_1_1_1_1_2);
		
		JLabel food_IconLabel_1 = new JLabel("");
		food_IconLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		food_IconLabel_1.setBounds(308, 220, 75, 81);
		foodPanel_1.add(food_IconLabel_1);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("음 식");
		lblNewLabel_3_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_3_1_1_1_1_1_1.setBounds(318, 305, 57, 23);
		foodPanel_1.add(lblNewLabel_3_1_1_1_1_1_1);
		
		JPanel shop_LoginPanel = new JPanel();
		shopTabbedPane.addTab("로그인", null, shop_LoginPanel, null);
		shop_LoginPanel.setLayout(null);
		
		JLabel login_IdLabel = new JLabel("아이디");
		login_IdLabel.setBounds(109, 201, 57, 15);
		shop_LoginPanel.add(login_IdLabel);
		
		JLabel lgoin_PasswordLabel = new JLabel("패쓰워드");
		lgoin_PasswordLabel.setBounds(109, 263, 57, 15);
		shop_LoginPanel.add(lgoin_PasswordLabel);
		
		login_IdTextField = new JTextField();
		login_IdTextField.setColumns(10);
		login_IdTextField.setBounds(209, 198, 116, 21);
		shop_LoginPanel.add(login_IdTextField);
		
		login_PasswordField = new JPasswordField();
		login_PasswordField.setBounds(209, 260, 116, 21);
		shop_LoginPanel.add(login_PasswordField);
		
		JButton login_Btn = new JButton("로그인");
		login_Btn.setBounds(109, 322, 97, 23);
		shop_LoginPanel.add(login_Btn);
		
		JButton login_joinBtn = new JButton("회원가입");
		login_joinBtn.setBounds(228, 322, 97, 23);
		shop_LoginPanel.add(login_joinBtn);
		
		JLabel login_Label = new JLabel("L O G I N");
		login_Label.setFont(new Font("굴림", Font.BOLD, 30));
		login_Label.setHorizontalAlignment(SwingConstants.CENTER);
		login_Label.setBounds(190, 82, 155, 44);
		shop_LoginPanel.add(login_Label);
		
		JLabel login_Icon = new JLabel("");
		login_Icon.setHorizontalAlignment(SwingConstants.CENTER);
		login_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/로그인.png")));

		login_Icon.setBounds(81, 54, 111, 100);
		shop_LoginPanel.add(login_Icon);
		
		JPanel shop_JoinPanel = new JPanel();
		shopTabbedPane.addTab("회원가입", null, shop_JoinPanel, null);
		shop_JoinPanel.setLayout(null);
		
		JLabel join_IdLabel = new JLabel("아이디");
		join_IdLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_IdLabel.setBounds(81, 159, 57, 15);
		shop_JoinPanel.add(join_IdLabel);
		
		JLabel join_PasswordLabel = new JLabel("비밀번호");
		join_PasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_PasswordLabel.setBounds(81, 196, 57, 15);
		shop_JoinPanel.add(join_PasswordLabel);
		
		JLabel join_NameLabel = new JLabel("이름");
		join_NameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_NameLabel.setBounds(81, 231, 57, 15);
		shop_JoinPanel.add(join_NameLabel);
		
		JLabel join_AddressLabel = new JLabel("주소");
		join_AddressLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_AddressLabel.setBounds(81, 266, 57, 15);
		shop_JoinPanel.add(join_AddressLabel);
		
		JLabel join_PhoneLabel = new JLabel("연락처");
		join_PhoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_PhoneLabel.setBounds(81, 301, 57, 15);
		shop_JoinPanel.add(join_PhoneLabel);
		
		JLabel join_GenderLabel = new JLabel("성별");
		join_GenderLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_GenderLabel.setBounds(81, 336, 57, 15);
		shop_JoinPanel.add(join_GenderLabel);
		
		join_PhoneTextField = new JTextField();
		join_PhoneTextField.setBounds(150, 298, 204, 21);
		shop_JoinPanel.add(join_PhoneTextField);
		join_PhoneTextField.setColumns(10);
		
		join_AddressTextField = new JTextField();
		join_AddressTextField.setColumns(10);
		join_AddressTextField.setBounds(150, 263, 204, 21);
		shop_JoinPanel.add(join_AddressTextField);
		
		join_NameTextFiled = new JTextField();
		join_NameTextFiled.setColumns(10);
		join_NameTextFiled.setBounds(150, 228, 204, 21);
		shop_JoinPanel.add(join_NameTextFiled);
		
		join_IdTextField = new JTextField();
		join_IdTextField.setColumns(10);
		join_IdTextField.setBounds(150, 156, 107, 21);
		shop_JoinPanel.add(join_IdTextField);
		
		join_PasswordField = new JPasswordField();
		join_PasswordField.setBounds(150, 193, 204, 21);
		shop_JoinPanel.add(join_PasswordField);
		
		JButton join_Btn = new JButton("회원가입");
		join_Btn.setBackground(new Color(255, 255, 255));
		join_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		join_Btn.setBounds(103, 404, 115, 33);
		shop_JoinPanel.add(join_Btn);
		
		JButton join_jungbok_Btn = new JButton("중복체크");
		join_jungbok_Btn.setBounds(262, 155, 92, 23);
		shop_JoinPanel.add(join_jungbok_Btn);
		
		JButton join_Cancle_Btn = new JButton("취소");
		join_Cancle_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		join_Cancle_Btn.setBackground(new Color(255, 255, 255));
		join_Cancle_Btn.setBounds(232, 404, 115, 33);
		shop_JoinPanel.add(join_Cancle_Btn);
		
		JLabel join_Icon = new JLabel("");
		join_Icon.setHorizontalAlignment(SwingConstants.CENTER);
		join_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/가입.png")));
		join_Icon.setBounds(65, 31, 92, 103);
		shop_JoinPanel.add(join_Icon);
		
		JComboBox join_GenderComboBox = new JComboBox();
		join_GenderComboBox.setModel(new DefaultComboBoxModel(new String[] {"성별", "남성", "여성"}));
		join_GenderComboBox.setBounds(150, 332, 92, 23);
		shop_JoinPanel.add(join_GenderComboBox);
		
		JLabel join_Label = new JLabel("회 원 가 입");
		join_Label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 35));
		join_Label.setBounds(169, 56, 183, 60);
		shop_JoinPanel.add(join_Label);
		
		JPanel shop_InfoPanel = new JPanel();
		shopTabbedPane.addTab("내정보", null, shop_InfoPanel, null);
		shop_InfoPanel.setLayout(null);
		
		JLabel info_IdLabel = new JLabel("아이디");
		info_IdLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_IdLabel.setBounds(82, 144, 57, 15);
		shop_InfoPanel.add(info_IdLabel);
		
		JLabel info_PasswordLabel = new JLabel("비밀번호");
		info_PasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_PasswordLabel.setBounds(82, 181, 57, 15);
		shop_InfoPanel.add(info_PasswordLabel);
		
		JLabel info_NameLabel = new JLabel("이름");
		info_NameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_NameLabel.setBounds(82, 216, 57, 15);
		shop_InfoPanel.add(info_NameLabel);
		
		JLabel info_AddressLabel = new JLabel("주소");
		info_AddressLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_AddressLabel.setBounds(82, 251, 57, 15);
		shop_InfoPanel.add(info_AddressLabel);
		
		JLabel info_PhoneLabel = new JLabel("연락처");
		info_PhoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_PhoneLabel.setBounds(82, 286, 57, 15);
		shop_InfoPanel.add(info_PhoneLabel);
		
		JLabel info_GenderLabel = new JLabel("성별");
		info_GenderLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_GenderLabel.setBounds(82, 321, 57, 15);
		shop_InfoPanel.add(info_GenderLabel);
		
		info_PhoneTextField = new JTextField();
		info_PhoneTextField.setColumns(10);
		info_PhoneTextField.setBounds(151, 283, 204, 21);
		shop_InfoPanel.add(info_PhoneTextField);
		
		info_AddressTextField = new JTextField();
		info_AddressTextField.setColumns(10);
		info_AddressTextField.setBounds(151, 248, 204, 21);
		shop_InfoPanel.add(info_AddressTextField);
		
		info_NameTextField = new JTextField();
		info_NameTextField.setColumns(10);
		info_NameTextField.setBounds(151, 213, 204, 21);
		shop_InfoPanel.add(info_NameTextField);
		
		info_IdTextField = new JTextField();
		info_IdTextField.setColumns(10);
		info_IdTextField.setBounds(151, 141, 107, 21);
		shop_InfoPanel.add(info_IdTextField);
		
		info_PasswordField = new JPasswordField();
		info_PasswordField.setBounds(151, 178, 204, 21);
		shop_InfoPanel.add(info_PasswordField);
		
		JButton info_Btn = new JButton("회원탈퇴");
		info_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		info_Btn.setBackground(Color.WHITE);
		info_Btn.setBounds(80, 381, 95, 33);
		shop_InfoPanel.add(info_Btn);
		
		JButton info_jungbok_Btn = new JButton("중복체크");
		info_jungbok_Btn.setBounds(263, 140, 92, 23);
		shop_InfoPanel.add(info_jungbok_Btn);
		
		JButton info_Cancle_Btn = new JButton("취소");
		info_Cancle_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		info_Cancle_Btn.setBackground(Color.WHITE);
		info_Cancle_Btn.setBounds(284, 381, 71, 33);
		shop_InfoPanel.add(info_Cancle_Btn);
		
		JComboBox info_GenderComboBox = new JComboBox();
		info_GenderComboBox.setModel(new DefaultComboBoxModel(new String[] {"성별", "남성", "여성"}));
		info_GenderComboBox.setBounds(151, 317, 92, 23);
		shop_InfoPanel.add(info_GenderComboBox);
		
		JButton info_Cancle_Btn_1 = new JButton("수정");
		info_Cancle_Btn_1.setFont(new Font("굴림", Font.BOLD, 15));
		info_Cancle_Btn_1.setBackground(new Color(255, 255, 102));
		info_Cancle_Btn_1.setBounds(187, 381, 85, 33);
		shop_InfoPanel.add(info_Cancle_Btn_1);
		
		JLabel info_Icon = new JLabel("");
		info_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/내정보.png")));
		info_Icon.setBounds(106, 41, 77, 64);
		shop_InfoPanel.add(info_Icon);
		
		JLabel lblNewLabel = new JLabel("내 정 보");
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 35));
		lblNewLabel.setBounds(197, 54, 129, 39);
		shop_InfoPanel.add(lblNewLabel);
		
		JPanel shop_AdminPanel = new JPanel();
		shopTabbedPane.addTab("관리창", null, shop_AdminPanel, null);
		
		JPanel shop_CartPanel = new JPanel();
		shopTabbedPane.addTab("장바구니", null, shop_CartPanel, null);
		shop_CartPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		shop_CartPanel.add(panel, BorderLayout.SOUTH);
		
		JButton cart_homeBtn = new JButton("홈\r\n");
		cart_homeBtn.setBackground(new Color(248, 248, 255));
		cart_homeBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		cart_homeBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		cart_homeBtn.setBorderPainted(false);
		cart_homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cart_homeBtn.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/홈버튼.png")));
		panel.add(cart_homeBtn);
		
		JButton cart_InfoBtn = new JButton("내정보");
		cart_InfoBtn.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/내정보.png")));
		cart_InfoBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		cart_InfoBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		cart_InfoBtn.setBorderPainted(false);
		cart_InfoBtn.setBackground(new Color(248, 248, 255));
		panel.add(cart_InfoBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		shop_CartPanel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel cart_panel = new JPanel();
		scrollPane.setViewportView(cart_panel);
		cart_panel.setLayout(null);
		
		JLabel cart_CartLabel = new JLabel(" 장바구니");
		cart_CartLabel.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		cart_CartLabel.setBounds(12, 20, 102, 18);
		cart_CartLabel.setFont(new Font("굴림", Font.BOLD, 15));
		cart_panel.add(cart_CartLabel);
		
		Panel cart_Item1_1_1_1 = new Panel();
		cart_Item1_1_1_1.setLayout(null);
		cart_Item1_1_1_1.setBounds(12, 69, 198, 77);
		cart_panel.add(cart_Item1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/디지털.png")));
		lblNewLabel_1_1_1_1.setBounds(12, 0, 64, 72);
		cart_Item1_1_1_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("상품명: 디지털");
		lblNewLabel_2_1_1_1.setBounds(95, 9, 103, 15);
		cart_Item1_1_1_1.add(lblNewLabel_2_1_1_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setBounds(130, 34, 44, 23);
		cart_Item1_1_1_1.add(comboBox_1_1_1);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("수량:");
		lblNewLabel_6_1_1_1.setBounds(94, 38, 44, 15);
		cart_Item1_1_1_1.add(lblNewLabel_6_1_1_1);
		
		Panel cart_Item1_1_1_1_1 = new Panel();
		cart_Item1_1_1_1_1.setLayout(null);
		cart_Item1_1_1_1_1.setBounds(12, 172, 198, 77);
		cart_panel.add(cart_Item1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1_1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/디지털.png")));
		lblNewLabel_1_1_1_1_1.setBounds(12, 0, 64, 72);
		cart_Item1_1_1_1_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("상품명: 디지털");
		lblNewLabel_2_1_1_1_1.setBounds(95, 9, 103, 15);
		cart_Item1_1_1_1_1.add(lblNewLabel_2_1_1_1_1);
		
		JComboBox comboBox_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1.setBounds(130, 34, 44, 23);
		cart_Item1_1_1_1_1.add(comboBox_1_1_1_1);
		
		JLabel lblNewLabel_6_1_1_1_1 = new JLabel("수량:");
		lblNewLabel_6_1_1_1_1.setBounds(94, 38, 44, 15);
		cart_Item1_1_1_1_1.add(lblNewLabel_6_1_1_1_1);
		
		Panel cart_Item1_1 = new Panel();
		cart_Item1_1.setLayout(null);
		shop_CartPanel.add(cart_Item1_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(12, 0, 64, 72);
		cart_Item1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("상품명: 생활");
		lblNewLabel_2_1.setBounds(95, 9, 103, 15);
		cart_Item1_1.add(lblNewLabel_2_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(130, 34, 44, 23);
		cart_Item1_1.add(comboBox_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("수량:");
		lblNewLabel_6_1.setBounds(94, 38, 44, 15);
		cart_Item1_1.add(lblNewLabel_6_1);
		
	}
}
