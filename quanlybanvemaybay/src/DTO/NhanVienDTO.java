/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tommy
 */
package DTO;
import BUS.*;
import DAO.*;
import FRM.*;
public class NhanVienDTO {
    String MaNV;
    String TenNV;
    String ChucVu;
    int Luong;
    String TenTK;
    public NhanVienDTO(){MaNV="";TenNV="";ChucVu="";Luong=0;TenTK="";}
    NhanVienDTO(String MaNV,String TenNV,String ChucVu,int Luong,String TenTK)
    {
        this.MaNV=MaNV;
        this.TenNV=TenNV;
        this.ChucVu=ChucVu;
        this.Luong=Luong;
        this.TenTK=TenTK;
    }
    public void setMaNV(String MaNV){this.MaNV=MaNV;}
    public void setTenNV(String TenNV){this.TenNV=TenNV;}
    public void setChucVu(String ChucVu){this.ChucVu=ChucVu;}
    public void setLuong(int Luong){this.Luong=Luong;}
    public void setTenTK(String TenTK){this.TenTK=TenTK;}
    
    public String getMaNV(){return MaNV;}
    public String getTenNV(){return TenNV;}
    public String getChucVu(){return ChucVu;}
    public int getLuong(){return Luong;}
    public String getTenTK(){return TenTK;}
}
