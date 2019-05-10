/*
 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import BUS.*;
import DAO.*;
import FRM.*;
import java.util.Date;
/**
 *
 * @author Tommy
 */
public class KhachHangDTO {
	public String MaKH;
	public String TenKH;
	public String NgaySinh;
	public String CMND;
	public String SDT;
	public String GioiTinh;
	public String Visa;
    public KhachHangDTO(){MaKH="";TenKH="";NgaySinh="";CMND="";SDT="";GioiTinh="";Visa="";}
    public KhachHangDTO(String MaKH,String TenKH,String NgaySinh,String CMND,String SDT,String GioiTinh,String Visa)
    {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.NgaySinh = NgaySinh;
        this.CMND = CMND;
        this.SDT = SDT ;
        this.GioiTinh = GioiTinh;
        this.Visa = Visa;
    }
    public void setMaKH(String MaKH){this.MaKH=MaKH;}
    public void setTenKH(String TenKH){this.TenKH=TenKH;}
    public void setNgaySinh(String NgaySinh){this.NgaySinh=NgaySinh;}
    public void setCMND(String CMND){this.CMND=CMND;}
    public void setSDT(String SDT){this.SDT=SDT;}
    public void setGioiTinh(String GioiTinh){this.GioiTinh=GioiTinh;}
    public void setVisa(String Visa){this.Visa=Visa;}
    
    public String getMaKH(){return MaKH;}
    public String getTenKH(){return TenKH;}
    public String getNgaySinh(){return NgaySinh;}
    public String getCMND(){return CMND;}
    public String getSDT(){return SDT;}
    public String getGioiTinh(){return GioiTinh;}
    public String getVisa(){return Visa;}
    
}
