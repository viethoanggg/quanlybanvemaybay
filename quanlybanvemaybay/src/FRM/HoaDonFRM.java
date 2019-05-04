package FRM;
import BUS.*;
import DAO.*;
import DTO.*;
import DAO.*;
import DTO.*;
import BUS.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.ChiTietHDBUS;
import BUS.HoaDonBUS;
import DTO.ChiTietHDDTO;
import DTO.HoaDonDTO;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
public class HoaDonFRM extends JFrame {

	private JPanel HoaDon;
	private JTable tblHoaDon = new JTable();
	private DefaultTableModel model=new DefaultTableModel();
	private DefaultTableModel modelcthd=new DefaultTableModel();
	private JTextField txtTimKiemHD;
	private JTextField txtMaKH_HD;
	private JTextField txtMaNV_HD;
	private JTextField txtNgayDatVe_HD;
	private JTextField txtTenKHM;
	private JTextField txtNgayDatVe_CTHD;
	private JTextField txtTenNV;
	private JTextField txtThanhTien_CTHD;
	private JTable tblChiTietHD;
	private JTextField txtMaHD_HD;
	private JTextField txtSoLuongVe;
	private JTextField txtThanhTien_HD;
	private JTextField txtSoLuongVe_CTHD;
	private JTextField txtTKNC_MaKH;
	private JTextField txtTKNC_MaNV;
	private JTextField txtTKNC_NgayDatVeTu;
	private JTextField txtTKNC_NgayDatVeDen;
	private JTextField txtTKNC_GiaTu;
	private JTextField txtTKNC_GiaDen;
	private File file;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDonFRM frame = new HoaDonFRM();
					//frame.setUndecorated(true);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public void setTable() 
	{
		HoaDonBUS bus=new HoaDonBUS();
		if(HoaDonBUS.dshd==null) bus.docDSHD();
		
		newTableHD();
		newDataModel();
	}
	
	/**
	 * Create the frame.
	 */
	public HoaDonFRM() {
		setTable();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1251, 734);
		setLocationRelativeTo(null);
		setTitle("Quản lý hóa đơn.");
		HoaDon = new JPanel();
		HoaDon.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(HoaDon);
		HoaDon.setLayout(null);
		
		JLabel lblHoaDon = new JLabel("H\u00D3A \u0110\u01A0N");
		lblHoaDon.setBounds(10, 84, 69, 27);
		HoaDon.add(lblHoaDon);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 584, 188);
		HoaDon.add(scrollPane);
		
		
		scrollPane.setViewportView(tblHoaDon);
		tblHoaDon.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblTmKim = new JLabel("T\u00ECm Ki\u1EBFm");
		lblTmKim.setBounds(10, 331, 91, 27);
		HoaDon.add(lblTmKim);
		
		txtTimKiemHD = new JTextField();
		txtTimKiemHD.setBounds(111, 331, 240, 27);
		HoaDon.add(txtTimKiemHD);
		txtTimKiemHD.setColumns(10);
		
		JLabel lblMaHD = new JLabel("M\u00E3 H\u0110");
		lblMaHD.setBounds(10, 369, 91, 27);
		HoaDon.add(lblMaHD);
		
		JLabel lblMaKH = new JLabel("M\u00E3 KH");
		lblMaKH.setBounds(10, 406, 91, 27);
		HoaDon.add(lblMaKH);
		
		JLabel lblMaNV = new JLabel("M\u00E3 NV");
		lblMaNV.setBounds(10, 444, 91, 27);
		HoaDon.add(lblMaNV);
		
		JLabel lblNgayDatVe = new JLabel("Ng\u00E0y \u0111\u1EB7t v\u00E9");
		lblNgayDatVe.setBounds(10, 485, 91, 27);
		HoaDon.add(lblNgayDatVe);
		
		JLabel lblSoLuong = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblSoLuong.setBounds(10, 523, 91, 27);
		HoaDon.add(lblSoLuong);
		
		JLabel lblThanhTien = new JLabel("Th\u00E0nh ti\u1EC1n");
		lblThanhTien.setBounds(10, 561, 91, 27);
		HoaDon.add(lblThanhTien);
		
		txtMaKH_HD = new JTextField();
		txtMaKH_HD.setColumns(10);
		txtMaKH_HD.setBounds(111, 409, 240, 27);
		HoaDon.add(txtMaKH_HD);
		
		txtMaNV_HD = new JTextField();
		txtMaNV_HD.setColumns(10);
		txtMaNV_HD.setBounds(111, 447, 240, 27);
		HoaDon.add(txtMaNV_HD);
		
		txtNgayDatVe_HD = new JTextField();
		txtNgayDatVe_HD.setColumns(10);
		txtNgayDatVe_HD.setBounds(111, 485, 240, 27);
		HoaDon.add(txtNgayDatVe_HD);
		
		JComboBox cbbTimKiem_HD = new JComboBox();
		cbbTimKiem_HD.setModel(new DefaultComboBoxModel(new String[] {"Tìm Theo", "Mã HĐ", "Mã KH", "Mã NV"}));
		cbbTimKiem_HD.setBounds(388, 332, 81, 24);
		HoaDon.add(cbbTimKiem_HD);
		
		JButton btnTimKiem_HD = new JButton("T\u00ECm Ki\u1EBFm");
		btnTimKiem_HD.setBounds(494, 329, 89, 27);
		HoaDon.add(btnTimKiem_HD);
		
		JButton btnThem_HD = new JButton("Th\u00EAm");
		btnThem_HD.setBounds(111, 611, 89, 23);
		HoaDon.add(btnThem_HD);
		
		JButton btnSua_HD = new JButton("S\u1EEDa");
		btnSua_HD.setBounds(275, 611, 89, 23);
		HoaDon.add(btnSua_HD);
		
		JButton btnXoa_HD = new JButton("X\u00F3a");
		btnXoa_HD.setBounds(407, 611, 89, 23);
		HoaDon.add(btnXoa_HD);
		
		JButton btnCapNhatDSHD = new JButton("C\u1EADp nh\u1EADt DSHD");
		btnCapNhatDSHD.setBounds(111, 645, 119, 23);
		HoaDon.add(btnCapNhatDSHD);
		
		JButton btnDatLai_HD = new JButton("\u0110\u1EB7t l\u1EA1i");
		btnDatLai_HD.setBounds(275, 645, 89, 23);
		HoaDon.add(btnDatLai_HD);
		
		JButton btnThoat_HD = new JButton("Tho\u00E1t");
		btnThoat_HD.setBounds(407, 645, 89, 23);
		HoaDon.add(btnThoat_HD);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "CHI TI\u1EBET H\u0110", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(625, 90, 600, 374);
		HoaDon.add(panel);
		panel.setLayout(null);
		
		JLabel lblTnKh = new JLabel("Tên KHM");
		lblTnKh.setBounds(24, 31, 89, 24);
		panel.add(lblTnKh);
		
		JLabel lblNgytV = new JLabel("Ng\u00E0y \u0111\u1EB7t v\u00E9");
		lblNgytV.setBounds(24, 64, 89, 24);
		panel.add(lblNgytV);
		
		JLabel lblTnNv = new JLabel("T\u00EAn NV");
		lblTnNv.setBounds(24, 99, 89, 24);
		panel.add(lblTnNv);
		
		JLabel lblThnhTin = new JLabel("Th\u00E0nh ti\u1EC1n");
		lblThnhTin.setBounds(24, 175, 89, 24);
		panel.add(lblThnhTin);
		
		txtTenKHM = new JTextField();
		txtTenKHM.setEditable(false);
		txtTenKHM.setBounds(123, 31, 299, 26);
		panel.add(txtTenKHM);
		txtTenKHM.setColumns(10);
		
		txtNgayDatVe_CTHD = new JTextField();
		txtNgayDatVe_CTHD.setEditable(false);
		txtNgayDatVe_CTHD.setColumns(10);
		txtNgayDatVe_CTHD.setBounds(123, 66, 299, 26);
		panel.add(txtNgayDatVe_CTHD);
		
		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(123, 101, 299, 26);
		panel.add(txtTenNV);
		
		txtThanhTien_CTHD = new JTextField();
		txtThanhTien_CTHD.setEditable(false);
		txtThanhTien_CTHD.setColumns(10);
		txtThanhTien_CTHD.setBounds(123, 177, 299, 26);
		panel.add(txtThanhTien_CTHD);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch chi ti\u1EBFt H\u0110", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(24, 214, 566, 153);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 24, 546, 118);
		panel_1.add(scrollPane_1);
		
		tblChiTietHD = new JTable();
		scrollPane_1.setViewportView(tblChiTietHD);
		
		JLabel lblSLngV = new JLabel("Số lượng vé");
		lblSLngV.setBounds(24, 134, 89, 24);
		panel.add(lblSLngV);
		
		txtSoLuongVe_CTHD = new JTextField();
		txtSoLuongVe_CTHD.setEditable(false);
		txtSoLuongVe_CTHD.setColumns(10);
		txtSoLuongVe_CTHD.setBounds(123, 136, 299, 26);
		panel.add(txtSoLuongVe_CTHD);
		
		JButton btbThem_CTHD = new JButton("Th\u00EAm");

		btbThem_CTHD.setBounds(723, 611, 89, 23);
		HoaDon.add(btbThem_CTHD);
		
		JButton btnSua_CTHD = new JButton("S\u1EEDa");

		btnSua_CTHD.setBounds(899, 611, 89, 23);
		HoaDon.add(btnSua_CTHD);
		
		JButton btnXoa_CTHD = new JButton("X\u00F3a");

		btnXoa_CTHD.setBounds(1019, 611, 89, 23);
		HoaDon.add(btnXoa_CTHD);
		
		JButton btnCapNhatDSCTHD = new JButton("C\u1EADp nh\u1EADt DSCTHD");
		btnCapNhatDSCTHD.setBounds(723, 645, 141, 23);
		HoaDon.add(btnCapNhatDSCTHD);
		
		JButton btnDatLai_CTHD = new JButton("\u0110\u1EB7t l\u1EA1i");
		btnDatLai_CTHD.setBounds(899, 645, 89, 23);
		HoaDon.add(btnDatLai_CTHD);
		
		JButton btnThoat_CTHD = new JButton("Tho\u00E1t");
		btnThoat_CTHD.setBounds(1019, 645, 89, 23);
		HoaDon.add(btnThoat_CTHD);
		
		JLabel lblMH = new JLabel("M\u00E3 H\u0110");
		lblMH.setBounds(663, 475, 75, 23);
		HoaDon.add(lblMH);
		
		JLabel lblMV = new JLabel("M\u00E3 v\u00E9");
		lblMV.setBounds(663, 509, 75, 24);
		HoaDon.add(lblMV);
		
		JLabel lblMHngV = new JLabel("M\u00E3 h\u1EA1ng v\u00E9");
		lblMHngV.setBounds(663, 544, 75, 27);
		HoaDon.add(lblMHngV);
		
		JLabel lblMaHD_CTHD = new JLabel("");
		lblMaHD_CTHD.setBounds(745, 475, 129, 23);
		HoaDon.add(lblMaHD_CTHD);
		
		JLabel lblMaVe = new JLabel("");
		lblMaVe.setBounds(745, 510, 129, 23);
		HoaDon.add(lblMaVe);
		
		JLabel lblMaHangVe = new JLabel("");
		lblMaHangVe.setBounds(745, 546, 129, 23);
		HoaDon.add(lblMaHangVe);
		
		JLabel lblTnKh_1 = new JLabel("Tên KHD");
		lblTnKh_1.setBounds(975, 475, 69, 23);
		HoaDon.add(lblTnKh_1);
		
		JLabel lblTnChng = new JLabel("T\u00EAn ch\u1EB7ng");
		lblTnChng.setBounds(975, 509, 69, 23);
		HoaDon.add(lblTnChng);
		
		JLabel lblGiV = new JLabel("Gi\u00E1 v\u00E9");
		lblGiV.setBounds(975, 544, 69, 23);
		HoaDon.add(lblGiV);
		
		JLabel lblVisa = new JLabel("VISA");
		lblVisa.setBounds(975, 577, 69, 23);
		HoaDon.add(lblVisa);
		
		JLabel lblTenKHD = new JLabel("");
		lblTenKHD.setBounds(1054, 475, 157, 23);
		HoaDon.add(lblTenKHD);
		
		JLabel lblTenChang = new JLabel("");
		lblTenChang.setBounds(1054, 510, 157, 23);
		HoaDon.add(lblTenChang);
		
		JLabel lblGiaVe = new JLabel("");
		lblGiaVe.setBounds(1054, 544, 157, 23);
		HoaDon.add(lblGiaVe);
		
		JLabel lblVISA = new JLabel("");
		lblVISA.setBounds(1054, 577, 157, 23);
		HoaDon.add(lblVISA);
		
		JLabel lblTenAD = new JLabel("");
		lblTenAD.setText("Xin chào "+main.TenNV);
		lblTenAD.setBounds(1080, 11, 145, 27);
		HoaDon.add(lblTenAD);
		
		JButton btnSuaTTKH = new JButton("...");
		btnSuaTTKH.setBounds(380, 420, 34, 16);
		HoaDon.add(btnSuaTTKH);
		
		txtMaHD_HD = new JTextField();
		txtMaHD_HD.setEditable(false);
		txtMaHD_HD.setColumns(10);
		txtMaHD_HD.setBounds(111, 369, 240, 27);
		HoaDon.add(txtMaHD_HD);
		
		txtSoLuongVe = new JTextField();
		txtSoLuongVe.setEditable(false);
		txtSoLuongVe.setColumns(10);
		txtSoLuongVe.setBounds(111, 526, 240, 27);
		HoaDon.add(txtSoLuongVe);
		
		txtThanhTien_HD = new JTextField();
		txtThanhTien_HD.setEditable(false);
		txtThanhTien_HD.setColumns(10);
		txtThanhTien_HD.setBounds(111, 564, 240, 27);
		HoaDon.add(txtThanhTien_HD);
		
		JButton btnXemToanBoDSCTHD = new JButton("Xem toàn bộ DS CTHD");

		btnXemToanBoDSCTHD.setBounds(1054, 60, 171, 23);
		HoaDon.add(btnXemToanBoDSCTHD);
		
		JButton btnTimKiemNangCao = new JButton("Tìm kiếm nâng cao");
		
		btnTimKiemNangCao.setBounds(417, 370, 141, 25);
		HoaDon.add(btnTimKiemNangCao);
		
		JButton btnXuatFile = new JButton("Xuất file");
		
		btnXuatFile.setBounds(494, 86, 100, 23);
		HoaDon.add(btnXuatFile);
		
		
		btnThem_HD.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				HoaDonFRM2 themhd=new HoaDonFRM2();
			}
		});
		/*btnThem_HD.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				HoaDonDTO hd=new HoaDonDTO();
				hd.setMaHD(txtMaHD_HD.getText());
				hd.setMaKH(txtMaKH_HD.getText());
				hd.setMaNV(txtMaNV_HD.getText());
				hd.setNgayDatVe(txtNgayDatVe_HD.getText());
				hd.setSoLuongVe(Integer.valueOf(txtSoLuongVe.getText()));
				hd.setThanhTien(Integer.valueOf(txtThanhTien_HD.getText()));
				
				Vector row=new Vector();
				row.add(hd.getMaHD());
				row.add(hd.getMaKH());
				row.add(hd.getMaNV());
				row.add(hd.getNgayDatVe());
				row.add(String.valueOf(hd.getSoLuongVe()));
				row.add(String.valueOf(hd.getThanhTien()));
				
				model.addRow(row);
				tblHoaDon.setModel(model);
				
				HoaDonBUS bus=new HoaDonBUS();
				bus.them(hd);
			}
		});*/
		
		btnSua_HD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int k=JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn sửa");
				if(k==0)
				{
					int i=tblHoaDon.getSelectedRow();
					if(i>=0)
					{
						JOptionPane.showMessageDialog(null,"Đã Sửa.");
						HoaDonDTO hd=new HoaDonDTO();
						hd.setMaHD(txtMaHD_HD.getText());
						hd.setMaKH(txtMaKH_HD.getText());
						hd.setMaNV(txtMaNV_HD.getText());
						hd.setNgayDatVe(txtNgayDatVe_HD.getText());
						hd.setSoLuongVe(Integer.valueOf(txtSoLuongVe.getText()));
						hd.setThanhTien(Integer.valueOf(txtThanhTien_HD.getText()));
						
						tblHoaDon.getModel().setValueAt(hd.getMaHD(),i,0);
						tblHoaDon.getModel().setValueAt(hd.getMaKH(),i,1);
						tblHoaDon.getModel().setValueAt(hd.getMaNV(),i,2);
						tblHoaDon.getModel().setValueAt(hd.getNgayDatVe(),i,3);
						tblHoaDon.getModel().setValueAt(hd.getSoLuongVe(),i,4);
						tblHoaDon.getModel().setValueAt(hd.getThanhTien(),i,5);
						
						HoaDonBUS bus=new HoaDonBUS();
						bus.sua(i, hd);
					}
					else JOptionPane.showMessageDialog(null,"Vui lòng chọn hóa đơn cần sửa.");
					
				}
							
				
			}
		});
		btnXoa_HD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=tblHoaDon.getSelectedRow();
				int k=JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xóa");

				if(k==0)
				{
					if(i>=0)
					{
						JOptionPane.showMessageDialog(null,"Đã xóa.");
						HoaDonBUS bus=new HoaDonBUS();
						bus.xoa(i, tblHoaDon.getModel().getValueAt(i,0).toString());
						model.removeRow(i);
						tblHoaDon.setModel(model);
						
					}
					else JOptionPane.showMessageDialog(null,"Vui lòng chọn hóa đơn cần xóa.");
				}
			}
		});
		btnCapNhatDSHD.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				HoaDonBUS bus=new HoaDonBUS();
				bus.docDSHD();
				model =new DefaultTableModel();
				tblHoaDon.setModel(model);
				setTable();
			}
		});
		
		btnDatLai_HD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtMaHD_HD.setText("");
				txtMaKH_HD.setText("");
				txtMaNV_HD.setText("");
				txtNgayDatVe_HD.setText("");
				txtSoLuongVe.setText("");
				txtThanhTien_HD.setText("");
				
			}
		});
		btnThoat_HD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			
			}
		});
		tblHoaDon.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int i=tblHoaDon.getSelectedRow();
				if(i>=0)
				{
					txtMaHD_HD.setText(tblHoaDon.getModel().getValueAt(i,0).toString());
					txtMaKH_HD.setText(tblHoaDon.getModel().getValueAt(i,1).toString());
					txtMaNV_HD.setText(tblHoaDon.getModel().getValueAt(i,2).toString());
					txtNgayDatVe_HD.setText(tblHoaDon.getModel().getValueAt(i,3).toString());
					txtSoLuongVe.setText(tblHoaDon.getModel().getValueAt(i,4).toString());
					txtThanhTien_HD.setText(tblHoaDon.getModel().getValueAt(i,5).toString());
					
					String mahd=tblHoaDon.getModel().getValueAt(i,0).toString();
					ChiTietHDBUS bus=new ChiTietHDBUS();
					bus.xemCTHD(mahd);
					newTableCTHD();
					newDataCTHD();
					
					txtNgayDatVe_CTHD.setText(txtNgayDatVe_HD.getText());
					txtThanhTien_CTHD.setText(txtThanhTien_HD.getText());
					txtSoLuongVe_CTHD.setText(txtSoLuongVe.getText());
				}
				
			}
		});
		tblChiTietHD.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int k=tblChiTietHD.getSelectedRow();
				if(k>=0)
				{
					lblMaHD_CTHD.setText(tblChiTietHD.getModel().getValueAt(k,0).toString());
					lblMaVe.setText(tblChiTietHD.getModel().getValueAt(k,1).toString());
					lblMaHangVe.setText(tblChiTietHD.getModel().getValueAt(k,2).toString());
					lblTenKHD.setText(tblChiTietHD.getModel().getValueAt(k,3).toString());
					lblTenChang.setText(tblChiTietHD.getModel().getValueAt(k,4).toString());
					lblGiaVe.setText(tblChiTietHD.getModel().getValueAt(k,5).toString());
					lblVISA.setText(tblChiTietHD.getModel().getValueAt(k,6).toString());
				}
			}
		});
		btnTimKiem_HD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=cbbTimKiem_HD.getSelectedIndex();
				if(i==0)
				{
					JOptionPane.showMessageDialog(null,"Vui lòng chọn loại muốn tìm.");
				}
				else if(i==1)
				{
					newTableHD();
					HoaDonBUS bus=new HoaDonBUS();
					bus.timKiem("MaHD",txtTimKiemHD.getText());
					newDataModel();
				}
				else if(i==2)
				{
					newTableHD();
					HoaDonBUS bus=new HoaDonBUS();
					bus.timKiem("MaKH",txtTimKiemHD.getText());
					newDataModel();
				}
				else if(i==3)
				{
					newTableHD();
					HoaDonBUS bus=new HoaDonBUS();
					bus.timKiem("MaNV",txtTimKiemHD.getText());
					newDataModel();
				}
				
				
			}
		});
		
		btnTimKiemNangCao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtTKNC_MaKH =new JTextField("");
				txtTKNC_MaNV =new JTextField("");
				txtTKNC_NgayDatVeTu =new JTextField("");
				txtTKNC_NgayDatVeDen =new JTextField("");
				txtTKNC_GiaTu =new JTextField();
				txtTKNC_GiaDen =new JTextField();
				
				Object []tknc= {
					"Nhập mã KH",txtTKNC_MaKH,
					"Nhập mã NV",txtTKNC_MaNV," ",
					"Nhập ngày đặt vé (yyyy-mm-dd)",
					"Từ",txtTKNC_NgayDatVeTu,
					"Đến",txtTKNC_NgayDatVeDen," ",
					"Nhập khoảng giá",
					"Từ",txtTKNC_GiaTu,
					"Đến",txtTKNC_GiaDen,
				};
				
				int i=JOptionPane.showConfirmDialog(getParent(),tknc,"Nhập những giá trị cần tìm",JOptionPane.OK_CANCEL_OPTION);
				int flag=0;
				Date ngayDatVeTu = null;
				Date ngayDatVeDen=null;
				String a=txtTKNC_NgayDatVeTu.getText();
				String b=txtTKNC_NgayDatVeDen.getText();
				if( a.equals("")==false && b.equals("")==false )
				{
					try {
						
						SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
						ngayDatVeTu=f.parse(txtTKNC_NgayDatVeTu.getText());
						ngayDatVeDen=f.parse(txtTKNC_NgayDatVeDen.getText());
						
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"Ngày tháng nhập ko hợp lệ.");
						flag=1;
					}
				}
				if(flag==0 && ngayDatVeTu.compareTo(ngayDatVeDen)>0)
				{
					JOptionPane.showMessageDialog(null,"Khoảng ngày nhập không hợp lệ.");
					flag=1;
				}
				for(int j=0;j<txtTKNC_GiaTu.getText().length();j++)
				{
					if(txtTKNC_GiaTu.getText().charAt(j)<'0' || txtTKNC_GiaTu.getText().charAt(j)>'9')
					{
						JOptionPane.showMessageDialog(null,"Giá tiền nhập không hợp lệ.");
						flag=1;
					}
				}
				
				for(int j=0;j<txtTKNC_GiaDen.getText().length();j++)
				{
					if(txtTKNC_GiaDen.getText().charAt(j)<'0' || txtTKNC_GiaDen.getText().charAt(j)>'9')
					{
						JOptionPane.showMessageDialog(null,"Giá tiền nhập không hợp lệ.");
						flag=1;
					}
				}
				if( txtTKNC_GiaDen.getText().equals("")==false && txtTKNC_GiaTu.getText().equals("")==false )
				{
				int gden=Integer.valueOf(txtTKNC_GiaDen.getText());
				int gtu=Integer.valueOf(txtTKNC_GiaTu.getText());
				if(flag==0 && gden<gtu)
				{
					JOptionPane.showMessageDialog(null,"Giá tiền nhập không hợp lệ.");
					flag=1;
				}
				}
				if(txtTKNC_MaKH.getText().equals("")==true && txtTKNC_MaNV.getText().equals("")==true && txtTKNC_NgayDatVeTu.getText().equals("")==true && txtTKNC_NgayDatVeDen.getText().equals("")==true && txtTKNC_GiaTu.getText().equals("")==true && txtTKNC_GiaDen.getText().equals("")==true)
						flag=1;
				if(flag==0)
				{
					newTableHD();
					HoaDonBUS bus=new HoaDonBUS();
					bus.timKiemNangCao(txtTKNC_MaKH.getText(),txtTKNC_MaNV.getText(),txtTKNC_NgayDatVeTu.getText(),txtTKNC_NgayDatVeDen.getText(),txtTKNC_GiaTu.getText(),txtTKNC_GiaDen.getText());
					newDataModel();
				}
			}
		});
//--------------------------------------------------------------------------------------------------------------------------------//		
		btnCapNhatDSCTHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=tblHoaDon.getSelectedRow();
				if(i>=0)
				{
					ChiTietHDBUS bus=new ChiTietHDBUS();
					bus.xemCTHD(tblHoaDon.getModel().getValueAt(i,0).toString());
					newTableCTHD();
					newDataCTHD();
				}
				else JOptionPane.showMessageDialog(null,"Vui lòng chọn hóa đơn cần cập nhật.");
				
				
				
			}
		});
		
		btbThem_CTHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int k=tblHoaDon.getSelectedRow();
				
				if(k>=0)
				{
					String mahd=tblHoaDon.getModel().getValueAt(k,0).toString();
					int sl=Integer.valueOf(tblHoaDon.getModel().getValueAt(k,4).toString());
					ChiTietHDFRM ct=new ChiTietHDFRM();
					ct.them(mahd,sl);
				}
				else JOptionPane.showMessageDialog(null,"Vui lòng chọn chi tiết cần thêm.");
			}
		});
		
		btnSua_CTHD.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int k=tblHoaDon.getSelectedRow();
				int i=tblChiTietHD.getSelectedRow();
				
				if(k>=0 && i>=0)
				{
					String mahd=tblHoaDon.getModel().getValueAt(k,0).toString();
					String mave=tblChiTietHD.getModel().getValueAt(i,1).toString();
					//tim makh trong csld,
					String makh="";
					ChiTietHDFRM ct=new ChiTietHDFRM();
					ct.sua(mahd, mave, makh);
				}
				else JOptionPane.showMessageDialog(null,"Vui lòng chọn chi tiết cần sửa.");
			}
		});
		
		btnXoa_CTHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int k=tblHoaDon.getSelectedRow();
				int i=tblChiTietHD.getSelectedRow();
				
				int c=JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xóa");

				if(c==0)
				{
					if(k>=0 && i>=0)
					{
						
						JOptionPane.showMessageDialog(null,"Đã xóa.");
						String mahd=tblHoaDon.getModel().getValueAt(k,0).toString();
						String mave=tblChiTietHD.getModel().getValueAt(i,1).toString();
						ChiTietHDBUS bus=new ChiTietHDBUS();
						bus.xoa(mahd,mave,i);
						
						modelcthd.removeRow(i);
						tblChiTietHD.setModel(model);
					}
					else JOptionPane.showMessageDialog(null,"Vui lòng chọn chi tiết cần xóa.");
				}
			}
		});
		
			btnDatLai_CTHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMaHD_CTHD.setText("");
				lblMaVe.setText("");
				lblMaHangVe.setText("");
				lblTenKHD.setText("");
				lblTenChang.setText("");
				lblGiaVe.setText("");
				lblVISA.setText("");
				
			}
		});
		
		btnThoat_CTHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			
			}
		});
		
		btnXemToanBoDSCTHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChiTietHDFRM ct=new ChiTietHDFRM();
				ct.xemToanBoDSCTHD();
			}
		});
		
		btnXuatFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				file =new File("hoadon.xls");
				xuatFileExcel(tblHoaDon, file);
				JOptionPane.showMessageDialog(null,"Đã xuất ra file excel.");
			}
		});
	}
	
	
	public void newTableHD()
	{
		model=new DefaultTableModel();
		Vector header=new Vector();
		header.add("MaHD");
		header.add("MaKH");
		header.add("MaNV");
		header.add("NgayDatVe");
		header.add("SoLuongVe");
		header.add("ThanhTien");
		
		if(model.getRowCount()==0)
			model=new DefaultTableModel(header,0);
		tblHoaDon.setModel(model);
	}
	public void newDataModel()
	{
		for(HoaDonDTO hd : HoaDonBUS.dshd)
		{
			Vector row=new Vector();
			row.add(hd.getMaHD());
			row.add(hd.getMaKH());
			row.add(hd.getMaNV());
			row.add(hd.getNgayDatVe());
			row.add(hd.getSoLuongVe());
			row.add(hd.getThanhTien());
			
			model.addRow(row);
		}
		tblHoaDon.setModel(model);
	}
	
	public void newTableCTHD()
	{
		modelcthd=new DefaultTableModel();
		Vector header=new Vector();
		header.add("M\u00E3 H\u0110");
		header.add("M\u00E3 v\u00E9");
		header.add("M\u00E3 h\u1EA1ng v\u00E9");
		header.add("T\u00EAn KH");
		header.add("T\u00EAn ch\u1EB7ng bay");
		header.add("Gi\u00E1 v\u00E9");
		header.add("VISA");
		
		if(modelcthd.getRowCount()==0)
			modelcthd=new DefaultTableModel(header,0);
		tblChiTietHD.setModel(modelcthd);
	}
	
	public void newDataCTHD()
	{
		
		for(ChiTietHDDTO ct: ChiTietHDBUS.dscthd)
		{
			Vector row=new Vector();
			row.add(ct.getMaHD());
			row.add(ct.getMaVe());
			row.add(ct.getMaHangVe());
			row.add(ct.getTenKH());
			row.add(ct.getTenChang());
			row.add(ct.getGiaVe());
			row.add(ct.getVISA());
			modelcthd.addRow(row);
		}
		tblChiTietHD.setModel(modelcthd);
	}
	
	public void xuatFileExcel(JTable table, File file){
			
			try{
				FileWriter out = new FileWriter(file);
			// Xuat tieu de bang ra file excel
				for(int i=0; i < table.getColumnCount();i++) {
					out.write(table.getColumnName(i)+"\t");
				}
				out.write("\n");
			// Xuat noi dung bang ra file excel.
				for(int i=0; i < table.getRowCount();i++){
					for(int j=0;j < table.getColumnCount();j++){
							out.write(table.getModel().getValueAt(i,j).toString() + "\t"); // \t de chuyen sang cot moi trong file excel.
						}
					out.write("\n"); // \n de xuong dong moi trong file excel.
				}
				out.close();
			}
			catch(Exception ex) {}

		}
}
