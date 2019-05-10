package BUS;
import DAO.*;
import DTO.*;
import FRM.*;

import java.util.ArrayList;
public class SanBayBUS {
	public static ArrayList<SanBayDTO> dsSanBay=new ArrayList<SanBayDTO>();
	public SanBayBUS()
	{
		
	}
	public void docDSSanBay()
	{
		SanBayDAO data=new SanBayDAO();
		if(dsSanBay==null)
			dsSanBay=new ArrayList<SanBayDTO>();
		dsSanBay=data.docDSSanBay();
	}
	public void them(SanBayDTO sb)
	{
		SanBayDAO data=new SanBayDAO();
		data.them(sb);
		dsSanBay.add(sb);
	}
	public void xoa(int i,String ma)
	{
		dsSanBay.remove(i);
		SanBayDAO data=new SanBayDAO();
		data.xoa(ma);
	}
	public void sua(int i,SanBayDTO sb)
	{
		SanBayDAO data=new SanBayDAO();
		data.sua(sb);
		dsSanBay.set(i, sb);
	}
}
