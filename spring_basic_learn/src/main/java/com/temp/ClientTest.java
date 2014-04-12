package com.temp;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ClientTest {
	private static AInterestCalculator aInterestCalculator;

	@BeforeClass
	public static void beforeClass() {
		aInterestCalculator = new AInterestCalculator();
		aInterestCalculator.setRate(0.05);
		System.out.println("beforeClass..");
	}

	private double expect;

	private double amount;
	private double year;

	@Parameters
	public static Collection perpareData() {
		Object[][] objs = { { 1000, 10000, 2 }, { 0, 0, 100 } };

		return Arrays.asList(objs);
	}

	public ClientTest(double expect, double amount, double year) {
		this.expect = expect;
		this.amount = amount;
		this.year = year;
	}

	@Test
	public void t() {
		System.out.println("amount:" + this.amount + "\tyear:" + this.year + "\texpect:" + expect);
		System.out.println(this.expect + "   "
				+ aInterestCalculator.calculate(this.amount, this.year));
		Assert.assertTrue(this.expect == aInterestCalculator.calculate(
				this.amount, this.year));
	}

}
