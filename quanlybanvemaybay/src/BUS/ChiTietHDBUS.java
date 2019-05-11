package BUS;
import DAO.*;
import DTO.*;
import FRM.*;

import java.util.ArrayList;

import DAO.ChiTietHDDAO;
import DTO.ChiTietHDDTO;

public class ChiTietHDBUS {
	public static ArrayList<ChiTietHDDTO> dscthd;
	
	public void docDSCTHD()
	{
		ChiTietHDDAO data =new ChiTietHDDAO();
		if(dscthd==null) dscthd=new ArrayList<ChiTietHDDTO>();
		dscthd=data.docDSCTHD();
	}
	
	public void xemCTHD(String mahd)
	{
		ChiTietHDDAO data =new ChiTietHDDAO();
		dscthd=new ArrayList<ChiTietHDDTO>();
		dscthd=data.xemCTHD(mahd);
	}
	
	public void TimKiemTheoMa(String ma,String dulieu)
	{
		dscthd=new ArrayList<ChiTietHDDTO>();
		ChiTietHDDAO data=new ChiTietHDDAO();
		dscthd=data.TimKiemTheoMa(ma,dulieu);
	}
	public void TimKiemTheoTen(String ten,String dulieu)
	{
		dscthd=new ArrayList<ChiTietHDDTO>();
		ChiTietHDDAO data=new ChiTietHDDAO();
		dscthd=data.TimKiemTheoTen(ten,dulieu);
	}
	public void xoa(String maHD,String maVe,int vitri)
	{
		dscthd.remove(vitri);
		ChiTietHDDAO data=new ChiTietHDDAO();
		data.xoa(maHD,maVe);
	}
	
	public void timKiemNangCao(String gt,String gd)
	{
		dscthd=new ArrayList<ChiTietHDDTO>();
		ChiTietHDDAO data=new ChiTietHDDAO();
		dscthd=data.timKiemNangCao(gt,gd);
	}
	public void them(ChiTietHDDTO ct)
	{
		dscthd.add(ct);
		ChiTietHDDAO data=new ChiTietHDDAO();
		data.them(ct);
	}
}
