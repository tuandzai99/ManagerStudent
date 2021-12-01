package com.tuanother.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanother.models.KetQua;
import com.tuanother.models.MonHoc;
import com.tuanother.repositorys.KetQuaRepository;
import com.tuanother.repositorys.MonHocRepository;
import com.tuanother.services.MonHocService;

@Service
public class MonHocServiceImpl  implements MonHocService{
	
	@Autowired
	MonHocRepository monHocRepository;
	
	@Autowired
	KetQuaRepository ketQuaRepository;
	
	@Override
	public MonHoc save(MonHoc entity) {
		return monHocRepository.save(entity);
	}

	@Override
	public List<MonHoc>saveAll(List<MonHoc> entities) {
		return (List<MonHoc>) monHocRepository.saveAll(entities);
	}

	@Override
	public Optional<MonHoc> findById(Integer id) {
		return monHocRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return monHocRepository.existsById(id);
	}

	@Override
	public List<MonHoc> findAll() {
		return (List<MonHoc>) monHocRepository.findAll();
	}

	@Override
	public List<MonHoc> findAllById(List<Integer> ids) {
		return (List<MonHoc>) monHocRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return monHocRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		monHocRepository.deleteById(id);
		List<KetQua> ketQuas=ketQuaRepository.findByMaMonHoc(id);
		ketQuaRepository.deleteAll(ketQuas);
	}

	@Override
	public void delete(MonHoc entity) {
		monHocRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends MonHoc> entities) {
		monHocRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		monHocRepository.deleteAll();
	}
	
	
	
	
}
