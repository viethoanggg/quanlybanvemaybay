package FRM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
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
import java.awt.event.ActionEvent;

public class TrangChuFRM extends JFrame {

	private JPanel contentPane;
	private JPanel panelContent;
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
		setAutoRequestFocus(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1237, 710);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, 0, 1261, 68);
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
		btnNavBarTimKiem.setBounds(292, 11, 126, 46);
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
		btnThongKe.setBounds(428, 11, 126, 46);
		panel.add(btnThongKe);
		
		JButton btnQuanLy = new JButton("Quản lý");
		
		btnQuanLy.setIcon(new ImageIcon("images/iconQuanLy.png"));
		btnQuanLy.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLy.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnQuanLy.setBackground(Color.WHITE);
		btnQuanLy.setBounds(564, 11, 126, 46);
		panel.add(btnQuanLy);
		
		JButton btnNavbarThoat = new JButton("Thoát");
		btnNavbarThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNavbarThoat.setIcon(new ImageIcon("images/iconExit.png"));
		btnNavbarThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnNavbarThoat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNavbarThoat.setBackground(Color.WHITE);
		btnNavbarThoat.setBounds(701, 11, 126, 46);
		panel.add(btnNavbarThoat);
		
		JLabel lblLeVietHoang = new JLabel("Le viet hoang");
		lblLeVietHoang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLeVietHoang.setForeground(Color.WHITE);
		lblLeVietHoang.setBounds(989, 11, 126, 22);
		panel.add(lblLeVietHoang);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JPanel panelQuanLy = new JPanel();
		panelQuanLy.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panelQuanLy.setBackground(new Color(255, 255, 255));
		panelQuanLy.setBounds(20, 79, 261, 259);
		contentPane.add(panelQuanLy);
		panelQuanLy.setLayout(null);
		panelQuanLy.setVisible(false);
		
		JLabel lblQunL = new JLabel("Quản lý");
		lblQunL.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQunL.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunL.setBounds(87, 11, 93, 25);
		panelQuanLy.add(lblQunL);
		
		JButton btnQuanLyVMB = new JButton("Vé máy bay");
		btnQuanLyVMB.setForeground(new Color(255, 255, 255));
		btnQuanLyVMB.setBackground(new Color(0, 0, 0));
		btnQuanLyVMB.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuanLyVMB.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyVMB.setBounds(10, 47, 241, 39);
		btnQuanLyVMB.setBorder(new MatteBorder(0,5,0,0,Color.red));
		panelQuanLy.add(btnQuanLyVMB);
		
		JButton btnKhchHng = new JButton("Khách hàng");
		btnKhchHng.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhchHng.setForeground(Color.WHITE);
		btnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnKhchHng.setBorder(new MatteBorder(0,5,0,0,Color.red));
		btnKhchHng.setBackground(Color.BLACK);
		btnKhchHng.setBounds(10, 87, 241, 39);
		panelQuanLy.add(btnKhchHng);
		
		JButton btnChuynBay = new JButton("Chuyến bay");
		btnChuynBay.setHorizontalAlignment(SwingConstants.LEFT);
		btnChuynBay.setForeground(Color.WHITE);
		btnChuynBay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChuynBay.setBorder(new MatteBorder(0,5,0,0,Color.red));
		btnChuynBay.setBackground(Color.BLACK);
		btnChuynBay.setBounds(10, 127, 241, 39);
		panelQuanLy.add(btnChuynBay);
		
		JButton btnQuanLyChangBay = new JButton("Chặng bay");
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
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				JPanel panelThongKe = new JPanel();
				panelThongKe.setBounds(20, 79, 261, 259);
				contentPane.add(panelThongKe);
				panelThongKe.setLayout(null);
				panelThongKe.setBackground(Color.WHITE);
				panelThongKe.setVisible(false);
				
						JLabel lblThongKe = new JLabel("Thống kê");
						lblThongKe.setHorizontalAlignment(SwingConstants.CENTER);
						lblThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
						lblThongKe.setBounds(66, 11, 124, 25);
						panelThongKe.add(lblThongKe);
						
						JButton btnThongKeVMB = new JButton("Vé máy bay");
						btnThongKeVMB.setHorizontalAlignment(SwingConstants.LEFT);
						btnThongKeVMB.setForeground(Color.WHITE);
						btnThongKeVMB.setFont(new Font("Tahoma", Font.BOLD, 12));
						btnThongKeVMB.setBorder(new MatteBorder(0,5,0,0,Color.red));
						btnThongKeVMB.setBackground(Color.BLACK);
						btnThongKeVMB.setBounds(10, 47, 241, 39);
						panelThongKe.add(btnThongKeVMB);
						
						JButton btnThongKeKH = new JButton("Khách hàng");
						btnThongKeKH.setHorizontalAlignment(SwingConstants.LEFT);
						btnThongKeKH.setForeground(Color.WHITE);
						btnThongKeKH.setFont(new Font("Tahoma", Font.BOLD, 12));
						btnThongKeKH.setBorder(new MatteBorder(0,5,0,0,Color.red));
						btnThongKeKH.setBackground(Color.BLACK);
						btnThongKeKH.setBounds(10, 87, 241, 39);
						panelThongKe.add(btnThongKeKH);
						
						JButton btnThongKeCB = new JButton("Chuyến bay");
						btnThongKeCB.setHorizontalAlignment(SwingConstants.LEFT);
						btnThongKeCB.setForeground(Color.WHITE);
						btnThongKeCB.setFont(new Font("Tahoma", Font.BOLD, 12));
						btnThongKeCB.setBorder(new MatteBorder(0,5,0,0,Color.red));
						btnThongKeCB.setBackground(Color.BLACK);
						btnThongKeCB.setBounds(10, 127, 241, 39);
						panelThongKe.add(btnThongKeCB);
						
						JButton btnThongKeChangBay = new JButton("Chặng bay");
						btnThongKeChangBay.setHorizontalAlignment(SwingConstants.LEFT);
						btnThongKeChangBay.setForeground(Color.WHITE);
						btnThongKeChangBay.setFont(new Font("Tahoma", Font.BOLD, 12));
						btnThongKeChangBay.setBorder(new MatteBorder(0,5,0,0,Color.red));
						btnThongKeChangBay.setBackground(Color.BLACK);
						btnThongKeChangBay.setBounds(10, 167, 241, 39);
						panelThongKe.add(btnThongKeChangBay);
						
						JButton btnThongKeHD = new JButton("Hóa đơn");
						btnThongKeHD.setHorizontalAlignment(SwingConstants.LEFT);
						btnThongKeHD.setForeground(Color.WHITE);
						btnThongKeHD.setFont(new Font("Tahoma", Font.BOLD, 12));
						btnThongKeHD.setBorder(new MatteBorder(0,5,0,0,Color.red));
						btnThongKeHD.setBackground(Color.BLACK);
						btnThongKeHD.setBounds(10, 207, 241, 39);
						panelThongKe.add(btnThongKeHD);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		/*panelContent = new JPanel();
		panelContent.setBounds(291, 79, 930, 581);
		contentPane.add(panelContent);
		panelContent.setLayout(null);
		panelContent.setBackground(new Color(0,0,0,0));*/
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		btnQuanLyHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HoaDonFRM2 hd=new HoaDonFRM2();
				JPanel p=hd.HoaDonFRM2m();
				newPanelContent(291, 79, 622, 534,p);
				p.setBounds(0,0, 622, 534);
				
			}
		});
		
		btnTrangChu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelTimKiem.setVisible(false);
				panelThongKe.setVisible(false);
				panelQuanLy.setVisible(false);
				panelBanVe.setVisible(false);
			}
		});
		btnBanVe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelBanVe.setVisible(true);
				panelTimKiem.setVisible(false);
				panelThongKe.setVisible(false);
				panelQuanLy.setVisible(false);
				
			}
		});
		btnNavBarTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelTimKiem.setVisible(true);
				panelThongKe.setVisible(false);
				panelQuanLy.setVisible(false);
				panelBanVe.setVisible(false);
			}
		});
		btnThongKe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelThongKe.setVisible(true);
				panelQuanLy.setVisible(false);
				panelTimKiem.setVisible(false);
				panelBanVe.setVisible(false);
				
			}
		});
		btnQuanLy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelQuanLy.setVisible(true);
				panelThongKe.setVisible(false);
				panelTimKiem.setVisible(false);
				panelBanVe.setVisible(false);
			}
		});
		
		btnNavbarThoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				
			}
		});
		
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setIcon(new ImageIcon("images/15-1.jpg"));
		lblBackGround.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackGround.setBackground(Color.WHITE);
		lblBackGround.setBounds(0, 0, 1261, 721);
		contentPane.add(lblBackGround);

	}
	public void newPanelContent(int x,int y,int width,int height,JPanel p)
	{
		panelContent = new JPanel();
		contentPane.add(panelContent);
		panelContent.setBounds(x,y,width,height);
		panelContent.setLayout(null);
		panelContent.setBackground(new Color(0,0,0,0));
		panelContent.add(p);
	}
}
