package com.temp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class AInterestCalculatorTest {
	private AInterestCalculator aInterestCalculator;

	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass..");
	}
	
	@Before
	public void init() {
		this.aInterestCalculator = new AInterestCalculator();
		this.aInterestCalculator.setRate(0.05);
		System.out.println("init()..");
	}
	
	@Test
	public void testA1(){
		double ret = this.aInterestCalculator.calculate(1000, 2);
		Assert.assertTrue(ret == 100);
	}
	
	@Test
	public void testA2(){
		double ret = this.aInterestCalculator.calculate(10000, 3);
		Assert.assertTrue(ret == 1500);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testB(){
		double ret = this.aInterestCalculator.calculate(-1000, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testC(){
		double ret = this.aInterestCalculator.calculate(1000, -2);
	}
}
