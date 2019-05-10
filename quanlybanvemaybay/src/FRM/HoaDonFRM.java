package FRM;
import BUS.*;
import DAO.*;
import DTO.*;

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
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class HoaDonFRM extends JFrame {
	
	
	private JPanel HoaDon;
	private JTable tblHoaDon = new JTable();
	private DefaultTableModel model=new DefaultTableModel();
	private DefaultTableModel modelcthd=new DefaultTableModel();
	private JTextField txtTimKiemHD;
	private JTextField txtMaKH_HD;
	private JTextField txtMaNV_HD;
	private JTextField txtNgayDatVe_HD;
	private JTextField txtMaHD_HD;
	private JTextField txtSoLuongVe;
	private JTextField txtThanhTien_HD;
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
	public static void main(String[] args) {
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
	}
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
		setAutoRequestFocus(false);
		setTable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 653);
		setLocationRelativeTo(null);
		setTitle("Quản lý hóa đơn.");
		HoaDon = new JPanel();
		HoaDon.setBackground(new Color(255, 255, 255));
		HoaDon.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(HoaDon);
		HoaDon.setLayout(null);
		
		JLabel lblHoaDon = new JLabel("DANH SÁCH HÓA ĐƠN");
		//lblHoaDon.setBounds(47, 78, 156, 27);
		HoaDon.add(lblHoaDon);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 116, 584, 188);
		HoaDon.add(scrollPane);
		
		
		scrollPane.setViewportView(tblHoaDon);
		tblHoaDon.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblTmKim = new JLabel("T\u00ECm Ki\u1EBFm");
		lblTmKim.setBounds(47, 325, 91, 27);
		HoaDon.add(lblTmKim);
		
		txtTimKiemHD = new JTextField();
		txtTimKiemHD.setBounds(148, 325, 240, 27);
		HoaDon.add(txtTimKiemHD);
		txtTimKiemHD.setColumns(10);
		
		JLabel lblMaHD = new JLabel("M\u00E3 H\u0110");
		lblMaHD.setBounds(47, 363, 91, 27);
		HoaDon.add(lblMaHD);
		
		JLabel lblMaKH = new JLabel("M\u00E3 KH");
		lblMaKH.setBounds(47, 400, 91, 27);
		HoaDon.add(lblMaKH);
		
		JLabel lblMaNV = new JLabel("M\u00E3 NV");
		lblMaNV.setBounds(47, 438, 91, 27);
		HoaDon.add(lblMaNV);
		
		JLabel lblNgayDatVe = new JLabel("Ng\u00E0y \u0111\u1EB7t v\u00E9");
		lblNgayDatVe.setBounds(47, 479, 91, 27);
		HoaDon.add(lblNgayDatVe);
		
		JLabel lblSoLuong = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblSoLuong.setBounds(47, 517, 91, 27);
		HoaDon.add(lblSoLuong);
		
		JLabel lblThanhTien = new JLabel("Th\u00E0nh ti\u1EC1n");
		lblThanhTien.setBounds(47, 555, 91, 27);
		HoaDon.add(lblThanhTien);
		
		txtMaKH_HD = new JTextField();
		txtMaKH_HD.setBackground(new Color(255, 250, 250));
		txtMaKH_HD.setEditable(false);
		txtMaKH_HD.setColumns(10);
		txtMaKH_HD.setBounds(148, 403, 240, 27);
		HoaDon.add(txtMaKH_HD);
		
		txtMaNV_HD = new JTextField();
		txtMaNV_HD.setBackground(new Color(255, 250, 250));
		txtMaNV_HD.setEditable(false);
		txtMaNV_HD.setColumns(10);
		txtMaNV_HD.setBounds(148, 441, 240, 27);
		HoaDon.add(txtMaNV_HD);
		
		txtNgayDatVe_HD = new JTextField();
		txtNgayDatVe_HD.setBackground(new Color(255, 250, 250));
		txtNgayDatVe_HD.setEditable(false);
		txtNgayDatVe_HD.setColumns(10);
		txtNgayDatVe_HD.setBounds(148, 479, 240, 27);
		HoaDon.add(txtNgayDatVe_HD);
		
		JComboBox cbbTimKiem_HD = new JComboBox();
		cbbTimKiem_HD.setBackground(Color.WHITE);
		cbbTimKiem_HD.setModel(new DefaultComboBoxModel(new String[] {"Tìm Theo", "Mã HĐ", "Mã KH", "Mã NV"}));
		cbbTimKiem_HD.setBounds(408, 325, 91, 27);
		HoaDon.add(cbbTimKiem_HD);
		
		JButton btnTimKiem_HD = new JButton("");
		btnTimKiem_HD.setIcon(new ImageIcon("images/iconSearch.png"));
		btnTimKiem_HD.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTimKiem_HD.setBackground(Color.WHITE);
		btnTimKiem_HD.setBounds(530, 325, 29, 27);
		btnTimKiem_HD.setBorder(new EmptyBorder(0,0,0,0));
		HoaDon.add(btnTimKiem_HD);
		
		JButton btnThem_HD = new JButton("");
		btnThem_HD.setHorizontalAlignment(SwingConstants.LEFT);
		btnThem_HD.setIcon(new ImageIcon("images/icons8-plus-48.png"));
		btnThem_HD.setBackground(Color.WHITE);
		btnThem_HD.setBounds(476, 67, 47, 47);
		btnThem_HD.setBorder(new EmptyBorder(0,0,0,0));
		HoaDon.add(btnThem_HD);
		
		JButton btnXoa_HD = new JButton("");
		btnXoa_HD.setIcon(new ImageIcon("images/icons8-cancel-48.png"));
		btnXoa_HD.setBackground(Color.WHITE);
		btnXoa_HD.setBounds(533, 67, 42, 47);
		btnXoa_HD.setBorder(new EmptyBorder(0,0,0,0));
		HoaDon.add(btnXoa_HD);
		
		txtMaHD_HD = new JTextField();
		txtMaHD_HD.setBackground(new Color(255, 250, 250));
		txtMaHD_HD.setEditable(false);
		txtMaHD_HD.setColumns(10);
		txtMaHD_HD.setBounds(148, 363, 240, 27);
		HoaDon.add(txtMaHD_HD);
		
		txtSoLuongVe = new JTextField();
		txtSoLuongVe.setBackground(new Color(255, 250, 250));
		txtSoLuongVe.setEditable(false);
		txtSoLuongVe.setColumns(10);
		txtSoLuongVe.setBounds(148, 520, 240, 27);
		HoaDon.add(txtSoLuongVe);
		
		txtThanhTien_HD = new JTextField();
		txtThanhTien_HD.setBackground(new Color(255, 250, 250));
		txtThanhTien_HD.setEditable(false);
		txtThanhTien_HD.setColumns(10);
		txtThanhTien_HD.setBounds(148, 558, 240, 27);
		HoaDon.add(txtThanhTien_HD);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 667, 56);
		HoaDon.add(panel);
		panel.setLayout(null);
		
		JButton btnXemToanBoDSCTHD = new JButton("Xem toàn bộ DS CTHD");
		btnXemToanBoDSCTHD.setHorizontalAlignment(SwingConstants.LEFT);
		btnXemToanBoDSCTHD.setIcon(new ImageIcon("images/icons8-document-26.png"));
		btnXemToanBoDSCTHD.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXemToanBoDSCTHD.setBounds(10, 11, 197, 34);
		panel.add(btnXemToanBoDSCTHD);
		btnXemToanBoDSCTHD.setBackground(new Color(255, 255, 255));
		
		JButton btnXuatFile = new JButton("Xuất file");
		btnXuatFile.setIcon(new ImageIcon("images/icons8-export-30.png"));
		btnXuatFile.setHorizontalAlignment(SwingConstants.LEFT);
		btnXuatFile.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXuatFile.setBounds(424, 10, 142, 36);
		panel.add(btnXuatFile);
		btnXuatFile.setBackground(Color.WHITE);
		
		JButton btnCapNhatDSHD = new JButton("C\u1EADp nh\u1EADt DSHD");
		btnCapNhatDSHD.setHorizontalAlignment(SwingConstants.LEFT);
		btnCapNhatDSHD.setIcon(new ImageIcon("images/icons8-refresh-16.png"));
		btnCapNhatDSHD.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCapNhatDSHD.setBounds(235, 11, 164, 34);
		panel.add(btnCapNhatDSHD);
		btnCapNhatDSHD.setBackground(Color.WHITE);
		
		JButton btnReport = new JButton("Report");
		
		btnReport.setBounds(576, 17, 89, 23);
		panel.add(btnReport);
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
		
		JButton btnXemCTHD = new JButton("");
		
		btnXemCTHD.setIcon(new ImageIcon("images/icons8-send-file-48.png"));
		btnXemCTHD.setBackground(Color.WHITE);
		btnXemCTHD.setBounds(585, 67, 42, 47);
		btnXemCTHD.setBorder(new EmptyBorder(0,0,0,0));
		HoaDon.add(btnXemCTHD);
		
		btnXuatFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				file =new File("hoadon.xls");
				xuatFileExcel(tblHoaDon, file);
				JOptionPane.showMessageDialog(null,"Đã xuất ra file excel.");
			}
		});
		
		btnXemToanBoDSCTHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChiTietHDBUS bus=new ChiTietHDBUS();
				bus.docDSCTHD();
				ChiTietHDFRM ct=new ChiTietHDFRM();
				ct.xemToanBoDSCTHD();
			}
		});
		
		btnXemCTHD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i=tblHoaDon.getSelectedRow();
				if(i>=0)
				{
					String mahd=txtMaHD_HD.getText();
					ChiTietHDBUS bus=new ChiTietHDBUS();
					bus.TimKiemTheoMa("MaHD",mahd);
					ChiTietHDFRM ct=new ChiTietHDFRM();
					ct.xemToanBoDSCTHD();
				}
				else JOptionPane.showMessageDialog(null,"Chọn hóa đơn cần xem chi tiết."); 
					
				
				
			}
		});
		btnThem_HD.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				HoaDonFRM2 themhd=new HoaDonFRM2();
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
		
		btnReport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					
				String MaHD=txtMaHD_HD.getText();
				int SL=0;
				int TT=0;
				String MaKH=null;
				String NDV=null;
				String tenKH=null;
				
				try {
					//PropertyConfigurator.configure("log4j.properties");
					JasperReport jasperReport = JasperCompileManager.compileReport("HoaDon.jrxml");
			       // Tham số truyền vào báo cáo.
			       Map<String, Object> parameters = new HashMap<String, Object>();
			 
			       ChiTietHDBUS ctbus = new ChiTietHDBUS();
			       ctbus.docDSCTHD();
			       HoaDonBUS hdbus=new HoaDonBUS();
			       hdbus.docDSHD();
			       KhachHangBUS khbus=new KhachHangBUS();
			       khbus.docDSKH();
			       
			       
			       parameters.put("MaHD",MaHD);
			       for(HoaDonDTO hd : HoaDonBUS.dshd)
			       {
			    	   if(MaHD.equals(hd.getMaHD()))
			    	   {
			    		   SL=hd.getSoLuongVe();
			    		   TT=hd.getThanhTien();
			    		   MaKH=hd.getMaKH();
			    		   NDV=hd.getNgayDatVe();
			    	   }
			       }
			       
			      /* for(KhachHangDTO kh : KhachHangBUS.dskh)
			       {
			    	   if(MaKH.equals(kh.getMaKH()))
			    	   {
			    		   tenKH=kh.getTenKH();
			    	   }
			       }*/
			       //parameters.put("SoLuong",SL);
			       //parameters.put("ThanhTien",TT);
			       parameters.put("NgayDatVe",NDV);
			       parameters.put("NguoiMua",tenKH);
			       // DataSource
			       // Đây là báo cáo đơn giản, không kết nối vào DB
			       // vì vậy không cần nguồn dữ liệu.
			       JRDataSource dataSource = new JREmptyDataSource();
			      MySQLConnect c= new MySQLConnect();
			       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,dataSource);	 
			       // Đảm bảo thư mục đầu ra tồn tại.
			      /* File outDir = new File("report");
			       outDir.mkdirs();*/
			       JasperViewer.viewReport(jasperPrint,false);
			       // Chạy báo cáo và export ra file PDF.
			       JasperExportManager.exportReportToPdfFile(jasperPrint,
			               "report/HoaDon.pdf");
			 
			       System.out.println("Done!");
			       
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		//return HoaDon;
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
