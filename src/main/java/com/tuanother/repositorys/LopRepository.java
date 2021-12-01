package com.tuanother.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tuanother.dtos.TKSinhVienLop;
import com.tuanother.models.Lop;
@Repository
public interface LopRepository  extends CrudRepository<Lop, Integer> {
	@Query("select l from Lop l where ma_khoa = ?1")
	List<Lop> findByMaKhoa(Integer maKhoa);
	
	Lop findByTenLop(String tenLop);
	
	@Query("select new TKSinhVienLop(l.tenLop, count(sv.maSV) )\r\n"
			+ "from SinhVien sv, Lop l \r\n"
			+ "where sv.lopHoc.maLop=l.maLop\r\n"
			+ "group by l.maLop")
	List<TKSinhVienLop> tkSinhVienLop();
}
