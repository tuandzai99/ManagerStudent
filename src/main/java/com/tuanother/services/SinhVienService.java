package com.tuanother.services;

import java.util.List;
import java.util.Optional;

import com.tuanother.dtos.SinhVienDTO2;
import com.tuanother.models.Lop;
import com.tuanother.models.SinhVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SinhVienService {

	

	void deleteAll(List<SinhVien> entities);

	void delete(SinhVien entity);

	void deleteById(String id);

	long count();

	Page<SinhVien> findAll(Pageable pageable);

	List<SinhVien> findAllById(List<String> ids);

	//List<SinhVien> findAll();

	boolean existsById(String id);

	Optional<SinhVien> findById(String id);

	List<SinhVien> saveAll(List<SinhVien> entities);

	SinhVien save(SinhVien nhanVien);

	List<Lop> findAllLop();

	

	List<SinhVien> findByMalop(Integer maLop);

	List<SinhVien> updateByMalop(Integer maLopMoi, Integer maLopCu);


	List<SinhVienDTO2> findByKhoa(Integer maKhoa);

	int tongSV1Khoa(Integer maKhoa);

	int tongSV1Lop(Integer maLop);

	
}
