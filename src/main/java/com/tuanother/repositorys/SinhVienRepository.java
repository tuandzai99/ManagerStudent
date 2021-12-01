package com.tuanother.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tuanother.dtos.SinhVienDTO2;
import com.tuanother.models.SinhVien;

@Repository
public interface SinhVienRepository extends PagingAndSortingRepository<SinhVien,String> {
	
	@Query("SELECT sv FROM SinhVien sv  WHERE sv.lopHoc.maLop = ?1")
	List<SinhVien> findByMalop(Integer maLop);

	@Query(value = "update  sinhvien set ma_lop= ?1 where ma_lop = ?2", nativeQuery = true)
	List<SinhVien> updateByMalop(Integer maLopMoi, Integer maLopCu);

	// tìm số sinh viên có trong 1 khoa
	@Query("SELECT new SinhVienDTO2(sv.maSV, sv.tenSV,sv.gioiTinh, sv.ngaySinh, sv.queQuan, sv.image, sv.lopHoc.maLop) "
			+ " FROM SinhVien sv, Lop l, Khoa k " + "WHERE sv.lopHoc.maLop=l.maLop AND k.maKhoa=l.khoa.maKhoa "
			+ " AND k.maKhoa=?1 ORDER BY sv.tenSV ASC " )
	List<SinhVienDTO2> findByKhoa(Integer maKhoa);
	
	
	// tổng số sinh viên trong 1 lớp
	@Query("select count(sv.maSV)  from SinhVien sv ,Lop l\r\n"
			+ "where sv.lopHoc.maLop=l.maLop and l.maLop=?1\r\n"
			+ "")
	int tongSV1Lop(Integer maLop);
	
	// tổng số sinh viên trong 1 khoa
	@Query("select count(sv.maSV)from SinhVien sv, Lop l, Khoa k\r\n"
			+ "where sv.lopHoc.maLop=l.maLop and k.maKhoa=l.khoa.maKhoa and k.maKhoa=?1 \r\n"
			+ "")
	int tongSV1Khoa(Integer maKhoa);
	

}