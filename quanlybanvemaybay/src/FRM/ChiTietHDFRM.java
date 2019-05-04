package FRM;
import BUS.*;
import DAO.*;
import DTO.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DTO.ChiTietHDDTO;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ChiTietHDFRM extends JFrame {

	private JPanel contentPane;
	private final JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
	private JTextField txtMaHD_Them;
	private JTextField txtMaKHD;
	private JTextField txtTenKHD;
	private JTextField txtVISA;
	private JTextField txtSoLuongVe;
	private JTextField txtMaVe;
	private JTextField txtTenHangVe;
	private JTextField txtTenChang;
	private JTextField txtGiaVe;
	private JTextField txtMaHD_Sua;
	private JTextField txtMaVe_Sua;
	private JTextField txtMaKHD_Sua;
	private JTable tblCTHD=new JTable();
	private DefaultTableModel model =new DefaultTableModel();
	private JTextField txtTimKiem;
	private JTextField txtTKNC_GiaTu;
	private JTextField txtTKNC_GiaDen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietHDFRM frame = new ChiTietHDFRM();
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
	public void setTable() 
	{
		ChiTietHDBUS bus=new ChiTietHDBUS();
		if(ChiTietHDBUS.dscthd==null) bus.docDSCTHD();
		
		newTableCTHD();
		newDataCTHD();
	}
	
	public ChiTietHDFRM() {
		setTitle("Chi Tiết hóa đơn");
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tab.setBounds(0, 0, 530, 554);
		contentPane.add(tab);
		
		JPanel panelDSCTHD = new JPanel();
		tab.addTab("Danh sách chi tiết HĐ", null, panelDSCTHD, null);
		panelDSCTHD.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch chi ti\u1EBFt H\u0110", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(0, 11, 525, 198);
		panelDSCTHD.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 505, 166);
		panel_2.add(scrollPane);
		
		tblCTHD = new JTable();
		scrollPane.setViewportView(tblCTHD);
		
		JButton btnThem_DSCTHD = new JButton("Thêm");

		btnThem_DSCTHD.setBounds(60, 458, 89, 23);
		panelDSCTHD.add(btnThem_DSCTHD);
		
		JButton btnSua_DSCTHD = new JButton("Sửa");

		btnSua_DSCTHD.setBounds(236, 458, 89, 23);
		panelDSCTHD.add(btnSua_DSCTHD);
		
		JButton btnXoa_DSCTHD = new JButton("Xóa");

		btnXoa_DSCTHD.setBounds(356, 458, 89, 23);
		panelDSCTHD.add(btnXoa_DSCTHD);
		
		JButton btnCapNhatDSCTHD = new JButton("Cập nhật DSCTHD");
		btnCapNhatDSCTHD.setBounds(60, 492, 141, 23);
		panelDSCTHD.add(btnCapNhatDSCTHD);
		
		JButton button_4 = new JButton("Đặt lại");
		button_4.setBounds(236, 492, 89, 23);
		panelDSCTHD.add(button_4);
		
		JButton button_5 = new JButton("Thoát");
		button_5.setBounds(356, 492, 89, 23);
		panelDSCTHD.add(button_5);
		
		JLabel label = new JLabel("Mã HĐ");
		label.setBounds(60, 309, 75, 23);
		panelDSCTHD.add(label);
		
		JLabel label_2 = new JLabel("Mã vé");
		label_2.setBounds(60, 343, 75, 24);
		panelDSCTHD.add(label_2);
		
		JLabel label_3 = new JLabel("Mã hạng vé");
		label_3.setBounds(60, 378, 75, 27);
		panelDSCTHD.add(label_3);
		
		JLabel lblMaHD_CTHD = new JLabel("");
		lblMaHD_CTHD.setBounds(142, 309, 129, 23);
		panelDSCTHD.add(lblMaHD_CTHD);
		
		JLabel lblMaVe = new JLabel("");
		lblMaVe.setBounds(142, 344, 129, 23);
		panelDSCTHD.add(lblMaVe);
		
		JLabel lblMaHangVe = new JLabel("");
		lblMaHangVe.setBounds(142, 380, 129, 23);
		panelDSCTHD.add(lblMaHangVe);
		
		JLabel label_7 = new JLabel("Tên KHD");
		label_7.setBounds(294, 309, 69, 23);
		panelDSCTHD.add(label_7);
		
		JLabel label_8 = new JLabel("Tên chặng");
		label_8.setBounds(294, 343, 69, 23);
		panelDSCTHD.add(label_8);
		
		JLabel label_9 = new JLabel("Giá vé");
		label_9.setBounds(294, 378, 69, 23);
		panelDSCTHD.add(label_9);
		
		JLabel label_10 = new JLabel("VISA");
		label_10.setBounds(294, 411, 69, 23);
		panelDSCTHD.add(label_10);
		
		JLabel lblTenKHD = new JLabel("");
		lblTenKHD.setBounds(368, 279, 157, 23);
		panelDSCTHD.add(lblTenKHD);
		
		JLabel lblTenChang = new JLabel("");
		lblTenChang.setBounds(368, 314, 157, 23);
		panelDSCTHD.add(lblTenChang);
		
		JLabel lblGiaVe = new JLabel("");
		lblGiaVe.setBounds(368, 348, 157, 23);
		panelDSCTHD.add(lblGiaVe);
		
		JLabel lblVISA = new JLabel("");
		lblVISA.setBounds(368, 381, 157, 23);
		panelDSCTHD.add(lblVISA);
		
		JLabel label_4 = new JLabel("Tìm Kiếm");
		label_4.setBounds(28, 220, 58, 27);
		panelDSCTHD.add(label_4);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(114, 220, 141, 27);
		panelDSCTHD.add(txtTimKiem);
		
		JComboBox cbbTimKiem = new JComboBox();
		cbbTimKiem.setModel(new DefaultComboBoxModel(new String[] {"--Chọn-- ", "MaHD", "MaVe", "MaHangVe", "TenKH", "TenChang"}));
		cbbTimKiem.setBounds(280, 220, 109, 24);
		panelDSCTHD.add(cbbTimKiem);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");

		btnTimKiem.setBounds(415, 220, 89, 27);
		panelDSCTHD.add(btnTimKiem);
		
		JButton btnTimKiemNangCao = new JButton("Tìm kiếm nâng cao");
		
		btnTimKiemNangCao.setBounds(363, 262, 141, 27);
		panelDSCTHD.add(btnTimKiemNangCao);
		
		JPanel panelThemCTHD = new JPanel();
		tab.addTab("Thêm", null, panelThemCTHD, null);
		panelThemCTHD.setLayout(null);
		
		JLabel lblMH = new JLabel("Mã HĐ");
		lblMH.setBounds(41, 11, 89, 24);
		panelThemCTHD.add(lblMH);
		
		txtMaHD_Them = new JTextField();
		txtMaHD_Them.setEditable(false);
		txtMaHD_Them.setBounds(140, 11, 156, 24);
		panelThemCTHD.add(txtMaHD_Them);
		txtMaHD_Them.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00EAm KHD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 83, 515, 153);
		panelThemCTHD.add(panel);
		panel.setLayout(null);
		
		JLabel lblMKhd = new JLabel("Mã KHD");
		lblMKhd.setBounds(30, 27, 76, 29);
		panel.add(lblMKhd);
		
		txtMaKHD = new JTextField();
		txtMaKHD.setBounds(119, 27, 185, 29);
		panel.add(txtMaKHD);
		txtMaKHD.setColumns(10);
		
		JComboBox cbbMaKHD = new JComboBox();
		cbbMaKHD.setModel(new DefaultComboBoxModel(new String[] {"Chọn mã KHD"}));
		cbbMaKHD.setBounds(314, 27, 120, 29);
		panel.add(cbbMaKHD);
		
		JLabel lblTnKhd = new JLabel("Tên KHD");
		lblTnKhd.setBounds(30, 70, 76, 29);
		panel.add(lblTnKhd);
		
		txtTenKHD = new JTextField();
		txtTenKHD.setEditable(false);
		txtTenKHD.setColumns(10);
		txtTenKHD.setBounds(119, 70, 185, 29);
		panel.add(txtTenKHD);
		
		JLabel lblVisa = new JLabel("VISA");
		lblVisa.setBounds(30, 113, 76, 29);
		panel.add(lblVisa);
		
		txtVISA = new JTextField();
		txtVISA.setEditable(false);
		txtVISA.setColumns(10);
		txtVISA.setBounds(119, 113, 185, 29);
		panel.add(txtVISA);
		
		JButton btnThemKHDMoi = new JButton("...");
		btnThemKHDMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemKHDMoi.setBounds(458, 41, 34, 12);
		panel.add(btnThemKHDMoi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00EAm v\u00E9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 259, 515, 207);
		panelThemCTHD.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMV = new JLabel("Mã vé");
		lblMV.setBounds(29, 33, 76, 29);
		panel_1.add(lblMV);
		
		txtMaVe = new JTextField();
		txtMaVe.setEditable(false);
		txtMaVe.setColumns(10);
		txtMaVe.setBounds(118, 33, 185, 29);
		panel_1.add(txtMaVe);
		
		JLabel lblTnHngV = new JLabel("Tên hạng vé");
		lblTnHngV.setBounds(29, 76, 76, 29);
		panel_1.add(lblTnHngV);
		
		txtTenHangVe = new JTextField();
		txtTenHangVe.setEditable(false);
		txtTenHangVe.setColumns(10);
		txtTenHangVe.setBounds(118, 76, 185, 29);
		panel_1.add(txtTenHangVe);
		
		JLabel lblTnChng = new JLabel("Tên chặng");
		lblTnChng.setBounds(29, 119, 76, 29);
		panel_1.add(lblTnChng);
		
		txtTenChang = new JTextField();
		txtTenChang.setEditable(false);
		txtTenChang.setColumns(10);
		txtTenChang.setBounds(118, 119, 315, 29);
		panel_1.add(txtTenChang);
		
		JButton btnThemMaVeMoi = new JButton("Thêm vé");
		btnThemMaVeMoi.setBounds(343, 33, 90, 30);
		panel_1.add(btnThemMaVeMoi);
		
		JLabel lblGiV = new JLabel("Giá vé");
		lblGiV.setBounds(29, 159, 76, 29);
		panel_1.add(lblGiV);
		
		txtGiaVe = new JTextField();
		txtGiaVe.setEditable(false);
		txtGiaVe.setColumns(10);
		txtGiaVe.setBounds(118, 159, 185, 29);
		panel_1.add(txtGiaVe);
		
		JLabel lblSLngV = new JLabel("Số lượng vé");
		lblSLngV.setBounds(40, 46, 88, 26);
		panelThemCTHD.add(lblSLngV);
		
		txtSoLuongVe = new JTextField();
		txtSoLuongVe.setColumns(10);
		txtSoLuongVe.setBounds(140, 46, 156, 24);
		panelThemCTHD.add(txtSoLuongVe);
		
		JButton btnThemCTHD = new JButton("Thêm");
		btnThemCTHD.setBounds(130, 477, 89, 34);
		panelThemCTHD.add(btnThemCTHD);
		
		JButton btnDatLai_Them = new JButton("Đặt lại");
		btnDatLai_Them.setBounds(264, 477, 89, 34);
		panelThemCTHD.add(btnDatLai_Them);
		
		JButton btnThoat_Them = new JButton("Thoát");
		btnThoat_Them.setBounds(399, 477, 89, 34);
		panelThemCTHD.add(btnThoat_Them);
		
		JPanel panelSuaCTHD = new JPanel();
		tab.addTab("Sửa", null, panelSuaCTHD, null);
		panelSuaCTHD.setLayout(null);
		
		JRadioButton rbtnVe = new JRadioButton("Sửa thông tin vé");

		rbtnVe.setBounds(20, 70, 149, 23);
		panelSuaCTHD.add(rbtnVe);
		
		JRadioButton rbtnKHD = new JRadioButton("Sửa thông tin khách hàng đi");

		rbtnKHD.setBounds(20, 162, 181, 23);
		panelSuaCTHD.add(rbtnKHD);
		
		ButtonGroup g=new ButtonGroup();
		g.add(rbtnVe);
		g.add(rbtnKHD);
		
		JLabel lblMH_1 = new JLabel("Mã HĐ");
		lblMH_1.setBounds(28, 11, 77, 29);
		panelSuaCTHD.add(lblMH_1);
		
		txtMaHD_Sua = new JTextField();
		txtMaHD_Sua.setEditable(false);
		txtMaHD_Sua.setBounds(130, 9, 185, 32);
		panelSuaCTHD.add(txtMaHD_Sua);
		txtMaHD_Sua.setColumns(10);
		
		JLabel lblMaVe_Sua = new JLabel("Mã vé");
		lblMaVe_Sua.setBounds(41, 100, 76, 29);
		panelSuaCTHD.add(lblMaVe_Sua);
		
		txtMaVe_Sua = new JTextField();
		txtMaVe_Sua.setEditable(false);
		txtMaVe_Sua.setColumns(10);
		txtMaVe_Sua.setBounds(130, 100, 185, 29);
		panelSuaCTHD.add(txtMaVe_Sua);
		
		JComboBox cbbMaVe_Sua = new JComboBox();
		cbbMaVe_Sua.setModel(new DefaultComboBoxModel(new String[] {"Chọn mã vé"}));
		cbbMaVe_Sua.setEnabled(false);
		cbbMaVe_Sua.setBounds(325, 100, 120, 29);
		panelSuaCTHD.add(cbbMaVe_Sua);
		
		JButton btnSuaTheoMaVe = new JButton("Sửa");
		btnSuaTheoMaVe.setEnabled(false);
		btnSuaTheoMaVe.setBounds(455, 100, 60, 26);
		panelSuaCTHD.add(btnSuaTheoMaVe);
		
		JLabel label_1 = new JLabel("Mã KHD");
		label_1.setBounds(41, 192, 76, 29);
		panelSuaCTHD.add(label_1);
		
		txtMaKHD_Sua = new JTextField();
		txtMaKHD_Sua.setEditable(false);
		txtMaKHD_Sua.setColumns(10);
		txtMaKHD_Sua.setBounds(130, 192, 185, 29);
		panelSuaCTHD.add(txtMaKHD_Sua);
		
		JComboBox cbbMaKHD_Sua = new JComboBox();
		cbbMaKHD_Sua.setModel(new DefaultComboBoxModel(new String[] {"Chọn mã KHD"}));
		cbbMaKHD_Sua.setEnabled(false);
		cbbMaKHD_Sua.setBounds(325, 192, 120, 29);
		panelSuaCTHD.add(cbbMaKHD_Sua);
		
		JButton btnSuaTheoMaKHD = new JButton("Sửa");
		btnSuaTheoMaKHD.setEnabled(false);
		btnSuaTheoMaKHD.setBounds(455, 192, 60, 29);
		panelSuaCTHD.add(btnSuaTheoMaKHD);
		
		JButton btnDatLai_Sua = new JButton("Đặt lại");
		btnDatLai_Sua.setBounds(130, 282, 89, 34);
		panelSuaCTHD.add(btnDatLai_Sua);
		
		JButton btnThoat_Sua = new JButton("Thoát");
		btnThoat_Sua.setBounds(265, 282, 89, 34);
		panelSuaCTHD.add(btnThoat_Sua);

		setTable();
		setVisible(true);
		
		rbtnVe.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(rbtnVe.isSelected()==true)
				{
					txtMaVe_Sua.setEditable(true);
					cbbMaVe_Sua.setEnabled(true);
					btnSuaTheoMaVe.setEnabled(true);
					
					txtMaKHD_Sua.setEditable(false);
					cbbMaKHD_Sua.setEnabled(false);
					btnSuaTheoMaKHD.setEnabled(false);
				}
			}
		});
		rbtnKHD.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(rbtnKHD.isSelected()==true)
				{
					txtMaVe_Sua.setEditable(false);
					cbbMaVe_Sua.setEnabled(false);
					btnSuaTheoMaVe.setEnabled(false);
					
					txtMaKHD_Sua.setEditable(true);
					cbbMaKHD_Sua.setEnabled(true);
					btnSuaTheoMaKHD.setEnabled(true);
				}
			}
		});
		
		tblCTHD.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				int k=tblCTHD.getSelectedRow();
				if(k>=0)
				{
					lblMaHD_CTHD.setText(tblCTHD.getModel().getValueAt(k,0).toString());
					lblMaVe.setText(tblCTHD.getModel().getValueAt(k,1).toString());
					lblMaHangVe.setText(tblCTHD.getModel().getValueAt(k,2).toString());
					lblTenKHD.setText(tblCTHD.getModel().getValueAt(k,3).toString());
					lblTenChang.setText(tblCTHD.getModel().getValueAt(k,4).toString());
					lblGiaVe.setText(tblCTHD.getModel().getValueAt(k,5).toString());
					lblVISA.setText(tblCTHD.getModel().getValueAt(k,6).toString());
				}
			}
		});
		
		btnThem_DSCTHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int i=tblCTHD.getSelectedRow();
				int d=0;
				if(i>=0)
				{
					String mahd=tblCTHD.getModel().getValueAt(i,0).toString();
					for(ChiTietHDDTO ct : ChiTietHDBUS.dscthd)
					{
						if(ct.getMaHD().equals(mahd))
							d++;
						
					}
					
					them(mahd,d);
					tab.setEnabledAt(0,true);
				}
				else JOptionPane.showMessageDialog(null,"Vui lòng chọn hóa đơn cần thêm.");
			}
		});
		
		btnSua_DSCTHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int i=tblCTHD.getSelectedRow();
				if(i>=0) 
				{
					String mahd=tblCTHD.getModel().getValueAt(i,0).toString();
					String mave=tblCTHD.getModel().getValueAt(i,1).toString();
					String makh="";
					sua(mahd,mave,makh);
					tab.setEnabledAt(0,true);
				}
				else JOptionPane.showMessageDialog(null,"Vui lòng chọn chi tiết hóa đơn cần sửa.");
			}
		});
		
		btnXoa_DSCTHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=tblCTHD.getSelectedRow();
				
				int c=JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xóa");

				if(c==0)
				{
					if(i>=0) 
					{
						JOptionPane.showMessageDialog(null,"Đã xóa.");
						String mahd=tblCTHD.getModel().getValueAt(i,0).toString();
						String mave=tblCTHD.getModel().getValueAt(i,1).toString();
						
						ChiTietHDBUS bus=new ChiTietHDBUS();
						bus.xoa(mahd,mave,i);
						
						model.removeRow(i);
						tblCTHD.setModel(model);
					}
					else JOptionPane.showMessageDialog(null,"Vui lòng chọn chi tiết hóa đơn cần xóa.");
				}
			}
		});
		
		btnCapNhatDSCTHD.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ChiTietHDBUS bus=new ChiTietHDBUS();
						bus.docDSCTHD();
						newTableCTHD();
						newDataCTHD();
						
					}
				});
		btnTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int i=cbbTimKiem.getSelectedIndex();
				
				if(i==0)
				{
					JOptionPane.showMessageDialog(null,"Vui lòng chọn loại muốn tìm");
				}
				else if(i==1)
				{
					ChiTietHDBUS bus=new ChiTietHDBUS();
					bus.TimKiemTheoMa("MaHD",txtTimKiem.getText());
					newTableCTHD();
					newDataCTHD();
				}
				else if(i==2)
				{
					ChiTietHDBUS bus=new ChiTietHDBUS();
					bus.TimKiemTheoMa("MaVe",txtTimKiem.getText());
					newTableCTHD();
					newDataCTHD();
				}
				else if(i==3)
				{
					ChiTietHDBUS bus=new ChiTietHDBUS();
					bus.TimKiemTheoMa("MaHangVe",txtTimKiem.getText());
					newTableCTHD();
					newDataCTHD();
				}
				else if(i==4)
				{
					ChiTietHDBUS bus=new ChiTietHDBUS();
					bus.TimKiemTheoTen("TenKH",txtTimKiem.getText());
					newTableCTHD();
					newDataCTHD();
				}
				else if(i==5)
				{
					ChiTietHDBUS bus=new ChiTietHDBUS();
					bus.TimKiemTheoTen("TenChang",txtTimKiem.getText());
					newTableCTHD();
					newDataCTHD();
				}
				
			}
			
		});
		
		btnTimKiemNangCao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtTKNC_GiaTu =new JTextField();
				txtTKNC_GiaDen =new JTextField();
				
				Object []tknc= {
						"Nhập khoảng giá",
						"Từ",txtTKNC_GiaTu,
						"Đến",txtTKNC_GiaDen,
					};
				
				int i=JOptionPane.showConfirmDialog(getParent(),tknc,"Nhập những giá trị cần tìm",JOptionPane.OK_CANCEL_OPTION);
				int flag=0;
				
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
				if(flag==0 && Integer.valueOf(txtTKNC_GiaDen.getText())<Integer.valueOf(txtTKNC_GiaTu.getText()))
				{
					JOptionPane.showMessageDialog(null,"Giá tiền nhập không hợp lệ.");
					flag=1;
				}
				
				if(txtTKNC_GiaTu.getText()=="" && txtTKNC_GiaDen.getText()=="")
					flag=1;
				
				if(flag==0)
				{
					newTableCTHD();
					ChiTietHDBUS bus=new ChiTietHDBUS();
					bus.timKiemNangCao(txtTKNC_GiaTu.getText(),txtTKNC_GiaDen.getText());
					newDataCTHD();
				}
			}
		});
	}
	
	public void newTableCTHD()
	{
		model=new DefaultTableModel();
		Vector header=new Vector();
		header.add("M\u00E3 H\u0110");
		header.add("M\u00E3 v\u00E9");
		header.add("M\u00E3 h\u1EA1ng v\u00E9");
		header.add("T\u00EAn KH");
		header.add("T\u00EAn ch\u1EB7ng bay");
		header.add("Gi\u00E1 v\u00E9");
		header.add("VISA");
		
		if(model.getRowCount()==0)
			model=new DefaultTableModel(header,0);
		tblCTHD.setModel(model);
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
			model.addRow(row);
		}
		tblCTHD.setModel(model);
	}
	
	public void them(String MaHD,int soluongve)
	{
		tab.setSelectedIndex(1);
		tab.setEnabledAt(1, true);
		tab.setEnabledAt(2,false);
		tab.setEnabledAt(0,false);
		txtMaHD_Them.setText(MaHD);
		txtSoLuongVe.setText(String.valueOf(soluongve));
	}
	public void sua(String MaHD,String maVe,String maKH)
	{
		tab.setSelectedIndex(2);
		tab.setEnabledAt(2, true);
		tab.setEnabledAt(1,false);
		tab.setEnabledAt(0,false);
		txtMaHD_Sua.setText(MaHD);
		txtMaVe_Sua.setText(maVe);
		txtMaKHD_Sua.setText(maKH);
	}
	public void xemToanBoDSCTHD()
	{
		tab.setSelectedIndex(0);
		tab.setEnabledAt(0, true);
		tab.setEnabledAt(1,false);
		tab.setEnabledAt(2,false);

	}
}
