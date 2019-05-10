package DAO;
import BUS.*;
import DTO.*;
import FRM.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class GheDAO {
	
	private MySQLConnect ghe;
	public GheDAO()
	{
		ghe=new MySQLConnect("localhost","root","","quanlybanvemaybay");
		ghe.Connect();
	}
	public ArrayList<GheDTO> docDSGhe()
	{
		
		ArrayList<GheDTO> dsGhe=new ArrayList<GheDTO>();
		try {
			String qry="select * from Ghe";
			ghe.executeQuery(qry);
			while(ghe.getResult().next()==true)
			{
				GheDTO g=new GheDTO();
				g.setMaghe(ghe.getResult().getString(1));
				g.setMamaybay(ghe.getResult().getString(2));
				g.setMahangve(ghe.getResult().getString(3));
				dsGhe.add(g);
			}
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(null,"Lỗi không đọc được dữ liệu DB");}
		
		ghe.close();
		
		return dsGhe;
		
	}
	
	
	public void them(GheDTO g)
	{
		try {
			String qry="INSERT INTO Ghe(MaGhe,TenGhe,Gia) VALUES(";
			qry+="'"+g.getMaghe()+"',";
			qry+="'"+g.getMamaybay()+"',";
			qry+="'"+g.getMahangve()+"')";
			ghe.executeUpdate(qry);
			ghe.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Lỗi thêm dữ liệu DB");
		}
		
		
		
	}
	
	public void xoa(String ma)
	{
		try {
			String qry="Delete from Ghe where MaGhe= '"+ma+"'";
			ghe.executeUpdate(qry);
			ghe.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Lỗi xóa dữ liệu DB");
		}
		
	}
	
	public void sua(GheDTO g)
	{
		try {
			String qry="Update Ghe Set ";
			qry+="MaGhe="+"'"+g.getMaghe()+"'";
			qry+=",MaMayBay="+"'"+g.getMamaybay()+"'";
			qry+=",MaHangVe="+"'"+g.getMahangve()+"'";
			qry+=" "+"where MaGhe='"+g.getMaghe()+"'";
			ghe.executeUpdate(qry);
			ghe.close();
		}
		catch(Exception e) {JOptionPane.showMessageDialog(null,"Lỗi không sửa được dữ liệu DB");}
		
	}
	

}
