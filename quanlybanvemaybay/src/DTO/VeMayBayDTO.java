/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import BUS.*;
import DAO.*;
import FRM.*;

/**
 *
 * @author Tommy
 */
public class VeMayBayDTO {
	public String MaVe;
	public String MaGhe;
	public String MaKH;
	public String MaCB;
	public String TenHangVe;
	public  int GiaVe;
    public  String Hang;
    public  int GiaTriGiam;
    public  String Visa;
    public VeMayBayDTO(){MaVe="";MaGhe="";MaKH="";MaCB="";TenHangVe="";GiaVe=0;Hang="";GiaTriGiam=0;Visa="";}
    public VeMayBayDTO(String MaVe,String MaGhe,String MaKH,String MaCB,String TenHangVe,int GiaVe,String Hang,int GiaTriGiam,String Visa)
    {
        this.MaVe=MaVe;
        this.MaGhe=MaGhe;
        this.MaKH=MaKH;
        this.MaCB=MaCB;
        this.TenHangVe=TenHangVe;
        this.GiaVe=GiaVe;
        this.Hang=Hang;
        this.GiaTriGiam=GiaTriGiam;
        this.Visa=Visa;
    }
    public void setMaVe(String MaVe){this.MaVe=MaVe;}
    public void setMaGhe(String MaGhe){this.MaGhe=MaGhe;}
    public void setMaKH(String MaKH){this.MaKH=MaKH;}
    public void setMaCB(String MaCB){this.MaCB=MaCB;}
    public void setTenHangVe(String TenHangVe){this.TenHangVe=TenHangVe;}
    public void setGiaVe(int GiaVe){this.GiaVe=GiaVe;}
    public void setHang(String Hang){this.Hang=Hang;}
    public void setGiaTriGiam(int GiaTriGiam){this.GiaTriGiam=GiaTriGiam;}
    public void setVisa(String Visa){this.Visa=Visa;}
    
    public String getMaVe(){return MaVe;}
    public String getMaGhe(){return MaGhe;}
    public String getMaKH(){return MaKH;}
    public String getMaCB(){return MaCB;}
    public String getTenHangVe(){return TenHangVe;}
    public int getGiaVe(){return GiaVe;}
    public String getHang(){return Hang;}
    public int getGiaTriGiam(){return GiaTriGiam;}
    public String getVisa(){return Visa;}
   
}
