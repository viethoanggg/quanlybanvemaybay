package FRM;
import BUS.*;
import DAO.*;
import DTO.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class HangVeFRM extends JFrame {

	private JPanel contentPane;
	private JTextField txtTmKiem;
	private JTextField txtMaHangVe;
	private JTable tblHangVe =new JTable();
	private JTextField txtTenHangVe;
	private JTextField txtGiaHangVe;
	private DefaultTableModel model =new DefaultTableModel(); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangVeFRM frame = new HangVeFRM();
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
	public HangVeFRM() {
		setTableHangVe();
		setTitle("Hạng vé");
		
		setBounds(100, 100, 685, 487);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm");
		lblNewLabel.setBounds(42, 209, 115, 20);
		contentPane.add(lblNewLabel);
		
		txtTmKiem = new JTextField();
		
		txtTmKiem.setBounds(175, 206, 192, 23);
		contentPane.add(txtTmKiem);
		txtTmKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm");
		btnTimKiem.setBackground(new Color(245, 245, 220));
		
		btnTimKiem.setBounds(412, 208, 89, 23);
		contentPane.add(btnTimKiem);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hạng vé");
		lblNewLabel_1.setBounds(42, 253, 115, 23);
		contentPane.add(lblNewLabel_1);
		
		txtMaHangVe = new JTextField();
		txtMaHangVe.setEditable(false);
		txtMaHangVe.setBounds(175, 253, 192, 23);
		contentPane.add(txtMaHangVe);
		txtMaHangVe.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên hạng vé");
		lblNewLabel_2.setBounds(42, 296, 123, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giá hạng vé");
		lblNewLabel_3.setBounds(42, 333, 115, 26);
		contentPane.add(lblNewLabel_3);
		
		JButton btnCapNhat = new JButton("Cập nhật DS");
		btnCapNhat.setBackground(new Color(245, 245, 220));
		btnCapNhat.setBounds(79, 383, 115, 33);
		contentPane.add(btnCapNhat);
		
		JButton btnDatLai = new JButton("Đặt lại");
		btnDatLai.setBackground(new Color(245, 245, 220));
		btnDatLai.setBounds(217, 383, 115, 33);
		contentPane.add(btnDatLai);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(245, 245, 220));
		btnSua.setBounds(357, 383, 123, 33);
		contentPane.add(btnSua);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(245, 245, 220));
		btnThoat.setBounds(499, 383, 115, 33);
		contentPane.add(btnThoat);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch h\u1EA1ng v\u00E9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(25, 72, 620, 119);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 580, 87);
		panel.add(scrollPane);
		scrollPane.setViewportView(tblHangVe);
		
		txtTenHangVe = new JTextField();
		txtTenHangVe.setColumns(10);
		txtTenHangVe.setBounds(175, 295, 192, 23);
		contentPane.add(txtTenHangVe);
		
		txtGiaHangVe = new JTextField();
		txtGiaHangVe.setColumns(10);
		txtGiaHangVe.setBounds(175, 336, 192, 23);
		contentPane.add(txtGiaHangVe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 669, 55);
		contentPane.add(panel_1);
		
		tblHangVe.addMouseListener(new MouseAdapter()
			{	
				@Override
				public void mouseClicked(MouseEvent e)
				{
					int i=tblHangVe.getSelectedRow();
					if(i>=0)
					{
						txtMaHangVe.setText(tblHangVe.getModel().getValueAt(i,0).toString());
						txtTenHangVe.setText(tblHangVe.getModel().getValueAt(i,1).toString());
						txtGiaHangVe.setText(String.valueOf(tblHangVe.getModel().getValueAt(i,2).toString()));
					}
				}
			});
		
		btnCapNhat.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setTableHangVe();
			}
		});
		
		btnDatLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtMaHangVe.setText("");
				txtTenHangVe.setText("");
				txtGiaHangVe.setText("");
				
			}
		});
		
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=tblHangVe.getSelectedRow();
				if(i>=0)
				{
					int k=JOptionPane.showConfirmDialog(null,"Bạn có muốn sửa.");
					if(k==0)
					{
						JOptionPane.showMessageDialog(null,"Đã sửa");
						HangVeDTO hv =new HangVeDTO();
						hv.setMaHangVe(txtMaHangVe.getText());
						hv.setTenHangVe(txtTenHangVe.getText());
						hv.setGiaHangVe(Integer.valueOf(txtGiaHangVe.getText()));
						
						tblHangVe.getModel().setValueAt(hv.getMaHangVe(), i,0);
						tblHangVe.getModel().setValueAt(hv.getTenHangVe(), i,1);
						tblHangVe.getModel().setValueAt(hv.getGiaHangVe(), i,2);
						
						HangVeBUS bus=new HangVeBUS();
						bus.sua(i,hv);
					}
				}
				
			}
		});
		
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		txtTmKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String s=txtTmKiem.getText();
				HangVeBUS bus=new HangVeBUS();
				bus.TimKiem(s);
				newTableHangVe();
				newDataHangVe();
			}
		});
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=txtTmKiem.getText();
				HangVeBUS bus=new HangVeBUS();
				bus.TimKiem(s);
				newTableHangVe();
				newDataHangVe();
			}
		});
	}
	
//--------------------------------------------------------------------------------------------------------------//
	public void newTableHangVe()
	{
		Vector header =new Vector();
		model=new DefaultTableModel();
		header.add("Mã hạng vé");
		header.add("Tên hạng vé");
		header.add("Giá hạng vé");
		if(model.getRowCount()==0)
			model =new DefaultTableModel(header,0);
		
		tblHangVe.setModel(model);
	}
	public void newDataHangVe()
	{
		
		for(HangVeDTO hv : HangVeBUS.dshv)
		{
			Vector row=new Vector();
			row.add(hv.getMaHangVe());
			row.add(hv.getTenHangVe());
			row.add(hv.getGiaHangVe());
			
			model.addRow(row);
		}
		tblHangVe.setModel(model);
	}
	public void setTableHangVe()
	{
		HangVeBUS bus=new HangVeBUS();
		bus.docDSHangVe();
		newTableHangVe();
		newDataHangVe();
	}
}
