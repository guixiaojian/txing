package com.tx.collect;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MathTest {

	@Test
	public void randomtest(){

		double lat = 24.79029922 ;
		double lon = 102.82257282 ;


		BigDecimal lat2 = BigDecimal.valueOf(lat).add(new BigDecimal(Math.random()*10).setScale(2, BigDecimal.ROUND_HALF_UP));

		BigDecimal lon2 = BigDecimal.valueOf(lon).add(new BigDecimal(Math.random()*10).setScale(2, BigDecimal.ROUND_HALF_UP));

		System.out.println(lat2);
		System.out.println(lon2);


		System.out.println(BigDecimal.valueOf(Math.random() * 1000));
	}

}
