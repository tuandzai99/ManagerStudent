package com.tuanother.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ketqua")
public class KetQua {
	@Id
	private Integer id;

	
	@Column(name = "diem_thi")
	private Float diemThi;
	
	
	
	@ManyToOne
	@JoinColumn(name = "ma_mh")
	private MonHoc monHoc;
	
	
	@ManyToOne
	@JoinColumn(name = "ma_sv")
	private SinhVien sinhVien;


	public KetQua() {
		super();
	}


	public KetQua(Integer id, Float diemThi, MonHoc monHoc, SinhVien sinhVien) {
		super();
		this.id = id;
		this.diemThi = diemThi;
		this.monHoc = monHoc;
		this.sinhVien = sinhVien;
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


	public MonHoc getMonHoc() {
		return monHoc;
	}


	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}


	public SinhVien getSinhVien() {
		return sinhVien;
	}


	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}
	
	
	
}
