package com.tuanother.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TKSinhVienKhoa {

	@Id
	private String tenKhoa;
	
	private Long soLuong;
	
	public TKSinhVienKhoa() {
		
	}
	public TKSinhVienKhoa(String tenKhoa,Long soLuong) {
		super();
		this.tenKhoa = tenKhoa;
		this.soLuong = soLuong;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public Long getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(Long soLuong) {
		this.soLuong = soLuong;
	}
	
}
