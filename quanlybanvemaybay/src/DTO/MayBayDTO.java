package DTO;
import BUS.*;
import DAO.*;
import FRM.*;
import java.util.Scanner;
public class MayBayDTO {
	private String mamaybay;
	private int soluongghe;
	private String hang;
	private String loai;
	public MayBayDTO()
	{
		mamaybay=" ";
		soluongghe=0;
		hang=" ";
		loai=" ";
	}
	public MayBayDTO(String mmb,int slg,String h,String l)
	{
		mamaybay=mmb;
		soluongghe=slg;
		hang=h;
		loai=l;
	}
	public MayBayDTO(MayBayDTO d)
	{
		mamaybay=d.mamaybay;
		soluongghe=d.soluongghe;
		hang=d.hang;
		loai=d.loai;
	}
	
	
	public String getMamaybay() {
		return mamaybay;
	}
	public void setMamaybay(String mamaybay) {
		this.mamaybay = mamaybay;
	}
	public int getSoluongghe() {
		return soluongghe;
	}
	public void setSoluongghe(int soluongghe) {
		this.soluongghe = soluongghe;
	}
	public String getHang() {
		return hang;
	}
	public void setHang(String hang) {
		this.hang = hang;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	
	
	
}
