package co.ie12.Ie12SampleMovie.service;

import co.ie12.Ie12SampleMovie.entity.Schedule;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

public class CalculatePriceServiceTest {

    @Test
    public void 上映日が各月の1日の場合上映料金が1000円であること(){
        Schedule schedule = new Schedule();
        schedule.setShowDay(LocalDate.of(2018,3,1));
        CalculatePriceService priceService = new CalculatePriceService(schedule);
        assertThat(priceService.calculatePrice(),is(new BigDecimal(1000)));
    }

    @Test
    public void 上映日が1日でない場合上映料金が1800円であること(){
        Schedule schedule = new Schedule();
        schedule.setShowDay(LocalDate.of(2018,3,2));
        CalculatePriceService priceService = new CalculatePriceService(schedule);
        assertThat(priceService.calculatePrice(),is(new BigDecimal(1800)));
    }
    
    @Test
    public void 上映日が1日でかつ8時より前に終わると800円(){
        Schedule schedule = new Schedule();
        schedule.setEndTime(LocalTime.of(7, 59));
        schedule.setShowDay(LocalDate.of(2018, 3, 1));
        CalculatePriceService priceService = new CalculatePriceService(schedule);
        assertThat(priceService.calculatePrice(),is(new BigDecimal(800)));
    }
    
    @Test
    public void 上映日が1日以外でかつ8時より前に終わると800円() {
    	Schedule schedule = new Schedule();
        schedule.setEndTime(LocalTime.of(7, 59));
        schedule.setShowDay(LocalDate.of(2018, 3, 2));
        CalculatePriceService priceService = new CalculatePriceService(schedule);
        assertThat(priceService.calculatePrice(),is(new BigDecimal(800)));
    }
    
    @Test
    public void 上映日が1日以外で終了時間が8時ちょうどとなると1800円() {
    	Schedule schedule = new Schedule();
    	schedule.setEndTime(LocalTime.of(8, 00));
    	schedule.setShowDay(LocalDate.of(2018, 3, 2));
    	CalculatePriceService priceService = new CalculatePriceService(schedule);
    	assertThat(priceService.calculatePrice(),is(new BigDecimal(1800)));
    }

    @Test
    public void 上映日が1日以外で開始時間が21時以降で1000円() {
    	Schedule schedule = new Schedule();
    	schedule.setStartTime(LocalTime.of(21, 01));
    	schedule.setShowDay(LocalDate.of(2018, 3, 2));
    	CalculatePriceService priceService = new CalculatePriceService(schedule);
    	assertThat(priceService.calculatePrice(),is(new BigDecimal(1000)));
    }
}
