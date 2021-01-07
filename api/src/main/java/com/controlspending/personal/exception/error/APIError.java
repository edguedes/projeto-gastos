package com.controlspending.personal.exception.error;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class APIError {
	
	@JsonProperty("erro")
	private List<ErrorItem> items = new ArrayList<>();
	
	public APIError() {
		super();
	}

	public List<ErrorItem> getItems() {
		return items;
	}

	public void setItems(List<ErrorItem> items) {
		this.items = items;
	}

}


