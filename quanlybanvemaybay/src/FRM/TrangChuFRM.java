package FRM;
import BUS.*;
import DAO.*;
import DTO.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class TrangChuFRM extends JFrame {

	private JPanel contentPane;
	private JPanel panelContent=new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChuFRM frame = new TrangChuFRM();
					frame.setUndecorated(true);
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
	public TrangChuFRM() {
		setUndecorated(true);
		setAutoRequestFocus(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1163, 710);
		setLocationRelativeTo(null);
		setTitle("Trang chủ");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, 0, 1273, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnTrangChu = new JButton("Trang chủ");
		
		btnTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		btnTrangChu.setIcon(new ImageIcon("images/iconTrangChu.png"));
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTrangChu.setBackground(Color.WHITE);
		btnTrangChu.setBounds(20, 11, 126, 46);
		panel.add(btnTrangChu);
		
		JButton btnNavBarTimKiem = new JButton("Tìm kiếm");
		
		btnNavBarTimKiem.setIcon(new ImageIcon("images/iconSearch.png"));
		btnNavBarTimKiem.setHorizontalAlignment(SwingConstants.LEFT);
		btnNavBarTimKiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNavBarTimKiem.setBackground(Color.WHITE);
		btnNavBarTimKiem.setBounds(565, 11, 126, 46);
		panel.add(btnNavBarTimKiem);
		
		JButton btnBanVe = new JButton("Bán vé");
	
		btnBanVe.setIcon(new ImageIcon("images/iconMayBay.png"));
		btnBanVe.setHorizontalAlignment(SwingConstants.LEFT);
		btnBanVe.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBanVe.setBackground(Color.WHITE);
		btnBanVe.setBounds(156, 11, 126, 46);
		panel.add(btnBanVe);
		
		JButton btnThongKe = new JButton("Thống kê");
		
		btnThongKe.setIcon(new ImageIcon("images/iconChart.png"));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThongKe.setBackground(Color.WHITE);
		btnThongKe.setBounds(429, 11, 126, 46);
		panel.add(btnThongKe);
		
		JButton btnQuanLy = new JButton("Quản lý");
		
		btnQuanLy.setIcon(new ImageIcon("images/iconQuanLy.png"));
		btnQuanLy.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLy.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuanLy.setBackground(Color.WHITE);
		btnQuanLy.setBounds(292, 11, 126, 46);
		panel.add(btnQuanLy);
		
		JButton btnNavbarThoat = new JButton("Thoát");
		btnNavbarThoat.setIcon(new ImageIcon("images/iconExit.png"));
		btnNavbarThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnNavbarThoat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNavbarThoat.setBackground(Color.WHITE);
		btnNavbarThoat.setBounds(701, 11, 126, 46);
		panel.add(btnNavbarThoat);
		
		JLabel lblTenDangNHap = new JLabel("");
		lblTenDangNHap.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenDangNHap.setForeground(Color.WHITE);
		lblTenDangNHap.setBounds(931, 11, 126, 22);
		panel.add(lblTenDangNHap);
		
		JLabel lblThoiGianDangNhap = new JLabel("");
		lblThoiGianDangNhap.setForeground(Color.WHITE);
		lblThoiGianDangNhap.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblThoiGianDangNhap.setBounds(931, 35, 126, 22);
		panel.add(lblThoiGianDangNhap);
		
		long millis= System.currentTimeMillis();
		Date date=new Date(millis);
		SimpleDateFormat fm=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d= fm.format(date);
		lblThoiGianDangNhap.setText(d);
		lblTenDangNHap.setText(main.TenNV);
		
		JButton button = new JButton("-");
		button.setBackground(Color.WHITE);
		
		button.setBounds(1096, 11, 45, 15);
		panel.add(button);
		
///////////////////---Panel quan ly---- ////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JPanel panelQuanLy = new JPanel();
		panelQuanLy.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panelQuanLy.setBackground(new Color(255, 255, 255));
		panelQuanLy.setBounds(20, 79, 261, 423);
		contentPane.add(panelQuanLy);
		panelQuanLy.setLayout(null);
		panelQuanLy.setVisible(false);
		
		JLabel lblQunL = new JLabel("Quản lý");
		lblQunL.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQunL.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunL.setBounds(87, 11, 93, 25);
		panelQuanLy.add(lblQunL);
		
		JButton btnQuanLyVMB = new JButton("Vé máy bay");
		btnQuanLyVMB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VeMayBayFRM v=new  VeMayBayFRM();
				v.setVisible(true);
			}
		});
		btnQuanLyVMB.setForeground(new Color(255, 255, 255));
		btnQuanLyVMB.setBackground(new Color(0, 0, 0));
		btnQuanLyVMB.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuanLyVMB.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyVMB.setBounds(10, 47, 241, 39);
		btnQuanLyVMB.setBorder(new MatteBorder(0,5,0,0,Color.red));
		panelQuanLy.add(btnQuanLyVMB);
		
		JButton btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KhachHangFRM kh=new KhachHangFRM();
				kh.setVisible(true);
			}
		});
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setForeground(Color.WHITE);
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnKhachHang.setBorder(new MatteBorder(0,5,0,0,Color.red));
		btnKhachHang.setBackground(Color.BLACK);
		btnKhachHang.setBounds(10, 87, 241, 39);
		panelQuanLy.add(btnKhachHang);
		
		JButton btnChuyenBay = new JButton("Chuyến bay");
		btnChuyenBay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChuyenBayFRM cb=new ChuyenBayFRM();
				cb.setVisible(true);
			}
		});
		btnChuyenBay.setHorizontalAlignment(SwingConstants.LEFT);
		btnChuyenBay.setForeground(Color.WHITE);
		btnChuyenBay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChuyenBay.setBorder(new MatteBorder(0,5,0,0,Color.red));
		btnChuyenBay.setBackground(Color.BLACK);
		btnChuyenBay.setBounds(10, 127, 241, 39);
		panelQuanLy.add(btnChuyenBay);
		
		JButton btnQuanLyChangBay = new JButton("Chặng bay");
		btnQuanLyChangBay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangFRM c=new ChangFRM();
				c.setVisible(true);
			}
		});
		btnQuanLyChangBay.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyChangBay.setForeground(Color.WHITE);
		btnQuanLyChangBay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuanLyChangBay.setBorder(new MatteBorder(0,5,0,0,Color.red));
		btnQuanLyChangBay.setBackground(Color.BLACK);
		btnQuanLyChangBay.setBounds(10, 167, 241, 39);
		panelQuanLy.add(btnQuanLyChangBay);
		
		JButton btnQuanLyHD = new JButton("Hóa đơn");
		
		btnQuanLyHD.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyHD.setForeground(Color.WHITE);
		btnQuanLyHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuanLyHD.setBorder(new MatteBorder(0,5,0,0,Color.red));
		btnQuanLyHD.setBackground(Color.BLACK);
		btnQuanLyHD.setBounds(10, 207, 241, 39);
		panelQuanLy.add(btnQuanLyHD);
		
		JButton btnQuanLyGhe = new JButton("Quản lý ghê");
		btnQuanLyGhe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GheFRM g=new GheFRM();
				g.setVisible(true);
			}
		});
		btnQuanLyGhe.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyGhe.setForeground(Color.WHITE);
		btnQuanLyGhe.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuanLyGhe.setBorder(new MatteBorder(0,5,0,0,Color.red));
		btnQuanLyGhe.setBackground(Color.BLACK);
		btnQuanLyGhe.setBounds(10, 248, 241, 39);
		panelQuanLy.add(btnQuanLyGhe);
		
		JButton btnQuanLyHangVe = new JButton("Hạng vé");
		btnQuanLyHangVe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HangVeFRM hv=new HangVeFRM();
				hv.setVisible(true);
			}
		});
		btnQuanLyHangVe.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyHangVe.setForeground(Color.WHITE);
		btnQuanLyHangVe.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuanLyHangVe.setBorder(new MatteBorder(0,5,0,0,Color.red));
		btnQuanLyHangVe.setBackground(Color.BLACK);
		btnQuanLyHangVe.setBounds(10, 288, 241, 39);
		panelQuanLy.add(btnQuanLyHangVe);
		
		JButton btnQuanLyMayBay = new JButton("Máy bay");
		btnQuanLyMayBay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MayBayFRM mb=new MayBayFRM();
				mb.setVisible(true);
			}
		});
		btnQuanLyMayBay.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyMayBay.setForeground(Color.WHITE);
		btnQuanLyMayBay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuanLyMayBay.setBorder(new MatteBorder(0,5,0,0,Color.red));
		btnQuanLyMayBay.setBackground(Color.BLACK);
		btnQuanLyMayBay.setBounds(10, 328, 241, 39);
		panelQuanLy.add(btnQuanLyMayBay);
		
		JButton btnQuanLySanBay = new JButton("Sân bay");
		btnQuanLySanBay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SanBayFRM sb=new SanBayFRM();
				sb.setVisible(true);
			}
		});
		btnQuanLySanBay.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLySanBay.setForeground(Color.WHITE);
		btnQuanLySanBay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuanLySanBay.setBorder(new MatteBorder(0,5,0,0,Color.red));
		btnQuanLySanBay.setBackground(Color.BLACK);
		btnQuanLySanBay.setBounds(10, 368, 241, 39);
		panelQuanLy.add(btnQuanLySanBay);
		
///////////////----Panel thong  ke-------/////////////////////////////////////////////////////////////////////////////////
				JPanel panelThongKe = new JPanel();
				panelThongKe.setBounds(20, 79, 261, 174);
				contentPane.add(panelThongKe);
				panelThongKe.setLayout(null);
				panelThongKe.setBackground(Color.WHITE);
				panelThongKe.setVisible(false);
				
						JLabel lblThongKe = new JLabel("Thống kê");
						lblThongKe.setHorizontalAlignment(SwingConstants.CENTER);
						lblThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
						lblThongKe.setBounds(66, 11, 124, 25);
						panelThongKe.add(lblThongKe);
						
						JButton btnThongKeCB = new JButton("Chuyến bay");
						btnThongKeCB.setHorizontalAlignment(SwingConstants.LEFT);
						btnThongKeCB.setForeground(Color.WHITE);
						btnThongKeCB.setFont(new Font("Tahoma", Font.BOLD, 12));
						btnThongKeCB.setBorder(new MatteBorder(0,5,0,0,Color.red));
						btnThongKeCB.setBackground(Color.BLACK);
						btnThongKeCB.setBounds(10, 47, 241, 39);
						panelThongKe.add(btnThongKeCB);
						
						JButton btnThongKeChangBay = new JButton("Chặng bay");
						btnThongKeChangBay.setHorizontalAlignment(SwingConstants.LEFT);
						btnThongKeChangBay.setForeground(Color.WHITE);
						btnThongKeChangBay.setFont(new Font("Tahoma", Font.BOLD, 12));
						btnThongKeChangBay.setBorder(new MatteBorder(0,5,0,0,Color.red));
						btnThongKeChangBay.setBackground(Color.BLACK);
						btnThongKeChangBay.setBounds(10, 87, 241, 39);
						panelThongKe.add(btnThongKeChangBay);
						
						JButton btnThongKeHD = new JButton("Hóa đơn");
						btnThongKeHD.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ThongKeHDFRM tkhd=new ThongKeHDFRM();
								tkhd.setVisible(true);
							}
						});
						btnThongKeHD.setHorizontalAlignment(SwingConstants.LEFT);
						btnThongKeHD.setForeground(Color.WHITE);
						btnThongKeHD.setFont(new Font("Tahoma", Font.BOLD, 12));
						btnThongKeHD.setBorder(new MatteBorder(0,5,0,0,Color.red));
						btnThongKeHD.setBackground(Color.BLACK);
						btnThongKeHD.setBounds(10, 127, 241, 39);
						panelThongKe.add(btnThongKeHD);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		/*panelContent = new JPanel();
		panelContent.setBounds(291, 79, 930, 581);
		contentPane.add(panelContent);
		panelContent.setLayout(null);
		panelContent.setBackground(new Color(0,0,0,0));*/
		
////////////////////////---Panel tim kiem--- ////////////////////////////////////////////////////////////////////////////////////////////
						
				JPanel panelTimKiem = new JPanel();
				panelTimKiem.setBackground(new Color(255, 255, 255));
				panelTimKiem.setBounds(20, 79, 261, 259);
				contentPane.add(panelTimKiem);
				panelTimKiem.setLayout(null);
				panelTimKiem.setVisible(false);
				
				JLabel lblTmKim = new JLabel("Tìm kiếm");
				lblTmKim.setHorizontalAlignment(SwingConstants.CENTER);
				lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblTmKim.setBounds(62, 11, 129, 25);
				panelTimKiem.add(lblTmKim);
				
				JButton btnTimKiemVMB = new JButton("Vé máy bay");
				btnTimKiemVMB.setHorizontalAlignment(SwingConstants.LEFT);
				btnTimKiemVMB.setForeground(Color.WHITE);
				btnTimKiemVMB.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnTimKiemVMB.setBorder(new MatteBorder(0,5,0,0,Color.red));
				btnTimKiemVMB.setBackground(Color.BLACK);
				btnTimKiemVMB.setBounds(10, 47, 241, 39);
				panelTimKiem.add(btnTimKiemVMB);
				
				JButton btnTimKiemKH = new JButton("Khách hàng");
				btnTimKiemKH.setHorizontalAlignment(SwingConstants.LEFT);
				btnTimKiemKH.setForeground(Color.WHITE);
				btnTimKiemKH.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnTimKiemKH.setBorder(new MatteBorder(0,5,0,0,Color.red));
				btnTimKiemKH.setBackground(Color.BLACK);
				btnTimKiemKH.setBounds(10, 87, 241, 39);
				panelTimKiem.add(btnTimKiemKH);
				
				JButton btnTimKiemCB = new JButton("Chuyến bay");
				btnTimKiemCB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						TimKiemCBFRM tkcb=new TimKiemCBFRM();
						tkcb.setVisible(true);
					}
				});
				btnTimKiemCB.setHorizontalAlignment(SwingConstants.LEFT);
				btnTimKiemCB.setForeground(Color.WHITE);
				btnTimKiemCB.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnTimKiemCB.setBorder(new MatteBorder(0,5,0,0,Color.red));
				btnTimKiemCB.setBackground(Color.BLACK);
				btnTimKiemCB.setBounds(10, 127, 241, 39);
				panelTimKiem.add(btnTimKiemCB);
				
				JButton btnTimKiemChangBay = new JButton("Chặng bay");
				btnTimKiemChangBay.setHorizontalAlignment(SwingConstants.LEFT);
				btnTimKiemChangBay.setForeground(Color.WHITE);
				btnTimKiemChangBay.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnTimKiemChangBay.setBorder(new MatteBorder(0,5,0,0,Color.red));
				btnTimKiemChangBay.setBackground(Color.BLACK);
				btnTimKiemChangBay.setBounds(10, 167, 241, 39);
				panelTimKiem.add(btnTimKiemChangBay);
				
				JButton btnTimKiemHD = new JButton("Hóa đơn");
				btnTimKiemHD.setHorizontalAlignment(SwingConstants.LEFT);
				btnTimKiemHD.setForeground(Color.WHITE);
				btnTimKiemHD.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnTimKiemHD.setBorder(new MatteBorder(0,5,0,0,Color.red));
				btnTimKiemHD.setBackground(Color.BLACK);
				btnTimKiemHD.setBounds(10, 207, 241, 39);
				panelTimKiem.add(btnTimKiemHD);

//////////////////////////---Panel Ban Ve--------//////////////////////////////////////////////////////////////////////////////////
				
		JPanel panelBanVe = new JPanel();
		panelBanVe.setBackground(new Color(255, 255, 255));
		panelBanVe.setBounds(20, 79, 261, 106);
		contentPane.add(panelBanVe);
		panelBanVe.setLayout(null);
		panelBanVe.setVisible(false);
		
		JLabel lblBnV = new JLabel("Bán vé");
		lblBnV.setHorizontalAlignment(SwingConstants.CENTER);
		lblBnV.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBnV.setBounds(87, 11, 93, 25);
		panelBanVe.add(lblBnV);
		
		JButton btnBanVeVMB = new JButton("Bán vé máy bay");
		btnBanVeVMB.setHorizontalAlignment(SwingConstants.LEFT);
		btnBanVeVMB.setForeground(Color.WHITE);
		btnBanVeVMB.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBanVeVMB.setBorder(new MatteBorder(0,5,0,0,Color.red));
		btnBanVeVMB.setBackground(Color.BLACK);
		btnBanVeVMB.setBounds(10, 47, 241, 39);
		panelBanVe.add(btnBanVeVMB);
		
		JLabel lblLogo = new JLabel("QUẢN LÝ BÁN VÉ MÁY BAY");
		lblLogo.setForeground(Color.RED);
		lblLogo.setBounds(191, 101, 800, 92);
		contentPane.add(lblLogo);
		lblLogo.setFont(new Font("Times New Roman", Font.BOLD, 46));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBackground(new Color(0,0,0,0));
		
		panelContent = new JPanel();
		panelContent.setBackground(new Color(255, 255, 255));
		panelContent.setBounds(350, 79,700, 592);
		contentPane.add(panelContent);
		panelContent.setLayout(null);
		
		JPanel panelQuyTrinhBanVe = new JPanel();
		panelQuyTrinhBanVe.setBackground(Color.WHITE);
		panelQuyTrinhBanVe.setBounds(0, 0, 700, 315);
		panelContent.add(panelQuyTrinhBanVe);
		panelQuyTrinhBanVe.setLayout(null);
		panelContent.setVisible(false);
		
		JButton btnDocCSDL = new JButton("Đọc CSDL");
		
		btnDocCSDL.setBackground(Color.WHITE);
		btnDocCSDL.setBounds(1049, 79, 98, 23);
		contentPane.add(btnDocCSDL);
		
		
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setIcon(new ImageIcon("images/15-1.jpg"));
		lblBackGround.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackGround.setBackground(Color.WHITE);
		lblBackGround.setBounds(-47, 0, 1252, 721);
		
		contentPane.add(lblBackGround);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		btnQuanLyHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HoaDonFRM hd=new HoaDonFRM();
				hd.setVisible(true);
				/*JPanel p=hd.HoaDonFRM();
				newPanelContent(350,79,666,620,p);
				p.setBounds(0,0,666,620);
				//p.setBackground(new Color(0,0,0,0));*/
			}
		});
		btnTimKiemHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TimKiemHD tk=new TimKiemHD();
				tk.setVisible(true);
				/*JPanel p=tk.TimKiemHD();
				newPanelContent(350,79, 648, 565,p);
				p.setBounds(0, 0, 648, 565);*/
				
			}
		});
		btnTrangChu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblLogo.setVisible(true);
				btnDocCSDL.setVisible(true);
				panelTimKiem.setVisible(false);
				panelThongKe.setVisible(false);
				panelQuanLy.setVisible(false);
				panelBanVe.setVisible(false);
				panelContent.setVisible(false);
			}
		});
		btnBanVe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblLogo.setVisible(false);
				btnDocCSDL.setVisible(false);
				panelBanVe.setVisible(true);
				panelTimKiem.setVisible(false);
				panelThongKe.setVisible(false);
				panelQuanLy.setVisible(false);
				panelContent.setVisible(false);
				
			}
		});
		btnNavBarTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblLogo.setVisible(false);
				btnDocCSDL.setVisible(false);
				panelTimKiem.setVisible(true);
				panelThongKe.setVisible(false);
				panelQuanLy.setVisible(false);
				panelBanVe.setVisible(false);
				panelContent.setVisible(false);
			}
		});
		btnThongKe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblLogo.setVisible(false);
				btnDocCSDL.setVisible(false);
				panelThongKe.setVisible(true);
				panelQuanLy.setVisible(false);
				panelTimKiem.setVisible(false);
				panelBanVe.setVisible(false);
				panelContent.setVisible(false);
			}
		});
		btnQuanLy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblLogo.setVisible(false);
				btnDocCSDL.setVisible(false);
				panelQuanLy.setVisible(true);
				panelThongKe.setVisible(false);
				panelTimKiem.setVisible(false);
				panelBanVe.setVisible(false);
				panelContent.setVisible(false);
			}
		});
		
		btnNavbarThoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				
			}
		});
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setExtendedState(ICONIFIED);
			}
		});
		btnDocCSDL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangBUS cbus=new ChangBUS();
				cbus.docDSChang();
				ChuyenBayBUS cbbus=new ChuyenBayBUS();
				cbbus.docDSChuyenBay();
				ChiTietHDBUS ct=new ChiTietHDBUS();
				ct.docDSCTHD();
				GheBUS gbus=new GheBUS();
				gbus.docDSGhe();
				HangVeBUS hvbus=new HangVeBUS();
				hvbus.docDSHangVe();
				HoaDonBUS hdbus=new HoaDonBUS();
				hdbus.docDSHD();
				KhachHangBUS khbus=new KhachHangBUS();
				khbus.docDSKH();
				MayBayBUS mbbus=new MayBayBUS();
				mbbus.docDSMayBay();
				SanBayBUS sbbus=new SanBayBUS();
				sbbus.docDSSanBay();
				VeMayBayBUS v=new VeMayBayBUS();
				v.docDSVMB();
				JOptionPane.showMessageDialog(null,"Đã đọc danh sách từ CSDL.");
			}
		});

	}
	public void newPanelContent(int x,int y,int width,int height,JPanel p)
	{
		panelContent.removeAll();
		panelContent.setBackground(new Color(0,0,0,0));
		panelContent.setBounds(x,y,width,height);
		panelContent.add(p);
		panelContent.setVisible(true);
	}
	
}
