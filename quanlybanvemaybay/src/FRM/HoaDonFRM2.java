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

public class HoaDonFRM2 extends JFrame {

	private JPanel HoaDon2;
	private JTextField txtMaHD;
	private JTextField txtMaKH;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	public HoaDonFRM2() {}
	public JPanel HoaDonFRM2m() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		//setBounds(100, 100, 622, 534);
		//setTitle("Thêm hóa đơn");
		HoaDon2 = new JPanel();
		//HoaDon2.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(HoaDon2);
		HoaDon2.setLayout(null);
		
		JPanel panelThemHD = new JPanel();
		panelThemHD.setBounds(0, 0, 606, 495);
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
		lblTenNV.setText(main.TenNV);
		lblTenNV.setBounds(180, 59, 279, 26);
		panelThemHD.add(lblTenNV);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin ng\u01B0\u1EDDi mua", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(30, 207, 521, 186);
		panelThemHD.add(panel);
		panel.setLayout(null);
		
		JRadioButton rbnKHC = new JRadioButton("KH cũ",true);
		rbnKHC.setBounds(18, 29, 71, 23);
		panel.add(rbnKHC);
		
		JRadioButton rbnKHM = new JRadioButton("KH mới");
		rbnKHM.setBounds(130, 29, 71, 23);
		panel.add(rbnKHM);
		
		ButtonGroup g=new ButtonGroup(); 
		g.add(rbnKHC);
		g.add(rbnKHM);
		
		JPanel panelKHC = new JPanel();
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
		
		JComboBox cbbMaKH = new JComboBox();
		cbbMaKH.setBounds(266, 12, 126, 24);
		panelKHC.add(cbbMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(101, 11, 155, 27);
		panelKHC.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JButton btnThemHD = new JButton(" Thêm HĐ");
		btnThemHD.setBounds(86, 404, 101, 33);
		panelThemHD.add(btnThemHD);
		
		JButton btnDatLai = new JButton("Đặt lại");
		btnDatLai.setBounds(240, 404, 89, 33);
		panelThemHD.add(btnDatLai);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(380, 404, 89, 33);
		panelThemHD.add(btnThoat);
		
	//-----------------------------------------------------------------------//	
		long millis=System.currentTimeMillis();  
		Date date=new Date(millis);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
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

		btnThemCTHD.setBounds(461, 458, 135, 26);
		btnThemCTHD.setEnabled(false);
		panelThemHD.add(btnThemCTHD);
		
		
		btnThemHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String mahd=txtMaHD.getText();
				String makh=txtMaKH.getText();
				int flag=0;
				for(HoaDonDTO hd : HoaDonBUS.dshd)
				{
					if(mahd.equals(hd.getMaHD()))
					{
						JOptionPane.showMessageDialog(null,"Mã HĐ bị trùng.");
						flag=1;
					}
				}
				
				/*for(KhacHangDTO kh : KhachHangBUS.dskh)
				{
					if(makh.equals(kh.getMaHD()))
					{
						JOptionPane.showMessageDialog(null,"Mã KH Không hợp lệ.");
						flag=1;
					}
				}*/
				if(flag==0)
				{
					JOptionPane.showMessageDialog(null,"Đã thêm hóa đơn.");
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
				System.exit(1);
			}
		});
		btnDatLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtMaHD.setText("");
				txtMaKH.setText("");
				
			}
		});
		return HoaDon2;
	}
}
