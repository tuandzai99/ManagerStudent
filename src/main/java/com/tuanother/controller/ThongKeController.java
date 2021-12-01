package com.tuanother.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuanother.dtos.AVGSinhVien;
import com.tuanother.dtos.TKDiemSinhVien;
import com.tuanother.dtos.TKSinhVienKhoa;
import com.tuanother.dtos.TKSinhVienLop;
import com.tuanother.services.KetQuaService;
import com.tuanother.services.KhoaService;
import com.tuanother.services.LopService;

@Controller
public class ThongKeController {
	@Autowired
	KhoaService khoaService;

	@Autowired
	LopService lopService;
	
	@Autowired
	KetQuaService ketQuaService;

	@RequestMapping("/thongke")
	public String thongKe() {
		return "thongke/thongkesv";
	}

	@RequestMapping("/tk-sv-khoa")
	public String tkSVKhoa(ModelMap model) {

		List<TKSinhVienKhoa> tkSinhVienKhoas = khoaService.thongKeSoLuongSVKhoa();
		List<TKSinhVienKhoa> tkLopKhoas = khoaService.tkLopTrongKhoa();

		model.addAttribute("tkkhoa", tkSinhVienKhoas);
		model.addAttribute("tklopkhoa", tkLopKhoas);

		return "thongke/tksvofkhoa";

	}

	@RequestMapping("/tk-sv-lop")
	public String tkSVLop(ModelMap model) {
		List<TKSinhVienLop> tkSinhVienLops = lopService.tkSinhVienLop();

		model.addAttribute("tklop", tkSinhVienLops);

		return "thongke/tksvoflop";

	}
	@RequestMapping("/tk-diem-sv")
	public String tkDiemSinhVien(ModelMap model) {
		List<TKDiemSinhVien> tkDiemSinhViens=ketQuaService.tkDiemSinhVien();
		List<AVGSinhVien> avgSinhViens = ketQuaService.tkAVGSinhVien();
		
		model.addAttribute("avgsv",avgSinhViens);
		model.addAttribute("tkdiem", tkDiemSinhViens);
		return "thongke/tksoluongdiemthi";
	}
	
	
}
