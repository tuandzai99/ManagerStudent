package com.tuanother.services;

import java.util.List;
import java.util.Optional;

import com.tuanother.models.MonHoc;

public interface MonHocService {

	void deleteAll();

	void deleteAll(Iterable<? extends MonHoc> entities);

	void delete(MonHoc entity);

	void deleteById(Integer id);

	long count();

	List<MonHoc> findAllById(List<Integer> ids);

	List<MonHoc> findAll();

	boolean existsById(Integer id);

	Optional<MonHoc> findById(Integer id);

	List<MonHoc> saveAll(List<MonHoc> entities);

	MonHoc save(MonHoc entity);

	

	
	
}
