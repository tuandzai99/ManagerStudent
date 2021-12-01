package com.tuanother.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tuanother.dtos.AVGSinhVien;
import com.tuanother.dtos.DiemSinhVien;
import com.tuanother.dtos.TKDiemSinhVien;
import com.tuanother.models.KetQua;
@Repository
public interface KetQuaRepository extends CrudRepository<KetQua, Integer> {
	@Query(value = "select * from ketqua where ma_mh = ?1", nativeQuery = true)
	List<KetQua> findByMaMonHoc(Integer maMH);
	@Query(value = "select * from ketqua where ma_sv = ?1", nativeQuery = true)
	List<KetQua> findByMaSinhVien(String maSV);
	
	// tìm điểm của sinh viên
	
	@Query("SELECT new DiemSinhVien(mh.tenMH, kq.diemThi)\r\n"
			+ "FROM SinhVien sv, KetQua kq, MonHoc  mh\r\n"
			+ "WHERE sv.maSV=kq.sinhVien.maSV AND sv.maSV=?1 AND mh.maMH=kq.monHoc.maMH")
	List<DiemSinhVien> findByDiem(String maSV);
	
	// hiển thị điểm trung bình của sinh viên cần tìm
	
	@Query("SELECT AVG(kq.diemThi)\r\n"
			+ "FROM SinhVien sv, KetQua kq\r\n"
			+ "WHERE sv.maSV=kq.sinhVien.maSV AND sv.maSV=?1")
	Float diemTrungBinh1SV(String maSV);
	
	// thống kê số lượng điểm thi
	
	@Query("select new TKDiemSinhVien(kq.diemThi, count(kq.id)) \r\n"
			+ "from KetQua kq, MonHoc mh\r\n"
			+ "where kq.monHoc.maMH=mh.maMH \r\n"
			+ "group by kq.diemThi\r\n"
			+ "order by kq.diemThi desc")
	List<TKDiemSinhVien> tkDiemSinhVien();
	
	// hiển thị điểm trung bình của từng sinh viên
	// AVG kiểu dữ liệu spring double
	@Query("SELECT new AVGSinhVien(sv.tenSV, AVG(kq.diemThi)) \r\n"
			+"FROM KetQua kq, SinhVien sv \r\n"
			+"WHERE sv.maSV = kq.sinhVien.maSV \r\n"
			+"group by sv.maSV \r\n"
			+"")
	List<AVGSinhVien> tkAVGSinhVien();
}
