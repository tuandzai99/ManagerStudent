package com.tuanother.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "khoa")
public class Khoa {
	@Id
	
	@Column(name = "ma_khoa")
	private Integer maKhoa;
	
	@Column(name = "ten_khoa")
	private String tenKhoa;
	
	@Column(name = "so_cbgv")
	private int soCBGV;
	
	@OneToMany(mappedBy = "khoa", cascade = CascadeType.ALL)
	private Set<Lop> lops;
	
	public Khoa() {
		super();
	}

	public Khoa(Integer maKhoa, String tenKhoa, int soCBGV, Set<Lop> lops) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
		this.soCBGV = soCBGV;
		this.lops = lops;
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

	public Set<Lop> getLops() {
		return lops;
	}

	public void setLops(Set<Lop> lops) {
		this.lops = lops;
	}
	
	
	
}
