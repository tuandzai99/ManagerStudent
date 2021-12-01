package com.tuanother.services;

import java.util.List;
import java.util.Optional;

import com.tuanother.dtos.AVGSinhVien;
import com.tuanother.dtos.DiemSinhVien;
import com.tuanother.dtos.TKDiemSinhVien;
import com.tuanother.models.KetQua;
import com.tuanother.models.MonHoc;
import com.tuanother.models.SinhVien;

public interface KetQuaService {

	void deleteAll();

	void deleteAll(List<KetQua> entities);

	void delete(KetQua entity);

	void deleteById(Integer id);

	long count();

	List<KetQua> findAllById(Iterable<Integer> ids);

	List<KetQua> findAll();

	boolean existsById(Integer id);

	Optional<KetQua> findById(Integer id);

	List<KetQua> saveAll(List<KetQua> entities);

	KetQua save(KetQua entity);

	List<SinhVien> findAllSinhVien();

	List<MonHoc> findAllMonHoc();

	boolean checkSinhVien(String maSV, Integer maMH);

	List<KetQua> findByMaSinhVien(String maSV);
	List<KetQua> findByMaMonHoc(Integer maMH);

	List<DiemSinhVien> findByDiem(String maSV);

	List<TKDiemSinhVien> tkDiemSinhVien();

	Float diemTrungBinh1SV(String maSV);

	List<AVGSinhVien> tkAVGSinhVien();

}
