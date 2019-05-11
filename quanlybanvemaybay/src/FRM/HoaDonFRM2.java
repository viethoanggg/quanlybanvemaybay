package FRM;
import BUS.*;
import DAO.*;
import DTO.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import BUS.HoaDonBUS;
import DTO.HoaDonDTO;

import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HoaDonFRM2 extends JFrame {

	private JPanel HoaDon2;
	private JTextField txtMaHD;
	private JTextField txtMaKH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDonFRM2 frame = new HoaDonFRM2();
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
	public HoaDonFRM2() {
		HoaDonBUS hdbus=new HoaDonBUS();
		hdbus.docDSHD();
		KhachHangBUS khbus=new KhachHangBUS();
		khbus.docDSKH();
		
		
		//setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 606, 534);
		setLocationRelativeTo(null);
		setTitle("Thêm hóa đơn");
		HoaDon2 = new JPanel();
		HoaDon2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(HoaDon2);
		HoaDon2.setLayout(null);
		
		JPanel panelThemHD = new JPanel();
		panelThemHD.setBackground(Color.WHITE);
		panelThemHD.setBounds(0, 0, 604, 534);
		HoaDon2.add(panelThemHD);
		panelThemHD.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ngày đặt vé");
		lblNewLabel.setBounds(30, 22, 89, 26);
		panelThemHD.add(lblNewLabel);
		
		JLabel lblNgayDatVe = new JLabel("New label");
		lblNgayDatVe.setBounds(180, 22, 279, 26);
		panelThemHD.add(lblNgayDatVe);
		
		JLabel lblMH = new JLabel("Mã HĐ");
		lblMH.setBounds(30, 96, 89, 26);
		panelThemHD.add(lblMH);
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(180, 96, 279, 26);
		panelThemHD.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		JLabel lblTnNv = new JLabel("Tên NV");
		lblTnNv.setBounds(30, 59, 89, 26);
		panelThemHD.add(lblTnNv);
		
		JLabel lblTenNV = new JLabel("");
		lblTenNV.setBounds(180, 59, 279, 26);
		panelThemHD.add(lblTenNV);
		lblTenNV.setText(main.TenNV);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin ng\u01B0\u1EDDi mua", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(30, 207, 521, 186);
		panelThemHD.add(panel);
		panel.setLayout(null);
		
		JRadioButton rbnKHC = new JRadioButton("KH cũ",true);
		rbnKHC.setBackground(Color.WHITE);
		rbnKHC.setBounds(18, 29, 71, 23);
		panel.add(rbnKHC);
		
		ButtonGroup g=new ButtonGroup(); 
		g.add(rbnKHC);
		
		JPanel panelKHC = new JPanel();
		panelKHC.setBackground(Color.WHITE);
		panelKHC.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelKHC.setBounds(18, 73, 493, 96);
		panel.add(panelKHC);
		panelKHC.setLayout(null);
		
		JLabel lblTnKh = new JLabel("Tên KH");
		lblTnKh.setBounds(10, 49, 81, 27);
		panelKHC.add(lblTnKh);
		
		JLabel lblTenKH = new JLabel("");
		lblTenKH.setBounds(101, 49, 336, 27);
		panelKHC.add(lblTenKH);
		
		JLabel lblMKh = new JLabel("Mã KH");
		lblMKh.setBounds(10, 11, 81, 27);
		panelKHC.add(lblMKh);
		
		txtMaKH = new JTextField();
		
		txtMaKH.setBounds(151, 11, 126, 27);
		panelKHC.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblKhm = new JLabel("KHM_");
		lblKhm.setBounds(101, 11, 51, 27);
		panelKHC.add(lblKhm);
		
		JLabel lblnhpS = new JLabel("(Nhập số)");
		lblnhpS.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblnhpS.setBounds(287, 11, 90, 27);
		panelKHC.add(lblnhpS);
		
		JButton btnThemKH = new JButton("Thêm KH mới");
		btnThemKH.setBackground(new Color(245, 245, 220));
		
		btnThemKH.setBounds(378, 29, 133, 23);
		panel.add(btnThemKH);
		
		JButton btnThemHD = new JButton(" Thêm HĐ");
		btnThemHD.setBackground(new Color(245, 245, 220));
		btnThemHD.setBounds(86, 404, 101, 33);
		panelThemHD.add(btnThemHD);
		
		JButton btnDatLai = new JButton("Đặt lại");
		btnDatLai.setBackground(new Color(245, 245, 220));
		btnDatLai.setBounds(240, 404, 89, 33);
		panelThemHD.add(btnDatLai);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(245, 245, 220));
		btnThoat.setBounds(380, 404, 89, 33);
		panelThemHD.add(btnThoat);
		
	//-----------------------------------------------------------------------//	
		long millis=System.currentTimeMillis();  
		Date date=new Date(millis);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d=formatter.format(date);
		lblNgayDatVe.setText(d); 
	//----------------------------------------------------------------------//	
		JLabel lblSLngV = new JLabel("Số lượng vé");
		lblSLngV.setBounds(30, 133, 89, 26);
		panelThemHD.add(lblSLngV);
		
		JLabel lblSoLuongVe = new JLabel("0");
		lblSoLuongVe.setBounds(180, 133, 279, 26);
		panelThemHD.add(lblSoLuongVe);
		
		JLabel lblThnhTin = new JLabel("Thành tiền");
		lblThnhTin.setBounds(30, 170, 89, 26);
		panelThemHD.add(lblThnhTin);
		
		JLabel lblThanhTien = new JLabel("0");
		lblThanhTien.setBounds(180, 170, 279, 26);
		panelThemHD.add(lblThanhTien);
		
		JButton btnThemCTHD = new JButton("Thêm chi tiết HĐ");
		btnThemCTHD.setBackground(new Color(245, 245, 220));

		btnThemCTHD.setBounds(461, 458, 135, 26);
		btnThemCTHD.setEnabled(false);
		panelThemHD.add(btnThemCTHD);
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		btnThemHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String mahd=txtMaHD.getText();
				String makh="KHM_"+txtMaKH.getText();
				int flag=0;
				
				
				for(HoaDonDTO hd : HoaDonBUS.dshd)
				{
					if(mahd.equals(hd.getMaHD()))
					{
						JOptionPane.showMessageDialog(null,"Mã HĐ bị trùng.");
						flag=1;
					}
				}
				
			
				
				for(KhachHangDTO kh : KhachHangBUS.dskh)	
				{
					flag=2;
					if(makh.equals(kh.MaKH))
					{
						flag=0;
						break;
					}
				}
				if(flag==2) JOptionPane.showMessageDialog(null,"Mã KH không hợp lệ.");
				if(mahd.equals("")) flag=1;
				if(makh.equals("")) flag=1;
				if(flag==0)
				{
					JOptionPane.showMessageDialog(null,"Đã thêm hóa đơn.Hãy thêm chi tiết hóa đơn ở nút bên dưới.");
					btnThemCTHD.setEnabled(true);
					HoaDonDTO hd=new HoaDonDTO();
					hd.setMaHD(txtMaHD.getText());
					hd.setMaKH(txtMaKH.getText());
					hd.setMaNV(main.MaNV);
					hd.setNgayDatVe(lblNgayDatVe.getText());
					hd.setSoLuongVe(Integer.valueOf(lblSoLuongVe.getText()));
					hd.setThanhTien(Integer.valueOf(lblThanhTien.getText()));
					
					HoaDonBUS bus=new HoaDonBUS();
					bus.them(hd);
				}
				
			}
		});
		
		txtMaKH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				String makh="KHM_"+txtMaKH.getText();
				for(KhachHangDTO kh : KhachHangBUS.dskh)	
				{
					if(makh.equals(kh.MaKH))
					{
						lblTenKH.setText(kh.getTenKH());
						break;
					}
					else
					{
						lblTenKH.setText("");
					}	
				}
			}
		});
		
		btnThemCTHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ChiTietHDFRM ct=new ChiTietHDFRM();
				ct.them(txtMaHD.getText(),Integer.valueOf(lblSoLuongVe.getText()));
			}
		});
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		btnDatLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtMaHD.setText("");
				txtMaKH.setText("");
				
			}
		});
		btnThemKH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ThemKH themkh=new ThemKH();
				themkh.setVisible(true);
			}
		});
	}
}
