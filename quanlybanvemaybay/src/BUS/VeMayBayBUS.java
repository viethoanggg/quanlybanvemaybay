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
public class VeMayBayBUS {
    public static ArrayList<VeMayBayDTO> dsvmb;
	
	public void docDSVMB() 
	{
		VeMayBayDAO data=new VeMayBayDAO();
		if(dsvmb==null) dsvmb=new ArrayList<VeMayBayDTO>();
		dsvmb=data.docDSVeMayBay();
		
	}
	
	public void them(VeMayBayDTO vmb)
	{
		dsvmb.add(vmb);
		VeMayBayDAO data=new VeMayBayDAO();
		data.them(vmb);
	}
	public void sua(int i,VeMayBayDTO vmb)
	{
		dsvmb.set(i,vmb);
		VeMayBayDAO data=new VeMayBayDAO();
		data.sua(vmb);
		
	}
	public void xoa(int i,String maVe)
	{
		dsvmb.remove(i);
		VeMayBayDAO data=new VeMayBayDAO();
		data.xoa(maVe);
	}
        public void timKiem(String ma,String dulieu)
	{
		dsvmb=new ArrayList<VeMayBayDTO>();
		VeMayBayDAO data=new VeMayBayDAO();
		dsvmb=data.timKiem(ma, dulieu);
	}
        public void hienThi(String ma,String chuoi)
        {
                dsvmb=new ArrayList<VeMayBayDTO>();
                VeMayBayDAO data = new VeMayBayDAO();
                dsvmb=data.hienThi(ma, chuoi);
        }
        
}
