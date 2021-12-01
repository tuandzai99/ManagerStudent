package com.tuanother.services;

import java.util.List;
import java.util.Optional;

import com.tuanother.dtos.TKSinhVienLop;
import com.tuanother.models.Khoa;
import com.tuanother.models.Lop;

public interface LopService {

	void deleteAll();

	void deleteAll(List<Lop> entities);

	void delete(Lop entity);

	void deleteById(Integer id);

	long count();

	List<Lop> findAllById(List<Integer> ids);

	List<Lop> findAll();

	boolean existsById(Integer id);

	Optional<Lop> findById(Integer id);

	List<Lop> saveAll(List<Lop> entities);

	Lop save(Lop entity);
	
	List<Khoa> findAllKhoa();
	
	List<Lop> findByMaKhoa(Integer maKhoa);

	Lop findByTenLop(String tenLop);

	List<TKSinhVienLop> tkSinhVienLop();
	
	

	

}
