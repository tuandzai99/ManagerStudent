package com.tuanother.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DiemSinhVien {
	@Id
	private String tenMH;
	private Float diemThi;
	
	public DiemSinhVien() {
		
	}
	public DiemSinhVien(String tenMH, Float diemThi) {
		super();
		this.tenMH = tenMH;
		this.diemThi = diemThi;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public Float getDiemThi() {
		return diemThi;
	}
	public void setDiemThi(Float diemThi) {
		this.diemThi = diemThi;
	}
	
	
	

}
