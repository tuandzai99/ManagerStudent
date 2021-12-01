package com.tuanother.dtos;

public class KhoaDTO {
	private Integer maKhoa;

	
	private String tenKhoa;

	private int soCBGV;
	public KhoaDTO() {
		
	}
	public KhoaDTO(Integer maKhoa, String tenKhoa, int soCBGV) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
		this.soCBGV = soCBGV;
	}
	public Integer getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(Integer maKhoa) {
		this.maKhoa = maKhoa;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public int getSoCBGV() {
		return soCBGV;
	}
	public void setSoCBGV(int soCBGV) {
		this.soCBGV = soCBGV;
	}
	
	
}
