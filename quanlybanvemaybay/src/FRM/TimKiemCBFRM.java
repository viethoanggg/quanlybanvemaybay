package FRM;
import BUS.*;
import DAO.*;
import DTO.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;
import lu.tudor.santec.jtimechooser.JTimeChooser;
import lu.tudor.santec.jtimechooser.TimeChangedEvent;
import javax.swing.JComponent;
import java.util.Date;
import lu.tudor.santec.jtimechooser.TimeChooserHandler;
import lu.tudor.santec.jtimechooser.TimeChooserModel;
import java.awt.event.MouseWheelListener;
import java.sql.Time;
import java.awt.event.MouseWheelEvent;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TimKiemCBFRM extends JFrame {

	private static JPanel contentPane;
	private JTable tblChuyenBay=new JTable();
	static JTextField txtTimMaMayBay;
	static JTextField txtTimMaChuyenBay;
	private JTextField txtThoiGianDiTu;
	private JTextField txtChang;
	private JTextField txtTimMaChang;
	private JTextField txtThoiGianDiDen;
	private JComboBox cbbTimMaMayBay,cbbTimMaChuyenBay,cbbTimMaChang,cbbTimChang;
	private DefaultTableModel model=new DefaultTableModel();
	private DefaultTableModel model1=new DefaultTableModel();
	private Vector header,row,dataMaMayBay,dataMaChuyenBay,dataMaChang,dataChang;
	private static JDateChooser dcNgayDiTu;
	private static JDateChooser dcNgayDiDen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemCBFRM frame = new TimKiemCBFRM();
					frame.setLocationRelativeTo(null);
					
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
	public TimKiemCBFRM() {
		ChangBUS bus1=new ChangBUS();
		bus1.docDSChang();
		MayBayBUS bus2=new MayBayBUS();
		bus2.docDSMayBay();
		header=new Vector();
		header.add("Mã máy bay");
		header.add("Mã chuyến bay");
		header.add("Mã chặng");
		header.add("Thời gian đi");
		header.add("Thời gian đến");
		header.add("Ngày đi");
		header.add("Ngày đến");
		header.add("Số ghế trống");
		header.add("Tên chặng");
		if(model.getRowCount()==0)
			{model =new DefaultTableModel(header,0);}
		ChuyenBayBUS bus=new ChuyenBayBUS();
		bus.docDSChuyenBay();
		int i=0;
		dataMaMayBay=new Vector();
		dataMaChuyenBay=new Vector();
		dataMaChang=new Vector();
		dataChang=new Vector();
		for(ChuyenBayDTO cb: ChuyenBayBUS.dsChuyenBay)
		{
			row=new Vector();
			row.add(cb.getMamaybay());
			row.add(cb.getMachuyenbay());
			row.add(cb.getMachang());
			row.add(cb.getThoigiandi());
			row.add(cb.getThoigianden());
			row.add(cb.getNgaydi());
			row.add(cb.getNgayden());
			row.add(cb.getSoghetrong());
			row.add(cb.getTenchang());
			model.addRow(row);
			dataMaChuyenBay.add(cb.getMachuyenbay());
			
			
		}
		
		tblChuyenBay.setModel(model);
		
		for(ChangDTO c: ChangBUS.dsChang)
		{
			dataMaChang.add(c.getMachang());
			dataChang.add(c.getTenchang());
		}
		for(MayBayDTO mb: MayBayBUS.dsMayBay)
		{
			
			dataMaMayBay.add(mb.getMamaybay());
		}
		
		
		setBounds(100, 100, 1338, 710);
		setLocationRelativeTo(null);
		setTitle("Tìm kiếm chuyến bay");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 36, 1267, 285);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(tblChuyenBay);
		
		cbbTimChang = new JComboBox();
		cbbTimChang.setModel(new DefaultComboBoxModel(dataChang));
		cbbTimChang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i=cbbTimChang.getSelectedIndex();
				if(i>=0)
				{
					txtChang.setText(cbbTimChang.getItemAt(i).toString());
				}
			}
		});
		cbbTimChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbTimChang.setBounds(433, 449, 201, 31);
		contentPane.add(cbbTimChang);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChuyenBayBUS bus=new ChuyenBayBUS();
				bus.docDSChuyenBay();
				bus.capnhatSoGheTrong();
				model1=new DefaultTableModel();
				header=new Vector();
				header.add("Mã máy bay");
				header.add("Mã chuyến bay");
				header.add("Mã chặng");
				header.add("Thời gian đi");
				header.add("Thời gian đến");
				header.add("Ngày đi");
				header.add("Ngày đến");
				header.add("Số ghế trống");
				header.add("Tên chặng");
				if(model1.getRowCount()==0)
					{model1 =new DefaultTableModel(header,0);}
				for(ChuyenBayDTO cb: ChuyenBayBUS.dsChuyenBay)
				{
					row=new Vector();
					row.add(cb.getMamaybay());
					row.add(cb.getMachuyenbay());
					row.add(cb.getMachang());
					row.add(cb.getThoigiandi());
					row.add(cb.getThoigianden());
					row.add(cb.getNgaydi());
					row.add(cb.getNgayden());
					row.add(cb.getSoghetrong());
					row.add(cb.getTenchang());
					model1.addRow(row);
					
				}
				tblChuyenBay.setModel(model1);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(433, 505, 89, 31);
		contentPane.add(btnReset);
		
		ButtonGroup timkiemGroup=new ButtonGroup();
		
		JLabel lblThoiGianDiTu = new JLabel("Thời gian đi từ");
		lblThoiGianDiTu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThoiGianDiTu.setBounds(38, 357, 108, 20);
		contentPane.add(lblThoiGianDiTu);
		
		JLabel lblThoiGianDiDen = new JLabel("Thời gian đi đến");
		lblThoiGianDiDen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThoiGianDiDen.setBounds(38, 404, 108, 20);
		contentPane.add(lblThoiGianDiDen);
		
		JLabel lblNgayDiTu = new JLabel("Ngày đi từ");
		lblNgayDiTu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayDiTu.setBounds(435, 352, 108, 20);
		contentPane.add(lblNgayDiTu);
		
		txtThoiGianDiTu = new JTextField();
		txtThoiGianDiTu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtThoiGianDiTu.setColumns(10);
		txtThoiGianDiTu.setBounds(145, 352, 148, 31);
		contentPane.add(txtThoiGianDiTu);
		
		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setForeground(UIManager.getColor("Button.focus"));
		pnTimKiem.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm c\u01A1 b\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		((TitledBorder) pnTimKiem.getBorder()).setTitleFont(new Font("Arial", Font.ITALIC, 16));
		pnTimKiem.setBounds(747, 347, 547, 298);
		contentPane.add(pnTimKiem);
		pnTimKiem.setLayout(null);
		
		JRadioButton rdbtnMaMayBay = new JRadioButton("Mã máy bay");
		rdbtnMaMayBay.setBounds(96, 35, 109, 23);
		pnTimKiem.add(rdbtnMaMayBay);
		rdbtnMaMayBay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnMaMayBay.isSelected()==true)
					cbbTimMaMayBay.setEditable(true);
					txtTimMaMayBay.setEditable(true);
					
					
					cbbTimMaChuyenBay.setEditable(false);
					txtTimMaChuyenBay.setEditable(false);
					
					cbbTimMaChang.setEditable(false);
					txtTimMaChang.setEditable(false);
					
			}
		});
		rdbtnMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		timkiemGroup.add(rdbtnMaMayBay);
		timkiemGroup.add(rdbtnMaMayBay);
		
		JRadioButton rdbtnMaChuyenBay = new JRadioButton("Mã chuyến bay");
		rdbtnMaChuyenBay.setBounds(220, 35, 121, 23);
		pnTimKiem.add(rdbtnMaChuyenBay);
		rdbtnMaChuyenBay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnMaChuyenBay.isSelected()==true)
					cbbTimMaMayBay.setEditable(false);
					txtTimMaMayBay.setEditable(false);
					
					
					cbbTimMaChuyenBay.setEditable(true);
					txtTimMaChuyenBay.setEditable(true);
					
					cbbTimMaChang.setEditable(false);
					txtTimMaChang.setEditable(false);
					
			}
		});
		rdbtnMaChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		timkiemGroup.add(rdbtnMaChuyenBay);
		timkiemGroup.add(rdbtnMaChuyenBay);
		
			cbbTimMaMayBay = new JComboBox();
			cbbTimMaMayBay.setBounds(394, 82, 103, 31);
			pnTimKiem.add(cbbTimMaMayBay);
			cbbTimMaMayBay.setModel(new DefaultComboBoxModel(dataMaMayBay));
			cbbTimMaMayBay.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int i=cbbTimMaMayBay.getSelectedIndex();
					if(i>=0)
					{
						
						txtTimMaMayBay.setText(cbbTimMaMayBay.getItemAt(i).toString());
					}
				}
			});
			cbbTimMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		txtTimMaMayBay = new JTextField();
		txtTimMaMayBay.setBounds(238, 82, 148, 31);
		pnTimKiem.add(txtTimMaMayBay);
		txtTimMaMayBay.setEditable(false);
		txtTimMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimMaMayBay.setColumns(10);
		
		JLabel lblTimMaMayBay = new JLabel("Nhập mã máy bay cần tìm :");
		lblTimMaMayBay.setBounds(57, 82, 171, 31);
		pnTimKiem.add(lblTimMaMayBay);
		lblTimMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
			cbbTimMaChuyenBay = new JComboBox();
			cbbTimMaChuyenBay.setBounds(394, 132, 103, 31);
			pnTimKiem.add(cbbTimMaChuyenBay);
			cbbTimMaChuyenBay.setModel(new DefaultComboBoxModel(dataMaChuyenBay));
			cbbTimMaChuyenBay.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					int i=cbbTimMaChuyenBay.getSelectedIndex();
					if(i>=0)
					{
						txtTimMaChuyenBay.setText(cbbTimMaChuyenBay.getItemAt(i).toString());
					}
				}
			});
			cbbTimMaChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		txtTimMaChuyenBay = new JTextField();
		txtTimMaChuyenBay.setBounds(238, 132, 148, 31);
		pnTimKiem.add(txtTimMaChuyenBay);
		txtTimMaChuyenBay.setEditable(false);
		txtTimMaChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimMaChuyenBay.setColumns(10);
		
		JLabel lblTimMaChuyenBay = new JLabel("Nhập mã chuyến bay cần tìm :");
		lblTimMaChuyenBay.setBounds(38, 132, 190, 31);
		pnTimKiem.add(lblTimMaChuyenBay);
		lblTimMaChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JRadioButton rdbtnMaChang = new JRadioButton("Mã chặng");
		rdbtnMaChang.setBounds(361, 35, 109, 23);
		pnTimKiem.add(rdbtnMaChang);
		rdbtnMaChang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnMaChang.isSelected()==true)
					cbbTimMaMayBay.setEditable(false);
					txtTimMaMayBay.setEditable(false);
					
					
					cbbTimMaChuyenBay.setEditable(false);
					txtTimMaChuyenBay.setEditable(false);
					
					cbbTimMaChang.setEditable(true);
					txtTimMaChang.setEditable(true);
					
			}
		});
		rdbtnMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		timkiemGroup.add(rdbtnMaChang);
		
		cbbTimMaChang = new JComboBox();
		cbbTimMaChang.setBounds(394, 186, 103, 31);
		pnTimKiem.add(cbbTimMaChang);
		cbbTimMaChang.setModel(new DefaultComboBoxModel(dataMaChang));
		cbbTimMaChang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i=cbbTimMaChang.getSelectedIndex();
				if(i>=0)
				{
					txtTimMaChang.setText(cbbTimMaChang.getItemAt(i).toString());
				}
			}
		});
		cbbTimMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtTimMaChang = new JTextField();
		txtTimMaChang.setBounds(238, 186, 148, 31);
		pnTimKiem.add(txtTimMaChang);
		txtTimMaChang.setEditable(false);
		txtTimMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimMaChang.setColumns(10);
		
		JLabel lblTimMaChang = new JLabel("Nhập mã chặng cần tìm :");
		lblTimMaChang.setBounds(73, 186, 155, 31);
		pnTimKiem.add(lblTimMaChang);
		lblTimMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(238, 242, 89, 31);
		pnTimKiem.add(btnTimKiem);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMaMayBay.isSelected()==true)
				{
				String mamaybay=txtTimMaMayBay.getText();
				model=new DefaultTableModel();
				header=new Vector();
				header.add("Mã máy bay");
				header.add("Mã chuyến bay");
				header.add("Mã chặng");
				header.add("Thời gian đi");
				header.add("Thời gian đến");
				header.add("Ngày đi");
				header.add("Ngày đến");
				header.add("Số ghế trống");
				header.add("Tên chặng");
				if(model.getRowCount()==0)
					{model =new DefaultTableModel(header,0);}
				for(ChuyenBayDTO cb: ChuyenBayBUS.dsChuyenBay)
				{
					if(cb.getMamaybay().equals(mamaybay))
					{		
							row=new Vector();
							row.add(cb.getMamaybay());
							row.add(cb.getMachuyenbay());
							row.add(cb.getMachang());
							row.add(cb.getThoigiandi());
							row.add(cb.getThoigianden());
							row.add(cb.getNgaydi());
							row.add(cb.getNgayden());
							row.add(cb.getSoghetrong());
							row.add(cb.getTenchang());
							model.addRow(row);
					}
				}
				tblChuyenBay.setModel(model);
				}
				if(rdbtnMaChuyenBay.isSelected()==true)
				{
				String machuyenbay=txtTimMaChuyenBay.getText();
				
				model=new DefaultTableModel();
				header=new Vector();
				header.add("Mã máy bay");
				header.add("Mã chuyến bay");
				header.add("Mã chặng");
				header.add("Thời gian đi");
				header.add("Thời gian đến");
				header.add("Ngày đi");
				header.add("Ngày đến");
				header.add("Số ghế trống");
				if(model.getRowCount()==0)
					{model =new DefaultTableModel(header,0);}
				for(ChuyenBayDTO cb: ChuyenBayBUS.dsChuyenBay)
				{
					if(cb.getMachuyenbay().equals(machuyenbay))
					{
							
							row=new Vector();
							row.add(cb.getMamaybay());
							row.add(cb.getMachuyenbay());
							row.add(cb.getMachang());
							row.add(cb.getThoigiandi());
							row.add(cb.getThoigianden());
							row.add(cb.getNgaydi());
							row.add(cb.getNgayden());
							row.add(cb.getSoghetrong());
							model.addRow(row);
					}
				}
				tblChuyenBay.setModel(model);
				}
				if(rdbtnMaChang.isSelected()==true)
				{
				String machang=txtTimMaChang.getText();
				
				model=new DefaultTableModel();
				header=new Vector();
				header.add("Mã máy bay");
				header.add("Mã chuyến bay");
				header.add("Mã chặng");
				header.add("Thời gian đi");
				header.add("Thời gian đến");
				header.add("Ngày đi");
				header.add("Ngày đến");
				header.add("Số ghế trống");
				header.add("Tên chặng");
				if(model.getRowCount()==0)
					{model =new DefaultTableModel(header,0);}
				for(ChuyenBayDTO cb: ChuyenBayBUS.dsChuyenBay)
				{
					if(cb.getMachang().equals(machang))
					{
							
							row=new Vector();
							row.add(cb.getMamaybay());
							row.add(cb.getMachuyenbay());
							row.add(cb.getMachang());
							row.add(cb.getThoigiandi());
							row.add(cb.getThoigianden());
							row.add(cb.getNgaydi());
							row.add(cb.getNgayden());
							row.add(cb.getSoghetrong());
							row.add(cb.getTenchang());
							model.addRow(row);
					}
				}
				tblChuyenBay.setModel(model);
				}
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		dcNgayDiTu = new JDateChooser();
		dcNgayDiTu.setBounds(529, 347, 154, 31);
		contentPane.add(dcNgayDiTu);
		
		dcNgayDiDen = new JDateChooser();
		dcNgayDiDen.setBounds(529, 393, 154, 31);
		contentPane.add(dcNgayDiDen);
		
		timkiemGroup=new ButtonGroup();
		
		JLabel lblNgayDiDen = new JLabel("Ngày đi đến");
		lblNgayDiDen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayDiDen.setBounds(435, 398, 108, 20);
		contentPane.add(lblNgayDiDen);
		
		txtThoiGianDiDen = new JTextField();
		txtThoiGianDiDen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtThoiGianDiDen.setColumns(10);
		txtThoiGianDiDen.setBounds(145, 404, 148, 31);
		contentPane.add(txtThoiGianDiDen);
		
		JTimeChooser GioDi = new JTimeChooser();
		GioDi.getTimeField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtThoiGianDiTu.setText(GioDi.getFormatedTime().toString());
			}
		});
		GioDi.getTimeField().addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				txtThoiGianDiTu.setText(GioDi.getFormatedTime().toString());
			}
		});
		GioDi.getTimeField().setFont(new Font("Tahoma", Font.PLAIN, 11));
		GioDi.setBounds(303, 357, 51, 20);
		contentPane.add(GioDi);
		
		JTimeChooser GioDen = new JTimeChooser();
		GioDen.getTimeField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtThoiGianDiTu.setText(GioDen.getFormatedTime().toString());
			}
		});
		GioDen.getTimeField().addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				txtThoiGianDiTu.setText(GioDen.getFormatedTime().toString());
			}
		});
		GioDen.getTimeField().setFont(new Font("Tahoma", Font.PLAIN, 11));
		GioDen.setBounds(303, 409, 51, 20);
		contentPane.add(GioDen);
		
		JLabel lblChang = new JLabel("Chặng");
		lblChang.setBounds(163, 454, 49, 20);
		contentPane.add(lblChang);
		lblChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtChang = new JTextField();
		txtChang.setBounds(214, 449, 209, 31);
		contentPane.add(txtChang);
		txtChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtChang.setColumns(10);
		
		JButton btnTimKiemNC = new JButton("Tìm kiếm");
		btnTimKiemNC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
				String a="";
				String b="";
				int flag=0;
				try {
					if(dcNgayDiTu.getDate()!=null )
						a=f.format(dcNgayDiTu.getDate());
					if(dcNgayDiDen.getDate()!=null )
						b=f.format(dcNgayDiDen.getDate());
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Ngày tháng nhập không hợp lệ");
				}
				
				if(flag==0 && dcNgayDiTu.getDate()!=null && dcNgayDiDen.getDate()!=null && dcNgayDiTu.getDate().compareTo(dcNgayDiDen.getDate())>0)
				{
					JOptionPane.showMessageDialog(null,"Khoảng ngày nhập không hợp lệ");
					flag=1;
				}
				if(flag==0)
				{
				
					ChuyenBayBUS bus=new ChuyenBayBUS();
					bus.timkiemtheongay(a,b);
					model=new DefaultTableModel();
					header=new Vector();
					header.add("Mã máy bay");
					header.add("Mã chuyến bay");
					header.add("Mã chặng");
					header.add("Thời gian đi");
					header.add("Thời gian đến");
					header.add("Ngày đi");
					header.add("Ngày đến");
					header.add("Số ghế trống");
					header.add("Tên chặng");
					if(model.getRowCount()==0)
						{model =new DefaultTableModel(header,0);}
					tblChuyenBay.setModel(model);
					
					for(ChuyenBayDTO cb: ChuyenBayBUS.dsChuyenBay)
					{							
								row=new Vector();
								row.add(cb.getMamaybay());
								row.add(cb.getMachuyenbay());
								row.add(cb.getMachang());
								row.add(cb.getThoigiandi());
								row.add(cb.getThoigianden());
								row.add(cb.getNgaydi());
								row.add(cb.getNgayden());
								row.add(cb.getSoghetrong());
								row.add(cb.getTenchang());
								model.addRow(row);
								
					}
					tblChuyenBay.setModel(model);
				}
			}
		});
		btnTimKiemNC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiemNC.setBounds(313, 505, 89, 31);
		contentPane.add(btnTimKiemNC);
		tblChuyenBay.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				int i=tblChuyenBay.getSelectedRow();
				if(i>=0)
				{
					txtThoiGianDiTu.setText(tblChuyenBay.getModel().getValueAt(i,3).toString());
					txtThoiGianDiDen.setText(tblChuyenBay.getModel().getValueAt(i,4).toString());
					//Time giodi=new Time("HH:mm:ss");
					SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date ngaydi=f.parse(tblChuyenBay.getModel().getValueAt(i, 5).toString());
						dcNgayDiTu.setDate(ngaydi);
						Date ngayden=f.parse(tblChuyenBay.getModel().getValueAt(i, 6).toString());
						dcNgayDiDen.setDate(ngayden);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
					
			}
		});
		
		}
	
	/*public void actionPerformed(ActionEvent arg0) {
		
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
	
});*/
}
