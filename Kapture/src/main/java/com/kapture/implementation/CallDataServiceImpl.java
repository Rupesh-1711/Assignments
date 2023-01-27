package com.kapture.implementation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapture.entity.CallData;
import com.kapture.exception.CallDataException;
import com.kapture.repository.CallDataRepository;
import com.kapture.service.CallDataService;

@Service
public class CallDataServiceImpl implements CallDataService{

	@Autowired
	private CallDataRepository cRepo;
	
	@Override
	public CallData addData(CallData data) throws CallDataException {
		
		if(data ==null) {
			throw new CallDataException("Enter valid data");
		}
		System.out.print(data);
		cRepo.save(data);
		return data;
	}

	@Override
	public String hourOfDayVolumeIsHighest() throws CallDataException {
		
		List<Object[]> list = cRepo.findHighestCallVolumeByHour();
	
		if(list.size()==0) {
			throw new CallDataException("Data not found");
		}
		
		Object[] a = list.get(0);
         int start = (int)a[0];
         int end = start+1;
         if(start >=0 && start<=11) {
        	 return start+"-"+end+" AM";
         }else {
        	 
        	 return "Hour of the day when the call volume is highest is "+start+"-"+end+" PM";
         }
		
	}

	@Override
	public String hourOfDayCallIsLongest() throws CallDataException {
		
		List<Object[]> list = cRepo.findLongestCallbyHour();
		
		if(list.size()==0) {
			throw new CallDataException("Data not found");
		}
		
		Object[] a = list.get(0);
         int start = (int)a[0];
         int end = start+1;
         if(start >=0 && start<=11) {
        	 return start+"-"+end+" AM";
         }else {
        	 
        	 return "Hour of the day when the calls are longest is "+start+"-"+end+" PM";
         }
	}

	@Override
	public String dayOfWeekVolumeIsHighest() throws CallDataException {
		
		List<Object[]> list = cRepo.findHighestCallVolumebyDay();
		
		if(list.size()==0) {
			throw new CallDataException("Data not found");
		}
		Object[] a = list.get(0);
		
		String day =(String) a[0];
       return "Day of the Week when the call volume is highest is "+day;
	}

	@Override
	public String dayrOfWeekCallIsLongest() throws CallDataException {
		List<Object[]> list = cRepo.findLongestCallbyDay();
		
		if(list.size()==0) {
			throw new CallDataException("Data not found");
		}
		Object[] a = list.get(0);
		
		String day =(String) a[0];
       return "Day of the Week when the call volume is longest is "+day;
	}

}
