package DTO;
import BUS.*;
import DAO.*;
import FRM.*;
import java.util.Scanner;
import java.io.*;
public class HoaDonDTO {
		private String maHD;
		private String maKH;
		private String maNV;
		private String ngayDatVe;
		private int thanhTien;
		private int soLuongVe;
		
		public HoaDonDTO() {}
		public HoaDonDTO(String mhd,String mkh,String mnv,String n) {
			this.maHD=mhd;
			this.maKH=mkh;
			this.maNV=mnv;
			this.ngayDatVe=n;
		}
		public HoaDonDTO(HoaDonDTO d)
		{
			this.maHD=d.maHD;
			this.maKH=d.maKH;
			this.maNV=d.maNV;
			this.ngayDatVe=d.ngayDatVe;
		}

		public String getMaHD() {
			return maHD;
		}
		public void setMaHD(String maHD) {
			this.maHD = maHD;
		}
		public String getMaKH() {
			return maKH;
		}
		public void setMaKH(String maKH) {
			this.maKH = maKH;
		}
		public String getMaNV() {
			return maNV;
		}
		public void setMaNV(String maNV) {
			this.maNV = maNV;
		}
		public String getNgayDatVe() {
			return ngayDatVe;
		}
		public void setNgayDatVe(String ngayDatVe) {
			this.ngayDatVe = ngayDatVe;
		}
		public int getThanhTien() {
			return thanhTien;
		}
		public void setThanhTien(int thanhTien) {
			this.thanhTien = thanhTien;
		}
		public int getSoLuongVe() {
			return soLuongVe;
		}

		public void setSoLuongVe(int soLuongVe) {
			this.soLuongVe = soLuongVe;
		}
	}