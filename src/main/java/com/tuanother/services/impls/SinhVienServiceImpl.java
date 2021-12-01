package com.tuanother.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tuanother.dtos.SinhVienDTO2;
import com.tuanother.models.Lop;
import com.tuanother.models.SinhVien;
import com.tuanother.repositorys.LopRepository;
import com.tuanother.repositorys.SinhVienRepository;
import com.tuanother.services.SinhVienService;

@Service
public class SinhVienServiceImpl implements SinhVienService {

	@Autowired
	private LopRepository lopRepository;
	@Autowired
	private SinhVienRepository sinhVienRepository;

	@Override
	public int tongSV1Lop(Integer maLop) {
		return sinhVienRepository.tongSV1Lop(maLop);
	}

	@Override
	public int tongSV1Khoa(Integer maKhoa) {
		return sinhVienRepository.tongSV1Khoa(maKhoa);
	}

	@Override
	public List<Lop> findAllLop() {
		return (List<Lop>) lopRepository.findAll();
	}

	@Override
	public List<SinhVien> findByMalop(Integer maLop) {
		return sinhVienRepository.findByMalop(maLop);
	}

	@Override
	public List<SinhVienDTO2> findByKhoa(Integer maKhoa) {
		return sinhVienRepository.findByKhoa(maKhoa);
	}

	public SinhVien save(SinhVien entity) {
		return sinhVienRepository.save(entity);
	}

	public Iterable<SinhVien> findAllById(Iterable<String> ids) {
		return sinhVienRepository.findAllById(ids);
	}

	public void deleteAll(Iterable<? extends SinhVien> entities) {
		sinhVienRepository.deleteAll(entities);
	}

	@Override
	public List<SinhVien> saveAll(List<SinhVien> entities) {
		return (List<SinhVien>) sinhVienRepository.saveAll(entities);
	}

	@Override
	public Optional<SinhVien> findById(String id) {
		return sinhVienRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return sinhVienRepository.existsById(id);
	}

	@Override
	public Page<SinhVien> findAll(Pageable pageable) {
		return sinhVienRepository.findAll(pageable);
	}

	@Override
	public List<SinhVien> findAllById(List<String> ids) {
		return (List<SinhVien>) sinhVienRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return sinhVienRepository.count();
	}

	@Override
	public void deleteById(String id) {
		sinhVienRepository.deleteById(id);

	}

	@Override
	public List<SinhVien> updateByMalop(Integer maLopMoi, Integer maLopCu) {
		return sinhVienRepository.updateByMalop(maLopMoi, maLopCu);
	}

	@Override
	public void delete(SinhVien entity) {
		sinhVienRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<SinhVien> entities) {
		// TODO Auto-generated method stub

	}

}
