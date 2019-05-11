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

public class ChangFRM extends JFrame {

	private JPanel contentPane;
	private JTable tblChang=new JTable();
	private JTextField txtGia;
	private JTextField txtMaChang;
	private JTextField txtTenChang;
	static JTextField txtTimMa;
	static JTextField txtTimTen;
	private JComboBox cbbTimMa,cbbTimTen;
	private JLabel lblTimMa,lblTimTen;
	private DefaultTableModel model=new DefaultTableModel();
	private DefaultTableModel model1=new DefaultTableModel();
	private Vector header,row,dataMa,dataTen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangFRM frame = new ChangFRM();
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
	public ChangFRM() {
		
		header=new Vector();
		header.add("Mã sân bay");
		header.add("Tên sân bay");
		header.add("Thành phố");
		if(model.getRowCount()==0)
			{model =new DefaultTableModel(header,0);}
		ChangBUS bus=new ChangBUS();
		bus.docDSChang();
		int i=0;
		dataMa=new Vector();
		dataTen=new Vector();
		for(ChangDTO c: ChangBUS.dsChang)
		{
			row=new Vector();
			row.add(c.getMachang());
			row.add(c.getTenchang());
			row.add(c.getGia());
			model.addRow(row);
			dataMa.add(c.getMachang());
			dataTen.add(c.getTenchang());
		}
		tblChang.setModel(model);
          
		
		
		setTitle("Quản lý chặng bay.");
		setBounds(100, 100, 1133, 678);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 41, 1055, 285);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(tblChang);
		
		JLabel lblMaChang = new JLabel("Mã chặng");
		lblMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaChang.setBounds(27, 381, 108, 20);
		contentPane.add(lblMaChang);
		
		JLabel lblTenchang = new JLabel("Tên chặng");
		lblTenchang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenchang.setBounds(27, 435, 108, 20);
		contentPane.add(lblTenchang);
		
		JLabel lblGia = new JLabel("Giá");
		lblGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGia.setBounds(27, 478, 108, 20);
		contentPane.add(lblGia);
		
		txtGia = new JTextField();
		txtGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGia.setColumns(10);
		txtGia.setBounds(107, 478, 148, 31);
		contentPane.add(txtGia);
		
		txtMaChang = new JTextField();
		txtMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaChang.setColumns(10);
		txtMaChang.setBounds(107, 370, 148, 31);
		contentPane.add(txtMaChang);
		
		txtTenChang = new JTextField();
		txtTenChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenChang.setColumns(10);
		txtTenChang.setBounds(107, 424, 148, 31);
		contentPane.add(txtTenChang);
		
		JComboBox cbbThemChang = new JComboBox();
		cbbThemChang.setModel(new DefaultComboBoxModel(dataTen));
		cbbThemChang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i=cbbThemChang.getSelectedIndex();
				if(i>=0)
				{
					txtTenChang.setText(cbbThemChang.getItemAt(i).toString());
				}
			}
		});
		cbbThemChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThemChang.setBounds(265, 424, 189, 31);
		contentPane.add(cbbThemChang);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				String msb=txtMaChang.getText();
				for(ChangDTO sb : ChangBUS.dsChang)
				{
					if(msb.equals(sb.getMachang()))
						JOptionPane.showMessageDialog(null,"Mã chặng bị trùng ");
					flag=1;
				}
				if(flag==0)
				{
				JOptionPane.showMessageDialog(null,"Thêm thành công");
				ChangDTO sb=new ChangDTO();
				sb.setMachang(txtMaChang.getText());
				sb.setTenchang(txtTenChang.getText());
				sb.setGia(Integer.parseInt(txtGia.getText()));
				
				ChangBUS bus =new ChangBUS();
				bus.them(sb);
				
				row=new Vector();
				row.add(sb.getMachang());
				row.add(sb.getTenchang());
				row.add(sb.getGia());
				model.addRow(row);
				tblChang.setModel(model);
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(27, 553, 89, 31);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i=tblChang.getSelectedRow();
				if(i>=0)
				{
					ChangDTO sb=new ChangDTO();
					sb.setMachang(txtMaChang.getText());
					sb.setTenchang(txtTenChang.getText());
					sb.setGia(Integer.parseInt(txtGia.getText()));
					model.setValueAt(sb.getMachang(), i, 0);
					model.setValueAt(sb.getTenchang(), i, 1);
					model.setValueAt(sb.getGia(), i, 2);
					tblChang.setModel(model);
					ChangBUS bus=new ChangBUS();
					bus.sua(i,sb);
				}
				
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(145, 553, 89, 31);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=tblChang.getSelectedRow();
				if(i>=0)
				{
					
					String ma=tblChang.getModel().getValueAt(i,0).toString();
					ChangBUS bus=new ChangBUS();
					bus.xoa(i,ma);
					model.removeRow(i);
					tblChang.setModel(model);
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(265, 553, 89, 31);
		contentPane.add(btnXoa);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangBUS bus=new ChangBUS();
				bus.docDSChang();
				model1=new DefaultTableModel();
				header=new Vector();
				header.add("Mã chặng");
				header.add("Tên chặng");
				header.add("Giá");
				if(model1.getRowCount()==0)
					{model1 =new DefaultTableModel(header,0);}
				for(ChangDTO c: ChangBUS.dsChang)
				{
					row=new Vector();
					row.add(c.getMachang());
					row.add(c.getTenchang());
					row.add(c.getGia());
					model1.addRow(row);
					
				}
				tblChang.setModel(model1);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(383, 553, 89, 31);
		contentPane.add(btnReset);
		
		JLabel label = new JLabel("");
		label.setBounds(688, 403, 46, 14);
		contentPane.add(label);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTimKiem.setBounds(637, 361, 318, 31);
		contentPane.add(lblTimKiem);
		
		JRadioButton rdbtnMaChang = new JRadioButton("Mã chặng");
		rdbtnMaChang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnMaChang.isSelected()==true)
					cbbTimMa.setEditable(true);
					txtTimMa.setEditable(true);
					
					
					cbbTimTen.setEditable(false);
					txtTimTen.setEditable(false);
					
			}
		});
		
		rdbtnMaChang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMaChang.setBounds(637, 415, 109, 23);
		contentPane.add(rdbtnMaChang);
		
		JRadioButton rdbtnTenchang = new JRadioButton("Tên chặng");
		rdbtnTenchang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnTenchang.isSelected()==true)
					cbbTimMa.setEditable(false);
					txtTimMa.setEditable(false);
										
					cbbTimTen.setEditable(true);
					txtTimTen.setEditable(true);
		
			}
		});
		rdbtnTenchang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTenchang.setBounds(912, 415, 109, 23);
		contentPane.add(rdbtnTenchang);
		
		ButtonGroup timkiemGroup=new ButtonGroup();
		timkiemGroup.add(rdbtnMaChang);
		timkiemGroup.add(rdbtnTenchang);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMaChang.isSelected()==true)
				{
				String ma=txtTimMa.getText();
				model=new DefaultTableModel();
				header=new Vector();
				header.add("Mã chặng");
				header.add("Tên chặng");
				header.add("Giá");
				if(model.getRowCount()==0)
					{model =new DefaultTableModel(header,0);}
				for(ChangDTO sb: ChangBUS.dsChang)
				{
					if(sb.getMachang().equals(ma))
					{		
							row=new Vector();
							row.add(sb.getMachang());
							row.add(sb.getTenchang());
							row.add(sb.getGia());
							model.addRow(row);
					}
				}
				tblChang.setModel(model);
				}
				if(rdbtnTenchang.isSelected()==true)
				{
				String tensb=txtTimTen.getText();
				
				model=new DefaultTableModel();
				header=new Vector();
				header.add("Mã chặng");
				header.add("Tên chặng");
				header.add("Giá");
				if(model.getRowCount()==0)
					{model =new DefaultTableModel(header,0);}
				for(ChangDTO c: ChangBUS.dsChang)
				{
					if(c.getTenchang().toLowerCase().indexOf(tensb.toLowerCase())!=-1)
					{
							
							row=new Vector();
							row.add(c.getMachang());
							row.add(c.getTenchang());
							row.add(c.getGia());
							model.addRow(row);
					}
				}
				tblChang.setModel(model);
				}
				
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.setBounds(765, 571, 89, 31);
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
		cbbTimMa.setBounds(880, 463, 202, 31);
		contentPane.add(cbbTimMa);
		cbbTimMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		txtTimTen = new JTextField();
		txtTimTen.setEditable(false);
		txtTimTen.setBounds(716, 517, 148, 31);
		contentPane.add(txtTimTen);
		txtTimTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimTen.setColumns(10);
		
		JLabel lblTimTen = new JLabel("Nhập tên chặng cần tìm :");
		lblTimTen.setBounds(529, 517, 183, 31);
		contentPane.add(lblTimTen);
		lblTimTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
					
		txtTimMa = new JTextField();
		txtTimMa.setEditable(false);
		txtTimMa.setBounds(714, 463, 148, 32);
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
		cbbTimTen.setBounds(880, 516, 202, 32);
		contentPane.add(cbbTimTen);
		cbbTimTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
					
		JLabel lblTimMa = new JLabel("Nhập mã chặng cần tìm :");
		lblTimMa.setBounds(529, 471, 171, 17);
		contentPane.add(lblTimMa);
		lblTimMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox cbbTimTen = new JComboBox();
		cbbTimTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbTimTen.setBounds(880, 517, 202, 31);
		contentPane.add(cbbTimTen);
		
		
		tblChang.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				int i=tblChang.getSelectedRow();
				if(i>=0)
				{
					txtMaChang.setText(tblChang.getModel().getValueAt(i,0).toString());
					txtTenChang.setText(tblChang.getModel().getValueAt(i,1).toString());
					txtGia.setText(tblChang.getModel().getValueAt(i,2).toString());
				}
					
			}
		});
		}
}


