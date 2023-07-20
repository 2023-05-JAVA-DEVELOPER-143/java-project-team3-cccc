package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
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
import java.awt.ScrollPane;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Window.Type;
import java.awt.Scrollbar;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;

import cart.CartService;
import order.OrderService;
import product.ProductService;
import user.User;
import user.UserService;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ShoppingMallFrame extends JFrame {


	
	/************1. 서비스 객체변수 선언**************/
	private UserService userService;
	private ProductService productService;
	private OrderService orderService;
	private CartService cartService;
	
	/************loginUser**************/
	private User loginUser = null;
	/**********************************/
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
	private JPanel order_ContentPane;
	private JScrollPane cart_ScrollPane;
	private JPanel cart_ContentPanel;

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
	@SuppressWarnings("unchecked")
	public ShoppingMallFrame() throws Exception{
		setResizable(false);
		setAutoRequestFocus(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShoppingMallFrame.class.getResource("/ui/image/로고1.png")));
		setTitle("TEAM_SAMJO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 582);
		
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
		shopTabbedPane.setBounds(0, 0, 509, 517);
		contentPane.add(shopTabbedPane);
		
		JPanel shop_MainPanel = new JPanel();
		shop_MainPanel.setToolTipText("");
		shopTabbedPane.addTab(" 상 품 ", null, shop_MainPanel, null);
		shop_MainPanel.setLayout(null);
		
		subPanel = new JPanel();
		subPanel.setBounds(0, 0, 509, 517);
		shop_MainPanel.add(subPanel);
		subPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		subPanel.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel homePanel = new JPanel();
		homePanel.setBackground(Color.WHITE);
		tabbedPane.addTab("HOME", null, homePanel, null);
		homePanel.setLayout(null);
		
		JLabel fasionLabel = new JLabel("패  션");
		fasionLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);	
			}
		});
		fasionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fasionLabel.setBounds(90, 177, 57, 15);
		homePanel.add(fasionLabel);
		
		JLabel sportLabel = new JLabel("스포츠");
		sportLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);	
			}
		});
		sportLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sportLabel.setBounds(219, 177, 57, 15);
		homePanel.add(sportLabel);
		
		JLabel dailyLabel = new JLabel("생  활");
		dailyLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);	
			}
		});
		dailyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dailyLabel.setBounds(348, 177, 57, 15);
		homePanel.add(dailyLabel);
		
		JLabel furnitureLabel = new JLabel("가  구");
		furnitureLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(4);	
			}
		});
		furnitureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		furnitureLabel.setBounds(90, 332, 57, 15);
		homePanel.add(furnitureLabel);
		
		JLabel digitalLabel = new JLabel("디지털");
		digitalLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(5);	
			}
		});
		digitalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		digitalLabel.setBounds(219, 332, 57, 15);
		homePanel.add(digitalLabel);
		
		JLabel foodLabel = new JLabel("음  식");
		foodLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(6);	
			}
		});
		foodLabel.setHorizontalAlignment(SwingConstants.CENTER);
		foodLabel.setBounds(348, 332, 57, 15);
		homePanel.add(foodLabel);
		
		JLabel fasionImage = new JLabel("");
		fasionImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		fasionImage.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/옷.png")));
		fasionImage.setHorizontalAlignment(SwingConstants.CENTER);
		fasionImage.setBounds(80, 87, 77, 80);
		homePanel.add(fasionImage);
		
		JLabel sportImage = new JLabel("");
		sportImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);	
			}
		});
		sportImage.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/스포츠레저.png")));
		sportImage.setHorizontalAlignment(SwingConstants.CENTER);
		sportImage.setBounds(209, 87, 77, 80);
		homePanel.add(sportImage);
		
		JLabel dailyImage = new JLabel("");
		dailyImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);	
			}
		});
		dailyImage.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/생활.png")));
		dailyImage.setHorizontalAlignment(SwingConstants.CENTER);
		dailyImage.setBounds(338, 87, 77, 80);
		homePanel.add(dailyImage);
		
		JLabel furnitureImage = new JLabel("");
		furnitureImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(4);	
			}
		});
		furnitureImage.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/가구.png")));
		furnitureImage.setHorizontalAlignment(SwingConstants.CENTER);
		furnitureImage.setBounds(80, 242, 77, 80);
		homePanel.add(furnitureImage);
		
		JLabel digitalImage = new JLabel("");
		digitalImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(5);	
			}
		});
		digitalImage.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/디지털.png")));
		digitalImage.setHorizontalAlignment(SwingConstants.CENTER);
		digitalImage.setBounds(209, 242, 77, 80);
		homePanel.add(digitalImage);
		
		JLabel foodImage = new JLabel("");
		foodImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(6);	
			}
		});
		foodImage.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/식품.png")));
		foodImage.setHorizontalAlignment(SwingConstants.CENTER);
		foodImage.setBounds(338, 242, 77, 80);
		homePanel.add(foodImage);
		
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
		shop_LoginPanel.setBackground(Color.WHITE);
		shopTabbedPane.addTab("로그인", null, shop_LoginPanel, null);
		shop_LoginPanel.setLayout(null);
		
		JLabel login_IdLabel = new JLabel("아이디");
		login_IdLabel.setBounds(143, 221, 57, 15);
		shop_LoginPanel.add(login_IdLabel);
		
		JLabel lgoin_PasswordLabel = new JLabel("패쓰워드");
		lgoin_PasswordLabel.setBounds(143, 283, 57, 15);
		shop_LoginPanel.add(lgoin_PasswordLabel);
		
		login_IdTextField = new JTextField();
		login_IdTextField.setColumns(10);
		login_IdTextField.setBounds(243, 218, 116, 21);
		shop_LoginPanel.add(login_IdTextField);
		
		login_PasswordField = new JPasswordField();
		login_PasswordField.setBounds(243, 280, 116, 21);
		shop_LoginPanel.add(login_PasswordField);
		
		JButton login_Btn = new JButton("로그인");
		login_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String id = login_IdTextField.getText();
				String password = new String(login_PasswordField.getText());
					User userloginUser = userservice.login(id, password);
					if(userloginUser!=null) {
						loginProcess(userloginUser);	
						
					}else {
						//로그인 실패
						JOptionPane.showMessageDialog(null, "아이디또는 비밀번호를 확인하세요");
						login_IdTextField.setSelectionStart(0);
						login_IdTextField.setSelectionEnd(id.length());
						login_IdTextField.requestFocus();
					}
						
				} catch (Exception e1) {
					e1.getStackTrace();
				}
				
			}
		});
		login_Btn.setBounds(143, 342, 97, 23);
		shop_LoginPanel.add(login_Btn);
		
		JButton login_joinBtn = new JButton("회원가입");
		login_joinBtn.setBounds(262, 342, 97, 23);
		shop_LoginPanel.add(login_joinBtn);
		
		JLabel login_Label = new JLabel("L O G I N");
		login_Label.setFont(new Font("굴림", Font.BOLD, 30));
		login_Label.setHorizontalAlignment(SwingConstants.CENTER);
		login_Label.setBounds(224, 102, 155, 44);
		shop_LoginPanel.add(login_Label);
		
		JLabel login_Icon = new JLabel("");
		login_Icon.setHorizontalAlignment(SwingConstants.CENTER);
		login_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/로그인.png")));
		
				login_Icon.setBounds(115, 74, 111, 100);
				shop_LoginPanel.add(login_Icon);
		
		JPanel shop_JoinPanel = new JPanel();
		shop_JoinPanel.setBackground(Color.WHITE);
		shopTabbedPane.addTab("회원가입", null, shop_JoinPanel, null);
		shop_JoinPanel.setLayout(null);
		
		JLabel join_IdLabel = new JLabel("아이디");
		join_IdLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_IdLabel.setBounds(120, 160, 57, 15);
		shop_JoinPanel.add(join_IdLabel);
		
		JLabel join_PasswordLabel = new JLabel("비밀번호");
		join_PasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_PasswordLabel.setBounds(120, 197, 57, 15);
		shop_JoinPanel.add(join_PasswordLabel);
		
		JLabel join_NameLabel = new JLabel("이름");
		join_NameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_NameLabel.setBounds(120, 232, 57, 15);
		shop_JoinPanel.add(join_NameLabel);
		
		JLabel join_AddressLabel = new JLabel("주소");
		join_AddressLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_AddressLabel.setBounds(120, 267, 57, 15);
		shop_JoinPanel.add(join_AddressLabel);
		
		JLabel join_PhoneLabel = new JLabel("연락처");
		join_PhoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_PhoneLabel.setBounds(120, 302, 57, 15);
		shop_JoinPanel.add(join_PhoneLabel);
		
		JLabel join_GenderLabel = new JLabel("성별");
		join_GenderLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_GenderLabel.setBounds(120, 337, 57, 15);
		shop_JoinPanel.add(join_GenderLabel);
		
		join_PhoneTextField = new JTextField();
		join_PhoneTextField.setBounds(189, 299, 204, 21);
		shop_JoinPanel.add(join_PhoneTextField);
		join_PhoneTextField.setColumns(10);
		
		join_AddressTextField = new JTextField();
		join_AddressTextField.setColumns(10);
		join_AddressTextField.setBounds(189, 264, 204, 21);
		shop_JoinPanel.add(join_AddressTextField);
		
		join_NameTextFiled = new JTextField();
		join_NameTextFiled.setColumns(10);
		join_NameTextFiled.setBounds(189, 229, 204, 21);
		shop_JoinPanel.add(join_NameTextFiled);
		
		join_IdTextField = new JTextField();
		join_IdTextField.setColumns(10);
		join_IdTextField.setBounds(189, 157, 197, 21);
		shop_JoinPanel.add(join_IdTextField);
		
		join_PasswordField = new JPasswordField();
		join_PasswordField.setBounds(189, 194, 204, 21);
		shop_JoinPanel.add(join_PasswordField);
		
		JButton join_Btn = new JButton("회원가입");
		join_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		join_Btn.setBackground(new Color(255, 255, 255));
		join_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		join_Btn.setBounds(142, 405, 115, 33);
		shop_JoinPanel.add(join_Btn);
		
		JButton join_Cancle_Btn = new JButton("취소");
		join_Cancle_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		join_Cancle_Btn.setBackground(new Color(255, 255, 255));
		join_Cancle_Btn.setBounds(271, 405, 115, 33);
		shop_JoinPanel.add(join_Cancle_Btn);
		
		JLabel join_Icon = new JLabel("");
		join_Icon.setHorizontalAlignment(SwingConstants.CENTER);
		join_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/가입.png")));
		join_Icon.setBounds(104, 32, 92, 103);
		shop_JoinPanel.add(join_Icon);
		
		JComboBox join_GenderComboBox = new JComboBox();
		join_GenderComboBox.setModel(new DefaultComboBoxModel(new String[] {"성별", "남성", "여성"}));
		join_GenderComboBox.setBounds(189, 333, 92, 23);
		shop_JoinPanel.add(join_GenderComboBox);
		
		JLabel join_Label = new JLabel("회 원 가 입");
		join_Label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 35));
		join_Label.setBounds(208, 57, 183, 60);
		shop_JoinPanel.add(join_Label);
		
		JPanel shop_InfoPanel = new JPanel();
		shop_InfoPanel.setBackground(Color.WHITE);
		shopTabbedPane.addTab("내정보", null, shop_InfoPanel, null);
		shop_InfoPanel.setLayout(null);
		
		JLabel info_IdLabel = new JLabel("아이디");
		info_IdLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_IdLabel.setBounds(109, 144, 57, 15);
		shop_InfoPanel.add(info_IdLabel);
		
		JLabel info_PasswordLabel = new JLabel("비밀번호");
		info_PasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_PasswordLabel.setBounds(109, 181, 57, 15);
		shop_InfoPanel.add(info_PasswordLabel);
		
		JLabel info_NameLabel = new JLabel("이름");
		info_NameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_NameLabel.setBounds(109, 216, 57, 15);
		shop_InfoPanel.add(info_NameLabel);
		
		JLabel info_AddressLabel = new JLabel("주소");
		info_AddressLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_AddressLabel.setBounds(109, 251, 57, 15);
		shop_InfoPanel.add(info_AddressLabel);
		
		JLabel info_PhoneLabel = new JLabel("연락처");
		info_PhoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_PhoneLabel.setBounds(109, 286, 57, 15);
		shop_InfoPanel.add(info_PhoneLabel);
		
		JLabel info_GenderLabel = new JLabel("성별");
		info_GenderLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_GenderLabel.setBounds(109, 321, 57, 15);
		shop_InfoPanel.add(info_GenderLabel);
		
		info_PhoneTextField = new JTextField();
		info_PhoneTextField.setColumns(10);
		info_PhoneTextField.setBounds(178, 283, 204, 21);
		shop_InfoPanel.add(info_PhoneTextField);
		
		info_AddressTextField = new JTextField();
		info_AddressTextField.setColumns(10);
		info_AddressTextField.setBounds(178, 248, 204, 21);
		shop_InfoPanel.add(info_AddressTextField);
		
		info_NameTextField = new JTextField();
		info_NameTextField.setColumns(10);
		info_NameTextField.setBounds(178, 213, 204, 21);
		shop_InfoPanel.add(info_NameTextField);
		
		info_IdTextField = new JTextField();
		info_IdTextField.setEditable(false);
		info_IdTextField.setEnabled(false);
		info_IdTextField.setColumns(10);
		info_IdTextField.setBounds(178, 141, 204, 21);
		shop_InfoPanel.add(info_IdTextField);
		
		info_PasswordField = new JPasswordField();
		info_PasswordField.setBounds(178, 178, 204, 21);
		shop_InfoPanel.add(info_PasswordField);
		
		JButton info_Btn = new JButton("회원탈퇴");
		info_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		info_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		info_Btn.setBackground(Color.WHITE);
		info_Btn.setBounds(107, 381, 95, 33);
		shop_InfoPanel.add(info_Btn);
		
		JButton info_Cancle_Btn = new JButton("취소");
		info_Cancle_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		info_Cancle_Btn.setBackground(Color.WHITE);
		info_Cancle_Btn.setBounds(311, 381, 71, 33);
		shop_InfoPanel.add(info_Cancle_Btn);
		
		JComboBox info_GenderComboBox = new JComboBox();
		info_GenderComboBox.setModel(new DefaultComboBoxModel(new String[] {"성별", "남성", "여성"}));
		info_GenderComboBox.setBounds(178, 317, 92, 23);
		shop_InfoPanel.add(info_GenderComboBox);
		
		JButton info_Cancle_Btn_1 = new JButton("수정");
		info_Cancle_Btn_1.setFont(new Font("굴림", Font.BOLD, 15));
		info_Cancle_Btn_1.setBackground(new Color(255, 255, 102));
		info_Cancle_Btn_1.setBounds(214, 381, 85, 33);
		shop_InfoPanel.add(info_Cancle_Btn_1);
		
		JLabel info_Icon = new JLabel("");
		info_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/내정보.png")));
		info_Icon.setBounds(133, 41, 77, 64);
		shop_InfoPanel.add(info_Icon);
		
		JLabel lblNewLabel = new JLabel("내 정 보");
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 35));
		lblNewLabel.setBounds(224, 54, 129, 39);
		shop_InfoPanel.add(lblNewLabel);
		
		JPanel shop_AdminPanel = new JPanel();
		shopTabbedPane.addTab("관리창", null, shop_AdminPanel, null);
		
		JPanel shop_CartPanel = new JPanel();
		shopTabbedPane.addTab("장바구니", null, shop_CartPanel, null);
		shop_CartPanel.setLayout(new BorderLayout(0, 0));
		
		
		
		cart_ScrollPane = new JScrollPane();
		cart_ScrollPane.setBackground(Color.WHITE);
		cart_ScrollPane.setPreferredSize(new Dimension(390, 780));
		cart_ScrollPane.setHorizontalScrollBarPolicy(cart_ScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		shop_CartPanel.add(cart_ScrollPane, BorderLayout.CENTER);
		
		
		cart_ContentPanel = new JPanel();
		cart_ContentPanel.setPreferredSize(new Dimension(390, 300));	
		cart_ContentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		cart_ScrollPane.setViewportView(cart_ContentPanel);
		cart_ContentPanel.setLayout(new BorderLayout(0, 0));
		
		Panel order_ListTiltlePanel_1 = new Panel();
		order_ListTiltlePanel_1.setLayout(null);
		
		JLabel order_ItemNameLable_4_1 = new JLabel("상품명");
		order_ItemNameLable_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNameLable_4_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		order_ItemNameLable_4_1.setBounds(140, 11, 44, 16);
		order_ListTiltlePanel_1.add(order_ItemNameLable_4_1);
		
		JLabel order_ItemNo_4_1 = new JLabel("수량");
		order_ItemNo_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNo_4_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		order_ItemNo_4_1.setBounds(219, 11, 44, 16);
		order_ListTiltlePanel_1.add(order_ItemNo_4_1);
		
		JLabel order_itemPrice_4_1 = new JLabel("가격");
		order_itemPrice_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		order_itemPrice_4_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		order_itemPrice_4_1.setBounds(316, 12, 33, 15);
		order_ListTiltlePanel_1.add(order_itemPrice_4_1);
		
		JLabel order_ItemTotPrice_4_1 = new JLabel("상품금액");
		order_ItemTotPrice_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemTotPrice_4_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		order_ItemTotPrice_4_1.setBounds(392, 11, 69, 16);
		order_ListTiltlePanel_1.add(order_ItemTotPrice_4_1);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("   전체선택");
		chckbxNewCheckBox_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		chckbxNewCheckBox_1.setBounds(20, 8, 112, 23);
		order_ListTiltlePanel_1.add(chckbxNewCheckBox_1);
		
		JPanel cart_ItemPanel = new JPanel();
		cart_ItemPanel.setBackground(Color.WHITE);
		cart_ItemPanel.setLayout(null);
		cart_ItemPanel.setPreferredSize(new Dimension(390, 780));
		cart_ItemPanel.setBorder(null);
		cart_ContentPanel.add(cart_ItemPanel);	
		
		
		
		JPanel cart_ItemPanel1 = new JPanel();
		cart_ItemPanel1.setLayout(null);
		cart_ItemPanel1.setBounds(0, 60, 485, 80);
		cart_ItemPanel1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		cart_ItemPanel.add(cart_ItemPanel1);
	

		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1_1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/Food1.png")));
		lblNewLabel_1_1_1_1_1.setBounds(49, 10, 64, 70);
		cart_ItemPanel1.add(lblNewLabel_1_1_1_1_1);
		
		JComboBox comboBox_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1.setBounds(219, 25, 44, 23);
		cart_ItemPanel1.add(comboBox_1_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("음 식");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(134, 29, 57, 15);
		cart_ItemPanel1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("300,000");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setBounds(297, 29, 57, 15);
		cart_ItemPanel1.add(lblNewLabel_1_1_2);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setBounds(20, 25, 21, 23);
		cart_ItemPanel1.add(chckbxNewCheckBox_2);
		
		JLabel cart_PpHangleLabel1 = new JLabel("원");
		cart_PpHangleLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		cart_PpHangleLabel1.setFont(new Font("굴림", Font.PLAIN, 13));
		cart_PpHangleLabel1.setBounds(351, 29, 21, 15);
		cart_ItemPanel1.add(cart_PpHangleLabel1);
		
		JLabel cart_PpHangleLabel1_1 = new JLabel("원");
		cart_PpHangleLabel1_1.setHorizontalAlignment(SwingConstants.CENTER);
		cart_PpHangleLabel1_1.setFont(new Font("굴림", Font.PLAIN, 13));
		cart_PpHangleLabel1_1.setBounds(452, 29, 21, 15);
		cart_ItemPanel1.add(cart_PpHangleLabel1_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("300,000");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setBounds(398, 29, 57, 15);
		cart_ItemPanel1.add(lblNewLabel_1_1_2_1);
		
		JPanel cart_ItemPanel2 = new JPanel();
		cart_ItemPanel2.setLayout(null);
		cart_ItemPanel2.setPreferredSize(new Dimension(390, 780));
		cart_ItemPanel2.setBorder(null);
		cart_ContentPanel.add(cart_ItemPanel);
		
		Panel cart_ListTiltlePanel = new Panel();
		cart_ListTiltlePanel.setLocation(0, 10);
		cart_ListTiltlePanel.setSize(485, 40);
		cart_ListTiltlePanel.setLayout(null);
		cart_ItemPanel.add(cart_ListTiltlePanel);
		
		JLabel order_ItemNameLable_4_2 = new JLabel("상품명");
		order_ItemNameLable_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNameLable_4_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		order_ItemNameLable_4_2.setBounds(138, 12, 44, 16);
		cart_ListTiltlePanel.add(order_ItemNameLable_4_2);
		
		JLabel order_ItemNo_4_2 = new JLabel("수량");
		order_ItemNo_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNo_4_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		order_ItemNo_4_2.setBounds(218, 12, 44, 16);
		cart_ListTiltlePanel.add(order_ItemNo_4_2);
		
		JLabel order_itemPrice_4_2 = new JLabel("가격");
		order_itemPrice_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		order_itemPrice_4_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		order_itemPrice_4_2.setBounds(316, 12, 33, 15);
		cart_ListTiltlePanel.add(order_itemPrice_4_2);
		
		JLabel order_ItemTotPrice_4_2 = new JLabel("주문금액");
		order_ItemTotPrice_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemTotPrice_4_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		order_ItemTotPrice_4_2.setBounds(393, 12, 69, 16);
		cart_ListTiltlePanel.add(order_ItemTotPrice_4_2);
		
		JCheckBox chckbxNewCheckBox_2_2 = new JCheckBox("");
		chckbxNewCheckBox_2_2.setBackground(Color.WHITE);
		chckbxNewCheckBox_2_2.setBounds(20, 8, 21, 23);
		cart_ListTiltlePanel.add(chckbxNewCheckBox_2_2);
		
		JLabel lblNewLabel_2 = new JLabel("전체선택");
		lblNewLabel_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(49, 12, 57, 15);
		cart_ListTiltlePanel.add(lblNewLabel_2);
		
		Panel cart_ListSumPanel = new Panel();
		cart_ListSumPanel.setLayout(null);
		cart_ListSumPanel.setBounds(0, 366, 485, 37);
		cart_ItemPanel.add(cart_ListSumPanel);
		
		JLabel order_itemPrice_4_2_1 = new JLabel("합  계 :");
		order_itemPrice_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		order_itemPrice_4_2_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		order_itemPrice_4_2_1.setBounds(313, 11, 57, 15);
		cart_ListSumPanel.add(order_itemPrice_4_2_1);
		
		JLabel order_ItemTotPrice_4_2_1 = new JLabel("\\ 600,000");
		order_ItemTotPrice_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemTotPrice_4_2_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		order_ItemTotPrice_4_2_1.setBounds(382, 10, 91, 16);
		cart_ListSumPanel.add(order_ItemTotPrice_4_2_1);
		
		JButton btnNewButton = new JButton("수  정");
		btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		btnNewButton.setBounds(62, 8, 97, 23);
		cart_ListSumPanel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("삭  제");
		btnNewButton_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		btnNewButton_2.setBounds(188, 8, 97, 23);
		cart_ListSumPanel.add(btnNewButton_2);
		
		JPanel cart_ItemPanel1_1 = new JPanel();
		cart_ItemPanel1_1.setLayout(null);
		cart_ItemPanel1_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		cart_ItemPanel1_1.setBounds(0, 150, 485, 80);
		cart_ItemPanel.add(cart_ItemPanel1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1_1_1.setBounds(49, 0, 64, 72);
		cart_ItemPanel1_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JComboBox comboBox_1_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1_1.setBounds(219, 25, 44, 23);
		cart_ItemPanel1_1.add(comboBox_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("음 식");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setBounds(134, 29, 57, 15);
		cart_ItemPanel1_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("300,000");
		lblNewLabel_1_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_2.setBounds(297, 29, 57, 15);
		cart_ItemPanel1_1.add(lblNewLabel_1_1_2_2);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("");
		chckbxNewCheckBox_2_1.setBounds(20, 25, 21, 23);
		cart_ItemPanel1_1.add(chckbxNewCheckBox_2_1);
		
		JLabel cart_PpHangleLabel1_2 = new JLabel("원");
		cart_PpHangleLabel1_2.setHorizontalAlignment(SwingConstants.CENTER);
		cart_PpHangleLabel1_2.setFont(new Font("굴림", Font.PLAIN, 13));
		cart_PpHangleLabel1_2.setBounds(351, 29, 21, 15);
		cart_ItemPanel1_1.add(cart_PpHangleLabel1_2);
		
		JLabel cart_PpHangleLabel1_1_1 = new JLabel("원");
		cart_PpHangleLabel1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		cart_PpHangleLabel1_1_1.setFont(new Font("굴림", Font.PLAIN, 13));
		cart_PpHangleLabel1_1_1.setBounds(452, 29, 21, 15);
		cart_ItemPanel1_1.add(cart_PpHangleLabel1_1_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("300,000");
		lblNewLabel_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_1.setBounds(398, 29, 57, 15);
		cart_ItemPanel1_1.add(lblNewLabel_1_1_2_1_1);
		
		JPanel cart_ItemPanel1_1_1 = new JPanel();
		cart_ItemPanel1_1_1.setLayout(null);
		cart_ItemPanel1_1_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		cart_ItemPanel1_1_1.setBounds(0, 240, 485, 80);
		cart_ItemPanel.add(cart_ItemPanel1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1_1_1_1.setBounds(49, 0, 64, 72);
		cart_ItemPanel1_1_1.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JComboBox comboBox_1_1_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1_1_1.setBounds(219, 25, 44, 23);
		cart_ItemPanel1_1_1.add(comboBox_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("음 식");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setBounds(134, 29, 57, 15);
		cart_ItemPanel1_1_1.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("300,000");
		lblNewLabel_1_1_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_2_1.setBounds(297, 29, 57, 15);
		cart_ItemPanel1_1_1.add(lblNewLabel_1_1_2_2_1);
		
		JCheckBox chckbxNewCheckBox_2_1_1 = new JCheckBox("");
		chckbxNewCheckBox_2_1_1.setBounds(20, 25, 21, 23);
		cart_ItemPanel1_1_1.add(chckbxNewCheckBox_2_1_1);
		
		JLabel cart_PpHangleLabel1_2_1 = new JLabel("원");
		cart_PpHangleLabel1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		cart_PpHangleLabel1_2_1.setFont(new Font("굴림", Font.PLAIN, 13));
		cart_PpHangleLabel1_2_1.setBounds(351, 29, 21, 15);
		cart_ItemPanel1_1_1.add(cart_PpHangleLabel1_2_1);
		
		JLabel cart_PpHangleLabel1_1_1_1 = new JLabel("원");
		cart_PpHangleLabel1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		cart_PpHangleLabel1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 13));
		cart_PpHangleLabel1_1_1_1.setBounds(452, 29, 21, 15);
		cart_ItemPanel1_1_1.add(cart_PpHangleLabel1_1_1_1);
		
		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("300,000");
		lblNewLabel_1_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_1_1.setBounds(398, 29, 57, 15);
		cart_ItemPanel1_1_1.add(lblNewLabel_1_1_2_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/디지털.png")));
		lblNewLabel_1_1_1_1.setBounds(57, -2, 64, 72);
		cart_ItemPanel2.add(lblNewLabel_1_1_1_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox_1_1_1.setBounds(219, 23, 44, 23);
		cart_ItemPanel2.add(comboBox_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("디지털");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(134, 27, 57, 15);
		cart_ItemPanel2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("디지털");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(304, 27, 57, 15);
		cart_ItemPanel2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\\ 300,000");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(398, 27, 57, 15);
		cart_ItemPanel2.add(lblNewLabel_1_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(20, 23, 21, 23);
		cart_ItemPanel2.add(chckbxNewCheckBox);
		
		
		JPanel shop_OrderListPanel = new JPanel();
		shop_OrderListPanel.setBackground(Color.WHITE);
		shopTabbedPane.addTab("주문목록", null, shop_OrderListPanel, null);
		shop_OrderListPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane order_ScrollPane = new JScrollPane();
		order_ScrollPane.setPreferredSize(new Dimension(390, 780));
		order_ScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		order_ScrollPane.setBackground(Color.WHITE);
		shop_OrderListPanel.add(order_ScrollPane, BorderLayout.CENTER);
		
		order_ContentPane = new JPanel();
		order_ContentPane.setPreferredSize(new Dimension(390, 780));
		order_ContentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		order_ContentPane.setBackground(Color.WHITE);
		order_ScrollPane.setViewportView(order_ContentPane);
		order_ContentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel order_ItemPanel = new JPanel();
		order_ItemPanel.setLayout(null);
		order_ItemPanel.setPreferredSize(new Dimension(390, 60));
		order_ItemPanel.setBorder(null);
		order_ItemPanel.setBackground(Color.WHITE);
		order_ContentPane.add(order_ItemPanel);
		
		JPanel order_ProductPanel1 = new JPanel();
		order_ProductPanel1.setLayout(null);
		order_ProductPanel1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		order_ProductPanel1.setBounds(0, 40, 485, 80);
		order_ItemPanel.add(order_ProductPanel1);
		
		JLabel order_ItemNameLable_2 = new JLabel(" 디지털 외 3종.....");
		order_ItemNameLable_2.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNameLable_2.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		order_ItemNameLable_2.setBounds(211, 34, 103, 16);
		order_ProductPanel1.add(order_ItemNameLable_2);
		
		JLabel order_ItemTotPrice_2 = new JLabel("￦ 900,000");
		order_ItemTotPrice_2.setHorizontalAlignment(SwingConstants.RIGHT);
		order_ItemTotPrice_2.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		order_ItemTotPrice_2.setBounds(361, 34, 69, 16);
		order_ProductPanel1.add(order_ItemTotPrice_2);
		
		JLabel order_ItemNameLable_2_1 = new JLabel("2023/07/20");
		order_ItemNameLable_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNameLable_2_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		order_ItemNameLable_2_1.setBounds(103, 34, 81, 16);
		order_ProductPanel1.add(order_ItemNameLable_2_1);
		
		JCheckBox chckbxNewCheckBox_2_2_1_1 = new JCheckBox("");
		chckbxNewCheckBox_2_2_1_1.setBounds(42, 34, 21, 23);
		order_ProductPanel1.add(chckbxNewCheckBox_2_2_1_1);
		
		Panel order_ListTiltlePanel = new Panel();
		order_ListTiltlePanel.setBounds(0, 0, 485, 33);
		order_ItemPanel.add(order_ListTiltlePanel);
		order_ListTiltlePanel.setLayout(null);
		
		JLabel order_ItemNameLable_4 = new JLabel("상세내역");
		order_ItemNameLable_4.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNameLable_4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		order_ItemNameLable_4.setBounds(228, 10, 69, 16);
		order_ListTiltlePanel.add(order_ItemNameLable_4);
		
		JLabel order_ItemNo_4 = new JLabel("주문일");
		order_ItemNo_4.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNo_4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		order_ItemNo_4.setBounds(121, 10, 44, 16);
		order_ListTiltlePanel.add(order_ItemNo_4);
		
		JLabel order_ItemTotPrice_4 = new JLabel("주문금액");
		order_ItemTotPrice_4.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemTotPrice_4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		order_ItemTotPrice_4.setBounds(361, 10, 69, 16);
		order_ListTiltlePanel.add(order_ItemTotPrice_4);
		
		JCheckBox chckbxNewCheckBox_2_2_1 = new JCheckBox("");
		chckbxNewCheckBox_2_2_1.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox_2_2_1.setBounds(8, 7, 21, 23);
		order_ListTiltlePanel.add(chckbxNewCheckBox_2_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("전체선택");
		lblNewLabel_2_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(37, 11, 57, 15);
		order_ListTiltlePanel.add(lblNewLabel_2_1);
		
		JPanel order_ProductPanel1_1 = new JPanel();
		order_ProductPanel1_1.setLayout(null);
		order_ProductPanel1_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		order_ProductPanel1_1.setBounds(0, 130, 485, 80);
		order_ItemPanel.add(order_ProductPanel1_1);
		
		JLabel order_ItemNameLable_2_2 = new JLabel(" 디지털 외 3종.....");
		order_ItemNameLable_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNameLable_2_2.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		order_ItemNameLable_2_2.setBounds(211, 34, 103, 16);
		order_ProductPanel1_1.add(order_ItemNameLable_2_2);
		
		JLabel order_ItemTotPrice_2_1 = new JLabel("￦ 900,000");
		order_ItemTotPrice_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		order_ItemTotPrice_2_1.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		order_ItemTotPrice_2_1.setBounds(361, 34, 69, 16);
		order_ProductPanel1_1.add(order_ItemTotPrice_2_1);
		
		JLabel order_ItemNameLable_2_1_1 = new JLabel("2023/07/20");
		order_ItemNameLable_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNameLable_2_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		order_ItemNameLable_2_1_1.setBounds(103, 34, 81, 16);
		order_ProductPanel1_1.add(order_ItemNameLable_2_1_1);
		
		JCheckBox chckbxNewCheckBox_2_2_1_1_1 = new JCheckBox("");
		chckbxNewCheckBox_2_2_1_1_1.setBounds(42, 34, 21, 23);
		order_ProductPanel1_1.add(chckbxNewCheckBox_2_2_1_1_1);
		
		JPanel order_ProductPanel1_1_1 = new JPanel();
		order_ProductPanel1_1_1.setLayout(null);
		order_ProductPanel1_1_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		order_ProductPanel1_1_1.setBounds(0, 220, 485, 80);
		order_ItemPanel.add(order_ProductPanel1_1_1);
		
		JLabel order_ItemNameLable_2_2_1 = new JLabel(" 디지털 외 3종.....");
		order_ItemNameLable_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNameLable_2_2_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		order_ItemNameLable_2_2_1.setBounds(211, 34, 103, 16);
		order_ProductPanel1_1_1.add(order_ItemNameLable_2_2_1);
		
		JLabel order_ItemTotPrice_2_1_1 = new JLabel("￦ 900,000");
		order_ItemTotPrice_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		order_ItemTotPrice_2_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		order_ItemTotPrice_2_1_1.setBounds(361, 34, 69, 16);
		order_ProductPanel1_1_1.add(order_ItemTotPrice_2_1_1);
		
		JLabel order_ItemNameLable_2_1_1_1 = new JLabel("2023/07/20");
		order_ItemNameLable_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNameLable_2_1_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		order_ItemNameLable_2_1_1_1.setBounds(103, 34, 81, 16);
		order_ProductPanel1_1_1.add(order_ItemNameLable_2_1_1_1);
		
		JCheckBox chckbxNewCheckBox_2_2_1_1_1_1 = new JCheckBox("");
		chckbxNewCheckBox_2_2_1_1_1_1.setBounds(42, 34, 21, 23);
		order_ProductPanel1_1_1.add(chckbxNewCheckBox_2_2_1_1_1_1);
		
		JPanel order_ProductPanel1_1_1_1 = new JPanel();
		order_ProductPanel1_1_1_1.setLayout(null);
		order_ProductPanel1_1_1_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		order_ProductPanel1_1_1_1.setBounds(0, 310, 485, 80);
		order_ItemPanel.add(order_ProductPanel1_1_1_1);
		
		JLabel order_ItemNameLable_2_2_1_1 = new JLabel(" 디지털 외 3종.....");
		order_ItemNameLable_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNameLable_2_2_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		order_ItemNameLable_2_2_1_1.setBounds(211, 34, 103, 16);
		order_ProductPanel1_1_1_1.add(order_ItemNameLable_2_2_1_1);
		
		JLabel order_ItemTotPrice_2_1_1_1 = new JLabel("￦ 900,000");
		order_ItemTotPrice_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		order_ItemTotPrice_2_1_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		order_ItemTotPrice_2_1_1_1.setBounds(361, 34, 69, 16);
		order_ProductPanel1_1_1_1.add(order_ItemTotPrice_2_1_1_1);
		
		JLabel order_ItemNameLable_2_1_1_1_1 = new JLabel("2023/07/20");
		order_ItemNameLable_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		order_ItemNameLable_2_1_1_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		order_ItemNameLable_2_1_1_1_1.setBounds(103, 34, 81, 16);
		order_ProductPanel1_1_1_1.add(order_ItemNameLable_2_1_1_1_1);
		
		JCheckBox chckbxNewCheckBox_2_2_1_1_1_1_1 = new JCheckBox("");
		chckbxNewCheckBox_2_2_1_1_1_1_1.setBounds(42, 34, 21, 23);
		order_ProductPanel1_1_1_1.add(chckbxNewCheckBox_2_2_1_1_1_1_1);
		
		
		JPanel order_BntPanel = new JPanel();
		shop_OrderListPanel.add(order_BntPanel, BorderLayout.SOUTH);
		
		JButton order_Btn = new JButton("주 문 삭 제");
		order_Btn.setFont(new Font("나눔고딕", Font.BOLD, 15));
		order_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		order_BntPanel.add(order_Btn);
		
		/* 서비스 생성*/
		userService = new UserService();
		
	} // 생성자 끝
	
	private void loginProcess(User loginUser)throws Exception{
		this.loginUser = loginUser;
		setTitle(loginUser.getName() + "님 로그인");
		shopTabbedPane.setEnabledAt(1, false);
		
	}
	
} 
