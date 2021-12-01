package com.tuanother.models;




import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "sinhvien")
public class SinhVien {

	@Id
	
	@Column(name = "ma_sv")
	private String maSV;

	@Column(name = "ten_sv")
	private String tenSV;

	@Column(name = "gioi_tinh")
	private boolean gioiTinh;

	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "ngay_sinh")
	private Date ngaySinh;

	@Column(name = "image")
	private String image;

	@Column(name = "que_quan")
	private String queQuan;

	@ManyToOne
	@JoinColumn(name = "maLop")
	private Lop lopHoc;
	
	
//	@ManyToMany(mappedBy = "sinhviens")
//	private List<MonHoc> monHocs;
	@OneToMany(mappedBy = "sinhVien", cascade = CascadeType.ALL)
	private Set<KetQua> ketQuas;
	
	

	public SinhVien() {
		super();
	}

	public SinhVien(String maSV, String tenSV, boolean gioiTinh, Date ngaySinh, String image, String queQuan,
			Lop lopHoc) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.image = image;
		this.queQuan = queQuan;
		this.lopHoc = lopHoc;
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
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public Lop getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(Lop lopHoc) {
		this.lopHoc = lopHoc;
	}


	@Transient
	public String getImagePath(){
		if(image == null || maSV== null) return null;
		return "/image/" + maSV + "/" +image;
	}
	

	
}
