package com.tuanother.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tuanother.dtos.TKSinhVienKhoa;
import com.tuanother.models.Khoa;

@Repository
public interface KhoaRepository  extends CrudRepository<Khoa, Integer>{
	@Query("select k from Khoa k where k.tenKhoa = ?1")
	Khoa findByTenKhoa(String tenKhoa);
	
	
	// biến count có kiểu dữ liệu là Long
	//thống kê số sinh viên có trong mỗi khoa
	@Query("SELECT new TKSinhVienKhoa(k.tenKhoa, COUNT(sv.maSV) ) \r\n"
			+ "FROM SinhVien sv, Lop l, Khoa k\r\n"
			+ "WHERE sv.lopHoc.maLop=l.maLop AND k.maKhoa=l.khoa.maKhoa\r\n"
			+ "GROUP BY k.maKhoa")
	List<TKSinhVienKhoa> tkSoLuongSVKhoa();
	
	@Query("select k from Khoa k where k.maKhoa = ?1")
	Khoa findByMaKhoa(String tenKhoa);
	
	// thống kê số lớp có trong mỗi khoa
	@Query("select new TKSinhVienKhoa(k.tenKhoa ,count(l.maLop)) \r\n"
			+ "from Khoa k, Lop l\r\n"
			+ "where k.maKhoa=l.khoa.maKhoa\r\n"
			+ "group by k.maKhoa\r\n"
			+ "")
	List<TKSinhVienKhoa> tkLopTrongKhoa();
	
	
	
}
