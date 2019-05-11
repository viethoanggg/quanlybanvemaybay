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
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ThemVe extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaVe;
	private JTextField txtMaKHD;
	private JTextField txtTenKHD;
	private JTextField txtVISA;
	private JTextField txtGaDi;
	private JTextField txtGaDen;
	private JTable tblChuyenBay=new JTable();;
	private JTextField txtMaSoGhe;
	private JTextField txtMaGhe;
	DefaultTableModel model=new DefaultTableModel();
	private JTextField txtMG;
	private JTextField txtMaChuyenBay;
	private JTextField txtHang;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemVe frame = new ThemVe();
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
	public ThemVe() {
		
		KhachHangBUS khbus=new KhachHangBUS();
		khbus.docDSKH();
		VeMayBayBUS vbus=new VeMayBayBUS();
		vbus.docDSVMB();
		ChuyenBayBUS cbbus=new ChuyenBayBUS();
		cbbus.docDSChuyenBay();
		MayBayBUS mbbus=new MayBayBUS();
		mbbus.docDSMayBay();
		ChangBUS cbus=new ChangBUS();
		cbus.docDSChang();
		GheBUS gbus=new GheBUS();
		gbus.docDSGhe();		
		HangVeBUS hvbus=new HangVeBUS();
		hvbus.docDSHangVe();
		
		setAutoRequestFocus(false);
		
		setBounds(100, 100, 902, 537);
		setLocationRelativeTo(null);
		setTitle("Thêm vé máy bay.");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Mã vé");
		label.setBounds(137, 23, 74, 30);
		contentPane.add(label);
		
		txtMaVe = new JTextField();
		
		txtMaVe.setColumns(10);
		txtMaVe.setBounds(305, 22, 36, 33);
		contentPane.add(txtMaVe);
		
		JComboBox cbbMaVe = new JComboBox();
		cbbMaVe.setBackground(Color.WHITE);
		
		cbbMaVe.setModel(new DefaultComboBoxModel(new String[] {"TN_", "NN_"}));
		cbbMaVe.setBounds(221, 23, 74, 30);
		contentPane.add(cbbMaVe);
		
		JLabel label_1 = new JLabel("(Nhập số)");
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		label_1.setBounds(342, 23, 61, 27);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Mã KHD");
		label_2.setBounds(492, 23, 76, 29);
		contentPane.add(label_2);
		
		txtMaKHD = new JTextField();
		
		txtMaKHD.setColumns(10);
		txtMaKHD.setBounds(637, 23, 46, 29);
		contentPane.add(txtMaKHD);
		
		JLabel label_3 = new JLabel("KHD_");
		label_3.setBounds(581, 23, 46, 29);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Tên KHD");
		label_4.setBounds(492, 66, 76, 29);
		contentPane.add(label_4);
		
		txtTenKHD = new JTextField();
		txtTenKHD.setEditable(false);
		txtTenKHD.setColumns(10);
		txtTenKHD.setBounds(581, 66, 185, 29);
		contentPane.add(txtTenKHD);
		
		JLabel label_5 = new JLabel("(Nhập số)");
		label_5.setFont(new Font("Tahoma", Font.ITALIC, 10));
		label_5.setBounds(683, 23, 61, 27);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("VISA");
		label_6.setBounds(137, 64, 76, 29);
		contentPane.add(label_6);
		
		txtVISA = new JTextField();
		txtVISA.setEditable(false);
		txtVISA.setColumns(10);
		txtVISA.setBounds(221, 66, 185, 29);
		contentPane.add(txtVISA);
		
		JButton btnDatLai = new JButton("Đặt lai");
		
		btnDatLai.setBackground(Color.WHITE);
		btnDatLai.setBounds(369, 453, 89, 30);
		contentPane.add(btnDatLai);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(Color.WHITE);
		
		btnThem.setBounds(244, 453, 89, 30);
		contentPane.add(btnThem);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.WHITE);
		
		btnThoat.setBounds(492, 453, 89, 30);
		contentPane.add(btnThoat);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 112, 866, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ga đi");
		lblNewLabel.setBounds(47, 11, 86, 25);
		panel.add(lblNewLabel);
		
		txtGaDi = new JTextField();
		txtGaDi.setBounds(132, 11, 193, 25);
		panel.add(txtGaDi);
		txtGaDi.setColumns(10);
		
		JLabel lblGan = new JLabel("Ga đến");
		lblGan.setBounds(394, 11, 86, 25);
		panel.add(lblGan);
		
		txtGaDen = new JTextField();
		txtGaDen.setColumns(10);
		txtGaDen.setBounds(490, 11, 182, 25);
		panel.add(txtGaDen);
		
		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.setBackground(Color.WHITE);
		
		btnTimKiem.setBounds(722, 12, 89, 25);
		panel.add(btnTimKiem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 171, 842, 150);
		contentPane.add(scrollPane);
		
		
		tblChuyenBay.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MaChuyenBay", "MaMayBay", "H\u00E3ng", "TenChangBay", "NgayDi", "NgayDen", "ThoiGianDI", "ThoiGianDen", "SoGheTrong"
			}
		));
		scrollPane.setViewportView(tblChuyenBay);
		
		JLabel lblGh = new JLabel("Mã ghế");
		lblGh.setBounds(526, 389, 55, 30);
		contentPane.add(lblGh);
		
		txtMaSoGhe = new JTextField();
		txtMaSoGhe.setColumns(10);
		txtMaSoGhe.setBounds(693, 389, 36, 30);
		contentPane.add(txtMaSoGhe);
		
		JLabel label_8 = new JLabel("(Nhập số)");
		label_8.setFont(new Font("Tahoma", Font.ITALIC, 10));
		label_8.setBounds(739, 391, 61, 27);
		contentPane.add(label_8);
		
		txtMaGhe = new JTextField("EC");
		txtMaGhe.setEditable(false);
		txtMaGhe.setColumns(10);
		txtMaGhe.setBounds(637, 390, 46, 29);
		contentPane.add(txtMaGhe);
		
		JLabel label_7 = new JLabel("Hạng vé");
		label_7.setBounds(526, 336, 61, 30);
		contentPane.add(label_7);
		
		JComboBox cbbHangVe = new JComboBox();
		cbbHangVe.setBackground(Color.WHITE);
		
		cbbHangVe.setModel(new DefaultComboBoxModel(new String[] {"Economy Class", "Business class", "First Class", "Premium Class"}));
		cbbHangVe.setBounds(592, 336, 174, 30);
		contentPane.add(cbbHangVe);
		
		JLabel lblGimGi = new JLabel("Giảm giá");
		lblGimGi.setBounds(32, 389, 61, 30);
		contentPane.add(lblGimGi);
		
		JComboBox cbbGiamGia = new JComboBox();
		cbbGiamGia.setBackground(Color.WHITE);
		cbbGiamGia.setModel(new DefaultComboBoxModel(new String[] {"0", "10", "20", "50"}));
		cbbGiamGia.setBounds(125, 389, 74, 30);
		contentPane.add(cbbGiamGia);
		
		txtMG = new JTextField();
		txtMG.setEditable(false);
		txtMG.setText("MG");
		txtMG.setBounds(596, 389, 36, 30);
		contentPane.add(txtMG);
		txtMG.setColumns(10);
		
		JLabel lblMChuynBay = new JLabel("Mã chuyến bay");
		lblMChuynBay.setBounds(30, 332, 89, 30);
		contentPane.add(lblMChuynBay);
		
		txtMaChuyenBay = new JTextField();
		txtMaChuyenBay.setBounds(125, 332, 108, 34);
		contentPane.add(txtMaChuyenBay);
		txtMaChuyenBay.setColumns(10);
		
		txtHang = new JTextField();
		txtHang.setColumns(10);
		txtHang.setBounds(370, 332, 108, 34);
		contentPane.add(txtHang);
		
		JLabel lblHng = new JLabel("Hãng");
		lblHng.setBounds(314, 332, 46, 30);
		contentPane.add(lblHng);
		
		JButton btnNewButton = new JButton("Tạo KH mới");
		btnNewButton.setBackground(Color.WHITE);
		
		btnNewButton.setBounds(779, 23, 97, 27);
		contentPane.add(btnNewButton);
//////////////////////////////////////////////////////////////////////////////////////////////////////
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemKH themkh=new ThemKH();
				themkh.setVisible(true);
			}
		});
		cbbMaVe.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(cbbMaVe.getSelectedIndex()==0)
				{
					cbbGiamGia.setEnabled(true);
					
				}
				if(cbbMaVe.getSelectedIndex()==1)
				{
					cbbGiamGia.setEnabled(false);
				}
			}
		});
		
		txtMaVe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String mave=cbbMaVe.getSelectedItem().toString()+txtMaVe.getText();
				int flag=0;
				for(VeMayBayDTO v : VeMayBayBUS.dsvmb)
				{
					if(mave.equals(v.getMaVe()))
					{
						JOptionPane.showMessageDialog(null,"Mã vé bị trùng.");
						flag=1;
					}
				}
				
			}
		});
		
		txtMaKHD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
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
		
		cbbHangVe.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(cbbHangVe.getSelectedIndex()==0)
				{
					txtMaGhe.setText("EC");
					
					
				}
				else if(cbbHangVe.getSelectedIndex()==1)
				{
					txtMaGhe.setText("BC");
					
				}
				else if(cbbHangVe.getSelectedIndex()==2)
				{
					txtMaGhe.setText("FC");
					
				}
				else if(cbbHangVe.getSelectedIndex()==3)
				{
					txtMaGhe.setText("PC");
			
				}
			}
		});
		btnTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model=new DefaultTableModel();
				
				Vector header=new Vector();
				header.add("MaChuyenBay");
				header.add("MaMayBay");
				header.add("Hãng");
				header.add("TenChangBay");
				header.add("NgayDi");
				header.add("NgayDen");
				header.add("ThoiGianDi");
				header.add("ThoiGianDen");
				header.add("SoGheTrong");
				model =new DefaultTableModel(header,0);
				tblChuyenBay.setModel(model);	
				
				String gadi=txtGaDi.getText();
				String gaden=txtGaDen.getText();
				long millis=System.currentTimeMillis();
				Date date=new Date(millis);
				SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
				
				for(ChuyenBayDTO cb: ChuyenBayBUS.dsChuyenBay)
				{
					if(cb.getTenchang().toLowerCase().indexOf(gadi)!=-1 && cb.getTenchang().toLowerCase().lastIndexOf(gaden)!=-1 && cb.getSoghetrong()>0)
					{
						try {
							Date ngaybay=f.parse(cb.getNgaydi());
							if(date.before(ngaybay))
							{
								Vector b=new Vector();
								b.add(cb.getMachuyenbay());
								b.add(cb.getMamaybay());
								for(MayBayDTO mb : MayBayBUS.dsMayBay)
								{
									if(cb.getMamaybay().equals(mb.getMamaybay()))
										b.add(mb.getHang());
								}
								b.add(cb.getTenchang());
								b.add(cb.getNgaydi());
								b.add(cb.getNgayden());
								b.add(cb.getThoigiandi());
								b.add(cb.getThoigianden());
								b.add(cb.getSoghetrong());
								model.addRow(b);
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
					tblChuyenBay.setModel(model);
			}
		});
		tblChuyenBay.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int i=tblChuyenBay.getSelectedRow();
				if(i>=0)
				{
					txtMaChuyenBay.setText(tblChuyenBay.getModel().getValueAt(i,0).toString());
					txtHang.setText(tblChuyenBay.getModel().getValueAt(i, 2).toString());
				}
			}
		});
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//kiem tra ma ve
				
				String mave=cbbMaVe.getSelectedItem().toString()+txtMaVe.getText();
				int flag=0;
				for(VeMayBayDTO v : VeMayBayBUS.dsvmb)
				{
					if(mave.equals(v.getMaVe()))
					{
						JOptionPane.showMessageDialog(null,"Mã vé bị trùng.");
						flag=1;
					}
				}
				if(txtMaVe.getText().equals("")==true)
				{
					JOptionPane.showMessageDialog(null,"Mã vé bị trống.");
					flag=1;
				}
				//kiem tra kh ton tai trong cdsl
				String makh="KHD_"+txtMaKHD.getText();
				for(KhachHangDTO kh: KhachHangBUS.dskh)
				{
					flag=2;
					if(makh.equals(kh.getMaKH()))
					{
						flag=0;
						break;
					}
				}
				if(flag==2)
					JOptionPane.showMessageDialog(null,"Mã khách hàng chưa tồn tại trong cơ sở dữ liệu.");
				if(txtMaChuyenBay.getText().equals("")==true)
				{
					JOptionPane.showMessageDialog(null,"Mã chuyến bay bị trống.");
					flag=1;
				}
				
				//kiem tra ma ghe ton tai trong may bay va da co nguoi dat hay chua
				String maghe="MG"+txtMaGhe.getText()+txtMaSoGhe.getText();
				
				String mamaybay="";
				int i=tblChuyenBay.getSelectedRow();
				if(i>=0)	
						mamaybay=tblChuyenBay.getModel().getValueAt(i,1 ).toString();
				
				for(GheDTO g :GheBUS.dsGhe)
				{
					flag=3;
					if(mamaybay.equals(g.getMamaybay()) && maghe.equals(g.getMaghe()))
					{
						flag=0;
						break;
					}	
				}
				if(flag==3)
					JOptionPane.showMessageDialog(null,"Mã ghế không có trong may bay.");
				if(flag==0)
					for(VeMayBayDTO vmb: VeMayBayBUS.dsvmb)
					{
						
						if(maghe.equals(vmb.getMaGhe()))
						{
							flag=4;
							break;
						}
					}
				if(flag==4)
					JOptionPane.showMessageDialog(null,"Mã ghế đã có người đặt.");
				if(txtMaSoGhe.getText().equals("")==true)
				{
					JOptionPane.showMessageDialog(null,"Mã ghế bị trống.");
					flag=1;
				}
				
				//them ve
				if(flag==0)
				{
					VeMayBayDTO vmb =new VeMayBayDTO();
					vmb.setMaVe(mave);
					vmb.setMaKH(makh);
					vmb.setMaCB(txtMaChuyenBay.getText());
					vmb.setTenHangVe(cbbHangVe.getItemAt(cbbHangVe.getSelectedIndex()).toString());
					
					vmb.setMaGhe(maghe);
					vmb.setHang(txtHang.getText());
					if(cbbMaVe.getSelectedIndex()==1)
						vmb.setVisa(txtVISA.getText());
					else 
						vmb.setVisa("");
					if(cbbMaVe.getSelectedIndex()==0)
						vmb.setGiaTriGiam(Integer.valueOf(cbbGiamGia.getItemAt(cbbGiamGia.getSelectedIndex()).toString()));
					if(cbbMaVe.getSelectedIndex()==1)
						vmb.setGiaTriGiam(Integer.valueOf("0"));
					int giachang=0;
					int giahangve=0;
					for(ChuyenBayDTO cb : ChuyenBayBUS.dsChuyenBay)
					{
						if(vmb.getMaCB().equals(cb.getMachuyenbay()))
						{
							String chang=cb.getMachang();
							for(ChangDTO c:ChangBUS.dsChang)
							{
								if(chang.equals(c.getMachang()))
								{
									giachang=c.getGia();
									break;
								}
							}
						}
					}
					
					for(HangVeDTO hv : HangVeBUS.dshv)
					{
						if(vmb.getTenHangVe().equals(hv.getTenHangVe()))
							giahangve=hv.getGiaHangVe();
					}
					
					int giave=giachang+giahangve;
					
					if(cbbMaVe.getSelectedIndex()==0)
						giave=giave-(giave*(Integer.valueOf(cbbGiamGia.getItemAt(cbbGiamGia.getSelectedIndex()).toString()))/100);
					vmb.setGiaVe(giave);
					
					VeMayBayBUS bus=new VeMayBayBUS();
					bus.them(vmb);
					cbbus.capnhatSoGheTrong();
					JOptionPane.showMessageDialog(null,"Đã thêm vé.");
				}
			}
		});
		btnThoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnDatLai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
