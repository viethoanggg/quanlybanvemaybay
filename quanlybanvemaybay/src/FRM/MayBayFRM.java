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
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;

public class MayBayFRM extends JFrame {

	private JPanel contentPane;
	private JTable tblSanBay=new JTable();
	private JTextField txtLoai;
	private JTextField txtMaMayBay;
	private JTextField txtHang;
	static JTextField txtTimMa;
	static JTextField txtTimhang;
	private JComboBox cbbTimMa,cbbTimhang;
	private JPanel plTimKiem;
	private JLabel lblTimMa,lblTimTen;
	private DefaultTableModel model=new DefaultTableModel();
	private DefaultTableModel model1=new DefaultTableModel();
	private Vector header,row,dataMa,dataHang,dataLoai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MayBayFRM frame = new MayBayFRM();
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
	public MayBayFRM() {
		
		header=new Vector();
		header.add("Mã máy bay");
		header.add("Hãng");
		header.add("Loại");
		if(model.getRowCount()==0)
			{model =new DefaultTableModel(header,0);}
		MayBayBUS bus=new MayBayBUS();
		bus.docDSMayBay();
		int i=0;
		dataMa=new Vector();
		dataHang=new Vector();
		dataLoai=new Vector();
		for(MayBayDTO mb: MayBayBUS.dsMayBay)
		{
			row=new Vector();
			row.add(mb.getMamaybay());
			row.add(mb.getHang());
			row.add(mb.getLoai());
			model.addRow(row);
			dataMa.add(mb.getMamaybay());
			dataHang.add(mb.getHang());
			dataLoai.add(mb.getLoai());
		}
		tblSanBay.setModel(model);
          
		
		
		
		setBounds(100, 100, 1142, 692);
		setLocationRelativeTo(null);
		setTitle("Quản lý máy bay.");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 42, 1072, 285);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(tblSanBay);
		
		JLabel lblMaMayBay = new JLabel("Mã máy bay");
		lblMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaMayBay.setBounds(27, 366, 108, 20);
		contentPane.add(lblMaMayBay);
		
		JLabel lblHang = new JLabel("Hãng");
		lblHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHang.setBounds(27, 420, 108, 20);
		contentPane.add(lblHang);
		
		JLabel lblLoai = new JLabel("Loại");
		lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoai.setBounds(27, 474, 108, 20);
		contentPane.add(lblLoai);
		
		txtLoai = new JTextField();
		txtLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLoai.setColumns(10);
		txtLoai.setBounds(115, 469, 148, 31);
		contentPane.add(txtLoai);
		
		txtMaMayBay = new JTextField();
		txtMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaMayBay.setColumns(10);
		txtMaMayBay.setBounds(115, 361, 148, 31);
		contentPane.add(txtMaMayBay);
		
		txtHang = new JTextField();
		txtHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHang.setColumns(10);
		txtHang.setBounds(115, 415, 148, 31);
		contentPane.add(txtHang);
		
		JComboBox cbbThemHang = new JComboBox();
		cbbThemHang.setModel(new DefaultComboBoxModel(dataHang));
		cbbThemHang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i=cbbThemHang.getSelectedIndex();
				if(i>=0)
				{
					txtLoai.setText(cbbThemHang.getItemAt(i).toString());
				}
			}
		});
		cbbThemHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThemHang.setBounds(273, 415, 225, 31);
		contentPane.add(cbbThemHang);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				String mmb=txtMaMayBay.getText();
				for(MayBayDTO mb : MayBayBUS.dsMayBay)
				{
					if(mmb.equals(mb.getMamaybay()))
						JOptionPane.showMessageDialog(null,"Mã máy bay bị trùng ");
					flag=1;
				}
				if(flag==0)
				{
				JOptionPane.showMessageDialog(null,"Thêm thành công");
				MayBayDTO mb=new MayBayDTO();
				mb.setMamaybay(txtMaMayBay.getText());
				mb.setHang(txtHang.getText());
				mb.setLoai(txtLoai.getText());
				
				MayBayBUS bus =new MayBayBUS();
				bus.them(mb);
				
				row=new Vector();
				row.add(mb.getMamaybay());
				row.add(mb.getHang());
				row.add(mb.getLoai());
				model.addRow(row);
				tblSanBay.setModel(model);
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(27, 526, 89, 31);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i=tblSanBay.getSelectedRow();
				if(i>=0)
				{
					MayBayDTO mb=new MayBayDTO();
					mb.setMamaybay(txtMaMayBay.getText());
					mb.setHang(txtHang.getText());
					mb.setLoai(txtLoai.getText());
					model.setValueAt(mb.getMamaybay(), i, 0);
					model.setValueAt(mb.getHang(), i, 1);
					model.setValueAt(mb.getLoai(), i, 2);
					tblSanBay.setModel(model);
					MayBayBUS bus=new MayBayBUS();
					bus.sua(i,mb);
				}
				
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(142, 526, 89, 31);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=tblSanBay.getSelectedRow();
				if(i>=0)
				{
					
					String ma=tblSanBay.getModel().getValueAt(i,0).toString();
					MayBayBUS bus=new MayBayBUS();
					bus.xoa(i,ma);
					model.removeRow(i);
					tblSanBay.setModel(model);
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(256, 526, 89, 31);
		contentPane.add(btnXoa);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MayBayBUS bus=new MayBayBUS();
				bus.docDSMayBay();
				model1=new DefaultTableModel();
				header=new Vector();
				header.add("Mã máy bay");
				header.add("Hãng");
				header.add("Loại");
				header.add("Số lượng ghế");
				if(model1.getRowCount()==0)
					{model1 =new DefaultTableModel(header,0);}
				for(MayBayDTO mb: MayBayBUS.dsMayBay)
				{
					row=new Vector();
					row.add(mb.getMamaybay());
					row.add(mb.getHang());
					row.add(mb.getLoai());
					model1.addRow(row);
					
				}
				tblSanBay.setModel(model1);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(373, 526, 89, 31);
		contentPane.add(btnReset);
		
		JLabel label = new JLabel("");
		label.setBounds(705, 395, 46, 14);
		contentPane.add(label);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTimKiem.setBounds(654, 353, 318, 31);
		contentPane.add(lblTimKiem);
		
		JRadioButton rdbtnMaMayBay = new JRadioButton("Mã máy bay");
		rdbtnMaMayBay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnMaMayBay.isSelected()==true)
					cbbTimMa.setEditable(true);
					txtTimMa.setEditable(true);
					
					
					cbbTimhang.setEditable(false);
					txtTimhang.setEditable(false);
					
					
			}
		});
		
		rdbtnMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMaMayBay.setBounds(654, 407, 109, 23);
		contentPane.add(rdbtnMaMayBay);
		
		JRadioButton rdbtnHang = new JRadioButton("Hãng");
		rdbtnHang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnHang.isSelected()==true)
					cbbTimMa.setEditable(false);
					txtTimMa.setEditable(false);
										
					cbbTimhang.setEditable(true);
					txtTimhang.setEditable(true);
					
					
			}
		});
		rdbtnHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnHang.setBounds(915, 407, 109, 23);
		contentPane.add(rdbtnHang);
		
		ButtonGroup timkiemGroup=new ButtonGroup();
		timkiemGroup.add(rdbtnMaMayBay);
		timkiemGroup.add(rdbtnHang);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMaMayBay.isSelected()==true)
				{
				String ma=txtTimMa.getText();
				model=new DefaultTableModel();
				header=new Vector();
				header.add("Mã máy bay");
				header.add("Hãng");
				header.add("Loại");
				if(model.getRowCount()==0)
					{model =new DefaultTableModel(header,0);}
				for(MayBayDTO mb: MayBayBUS.dsMayBay)
				{
					if(mb.getMamaybay().equals(ma))
					{		
							row=new Vector();
							row.add(mb.getMamaybay());
							row.add(mb.getHang());
							row.add(mb.getLoai());
							model.addRow(row);
					}
				}
				tblSanBay.setModel(model);
				}
				if(rdbtnHang.isSelected()==true)
				{
				String tenmb=txtTimhang.getText();
				
				model=new DefaultTableModel();
				header=new Vector();
				header.add("Mã máy bay");
				header.add("Hãng");
				header.add("Loại");
				if(model.getRowCount()==0)
					{model =new DefaultTableModel(header,0);}
				for(MayBayDTO mb: MayBayBUS.dsMayBay)
				{
					if(mb.getHang().toLowerCase().indexOf(tenmb.toLowerCase())!=-1)
					{
							
							row=new Vector();
							row.add(mb.getMamaybay());
							row.add(mb.getHang());
							row.add(mb.getLoai());
							model.addRow(row);
					}
				}
				tblSanBay.setModel(model);
				}
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.setBounds(702, 551, 89, 31);
		contentPane.add(btnTimKiem);
		
		cbbTimMa = new JComboBox();
		cbbTimMa.setModel(new DefaultComboBoxModel(dataMa));
		cbbTimMa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i=cbbTimMa.getSelectedIndex();
				if(i>=0)
				{
					txtTimMa.setText(cbbTimMa.getItemAt(i).toString());
				}
			}
		});
		cbbTimMa.setBounds(897, 455, 202, 31);
		contentPane.add(cbbTimMa);
		cbbTimMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		txtTimhang = new JTextField();
		txtTimhang.setEditable(false);
		txtTimhang.setBounds(733, 509, 148, 31);
		contentPane.add(txtTimhang);
		txtTimhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimhang.setColumns(10);
		
		JLabel lblTimhang = new JLabel("Nhập hãng máy bay cần tìm :");
		lblTimhang.setBounds(530, 509, 183, 31);
		contentPane.add(lblTimhang);
		lblTimhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
					
		txtTimMa = new JTextField();
		txtTimMa.setEditable(false);
		txtTimMa.setBounds(731, 455, 148, 32);
		contentPane.add(txtTimMa);
		txtTimMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimMa.setColumns(10);
		
	
		cbbTimhang = new JComboBox();
		cbbTimhang.setModel(new DefaultComboBoxModel(dataHang));
		cbbTimhang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i=cbbTimhang.getSelectedIndex();
				if(i>=0)
				{
					txtTimhang.setText(cbbTimhang.getItemAt(i).toString());
				}
			}
		});
		cbbTimhang.setBounds(897, 508, 202, 32);
		contentPane.add(cbbTimhang);
		cbbTimhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
					
		JLabel lblTimMa = new JLabel("Nhập mã máy bay cần tìm :");
		lblTimMa.setBounds(546, 463, 171, 17);
		contentPane.add(lblTimMa);
		lblTimMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox cbbTimTen = new JComboBox();
		cbbTimTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbTimTen.setBounds(897, 509, 202, 31);
		contentPane.add(cbbTimTen);
		
		
		tblSanBay.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				int i=tblSanBay.getSelectedRow();
				if(i>=0)
				{
					txtMaMayBay.setText(tblSanBay.getModel().getValueAt(i,0).toString());
					txtHang.setText(tblSanBay.getModel().getValueAt(i,1).toString());
					txtLoai.setText(tblSanBay.getModel().getValueAt(i,2).toString());
				}
					
			}
		});
		}
}


