package FRM;
import BUS.*;
import DAO.*;
import DTO.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class main extends JFrame {
	public static String TenNV="Lê Việt Hoàng";
	public static String MaNV="NV01";
	private JPanel contentPane;
	private JTextField txtTenDangNhap;
	private JPasswordField txtMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/iconMayBay.png"));
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 257);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTe = new JLabel("Tên đăng nhập");
		lblTe.setForeground(Color.RED);
		lblTe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTe.setBounds(23, 34, 125, 30);
		contentPane.add(lblTe);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setForeground(Color.RED);
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMtKhu.setBounds(23, 85, 125, 30);
		contentPane.add(lblMtKhu);
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setBounds(148, 34, 265, 30);
		contentPane.add(txtTenDangNhap);
		txtTenDangNhap.setColumns(10);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBackground(new Color(0, 255, 255));
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDangNhap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tdn=txtTenDangNhap.getText();
				String mk=txtMatKhau.getText();
				if(mk.equals("root") && tdn.equals("root"))
				{
					TrangChuFRM ct=new TrangChuFRM();
					ct.setVisible(true);
					setVisible(false);
				}
				else JOptionPane.showMessageDialog(null,"Tên đăng nhập hoặc mật khẩu không đúng.");
			}
		});
		btnDangNhap.setBounds(146, 158, 96, 30);
		contentPane.add(btnDangNhap);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(0, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setBounds(289, 158, 96, 30);
		contentPane.add(btnThoat);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(148, 85, 265, 30);
		contentPane.add(txtMatKhau);
		
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setIcon(new ImageIcon("images/hinh-nen-may-bay-dep-2.jpg"));
		lblBackGround.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackGround.setBounds(0, 0, 444, 228);
		contentPane.add(lblBackGround);
	}
}
