package co.ie12.Ie12SampleMovie.service;

import co.ie12.Ie12SampleMovie.entity.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PriceCalculatorFactory {

    public static PriceCalculator create(Schedule schedule){
        //List<String> list = new ArrayList<>();
    	if (schedule.isMorningShow()) {
    		return new MornigShowCalculator();
    	}
        
    	if(schedule.isMoviesDay()){
            return  new MoviesDayPriceCalculator();
        }
        
    	if(schedule.isLateShow()) {
    		return new LateShowCalculator();
    	}
    	
    	return  new DefaultPriceCalculator();
    }

}
