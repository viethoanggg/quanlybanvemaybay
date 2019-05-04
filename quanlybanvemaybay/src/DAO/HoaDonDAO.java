package DAO;
import BUS.*;
import DTO.*;
import FRM.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BUS.MySQLConnect;
import DTO.HoaDonDTO;

public class HoaDonDAO {
	
	private MySQLConnect hoadon;
	public HoaDonDAO() 
	{
		hoadon=new MySQLConnect("localhost","root","","quanlybanvemaybay");
		hoadon.Connect();
	}
	
	public ArrayList docDSHD()
	{
		ArrayList<HoaDonDTO> dshd=new ArrayList<HoaDonDTO>();
		//String query="select * from hoadon";
		String query2="select hd.MaHD,MaKH,MaNV,NgayDatVe,count(MaVe) as 'sl',sum(GiaVe) as 'tongtien' from hoadon hd LEFT JOIN chitiethd ct on hd.MaHD=ct.MaHD group by hd.MaHD";
		try {
			hoadon.executeQuery(query2);
			while(hoadon.getResult().next()==true)
			{
				HoaDonDTO hd=new HoaDonDTO();
				hd.setMaHD(hoadon.getResult().getString(1));
				hd.setMaKH(hoadon.getResult().getString(2));
				hd.setMaNV(hoadon.getResult().getString(3));
				hd.setNgayDatVe(hoadon.getResult().getString(4));
				hd.setSoLuongVe(hoadon.getResult().getInt(5));
				hd.setThanhTien(hoadon.getResult().getInt(6));
				dshd.add(hd);
				
				String query="UPDATE hoadon SET ";
				query=query+"SoLuong="+"'"+hd.getSoLuongVe()+"',";
				query=query+"ThanhTien="+"'"+hd.getThanhTien()+"'";
				query=query+"where MaHD="+"'"+hd.getMaHD()+"'";
				
				hoadon.executeUpdate(query);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Lỗi kết nối Database hoa don.");
		}
		hoadon.close();
		return dshd;
	}
	
	public void them(HoaDonDTO hd)
	{
		try 
		{
			String query="INSERT INTO hoadon (MaHD,MaKH,MaNV,NgayDatVe,SoLuong,ThanhTien) VALUES (";
			query=query+"'"+hd.getMaHD()+"',";
			query=query+"'"+hd.getMaKH()+"',";
			query=query+"'"+hd.getMaNV()+"',";
			query=query+"'"+hd.getNgayDatVe()+"',";
			query=query+"'"+hd.getSoLuongVe()+"',";
			query=query+"'"+hd.getThanhTien()+"')";
			
			hoadon.executeUpdate(query);
			
		}
		catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null,"Lỗi thêm dữ liệu DAO.");
		}
		hoadon.close();
	}
	public void sua(HoaDonDTO hd)
	{
		try 
		{
			String query="UPDATE hoadon SET ";
			query=query+"MaHD="+"'"+hd.getMaHD()+"',";
			query=query+"MaKH="+"'"+hd.getMaKH()+"',";
			query=query+"MaNV="+"'"+hd.getMaNV()+"',";
			query=query+"NgayDatVe="+"'"+hd.getNgayDatVe()+"',";
			query=query+"SoLuong="+"'"+hd.getSoLuongVe()+"',";
			query=query+"ThanhTien="+"'"+hd.getThanhTien()+"'";
			query=query+"where MaHD="+"'"+hd.getMaHD()+"'";
			
			hoadon.executeUpdate(query);
			
		}
		catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null,"Lỗi sửa dữ liệu DAO.");
		}
		hoadon.close();
	}
	public void xoa(String maHD)
	{
		try 
		{
			String query="DELETE FROM hoadon WHERE ";
			query=query+"MaHD="+"'"+maHD+"'";

			hoadon.executeUpdate(query);
			
		}
		catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null,"Lỗi xóa dữ liệu DAO.");
		}
		hoadon.close();
	}
	
	public ArrayList timKiem(String ma,String dulieu)
	{
		ArrayList<HoaDonDTO> dshd=new ArrayList<HoaDonDTO>();
		try
		{
			String query="select * from hoadon where "+ma+"="+"'"+dulieu+"'";
			hoadon.executeQuery(query);
			
			while(hoadon.getResult().next()==true)
			{
				HoaDonDTO hd=new HoaDonDTO();
				hd.setMaHD(hoadon.getResult().getString(1));
				hd.setMaKH(hoadon.getResult().getString(2));
				hd.setMaNV(hoadon.getResult().getString(3));
				hd.setNgayDatVe(hoadon.getResult().getString(4));
				hd.setSoLuongVe(hoadon.getResult().getInt(5));
				hd.setThanhTien(hoadon.getResult().getInt(6));
				dshd.add(hd);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi tìm kiếm dữ liệu DAO.");
		}
	hoadon.close();
	return dshd;
	}
	
	public ArrayList timKiemNangCao(String maKH,String maNV,String nt,String nd,String gt,String gd)
	{
		ArrayList<HoaDonDTO> dshd=new ArrayList<HoaDonDTO>();
		try
		{
			String query="select * from hoadon where ";
			if(maKH!="") 
				query+=" MaKH LIKE '%"+maKH+"%' ";
			if(maNV!="") 
				query+="and MaNV LIKE '%"+maNV+"%' ";
			if(nt.equals("")==false && nd.equals("")==false) 
				query+="and NgayDatVe BETWEEN '"+nt+"' and '"+nd+"' ";
			if(gt.equals("")==false && gd.equals("")==false) 
				query+="and ThanhTien BETWEEN "+gt+" and "+gd;
			hoadon.executeQuery(query);
			
			while(hoadon.getResult().next()==true)
			{
				HoaDonDTO hd=new HoaDonDTO();
				hd.setMaHD(hoadon.getResult().getString(1));
				hd.setMaKH(hoadon.getResult().getString(2));
				hd.setMaNV(hoadon.getResult().getString(3));
				hd.setNgayDatVe(hoadon.getResult().getString(4));
				hd.setSoLuongVe(hoadon.getResult().getInt(5));
				hd.setThanhTien(hoadon.getResult().getInt(6));
				dshd.add(hd);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi tìm kiếm nâng cao DAO.");
		}
		hoadon.close();
		return dshd;
	}
}
