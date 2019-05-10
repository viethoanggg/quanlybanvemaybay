package BUS;
import DAO.*;
import DTO.*;
import FRM.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tommy
 */
public class KhachHangBUS {
    public static ArrayList<KhachHangDTO> dskh;
	
	public void docDSKH() 
	{
		KhachHangDAO data=new KhachHangDAO();
		if(dskh==null) dskh=new ArrayList<KhachHangDTO>();
		dskh=data.docDSKhachHang();
		
	}
	public void them(KhachHangDTO kh)
	{
		dskh.add(kh);
		KhachHangDAO data=new KhachHangDAO();
		data.them(kh);
	}
	public void sua(int i,KhachHangDTO kh)
	{
		dskh.set(i,kh);
		KhachHangDAO data=new KhachHangDAO();
		data.sua(kh);
		
	}
        public void timKiem(String ma,String dulieu)
	{
		dskh=new ArrayList<KhachHangDTO>();
		KhachHangDAO data=new KhachHangDAO();
		dskh=data.timKiem(ma, dulieu);
	}
	public void xoa(int i,String maKH)
	{
		dskh.remove(i);
		KhachHangDAO data=new KhachHangDAO();
		data.xoa(maKH);
	}
        public void hienThi(String ma,String chuoi)
        {
                dskh=new ArrayList<KhachHangDTO>();
                KhachHangDAO data = new KhachHangDAO();
                dskh=data.hienThi(ma, chuoi);
        }
}
