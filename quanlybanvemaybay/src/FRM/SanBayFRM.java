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

public class SanBayFRM extends JFrame {

	private JPanel contentPane;
	private JTable tblSanBay=new JTable();
	private JTextField txtThanhPho;
	private JTextField txtMaSanbay;
	private JTextField txtTenSanBay;
	static JTextField txtTimMa;
	static JTextField txtTimTen;
	private JComboBox cbbTimMa,cbbTimTen,cbbTimThanhPho;
	private JPanel plTimKiem;
	private JLabel lblTimMa,lblTimTen;
	private DefaultTableModel model=new DefaultTableModel();
	private DefaultTableModel model1=new DefaultTableModel();
	private Vector header,row,dataMa,dataTen,dataThanhPho;
	private JTextField txtTimThanhPho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanBayFRM frame = new SanBayFRM();
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
	public SanBayFRM() {
		
		header=new Vector();
		header.add("Mã sân bay");
		header.add("Tên sân bay");
		header.add("Thành phố");
		if(model.getRowCount()==0)
			{model =new DefaultTableModel(header,0);}
		SanBayBUS bus=new SanBayBUS();
		bus.docDSSanBay();
		int i=0;
		dataMa=new Vector();
		dataTen=new Vector();
		dataThanhPho=new Vector();
		for(SanBayDTO sb: SanBayBUS.dsSanBay)
		{
			row=new Vector();
			row.add(sb.getMasanbay());
			row.add(sb.getTensanbay());
			row.add(sb.getThanhpho());
			model.addRow(row);
			dataMa.add(sb.getMasanbay());
			dataTen.add(sb.getTensanbay());
			dataThanhPho.add(sb.getThanhpho());
		}
		tblSanBay.setModel(model);
          
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1142, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 42, 1072, 285);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(tblSanBay);
		
		JLabel lblMaSanBay = new JLabel("Mã sân bay");
		lblMaSanBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaSanBay.setBounds(27, 366, 108, 20);
		contentPane.add(lblMaSanBay);
		
		JLabel lblTenSanbay = new JLabel("Tên sân bay");
		lblTenSanbay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenSanbay.setBounds(27, 420, 108, 20);
		contentPane.add(lblTenSanbay);
		
		JLabel lblThanhPho = new JLabel("Thành phố");
		lblThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThanhPho.setBounds(27, 474, 108, 20);
		contentPane.add(lblThanhPho);
		
		txtThanhPho = new JTextField();
		txtThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtThanhPho.setColumns(10);
		txtThanhPho.setBounds(115, 469, 148, 31);
		contentPane.add(txtThanhPho);
		
		txtMaSanbay = new JTextField();
		txtMaSanbay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaSanbay.setColumns(10);
		txtMaSanbay.setBounds(115, 361, 148, 31);
		contentPane.add(txtMaSanbay);
		
		txtTenSanBay = new JTextField();
		txtTenSanBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenSanBay.setColumns(10);
		txtTenSanBay.setBounds(115, 415, 148, 31);
		contentPane.add(txtTenSanBay);
		
		JComboBox cbbThemThanhPho = new JComboBox();
		cbbThemThanhPho.setModel(new DefaultComboBoxModel(dataThanhPho));
		cbbThemThanhPho.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i=cbbThemThanhPho.getSelectedIndex();
				if(i>=0)
				{
					txtThanhPho.setText(cbbThemThanhPho.getItemAt(i).toString());
				}
			}
		});
		cbbThemThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThemThanhPho.setBounds(273, 469, 189, 31);
		contentPane.add(cbbThemThanhPho);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				String msb=txtMaSanbay.getText();
				for(SanBayDTO sb : SanBayBUS.dsSanBay)
				{
					if(msb.equals(sb.getMasanbay()))
						JOptionPane.showMessageDialog(null,"Mã sân bay bị trùng ");
					flag=1;
				}
				if(flag==0)
				{
				JOptionPane.showMessageDialog(null,"Thêm thành công");
				SanBayDTO sb=new SanBayDTO();
				sb.setMasanbay(txtMaSanbay.getText());
				sb.setTensanbay(txtTenSanBay.getText());
				sb.setThanhpho(txtThanhPho.getText());
				
				SanBayBUS bus =new SanBayBUS();
				bus.them(sb);
				
				row=new Vector();
				row.add(sb.getMasanbay());
				row.add(sb.getTensanbay());
				row.add(sb.getThanhpho());
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
					SanBayDTO sb=new SanBayDTO();
					sb.setMasanbay(txtMaSanbay.getText());
					sb.setTensanbay(txtTenSanBay.getText());
					sb.setThanhpho(txtThanhPho.getText());
					model.setValueAt(sb.getMasanbay(), i, 0);
					model.setValueAt(sb.getTensanbay(), i, 1);
					model.setValueAt(sb.getThanhpho(), i, 2);
					tblSanBay.setModel(model);
					SanBayBUS bus=new SanBayBUS();
					bus.sua(i,sb);
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
					SanBayBUS bus=new SanBayBUS();
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
				SanBayBUS bus=new SanBayBUS();
				bus.docDSSanBay();
				model1=new DefaultTableModel();
				header=new Vector();
				header.add("Mã máy bay");
				header.add("Hãng");
				header.add("Loại");
				header.add("Số lượng ghế");
				if(model1.getRowCount()==0)
					{model1 =new DefaultTableModel(header,0);}
				for(SanBayDTO sb: SanBayBUS.dsSanBay)
				{
					row=new Vector();
					row.add(sb.getMasanbay());
					row.add(sb.getTensanbay());
					row.add(sb.getThanhpho());
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
		
		JRadioButton rdbtnMaSanBay = new JRadioButton("Mã sân bay");
		rdbtnMaSanBay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnMaSanBay.isSelected()==true)
					cbbTimMa.setEditable(true);
					txtTimMa.setEditable(true);
					
					
					cbbTimTen.setEditable(false);
					txtTimTen.setEditable(false);
					
					cbbTimThanhPho.setEditable(false);
					txtTimThanhPho.setEditable(false);
			}
		});
		
		rdbtnMaSanBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMaSanBay.setBounds(654, 407, 109, 23);
		contentPane.add(rdbtnMaSanBay);
		
		JRadioButton rdbtnTenSanBay = new JRadioButton("Tên sân bay");
		rdbtnTenSanBay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnTenSanBay.isSelected()==true)
					cbbTimMa.setEditable(false);
					txtTimMa.setEditable(false);
										
					cbbTimTen.setEditable(true);
					txtTimTen.setEditable(true);
					
					cbbTimThanhPho.setEditable(false);
					txtTimThanhPho.setEditable(false);
			}
		});
		rdbtnTenSanBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTenSanBay.setBounds(806, 407, 109, 23);
		contentPane.add(rdbtnTenSanBay);
		
		JRadioButton rdbtnThanhPho = new JRadioButton("Thành phố");
		rdbtnThanhPho.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnThanhPho.isSelected()==true)
					cbbTimThanhPho.setEditable(true);
					txtTimThanhPho.setEditable(true);
					
					cbbTimTen.setEditable(false);
					txtTimTen.setEditable(false);
					
					cbbTimMa.setEditable(false);
					txtTimMa.setEditable(false);					
			}
		});
		rdbtnThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnThanhPho.setBounds(957, 407, 109, 23);
		contentPane.add(rdbtnThanhPho);
		
		ButtonGroup timkiemGroup=new ButtonGroup();
		timkiemGroup.add(rdbtnMaSanBay);
		timkiemGroup.add(rdbtnTenSanBay);
		timkiemGroup.add(rdbtnThanhPho);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMaSanBay.isSelected()==true)
				{
				String ma=txtTimMa.getText();
				model=new DefaultTableModel();
				header=new Vector();
				header.add("Mã sân bay");
				header.add("Tên sân bay");
				header.add("Thành phố");
				if(model.getRowCount()==0)
					{model =new DefaultTableModel(header,0);}
				for(SanBayDTO sb: SanBayBUS.dsSanBay)
				{
					if(sb.getMasanbay().equals(ma))
					{		
							row=new Vector();
							row.add(sb.getMasanbay());
							row.add(sb.getTensanbay());
							row.add(sb.getThanhpho());
							model.addRow(row);
					}
				}
				tblSanBay.setModel(model);
				}
				if(rdbtnTenSanBay.isSelected()==true)
				{
				String tensb=txtTimTen.getText();
				
				model=new DefaultTableModel();
				header=new Vector();
				header.add("Mã sân bay");
				header.add("Tên sân bay");
				header.add("Thành phố");
				if(model.getRowCount()==0)
					{model =new DefaultTableModel(header,0);}
				for(SanBayDTO sb: SanBayBUS.dsSanBay)
				{
					if(sb.getTensanbay().toLowerCase().indexOf(tensb.toLowerCase())!=-1)
					{
							
							row=new Vector();
							row.add(sb.getMasanbay());
							row.add(sb.getTensanbay());
							row.add(sb.getThanhpho());
							model.addRow(row);
					}
				}
				tblSanBay.setModel(model);
				}
				if(rdbtnThanhPho.isSelected()==true)
				{
				String tentp=txtTimThanhPho.getText();
				
				model=new DefaultTableModel();
				header=new Vector();
				header.add("Mã sân bay");
				header.add("Tên sân bay");
				header.add("Thành phố");
				if(model.getRowCount()==0)
					{model =new DefaultTableModel(header,0);}
				for(SanBayDTO sb: SanBayBUS.dsSanBay)
				{
					if(sb.getThanhpho().toLowerCase().indexOf(tentp.toLowerCase())!=-1)
					{
							
							row=new Vector();
							row.add(sb.getMasanbay());
							row.add(sb.getTensanbay());
							row.add(sb.getThanhpho());
							model.addRow(row);
					}
				}
				tblSanBay.setModel(model);
				}
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.setBounds(702, 601, 89, 31);
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
			
		txtTimTen = new JTextField();
		txtTimTen.setEditable(false);
		txtTimTen.setBounds(733, 509, 148, 31);
		contentPane.add(txtTimTen);
		txtTimTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimTen.setColumns(10);
		
		JLabel lblTimTen = new JLabel("Nhập tên sân bay cần tìm :");
		lblTimTen.setBounds(546, 509, 183, 31);
		contentPane.add(lblTimTen);
		lblTimTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
					
		txtTimMa = new JTextField();
		txtTimMa.setEditable(false);
		txtTimMa.setBounds(731, 455, 148, 32);
		contentPane.add(txtTimMa);
		txtTimMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimMa.setColumns(10);
		
	
		cbbTimTen = new JComboBox();
		cbbTimTen.setModel(new DefaultComboBoxModel(dataTen));
		cbbTimTen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i=cbbTimTen.getSelectedIndex();
				if(i>=0)
				{
					txtTimTen.setText(cbbTimTen.getItemAt(i).toString());
				}
			}
		});
		cbbTimTen.setBounds(897, 508, 202, 32);
		contentPane.add(cbbTimTen);
		cbbTimTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
					
		JLabel lblTimMa = new JLabel("Nhập mã sân bay cần tìm :");
		lblTimMa.setBounds(546, 463, 171, 17);
		contentPane.add(lblTimMa);
		lblTimMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox cbbTimTen = new JComboBox();
		cbbTimTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbTimTen.setBounds(897, 509, 202, 31);
		contentPane.add(cbbTimTen);
		
		txtTimThanhPho = new JTextField();
		txtTimThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimThanhPho.setEditable(false);
		txtTimThanhPho.setColumns(10);
		txtTimThanhPho.setBounds(733, 559, 148, 31);
		contentPane.add(txtTimThanhPho);
		
		JLabel lblTimThanhPho = new JLabel("Nhập tên thành phố cần tìm :");
		lblTimThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimThanhPho.setBounds(534, 559, 183, 31);
		contentPane.add(lblTimThanhPho);
		
		cbbTimThanhPho = new JComboBox();
		cbbTimThanhPho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbTimThanhPho.setModel(new DefaultComboBoxModel(dataThanhPho));
		cbbTimThanhPho.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i=cbbTimThanhPho.getSelectedIndex();
				if(i>=0)
				{
					txtTimThanhPho.setText(cbbTimThanhPho.getItemAt(i).toString());
				}
			}
		});
		cbbTimThanhPho.setBounds(897, 558, 202, 32);
		contentPane.add(cbbTimThanhPho);
		
		
		tblSanBay.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				int i=tblSanBay.getSelectedRow();
				if(i>=0)
				{
					txtMaSanbay.setText(tblSanBay.getModel().getValueAt(i,0).toString());
					txtTenSanBay.setText(tblSanBay.getModel().getValueAt(i,1).toString());
					txtThanhPho.setText(tblSanBay.getModel().getValueAt(i,2).toString());
				}
					
			}
		});
		}
}


