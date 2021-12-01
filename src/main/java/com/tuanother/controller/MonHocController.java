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

import com.tuanother.dtos.MonHocDTO;
import com.tuanother.models.KetQua;
import com.tuanother.models.MonHoc;
import com.tuanother.services.KetQuaService;
import com.tuanother.services.MonHocService;

@Controller
public class MonHocController {
	
	@Autowired
	MonHocService monHocService;
	@Autowired
	KetQuaService ketQuaService;
	List<KetQua> ketQuas;
	
	@RequestMapping("/ds-monhoc")
	public String ds(ModelMap model) {
		List<MonHoc> monHocs=monHocService.findAll();
		Long tongMH=monHocService.count();
		
		model.addAttribute("tongmh", tongMH);
		model.addAttribute("monhoc", monHocs);
		return "monhoc/dsMonHoc";
	}
	
	@RequestMapping("/them-mon-hoc")
	public String themMonHoc(ModelMap model) {
		model.addAttribute("monhocdto",new MonHocDTO());
		
		return "monhoc/themMonHoc";
	}
	
	@RequestMapping("/monhoc-luuthem")
	public String luuMonHocThem(MonHocDTO monHocDTO) {
		
		MonHoc monHoc=new MonHoc();
		
		monHoc.setMaMH(monHocDTO.getMaMH());
		monHoc.setTenMH(monHocDTO.getTenMH());
		monHoc.setSoTiet(monHocDTO.getSoTiet());
		
		monHocService.save(monHoc);
		
		return "redirect:/ds-monhoc";
	}
	
	@RequestMapping("/monhoc/edit/{maMH}")
	public ModelAndView editMonHoc(@PathVariable("maMH") Integer maMH, @ModelAttribute("monhocdto") MonHocDTO monHocDTO, ModelMap model) {
		ModelAndView mv=new ModelAndView("monhoc/suaMonHoc");
		Optional<MonHoc> optional=monHocService.findById(maMH);
		
		ketQuas=ketQuaService.findByMaMonHoc(maMH);
		
		monHocDTO.setMaMH(optional.get().getMaMH());
		monHocDTO.setTenMH(optional.get().getTenMH());
		monHocDTO.setSoTiet(optional.get().getSoTiet());
		model.addAttribute("ERROR", "Không được sửa Mã Môn Học");
		mv.addObject("monhocdto", monHocDTO);
		return mv;
	}
	
	@RequestMapping("/luumhsua")
	public String luuMonHoc(MonHocDTO monHocDTO) {
		MonHoc monHoc=new MonHoc();
		
		monHoc.setMaMH(monHocDTO.getMaMH());
		monHoc.setTenMH(monHocDTO.getTenMH());
		monHoc.setSoTiet(monHocDTO.getSoTiet());
		
		monHocService.save(monHoc);
		
		for(int i=0;i<ketQuas.size();i++) {
			ketQuas.get(i).setMonHoc(monHoc);
		}
		ketQuaService.saveAll(ketQuas);
		
		return "redirect:/ds-monhoc";
	}
	@RequestMapping("/monhoc/delete/{maMH}")
	public String deleteMonHoc(@PathVariable("maMH") Integer id) {
		monHocService.deleteById(id);
		return "redirect:/ds-monhoc";
	}
}
