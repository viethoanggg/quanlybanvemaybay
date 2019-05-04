package BUS;
import DAO.*;
import DTO.*;
import FRM.*;
import java.util.ArrayList;

import DAO.HangVeDAO;
import DTO.HangVeDTO;


public class HangVeBUS {
	
	public static ArrayList<HangVeDTO> dshv;
	
	public void docDSHangVe()
	{
		HangVeDAO data=new HangVeDAO();
		if(dshv==null) dshv=new ArrayList<HangVeDTO>();
		dshv=data.docDSHangVe();
	}
	
	public void sua(int i,HangVeDTO hv)
	{
		dshv.set(i,hv);
		HangVeDAO data=new HangVeDAO();
		data.sua(hv);
	}
	public void TimKiem(String s)
	{
		if(s=="")
			docDSHangVe();
		else if(s!="")
		{
			dshv=new ArrayList<HangVeDTO>();
			HangVeDAO data=new HangVeDAO();
			dshv=data.TimKiem(s);
		}
	}
}
