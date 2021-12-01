package com.tuanother.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lop")
public class Lop {
	
	@Id
	@Column(name = "ma_lop")
	private Integer maLop;

	@Column(name = "ten_lop")
	private String tenLop;

	@ManyToOne
	@JoinColumn(name = "maKhoa")
	private Khoa khoa;

	@OneToMany(mappedBy = "lopHoc", cascade = CascadeType.ALL)
	private Set<SinhVien> sinhViens;

	public Lop() {
		super();
	}

	public Lop(Integer maLop, String tenLop, Khoa khoa, Set<SinhVien> sinhViens) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.khoa = khoa;
		this.sinhViens = sinhViens;
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

	public Khoa getKhoa() {
		return khoa;
	}


	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}

	public Set<SinhVien> getSinhViens() {
		return sinhViens;
	}

	public void setSinhViens(Set<SinhVien> sinhViens) {
		this.sinhViens = sinhViens;
	}

}
