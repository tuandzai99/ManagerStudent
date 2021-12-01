package com.tuanother.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuanother.dtos.DiemSinhVien;
import com.tuanother.dtos.KetQuaDTO;
import com.tuanother.models.KetQua;
import com.tuanother.models.MonHoc;
import com.tuanother.models.SinhVien;
import com.tuanother.repositorys.SinhVienRepository;
import com.tuanother.services.KetQuaService;

@Controller
public class KetQuaController {
	@Autowired
	KetQuaService ketQuaService;
	
	@Autowired
	SinhVienRepository sinhVienRepository;

	@RequestMapping("/ds-kq")
	public String ds(ModelMap model) {
		List<KetQua> ketQuas = ketQuaService.findAll();

		model.addAttribute("ketqua", ketQuas);
		return "ketqua/dsKetQua";
	}

	@RequestMapping("/nhap-diem")
	public String nhapDiemSV(ModelMap model) {

		model.addAttribute("ketquadto", new KetQuaDTO());
		return "ketqua/themKetQua";
	}

	@RequestMapping("/luukqthem")
	public String luuKq(@ModelAttribute("ketquadto") KetQuaDTO ketQuaDTO, ModelMap model) {
		if (ketQuaService.checkSinhVien(ketQuaDTO.getMaSV(), ketQuaDTO.getMaMH())) {

			KetQua ketqua = new KetQua();

			ketqua.setId(ketQuaDTO.getId());

			SinhVien sinhVien = new SinhVien();
			sinhVien.setMaSV(ketQuaDTO.getMaSV());

			ketqua.setSinhVien(sinhVien);

			MonHoc monHoc = new MonHoc();
			monHoc.setMaMH(ketQuaDTO.getMaMH());

			ketqua.setMonHoc(monHoc);

			ketqua.setDiemThi(ketQuaDTO.getDiemThi());

			ketQuaService.save(ketqua);

			return "redirect:/ds-kq";
		} else {

			model.addAttribute("ERROR", "Sinh Viên đã có điểm môn học!!!");
			return "ketqua/themKetQua";
		}

	}

	@RequestMapping("kq/edit/{id}")
	public ModelAndView editKQ(@PathVariable("id") Integer id, @ModelAttribute("ketquadto") KetQuaDTO ketQuaDTO, ModelMap model) {

		ModelAndView mv = new ModelAndView("ketqua/suaKetQua");

		Optional<KetQua> optional = ketQuaService.findById(id);

		

		ketQuaDTO.setId(optional.get().getId());
		ketQuaDTO.setMaSV(optional.get().getSinhVien().getMaSV());
		ketQuaDTO.setMaMH(optional.get().getMonHoc().getMaMH());
		ketQuaDTO.setDiemThi(optional.get().getDiemThi());
		model.addAttribute("ERROR","Không được sửa id, sinh viên, môn học");
		mv.addObject("ketquadto", ketQuaDTO);

		return mv;
	}

	@RequestMapping("/luukqsua")
	public String luuKqSua(@ModelAttribute("ketquadto") KetQuaDTO ketQuaDTO) {
		KetQua ketQua = new KetQua();
		ketQua.setId(ketQuaDTO.getId());
		
		SinhVien sinhVien =new SinhVien();
		
		sinhVien.setMaSV(ketQuaDTO.getMaSV());
		ketQua.setSinhVien(sinhVien);
		
		
		MonHoc monHoc=new MonHoc();
		monHoc.setMaMH(ketQuaDTO.getMaMH());
		
		ketQua.setMonHoc(monHoc);
		
		ketQua.setDiemThi(ketQuaDTO.getDiemThi());
		
		ketQuaService.save(ketQua);

		return "redirect:/ds-kq";
	}

	@RequestMapping("/kq/delete/{id}")
	public String deleteKq(@PathVariable("id") Integer id) {
		ketQuaService.deleteById(id);

		return "redirect:/ds-kq";
	}

	@ModelAttribute("sinhViens")
	public List<SinhVien> getSinhVien() {
		return ketQuaService.findAllSinhVien();
	}

	@ModelAttribute("monHocs")
	public List<MonHoc> getMonHoc() {
		return ketQuaService.findAllMonHoc();
	}
	
	
	@RequestMapping("/search-diem-sv")
	public String searchSinhVienByDiem(@RequestParam("maSV") String maSV, ModelMap model) {
	
			List<DiemSinhVien> diemThi= ketQuaService.findByDiem(maSV);
			Float avg= ketQuaService.diemTrungBinh1SV(maSV);
			
			model.addAttribute("diemthi",diemThi);
			model.addAttribute("avg",avg);
			
			return "ketqua/search-diem-sv";
		
	}
}
