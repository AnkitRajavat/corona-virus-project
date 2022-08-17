package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.project.services.Coronavirusdataservice;


import models.Locartionstates;

@Controller
public class Homecontroller {
	@Autowired(required =false)
	Coronavirusdataservice coronavirusdataservice;
	
	@RequestMapping("/")
	private String home(Model model){
		List<Locartionstates> allStats = coronavirusdataservice.getAllstats();
       int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "home";
	}

}
