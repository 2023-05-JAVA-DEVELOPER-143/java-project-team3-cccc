package ShoppingMall.Frame;

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
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ShoppingMallFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField join_PhoneTextField;
	private JTextField join_AddressTextField;
	private JTextField join_NameTextFiled;
	private JTextField join_IdTextField;
	private JPasswordField join_PasswordField;
	private JTextField textField_5;
	private JPasswordField passwordField_1;
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
		setTitle("TEAM_SAMJO");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShoppingMallFrame.class.getResource("/ShoppingMall/image/로고1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 582);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("ShoppingMall ");
		menuBar.add(mnNewMenu);
		
		textField = new JTextField();
		textField.setText(" ");
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
		cartLabel.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ShoppingMall/image/카트.png")));
		menuBar.add(cartLabel);
		
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
		
		JPanel shopMainPanel = new JPanel();
		shopMainPanel.setToolTipText("");
		shopTabbedPane.addTab(" 상 품 ", null, shopMainPanel, null);
		shopMainPanel.setLayout(null);
		
		subPanel = new JPanel();
		subPanel.setBounds(0, 0, 444, 488);
		shopMainPanel.add(subPanel);
		subPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		subPanel.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel homePanel = new JPanel();
		tabbedPane.addTab("HOME", null, homePanel, null);
		homePanel.setLayout(null);
		
		JLabel fashion_Icon = new JLabel("");
		fashion_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ShoppingMall/image/옷.png")));
		fashion_Icon.setBounds(60, 114, 64, 64);
		homePanel.add(fashion_Icon);
		
		JLabel sport_Icon = new JLabel("");
		sport_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ShoppingMall/image/스포츠레저.png")));
		sport_Icon.setBounds(184, 114, 64, 71);
		homePanel.add(sport_Icon);
		
		JLabel daily_Icon = new JLabel("");
		daily_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ShoppingMall/image/생활.png")));
		daily_Icon.setBounds(308, 114, 70, 64);
		homePanel.add(daily_Icon);
		
		JLabel funiture_Icon = new JLabel("");
		funiture_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ShoppingMall/image/free-icon-furniture-5564823.png")));
		funiture_Icon.setBounds(60, 245, 77, 64);
		homePanel.add(funiture_Icon);
		
		JLabel digital_Icon = new JLabel("");
		digital_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ShoppingMall/image/디지털.png")));
		digital_Icon.setBounds(184, 245, 64, 53);
		homePanel.add(digital_Icon);
		
		JLabel food_Icon = new JLabel("");
		food_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ShoppingMall/image/식품.png")));
		food_Icon.setBounds(308, 245, 64, 71);
		homePanel.add(food_Icon);
		
		JLabel lblNewLabel_3 = new JLabel("패  션");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(70, 191, 57, 15);
		homePanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("스포츠");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(184, 195, 57, 15);
		homePanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("생  활");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setBounds(318, 188, 57, 15);
		homePanel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_3 = new JLabel("가  구");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setBounds(70, 316, 57, 15);
		homePanel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("디지털");
		lblNewLabel_3_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_1.setBounds(184, 316, 57, 15);
		homePanel.add(lblNewLabel_3_3_1);
		
		JLabel lblNewLabel_3_3_1_1 = new JLabel("음  식");
		lblNewLabel_3_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_1_1.setBounds(318, 316, 57, 15);
		homePanel.add(lblNewLabel_3_3_1_1);
		
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
		
		JPanel shopLoginPanel = new JPanel();
		shopTabbedPane.addTab("로그인", null, shopLoginPanel, null);
		shopLoginPanel.setLayout(null);
		
		JLabel loginIdLabel = new JLabel("아이디");
		loginIdLabel.setBounds(111, 164, 57, 15);
		shopLoginPanel.add(loginIdLabel);
		
		JLabel lgoinPasswordLabel = new JLabel("패쓰워드");
		lgoinPasswordLabel.setBounds(111, 226, 57, 15);
		shopLoginPanel.add(lgoinPasswordLabel);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(211, 161, 116, 21);
		shopLoginPanel.add(textField_5);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(211, 223, 116, 21);
		shopLoginPanel.add(passwordField_1);
		
		JButton loginBtn = new JButton("로그인");
		loginBtn.setBounds(111, 285, 97, 23);
		shopLoginPanel.add(loginBtn);
		
		JButton joinBtn = new JButton("회원가입");
		joinBtn.setBounds(230, 285, 97, 23);
		shopLoginPanel.add(joinBtn);
		
		JLabel lblNewLabel_1 = new JLabel("L O G I N");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(183, 73, 155, 44);
		shopLoginPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ShoppingMall/image/자물쇠.png")));
		lblNewLabel_2.setBounds(101, 65, 48, 52);
		shopLoginPanel.add(lblNewLabel_2);
		
		JPanel shopJoinPanel = new JPanel();
		shopTabbedPane.addTab("회원가입", null, shopJoinPanel, null);
		shopJoinPanel.setLayout(null);
		
		JLabel join_IdLabel = new JLabel("아이디");
		join_IdLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_IdLabel.setBounds(80, 168, 57, 15);
		shopJoinPanel.add(join_IdLabel);
		
		JLabel join_PasswordLabel = new JLabel("비밀번호");
		join_PasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_PasswordLabel.setBounds(80, 205, 57, 15);
		shopJoinPanel.add(join_PasswordLabel);
		
		JLabel join_NameLabel = new JLabel("이름");
		join_NameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_NameLabel.setBounds(80, 240, 57, 15);
		shopJoinPanel.add(join_NameLabel);
		
		JLabel join_AddressLabel = new JLabel("주소");
		join_AddressLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_AddressLabel.setBounds(80, 275, 57, 15);
		shopJoinPanel.add(join_AddressLabel);
		
		JLabel join_PhoneLabel = new JLabel("연락처");
		join_PhoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_PhoneLabel.setBounds(80, 310, 57, 15);
		shopJoinPanel.add(join_PhoneLabel);
		
		JLabel join_GenderLabel = new JLabel("성별");
		join_GenderLabel.setHorizontalAlignment(SwingConstants.LEFT);
		join_GenderLabel.setBounds(80, 345, 57, 15);
		shopJoinPanel.add(join_GenderLabel);
		
		join_PhoneTextField = new JTextField();
		join_PhoneTextField.setBounds(149, 307, 204, 21);
		shopJoinPanel.add(join_PhoneTextField);
		join_PhoneTextField.setColumns(10);
		
		join_AddressTextField = new JTextField();
		join_AddressTextField.setColumns(10);
		join_AddressTextField.setBounds(149, 272, 204, 21);
		shopJoinPanel.add(join_AddressTextField);
		
		join_NameTextFiled = new JTextField();
		join_NameTextFiled.setColumns(10);
		join_NameTextFiled.setBounds(149, 237, 204, 21);
		shopJoinPanel.add(join_NameTextFiled);
		
		join_IdTextField = new JTextField();
		join_IdTextField.setColumns(10);
		join_IdTextField.setBounds(149, 165, 107, 21);
		shopJoinPanel.add(join_IdTextField);
		
		join_PasswordField = new JPasswordField();
		join_PasswordField.setBounds(149, 202, 204, 21);
		shopJoinPanel.add(join_PasswordField);
		
		JButton join_Btn = new JButton("회원가입");
		join_Btn.setBackground(new Color(255, 255, 255));
		join_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		join_Btn.setBounds(103, 404, 115, 33);
		shopJoinPanel.add(join_Btn);
		
		JButton join_jungbok_Btn = new JButton("중복체크");
		join_jungbok_Btn.setBounds(261, 164, 92, 23);
		shopJoinPanel.add(join_jungbok_Btn);
		
		JButton join_Cancle_Btn = new JButton("취소");
		join_Cancle_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		join_Cancle_Btn.setBackground(new Color(255, 255, 255));
		join_Cancle_Btn.setBounds(232, 404, 115, 33);
		shopJoinPanel.add(join_Cancle_Btn);
		
		JLabel join_Icon = new JLabel("");
		join_Icon.setHorizontalAlignment(SwingConstants.CENTER);
		join_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ShoppingMall/image/5087579.png")));
		join_Icon.setBounds(180, 33, 92, 103);
		shopJoinPanel.add(join_Icon);
		
		JComboBox join_GenderComboBox = new JComboBox();
		join_GenderComboBox.setBounds(149, 341, 92, 23);
		shopJoinPanel.add(join_GenderComboBox);
		
		JPanel shopInfoPanel = new JPanel();
		shopTabbedPane.addTab("내정보", null, shopInfoPanel, null);
		shopInfoPanel.setLayout(null);
		
		JLabel info_IdLabel = new JLabel("아이디");
		info_IdLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_IdLabel.setBounds(82, 144, 57, 15);
		shopInfoPanel.add(info_IdLabel);
		
		JLabel info_PasswordLabel = new JLabel("비밀번호");
		info_PasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_PasswordLabel.setBounds(82, 181, 57, 15);
		shopInfoPanel.add(info_PasswordLabel);
		
		JLabel info_NameLabel = new JLabel("이름");
		info_NameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_NameLabel.setBounds(82, 216, 57, 15);
		shopInfoPanel.add(info_NameLabel);
		
		JLabel info_AddressLabel = new JLabel("주소");
		info_AddressLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_AddressLabel.setBounds(82, 251, 57, 15);
		shopInfoPanel.add(info_AddressLabel);
		
		JLabel info_PhoneLabel = new JLabel("연락처");
		info_PhoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_PhoneLabel.setBounds(82, 286, 57, 15);
		shopInfoPanel.add(info_PhoneLabel);
		
		JLabel info_GenderLabel = new JLabel("성별");
		info_GenderLabel.setHorizontalAlignment(SwingConstants.LEFT);
		info_GenderLabel.setBounds(82, 321, 57, 15);
		shopInfoPanel.add(info_GenderLabel);
		
		info_PhoneTextField = new JTextField();
		info_PhoneTextField.setColumns(10);
		info_PhoneTextField.setBounds(151, 283, 204, 21);
		shopInfoPanel.add(info_PhoneTextField);
		
		info_AddressTextField = new JTextField();
		info_AddressTextField.setColumns(10);
		info_AddressTextField.setBounds(151, 248, 204, 21);
		shopInfoPanel.add(info_AddressTextField);
		
		info_NameTextField = new JTextField();
		info_NameTextField.setColumns(10);
		info_NameTextField.setBounds(151, 213, 204, 21);
		shopInfoPanel.add(info_NameTextField);
		
		info_IdTextField = new JTextField();
		info_IdTextField.setColumns(10);
		info_IdTextField.setBounds(151, 141, 107, 21);
		shopInfoPanel.add(info_IdTextField);
		
		info_PasswordField = new JPasswordField();
		info_PasswordField.setBounds(151, 178, 204, 21);
		shopInfoPanel.add(info_PasswordField);
		
		JButton info_Btn = new JButton("회원탈퇴");
		info_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		info_Btn.setBackground(Color.WHITE);
		info_Btn.setBounds(80, 381, 95, 33);
		shopInfoPanel.add(info_Btn);
		
		JButton info_jungbok_Btn = new JButton("중복체크");
		info_jungbok_Btn.setBounds(263, 140, 92, 23);
		shopInfoPanel.add(info_jungbok_Btn);
		
		JButton info_Cancle_Btn = new JButton("취소");
		info_Cancle_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		info_Cancle_Btn.setBackground(Color.WHITE);
		info_Cancle_Btn.setBounds(284, 381, 71, 33);
		shopInfoPanel.add(info_Cancle_Btn);
		
		JComboBox info_GenderComboBox = new JComboBox();
		info_GenderComboBox.setBounds(151, 317, 92, 23);
		shopInfoPanel.add(info_GenderComboBox);
		
		JButton info_Cancle_Btn_1 = new JButton("수정");
		info_Cancle_Btn_1.setFont(new Font("굴림", Font.BOLD, 15));
		info_Cancle_Btn_1.setBackground(new Color(255, 255, 102));
		info_Cancle_Btn_1.setBounds(187, 381, 85, 33);
		shopInfoPanel.add(info_Cancle_Btn_1);
		
		JLabel info_Icon = new JLabel("");
		info_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ShoppingMall/image/내정보.png")));
		info_Icon.setBounds(106, 41, 77, 64);
		shopInfoPanel.add(info_Icon);
		
		JLabel lblNewLabel = new JLabel("내 정 보");
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 35));
		lblNewLabel.setBounds(197, 54, 129, 39);
		shopInfoPanel.add(lblNewLabel);
		
		JPanel shopAdminPanel = new JPanel();
		shopTabbedPane.addTab("관리창", null, shopAdminPanel, null);
		
		JPanel shopCartPanel = new JPanel();
		shopTabbedPane.addTab("장바구니", null, shopCartPanel, null);
		shopCartPanel.setLayout(new BorderLayout(0, 0));
		
	}
}
