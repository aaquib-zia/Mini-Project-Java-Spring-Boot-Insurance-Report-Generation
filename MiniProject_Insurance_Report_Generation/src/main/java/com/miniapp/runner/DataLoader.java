package com.miniapp.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.miniapp.entity.CitizenPlan;
import com.miniapp.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner{
	
	private CitizenPlanRepository citRepo;
	
	public DataLoader() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired 
	public DataLoader(CitizenPlanRepository citRepo) {
		this.citRepo = citRepo;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		citRepo.deleteAll();
		
		// Cash Plan Data
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("Jofra");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setBenefitAmt(5000.00);
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		
		
		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Cathy");
		c2.setGender("Female");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("Rental Income");
		
		
		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Brett Lee");
		c3.setGender("Male");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setBenefitAmt(8000.00);
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminationRsn("Employed");
		
		
		// Food Plan Data
		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("David");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setBenefitAmt(7500.00);
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		
		
		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Sara");
		c5.setGender("Female");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("Property Income");
		
		
		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Smriti");
		c6.setGender("Male");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setBenefitAmt(3500.00);
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminationRsn("Employed");

		// Medical Plan Data
		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Tim Southee");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setBenefitAmt(6800.00);
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		
		
		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("Robert");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setDenialReason("Rich");
		
		
		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Cathryn");
		c9.setGender("Female");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setBenefitAmt(9500.00);
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminationRsn("Government Job");
		
		
		// Employment Plan Data
		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("Ellyse");
		c10.setGender("Female");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Approved");
		c10.setBenefitAmt(7000.00);
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		
		
		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("Charles");
		c11.setGender("Male");
		c11.setPlanName("Employment");
		c11.setPlanStatus("Denied");
		c11.setDenialReason("Salaried");
		
		
		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("Steve");
		c12.setGender("Male");
		c12.setPlanName("Employment");
		c12.setPlanStatus("Terminated");
		c12.setBenefitAmt(15000.00);
		c12.setPlanStartDate(LocalDate.now().minusMonths(4));
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setTerminatedDate(LocalDate.now());
		c12.setTerminationRsn("Multiple Incomes");
		
		List<CitizenPlan> list = Arrays.asList(c1, c2, c11, c12, c3, c4, c7, c8, c9, c5, c6, c10);
		citRepo.saveAll(list);
	}
	
	

}
