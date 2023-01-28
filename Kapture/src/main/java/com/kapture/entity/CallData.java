package com.kapture.entity;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class CallData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull 
	private Long from_number;
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private LocalDateTime start_time;

    
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private LocalDateTime end_time;
	
	private Integer duration;

	
	public CallData(Long from_number, LocalDateTime start_time, LocalDateTime end_time) {
		this.from_number = from_number;
		this.start_time = start_time;
		this.end_time = end_time;
	}
    
	

	
}
