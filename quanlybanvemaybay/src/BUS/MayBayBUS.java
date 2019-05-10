package BUS;
import DAO.*;
import DTO.*;
import FRM.*;
import java.util.ArrayList;

public class MayBayBUS {
	public static ArrayList<MayBayDTO> dsMayBay=new ArrayList<MayBayDTO>();
	public MayBayBUS()
	{
		
	}
	public void docDSMayBay()
	{
		MayBayDAO data=new MayBayDAO();
		if(dsMayBay==null)
			dsMayBay=new ArrayList<MayBayDTO>();
		dsMayBay=data.docDSMayBay();
	}
	
	public void them(MayBayDTO mb)
	{
		MayBayDAO data=new MayBayDAO();
		data.them(mb);
		dsMayBay.add(mb);
	}
	
	public void xoa(int i,String ma)
	{
		dsMayBay.remove(i);
		MayBayDAO data=new MayBayDAO();
		data.xoa(ma);
		
	}
	
	public void sua(int i,MayBayDTO mb)
	{
		MayBayDAO data=new MayBayDAO();
		data.sua(mb);
		dsMayBay.set(i, mb);
	}
}
