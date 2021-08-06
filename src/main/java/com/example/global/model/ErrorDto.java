package com.example.global.model;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorDto {

	private String message;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime timestamp;

	public int status;

	private Map<String, FormFieldDto> fieldErrors;
}