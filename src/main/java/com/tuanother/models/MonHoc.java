package com.tuanother.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "monhoc")
public class MonHoc {
	
	@Id
	@Column(name = "ma_mh")
	private Integer maMH;

	@Column(name = "ten_mh")
	private String tenMH;

	@Column(name = "so_tiet")
	private int soTiet;
	
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name="ketqua",
//			joinColumns = @JoinColumn(name = "ma_mh"),
//			inverseJoinColumns =  @JoinColumn(name="ma_sv")
//			)
//	private List<SinhVien> sinhviens;
	
	@OneToMany(mappedBy = "monHoc", cascade = CascadeType.ALL)
	private Set<KetQua> ketQuas;
	
	public MonHoc() {
		super();
	}

	public MonHoc(Integer maMH, String tenMH, int soTiet) {
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
