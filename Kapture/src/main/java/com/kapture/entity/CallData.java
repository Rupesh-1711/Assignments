package com.kapture.entity;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


@Entity
@Data
public class CallData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	

	private Long from_number;
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private LocalDateTime start_time;

    
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private LocalDateTime end_time;
	
	private Integer duration;


	
}
