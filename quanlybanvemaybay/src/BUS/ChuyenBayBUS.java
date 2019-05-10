package BUS;
import DAO.*;
import DTO.*;
import FRM.*;

import java.util.ArrayList;

public class ChuyenBayBUS {
	public static ArrayList<ChuyenBayDTO> dsChuyenBay=new ArrayList<ChuyenBayDTO>();
	public ChuyenBayBUS()
	{
		
	}
	public void docDSChuyenBay()
	{
		ChuyenBayDAO data=new ChuyenBayDAO();
		if(dsChuyenBay==null)
			dsChuyenBay=new ArrayList<ChuyenBayDTO>();
		dsChuyenBay=data.docDSChuyenBay();
	}
	
	public void them(ChuyenBayDTO cb)
	{
		ChuyenBayDAO data=new ChuyenBayDAO();
		data.them(cb);
		dsChuyenBay.add(cb);
	}
	
	public void xoa(int i,String ma)
	{
		dsChuyenBay.remove(i);
		ChuyenBayDAO data=new ChuyenBayDAO();
		data.xoa(ma);
		
	}
	
	public void sua(int i,ChuyenBayDTO cb)
	{
		ChuyenBayDAO data=new ChuyenBayDAO();
		data.sua(cb);
		dsChuyenBay.set(i, cb);
	}
	public void capnhatSoGheTrong()
	{
		dsChuyenBay=new ArrayList<ChuyenBayDTO>();
		ChuyenBayDAO data=new ChuyenBayDAO();
		data.capnhatSoGheTrong();
	}
}
