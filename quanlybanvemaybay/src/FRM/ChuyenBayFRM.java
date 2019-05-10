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

public class ChuyenBayFRM extends JFrame {

	private static JPanel contentPane;
	private JTable tblChuyenBay=new JTable();
	private JTextField txtMaChang;
	private JTextField txtMaMayBay;
	private JTextField txtMaChuyenBay;
	static JTextField txtTimMaMayBay;
	static JTextField txtTimMaChuyenBay;
	private JTextField txtThoiGianDi;
	private JTextField txtChang;
	private JTextField txtTimMaChang;
	private JTextField txtThoiGianDen;
	private JComboBox cbbTimMaMayBay,cbbTimMaChuyenBay,cbbTimMaChang;
	private DefaultTableModel model=new DefaultTableModel();
	private DefaultTableModel model1=new DefaultTableModel();
	private Vector header,row,dataMaMayBay,dataMaChuyenBay,dataMaChang;
	private JDateChooser dcNgayDi,dcNgayDen;
	private JTextField txtSoGheTrong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChuyenBayFRM frame = new ChuyenBayFRM();
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
	public ChuyenBayFRM() {
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
		}
		for(MayBayDTO mb: MayBayBUS.dsMayBay)
		{
			
			dataMaMayBay.add(mb.getMamaybay());
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1338, 849);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 36, 1267, 285);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(tblChuyenBay);
		
		JLabel lblMaMayBay = new JLabel("Mã máy bay");
		lblMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaMayBay.setBounds(27, 352, 108, 20);
		contentPane.add(lblMaMayBay);
		
		JLabel lblMaChuyenBay = new JLabel("Mã chuyến bay");
		lblMaChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaChuyenBay.setBounds(27, 406, 108, 20);
		contentPane.add(lblMaChuyenBay);
		
		JComboBox cbbThemMaMayBay = new JComboBox();
		cbbThemMaMayBay.setModel(new DefaultComboBoxModel(dataMaMayBay));
		cbbThemMaMayBay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i=cbbThemMaMayBay.getSelectedIndex();
				if(i>=0)
				{
					txtMaMayBay.setText(cbbThemMaMayBay.getItemAt(i).toString());
				}
			}
		});
		cbbThemMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThemMaMayBay.setBounds(285, 347, 84, 31);
		contentPane.add(cbbThemMaMayBay);
		
		txtMaMayBay = new JTextField();
		txtMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaMayBay.setColumns(10);
		txtMaMayBay.setBounds(127, 347, 148, 31);
		contentPane.add(txtMaMayBay);
		
		txtMaChuyenBay = new JTextField();
		txtMaChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaChuyenBay.setColumns(10);
		txtMaChuyenBay.setBounds(127, 401, 148, 31);
		contentPane.add(txtMaChuyenBay);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				String mcb=txtMaChang.getText();
				for(ChuyenBayDTO cb : ChuyenBayBUS.dsChuyenBay)
				{
					if(mcb.equals(cb.getMachang()))
						JOptionPane.showMessageDialog(null,"Mã chặng bị trùng ");
					flag=1;
				}
				if(flag==0)
				{
				JOptionPane.showMessageDialog(null,"Thêm thành công");
				ChuyenBayDTO cb=new ChuyenBayDTO();
				cb.setMamaybay(txtMaMayBay.getText());
				cb.setMachuyenbay(txtMaChuyenBay.getText());
				cb.setMachang(txtMaChang.getText());
				cb.setThoigiandi(txtThoiGianDi.getText());
				cb.setThoigianden(txtThoiGianDen.getText());
				SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
				String ngaydi=f.format(dcNgayDi.getDate());
				String ngayden=f.format(dcNgayDen.getDate());
				cb.setNgaydi(ngaydi);
				cb.setNgayden(ngayden);

				
				ChuyenBayBUS bus =new ChuyenBayBUS();
				bus.them(cb);
				
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
				tblChuyenBay.setModel(model);
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(409, 431, 89, 31);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i=tblChuyenBay.getSelectedRow();
				if(i>=0)
				{
					ChuyenBayDTO cb=new ChuyenBayDTO();
					cb.setMamaybay(txtMaMayBay.getText());
					cb.setMachuyenbay(txtMaChuyenBay.getText());
					cb.setMachang(txtMaChang.getText());
					cb.setThoigiandi(txtThoiGianDi.getText());
					cb.setThoigianden(txtThoiGianDen.getText());
					cb.setNgaydi(dcNgayDi.getToolTipText());
					cb.setNgayden(dcNgayDen.getToolTipText());
					model.setValueAt(cb.getMamaybay(), i, 0);
					model.setValueAt(cb.getMachuyenbay(), i, 1);
					model.setValueAt(cb.getMachang(), i, 2);
					model.setValueAt(cb.getThoigiandi(), i, 3);
					model.setValueAt(cb.getThoigianden(), i, 4);
					model.setValueAt(cb.getNgaydi(), i, 5);
					model.setValueAt(cb.getNgayden(), i, 6);
					tblChuyenBay.setModel(model);
					ChuyenBayBUS bus=new ChuyenBayBUS();
					bus.sua(i,cb);
				}
				
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(520, 431, 89, 31);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=tblChuyenBay.getSelectedRow();
				if(i>=0)
				{
					
					String ma=tblChuyenBay.getModel().getValueAt(i,0).toString();
					ChuyenBayBUS bus=new ChuyenBayBUS();
					bus.xoa(i,ma);
					model.removeRow(i);
					tblChuyenBay.setModel(model);
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(409, 485, 89, 31);
		contentPane.add(btnXoa);
		
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
		btnReset.setBounds(520, 485, 89, 31);
		contentPane.add(btnReset);
		
		ButtonGroup timkiemGroup=new ButtonGroup();
		
		JLabel lblThoiGianDi = new JLabel("Thời gian đi");
		lblThoiGianDi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThoiGianDi.setBounds(27, 604, 108, 20);
		contentPane.add(lblThoiGianDi);
		
		JLabel lblThoiGianDen = new JLabel("Thời gian đến");
		lblThoiGianDen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThoiGianDen.setBounds(27, 656, 108, 20);
		contentPane.add(lblThoiGianDen);
		
		JLabel lblNgayDi = new JLabel("Ngày đi");
		lblNgayDi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayDi.setBounds(435, 604, 108, 20);
		contentPane.add(lblNgayDi);
		
		txtThoiGianDi = new JTextField();
		txtThoiGianDi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtThoiGianDi.setColumns(10);
		txtThoiGianDi.setBounds(114, 599, 148, 31);
		contentPane.add(txtThoiGianDi);
		
		JPanel pnChangBay = new JPanel();
		pnChangBay.setForeground(UIManager.getColor("Button.focus"));
		pnChangBay.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EB7ng bay", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		((TitledBorder) pnChangBay.getBorder()).setTitleFont(new Font("Arial", Font.ITALIC, 16));
		pnChangBay.setBounds(27, 446, 362, 142);
		contentPane.add(pnChangBay);
		pnChangBay.setLayout(null);
		
		JLabel lblChang = new JLabel("Chặng");
		lblChang.setBounds(10, 81, 49, 20);
		pnChangBay.add(lblChang);
		lblChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtChang = new JTextField();
		txtChang.setBounds(110, 76, 242, 31);
		pnChangBay.add(txtChang);
		txtChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtChang.setColumns(10);
		
		JLabel lblMaChang = new JLabel("Mã chặng");
		lblMaChang.setBounds(10, 30, 108, 20);
		pnChangBay.add(lblMaChang);
		lblMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtMaChang = new JTextField();
		txtMaChang.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String machang=txtMaChang.getText();
				for(ChuyenBayDTO cb:ChuyenBayBUS.dsChuyenBay)
				{
					if(machang.equals(cb.getMachang()))
					{
						txtChang.setText(cb.getTenchang());
						break;
					}
					else 
						txtChang.setText("");
				}
			}
		});
		txtMaChang.setBounds(110, 25, 148, 31);
		pnChangBay.add(txtMaChang);
		txtMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaChang.setColumns(10);
		
		JComboBox cbbThemMaChang = new JComboBox();
		cbbThemMaChang.setBounds(268, 25, 84, 31);
		pnChangBay.add(cbbThemMaChang);
		cbbThemMaChang.setModel(new DefaultComboBoxModel(dataMaChang));
		cbbThemMaChang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i=cbbThemMaChang.getSelectedIndex();
				if(i>=0)
				{
					String machang=cbbThemMaChang.getItemAt(i).toString();
					for(ChuyenBayDTO cb:ChuyenBayBUS.dsChuyenBay)
					{
						if(machang.equals(cb.getMachang()))
						{
							txtChang.setText(cb.getTenchang());
							break;
						}
						
					}
					txtMaChang.setText(cbbThemMaChang.getItemAt(i).toString());
				}
			}
		});
		cbbThemMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		dcNgayDi = new JDateChooser();
		dcNgayDi.setBounds(529, 599, 154, 31);
		contentPane.add(dcNgayDi);
		
		dcNgayDen = new JDateChooser();
		dcNgayDen.setBounds(529, 645, 154, 31);
		contentPane.add(dcNgayDen);
		
		JRadioButton rdbtnMaMayBay = new JRadioButton("Mã máy bay");
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
		rdbtnMaMayBay.setBounds(841, 406, 109, 23);
		contentPane.add(rdbtnMaMayBay);
		rdbtnMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		timkiemGroup.add(rdbtnMaMayBay);
		
		JRadioButton rdbtnMaChuyenBay = new JRadioButton("Mã chuyến bay");
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
		rdbtnMaChuyenBay.setBounds(965, 406, 121, 23);
		contentPane.add(rdbtnMaChuyenBay);
		rdbtnMaChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		timkiemGroup.add(rdbtnMaChuyenBay);
		
			cbbTimMaMayBay = new JComboBox();
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
			cbbTimMaMayBay.setBounds(1139, 453, 103, 31);
			contentPane.add(cbbTimMaMayBay);
			cbbTimMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		txtTimMaMayBay = new JTextField();
		txtTimMaMayBay.setEditable(false);
		txtTimMaMayBay.setBounds(983, 453, 148, 31);
		contentPane.add(txtTimMaMayBay);
		txtTimMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimMaMayBay.setColumns(10);
		
		JLabel lblTimMaMayBay = new JLabel("Nhập mã máy bay cần tìm :");
		lblTimMaMayBay.setBounds(802, 453, 171, 31);
		contentPane.add(lblTimMaMayBay);
		lblTimMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
			cbbTimMaChuyenBay = new JComboBox();
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
			cbbTimMaChuyenBay.setBounds(1139, 503, 103, 31);
			contentPane.add(cbbTimMaChuyenBay);
			cbbTimMaChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		txtTimMaChuyenBay = new JTextField();
		txtTimMaChuyenBay.setEditable(false);
		txtTimMaChuyenBay.setBounds(983, 503, 148, 31);
		contentPane.add(txtTimMaChuyenBay);
		txtTimMaChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimMaChuyenBay.setColumns(10);
		
		JLabel lblTimMaChuyenBay = new JLabel("Nhập mã chuyến bay cần tìm :");
		lblTimMaChuyenBay.setBounds(783, 503, 190, 31);
		contentPane.add(lblTimMaChuyenBay);
		lblTimMaChuyenBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JRadioButton rdbtnMaChang = new JRadioButton("Mã chặng");
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
		rdbtnMaChang.setBounds(1106, 406, 109, 23);
		contentPane.add(rdbtnMaChang);
		rdbtnMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		timkiemGroup=new ButtonGroup();
		timkiemGroup.add(rdbtnMaMayBay);
		timkiemGroup.add(rdbtnMaChuyenBay);
		timkiemGroup.add(rdbtnMaChang);
		
		cbbTimMaChang = new JComboBox();
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
		cbbTimMaChang.setBounds(1139, 557, 103, 31);
		contentPane.add(cbbTimMaChang);
		cbbTimMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtTimMaChang = new JTextField();
		txtTimMaChang.setEditable(false);
		txtTimMaChang.setBounds(983, 557, 148, 31);
		contentPane.add(txtTimMaChang);
		txtTimMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimMaChang.setColumns(10);
		
		JLabel lblTimMaChang = new JLabel("Nhập mã chặng cần tìm :");
		lblTimMaChang.setBounds(818, 557, 155, 31);
		contentPane.add(lblTimMaChang);
		lblTimMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
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
		btnTimKiem.setBounds(983, 613, 89, 31);
		contentPane.add(btnTimKiem);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimKiem.setBounds(983, 364, 80, 14);
		contentPane.add(lblTimKiem);
		
		JLabel lblNgayDen = new JLabel("Ngày đến");
		lblNgayDen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayDen.setBounds(435, 650, 108, 20);
		contentPane.add(lblNgayDen);
		
		txtThoiGianDen = new JTextField();
		txtThoiGianDen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtThoiGianDen.setColumns(10);
		txtThoiGianDen.setBounds(114, 651, 148, 31);
		contentPane.add(txtThoiGianDen);
		
		JTimeChooser GioDi = new JTimeChooser();
		GioDi.getTimeField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtThoiGianDi.setText(GioDi.getFormatedTime().toString());
			}
		});
		GioDi.getTimeField().addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				txtThoiGianDi.setText(GioDi.getFormatedTime().toString());
			}
		});
		GioDi.getTimeField().setFont(new Font("Tahoma", Font.PLAIN, 11));
		GioDi.setBounds(272, 604, 51, 20);
		contentPane.add(GioDi);
		
		JTimeChooser GioDen = new JTimeChooser();
		GioDen.getTimeField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtThoiGianDi.setText(GioDen.getFormatedTime().toString());
			}
		});
		GioDen.getTimeField().addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				txtThoiGianDi.setText(GioDen.getFormatedTime().toString());
			}
		});
		GioDen.getTimeField().setFont(new Font("Tahoma", Font.PLAIN, 11));
		GioDen.setBounds(272, 656, 51, 20);
		contentPane.add(GioDen);
		
		JLabel lblSoGheTrong = new JLabel("Số ghế trống");
		lblSoGheTrong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoGheTrong.setBounds(27, 705, 108, 20);
		contentPane.add(lblSoGheTrong);
		
		txtSoGheTrong = new JTextField();
		txtSoGheTrong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoGheTrong.setColumns(10);
		txtSoGheTrong.setBounds(114, 700, 148, 31);
		contentPane.add(txtSoGheTrong);
		tblChuyenBay.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				int i=tblChuyenBay.getSelectedRow();
				if(i>=0)
				{
					txtMaMayBay.setText(tblChuyenBay.getModel().getValueAt(i,0).toString());
					txtMaChuyenBay.setText(tblChuyenBay.getModel().getValueAt(i,1).toString());
					txtMaChang.setText(tblChuyenBay.getModel().getValueAt(i,2).toString());
					txtThoiGianDi.setText(tblChuyenBay.getModel().getValueAt(i,3).toString());
					txtThoiGianDen.setText(tblChuyenBay.getModel().getValueAt(i,4).toString());
					//Time giodi=new Time("HH:mm:ss");
					SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date ngaydi=f.parse(tblChuyenBay.getModel().getValueAt(i, 5).toString());
						dcNgayDi.setDate(ngaydi);
						Date ngayden=f.parse(tblChuyenBay.getModel().getValueAt(i, 6).toString());
						dcNgayDen.setDate(ngayden);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					txtSoGheTrong.setText(tblChuyenBay.getModel().getValueAt(i,7).toString());
				}
					
			}
		});
		
		}
}
