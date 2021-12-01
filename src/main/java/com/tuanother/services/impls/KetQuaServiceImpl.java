package com.tuanother.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanother.dtos.AVGSinhVien;
import com.tuanother.dtos.DiemSinhVien;
import com.tuanother.dtos.TKDiemSinhVien;
import com.tuanother.models.KetQua;
import com.tuanother.models.MonHoc;
import com.tuanother.models.SinhVien;
import com.tuanother.repositorys.KetQuaRepository;
import com.tuanother.repositorys.MonHocRepository;
import com.tuanother.repositorys.SinhVienRepository;
import com.tuanother.services.KetQuaService;

@Service
public class KetQuaServiceImpl implements KetQuaService {

	@Autowired
	KetQuaRepository ketQuaRepository;
	@Autowired
	MonHocRepository monHocRepository;
	@Override
	public List<DiemSinhVien> findByDiem(String maSV) {
		return ketQuaRepository.findByDiem(maSV);
	}

	@Override
	public Float diemTrungBinh1SV(String maSV) {
		return ketQuaRepository.diemTrungBinh1SV(maSV);
	}

	@Override
	public List<AVGSinhVien> tkAVGSinhVien() {
		return ketQuaRepository.tkAVGSinhVien();
	}

	@Override
	public List<TKDiemSinhVien> tkDiemSinhVien() {
		return ketQuaRepository.tkDiemSinhVien();
	}

	@Autowired
	SinhVienRepository sinhVienRepository;

	@Override
	public KetQua save(KetQua entity) {
		return ketQuaRepository.save(entity);
	}

	@Override
	public List<KetQua> saveAll(List<KetQua> entities) {
		return (List<KetQua>) ketQuaRepository.saveAll(entities);
	}

	@Override
	public Optional<KetQua> findById(Integer id) {
		return ketQuaRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return ketQuaRepository.existsById(id);
	}

	@Override
	public List<KetQua> findAll() {
		return (List<KetQua>) ketQuaRepository.findAll();
	}

	@Override
	public List<KetQua> findAllById(Iterable<Integer> ids) {
		return (List<KetQua>) ketQuaRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return ketQuaRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		ketQuaRepository.deleteById(id);
	}

	@Override
	public void delete(KetQua entity) {
		ketQuaRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<KetQua> entities) {
		ketQuaRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ketQuaRepository.deleteAll();
	}

	@Override
	public List<SinhVien> findAllSinhVien() {
		return (List<SinhVien>) sinhVienRepository.findAll();
	}

	@Override
	public List<MonHoc> findAllMonHoc() {
		return (List<MonHoc>) monHocRepository.findAll();
	}

	@Override
	public boolean checkSinhVien(String maSV, Integer maMH) {
		List<KetQua> ketQuas = ketQuaRepository.findByMaSinhVien(maSV);

		for (int i = 0; i < ketQuas.size(); i++) {
			if (ketQuas.get(i).getMonHoc().getMaMH().equals(maMH) && ketQuas.get(i).getSinhVien().getMaSV().equals(maSV)) {
				return false;
			}

		}
		return true;
	}

	@Override
	public List<KetQua> findByMaSinhVien(String maSV) {
		return ketQuaRepository.findByMaSinhVien(maSV);
	}

	public List<KetQua> findByMaMonHoc(Integer maMH) {
		return ketQuaRepository.findByMaMonHoc(maMH);
	}
}
