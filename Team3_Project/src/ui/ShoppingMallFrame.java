package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import cart.CartService;
import order.OrderService;
import product.ProductService;
import user.User;
import user.UserService;
import javax.swing.table.DefaultTableModel;

public class ShoppingMallFrame extends JFrame {

	/************ 1. 서비스 객체변수 선언 **************/
	private UserService userservice;
	private CartService cartservice;
	private ProductService productservice;
	private OrderService orderservice;

	/************ loginUser **************/
	private User loginUser = null;

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
	private JComboBox info_GenderComboBox;
	private JComboBox join_GenderComboBox;

	private JComboBox fashion_CartQtyComboBox;
	private JComboBox fashion_CartQtyComboBox2;
	private JTable cartTable;
	private JTable orderTable;


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
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			
			// 메뉴바 장바구니 이미지 클릭 시 장바구니로 이동
			
			public void mouseClicked(MouseEvent e) {
			
				if (loginUser == null) {
					JOptionPane.showMessageDialog(null, "로그인이 필요합니다.");
					shopTabbedPane.setSelectedIndex(1);
				}else {			
			try {
				shopTabbedPane.setSelectedIndex(5);
			} catch (Exception e2) {
				
			}
			}
			}
		});
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
		tabbedPane.addTab("HOME", null, homePanel, null);
		homePanel.setLayout(null);
		
		JLabel fashionLabel = new JLabel("패  션");
		fashionLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);	
			}
			
		});
		fashionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fashionLabel.setBounds(90, 177, 57, 15);
		homePanel.add(fashionLabel);
		
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
		
		
		JLabel fashionImage = new JLabel("");
		fashionImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);	
			}
		});
		fashionImage.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/옷.png")));
		fashionImage.setHorizontalAlignment(SwingConstants.CENTER);
		fashionImage.setBounds(80, 87, 77, 80);
		homePanel.add(fashionImage);
		
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
		fashionPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel fashion_ContentPanel = new JPanel();
		fashionPanel.add(fashion_ContentPanel);
		fashion_ContentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel fashion_Product1 = new JPanel();
		fashion_Product1.setLayout(null);
		fashion_Product1.setSize(new Dimension(120, 120));
		fashion_Product1.setPreferredSize(new Dimension(170, 190));
		fashion_Product1.setMinimumSize(new Dimension(150, 150));
		fashion_Product1.setMaximumSize(new Dimension(200, 200));
		fashion_Product1.setBounds(new Rectangle(0, 0, 120, 120));
		fashion_Product1.setBorder(null);
		fashion_Product1.setBackground(Color.WHITE);
		fashion_Product1.setAlignmentY(1.0f);
		fashion_Product1.setAlignmentX(1.0f);
		fashion_ContentPanel.add(fashion_Product1);
		
		JLabel fashion_IconLabel1 = new JLabel("");
		fashion_IconLabel1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/fashion.Tshirt.png")));
		fashion_IconLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		fashion_IconLabel1.setBounds(3, 1, 162, 116);
		fashion_Product1.add(fashion_IconLabel1);
		
		JLabel fashion_DescLabel = new JLabel("<html>\r\n\t<font size='3'>\r\n\t\t\r\n\t\t\t상품: 옷<br>\r\n\t\t\t가격: 100,000<br>\r\n\t\t\t설명: 튼튼하네\r\n\t\t\r\n </font></html>");
		fashion_DescLabel.setVerticalAlignment(SwingConstants.TOP);
		fashion_DescLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		fashion_DescLabel.setHorizontalAlignment(SwingConstants.LEFT);
		fashion_DescLabel.setBounds(3, 143, 164, 47);
		fashion_Product1.add(fashion_DescLabel);
		
		JButton fashion_CartAddButton = new JButton("");
		fashion_CartAddButton.setActionCommand("1");
		fashion_CartAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(fashion_CartAddButton.getActionCommand());
				System.out.println(fashion_CartQtyComboBox.getSelectedItem());
				
			}
		});
		fashion_CartAddButton.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		fashion_CartAddButton.setOpaque(false);
		fashion_CartAddButton.setForeground(Color.WHITE);
		fashion_CartAddButton.setBorder(null);
		fashion_CartAddButton.setBackground(Color.WHITE);
		fashion_CartAddButton.setBounds(136, 119, 31, 23);
		fashion_Product1.add(fashion_CartAddButton);
		
		fashion_CartQtyComboBox = new JComboBox();
		fashion_CartQtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		fashion_CartQtyComboBox.setOpaque(false);
		fashion_CartQtyComboBox.setMaximumRowCount(10);
		fashion_CartQtyComboBox.setBorder(null);
		fashion_CartQtyComboBox.setBackground(Color.WHITE);
		fashion_CartQtyComboBox.setAutoscrolls(true);
		fashion_CartQtyComboBox.setBounds(99, 119, 33, 23);
		fashion_Product1.add(fashion_CartQtyComboBox);
		
		JPanel fashion_Product2 = new JPanel();
		fashion_Product2.setLayout(null);
		fashion_Product2.setSize(new Dimension(120, 120));
		fashion_Product2.setPreferredSize(new Dimension(170, 190));
		fashion_Product2.setMinimumSize(new Dimension(150, 150));
		fashion_Product2.setMaximumSize(new Dimension(200, 200));
		fashion_Product2.setBounds(new Rectangle(0, 0, 120, 120));
		fashion_Product2.setBorder(null);
		fashion_Product2.setBackground(Color.WHITE);
		fashion_Product2.setAlignmentY(1.0f);
		fashion_Product2.setAlignmentX(1.0f);
		fashion_ContentPanel.add(fashion_Product2);
		
		JLabel fashion_IconLabel2 = new JLabel("");
		fashion_IconLabel2.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/fashion.Tshirt.png")));
		fashion_IconLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		fashion_IconLabel2.setBounds(3, 1, 162, 116);
		fashion_Product2.add(fashion_IconLabel2);
		
		JLabel fashion_DescLabel2 = new JLabel("<html>\r\n\t<font size='3'>\r\n\t\t\r\n\t\t\t상품: 옷<br>\r\n\t\t\t가격: 100,000<br>\r\n\t\t\t설명: 튼튼하네\r\n\t\t\r\n </font></html>");
		fashion_DescLabel2.setVerticalAlignment(SwingConstants.TOP);
		fashion_DescLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		fashion_DescLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		fashion_DescLabel2.setBounds(3, 143, 164, 47);
		fashion_Product2.add(fashion_DescLabel2);
		
		JButton fashion_CartAddButton2 = new JButton("");
		fashion_CartAddButton2.setActionCommand("2");
		fashion_CartAddButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(fashion_CartAddButton2.getActionCommand());
				System.out.println(fashion_CartQtyComboBox2.getSelectedItem());
				
			}
		});
		fashion_CartAddButton2.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		fashion_CartAddButton2.setOpaque(false);
		fashion_CartAddButton2.setForeground(Color.WHITE);
		fashion_CartAddButton2.setBorder(null);
		fashion_CartAddButton2.setBackground(Color.WHITE);
		fashion_CartAddButton2.setBounds(136, 119, 31, 23);
		fashion_Product2.add(fashion_CartAddButton2);
		
		fashion_CartQtyComboBox2 = new JComboBox();
		fashion_CartQtyComboBox2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		fashion_CartQtyComboBox2.setOpaque(false);
		fashion_CartQtyComboBox2.setMaximumRowCount(10);
		fashion_CartQtyComboBox2.setBorder(null);
		fashion_CartQtyComboBox2.setBackground(Color.WHITE);
		fashion_CartQtyComboBox2.setAutoscrolls(true);
		fashion_CartQtyComboBox2.setBounds(99, 119, 33, 23);
		fashion_Product2.add(fashion_CartQtyComboBox2);
		
		JPanel sportPanel = new JPanel();
		tabbedPane.addTab("스포츠", null, sportPanel, null);
		sportPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel sport_ContentPanel = new JPanel();
		sportPanel.add(sport_ContentPanel);
		sport_ContentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel sport_Product1 = new JPanel();
		sport_Product1.setLayout(null);
		sport_Product1.setSize(new Dimension(120, 120));
		sport_Product1.setPreferredSize(new Dimension(170, 190));
		sport_Product1.setMinimumSize(new Dimension(150, 150));
		sport_Product1.setMaximumSize(new Dimension(200, 200));
		sport_Product1.setBounds(new Rectangle(0, 0, 120, 120));
		sport_Product1.setBorder(null);
		sport_Product1.setBackground(Color.WHITE);
		sport_Product1.setAlignmentY(1.0f);
		sport_Product1.setAlignmentX(1.0f);
		sport_ContentPanel.add(sport_Product1);
		
		JLabel sport_IconLabel1_1 = new JLabel("");
		sport_IconLabel1_1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/sports.basketball.png")));
		sport_IconLabel1_1.setHorizontalAlignment(SwingConstants.CENTER);
		sport_IconLabel1_1.setBounds(3, 1, 162, 116);
		sport_Product1.add(sport_IconLabel1_1);
		
		JLabel sport_DescLabel_1 = new JLabel("<html>\r\n\t<font size='3'>\r\n\t\t\r\n\t\t\t상품: 농구공<br>\r\n\t\t\t가격: 50,000<br>\r\n\t\t\t설명: 농구고옹\r\n\t\t\r\n </font></html>");
		sport_DescLabel_1.setVerticalAlignment(SwingConstants.TOP);
		sport_DescLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		sport_DescLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		sport_DescLabel_1.setBounds(3, 143, 164, 47);
		sport_Product1.add(sport_DescLabel_1);
		
		JButton sport_CartAddButton_1 = new JButton("");
		sport_CartAddButton_1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		sport_CartAddButton_1.setOpaque(false);
		sport_CartAddButton_1.setForeground(Color.WHITE);
		sport_CartAddButton_1.setBorder(null);
		sport_CartAddButton_1.setBackground(Color.WHITE);
		sport_CartAddButton_1.setBounds(136, 119, 31, 23);
		sport_Product1.add(sport_CartAddButton_1);
		
		JComboBox sport_CartQtyComboBox_1 = new JComboBox();
		sport_CartQtyComboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		sport_CartQtyComboBox_1.setOpaque(false);
		sport_CartQtyComboBox_1.setMaximumRowCount(10);
		sport_CartQtyComboBox_1.setBorder(null);
		sport_CartQtyComboBox_1.setBackground(Color.WHITE);
		sport_CartQtyComboBox_1.setAutoscrolls(true);
		sport_CartQtyComboBox_1.setBounds(99, 119, 33, 23);
		sport_Product1.add(sport_CartQtyComboBox_1);
		
		JPanel sport_Product2 = new JPanel();
		sport_Product2.setLayout(null);
		sport_Product2.setSize(new Dimension(120, 120));
		sport_Product2.setPreferredSize(new Dimension(170, 190));
		sport_Product2.setMinimumSize(new Dimension(150, 150));
		sport_Product2.setMaximumSize(new Dimension(200, 200));
		sport_Product2.setBounds(new Rectangle(0, 0, 120, 120));
		sport_Product2.setBorder(null);
		sport_Product2.setBackground(Color.WHITE);
		sport_Product2.setAlignmentY(1.0f);
		sport_Product2.setAlignmentX(1.0f);
		sport_ContentPanel.add(sport_Product2);
		
		JLabel sport_IconLabel2 = new JLabel("");
		sport_IconLabel2.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/sports.basketball.png")));
		sport_IconLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		sport_IconLabel2.setBounds(3, 1, 162, 116);
		sport_Product2.add(sport_IconLabel2);
		
		JLabel sport_DescLabel2 = new JLabel("<html>\r\n\t<font size='3'>\r\n\t\t\r\n\t\t\t상품: 농구공<br>\r\n\t\t\t가격: 50,000<br>\r\n\t\t\t설명: 농구고옹\r\n\t\t\r\n </font></html>");
		sport_DescLabel2.setVerticalAlignment(SwingConstants.TOP);
		sport_DescLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		sport_DescLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		sport_DescLabel2.setBounds(3, 143, 164, 47);
		sport_Product2.add(sport_DescLabel2);
		
		JButton sport_CartAddButton2 = new JButton("");
		sport_CartAddButton2.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		sport_CartAddButton2.setOpaque(false);
		sport_CartAddButton2.setForeground(Color.WHITE);
		sport_CartAddButton2.setBorder(null);
		sport_CartAddButton2.setBackground(Color.WHITE);
		sport_CartAddButton2.setBounds(136, 119, 31, 23);
		sport_Product2.add(sport_CartAddButton2);
		
		JComboBox sport_CartQtyComboBox2 = new JComboBox();
		sport_CartQtyComboBox2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		sport_CartQtyComboBox2.setOpaque(false);
		sport_CartQtyComboBox2.setMaximumRowCount(10);
		sport_CartQtyComboBox2.setBorder(null);
		sport_CartQtyComboBox2.setBackground(Color.WHITE);
		sport_CartQtyComboBox2.setAutoscrolls(true);
		sport_CartQtyComboBox2.setBounds(99, 119, 33, 23);
		sport_Product2.add(sport_CartQtyComboBox2);
		
		JPanel dailyPane = new JPanel();
		tabbedPane.addTab("생 활", null, dailyPane, null);
		dailyPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel daily_ContentPanel = new JPanel();
		dailyPane.add(daily_ContentPanel);
		daily_ContentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel daily_Product1 = new JPanel();
		daily_Product1.setLayout(null);
		daily_Product1.setSize(new Dimension(120, 120));
		daily_Product1.setPreferredSize(new Dimension(170, 190));
		daily_Product1.setMinimumSize(new Dimension(150, 150));
		daily_Product1.setMaximumSize(new Dimension(200, 200));
		daily_Product1.setBounds(new Rectangle(0, 0, 120, 120));
		daily_Product1.setBorder(null);
		daily_Product1.setBackground(Color.WHITE);
		daily_Product1.setAlignmentY(1.0f);
		daily_Product1.setAlignmentX(1.0f);
		daily_ContentPanel.add(daily_Product1);
		
		JLabel daily_IconLabel1 = new JLabel("");
		daily_IconLabel1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/life.tissue.png")));
		daily_IconLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		daily_IconLabel1.setBounds(3, 1, 162, 116);
		daily_Product1.add(daily_IconLabel1);
		
		JLabel daily_DescLabel1 = new JLabel("<html>\r\n\t<font size='3'>\r\n\t\t\r\n\t\t\t상품: 휴지<br>\r\n\t\t\t가격: 50,000<br>\r\n\t\t\t설명: 잘풀리는 휴지\r\n\t\t\r\n </font></html>");
		daily_DescLabel1.setVerticalAlignment(SwingConstants.TOP);
		daily_DescLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
		daily_DescLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		daily_DescLabel1.setBounds(3, 143, 164, 47);
		daily_Product1.add(daily_DescLabel1);
		
		JButton daily_CartAddButton1 = new JButton("");
		daily_CartAddButton1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		daily_CartAddButton1.setOpaque(false);
		daily_CartAddButton1.setForeground(Color.WHITE);
		daily_CartAddButton1.setBorder(null);
		daily_CartAddButton1.setBackground(Color.WHITE);
		daily_CartAddButton1.setBounds(136, 119, 31, 23);
		daily_Product1.add(daily_CartAddButton1);
		
		JComboBox daily_CartQtyComboBox1 = new JComboBox();
		daily_CartQtyComboBox1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		daily_CartQtyComboBox1.setOpaque(false);
		daily_CartQtyComboBox1.setMaximumRowCount(10);
		daily_CartQtyComboBox1.setBorder(null);
		daily_CartQtyComboBox1.setBackground(Color.WHITE);
		daily_CartQtyComboBox1.setAutoscrolls(true);
		daily_CartQtyComboBox1.setBounds(99, 119, 33, 23);
		daily_Product1.add(daily_CartQtyComboBox1);
		
		JPanel daily_Product2 = new JPanel();
		daily_Product2.setLayout(null);
		daily_Product2.setSize(new Dimension(120, 120));
		daily_Product2.setPreferredSize(new Dimension(170, 190));
		daily_Product2.setMinimumSize(new Dimension(150, 150));
		daily_Product2.setMaximumSize(new Dimension(200, 200));
		daily_Product2.setBounds(new Rectangle(0, 0, 120, 120));
		daily_Product2.setBorder(null);
		daily_Product2.setBackground(Color.WHITE);
		daily_Product2.setAlignmentY(1.0f);
		daily_Product2.setAlignmentX(1.0f);
		daily_ContentPanel.add(daily_Product2);
		
		JLabel daily_conLabel2 = new JLabel("");
		daily_conLabel2.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/life.dry.png")));
		daily_conLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		daily_conLabel2.setBounds(3, 1, 162, 116);
		daily_Product2.add(daily_conLabel2);
		
		JLabel daily_DescLabel2 = new JLabel("<html>\r\n\t<font size='3'>\r\n\t\t\r\n\t\t\t상품: 건조기<br>\r\n\t\t\t가격: 50,000<br>\r\n\t\t\t설명: 잘말리는 건조기\r\n\t\t\r\n </font></html>");
		daily_DescLabel2.setVerticalAlignment(SwingConstants.TOP);
		daily_DescLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		daily_DescLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		daily_DescLabel2.setBounds(3, 143, 164, 47);
		daily_Product2.add(daily_DescLabel2);
		
		JButton daily_CartAddButton2 = new JButton("");
		daily_CartAddButton2.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		daily_CartAddButton2.setOpaque(false);
		daily_CartAddButton2.setForeground(Color.WHITE);
		daily_CartAddButton2.setBorder(null);
		daily_CartAddButton2.setBackground(Color.WHITE);
		daily_CartAddButton2.setBounds(136, 119, 31, 23);
		daily_Product2.add(daily_CartAddButton2);
		
		JComboBox daily_CartQtyComboBox2 = new JComboBox();
		daily_CartQtyComboBox2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		daily_CartQtyComboBox2.setOpaque(false);
		daily_CartQtyComboBox2.setMaximumRowCount(10);
		daily_CartQtyComboBox2.setBorder(null);
		daily_CartQtyComboBox2.setBackground(Color.WHITE);
		daily_CartQtyComboBox2.setAutoscrolls(true);
		daily_CartQtyComboBox2.setBounds(99, 119, 33, 23);
		daily_Product2.add(daily_CartQtyComboBox2);
		
		JPanel furniturePanel = new JPanel();
		tabbedPane.addTab("가 구", null, furniturePanel, null);
		furniturePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel furniture_ContentPanel = new JPanel();
		furniturePanel.add(furniture_ContentPanel);
		furniture_ContentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		

		JPanel furniture_Product1 = new JPanel();
		furniture_Product1.setLayout(null);
		furniture_Product1.setSize(new Dimension(120, 120));
		furniture_Product1.setPreferredSize(new Dimension(170, 190));
		furniture_Product1.setMinimumSize(new Dimension(150, 150));
		furniture_Product1.setMaximumSize(new Dimension(200, 200));
		furniture_Product1.setBounds(new Rectangle(0, 0, 120, 120));
		furniture_Product1.setBorder(null);
		furniture_Product1.setBackground(Color.WHITE);
		furniture_Product1.setAlignmentY(1.0f);
		furniture_Product1.setAlignmentX(1.0f);
		furniture_ContentPanel.add(furniture_Product1);
		
		JLabel furniture_IconLabel1 = new JLabel("");
		furniture_IconLabel1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/furniture.chair.png")));
		furniture_IconLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		furniture_IconLabel1.setBounds(3, 1, 162, 116);
		furniture_Product1.add(furniture_IconLabel1);
		
		JLabel furniture_DescLabel1 = new JLabel("<html>\r\n\t<html>\r\n\t<font size='3'>\r\n\t\t\r\n\t\t\t상품: 의자<br>\r\n\t\t\t가격: 30,000<br>\r\n\t\t\t설명: 의자왕\r\n\t\t\r\n </font></html>");
		furniture_DescLabel1.setVerticalAlignment(SwingConstants.TOP);
		furniture_DescLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
		furniture_DescLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		furniture_DescLabel1.setBounds(3, 143, 164, 47);
		furniture_Product1.add(furniture_DescLabel1);
		
		JButton furniture_CartAddButton1 = new JButton("");
		furniture_CartAddButton1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		furniture_CartAddButton1.setOpaque(false);
		furniture_CartAddButton1.setForeground(Color.WHITE);
		furniture_CartAddButton1.setBorder(null);
		furniture_CartAddButton1.setBackground(Color.WHITE);
		furniture_CartAddButton1.setBounds(136, 119, 31, 23);
		furniture_Product1.add(furniture_CartAddButton1);
		
		JComboBox furniture_CartQtyComboBox1 = new JComboBox();
		furniture_CartQtyComboBox1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		furniture_CartQtyComboBox1.setOpaque(false);
		furniture_CartQtyComboBox1.setMaximumRowCount(10);
		furniture_CartQtyComboBox1.setBorder(null);
		furniture_CartQtyComboBox1.setBackground(Color.WHITE);
		furniture_CartQtyComboBox1.setAutoscrolls(true);
		furniture_CartQtyComboBox1.setBounds(99, 119, 33, 23);
		furniture_Product1.add(furniture_CartQtyComboBox1);
		
		JPanel furniture_Product2 = new JPanel();
		furniture_Product2.setLayout(null);
		furniture_Product2.setSize(new Dimension(120, 120));
		furniture_Product2.setPreferredSize(new Dimension(170, 190));
		furniture_Product2.setMinimumSize(new Dimension(150, 150));
		furniture_Product2.setMaximumSize(new Dimension(200, 200));
		furniture_Product2.setBounds(new Rectangle(0, 0, 120, 120));
		furniture_Product2.setBorder(null);
		furniture_Product2.setBackground(Color.WHITE);
		furniture_Product2.setAlignmentY(1.0f);
		furniture_Product2.setAlignmentX(1.0f);
		furniture_ContentPanel.add(furniture_Product2);
		
		JLabel furniture_onLabel2 = new JLabel("");
		furniture_onLabel2.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/furniture.sofa.png")));
		furniture_onLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		furniture_onLabel2.setBounds(3, 1, 162, 116);
		furniture_Product2.add(furniture_onLabel2);
		
		JLabel furniture_DescLabel2 = new JLabel("<html>\r\n\t<font size='3'>\r\n\t\t\r\n\t\t\t상품: 소파<br>\r\n\t\t\t가격: 400,000<br>\r\n\t\t\t설명: 소파입니다\r\n\t\t\r\n </font></html>");
		furniture_DescLabel2.setVerticalAlignment(SwingConstants.TOP);
		furniture_DescLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		furniture_DescLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		furniture_DescLabel2.setBounds(3, 143, 164, 47);
		furniture_Product2.add(furniture_DescLabel2);
		
		JButton furniture_CartAddButton2 = new JButton("");
		furniture_CartAddButton2.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		furniture_CartAddButton2.setOpaque(false);
		furniture_CartAddButton2.setForeground(Color.WHITE);
		furniture_CartAddButton2.setBorder(null);
		furniture_CartAddButton2.setBackground(Color.WHITE);
		furniture_CartAddButton2.setBounds(136, 119, 31, 23);
		furniture_Product2.add(furniture_CartAddButton2);
		
		JComboBox furniture_CartQtyComboBox2 = new JComboBox();
		furniture_CartQtyComboBox2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		furniture_CartQtyComboBox2.setOpaque(false);
		furniture_CartQtyComboBox2.setMaximumRowCount(10);
		furniture_CartQtyComboBox2.setBorder(null);
		furniture_CartQtyComboBox2.setBackground(Color.WHITE);
		furniture_CartQtyComboBox2.setAutoscrolls(true);
		furniture_CartQtyComboBox2.setBounds(99, 119, 33, 23);
		furniture_Product2.add(furniture_CartQtyComboBox2);
		
		JPanel digitalPanel = new JPanel();
		tabbedPane.addTab("디지털", null, digitalPanel, null);
		digitalPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel digital_ContentPanel = new JPanel();
		digitalPanel.add(digital_ContentPanel);
		digital_ContentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel digital_Product1 = new JPanel();
		digital_Product1.setLayout(null);
		digital_Product1.setSize(new Dimension(120, 120));
		digital_Product1.setPreferredSize(new Dimension(170, 190));
		digital_Product1.setMinimumSize(new Dimension(150, 150));
		digital_Product1.setMaximumSize(new Dimension(200, 200));
		digital_Product1.setBounds(new Rectangle(0, 0, 120, 120));
		digital_Product1.setBorder(null);
		digital_Product1.setBackground(Color.WHITE);
		digital_Product1.setAlignmentY(1.0f);
		digital_Product1.setAlignmentX(1.0f);
		digital_ContentPanel.add(digital_Product1);
		
		JLabel digital_IconLabel1 = new JLabel("");
		digital_IconLabel1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/digital3.jpg")));
		digital_IconLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		digital_IconLabel1.setBounds(3, 1, 162, 116);
		digital_Product1.add(digital_IconLabel1);
		
		JLabel digital_DescLabel1 = new JLabel("<html>\r\n\t<font size='3'>\r\n\t\t\r\n\t\t\t상품: 테블릿 PC<br>\r\n\t\t\t가격: 1,200,000<br>\r\n\t\t\t설명: 가전은 삼성\r\n\t\t\r\n </font></html>");
		digital_DescLabel1.setVerticalAlignment(SwingConstants.TOP);
		digital_DescLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
		digital_DescLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		digital_DescLabel1.setBounds(3, 143, 164, 47);
		digital_Product1.add(digital_DescLabel1);
		
		JButton digital_CartAddButton1 = new JButton("");
		digital_CartAddButton1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		digital_CartAddButton1.setOpaque(false);
		digital_CartAddButton1.setForeground(Color.WHITE);
		digital_CartAddButton1.setBorder(null);
		digital_CartAddButton1.setBackground(Color.WHITE);
		digital_CartAddButton1.setBounds(136, 119, 31, 23);
		digital_Product1.add(digital_CartAddButton1);
		
		JComboBox digital_CartQtyComboBox1 = new JComboBox();
		digital_CartQtyComboBox1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		digital_CartQtyComboBox1.setOpaque(false);
		digital_CartQtyComboBox1.setMaximumRowCount(10);
		digital_CartQtyComboBox1.setBorder(null);
		digital_CartQtyComboBox1.setBackground(Color.WHITE);
		digital_CartQtyComboBox1.setAutoscrolls(true);
		digital_CartQtyComboBox1.setBounds(99, 119, 33, 23);
		digital_Product1.add(digital_CartQtyComboBox1);
		
		JPanel digital_Product2 = new JPanel();
		digital_Product2.setLayout(null);
		digital_Product2.setSize(new Dimension(120, 120));
		digital_Product2.setPreferredSize(new Dimension(170, 190));
		digital_Product2.setMinimumSize(new Dimension(150, 150));
		digital_Product2.setMaximumSize(new Dimension(200, 200));
		digital_Product2.setBounds(new Rectangle(0, 0, 120, 120));
		digital_Product2.setBorder(null);
		digital_Product2.setBackground(Color.WHITE);
		digital_Product2.setAlignmentY(1.0f);
		digital_Product2.setAlignmentX(1.0f);
		digital_ContentPanel.add(digital_Product2);
		
		JLabel digital_onLabel2 = new JLabel("");
		digital_onLabel2.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/digital2.png")));
		digital_onLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		digital_onLabel2.setBounds(3, 1, 162, 116);
		digital_Product2.add(digital_onLabel2);
		
		JLabel digital_DescLabel2 = new JLabel("<html>\r\n\t<font size='3'>\r\n\t\t\r\n\t\t\t상품: 아이팟<br>\r\n\t\t\t가격: 500,000<br>\r\n\t\t\t설명: 애플 is 뭔들\r\n\t\t\r\n </font></html>");
		digital_DescLabel2.setVerticalAlignment(SwingConstants.TOP);
		digital_DescLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		digital_DescLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		digital_DescLabel2.setBounds(3, 143, 164, 47);
		digital_Product2.add(digital_DescLabel2);
		
		JButton digital_CartAddButton2 = new JButton("");
		digital_CartAddButton2.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		digital_CartAddButton2.setOpaque(false);
		digital_CartAddButton2.setForeground(Color.WHITE);
		digital_CartAddButton2.setBorder(null);
		digital_CartAddButton2.setBackground(Color.WHITE);
		digital_CartAddButton2.setBounds(136, 119, 31, 23);
		digital_Product2.add(digital_CartAddButton2);
		
		JComboBox digital_CartQtyComboBox2 = new JComboBox();
		digital_CartQtyComboBox2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		digital_CartQtyComboBox2.setOpaque(false);
		digital_CartQtyComboBox2.setMaximumRowCount(10);
		digital_CartQtyComboBox2.setBorder(null);
		digital_CartQtyComboBox2.setBackground(Color.WHITE);
		digital_CartQtyComboBox2.setAutoscrolls(true);
		digital_CartQtyComboBox2.setBounds(99, 119, 33, 23);
		digital_Product2.add(digital_CartQtyComboBox2);
		
		JPanel foodPanel = new JPanel();
		tabbedPane.addTab("음 식", null, foodPanel, null);
		foodPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel food_ContentPanel = new JPanel();
		foodPanel.add(food_ContentPanel);
		food_ContentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		

		JPanel food_Product1 = new JPanel();
		food_Product1.setLayout(null);
		food_Product1.setSize(new Dimension(120, 120));
		food_Product1.setPreferredSize(new Dimension(170, 190));
		food_Product1.setMinimumSize(new Dimension(150, 150));
		food_Product1.setMaximumSize(new Dimension(200, 200));
		food_Product1.setBounds(new Rectangle(0, 0, 120, 120));
		food_Product1.setBorder(null);
		food_Product1.setBackground(Color.WHITE);
		food_Product1.setAlignmentY(1.0f);
		food_Product1.setAlignmentX(1.0f);
		food_ContentPanel.add(food_Product1);
		
		JLabel food_IconLabel1 = new JLabel("");
		food_IconLabel1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/food.pizza.png")));
		food_IconLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		food_IconLabel1.setBounds(3, 1, 162, 116);
		food_Product1.add(food_IconLabel1);
		
		JLabel food_DescLabel1 = new JLabel("<html>\r\n\t<font size='3'>\r\n\t\t\r\n\t\t\t상품: 피자 PC<br>\r\n\t\t\t가격: 20,000<br>\r\n\t\t\t설명: 그냥피자\r\n\t\t\r\n </font></html>");
		food_DescLabel1.setVerticalAlignment(SwingConstants.TOP);
		food_DescLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
		food_DescLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		food_DescLabel1.setBounds(3, 143, 164, 47);
		food_Product1.add(food_DescLabel1);
		
		JButton food_CartAddButton1 = new JButton("");
		food_CartAddButton1.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		food_CartAddButton1.setOpaque(false);
		food_CartAddButton1.setForeground(Color.WHITE);
		food_CartAddButton1.setBorder(null);
		food_CartAddButton1.setBackground(Color.WHITE);
		food_CartAddButton1.setBounds(136, 119, 31, 23);
		food_Product1.add(food_CartAddButton1);
		
		JComboBox food_CartQtyComboBox1 = new JComboBox();
		food_CartQtyComboBox1.setOpaque(false);
		food_CartQtyComboBox1.setMaximumRowCount(10);
		food_CartQtyComboBox1.setBorder(null);
		food_CartQtyComboBox1.setBackground(Color.WHITE);
		food_CartQtyComboBox1.setAutoscrolls(true);
		food_CartQtyComboBox1.setBounds(99, 119, 33, 23);
		food_Product1.add(food_CartQtyComboBox1);
		
		JPanel food_Product2 = new JPanel();
		food_Product2.setLayout(null);
		food_Product2.setSize(new Dimension(120, 120));
		food_Product2.setPreferredSize(new Dimension(170, 190));
		food_Product2.setMinimumSize(new Dimension(150, 150));
		food_Product2.setMaximumSize(new Dimension(200, 200));
		food_Product2.setBounds(new Rectangle(0, 0, 120, 120));
		food_Product2.setBorder(null);
		food_Product2.setBackground(Color.WHITE);
		food_Product2.setAlignmentY(1.0f);
		food_Product2.setAlignmentX(1.0f);
		food_ContentPanel.add(food_Product2);
		
		JLabel food_onLabel2 = new JLabel("");
		food_onLabel2.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/Food1.png")));
		food_onLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		food_onLabel2.setBounds(3, 1, 162, 116);
		food_Product2.add(food_onLabel2);
		
		JLabel food_DescLabel2 = new JLabel("<html>\r\n\t<font size='3'>\r\n\t\t\r\n\t\t\t상품: 햇반<br>\r\n\t\t\t가격: 12,000<br>\r\n\t\t\t설명: 햇반\r\n\t\t\r\n </font></html>");
		food_DescLabel2.setVerticalAlignment(SwingConstants.TOP);
		food_DescLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		food_DescLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		food_DescLabel2.setBounds(3, 143, 164, 47);
		food_Product2.add(food_DescLabel2);
		
		JButton food_CartAddButton2 = new JButton("");
		food_CartAddButton2.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/카트.png")));
		food_CartAddButton2.setOpaque(false);
		food_CartAddButton2.setForeground(Color.WHITE);
		food_CartAddButton2.setBorder(null);
		food_CartAddButton2.setBackground(Color.WHITE);
		food_CartAddButton2.setBounds(136, 119, 31, 23);
		food_Product2.add(food_CartAddButton2);
		
		JComboBox digital_CartQtyComboBox2_1 = new JComboBox();
		digital_CartQtyComboBox2_1.setOpaque(false);
		digital_CartQtyComboBox2_1.setMaximumRowCount(10);
		digital_CartQtyComboBox2_1.setBorder(null);
		digital_CartQtyComboBox2_1.setBackground(Color.WHITE);
		digital_CartQtyComboBox2_1.setAutoscrolls(true);
		digital_CartQtyComboBox2_1.setBounds(99, 119, 33, 23);
		food_Product2.add(digital_CartQtyComboBox2_1);
		
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
						
				} 
			catch (Exception e1) {
				System.out.println("로그인에러-->"+e1.getMessage());
			}

			}
		});
		login_Btn.setBounds(143, 342, 97, 23);
		shop_LoginPanel.add(login_Btn);
		
		JButton login_joinBtn = new JButton("회원가입");
		login_joinBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				shopTabbedPane.setSelectedIndex(2);
			}
		});
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
		join_IdTextField.setBounds(189, 157, 107, 21);
		shop_JoinPanel.add(join_IdTextField);
		
		join_PasswordField = new JPasswordField();
		join_PasswordField.setBounds(189, 194, 204, 21);
		shop_JoinPanel.add(join_PasswordField);
		
		JButton join_Btn = new JButton("회원가입");
		join_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = join_IdTextField.getText();
					String password = new String(join_PasswordField.getPassword());
					String name = join_NameTextFiled.getText();
					String address = join_AddressTextField.getText();
					String phone = join_PhoneTextField.getText();
					String gender = "";
					if(join_GenderComboBox.getSelectedIndex()==0) {
						join_GenderComboBox.requestFocus();
						JOptionPane.showMessageDialog(null, "성별을 입력해주세요.");
						return;
					}else {
						gender = (String)join_GenderComboBox.getSelectedItem();
					}
					userservice.create(new User(id, password, name, address, phone, gender));
				} catch (Exception e2) {
					
				}
			}
		});
		join_Btn.setBackground(new Color(255, 255, 255));
		join_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		join_Btn.setBounds(142, 405, 115, 33);
		shop_JoinPanel.add(join_Btn);
		
		JButton join_jungbok_Btn = new JButton("중복체크");
		join_jungbok_Btn.setBounds(301, 156, 92, 23);
		shop_JoinPanel.add(join_jungbok_Btn);
		
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
		
		join_GenderComboBox = new JComboBox();
		join_GenderComboBox.setModel(new DefaultComboBoxModel(new String[] {"성별", "남성", "여성"}));
		join_GenderComboBox.setBounds(189, 333, 92, 23);
		shop_JoinPanel.add(join_GenderComboBox);
		
		JLabel join_Label = new JLabel("회 원 가 입");
		join_Label.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 35));
		join_Label.setBounds(208, 57, 183, 60);
		shop_JoinPanel.add(join_Label);
		
		JPanel shop_InfoPanel = new JPanel();
		shopTabbedPane.addTab("내정보", null, shop_InfoPanel, null);
		shopTabbedPane.setEnabledAt(3, false);
		shop_InfoPanel.setLayout(null);
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ	
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
		
		info_PhoneTextField = new JTextField();//연락처 
		info_PhoneTextField.setColumns(10);
		info_PhoneTextField.setBounds(178, 283, 204, 21);
		shop_InfoPanel.add(info_PhoneTextField);
		
		info_AddressTextField = new JTextField();//주소
		info_AddressTextField.setColumns(10);
		info_AddressTextField.setBounds(178, 248, 204, 21);
		shop_InfoPanel.add(info_AddressTextField);
		
		info_NameTextField = new JTextField();//이름
		info_NameTextField.setColumns(10);
		info_NameTextField.setBounds(178, 213, 204, 21);
		shop_InfoPanel.add(info_NameTextField);
		
		info_IdTextField = new JTextField();//아이디
		info_IdTextField.setEditable(false);
		info_IdTextField.setColumns(10);
		info_IdTextField.setBounds(178, 141, 204, 21);
		shop_InfoPanel.add(info_IdTextField);
		
		info_PasswordField = new JPasswordField();//비밀번호
		info_PasswordField.setBounds(178, 182, 204, 21);
		shop_InfoPanel.add(info_PasswordField);
		
		JButton info_Btn = new JButton("회원탈퇴");
		info_Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String id = loginUser.getUserId();
						userservice.deleteUser(id);
	
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "회원 탈퇴 에러 : "+e1.getMessage());
					}

				}
			});

		info_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		info_Btn.setBackground(Color.WHITE);
		info_Btn.setBounds(287, 381, 95, 33);
		shop_InfoPanel.add(info_Btn);
		
		JButton info_Cancle_Btn = new JButton("취소");
		info_Cancle_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		info_Cancle_Btn.setBackground(Color.WHITE);
		info_Cancle_Btn.setBounds(394, 381, 71, 33);
		shop_InfoPanel.add(info_Cancle_Btn);
		
		info_GenderComboBox = new JComboBox();
		info_GenderComboBox.setModel(new DefaultComboBoxModel(new String[] {"성별", "남성", "여성"}));
		info_GenderComboBox.setBounds(178, 317, 92, 23);
		shop_InfoPanel.add(info_GenderComboBox);
		
		JButton info_Cancle_Btn_1 = new JButton("수정");
		info_Cancle_Btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String id = info_IdTextField.getText();
					String password = new String(info_PasswordField.getPassword());
					String name = info_NameTextField.getText();
					String address = info_AddressTextField.getText();
					String phoneNumber = info_PhoneTextField.getText();
					String gender = (String)info_GenderComboBox.getSelectedItem();
					
					User updateUser = new User(id, password, name, address, phoneNumber, gender);
					userservice.loginUpdate(updateUser);
					
					//회원정보 변경
					
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "회원 수정 에러 : "+e1.getMessage());
				}

			}
		});
		info_Cancle_Btn_1.setFont(new Font("굴림", Font.BOLD, 15));
		info_Cancle_Btn_1.setBackground(new Color(255, 255, 102));
		info_Cancle_Btn_1.setBounds(190, 381, 85, 33);
		shop_InfoPanel.add(info_Cancle_Btn_1);
		
		JLabel info_Icon = new JLabel("");
		info_Icon.setIcon(new ImageIcon(ShoppingMallFrame.class.getResource("/ui/image/내정보.png")));
		info_Icon.setBounds(133, 41, 77, 64);
		shop_InfoPanel.add(info_Icon);
		
		JLabel lblNewLabel = new JLabel("내 정 보");
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 35));
		lblNewLabel.setBounds(224, 54, 129, 39);
		shop_InfoPanel.add(lblNewLabel);
		

		JButton info_User_Btn = new JButton("회원정보");
		info_User_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				displayUserInfo(loginUser);
				
			}
		});
		info_User_Btn.setFont(new Font("굴림", Font.BOLD, 15));
		info_User_Btn.setBackground(Color.WHITE);
		info_User_Btn.setBounds(83, 381, 95, 33);
		shop_InfoPanel.add(info_User_Btn);
		
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
		cart_ItemPanel.setLayout(null);
		cart_ItemPanel.setPreferredSize(new Dimension(390, 780));
		cart_ItemPanel.setBorder(null);
		cart_ContentPanel.add(cart_ItemPanel);
		
		Panel cart_ListSumPanel = new Panel();
		cart_ListSumPanel.setLayout(null);
		cart_ListSumPanel.setBounds(0, 366, 485, 37);
		cart_ItemPanel.add(cart_ListSumPanel);
		
		JLabel cart_itemPrice_4_2_1 = new JLabel("합  계 :");
		cart_itemPrice_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		cart_itemPrice_4_2_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		cart_itemPrice_4_2_1.setBounds(313, 11, 57, 15);
		cart_ListSumPanel.add(cart_itemPrice_4_2_1);
		
		JLabel cart_ItemTotPrice_4_2_1 = new JLabel("600,000");
		cart_ItemTotPrice_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		cart_ItemTotPrice_4_2_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		cart_ItemTotPrice_4_2_1.setBounds(382, 10, 91, 16);
		cart_ListSumPanel.add(cart_ItemTotPrice_4_2_1);
		

		JButton btnNewButton_2 = new JButton("삭  제");

		btnNewButton_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		btnNewButton_2.setBounds(204, 7, 97, 23);
		cart_ListSumPanel.add(btnNewButton_2);
		

		JButton cart_DelBnt = new JButton("구매");
		cart_DelBnt.setBounds(0, 7, 97, 23);
		cart_ListSumPanel.add(cart_DelBnt);
		cart_DelBnt.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		

		JButton cart_CahngeBnt = new JButton("수  정");
		cart_CahngeBnt.setBounds(92, 7, 97, 23);
		cart_ListSumPanel.add(cart_CahngeBnt);
		cart_CahngeBnt.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 23, 428, 161);
		cart_ItemPanel.add(scrollPane);
		
		cartTable = new JTable();
		cartTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\uC0C1\uD488\uBA85", "\uC218\uB7C9", "\uAC00\uACA9"
			}
		));
		scrollPane.setViewportView(cartTable);
		
		JPanel shop_OrderListPanel = new JPanel();
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 10, 393, 241);
		order_ItemPanel.add(scrollPane_1);
		
		orderTable = new JTable();
		orderTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\uC8FC\uBB38\uBC88\uD638", "\uC8FC\uBB38\uB0A0\uC9DC", "\uC8FC\uBB38\uAC00\uACA9"
			}
		));
		scrollPane_1.setViewportView(orderTable);
		
		
		JPanel order_BntPanel = new JPanel();
		shop_OrderListPanel.add(order_BntPanel, BorderLayout.SOUTH);
		
		JButton order_Btn = new JButton("주 문 삭 제");
		order_Btn.setFont(new Font("나눔고딕", Font.BOLD, 15));
		order_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		order_BntPanel.add(order_Btn);
	
		userservice = new UserService();

		cartservice = new CartService();

	} // 생성자 끝

	private void loginProcess(User loginUser) throws Exception {
		this.loginUser = loginUser;
		setTitle(loginUser.getName() + "님 로그인");
		shopTabbedPane.setEnabledAt(1, false);

		shopTabbedPane.setEnabledAt(3, true);
		shopTabbedPane.setSelectedIndex(0);

		shopTabbedPane.setSelectedIndex(0);
	}

	private void displayUserInfo(User loginUser) {
		/**** 로그인한회원상세데이타보여주기 *****/
		info_IdTextField.setText(loginUser.getUserId());
		info_AddressTextField.setText(loginUser.getAddress());
		info_NameTextField.setText(loginUser.getName());
		info_PasswordField.setText(loginUser.getPassword());
		info_PhoneTextField.setText(loginUser.getPhone());
		info_GenderComboBox.setSelectedItem(loginUser.getGender() + "");

	} 
	
}
