package com.example.global.model;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDto {

	private String message;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime timestamp;

	public int status;

	private Map<String, FormFieldDto> fieldErrors;

	public ErrorDto() {
		// TODO Auto-generated constructor stub
	}

	public ErrorDto(String message, LocalDateTime timestamp, int status, Map<String, FormFieldDto> fieldErrors) {
		this.message = message;
		this.timestamp = timestamp;
		this.status = status;
		this.fieldErrors = fieldErrors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Map<String, FormFieldDto> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(Map<String, FormFieldDto> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	@Override
	public String toString() {
		return "ErrorDto [message=" + message + ", timestamp=" + timestamp + ", status=" + status + ", fieldErrors="
				+ fieldErrors + "]";
	}
}