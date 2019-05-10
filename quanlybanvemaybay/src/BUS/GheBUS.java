package BUS;
import DAO.*;
import DTO.*;
import FRM.*;

import java.util.ArrayList;

public class GheBUS {
	public static ArrayList<GheDTO> dsGhe=new ArrayList<GheDTO>();
	public GheBUS()
	{
		
	}
	public void docDSGhe()
	{
		GheDAO data=new GheDAO();
		if(dsGhe==null)
			dsGhe=new ArrayList<GheDTO>();
		dsGhe=data.docDSGhe();
	}
	
	public void them(GheDTO g)
	{
		GheDAO data=new GheDAO();
		data.them(g);
		dsGhe.add(g);
	}
	
	public void xoa(int i,String ma)
	{
		dsGhe.remove(i);
		GheDAO data=new GheDAO();
		data.xoa(ma);
		
	}
	
	public void sua(int i,GheDTO g)
	{
		GheDAO data=new GheDAO();
		data.sua(g);
		dsGhe.set(i, g);
	}
}
