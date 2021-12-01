package com.tuanother.dtos;

public class LopDTO {
	
	private Integer maLop;
	
	private String tenLop;
	
	private Integer maKhoa;

	public LopDTO() {
		super();
	}

	public LopDTO(Integer maLop, String tenLop, Integer maKhoa) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.maKhoa = maKhoa;
	}

	public Integer getMaLop() {
		return maLop;
	}

	public void setMaLop(Integer maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public Integer getmaKhoa() {
		return maKhoa;
	}

	public void setmaKhoa(Integer maKhoa) {
		this.maKhoa = maKhoa;
	}
	
	
	
	

}
