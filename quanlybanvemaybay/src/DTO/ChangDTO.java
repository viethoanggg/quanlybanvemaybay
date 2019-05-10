package DTO;
import BUS.*;
import DAO.*;
import FRM.*;
import java.util.Scanner;

public class ChangDTO {
	private String machang;
	private String tenchang;
	private int gia;
	public ChangDTO()
	{
		machang=" ";
		tenchang=" ";
		gia=0;
	}
	public ChangDTO(String mc,String tc,int g)
	{
		machang=mc;
		tenchang=tc;
		gia=g;
	}
	public ChangDTO(ChangDTO d)
	{
		machang=d.machang;
		tenchang=d.tenchang;
		gia=d.gia;
	}
	
	
	public String getMachang() {
		return machang;
	}
	public void setMachang(String machang) {
		this.machang = machang;
	}
	public String getTenchang() {
		return tenchang;
	}
	public void setTenchang(String tenchang) {
		this.tenchang = tenchang;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	
	/*
	 SGN TPHCM TAN SON NHAT
	 HAN HANOI NOI BAI
	 DAD DANANG DA NANG
	 DLI DALAT LIEN KHUONG
	 DIN DIENBIEN DIENBIENPHU
	 HPH HAIPHONG CAT BI
	 TYOA TOKYO HANEDA
	 BKKA BANGKOK DDOON MUOWNGF
	 NEWA NEWYORK JOHN F.KENNEDY
	 SEOA SEOUL INCHEON
	 SHAA THUONGHAI PHOOS DDOONG
	 PQC PHUQUOC PHU QUOC
	 HKG HONGKONG HONG KONG
	 PNH PHNOMPENH PHNOM PENH
	 CXR NHATRANG CAM RANH
	 JKTA JAKARTA SOEKARNO HATTA
	 SYD SYDNEY SYDNEY
	 SIN SINGAPORE CHANGI
	 VTE VIENTIANE(LAO) WATTAY
	 RGN YANGON(MYANMAR) YANGON
	 VII VINH VINH
	 CAH CAMAU CAMAU
	 1 CHANG CO NHIEU CHUYEN BAY
	*/

}
