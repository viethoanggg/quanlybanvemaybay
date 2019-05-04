package DAO;
import BUS.*;
import DTO.*;
import FRM.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BUS.MySQLConnect;
import DTO.ChiTietHDDTO;

public class ChiTietHDDAO {
	
	private MySQLConnect cthd;
	public ChiTietHDDAO() 
	{
		cthd =new MySQLConnect("localhost","root","","quanlybanvemaybay");
		cthd.Connect();
		
	}
	public ArrayList docDSCTHD()
	{
		ArrayList<ChiTietHDDTO> dscthd=new ArrayList<ChiTietHDDTO>();
		try
		{
			String query="select * from chitiethd";
			cthd.executeQuery(query);
			
			while(cthd.getResult().next()==true)
			{
				ChiTietHDDTO ct=new ChiTietHDDTO();
				ct.setMaHD(cthd.getResult().getString(1));
				ct.setMaVe(cthd.getResult().getString(2));
				ct.setMaHangVe(cthd.getResult().getString(3));
				ct.setTenKH(cthd.getResult().getString(4));
				ct.setTenChang(cthd.getResult().getString(5));
				ct.setGiaVe(cthd.getResult().getInt(6));
				ct.setVISA(cthd.getResult().getString(7));
				
				dscthd.add(ct);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi kết nối Database chitiethd.");
		}
		cthd.close();
		return dscthd;
	}
	public ArrayList xemCTHD(String mahd)
	{
		ArrayList<ChiTietHDDTO> dscthd=new ArrayList<ChiTietHDDTO>();
		
		try
		{
			String query="select hd.MaHD,MaVe,MaHangVe,TenKH,TenChang,GiaVe,VISA from chitiethd ct,hoadon hd where hd.MaHD=ct.MaHD and ct.MaHD='"+mahd+"'";
			cthd.executeQuery(query);
			
			while(cthd.getResult().next()==true)
			{
				ChiTietHDDTO ct=new ChiTietHDDTO();
				ct.setMaHD(cthd.getResult().getString(1));
				ct.setMaVe(cthd.getResult().getString(2));
				ct.setMaHangVe(cthd.getResult().getString(3));
				ct.setTenKH(cthd.getResult().getString(4));
				ct.setTenChang(cthd.getResult().getString(5));
				ct.setGiaVe(cthd.getResult().getInt(6));
				ct.setVISA(cthd.getResult().getString(7));
				
				dscthd.add(ct);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi kết nối Database.");
		}
		cthd.close();
		return dscthd;
	}
	
	public ArrayList TimKiemTheoMa(String ma,String dulieu)
	{
		ArrayList<ChiTietHDDTO> dscthd=new ArrayList<ChiTietHDDTO>();
		
		try
		{
			String query="select * from chitiethd where "+ma+"= "+"'"+dulieu+"'";
			cthd.executeQuery(query);
			
			while(cthd.getResult().next()==true)
			{
				ChiTietHDDTO ct=new ChiTietHDDTO();
				ct.setMaHD(cthd.getResult().getString(1));
				ct.setMaVe(cthd.getResult().getString(2));
				ct.setMaHangVe(cthd.getResult().getString(3));
				ct.setTenKH(cthd.getResult().getString(4));
				ct.setTenChang(cthd.getResult().getString(5));
				ct.setGiaVe(cthd.getResult().getInt(6));
				ct.setVISA(cthd.getResult().getString(7));
				
				dscthd.add(ct);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi kết tìm kiếm cthd DAO.");
		}
		
		cthd.close();
		return dscthd;
	}
	public ArrayList TimKiemTheoTen(String ten,String dulieu)
	{
		ArrayList<ChiTietHDDTO> dscthd=new ArrayList<ChiTietHDDTO>();
		
		try
		{
			String query="select * from chitiethd where "+ten+" LIKE "+"'%"+dulieu+"%'";
			cthd.executeQuery(query);
			
			while(cthd.getResult().next()==true)
			{
				ChiTietHDDTO ct=new ChiTietHDDTO();
				ct.setMaHD(cthd.getResult().getString(1));
				ct.setMaVe(cthd.getResult().getString(2));
				ct.setMaHangVe(cthd.getResult().getString(3));
				ct.setTenKH(cthd.getResult().getString(4));
				ct.setTenChang(cthd.getResult().getString(5));
				ct.setGiaVe(cthd.getResult().getInt(6));
				ct.setVISA(cthd.getResult().getString(7));
				
				dscthd.add(ct);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi kết tìm kiếm cthd DAO.");
		}
		
		cthd.close();
		return dscthd;
	}
	
	public ArrayList timKiemNangCao(String gt,String gd)
	{
		ArrayList<ChiTietHDDTO> dscthd=new ArrayList<ChiTietHDDTO>();
		
		try
		{
			String query="select * from chitiethd where GiaVe BETWEEN "+gt+" and "+gd+"";
			cthd.executeQuery(query);
			
			while(cthd.getResult().next()==true)
			{
				ChiTietHDDTO ct=new ChiTietHDDTO();
				ct.setMaHD(cthd.getResult().getString(1));
				ct.setMaVe(cthd.getResult().getString(2));
				ct.setMaHangVe(cthd.getResult().getString(3));
				ct.setTenKH(cthd.getResult().getString(4));
				ct.setTenChang(cthd.getResult().getString(5));
				ct.setGiaVe(cthd.getResult().getInt(6));
				ct.setVISA(cthd.getResult().getString(7));
				System.out.print("1 ");
				dscthd.add(ct);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi tìm kiếm nâng cao DAO.");
		}
		
		cthd.close();
		return dscthd;
	}
	public void xoa(String maHD,String maVe)
	{
		String query="delete from chitiethd where MaHD = "+ "'"+maHD+"'"+" and MaVe = "+"'"+maVe+"'";
		try {
			cthd.executeUpdate(query);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi xóa Database chi tiet hd.");
		}
		cthd.close();
	}
	public MySQLConnect getCthd() {
		return cthd;
	}
	public void setCthd(MySQLConnect cthd) {
		this.cthd = cthd;
	}
	
}
