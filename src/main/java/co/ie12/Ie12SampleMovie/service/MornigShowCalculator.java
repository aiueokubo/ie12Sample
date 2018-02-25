package co.ie12.Ie12SampleMovie.service;

import java.math.BigDecimal;

/*
 * 早朝割引用の料金
 */
public class MornigShowCalculator implements PriceCalculator{

	@Override
	public BigDecimal calculatePrice() {
		return new BigDecimal(800);
	}
}
