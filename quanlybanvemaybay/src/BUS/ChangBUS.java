package BUS;
import DAO.*;
import DTO.*;
import FRM.*;

import java.util.ArrayList;

public class ChangBUS {
	public static ArrayList<ChangDTO> dsChang=new ArrayList<ChangDTO>();
	public ChangBUS()
	{
		
	}
	public void docDSChang()
	{
		ChangDAO data=new ChangDAO();
		if(dsChang==null)
			dsChang=new ArrayList<ChangDTO>();
		dsChang=data.docDSChang();
	}
	
	public void them(ChangDTO c)
	{
		ChangDAO data=new ChangDAO();
		data.them(c);
		dsChang.add(c);
	}
	
	public void xoa(int i,String ma)
	{
		dsChang.remove(i);
		ChangDAO data=new ChangDAO();
		data.xoa(ma);
		
	}
	
	public void sua(int i,ChangDTO c)
	{
		ChangDAO data=new ChangDAO();
		data.sua(c);
		dsChang.set(i, c);
	}
}
