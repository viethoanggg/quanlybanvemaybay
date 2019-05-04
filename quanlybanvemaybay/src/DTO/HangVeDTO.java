package DTO;
import BUS.*;
import DAO.*;
import FRM.*;
import java.util.Scanner;
import java.io.*;;
public class HangVeDTO {
		private String maHangVe;
		private String tenHangVe;
		private int giaHangVe;
		public HangVeDTO() {}
		public HangVeDTO(String maHangVe,String tenHangVe,int giaHangVe) {
			this.maHangVe=maHangVe;
			this.tenHangVe=tenHangVe;
			this.giaHangVe=giaHangVe;
		}
		public HangVeDTO(HangVeDTO h)
		{
			this.maHangVe=h.maHangVe;
			this.tenHangVe=h.tenHangVe;
			this.giaHangVe=h.giaHangVe;
		}
		
			
		public int getGiaHangVe() {
			return giaHangVe;
		}
		public void setGiaHangVe(int giaHangVe) {
			this.giaHangVe = giaHangVe;
		}
		public String getMaHangVe()
		{
			return this.maHangVe;
		}
		public void setMaHangVe(String m)
		{
			this.maHangVe=m;
		}
		public String getTenHangVe() {
			return tenHangVe;
		}
		public void setTenHangVe(String tenHangVe) {
			this.tenHangVe = tenHangVe;
		}

	}