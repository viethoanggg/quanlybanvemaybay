package DAO;
import BUS.*;
import DTO.*;
import FRM.*;
import java.util.ArrayList;
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
public class VeMayBayDAO {
    private MySQLConnect vemaybay;
	public VeMayBayDAO()
	{
		vemaybay=new MySQLConnect("localhost","root","","quanlybanvemaybay");
		vemaybay.Connect();
	}
	
	public ArrayList docDSVeMayBay() 
	{
		ArrayList<VeMayBayDTO> dsvmb=new ArrayList<>();
		try {
			String query="select * from vemaybay ";
			vemaybay.executeQuery(query);
			
			while(vemaybay.getResult().next()==true)
			{
				VeMayBayDTO vmb =new VeMayBayDTO();
				vmb.setMaVe(vemaybay.getResult().getString(1));
				vmb.setMaGhe(vemaybay.getResult().getString(2));
				vmb.setMaKH(vemaybay.getResult().getString(3));
                                vmb.setMaCB(vemaybay.getResult().getString(4));
                                vmb.setTenHangVe(vemaybay.getResult().getString(5));
                                vmb.setGiaVe(vemaybay.getResult().getInt(6));
                                vmb.setHang(vemaybay.getResult().getString(7));
                                vmb.setGiaTriGiam(vemaybay.getResult().getDouble(8));
                                vmb.setVisa(vemaybay.getResult().getString(9));
				
				dsvmb.add(vmb);
			}
                        
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi kết nối Database.");
		}
		vemaybay.close();
		return dsvmb;
	}
        public void them(VeMayBayDTO vmb)
	{
		try 
		{
			String query="INSERT INTO vemaybay (MaVe,MaGhe,MaKH,MaCB,TenHangVe,GiaVe,Hang,MaGiam,GiaTriGiam,Visa) VALUES (";
			query=query+"'"+vmb.getMaVe()+"',";
			query=query+"'"+vmb.getMaGhe()+"',";
			query=query+"'"+vmb.getMaKH()+"',";
			query=query+"'"+vmb.getMaCB()+"',";
			query=query+"'"+vmb.getTenHangVe()+"',";
                        query=query+"'"+vmb.getGiaVe()+"',";
                        query=query+"'"+vmb.getHang()+"',";
                        query=query+"'"+vmb.getGiaTriGiam()+"',";
			query=query+"'"+vmb.getVisa()+"')";
			
			vemaybay.executeUpdate(query);
			
		}
		catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null,"Lỗi thêm dữ liệu vào database !");
		}
		vemaybay.close();
	}
        public void sua(VeMayBayDTO vmb)
	{
		try {
			String query="UPDATE vemaybay SET ";
			query=query+" MaGhe="+"'"+vmb.getMaGhe()+"',";
			query=query+" MaKH="+"'"+vmb.getMaKH()+"',";
			query=query+" MaCB="+"'"+vmb.getMaCB()+"',";
			query=query+" TenHangVe="+"'"+vmb.getTenHangVe()+"',";
                        query=query+" GiaVe="+"'"+vmb.getGiaVe()+"',";
                        query=query+" Hang="+"'"+vmb.getHang()+"',";
                        query=query+" GiaTriGiam="+"'"+vmb.getGiaTriGiam()+"',";
			query=query+" Visa="+"'"+vmb.getVisa()+"'";
			query=query+" where MaVe="+"'"+vmb.getMaVe()+"'";
			vemaybay.executeUpdate(query);	
		}
		catch(Exception  e) {
			JOptionPane.showMessageDialog(null,"Lỗi Database !");
		}
                vemaybay.close();
	}
        public void xoa(String maVe)
	{
		try 
		{
			String query="DELETE FROM vemaybay WHERE ";
			query=query+"MaVe="+"'"+maVe+"'";

			vemaybay.executeUpdate(query);
			
		}
		catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null,"Lỗi xóa dữ liệu database");
		}
		vemaybay.close();
	}
        public ArrayList timKiem(String ma,String dulieu)
	{
		ArrayList<VeMayBayDTO> dsvmb=new ArrayList<VeMayBayDTO>();
		try
		{
			String query="select * from vemaybay where "+ma+"="+"'"+dulieu+"'";
			vemaybay.executeQuery(query);
			
			while(vemaybay.getResult().next()==true)
			{
				VeMayBayDTO vmb=new VeMayBayDTO();
				vmb.setMaVe(vemaybay.getResult().getString(1));
				vmb.setMaGhe(vemaybay.getResult().getString(2));
				vmb.setMaKH(vemaybay.getResult().getString(3));
				vmb.setMaCB(vemaybay.getResult().getString(4));
                                vmb.setTenHangVe(vemaybay.getResult().getString(5));
				vmb.setGiaVe(vemaybay.getResult().getInt(6));
				vmb.setHang(vemaybay.getResult().getString(7));
                                vmb.setGiaTriGiam(vemaybay.getResult().getDouble(8));
                                vmb.setVisa(vemaybay.getResult().getString(9));
				dsvmb.add(vmb);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi tìm kiếm dữ liệu DAO.");
		}
	vemaybay.close();
	return dsvmb;
	}
        public ArrayList hienThi(String ma,String chuoi)
	{
		ArrayList<VeMayBayDTO> dsvmb=new ArrayList<VeMayBayDTO>();
		try
		{       //query+="and MaNV LIKE '%"+maNV+"%' ";
			String query="select * from vemaybay where "+ma+" like "+" '%"+chuoi+"%' ";
			vemaybay.executeQuery(query);
			
			while(vemaybay.getResult().next()==true)
			{
				VeMayBayDTO vmb=new VeMayBayDTO();
				vmb.setMaVe(vemaybay.getResult().getString(1));
				vmb.setMaGhe(vemaybay.getResult().getString(2));
				vmb.setMaKH(vemaybay.getResult().getString(3));
				vmb.setMaCB(vemaybay.getResult().getString(4));
                                vmb.setTenHangVe(vemaybay.getResult().getString(5));
				vmb.setGiaVe(vemaybay.getResult().getInt(6));
				vmb.setHang(vemaybay.getResult().getString(7));
                                vmb.setGiaTriGiam(vemaybay.getResult().getDouble(8));
                                vmb.setVisa(vemaybay.getResult().getString(9));
				dsvmb.add(vmb);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi tìm kiếm dữ liệu DAO.");
		}
	vemaybay.close();
	return dsvmb;
	}
}
