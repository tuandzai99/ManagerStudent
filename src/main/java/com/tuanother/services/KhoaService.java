package com.tuanother.services;

import java.util.List;
import java.util.Optional;

import com.tuanother.dtos.TKSinhVienKhoa;
import com.tuanother.models.Khoa;

public interface KhoaService {

	void deleteAll();

	void deleteAll(Iterable<? extends Khoa> entities);

	void delete(Khoa entity);

	void deleteById(Integer id);

	long count();

	List<Khoa> findAllById(Iterable<Integer> ids);

	List<Khoa> findAll();

	boolean existsById(Integer id);

	Optional<Khoa> findById(Integer id);

	List<Khoa> saveAll(List<Khoa> entities);

	Khoa save(Khoa entity);

	Khoa findByTenKhoa(String tenKhoa);

	List<TKSinhVienKhoa> thongKeSoLuongSVKhoa();

	List<TKSinhVienKhoa> tkLopTrongKhoa();

	

	

}
