package DAO;
import BUS.*;
import DTO.*;
import FRM.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
public class ChuyenBayDAO {
	
	private MySQLConnect chuyenbay;
	public ChuyenBayDAO()
	{
		chuyenbay=new MySQLConnect("localhost","root","","quanlybanvemaybay");
		chuyenbay.Connect();
	}
	public ArrayList<ChuyenBayDTO> docDSChuyenBay()
	{
		
		ArrayList<ChuyenBayDTO> dschuyenbay=new ArrayList<ChuyenBayDTO>();
		try {
			String qry="SELECT chuyenbay.MaMayBay,chuyenbay.MaChuyenBay,chuyenbay.MaChang,chuyenbay.ThoiGianDi,chuyenbay.ThoiGianDen,chuyenbay.NgayDi,chuyenbay.NgayDen,chuyenbay.SoGheConTrong,chang.TenChang from chuyenbay,chang where chuyenbay.MaChang=chang.MaChang";
			chuyenbay.executeQuery(qry);
			while(chuyenbay.getResult().next()==true)
			{
				ChuyenBayDTO cb=new ChuyenBayDTO();
				ChangDTO c=new ChangDTO();
				cb.setMamaybay(chuyenbay.getResult().getString(1));
				cb.setMachuyenbay(chuyenbay.getResult().getString(2));
				cb.setMachang(chuyenbay.getResult().getString(3));
				cb.setThoigiandi(chuyenbay.getResult().getString(4));
				cb.setThoigianden(chuyenbay.getResult().getString(5));
				cb.setNgaydi(chuyenbay.getResult().getString(6));
				cb.setNgayden(chuyenbay.getResult().getString(7));
				cb.setSoghetrong(chuyenbay.getResult().getInt(8));
				cb.setTenchang(chuyenbay.getResult().getString(9));
				dschuyenbay.add(cb);
			}
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(null,"Lỗi không đọc được dữ liệu DB");}
		
		chuyenbay.close();
		
		return dschuyenbay;
		
	}
	
	
	public void them(ChuyenBayDTO cb)
	{
		try {
			String qry="INSERT INTO chuyenbay VALUES(";
			qry+="'"+cb.getMamaybay()+"',";
			qry+="'"+cb.getMachuyenbay()+"',";
			qry+="'"+cb.getMachang()+"',";
			qry+="'"+cb.getThoigiandi()+"',";
			qry+="'"+cb.getThoigianden()+"',";
			qry+="'"+cb.getNgaydi()+"',";
			qry+="'"+cb.getNgayden()+"',";
			qry+="'"+cb.getSoghetrong()+"')";
			chuyenbay.executeUpdate(qry);
			chuyenbay.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Lỗi thêm dữ liệu DB");
		}
		
		
		
	}
	
	public void xoa(String ma)
	{
		try {
			String qry="Delete from chuyenbay where Machuyenbay= '"+ma+"'";
			chuyenbay.executeUpdate(qry);
			chuyenbay.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Lỗi xóa dữ liệu DB");
		}
		
	}
	
	public void sua(ChuyenBayDTO cb)
	{
		try {
			String qry="Update chuyenbay Set ";
			qry+="MaMayBay="+"'"+cb.getMamaybay()+"'";
			qry+=",MaChuyenBay="+"'"+cb.getMachuyenbay()+"'";
			qry+=",MaChang="+"'"+cb.getMachang()+"'";
			qry+=",ThoiGianDi="+"'"+cb.getThoigiandi()+"'";
			qry+=",ThoiGianDen="+"'"+cb.getThoigianden()+"'";
			qry+=",NgayDi="+"'"+cb.getNgaydi()+"'";
			qry+=",NgayDen="+"'"+cb.getNgayden()+"'";
			qry+=" "+"where Machuyenbay='"+cb.getMachuyenbay()+"'";
			chuyenbay.executeUpdate(qry);
			chuyenbay.close();
		}
		catch(Exception e) {JOptionPane.showMessageDialog(null,"Lỗi không sửa được dữ liệu DB");}
		
	}
	public void capnhatSoGheTrong()
	{
		String query="Update chuyenbay,maybay set SoGheConTrong=SoLuongGhe where chuyenbay.MaMayBay=maybay.MaMayBay ";
		chuyenbay.executeUpdate(query);
		ChuyenBayBUS bus=new ChuyenBayBUS();
		bus.docDSChuyenBay();
		VeMayBayBUS bus1=new VeMayBayBUS();
		bus1.docDSVMB();
		for(ChuyenBayDTO cb:ChuyenBayBUS.dsChuyenBay)
		{
			for(VeMayBayDTO v:VeMayBayBUS.dsvmb)
			{
				if(cb.getMachuyenbay().equals(v.getMaCB()))
				{
						cb.setSoghetrong(cb.getSoghetrong()-1);
						String qry="update chuyenbay set SoGheConTrong="+cb.getSoghetrong()+" where MaChuyenBay='"+cb.getMachuyenbay()+"'";
						chuyenbay.executeUpdate(qry);
				}
			}
		}
		
		chuyenbay.close();
	}
	public ArrayList timkiemtheongay(String ngaydi,String ngaydiden)
	{
		ArrayList<ChuyenBayDTO> dschuyenbay=new ArrayList<ChuyenBayDTO>();
		try
		{
			String qry="SELECT chuyenbay.MaMayBay,chuyenbay.MaChuyenBay,chuyenbay.MaChang,chuyenbay.ThoiGianDi,chuyenbay.ThoiGianDen,chuyenbay.NgayDi,chuyenbay.NgayDen,chuyenbay.SoGheConTrong,chang.TenChang from chuyenbay,chang where chuyenbay.MaChang=chang.MaChang ";
			if(ngaydi.equals("")==false && ngaydiden.equals("")==false)
				qry+=" and NgayDi Between '"+ngaydi+"' and '"+ngaydiden+"'";
			else if(ngaydi.equals("")==false && ngaydiden.equals("")!=false)
				qry+=" and NgayDi >= '"+ngaydi+"'";
			else if(ngaydi.equals("")!=false && ngaydiden.equals("")==false)
				qry+=" and NgayDi <= '"+ngaydiden+"'";
			chuyenbay.executeQuery(qry);
			
			while(chuyenbay.getResult().next()==true)
			{
				ChuyenBayDTO cb=new ChuyenBayDTO();
				cb.setMamaybay(chuyenbay.getResult().getString(1));
				cb.setMachuyenbay(chuyenbay.getResult().getString(2));
				cb.setMachang(chuyenbay.getResult().getString(3));
				cb.setThoigiandi(chuyenbay.getResult().getString(4));
				cb.setThoigianden(chuyenbay.getResult().getString(5));
				cb.setNgaydi(chuyenbay.getResult().getString(6));
				cb.setNgayden(chuyenbay.getResult().getString(7));
				cb.setSoghetrong(chuyenbay.getResult().getInt(8));
				cb.setTenchang(chuyenbay.getResult().getString(9));
				dschuyenbay.add(cb);
			}
			
		}
		catch(Exception e) {JOptionPane.showMessageDialog(null,"Lỗi không tìm kiếm được dữ liệu DB");}
		chuyenbay.close();
		return dschuyenbay;
	}
	
	public ArrayList timkiemtheogio(String thoigianditu,String thoigiandiden)
	{
		ArrayList<ChuyenBayDTO> dschuyenbay=new ArrayList<ChuyenBayDTO>();
		try
		{
			String qry="selct * from chuyenbay where MaChuyenBay LIKE '%%' ";
			if(thoigianditu.equals("")==false && thoigiandiden.equals("")==false)
				qry+=" and ThoiGianDi Between '"+thoigianditu+"' and '"+thoigiandiden+"'";
			else if(thoigianditu.equals("")==false && thoigiandiden.equals("")!=false)
				qry+=" and ThoiGianDi >= '"+thoigianditu+"'";
			else if(thoigianditu.equals("")!=false && thoigiandiden.equals("")==false)
				qry+=" and ThoiGianDi <= '"+thoigiandiden+"'";
			chuyenbay.executeQuery(qry);
			
			while(chuyenbay.getResult().next()==true)
			{
				ChuyenBayDTO cb=new ChuyenBayDTO();
				cb.setMamaybay(chuyenbay.getResult().getString(1));
				cb.setMachuyenbay(chuyenbay.getResult().getString(2));
				cb.setMachang(chuyenbay.getResult().getString(3));
				cb.setThoigiandi(chuyenbay.getResult().getString(4));
				cb.setThoigianden(chuyenbay.getResult().getString(5));
				cb.setNgaydi(chuyenbay.getResult().getString(6));
				cb.setNgayden(chuyenbay.getResult().getString(7));
				cb.setSoghetrong(chuyenbay.getResult().getInt(8));
				cb.setTenchang(chuyenbay.getResult().getString(9));
				dschuyenbay.add(cb);
			}
			chuyenbay.close();
		}
		catch(Exception e) {JOptionPane.showMessageDialog(null,"Lỗi không tìm kiếm được dữ liệu DB");}
		return dschuyenbay;
	}

}
