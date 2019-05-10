package FRM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import BUS.HoaDonBUS;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;

public class ThongKeHDFRM extends JFrame {

	private JPanel contentPane;
	private JTextField txtTKNC_GiaTu;
	private JTextField txtTKNC_GiaDen;
	private JTextField txtNamQuy;
	private JLabel lblSoLuongVe;
	private JLabel lblTongDoanhThu;
	private JDateChooser txtTKNC_NgayDatVeTu=new JDateChooser();  
	private JDateChooser txtTKNC_NgayDatVeDen=new JDateChooser();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeHDFRM frame = new ThongKeHDFRM();
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
	public ThongKeHDFRM() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 545);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 657, 57);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 68, 299, 254);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Th\u1EDDi gian", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 40, 231, 102);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("Từ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(23, 24, 35, 28);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Đến");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(23, 63, 35, 28);
		panel_2.add(label_1);
		
		txtTKNC_NgayDatVeTu = new JDateChooser();
		txtTKNC_NgayDatVeTu.setBounds(68, 24, 135, 28);
		panel_2.add(txtTKNC_NgayDatVeTu);
		
		txtTKNC_NgayDatVeDen = new JDateChooser();
		txtTKNC_NgayDatVeDen.setBounds(68, 63, 135, 28);
		panel_2.add(txtTKNC_NgayDatVeDen);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "S\u1ED1 ti\u1EC1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 143, 231, 102);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_2 = new JLabel("Từ");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(21, 21, 35, 28);
		panel_3.add(label_2);
		
		txtTKNC_GiaTu = new JTextField();
		txtTKNC_GiaTu.setColumns(10);
		txtTKNC_GiaTu.setBounds(66, 21, 143, 28);
		panel_3.add(txtTKNC_GiaTu);
		
		JLabel label_3 = new JLabel("Đến");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(21, 60, 35, 28);
		panel_3.add(label_3);
		
		txtTKNC_GiaDen = new JTextField();
		txtTKNC_GiaDen.setColumns(10);
		txtTKNC_GiaDen.setBounds(66, 60, 144, 28);
		panel_3.add(txtTKNC_GiaDen);
		
		JButton btnTimKiemNangCao_Left = new JButton("");
		btnTimKiemNangCao_Left.setIcon(new ImageIcon("images/iconSearch.png"));
		btnTimKiemNangCao_Left.setBounds(251, 204, 29, 27);
		panel_1.add(btnTimKiemNangCao_Left);
		
		btnTimKiemNangCao_Left.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTimKiemNangCao_Left.setBorder(new EmptyBorder(0,0,0,0));
		btnTimKiemNangCao_Left.setBackground(Color.WHITE);
		
		JLabel lblnhpTextfield = new JLabel("( Nhập 1 textfield để truy xuất khoảng bé hoặc lớn. )");
		lblnhpTextfield.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblnhpTextfield.setBounds(10, 11, 270, 26);
		panel_1.add(lblnhpTextfield);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Qu\u00FD", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 333, 180, 146);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JComboBox cbbQuy = new JComboBox();
		cbbQuy.setModel(new DefaultComboBoxModel(new String[] {"Chọn quý", "1", "2", "3", "4"}));
		cbbQuy.setBackground(Color.WHITE);
		cbbQuy.setBounds(10, 22, 108, 28);
		panel_4.add(cbbQuy);
		
		JLabel label_4 = new JLabel("Năm");
		label_4.setBounds(10, 71, 53, 23);
		panel_4.add(label_4);
		
		txtNamQuy = new JTextField();
		txtNamQuy.setColumns(10);
		txtNamQuy.setBounds(10, 95, 108, 28);
		panel_4.add(txtNamQuy);
		
		JButton btnTimKiemNangCao_Right = new JButton("");
		btnTimKiemNangCao_Right.setIcon(new ImageIcon("images/iconSearch.png"));
		btnTimKiemNangCao_Right.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnTimKiemNangCao_Right.setBorder(new EmptyBorder(0,0,0,0));
		btnTimKiemNangCao_Right.setBackground(Color.WHITE);
		btnTimKiemNangCao_Right.setBounds(130, 95, 29, 27);
		panel_4.add(btnTimKiemNangCao_Right);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(319, 75, 328, 404);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblSLngV = new JLabel("Số lượng vé");
		lblSLngV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSLngV.setBounds(10, 27, 107, 33);
		panel_5.add(lblSLngV);
		
		lblSoLuongVe = new JLabel("");
		lblSoLuongVe.setBounds(127, 27, 191, 33);
		panel_5.add(lblSoLuongVe);
		
		JLabel lblTngDoanhThu = new JLabel("Tổng doanh thu");
		lblTngDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTngDoanhThu.setBounds(10, 71, 107, 33);
		panel_5.add(lblTngDoanhThu);
		
		lblTongDoanhThu = new JLabel("");
		lblTongDoanhThu.setBounds(127, 71, 191, 33);
		panel_5.add(lblTongDoanhThu);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		btnTimKiemNangCao_Left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int flag=0;
				SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
				String a="";
				String b="";
				
				try {
						if(txtTKNC_NgayDatVeTu.getDate()!=null)
							a=f.format(txtTKNC_NgayDatVeTu.getDate());
						if(txtTKNC_NgayDatVeDen.getDate()!=null)
							b=f.format(txtTKNC_NgayDatVeDen.getDate());
						
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null,"Ngày tháng nhập ko hợp lệ.");
						flag=1;
					}
				
				if(flag==0 && txtTKNC_NgayDatVeTu.getDate()!=null && txtTKNC_NgayDatVeDen.getDate()!=null && txtTKNC_NgayDatVeTu.getDate().compareTo(txtTKNC_NgayDatVeDen.getDate())>0)
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
				if(a.equals("")==true && b.equals("")==true && txtTKNC_GiaTu.getText().equals("")==true && txtTKNC_GiaDen.getText().equals("")==true)
						flag=1;
				if(flag==0)
				{
					HoaDonBUS bus=new HoaDonBUS();
					Vector c=new Vector();
					c=bus.thongKeHD(a,b,txtTKNC_GiaTu.getText(),txtTKNC_GiaDen.getText());
					lblSoLuongVe.setText(c.get(0).toString());
					lblTongDoanhThu.setText(c.get(1).toString());
				}
			}
		});
		btnTimKiemNangCao_Right.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i=cbbQuy.getSelectedIndex();
				String nam=txtNamQuy.getText();
				String quytu="";
				String quyden="";
				Vector c=new Vector();
				HoaDonBUS bus=new HoaDonBUS();
				if(i>0)
				{
					
					if(i==1 && nam.equals("")==false)
					{
						quytu=nam+"-01-01";
						quyden=nam+"-03-01";
						c=bus.thongketheoquy(quytu,quyden);
					}
					else if(i==2 && nam.equals("")==false)
					{
						quytu=nam+"-04-01";
						quyden=nam+"-06-01";
						c=bus.thongketheoquy(quytu,quyden);
					}
					else if(i==3 && nam.equals("")==false)
					{
						quytu=nam+"-07-01";
						quyden=nam+"-09-01";
						c=bus.thongketheoquy(quytu,quyden);
					}
					else if(i==4 && nam.equals("")==false)
					{
						quytu=nam+"-10-01";
						quyden=nam+"-12-01";
						c=bus.thongketheoquy(quytu,quyden);
					}
					if(nam.equals("")==false)
					{
						lblSoLuongVe.setText(c.get(0).toString());
						lblTongDoanhThu.setText(c.get(1).toString());
					}
				}
				else JOptionPane.showMessageDialog(null,"Hãy chọn quý.");
				
				if(nam.equals("")==true)
					JOptionPane.showMessageDialog(null,"Hãy nhập năm.");
					
			}
		
	});
	}
}
