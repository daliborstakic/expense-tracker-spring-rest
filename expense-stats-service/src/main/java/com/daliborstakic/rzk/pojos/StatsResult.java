package com.daliborstakic.rzk.pojos;

import java.time.LocalDateTime;
import java.util.Map;

public class StatsResult {
	private Map<String, Double> results;
	private Object groupElement;
	private LocalDateTime currentDateTime;

	public StatsResult(Map<String, Double> results, Object groupElement) {
		super();
		this.results = results;
		this.groupElement = groupElement;
		this.currentDateTime = LocalDateTime.now();
	}

	public Map<String, Double> getResults() {
		return results;
	}

	public void setResults(Map<String, Double> results) {
		this.results = results;
	}

	public Object getGroupElement() {
		return groupElement;
	}

	public void setGroupElement(Object groupElement) {
		this.groupElement = groupElement;
	}

	public LocalDateTime getCurrentDateTime() {
		return currentDateTime;
	}

	public void setCurrentDateTime(LocalDateTime currentDateTime) {
		this.currentDateTime = currentDateTime;
	}
}
