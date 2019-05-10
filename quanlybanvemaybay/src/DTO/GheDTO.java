package DTO;
import BUS.*;
import DAO.*;
import FRM.*;
import java.util.Scanner;

public class GheDTO {

		private String maghe;
		private String mamaybay;
		private String mahangve;
		public GheDTO()
		{
			mamaybay=" ";
			mahangve=" ";
			maghe=" ";
		}
		public GheDTO(String mg,String mmb,String mhv)
		{
			mamaybay=mmb;
			mahangve=mhv;
			maghe=mg;
		}
		public GheDTO(GheDTO d)
		{
			mamaybay=d.mamaybay;
			mahangve=d.mahangve;
			maghe=d.maghe;
		}
		
		public String getMaghe() {
			return maghe;
		}
		public void setMaghe(String maghe) {
			this.maghe = maghe;
		}
		public String getMamaybay() {
			return mamaybay;
		}
		public void setMamaybay(String mamaybay) {
			this.mamaybay = mamaybay;
		}
		public String getMahangve() {
			return mahangve;
		}
		public void setMahangve(String mahangve) {
			this.mahangve = mahangve;
		}
	}


