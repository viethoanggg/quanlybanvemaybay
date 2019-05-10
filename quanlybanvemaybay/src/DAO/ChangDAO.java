package DAO;
import BUS.*;
import DTO.*;
import FRM.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class ChangDAO {
	
	private MySQLConnect chang;
	public ChangDAO()
	{
		chang=new MySQLConnect("localhost","root","","quanlybanvemaybay");
		chang.Connect();
	}
	public ArrayList<ChangDTO> docDSChang()
	{
		
		ArrayList<ChangDTO> dsChang=new ArrayList<ChangDTO>();
		try {
			String qry="select * from Chang";
			chang.executeQuery(qry);
			while(chang.getResult().next()==true)
			{
				ChangDTO c=new ChangDTO();
				c.setMachang(chang.getResult().getString(1));
				c.setTenchang(chang.getResult().getString(2));
				c.setGia(chang.getResult().getInt(3));
				dsChang.add(c);
			}
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(null,"Lỗi không đọc được dữ liệu DB");}
		
		chang.close();
		
		return dsChang;
		
	}
	
	
	public void them(ChangDTO mb)
	{
		try {
			String qry="INSERT INTO Chang(MaChang,TenChang,Gia) VALUES(";
			qry+="'"+mb.getMachang()+"',";
			qry+="'"+mb.getTenchang()+"',";
			qry+="'"+mb.getGia()+"')";
			chang.executeUpdate(qry);
			chang.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Lỗi thêm dữ liệu DB");
		}
		
		
		
	}
	
	public void xoa(String ma)
	{
		try {
			String qry="Delete from Chang where MaChang= '"+ma+"'";
			chang.executeUpdate(qry);
			chang.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Lỗi xóa dữ liệu DB");
		}
		
	}
	
	public void sua(ChangDTO c)
	{
		try {
			String qry="Update Chang Set ";
			qry+="MaChang="+"'"+c.getMachang()+"'";
			qry+=",TenChang="+"'"+c.getTenchang()+"'";
			qry+=",Gia="+"'"+c.getGia()+"'";
			qry+=" "+"where MaChang='"+c.getMachang()+"'";
			chang.executeUpdate(qry);
			chang.close();
		}
		catch(Exception e) {JOptionPane.showMessageDialog(null,"Lỗi không sửa được dữ liệu DB");}
		
	}
	

}
