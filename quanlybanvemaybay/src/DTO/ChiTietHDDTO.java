package DTO;
import BUS.*;
import DAO.*;
import FRM.*;

import java.util.*;

import java.io.*;

public class ChiTietHDDTO {
		private String maHD;
		private String maVe;
		private String maHangVe;
		private String tenKH;
		private String tenChang;
		private int giaVe;
		private String VISA;
		public ChiTietHDDTO() {}
		
		public ChiTietHDDTO(String mahoadon,String mave,String mahangve,String tenKH,String tenChang,int giacua1ve,String VISA) 
		{
			this.maHD=mahoadon;
			this.maVe=mave;
			this.maHangVe=mahangve;
			this.tenKH=tenKH;
			this.tenChang=tenChang;
			this.giaVe=giacua1ve;
			this.VISA=VISA;
		}
		public ChiTietHDDTO(ChiTietHDDTO d) 
		{
			this.maHD=d.maHD;
			this.maVe=d.maVe;
			this.maHangVe=d.maHangVe;
			this.tenKH=tenKH;
			this.tenChang=tenChang;
			this.giaVe=d.giaVe;
			this.VISA=VISA;
		}

		public String getTenKH() {
			return tenKH;
		}

		public void setTenKH(String tenKH) {
			this.tenKH = tenKH;
		}

		public String getTenChang() {
			return tenChang;
		}

		public void setTenChang(String tenChang) {
			this.tenChang = tenChang;
		}

		public String getVISA() {
			return VISA;
		}

		public void setVISA(String vISA) {
			VISA = vISA;
		}

		public String getMaHangVe() {
			return maHangVe;
		}

		public void setMaHangVe(String maHangVe) {
			this.maHangVe = maHangVe;
		}

		public String getMaHD() {
			return maHD;
		}

		public void setMaHD(String maHD) {
			this.maHD = maHD;
		}

		public String getMaVe() {
			return maVe;
		}

		public void setMaVe(String maVe) {
			this.maVe = maVe;
		}

		public int getGiaVe() {
			return giaVe;
		}

		public void setGiaVe(int giaVe) {
			this.giaVe = giaVe;
		}
		
		
	

	}