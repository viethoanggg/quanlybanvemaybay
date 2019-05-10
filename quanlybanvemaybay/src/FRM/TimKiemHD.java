package FRM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import BUS.ChiTietHDBUS;
import BUS.HoaDonBUS;
import DTO.HoaDonDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class TimKiemHD extends JFrame {

	private JPanel contentPane;
	private JTable tblHoaDon;
	private JTextField txtTimKiemHD=new JTextField("");
	private JTextField txtTKNC_NgayDatVeTu=new JTextField("");
	private JTextField txtTKNC_NgayDatVeDen=new JTextField("");
	private JTextField txtTKNC_GiaTu=new JTextField("");
	private JTextField txtTKNC_GiaDen=new JTextField("");
	private JTextField txtNamQuy=new JTextField("");
	DefaultTableModel model=new DefaultTableModel();
	private File file;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemHD frame = new TimKiemHD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public void setTable() 
	{
		HoaDonBUS bus=new HoaDonBUS();
		if(HoaDonBUS.dshd==null) bus.docDSHD();
		
		newTableHD();
		newDataModel();
	}
	public JPanel TimKiemHD() {
		/*setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 585);*/
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	//	setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 649, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnXuatFile = new JButton("Xuất file");
		btnXuatFile.setIcon(new ImageIcon("images/icons8-export-30.png"));
		btnXuatFile.setHorizontalAlignment(SwingConstants.LEFT);
		btnXuatFile.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXuatFile.setBackground(Color.WHITE);
		btnXuatFile.setBounds(497, 11, 142, 36);
		panel.add(btnXuatFile);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 629, 186);
		contentPane.add(scrollPane);
		
		tblHoaDon = new JTable();
		tblHoaDon.setForeground(Color.BLACK);
		tblHoaDon.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tblHoaDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setViewportView(tblHoaDon);
		
		JLabel label = new JLabel("Tìm Kiếm");
		label.setBounds(58, 328, 91, 27);
		contentPane.add(label);
		
		txtTimKiemHD = new JTextField();
		txtTimKiemHD.setColumns(10);
		txtTimKiemHD.setBounds(159, 328, 240, 27);
		contentPane.add(txtTimKiemHD);
		
		JComboBox cbbTimKiem_HD = new JComboBox();
		cbbTimKiem_HD.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo", "MaHD", "MaKH", "MaNV"}));
		cbbTimKiem_HD.setBackground(Color.WHITE);
		cbbTimKiem_HD.setBounds(419, 328, 91, 27);
		contentPane.add(cbbTimKiem_HD);
		
		JButton btnTimKiem_HD = new JButton("");
		btnTimKiem_HD.setIcon(new ImageIcon("images/iconSearch.png"));
		btnTimKiem_HD.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTimKiem_HD.setBorder(new EmptyBorder(0,0,0,0));
		btnTimKiem_HD.setBackground(Color.WHITE);
		btnTimKiem_HD.setBounds(541, 328, 29, 27);
		contentPane.add(btnTimKiem_HD);
		
		JButton btnXemCTHD = new JButton("");
		btnXemCTHD.setIcon(new ImageIcon("images/icons8-send-file-48.png"));
		btnXemCTHD.setBorder(new EmptyBorder(0,0,0,0));
		btnXemCTHD.setBackground(Color.WHITE);
		btnXemCTHD.setBounds(603, 68, 36, 47);
		contentPane.add(btnXemCTHD);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm n\u00E2ng cao", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 366, 629, 168);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u1EDDi gian", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Th\u1EDDi gian", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 23, 432, 61);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblT = new JLabel("Từ");
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblT.setBounds(10, 22, 35, 28);
		panel_2.add(lblT);
		
		txtTKNC_NgayDatVeTu = new JTextField();
		txtTKNC_NgayDatVeTu.setBounds(55, 22, 143, 28);
		panel_2.add(txtTKNC_NgayDatVeTu);
		txtTKNC_NgayDatVeTu.setColumns(10);
		
		txtTKNC_NgayDatVeDen = new JTextField();
		txtTKNC_NgayDatVeDen.setColumns(10);
		txtTKNC_NgayDatVeDen.setBounds(278, 22, 144, 28);
		panel_2.add(txtTKNC_NgayDatVeDen);
		
		JLabel lbln = new JLabel("Đến");
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbln.setBounds(233, 22, 35, 28);
		panel_2.add(lbln);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "S\u1ED1 ti\u1EC1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 94, 432, 63);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("Từ");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 24, 35, 28);
		panel_3.add(label_1);
		
		txtTKNC_GiaTu = new JTextField();
		txtTKNC_GiaTu.setColumns(10);
		txtTKNC_GiaTu.setBounds(55, 24, 143, 28);
		panel_3.add(txtTKNC_GiaTu);
		
		JLabel label_2 = new JLabel("Đến");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(233, 24, 35, 28);
		panel_3.add(label_2);
		
		txtTKNC_GiaDen = new JTextField();
		txtTKNC_GiaDen.setColumns(10);
		txtTKNC_GiaDen.setBounds(278, 24, 144, 28);
		panel_3.add(txtTKNC_GiaDen);
		
		JButton btnTimKiemNangCao_Left = new JButton("");
		
		btnTimKiemNangCao_Left.setIcon(new ImageIcon("images/iconSearch.png"));
		btnTimKiemNangCao_Left.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTimKiemNangCao_Left.setBorder(new EmptyBorder(0,0,0,0));
		btnTimKiemNangCao_Left.setBackground(Color.WHITE);
		btnTimKiemNangCao_Left.setBounds(440, 119, 29, 27);
		panel_1.add(btnTimKiemNangCao_Left);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Qu\u00FD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(491, 23, 128, 134);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JComboBox cbbQuy = new JComboBox();
		cbbQuy.setModel(new DefaultComboBoxModel(new String[] {"Quý", "1", "2", "3", "4"}));
		cbbQuy.setBackground(Color.WHITE);
		cbbQuy.setBounds(10, 22, 108, 28);
		panel_4.add(cbbQuy);
		
		txtNamQuy = new JTextField();
		txtNamQuy.setBounds(10, 95, 78, 28);
		panel_4.add(txtNamQuy);
		txtNamQuy.setColumns(10);
		
		JLabel lblNm = new JLabel("Năm");
		lblNm.setBounds(10, 61, 53, 23);
		panel_4.add(lblNm);
		
		JButton btnTimKiemNangCao_Right = new JButton("");
		btnTimKiemNangCao_Right.setIcon(new ImageIcon("images/iconSearch.png"));
		btnTimKiemNangCao_Right.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTimKiemNangCao_Right.setBorder(new EmptyBorder(0,0,0,0));
		btnTimKiemNangCao_Right.setBackground(Color.WHITE);
		btnTimKiemNangCao_Right.setBounds(89, 96, 29, 27);
		panel_4.add(btnTimKiemNangCao_Right);
		
		setTable();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
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
		
			btnTimKiemNangCao_Left.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
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
					if(flag==0 && ngayDatVeTu!=null && ngayDatVeDen!=null && ngayDatVeTu.compareTo(ngayDatVeDen)>0)
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
					if(txtTKNC_NgayDatVeTu.getText().equals("")==true && txtTKNC_NgayDatVeDen.getText().equals("")==true && txtTKNC_GiaTu.getText().equals("")==true && txtTKNC_GiaDen.getText().equals("")==true)
							flag=1;
					if(flag==0)
					{
						newTableHD();
						HoaDonBUS bus=new HoaDonBUS();
						bus.timKiemNangCao(txtTKNC_NgayDatVeTu.getText(),txtTKNC_NgayDatVeDen.getText(),txtTKNC_GiaTu.getText(),txtTKNC_GiaDen.getText());
						newDataModel();
					}
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
			btnXemCTHD.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int i=tblHoaDon.getSelectedRow();
					if(i>=0)
					{
						String mahd=tblHoaDon.getModel().getValueAt(i,0).toString();
						ChiTietHDBUS bus=new ChiTietHDBUS();
						bus.TimKiemTheoMa("MaHD",mahd);
						ChiTietHDFRM ct=new ChiTietHDFRM();
						ct.xemToanBoDSCTHD();
					}
					else JOptionPane.showMessageDialog(null,"Chọn hóa đơn cần xem chi tiết."); 
						
					
					
				}
			});
			btnTimKiemNangCao_Right.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						int i=cbbQuy.getSelectedIndex();
						String nam=txtNamQuy.getText();
						String quytu="";
						String quyden="";
						HoaDonBUS bus=new HoaDonBUS();
						if(i>0)
						{
							
							if(i==1 && nam.equals("")==false)
							{
								quytu=nam+"-01-01";
								quyden=nam+"-03-01";
								bus.timkiemtheoquy(quytu,quyden);
							}
							if(i==2 && nam.equals("")==false)
							{
								quytu=nam+"-04-01";
								quyden=nam+"-06-01";
								bus.timkiemtheoquy(quytu,quyden);
							}
							if(i==3 && nam.equals("")==false)
							{
								quytu=nam+"-07-01";
								quyden=nam+"-09-01";
								bus.timkiemtheoquy(quytu,quyden);
							}
							if(i==4 && nam.equals("")==false)
							{
								quytu=nam+"-10-01";
								quyden=nam+"-12-01";
								bus.timkiemtheoquy(quytu,quyden);
							}
							setTable();
						}
						else JOptionPane.showMessageDialog(null,"Hãy chọn quý.");
						
						if(nam.equals("")==true)
							JOptionPane.showMessageDialog(null,"Hãy nhập năm.");
							
					}
				
			});
			
			return contentPane;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////	
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
