package DAO;
import BUS.*;
import DTO.*;
import FRM.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tommy
 */
public class KhachHangDAO {
    private MySQLConnect khachhang;
	public KhachHangDAO()
	{
		khachhang=new MySQLConnect("localhost","root","","quanlybanvemaybay");
		khachhang.Connect();
	}
	
	public ArrayList docDSKhachHang() 
	{
		ArrayList<KhachHangDTO> dskh=new ArrayList<>();
		try {
			String query="select * from khachhang ";
			khachhang.executeQuery(query);
			
			while(khachhang.getResult().next()==true)
			{
				KhachHangDTO kh =new KhachHangDTO();
				kh.setMaKH(khachhang.getResult().getString(1));
				kh.setTenKH(khachhang.getResult().getString(2));
                                kh.setNgaySinh(khachhang.getResult().getString(3));
                                kh.setCMND(khachhang.getResult().getString(4));
                                kh.setSDT(khachhang.getResult().getString(5));
                                kh.setGioiTinh(khachhang.getResult().getString(6));
                                kh.setVisa(khachhang.getResult().getString(7));
				
				dskh.add(kh);
			}		
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi kết nối Database.");
		}
		khachhang.close();
		return dskh;
	}
        public void them(KhachHangDTO kh)
	{
		try 
		{
			String query="INSERT INTO khachhang (MaKH,TenKH,NgaySinh,CMND,SDT,GioiTinh,Visa) VALUES (";
			query=query+"'"+kh.getMaKH()+"',";
			query=query+"'"+kh.getTenKH()+"',";
			query=query+"'"+kh.getNgaySinh()+"',";
			query=query+"'"+kh.getCMND()+"',";
			query=query+"'"+kh.getSDT()+"',";
                        query=query+"'"+kh.getGioiTinh()+"',";
			query=query+"'"+kh.getVisa()+"')";
			
			khachhang.executeUpdate(query);
			
		}
		catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null,"Lỗi thêm dữ liệu vào database !");
		}
		khachhang.close();
	}
        public void sua(KhachHangDTO kh)
	{
		try {
			String query="UPDATE khachhang SET ";
			query=query+" TenKH="+"'"+kh.getTenKH()+"',";
			query=query+" NgaySinh="+"'"+kh.getNgaySinh()+"',";
			query=query+" CMND="+"'"+kh.getCMND()+"',";
			query=query+" SDT="+"'"+kh.getSDT()+"',";
                        query=query+" GioiTinh="+"'"+kh.getGioiTinh()+"',";
			query=query+" Visa="+"'"+kh.getVisa()+"'";
			query=query+" where MaKH="+"'"+kh.getMaKH()+"'";
			khachhang.executeUpdate(query);	
		}
		catch(Exception  e) {
			JOptionPane.showMessageDialog(null,"Lỗi Database !");
		}
                khachhang.close();
	}
        public void xoa(String maKH)
	{
		try 
		{
			String query="DELETE FROM khachhang WHERE ";
			query=query+"MaKH="+"'"+maKH+"'";

			khachhang.executeUpdate(query);
			
		}
		catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null,"Lỗi xóa dữ liệu database");
		}
		khachhang.close();
	}
        public ArrayList timKiem(String ma,String dulieu)
	{
		ArrayList<KhachHangDTO> dskh=new ArrayList<KhachHangDTO>();
		try
		{
			String query="select * from khachhang where "+ma+"="+"'"+dulieu+"'";
			khachhang.executeQuery(query);
			
			while(khachhang.getResult().next()==true)
			{
				KhachHangDTO kh =new KhachHangDTO();
				kh.setMaKH(khachhang.getResult().getString(1));
				kh.setTenKH(khachhang.getResult().getString(2));
                                kh.setNgaySinh(khachhang.getResult().getString(3));
                                kh.setCMND(khachhang.getResult().getString(4));
                                kh.setSDT(khachhang.getResult().getString(5));
                                kh.setGioiTinh(khachhang.getResult().getString(6));
                                kh.setVisa(khachhang.getResult().getString(7));
				dskh.add(kh);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi tìm kiếm dữ liệu DAO.");
		}
	khachhang.close();
	return dskh;
	}
        public ArrayList hienThi(String ma,String chuoi)
	{
		ArrayList<KhachHangDTO> dskh=new ArrayList<KhachHangDTO>();
		try
		{       //query+="and MaNV LIKE '%"+maNV+"%' ";
			String query="select * from khachhang where "+ma+" like "+" '%"+chuoi+"%' ";
			khachhang.executeQuery(query);
			
			while(khachhang.getResult().next()==true)
			{
                                KhachHangDTO kh =new KhachHangDTO();
				kh.setMaKH(khachhang.getResult().getString(1));
				kh.setTenKH(khachhang.getResult().getString(2));
                                kh.setNgaySinh(khachhang.getResult().getString(3));
                                kh.setCMND(khachhang.getResult().getString(4));
                                kh.setSDT(khachhang.getResult().getString(5));
                                kh.setGioiTinh(khachhang.getResult().getString(6));
                                kh.setVisa(khachhang.getResult().getString(7));
				dskh.add(kh);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi tìm kiếm dữ liệu DAO.");
		}
	khachhang.close();
	return dskh;
	}
        public int thongKeDi_Mua(String chuoi)
        {
            int a=0;
            try
            {
                String query="select count(*) as SL   from khachhang where MaKH like "+" '%"+chuoi+"%' ";
                khachhang.executeQuery(query);
                while(khachhang.getResult().next()==true)
                {
                   //a.add(String.valueOf(khachhang.getResult().getInt(1)));
                     a=khachhang.getResult().getInt(1);
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Lỗi thống kê !");
            }
            khachhang.close();
            return a;
        }
}
        
