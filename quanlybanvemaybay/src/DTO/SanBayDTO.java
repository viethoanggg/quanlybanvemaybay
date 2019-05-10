package DTO;
import BUS.*;
import DAO.*;
import FRM.*;
import java.util.Scanner;

public class SanBayDTO {
	private String masanbay;
	private String tensanbay;
	private String thanhpho;
	public SanBayDTO()
	{
		masanbay=" ";
		tensanbay=" ";
		thanhpho=" ";
	}
	public SanBayDTO(String msb,String tsb,String tp)
	{
		masanbay=msb;
		tensanbay=tsb;
		thanhpho=tp;
	}
	public SanBayDTO(SanBayDTO d)
	{
		masanbay=d.masanbay;
		tensanbay=d.tensanbay;
		thanhpho=d.thanhpho;
	}
	public String getMasanbay() {
		return masanbay;
	}
	public void setMasanbay(String masanbay) {
		this.masanbay = masanbay;
	}
	public String getTensanbay() {
		return tensanbay;
	}
	public void setTensanbay(String tensanbay) {
		this.tensanbay = tensanbay;
	}
	public String getThanhpho() {
		return thanhpho;
	}
	public void setThanhpho(String thanhpho) {
		this.thanhpho = thanhpho;
	}
}
