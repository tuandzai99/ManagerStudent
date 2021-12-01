package com.tuanother.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tuanother.dtos.KhoaDTO;
import com.tuanother.models.Khoa;
import com.tuanother.models.Lop;
import com.tuanother.services.KhoaService;
import com.tuanother.services.LopService;

@Controller
public class KhoaController {
	@Autowired
	KhoaService khoaService;
	@Autowired
	LopService lopService;
	
	List<Lop> lops;
	@RequestMapping("/ds-khoa")
	public String dsKhoa(ModelMap model) {
		List<Khoa> khoas = khoaService.findAll();
		Long tongKhoa= khoaService.count();
		
		model.addAttribute("tongkhoa",tongKhoa);
		model.addAttribute("khoa", khoas);

		return "khoa/dsKhoa";
	}

	@RequestMapping("/them-khoa")
	public String themKhoa(ModelMap model) {
		KhoaDTO khoaDTO = new KhoaDTO();
		model.addAttribute("khoa", khoaDTO);

		return "khoa/themKhoa";
	}

	@RequestMapping("/khoa-luuthem")
	public String luuKhoaThem(KhoaDTO khoaDTO) {
		
		Khoa khoa=new Khoa();
		
		khoa.setMaKhoa(khoaDTO.getMaKhoa());
		khoa.setTenKhoa(khoaDTO.getTenKhoa());
		khoa.setSoCBGV(khoaDTO.getSoCBGV());
		
		khoaService.save(khoa);
		return "redirect:/ds-khoa";

	}
	
	@RequestMapping("/khoa-luusua")
	public String luuKhoaSua(KhoaDTO khoaDTO) {
		
		Khoa khoa=new Khoa();
		
		khoa.setMaKhoa(khoaDTO.getMaKhoa());
		khoa.setTenKhoa(khoaDTO.getTenKhoa());
		khoa.setSoCBGV(khoaDTO.getSoCBGV());
		
		khoaService.save(khoa);
		
		for(int i=0;i<lops.size();i++) {
			lops.get(i).setKhoa(khoa);
		}
		
		lopService.saveAll(lops);
		return "redirect:/ds-khoa" ;
	}

	@RequestMapping("khoa/edit/{maKhoa}")
	public ModelAndView suaKhoa(@PathVariable("maKhoa") Integer maKhoa) {
		ModelAndView mv = new ModelAndView("khoa/suaKhoa");
		lops= lopService.findByMaKhoa(maKhoa);
	
		KhoaDTO khoaDTO=new KhoaDTO();
		Optional<Khoa> khoa=khoaService.findById(maKhoa);
		
		khoaDTO.setMaKhoa(khoa.get().getMaKhoa());
		khoaDTO.setTenKhoa(khoa.get().getTenKhoa());
		khoaDTO.setSoCBGV(khoa.get().getSoCBGV());
		
		lops=lopService.findByMaKhoa(maKhoa);
		
		
		mv.addObject("khoadto",khoaDTO);
		
		return mv;

	}

	@RequestMapping("/khoa/delete/{maKhoa}")
	public String deleteKhoa(@PathVariable("maKhoa") Integer maKhoa) {
		khoaService.deleteById(maKhoa);
		return "redirect:/ds-khoa";
	}

}
