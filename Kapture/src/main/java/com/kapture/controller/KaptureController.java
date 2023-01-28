package com.kapture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kapture.entity.CallData;
import com.kapture.exception.CallDataException;
import com.kapture.service.CallDataService;

@RestController
@RequestMapping("/kapture")
public class KaptureController {


	@Autowired
	private CallDataService cService;
	@PostMapping("/")
	public ResponseEntity<CallData> addData(@RequestBody CallData data) throws CallDataException {
	      CallData result = cService.addData(data);
		return new ResponseEntity<CallData>(result,HttpStatus.CREATED);
	}

	@GetMapping("/hourVolume")
	public ResponseEntity<String> hourOfDayVolumeIsHighest() throws CallDataException {
		String info = cService.hourOfDayVolumeIsHighest();
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}

	@GetMapping("/hourLongest")
	public ResponseEntity<String> hourOfDayCallIsLongest() throws CallDataException {
		String info = cService.hourOfDayCallIsLongest();
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}

	@GetMapping("/dayVolume")
	public ResponseEntity<String> dayOfWeekVolumeIsHighest() throws CallDataException {
		String info = cService.dayOfWeekVolumeIsHighest();
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}

	@GetMapping("/dayLongest")
	public ResponseEntity<String> dayrOfWeekCallIsLongest() throws CallDataException {
		String info = cService.dayrOfWeekCallIsLongest();
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}
}
