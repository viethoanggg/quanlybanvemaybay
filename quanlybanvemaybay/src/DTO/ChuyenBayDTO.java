package DTO;
import BUS.*;
import DAO.*;
import FRM.*;
import java.util.Scanner;

public class ChuyenBayDTO {
	private String mamaybay;
	private String machuyenbay;
	private String machang;
	private	String thoigiandi;
	private String thoigianden;
	private String tenchang;
	private String ngaydi;
	private String ngayden;
	private int soghetrong;
	public ChuyenBayDTO()
	{
		mamaybay=" ";
		machuyenbay=" ";
		machang=" ";
		thoigiandi=" ";
		thoigianden=" ";
		ngaydi=" ";
		ngayden=" ";
		
	}
	public ChuyenBayDTO(String mmb,String mcb,String mc,String tgdi,String tgden,String ngdi,String ngden)
	{
		mamaybay=mmb;
		machuyenbay=mcb;
		machang=mc;
		thoigiandi=tgdi;
		thoigianden=tgden;
		ngaydi=ngdi;
		ngayden=ngden;
		
	}
	public ChuyenBayDTO(ChuyenBayDTO d)
	{
		mamaybay=d.mamaybay;
		machuyenbay=d.machuyenbay;
		machang=d.machang;
		thoigiandi=d.thoigiandi;
		thoigianden=d.thoigianden;
		ngaydi=d.ngaydi;
		ngayden=d.ngayden;
		
	}
	
	
	public String getMamaybay() {
		return mamaybay;
	}
	public void setMamaybay(String mamaybay) {
		this.mamaybay = mamaybay;
	}
	public String getMachuyenbay() {
		return machuyenbay;
	}
	public void setMachuyenbay(String machuyenbay) {
		this.machuyenbay = machuyenbay;
	}
	public String getMachang() {
		return machang;
	}
	public void setMachang(String machang) {
		this.machang = machang;
	}
	public String getThoigiandi() {
		return thoigiandi;
	}
	public void setThoigiandi(String thoigiandi) {
		this.thoigiandi = thoigiandi;
	}
	public String getThoigianden() {
		return thoigianden;
	}
	public void setThoigianden(String thoigianden) {
		this.thoigianden = thoigianden;
	}
	public String getTenchang() {
		return tenchang;
	}
	public void setTenchang(String tenchang) {
		this.tenchang = tenchang;
	}
	public int getSoghetrong() {
		return soghetrong;
	}
	public void setSoghetrong(int soghetrong) {
		this.soghetrong = soghetrong;
	}
	public String getNgaydi() {
		return ngaydi;
	}
	public void setNgaydi(String ngaydi) {
		this.ngaydi = ngaydi;
	}
	public String getNgayden() {
		return ngayden;
	}
	public void setNgayden(String ngayden) {
		this.ngayden = ngayden;
	}
	

}
