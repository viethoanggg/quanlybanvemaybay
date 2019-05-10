package DAO;
import BUS.*;
import DTO.*;
import FRM.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.HangVeDTO;

public class HangVeDAO {
	
	private MySQLConnect hangve;
	public HangVeDAO()
	{
		hangve=new MySQLConnect("localhost","root","","quanlybanvemaybay");
		hangve.Connect();
	}
	
	public ArrayList docDSHangVe() 
	{
		ArrayList<HangVeDTO> dshv=new ArrayList<HangVeDTO>();
		try {
			String query="select * from HangVe ";
			hangve.executeQuery(query);
			
			while(hangve.getResult().next()==true)
			{
				HangVeDTO hv =new HangVeDTO();
				hv.setMaHangVe(hangve.getResult().getString(1));
				hv.setTenHangVe(hangve.getResult().getString(2));
				hv.setGiaHangVe(hangve.getResult().getInt(3));
				
				dshv.add(hv);
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi kết nối Database hang ve.");
		}
		hangve.close();
		return dshv;
	}
	
	public void sua(HangVeDTO hv)
	{
		try {
			String query="UPDATE hangve SET ";
			query=query+"TenHangVe='"+hv.getTenHangVe()+"', ";
			query=query+"GiaHangVe='"+hv.getGiaHangVe()+"' ";
			query=query+"WHERE MaHangVe='"+hv.getMaHangVe()+"'";
			hangve.executeUpdate(query);
			
		}
		catch(Exception  e) {
			JOptionPane.showMessageDialog(null,"Lỗi thêm vào database hạng vé.");
		}
		finally {
			hangve.close();
		}

	}
	public ArrayList TimKiem(String s)
	{
		ArrayList<HangVeDTO> dshv=new ArrayList<HangVeDTO>();
		try
		{
			String query="select * from hangve where ";
			query=query+"MaHangVe like '%"+s+"%'";
			query=query+" OR TenHangVe LIKE '%"+s+"%'";
			hangve.executeQuery(query);
			
			while(hangve.getResult().next()==true)
			{
				HangVeDTO hv=new HangVeDTO();
				hv.setMaHangVe(hangve.getResult().getString(1));
				hv.setTenHangVe(hangve.getResult().getString(2));
				hv.setGiaHangVe(hangve.getResult().getInt(3));
				
				dshv.add(hv);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Lỗi tìm kiếm database hạng vé.");
		}
		finally {
			hangve.close();
		}
		return dshv;
	}

}
