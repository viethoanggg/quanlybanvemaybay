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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ThemKH extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtVISA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemKH frame = new ThemKH();
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
	public ThemKH() {
		KhachHangBUS khbus=new KhachHangBUS();
		khbus.docDSKH();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 318);
		setTitle("Thêm khách hàng");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 11, 673, 257);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MaKH");
		lblNewLabel.setBounds(27, 27, 74, 30);
		panel.add(lblNewLabel);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(195, 26, 36, 33);
		panel.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tên KH");
		lblNewLabel_1.setBounds(27, 68, 74, 30);
		panel.add(lblNewLabel_1);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(111, 68, 161, 30);
		panel.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ngay sinh");
		lblNgaySinh.setBounds(27, 112, 74, 30);
		panel.add(lblNgaySinh);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(111, 154, 161, 30);
		panel.add(txtCMND);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(27, 154, 74, 30);
		panel.add(lblCmnd);
		
		JLabel lblSodienthoai = new JLabel("SĐT");
		lblSodienthoai.setBounds(343, 27, 74, 30);
		panel.add(lblSodienthoai);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(427, 24, 161, 33);
		panel.add(txtSDT);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setBounds(343, 68, 74, 30);
		panel.add(lblGiiTnh);
		
		JLabel lblVisa = new JLabel("ViSa");
		lblVisa.setBounds(343, 112, 74, 30);
		panel.add(lblVisa);
		
		txtVISA = new JTextField();
		txtVISA.setColumns(10);
		txtVISA.setBounds(427, 112, 161, 30);
		panel.add(txtVISA);
		txtVISA.setEditable(false);
		
		JDateChooser txtNgaySinh = new JDateChooser();
		txtNgaySinh.setBounds(111, 112, 161, 30);
		panel.add(txtNgaySinh);
		
		JComboBox cbbGioiTinh = new JComboBox();
		cbbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbbGioiTinh.setBounds(427, 68, 161, 30);
		panel.add(cbbGioiTinh);
		
		JButton btnThem = new JButton("Thêm");
		
		btnThem.setBounds(183, 216, 89, 30);
		panel.add(btnThem);
		
		JButton btnDatLai = new JButton("Đặt lai");
		
		btnDatLai.setBounds(308, 216, 89, 30);
		panel.add(btnDatLai);
		
		JButton btnThoat = new JButton("Thoát");
		
		btnThoat.setBounds(431, 216, 89, 30);
		panel.add(btnThoat);
		
		JComboBox cbbMaKH = new JComboBox();
		cbbMaKH.setModel(new DefaultComboBoxModel(new String[] {"KHM_", "KHD_"}));
		cbbMaKH.setBounds(111, 27, 74, 30);
		panel.add(cbbMaKH);
		
		JLabel label = new JLabel("(Nhập số)");
		label.setFont(new Font("Tahoma", Font.ITALIC, 10));
		label.setBounds(232, 27, 61, 27);
		panel.add(label);
		
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String makh=cbbMaKH.getSelectedItem().toString()+txtMaKH.getText();
				int flag=0;
				for(KhachHangDTO kh : KhachHangBUS.dskh)
			       {
			    	   if(makh.equals(kh.getMaKH()))
			    	   {
			    		   JOptionPane.showMessageDialog(null,"Mã KH bị trùng");
			    		   flag=1;
			    	   }
			       }
				if(txtTenKH.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Tên khách hàng trống.");
		    		 flag=1;
				}
				if(txtCMND.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"CMND bị trống.");
		    		 flag=1;
				}
				if(cbbMaKH.getSelectedIndex()==1 && txtVISA.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"VISA bị trống.");
		    		 flag=1;
				}
				if(txtNgaySinh.getDate()==null)
				{
					flag=1;
				}
				if(flag==0)
				{
					KhachHangDTO kh =new KhachHangDTO();
					kh.setMaKH(makh);
					kh.setTenKH(txtTenKH.getText());
					kh.setCMND(txtCMND.getText());
					
					SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
					String d=f.format(txtNgaySinh.getDate());
					kh.setNgaySinh(d);
					
					kh.setSDT(txtSDT.getText());
					kh.setGioiTinh(cbbGioiTinh.getSelectedItem().toString());
					kh.setVisa(txtVISA.getText());
					kh.setGioiTinh(cbbGioiTinh.getSelectedItem().toString());
					
					KhachHangBUS bus=new KhachHangBUS();
					bus.them(kh);
					JOptionPane.showMessageDialog(null,"Đã thêm");
				}
			}
		});
		cbbMaKH.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(cbbMaKH.getSelectedIndex()==1)
					txtVISA.setEditable(true);
				if(cbbMaKH.getSelectedIndex()==0)
					txtVISA.setEditable(false);
			}
		});
		
		btnDatLai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtMaKH.setText("");
				txtTenKH.setText("");
				txtNgaySinh.setDateFormatString("");
				txtCMND.setText("");
				txtSDT.setText("");
				txtVISA.setText("");
			}
		});
		
		btnThoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
