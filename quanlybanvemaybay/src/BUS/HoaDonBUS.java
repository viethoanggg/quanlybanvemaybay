package BUS;
import DAO.*;
import DTO.*;
import FRM.*;

import java.util.ArrayList;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;

public class HoaDonBUS {
	public static ArrayList<HoaDonDTO> dshd;
	
	public void docDSHD() 
	{
		HoaDonDAO data=new HoaDonDAO();
		if(dshd==null) dshd=new ArrayList<HoaDonDTO>();
		dshd=data.docDSHD();
		
	}
	
	public void them(HoaDonDTO hd)
	{
		dshd.add(hd);
		HoaDonDAO data=new HoaDonDAO();
		data.them(hd);
	}
	public void sua(int i,HoaDonDTO hd)
	{
		dshd.set(i,hd);
		HoaDonDAO data=new HoaDonDAO();
		data.sua(hd);
		
	}
	public void xoa(int i,String maHD)
	{
		dshd.remove(i);
		HoaDonDAO data=new HoaDonDAO();
		data.xoa(maHD);
	}
	public void timKiem(String ma,String dulieu)
	{
		dshd=new ArrayList<HoaDonDTO>();
		HoaDonDAO data=new HoaDonDAO();
		dshd=data.timKiem(ma, dulieu);
	}
	public void timKiemNangCao(String maKH,String maNV,String nt,String nd,String gt,String gd)
	{
		dshd=new ArrayList<HoaDonDTO>();
		HoaDonDAO data=new HoaDonDAO();
		dshd=data.timKiemNangCao(maKH,maNV,nt,nd,gt,gd);
	}
	
}
