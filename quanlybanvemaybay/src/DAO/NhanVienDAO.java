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
public class NhanVienDAO {
    private MySQLConnect nhanvien;
    public NhanVienDAO()
	{
		nhanvien=new MySQLConnect("localhost","root","","projectdatabase");
		nhanvien.Connect();
	}	
	public ArrayList docDSNhanVien() 
	{
		ArrayList<NhanVienDTO> dsnv=new ArrayList<>();
		try {
			String query="select * from nhanvien ";
			nhanvien.executeQuery(query);
			
			while(nhanvien.getResult().next()==true)
			{
				NhanVienDTO nv =new NhanVienDTO();
				nv.setMaNV(nhanvien.getResult().getString(1));
				nv.setTenNV(nhanvien.getResult().getString(2));
                                nv.setChucVu(nhanvien.getResult().getString(3));
                                nv.setLuong(nhanvien.getResult().getInt(4));
                                nv.setTenTK(nhanvien.getResult().getString(5));	
				dsnv.add(nv);
			}		
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi kết nối Database.");
		}
		nhanvien.close();
		return dsnv;
	}
}
