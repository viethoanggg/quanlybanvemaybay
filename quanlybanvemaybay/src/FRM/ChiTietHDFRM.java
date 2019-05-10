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
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private JTable tblCTHD=new JTable();
	private DefaultTableModel model =new DefaultTableModel();
	private JTextField txtTimKiem;
	private JTextField txtTKNC_GiaTu;
	private JTextField txtTKNC_GiaDen;
	private JLabel lblSoLuongVeCu;
	
	public static int sovedat=0;
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
		setAutoRequestFocus(false);
		setTitle("Chi Tiết hóa đơn");
		
		HoaDonBUS hdbus=new HoaDonBUS();
		hdbus.docDSHD();
		KhachHangBUS khbus=new KhachHangBUS();
		khbus.docDSKH();
		sovedat=0;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tab.setBackground(new Color(255, 255, 255));
		tab.setBounds(0, 0, 530, 554);
		contentPane.add(tab);
		
		JPanel panelDSCTHD = new JPanel();
		panelDSCTHD.setBackground(new Color(240, 255, 255));
		tab.addTab("Danh sách chi tiết HĐ", null, panelDSCTHD, null);
		panelDSCTHD.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch chi ti\u1EBFt H\u0110", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(0, 110, 525, 198);
		panelDSCTHD.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 505, 166);
		scrollPane.setBackground(Color.WHITE);
		panel_2.add(scrollPane);
		
		tblCTHD = new JTable();
		scrollPane.setViewportView(tblCTHD);
		
		JLabel label = new JLabel("Mã HĐ");
		label.setBounds(60, 366, 75, 23);
		panelDSCTHD.add(label);
		
		JLabel label_2 = new JLabel("Mã vé");
		label_2.setBounds(60, 400, 75, 24);
		panelDSCTHD.add(label_2);
		
		JLabel label_3 = new JLabel("Mã hạng vé");
		label_3.setBounds(60, 435, 75, 27);
		panelDSCTHD.add(label_3);
		
		JLabel lblMaHD_CTHD = new JLabel("");
		lblMaHD_CTHD.setBounds(142, 366, 129, 23);
		panelDSCTHD.add(lblMaHD_CTHD);
		
		JLabel lblMaVe = new JLabel("");
		lblMaVe.setBounds(142, 401, 129, 23);
		panelDSCTHD.add(lblMaVe);
		
		JLabel lblMaHangVe = new JLabel("");
		lblMaHangVe.setBounds(142, 437, 129, 23);
		panelDSCTHD.add(lblMaHangVe);
		
		JLabel label_7 = new JLabel("Tên KHD");
		label_7.setBounds(294, 366, 69, 23);
		panelDSCTHD.add(label_7);
		
		JLabel label_8 = new JLabel("Tên chặng");
		label_8.setBounds(294, 400, 69, 23);
		panelDSCTHD.add(label_8);
		
		JLabel label_9 = new JLabel("Giá vé");
		label_9.setBounds(294, 435, 69, 23);
		panelDSCTHD.add(label_9);
		
		JLabel label_10 = new JLabel("VISA");
		label_10.setBounds(294, 468, 69, 23);
		panelDSCTHD.add(label_10);
		
		JLabel lblTenChang = new JLabel("");
		lblTenChang.setBounds(357, 401, 157, 23);
		panelDSCTHD.add(lblTenChang);
		
		JLabel lblGiaVe = new JLabel("");
		lblGiaVe.setBounds(357, 435, 157, 23);
		panelDSCTHD.add(lblGiaVe);
		
		JLabel lblVISA = new JLabel("");
		lblVISA.setBounds(357, 468, 157, 23);
		panelDSCTHD.add(lblVISA);
		
		JLabel label_4 = new JLabel("Tìm Kiếm");
		label_4.setBounds(28, 328, 58, 27);
		panelDSCTHD.add(label_4);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(114, 328, 141, 27);
		panelDSCTHD.add(txtTimKiem);
		
		JComboBox cbbTimKiem = new JComboBox();
		cbbTimKiem.setBackground(new Color(255, 255, 255));
		cbbTimKiem.setModel(new DefaultComboBoxModel(new String[] {"--Chọn-- ", "MaHD", "MaVe", "MaHangVe", "TenKH", "TenChang"}));
		cbbTimKiem.setBounds(280, 328, 109, 27);
		panelDSCTHD.add(cbbTimKiem);
		
		JButton btnTimKiem = new JButton("");
		btnTimKiem.setIcon(new ImageIcon("images/iconSearch.png"));
		btnTimKiem.setBackground(new Color(255, 255, 255));
		btnTimKiem.setBounds(413, 328, 32, 27);
		btnTimKiem.setBorder(new EmptyBorder(0,0,0,0));
		panelDSCTHD.add(btnTimKiem);
		
		JButton btnThem_DSCTHD = new JButton("");
		btnThem_DSCTHD.setIcon(new ImageIcon("images/icons8-plus-48.png"));
		btnThem_DSCTHD.setBackground(new Color(255, 255, 255));
		btnThem_DSCTHD.setBounds(357, 62, 46, 45);
		btnThem_DSCTHD.setBorder(new EmptyBorder(0,0,0,0));
		panelDSCTHD.add(btnThem_DSCTHD);
		
		JButton btnSua_DSCTHD = new JButton("");
		btnSua_DSCTHD.setIcon(new ImageIcon("images/icons8-maintenance-48.png"));
		btnSua_DSCTHD.setBackground(new Color(255, 255, 255));
		btnSua_DSCTHD.setBounds(413, 62, 46, 45);
		btnSua_DSCTHD.setBorder(new EmptyBorder(0,0,0,0));
		panelDSCTHD.add(btnSua_DSCTHD);
		
		JButton btnXoa_DSCTHD = new JButton("");
		btnXoa_DSCTHD.setIcon(new ImageIcon("images/icons8-cancel-48.png"));
		btnXoa_DSCTHD.setBackground(new Color(255, 255, 255));
		btnXoa_DSCTHD.setBounds(469, 62, 46, 45);
		btnXoa_DSCTHD.setBorder(new EmptyBorder(0,0,0,0));
		panelDSCTHD.add(btnXoa_DSCTHD);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(0, 0, 525, 51);
		panelDSCTHD.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnCapNhatDSCTHD = new JButton("Cập nhật DSCTHD");
		btnCapNhatDSCTHD.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCapNhatDSCTHD.setIcon(new ImageIcon("images/icons8-refresh-16.png"));
		btnCapNhatDSCTHD.setBackground(new Color(255, 255, 255));
		btnCapNhatDSCTHD.setHorizontalAlignment(SwingConstants.LEFT);
		btnCapNhatDSCTHD.setBounds(10, 12, 176, 32);
		panel_3.add(btnCapNhatDSCTHD);
		
		JButton button_5 = new JButton("Thoát");
		button_5.setIcon(new ImageIcon("images/iconExit.png"));
		button_5.setHorizontalAlignment(SwingConstants.LEFT);
		button_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_5.setBackground(new Color(255, 255, 255));
		button_5.setBounds(216, 12, 105, 32);
		panel_3.add(button_5);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(378, 370, 46, 14);
		panelDSCTHD.add(label_5);
		
		JLabel lblTenKHD = new JLabel("");
		lblTenKHD.setBounds(357, 366, 157, 23);
		panelDSCTHD.add(lblTenKHD);
		
		
		
		
		JPanel panelThemCTHD = new JPanel();
		panelThemCTHD.setBackground(new Color(245, 255, 250));
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
		panel.setBackground(new Color(245, 255, 250));
		panel.setBorder(new TitledBorder(null, "Th\u00EAm KHD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 83, 515, 153);
		panelThemCTHD.add(panel);
		panel.setLayout(null);
		
		JLabel lblMKhd = new JLabel("Mã KHD");
		lblMKhd.setBounds(30, 27, 76, 29);
		panel.add(lblMKhd);
		
		txtMaKHD = new JTextField();
		
		txtMaKHD.setBounds(175, 27, 117, 29);
		panel.add(txtMaKHD);
		txtMaKHD.setColumns(10);
		
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
		
		JButton btnThemKHDMoi = new JButton("Thêm KH Mới");
		
		btnThemKHDMoi.setBounds(393, 27, 112, 29);
		panel.add(btnThemKHDMoi);
		
		JLabel lblKhd = new JLabel("KHD_");
		lblKhd.setBounds(119, 27, 46, 29);
		panel.add(lblKhd);
		
		JLabel label_6 = new JLabel("(Nhập số)");
		label_6.setFont(new Font("Tahoma", Font.ITALIC, 10));
		label_6.setBounds(293, 27, 90, 27);
		panel.add(label_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
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
		
		lblSoLuongVeCu = new JLabel("");
		lblSoLuongVeCu.setBackground(new Color(224, 255, 255));
		lblSoLuongVeCu.setBounds(318, 46, 46, 20);
		panelThemCTHD.add(lblSoLuongVeCu);
		
		JButton btnThemCTHD = new JButton("Thêm");
		btnThemCTHD.setBounds(130, 477, 89, 34);
		panelThemCTHD.add(btnThemCTHD);
		
		JButton btnDatLai_Them = new JButton("Đặt lại");
		btnDatLai_Them.setBounds(264, 477, 89, 34);
		panelThemCTHD.add(btnDatLai_Them);
		
		JButton btnThoat_Them = new JButton("Thoát");
		btnThoat_Them.setBounds(399, 477, 89, 34);
		panelThemCTHD.add(btnThoat_Them);
		
		ButtonGroup g=new ButtonGroup();

		setTable();
		setVisible(true);

///////////////////////////////////////////////////////////////////////////////////////
		btnCapNhatDSCTHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChiTietHDBUS bus=new ChiTietHDBUS();
				bus.docDSCTHD();
				newTableCTHD();
				newDataCTHD();
				
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
		
		txtMaKHD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String makh="KHD_"+txtMaKHD.getText();
				
				for(KhachHangDTO kh :KhachHangBUS.dskh)
				{
					if(makh.equals(kh.getMaKH()))
					{
						txtTenKHD.setText(kh.getTenKH());
						txtVISA.setText(kh.getVisa());
						break;
					}
					else
					{
						txtTenKHD.setText("");
						txtVISA.setText("");
					}	
				}
			}
		});
		btnThemKHDMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themKHD();
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
		tab.setEnabledAt(0,false);
		txtMaHD_Them.setText(MaHD);
		txtSoLuongVe.setText(String.valueOf(soluongve));
		lblSoLuongVeCu.setText(String.valueOf(soluongve));
	}
	
	public void xemToanBoDSCTHD()
	{
		tab.setSelectedIndex(0);
		tab.setEnabledAt(0, true);
		tab.setEnabledAt(1,false);

	}
	
	public void themKHD()
	{
		
		JFrame mainFrame =new JFrame();
		
		
		//mainFrame.getContentPane().add(panel);
		mainFrame.setVisible(true);
		//int k=JOptionPane.showConfirmDialog(panel,"nhap", "gg",JOptionPane.OK_CANCEL_OPTION );
		//System.out.print(k);
	}
}
