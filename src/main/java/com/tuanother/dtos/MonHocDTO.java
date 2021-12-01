package com.tuanother.dtos;

public class MonHocDTO {
	
	private Integer maMH;
	

	private String tenMH;

	private int soTiet;
	public MonHocDTO() {
		
	}
	public MonHocDTO(Integer maMH, String tenMH, int soTiet) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.soTiet = soTiet;
	}
	public Integer getMaMH() {
		return maMH;
	}
	public void setMaMH(Integer maMH) {
		this.maMH = maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public int getSoTiet() {
		return soTiet;
	}
	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}
}
