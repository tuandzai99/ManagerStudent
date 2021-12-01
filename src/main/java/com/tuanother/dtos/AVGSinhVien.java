package com.tuanother.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AVGSinhVien {
	@Id
	private String tenSV;
	private Double diemThi;
	
	public AVGSinhVien() {
		
	}

	public AVGSinhVien(String tenSV, Double diemThi) {
		super();
		this.tenSV = tenSV;
		this.diemThi = diemThi;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public  Double getDiemThi() {
		return diemThi;
	}

	public void setDiemThi( Double diemThi) {
		this.diemThi = diemThi;
	}
	
}
