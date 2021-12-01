package com.tuanother.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TKDiemSinhVien {

		@Id
		private Float diemThi;
		private Long soLuong;
		
		public TKDiemSinhVien() {
			
		}

		public TKDiemSinhVien(Float diemThi, Long soLuong) {
			super();
			this.diemThi = diemThi;
			this.soLuong = soLuong;
		}

		public Float getDiemThi() {
			return diemThi;
		}

		public void setDiemThi(Float diemThi) {
			this.diemThi = diemThi;
		}

		public Long getSoLuong() {
			return soLuong;
		}

		public void setSoLuong(Long soLuong) {
			this.soLuong = soLuong;
		}
		
}
