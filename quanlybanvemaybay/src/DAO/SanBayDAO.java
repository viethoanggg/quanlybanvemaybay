package DAO;
import BUS.*;
import DTO.*;
import FRM.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class SanBayDAO {
	private MySQLConnect sanbay;
	public SanBayDAO()
	{
		sanbay=new MySQLConnect("localhost","root","","quanlybanvemaybay");
		sanbay.Connect();
	}
	public ArrayList<SanBayDTO> docDSSanBay()
	{
	ArrayList<SanBayDTO> dsSanBay=new ArrayList<SanBayDTO>();
	try
	{
		String qry="select *from sanbay ";
		sanbay.executeQuery(qry);
		while(sanbay.getResult().next()==true)
		{
			SanBayDTO sb=new SanBayDTO();
			sb.setMasanbay(sanbay.getResult().getString(1));
			sb.setTensanbay(sanbay.getResult().getString(2));
			sb.setThanhpho(sanbay.getResult().getString(3));
			dsSanBay.add(sb);
		}
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null,"Lỗi không đọc được dữ liệu DB");
	}
	sanbay.close();
	
	
	return dsSanBay;
	}
	
	public void them(SanBayDTO sb)
	{
		try {
			String qry="INSERT INTO sanbay VALUES(";
			qry="'"+sb.getMasanbay()+"',";
			qry="'"+sb.getTensanbay()+"',";
			qry="'"+sb.getThanhpho()+"')";
			sanbay.executeUpdate(qry);
			sanbay.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi thêm dữ liệu DB");
		}
	}
	
	public void xoa(String ma)
	{
		try {
			String qry="DELETE FROM sanbay where MaSanBay='"+ma+"'";
			sanbay.executeQuery(qry);
			sanbay.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi xóa dữ liệu DB");
		}
	}
	
	public void sua(SanBayDTO sb)
	{
		try {
			String qry="UPDATE sanbay SET ";
			qry=qry+"MaSanBay='"+sb.getMasanbay()+"',";
			qry=qry+"TenSanBay='"+sb.getTensanbay()+"',";
			qry=qry+"ThanhPho='"+sb.getThanhpho()+"'";
			qry=qry+" WHERE MaSanBay='"+sb.getMasanbay()+"'";
			sanbay.executeUpdate(qry);
			sanbay.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi không sửa được dữ liệu DB");
		}
	}
}
