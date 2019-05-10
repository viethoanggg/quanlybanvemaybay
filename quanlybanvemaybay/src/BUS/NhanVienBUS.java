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
public class NhanVienBUS {
     public static ArrayList<NhanVienDTO> dsnv;
	
	public void docDSNV() 
	{
		NhanVienDAO data=new NhanVienDAO();
		if(dsnv==null) dsnv=new ArrayList<NhanVienDTO>();
		dsnv=data.docDSNhanVien();	
	}
}
