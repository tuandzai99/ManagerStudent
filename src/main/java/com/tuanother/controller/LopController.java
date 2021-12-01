package com.tuanother.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tuanother.dtos.LopDTO;
import com.tuanother.models.Khoa;
import com.tuanother.models.Lop;
import com.tuanother.models.SinhVien;
import com.tuanother.services.LopService;
import com.tuanother.services.SinhVienService;

@Controller
public class LopController {

	@Autowired
	LopService lopService;
	@Autowired
	SinhVienService sinhVienService;

	private List<SinhVien> sinhViens;
	

	@RequestMapping("/ds-lop")
	public String dsLop(ModelMap model) {
		List<Lop> lops = lopService.findAll();
		Long tongLop= lopService.count();
		
		model.addAttribute("tonglop", tongLop);
		model.addAttribute("lop", lops);
		return "lop/dsLop";
	}

	@RequestMapping("/them-lop")
	public String themLop(ModelMap model) {

		LopDTO lopDto = new LopDTO();
		model.addAttribute("lopdto", lopDto);
		return "lop/themLop";
	}
	
	@RequestMapping("/luulopthem")
	public String luuLopThem(LopDTO lopDto) {
		Lop lop = new Lop();

		lop.setMaLop(lopDto.getMaLop());
		lop.setTenLop(lopDto.getTenLop());
		
		Khoa khoa = new Khoa();
		khoa.setMaKhoa(lopDto.getmaKhoa());

		lop.setKhoa(khoa);
		
		
		lopService.save(lop);

		return "redirect:/ds-lop";

	}

	@RequestMapping("/luulopsua")
	public String luuLop(LopDTO lopDto) {
		Lop lop = new Lop();
		
		lop.setMaLop(lopDto.getMaLop());
		lop.setTenLop(lopDto.getTenLop());

		Khoa khoa = new Khoa();
		khoa.setMaKhoa(lopDto.getmaKhoa());

		lop.setKhoa(khoa);
		lopService.save(lop);
		
		for(int i=0 ; i<sinhViens.size();i++) {
			sinhViens.get(i).setLopHoc(lop);
		}
		sinhVienService.saveAll(sinhViens);

		

		return "redirect:/ds-lop";

	}



	@RequestMapping("/lop/edit/{maLop}")
	public ModelAndView suaLop(@PathVariable("maLop") Integer maLop) {
		ModelAndView mv = new ModelAndView("lop/suaLop");
		Optional<Lop> lopOptional = lopService.findById(maLop);
		
		sinhViens= sinhVienService.findByMalop(lopOptional.get().getMaLop());
		
		
		LopDTO lopDTO = new LopDTO();

		lopDTO.setMaLop(lopOptional.get().getMaLop());
		lopDTO.setTenLop(lopOptional.get().getTenLop());
		lopDTO.setmaKhoa(lopOptional.get().getKhoa().getMaKhoa());
		
		mv.addObject("lopdto", lopDTO);

		return mv;
	}

	@RequestMapping("/lop/delete/{maLop}")
	public String xoaLop(@PathVariable("maLop") Integer maLop) {
		lopService.deleteById(maLop);
		return "redirect:/ds-lop";
	}

	@ModelAttribute(name = "khoas")
	public List<Khoa> getKhoa() {
		return lopService.findAllKhoa();
	}

}
