package com.tuanother.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TKSinhVienLop {
	@Id
	private String tenLop;
	private Long soLuong;
	
	public TKSinhVienLop() {
		
	}

	public TKSinhVienLop(String tenLop, Long soLuong) {
		super();
		this.tenLop = tenLop;
		this.soLuong = soLuong;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public Long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Long soLuong) {
		this.soLuong = soLuong;
	}
	
	
}
