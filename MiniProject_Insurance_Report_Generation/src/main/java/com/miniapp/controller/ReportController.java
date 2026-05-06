 package com.miniapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.miniapp.entity.CitizenPlan;
import com.miniapp.request.SearchRequest;
import com.miniapp.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	
	private ReportService service;
	
	public ReportController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public ReportController(ReportService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String indexPage(Model model) {
				
		model.addAttribute("searchi", new SearchRequest());
		// binding drop down
		model.addAttribute("name", service.getPlanName());
		model.addAttribute("statuses", service.getPlanStatuses());
		return "index";
	}

	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("searchi") SearchRequest request, Model model) {

		List<CitizenPlan> plans = service.search(request);
		model.addAttribute("plans", plans);
		model.addAttribute("name", service.getPlanName());
		model.addAttribute("statuses", service.getPlanStatuses());
		return "index";
	}
	
	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment; filename=plans.xls");
		service.exportExcel(response);
	
	}
	
	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=plans.pdf");
		service.exportPdf(response);
	
	}
	
//	https://excalidraw.com/#json=eH5dezkzj6uU9-Wr1IBIA,mlxc-hzwnpv6_8IDqG0U9w
}
