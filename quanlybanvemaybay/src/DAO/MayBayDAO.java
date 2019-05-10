package DAO;
import BUS.*;
import DTO.*;
import FRM.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class MayBayDAO {
	
	private MySQLConnect MayBay;
	public MayBayDAO()
	{
		MayBay=new MySQLConnect("localhost","root","","quanlybanvemaybay");
		MayBay.Connect();
	}
	public ArrayList<MayBayDTO> docDSMayBay()
	{
		
		ArrayList<MayBayDTO> dsMayBay=new ArrayList<MayBayDTO>();
		try {
			String qry="select * from MayBay";
			MayBay.executeQuery(qry);
			while(MayBay.getResult().next()==true)
			{
				MayBayDTO c=new MayBayDTO();
				c.setMamaybay(MayBay.getResult().getString(1));
				c.setHang(MayBay.getResult().getString(2));
				c.setLoai(MayBay.getResult().getString(3));
				dsMayBay.add(c);
			}
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(null,"Lỗi không đọc được dữ liệu DB");}
		
		MayBay.close();
		
		return dsMayBay;
		
	}
	
	
	public void them(MayBayDTO mb)
	{
		try {
			String qry="INSERT INTO MayBay(MaMayBay,TenMayBay,Gia) VALUES(";
			qry+="'"+mb.getMamaybay()+"',";
			qry+="'"+mb.getHang()+"',";
			qry+="'"+mb.getLoai()+"')";
			MayBay.executeUpdate(qry);
			MayBay.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Lỗi thêm dữ liệu DB");
		}
		
		
		
	}
	
	public void xoa(String ma)
	{
		try {
			String qry="Delete from MayBay where MaMayBay= '"+ma+"'";
			MayBay.executeUpdate(qry);
			MayBay.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Lỗi xóa dữ liệu DB");
		}
		
	}
	
	public void sua(MayBayDTO c)
	{
		try {
			String qry="Update MayBay Set ";
			qry+="MaMayBay="+"'"+c.getMamaybay()+"'";
			qry+=",TenMayBay="+"'"+c.getHang()+"'";
			qry+=",Gia="+"'"+c.getLoai()+"'";
			qry+=" "+"where MaMayBay='"+c.getMamaybay()+"'";
			MayBay.executeUpdate(qry);
			MayBay.close();
		}
		catch(Exception e) {JOptionPane.showMessageDialog(null,"Lỗi không sửa được dữ liệu DB");}
		
	}
	

}
