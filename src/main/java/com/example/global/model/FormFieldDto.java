package com.example.global.model;

import java.util.List;

public class FormFieldDto {

	private String fieldName;
	private List<String> errorMsg;

	public FormFieldDto(String fieldName, List<String> errorMsg) {
		this.fieldName = fieldName;
		this.errorMsg = errorMsg;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public List<String> getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(List<String> errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "FormFieldDto [fieldName=" + fieldName + ", errorMsg=" + errorMsg + "]";
	}

}
