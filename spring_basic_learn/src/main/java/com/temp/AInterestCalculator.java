package com.temp;

public class AInterestCalculator implements InterestCalculator {
	private double rate;

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public double calculate(double amount, double year) {
		if (amount < 0 || year < 0) {
			throw new IllegalArgumentException(
					"Amount or year must be positive !");
		}
		return amount * year * rate;
	}

}
