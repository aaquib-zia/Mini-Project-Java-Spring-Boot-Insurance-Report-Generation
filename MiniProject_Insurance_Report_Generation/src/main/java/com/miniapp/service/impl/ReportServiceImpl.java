package com.miniapp.service.impl;




import java.time.LocalDate;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openpdf.text.Document;
import org.openpdf.text.Font;
import org.openpdf.text.FontFactory;
import org.openpdf.text.PageSize;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.miniapp.entity.CitizenPlan;
import com.miniapp.repo.CitizenPlanRepository;
import com.miniapp.request.SearchRequest;
import com.miniapp.service.ReportService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService{
	
	private CitizenPlanRepository citRepo;
	
	public ReportServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public ReportServiceImpl(CitizenPlanRepository citRepo) {
		this.citRepo = citRepo;
	}

	@Override
	public List<String> getPlanName() {
		return citRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {
	     return citRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		
		CitizenPlan entity = new CitizenPlan();
		if(request.getPlanName()!=null && request.getPlanName()!="") {
			entity.setPlanName(request.getPlanName());
			
		}
		if(request.getPlanStatus()!=null && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
			
		}
		if(request.getGender()!=null  && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		
		if(request.getStartDate()!=null) {
			LocalDate startDate = request.getStartDate();
			
			entity.setPlanStartDate(startDate);
		}
		
		if(request.getEndDate()!=null) {
			entity.setPlanEndDate(request.getEndDate());
		}
		
		List<CitizenPlan> all = citRepo.findAll(Example.of(entity));
		System.out.println(all);
	
		
//		System.out.println("Execution");
//		System.out.println(request);
//		System.out.println(entity);
		return citRepo.findAll(Example.of(entity));		
	}
	

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		
		List<CitizenPlan> record = citRepo.findAll();

		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("reports_excel");
		Row headerRow = sheet.createRow(0);
		
		
		
		headerRow.createCell(0).setCellValue("Id");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Plan Start Date");
		headerRow.createCell(5).setCellValue("Plan End Date");
		headerRow.createCell(6).setCellValue("Benefit Amount");
		
		int dataRowIndex = 1;
		
		for(CitizenPlan rec : record) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(rec.getCitizenId());
			dataRow.createCell(1).setCellValue(rec.getCitizenName());
			dataRow.createCell(2).setCellValue(rec.getPlanName());
			dataRow.createCell(3).setCellValue(rec.getPlanStatus());
			if(rec.getPlanStartDate()!=null) {
				dataRow.createCell(4).setCellValue(rec.getPlanStartDate()+"");
			}else {
				dataRow.createCell(4).setCellValue("N/A");
			}
			if(rec.getPlanEndDate()!=null) {
				dataRow.createCell(5).setCellValue(rec.getPlanEndDate()+"");
			}else {
				dataRow.createCell(5).setCellValue("N/A");
			}
			if(rec.getBenefitAmt()!=null) {
			dataRow.createCell(6).setCellValue(rec.getBenefitAmt());
			}
			else{
				dataRow.createCell(6).setCellValue("N/A");
			}
			dataRowIndex++;
		}
		
//		FileOutputStream fos = new FileOutputStream(new File("plans.xls"));
//		workbook.write(fos);
//		workbook.close();
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		
		Document doc = new Document(PageSize.A4);
		PdfWriter.getInstance(doc, response.getOutputStream());
		
		doc.open();
		
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC); 
		fontTitle.setSize(20);
		fontTitle.setColor(80,200,150);
		
		
		Paragraph p = new Paragraph("Citizen-Plans-Info", fontTitle);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		p.setSpacingBefore(20.0f);
	    p.setSpacingAfter(25.0f);
		doc.add(p);
		

		List<CitizenPlan> plans = citRepo.findAll();
		
		PdfPTable table = new PdfPTable(6);
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		
		for(CitizenPlan plan : plans) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			if(plan.getPlanStartDate()!=null) {
				table.addCell(plan.getPlanStartDate()+"");
			}else {
				table.addCell("N/A");
			}
			if(plan.getPlanEndDate()!=null) {
				table.addCell(plan.getPlanEndDate()+"");
			}else {
				table.addCell("N/A");
			}			
		}
		doc.add(table);
		
		doc.close();
		
		return true;
	}

	
}
