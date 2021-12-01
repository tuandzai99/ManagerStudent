package com.tuanother.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanother.dtos.TKSinhVienLop;
import com.tuanother.models.Khoa;
import com.tuanother.models.Lop;
import com.tuanother.models.SinhVien;
import com.tuanother.repositorys.KhoaRepository;
import com.tuanother.repositorys.LopRepository;
import com.tuanother.repositorys.SinhVienRepository;
import com.tuanother.services.LopService;
@Service
public class LopServiceImpl implements LopService {
	@Autowired
	LopRepository lopRepository;
	@Autowired
	KhoaRepository khoaRepository;
	@Autowired
	SinhVienRepository sinhVienRepository;
	@Override
	public Lop save(Lop entity) {
		return lopRepository.save(entity);
	}

	

	@Override
	public List<TKSinhVienLop> tkSinhVienLop() {
		return lopRepository.tkSinhVienLop();
	}



	@Override
	public List<Lop> saveAll(List<Lop> entities) {
		return (List<Lop>) lopRepository.saveAll(entities);
	}

	@Override
	public Optional<Lop> findById(Integer id) {
		return lopRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return lopRepository.existsById(id);
	}

	@Override
	public List<Lop> findAll() {
		return (List<Lop>) lopRepository.findAll();
	}

	@Override
	public List<Lop> findAllById(List<Integer> ids) {
		return (List<Lop>) lopRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return lopRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		lopRepository.deleteById(id);
		//sinhVienRepository.deleteByMalop(id);
		List<SinhVien> sinhViens=sinhVienRepository.findByMalop(id);
		sinhVienRepository.deleteAll(sinhViens);
	}

	@Override
	public void delete(Lop entity) {
		lopRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Lop> entities) {
		lopRepository.deleteAll(entities);
	}

	public List<Lop> findByMaKhoa(Integer maKhoa) {
		return lopRepository.findByMaKhoa(maKhoa);
	}

	public List<SinhVien> findByMalop(Integer maLop) {
		return sinhVienRepository.findByMalop(maLop);
	}

	public List<SinhVien> updateByMalop(Integer maLopMoi, Integer maLopCu) {
		return sinhVienRepository.updateByMalop(maLopMoi, maLopCu);
	}

	public <S extends SinhVien> S save(S entity) {
		return sinhVienRepository.save(entity);
	}

	public <S extends SinhVien> Iterable<S> saveAll(Iterable<S> entities) {
		return sinhVienRepository.saveAll(entities);
	}

	public Optional<SinhVien> findById(String id) {
		return sinhVienRepository.findById(id);
	}

	public boolean existsById(String id) {
		return sinhVienRepository.existsById(id);
	}

	public Iterable<SinhVien> findAllById(Iterable<String> ids) {
		return sinhVienRepository.findAllById(ids);
	}

	public void deleteById(String id) {
		sinhVienRepository.deleteById(id);
	}

	public void delete(SinhVien entity) {
		sinhVienRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends SinhVien> entities) {
		sinhVienRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		lopRepository.deleteAll();
	}

	@Override
	public List<Khoa> findAllKhoa() {
		return (List<Khoa>) khoaRepository.findAll();
	}



	@Override
	public Lop findByTenLop(String tenLop) {
		return lopRepository.findByTenLop(tenLop);
	}
	

}
