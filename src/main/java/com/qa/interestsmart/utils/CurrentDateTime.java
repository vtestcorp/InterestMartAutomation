package com.qa.interestsmart.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrentDateTime {
	
	public String getCurrentDateAndTime()
	{
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        
        String currentDateAndTime = formater.format(calendar.getTime());
        return currentDateAndTime;
	}

}
