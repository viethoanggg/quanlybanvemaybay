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

public class GheFRM extends JFrame {

	private static JPanel contentPane;
	private JTable tblGhe=new JTable();
	private JTextField txtMaHangVe;
	private JTextField txtMaGhe;
	private JTextField txtMaMayBay;
	static JTextField txtTimMa;
	static JTextField txtTimMaMayBay;
	private JComboBox cbbTimMa,cbbTimMaMayBay,cbbTimMaHangVe;
	private JLabel lblTimMa,lblTimHang;
	private DefaultTableModel model=new DefaultTableModel();
	private DefaultTableModel model1=new DefaultTableModel();
	private Vector header,row,dataMaMayBay;
	static JTextField txtTimMaHangVe;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GheFRM frame = new GheFRM();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public GheFRM() {
		MayBayBUS bus2=new MayBayBUS();
		bus2.docDSMayBay();
		header=new Vector();
		header.add("Mã ghế");
		header.add("Mã máy bay");
		header.add("Mã hạng vé");
		if(model.getRowCount()==0)
			{model =new DefaultTableModel(header,0);}
		GheBUS bus=new GheBUS();
		bus.docDSGhe();
		int i=0;
		dataMaMayBay=new Vector();
		
		for(GheDTO g: GheBUS.dsGhe)
		{
			row=new Vector();
			row.add(g.getMaghe());
			row.add(g.getMamaybay());
			row.add(g.getMahangve());
			model.addRow(row);
		}
		tblGhe.setModel(model);
		for(MayBayDTO mb: MayBayBUS.dsMayBay)
		{
			
			dataMaMayBay.add(mb.getMamaybay());
		}  
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 771);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 50, 887, 285);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(tblGhe);
		
		JLabel lblMaGhe = new JLabel("Mã ghế");
		lblMaGhe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaGhe.setBounds(68, 408, 108, 20);
		contentPane.add(lblMaGhe);
		
		JLabel lblHang = new JLabel("Mã máy bay");
		lblHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHang.setBounds(68, 456, 108, 20);
		contentPane.add(lblHang);
		
		JLabel lblMaHangVe = new JLabel("Mã hạng vé");
		lblMaHangVe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaHangVe.setBounds(68, 505, 108, 20);
		contentPane.add(lblMaHangVe);
		
		txtMaHangVe = new JTextField();
		txtMaHangVe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaHangVe.setColumns(10);
		txtMaHangVe.setBounds(168, 504, 148, 31);
		contentPane.add(txtMaHangVe);
		
		txtMaGhe = new JTextField();
		txtMaGhe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaGhe.setColumns(10);
		txtMaGhe.setBounds(168, 396, 148, 31);
		contentPane.add(txtMaGhe);
		
		txtMaMayBay = new JTextField();
		txtMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaMayBay.setColumns(10);
		txtMaMayBay.setBounds(168, 450, 148, 31);
		contentPane.add(txtMaMayBay);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GheBUS bus=new GheBUS();
				bus.docDSGhe();
				model1=new DefaultTableModel();
				header=new Vector();
				header.add("Mã máy bay");
				header.add("Mã máy bay");
				header.add("Mã hạng vé");
				header.add("Số lượng ghế");
				if(model1.getRowCount()==0)
					{model1 =new DefaultTableModel(header,0);}
				for(GheDTO mb: GheBUS.dsGhe)
				{
					row=new Vector();
					row.add(mb.getMaghe());
					row.add(mb.getMamaybay());
					row.add(mb.getMahangve());
					model1.addRow(row);
					
				}
				tblGhe.setModel(model1);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(168, 558, 89, 31);
		contentPane.add(btnReset);
		
		JLabel label = new JLabel("");
		label.setBounds(520, 413, 46, 14);
		contentPane.add(label);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTimKiem.setBounds(469, 371, 318, 31);
		contentPane.add(lblTimKiem);
		
		JRadioButton rdbtnMaGhe = new JRadioButton("Mã ghế");
		rdbtnMaGhe.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnMaGhe.isSelected()==true)
					cbbTimMa.setEditable(true);
					txtTimMa.setEditable(true);
					
					
					cbbTimMaMayBay.setEditable(false);
					txtTimMaMayBay.setEditable(false);
					
					cbbTimMaHangVe.setEditable(false);
					txtTimMaHangVe.setEditable(false);					
			}
		});
		
		rdbtnMaGhe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMaGhe.setBounds(469, 425, 109, 23);
		contentPane.add(rdbtnMaGhe);
		
		JRadioButton rdbtnMaMayBay = new JRadioButton("Mã máy bay");
		rdbtnMaMayBay.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnMaMayBay.isSelected()==true)
					cbbTimMa.setEditable(false);
					txtTimMa.setEditable(false);
					
					cbbTimMaMayBay.setEditable(true);
					txtTimMaMayBay.setEditable(true);
					
					cbbTimMaHangVe.setEditable(false);
					txtTimMaHangVe.setEditable(false);
					
			}
		});
		rdbtnMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMaMayBay.setBounds(608, 425, 109, 23);
		contentPane.add(rdbtnMaMayBay);
		
		JRadioButton rdbtnMaHangVe = new JRadioButton("Mã hạng vé");
		rdbtnMaHangVe.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnMaHangVe.isSelected()==true)
					cbbTimMaHangVe.setEditable(true);
					txtTimMaHangVe.setEditable(true);
					
					cbbTimMaMayBay.setEditable(false);
					txtTimMaMayBay.setEditable(false);
					
					cbbTimMa.setEditable(false);
					txtTimMa.setEditable(false);					
			}
		});
		rdbtnMaHangVe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMaHangVe.setBounds(772, 425, 109, 23);
		contentPane.add(rdbtnMaHangVe);
		
		ButtonGroup timkiemGroup=new ButtonGroup();
		timkiemGroup.add(rdbtnMaGhe);
		timkiemGroup.add(rdbtnMaMayBay);
		timkiemGroup.add(rdbtnMaHangVe);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMaGhe.isSelected()==true)
				{
				String ma=txtTimMa.getText();
				model=new DefaultTableModel();
				header=new Vector();
				header.add("Mã ghê");
				header.add("Mã máy bay");
				header.add("Mã hạng vé");
				if(model.getRowCount()==0)
					{model =new DefaultTableModel(header,0);}
				for(GheDTO g: GheBUS.dsGhe)
				{
					if(g.getMaghe().equals(ma))
					{		
							row=new Vector();
							row.add(g.getMaghe());
							row.add(g.getMamaybay());
							row.add(g.getMahangve());
							model.addRow(row);
					}
				}
				tblGhe.setModel(model);
				}
				if(rdbtnMaMayBay.isSelected()==true)
				{
				String mamaybay=txtTimMaMayBay.getText();
				
				model=new DefaultTableModel();
				header=new Vector();
				header.add("Mã ghê");
				header.add("Mã máy bay");
				header.add("Mã hạng vé");
				if(model.getRowCount()==0)
					{model =new DefaultTableModel(header,0);}
				for(GheDTO g: GheBUS.dsGhe)
				{
					if(g.getMamaybay().equals(mamaybay))
					{
							
							row=new Vector();
							row.add(g.getMaghe());
							row.add(g.getMamaybay());
							row.add(g.getMahangve());
							model.addRow(row);
					}
				}
				tblGhe.setModel(model);
				}
				if(rdbtnMaHangVe.isSelected()==true)
				{
				String mahangve=txtTimMaHangVe.getText();
				
				model=new DefaultTableModel();
				header=new Vector();
				header.add("Mã ghê");
				header.add("Mã máy bay");
				header.add("Mã hạng vé");
				if(model.getRowCount()==0)
					{model =new DefaultTableModel(header,0);}
				for(GheDTO g: GheBUS.dsGhe)
				{
					if(g.getMahangve().equals(mahangve))
					{
							
							row=new Vector();
							row.add(g.getMaghe());
							row.add(g.getMamaybay());
							row.add(g.getMahangve());
							model.addRow(row);
					}
				}
				tblGhe.setModel(model);
				}
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.setBounds(520, 640, 89, 31);
		contentPane.add(btnTimKiem);
		
		cbbTimMa = new JComboBox();
		cbbTimMa.setModel(new DefaultComboBoxModel(new String[] {"MGFC01", "MGFC02", "MGFC03", "MGFC04", "MGFC05", "MGBC01", "MGBC02", "MGBC03", "MGBC04", "MGBC05", "MGEC01", "MGEC02", "MGEC03", "MGEC04", "MGEC05", "MGPC01", "MGPC02", "MGPC03", "MGPC04", "MGPC05"}));
		cbbTimMa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i=cbbTimMa.getSelectedIndex();
				if(i>=0)
				{
					txtTimMa.setText(cbbTimMa.getItemAt(i).toString());
				}
			}
		});
		cbbTimMa.setBounds(712, 473, 202, 31);
		contentPane.add(cbbTimMa);
		cbbTimMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		txtTimMaMayBay = new JTextField();
		txtTimMaMayBay.setEditable(false);
		txtTimMaMayBay.setBounds(548, 527, 148, 31);
		contentPane.add(txtTimMaMayBay);
		txtTimMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimMaMayBay.setColumns(10);
		
		JLabel lblTimMaMaybay = new JLabel("Nhập mã máy bay cần tìm :");
		lblTimMaMaybay.setBounds(361, 527, 183, 31);
		contentPane.add(lblTimMaMaybay);
		lblTimMaMaybay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
					
		txtTimMa = new JTextField();
		txtTimMa.setEditable(false);
		txtTimMa.setBounds(546, 473, 148, 32);
		contentPane.add(txtTimMa);
		txtTimMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimMa.setColumns(10);
		
	
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
		cbbTimMaMayBay.setBounds(712, 526, 202, 32);
		contentPane.add(cbbTimMaMayBay);
		cbbTimMaMayBay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
					
		JLabel lblTimMa = new JLabel("Nhập mã ghế cần tìm :");
		lblTimMa.setBounds(390, 480, 140, 17);
		contentPane.add(lblTimMa);
		lblTimMa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbbTimMaHangVe = new JComboBox();
		cbbTimMaHangVe.setModel(new DefaultComboBoxModel(new String[] {"EC", "PC", "BC", "FC"}));
		cbbTimMaHangVe.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i=cbbTimMaHangVe.getSelectedIndex();
				if(i>=0)
				{
					txtTimMaHangVe.setText(cbbTimMaHangVe.getItemAt(i).toString());
				}
			}
		});
		cbbTimMaHangVe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbTimMaHangVe.setBounds(712, 578, 202, 31);
		contentPane.add(cbbTimMaHangVe);
		
		txtTimMaHangVe = new JTextField();
		txtTimMaHangVe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimMaHangVe.setEditable(false);
		txtTimMaHangVe.setColumns(10);
		txtTimMaHangVe.setBounds(546, 578, 148, 32);
		contentPane.add(txtTimMaHangVe);
		
		JLabel lblTimMaHangVe = new JLabel("Nhập mã hạng vé cần tìm :");
		lblTimMaHangVe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimMaHangVe.setBounds(363, 585, 167, 17);
		contentPane.add(lblTimMaHangVe);
		tblGhe.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				int i=tblGhe.getSelectedRow();
				if(i>=0)
				{
					txtMaGhe.setText(tblGhe.getModel().getValueAt(i,0).toString());
					txtMaMayBay.setText(tblGhe.getModel().getValueAt(i,1).toString());
					txtMaHangVe.setText(tblGhe.getModel().getValueAt(i,2).toString());
				}
					
			}
		});
		}
}
