package com.modelncode.dddk.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 응답전문<T> {
	private String status;
	private String resMessage;
	private String errMessage;
	private List<T> resultset;
	private Map<String, Object> values = new HashMap<String, Object>();
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getResMessage() {
		return resMessage;
	}
	public void setResMessage(String resMessage) {
		this.resMessage = resMessage;
	}
	
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public List<T> getResultset() {
		return resultset;
	}
	public void setResultset(List<T> resultset) {
		this.resultset = resultset;
	}

	public Map<String, Object> getValues() {
		return values;
	}


	public void addValue(String key, Object val) {
		this.values.put(key, val);
	}
}
