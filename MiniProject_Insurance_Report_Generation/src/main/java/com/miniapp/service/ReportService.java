package com.miniapp.service;

import java.util.List;

import com.miniapp.entity.CitizenPlan;
import com.miniapp.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
	
	/*	
	 * ReportService (I)
	 * 1) method to get plan-name drop down data
	 * 2) method to get plan-status drop down data
	 * 3) method to handle search functionality
	 * 4) method to export data to excel file
	 * 5) method to export data to pdf file
	 */
	
	public List<String> getPlanName();
	
	public List<String> getPlanStatuses();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	
	public boolean exportPdf(HttpServletResponse response) throws Exception; 
	
	
//	public List<CitizenPlan> getCitizenUsingPlanName(String planName);
//	
//	public List<CitizenPlan> getCitizenUsingPlanStatus(String planStatus);
//	
//	public List<CitizenPlan> getCitizenUsingGender(String Gender);
//	
//	public List<CitizenPlan> getCitizenUsingPlanNameAndPlanStatus(String planName, String planStatus);
//	
//	public List<CitizenPlan> getCitizenUsingPlanNameAndGender(String planName, String Gender);
//	
//	public List<CitizenPlan> getCitizenUsingPlanStatusAndGender(String planStatus, String Gender); 	

}
