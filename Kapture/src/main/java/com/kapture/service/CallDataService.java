package com.kapture.service;

import com.kapture.entity.CallData;
import com.kapture.exception.CallDataException;

public interface CallDataService {

public CallData addData(CallData data) throws CallDataException;
	
	public String hourOfDayVolumeIsHighest()throws CallDataException;
	
	public String hourOfDayCallIsLongest() throws CallDataException;
	
    public String dayOfWeekVolumeIsHighest()throws CallDataException;
	
	public String dayrOfWeekCallIsLongest() throws CallDataException;
}
