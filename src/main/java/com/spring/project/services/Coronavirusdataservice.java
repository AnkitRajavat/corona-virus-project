package com.spring.project.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import models.Locartionstates;

@Service
public class Coronavirusdataservice {
	private static String Virus_DATA_URL="https://github.com/CSSEGISandData/COVID-19/blob/master/csse_covid_19_data/csse_covid_19_daily_reports/01-01-2022.csv";
	private List<Locartionstates>allstats=new ArrayList<>();

	public List<Locartionstates> getAllstats() {
		return allstats;
	}
	
	@PostConstruct
	@Scheduled(cron ="* * 1 * * *")
	
	public void fetchVirusdata() throws IOException, InterruptedException{
		
		 List<Locartionstates>newstats=new ArrayList<>();
		HttpClient client= HttpClient.newHttpClient();
		HttpRequest request=HttpRequest.newBuilder().uri(URI.create(Virus_DATA_URL)).build();
		HttpResponse<String> httpresponse=client.send(request,HttpResponse.BodyHandlers.ofString());
		System.out.println(httpresponse.body());
		
		StringReader csvbodyReader=new StringReader (httpresponse.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvbodyReader);
		for (CSVRecord record : records) {
			 Locartionstates locationstates=new Locartionstates();
			 locationstates.setState(record.get("Province_State"));
			 locationstates.setCountry(record.get("Country_Region"));
			 //locationstates.setLatesttotalcases((record.get(record.size()-1)));
			 int latestCases = Integer.parseInt(record.get(record.size() - 1));
			 int prevDayCases = Integer.parseInt(record.get(record.size() - 2));
			 locationstates.setLatestTotalCases(latestCases);
			 locationstates.setDiffFromPrevDay(latestCases - prevDayCases);
	            newstats.add(locationstates);
		    
		   System.out.println(locationstates);
		   newstats.add(locationstates);
		}
		this.allstats=newstats;
		
	}


}
