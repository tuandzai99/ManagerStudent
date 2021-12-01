package com.tuanother.controller;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tuanother.dtos.SinhVienDTO;
import com.tuanother.dtos.SinhVienDTO2;
import com.tuanother.models.Khoa;
import com.tuanother.models.Lop;
import com.tuanother.models.SinhVien;
import com.tuanother.services.KhoaService;
import com.tuanother.services.LopService;
import com.tuanother.services.SinhVienService;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienService sinhVienService;
	
	@Autowired
	LopService lopService;
	
	@Autowired
	KhoaService khoaService;
	
	@RequestMapping("/ds-sinh-vien")
	public String DS(ModelMap model,@RequestParam("p") Optional<Integer> p) {
		Sort sort = Sort.by("maSV").descending();
		Pageable pageable=PageRequest.of(p.orElse(0),4,sort);
		Page<SinhVien> page =sinhVienService.findAll(pageable);
		List<SinhVien> sinhViens=page.getContent();
		Long tongsv=sinhVienService.count();
		model.addAttribute("sinhvien",sinhViens);
		model.addAttribute("page",page);
		model.addAttribute("tongsv", tongsv);
		
		return "sinhvien/ds-sinh-vien";
	}
	
	@RequestMapping ( "/search-sv-lop")
	public String searchSinhVienByLop(@RequestParam("ten") String ten, ModelMap model) {
		Lop lop= lopService.findByTenLop(ten);
		if(lop==null) {
			model.addAttribute("ERROR", "Không Tìm thấy lớp cần tìm!!!!!");
			return"redirect:/ds-sinh-vien";
		} else {
			List<SinhVien> sinhViens=sinhVienService.findByMalop(lop.getMaLop());
			int tongSV1Lop=sinhVienService.tongSV1Lop(lop.getMaLop());
			
			model.addAttribute("sinhvien",sinhViens);
			model.addAttribute("tongsv1lop", tongSV1Lop);
			
			
			return "sinhvien/search-sv-lop";
		}
	}
		
		@RequestMapping("/search-sv-khoa")
		public String searchSinhVienByKhoa(@RequestParam("ten") String ten, ModelMap model) {
		
			Khoa khoa = (Khoa) khoaService.findByTenKhoa(ten);
			if(khoa==null) {
				model.addAttribute("ERROR", "Không Tìm thấy Khoa cần tìm!!!!!");
				return"redirect:/ds-sinh-vien";
			} else {
				List<SinhVienDTO2> sinhViens=sinhVienService.findByKhoa(khoa.getMaKhoa());
				int tongSV1Khoa= sinhVienService.tongSV1Khoa(khoa.getMaKhoa());
				
				model.addAttribute("sinhvien",sinhViens);
				model.addAttribute("tongsv1khoa",tongSV1Khoa);
				
				return "sinhvien/search-sv-khoa";
			}
			
		
		
	}
	@RequestMapping("/them-sinh-vien")
	public String addNV(ModelMap model) {
		SinhVienDTO sinhVien=new SinhVienDTO();
		
		model.addAttribute("sinhviendto", sinhVien);
		
		return "sinhvien/dang-ky-sinhvien";
	}
	
	@RequestMapping(value = "/luusv", method = RequestMethod.POST)
	public String luuNhanVien(SinhVienDTO sinhViendto,
							  ModelMap model,
							  @RequestParam("fileImage") MultipartFile file) throws IOException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		System.out.println(filename);

		SinhVien sinhVien=new SinhVien();
		sinhVien.setMaSV(sinhViendto.getMaSV());
		sinhVien.setTenSV(sinhViendto.getTenSV());
		sinhVien.setGioiTinh(sinhViendto.isGioiTinh());
		sinhVien.setNgaySinh(sinhViendto.getNgaySinh());
		// xu ly fie
		sinhVien.setImage(filename);
		sinhVien.setQueQuan(sinhViendto.getQueQuan());
		Lop lop=new Lop();
		lop.setMaLop(sinhViendto.getMaLop());
		
		sinhVien.setLopHoc(lop);
		
		SinhVien sv=sinhVienService.save(sinhVien);

		// xu ly file

		String uploadDir="./image/"+sv.getMaSV(); // dduong dan luu file
		Path uploadPath = Paths.get(uploadDir);


		if(!Files.exists(uploadPath)){
			Files.createDirectories(uploadPath);
		}

		try {
			InputStream inputStream =file.getInputStream();
			Path filePath =uploadPath.resolve(filename);
			System.out.println(filePath.toFile().getAbsolutePath());

			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

		}catch (IOException io){
			throw new IOException("Could Not Save File:"+ filename);
		}
		
		return "redirect:/ds-sinh-vien";
	}
	
	
	@RequestMapping("/edit/{maSV}")
	public ModelAndView editSinhVien(@PathVariable("maSV") String maSV) {
		ModelAndView mv=new ModelAndView("sinhvien/sua-infor-sinhvien");
		SinhVienDTO sinhVienDTO=new SinhVienDTO();
		Optional<SinhVien> sinhVien=sinhVienService.findById(maSV);
		
		
		
		sinhVienDTO.setMaSV(sinhVien.get().getMaSV());
		sinhVienDTO.setTenSV(sinhVien.get().getTenSV());
		sinhVienDTO.setGioiTinh(sinhVien.get().isGioiTinh());
		sinhVienDTO.setNgaySinh(sinhVien.get().getNgaySinh());
		sinhVienDTO.setImage(sinhVien.get().getImage());
		sinhVienDTO.setQueQuan(sinhVien.get().getQueQuan());
	
		sinhVienDTO.setMaLop(sinhVien.get().getLopHoc().getMaLop());
		
		mv.addObject("sinhviendto",sinhVienDTO);
		
		return mv;
		
	}
	
	@RequestMapping("/delete/{maSV}")
	public String deleteSinhVien(@PathVariable("maSV") String maSV) {
		 sinhVienService.deleteById(maSV);
		 return "redirect:/ds-sinh-vien";
	}
	@ModelAttribute(name = "lops")
	public List<Lop> getLop(){
		return sinhVienService.findAllLop();
	}


	@GetMapping("/403")
	public String error(){
		return "error/403";
	}
}
