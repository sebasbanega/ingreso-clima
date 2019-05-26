package com.sebastian.ingreso.dto;

import java.util.List;

public class CompleteReportDto {

	private List<ReportDto> results;
	private String report;

	public CompleteReportDto(List<ReportDto> results, String report) {
		super();
		this.results = results;
		this.report = report;
	}

	public List<ReportDto> getResults() {
		return results;
	}

	public void setResults(List<ReportDto> results) {
		this.results = results;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}
}
