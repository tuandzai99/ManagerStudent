package com.tuanother.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanother.dtos.TKSinhVienKhoa;
import com.tuanother.models.Khoa;
import com.tuanother.models.Lop;
import com.tuanother.repositorys.KhoaRepository;
import com.tuanother.repositorys.LopRepository;
import com.tuanother.services.KhoaService;

@Service
public class KhoaServiceImpl implements KhoaService {
	@Autowired
	KhoaRepository khoaRepository;

	@Autowired
	LopRepository lopRepository;
	
	
	@Override
	public List<TKSinhVienKhoa> thongKeSoLuongSVKhoa() {
		return khoaRepository.tkSoLuongSVKhoa();
	}
	@Override
	public Khoa save(Khoa entity) {
		return khoaRepository.save(entity);
	}

	@Override
	public List<TKSinhVienKhoa> tkLopTrongKhoa() {
		return khoaRepository.tkLopTrongKhoa();
	}
	@Override
	public Khoa findByTenKhoa(String tenKhoa) {
		return khoaRepository.findByTenKhoa(tenKhoa);
	}

	@Override
	public List<Khoa> saveAll(List<Khoa> entities) {
		return (List<Khoa>) khoaRepository.saveAll(entities);
	}

	@Override
	public Optional<Khoa> findById(Integer id) {
		return khoaRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return khoaRepository.existsById(id);
	}

	@Override
	public List<Khoa> findAll() {
		return (List<Khoa>) khoaRepository.findAll();
	}

	@Override
	public List<Khoa> findAllById(Iterable<Integer> ids) {
		return (List<Khoa>) khoaRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return khoaRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		khoaRepository.deleteById(id);
		List<Lop> lops=lopRepository.findByMaKhoa(id);
		lopRepository.deleteAll(lops);
		
	}

	@Override
	public void delete(Khoa entity) {
		khoaRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Khoa> entities) {
		khoaRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		khoaRepository.deleteAll();
	}

}
