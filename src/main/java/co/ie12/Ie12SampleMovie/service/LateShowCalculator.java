package co.ie12.Ie12SampleMovie.service;

import java.math.BigDecimal;

/*
 * 早朝割引用の料金
 */
public class LateShowCalculator implements PriceCalculator {

	@Override
	public BigDecimal calculatePrice() {
		// TODO Auto-generated method stub
		return new BigDecimal(1000);
	}
}
