package com.tuanother.dtos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class SinhVienDTO2 {
	
	@Id
	private String maSV;

	private String tenSV;


	private boolean gioiTinh;


	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngaySinh;


	private String image;

	
	private String queQuan;

	private Integer maLop;

	
	public SinhVienDTO2() {
		super();
	}


	public SinhVienDTO2(String maSV, String tenSV, boolean gioiTinh, Date ngaySinh, String  image, String queQuan,
			Integer lopId) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this. image =  image;
		this.queQuan = queQuan;
		this.maLop = lopId;
	}


	public String getMaSV() {
		return maSV;
	}


	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}


	public String getTenSV() {
		return tenSV;
	}


	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}


	public boolean isGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public Date getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	public String getImage() {
		return  image;
	}


	public void setImage(String hocBong) {
		this. image = hocBong;
	}


	public String getQueQuan() {
		return queQuan;
	}


	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}


	public Integer getMaLop() {
		return maLop;
	}


	public void setMaLop(Integer lopId) {
		this.maLop = lopId;
	}

	

	
	
}
