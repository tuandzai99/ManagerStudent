package com.tuanother.dtos;

public class KetQuaDTO {
	
	private Integer id;
	
	private Float diemThi;
	
	private Integer maMH;
	
	private String maSV;

	public KetQuaDTO() {
		super();
	}

	public KetQuaDTO(Integer id, Float diemThi, Integer maMH, String maSV) {
		super();
		this.id = id;
		this.diemThi = diemThi;
		this.maMH = maMH;
		this.maSV = maSV;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getDiemThi() {
		return diemThi;
	}

	public void setDiemThi(Float diemThi) {
		this.diemThi = diemThi;
	}

	public Integer getMaMH() {
		return maMH;
	}

	public void setMaMH(Integer maMH) {
		this.maMH = maMH;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}


	
	
	
	
}
