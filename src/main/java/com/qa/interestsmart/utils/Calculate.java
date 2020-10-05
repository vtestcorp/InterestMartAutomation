package com.qa.interestsmart.utils;

import java.time.LocalDate;
import java.time.Period;

public class Calculate {
	private static double expected_MonthlyPayment;
	private static long expected_Diff_NumberOfPayment;
	private static double expected_RemainingBalance;
	private static double expected_ActualEstimatedRate;
    
	
	public static void calculateTimePeriod() {

		LocalDate pdate = LocalDate.of(2012, 01, 01);
		LocalDate now = LocalDate.now();

		Period diff = Period.between(pdate, now);

		// System.out.printf("\nDifference is %d years, %d months and %d days
		// old\n\n", diff.getYears(), diff.getMonths(),diff.getDays());

		System.out.printf("\nDifference is %d months", diff.getMonths());

	}

	public static double calcuteActualEstimatedRate(double roi) {
		expected_ActualEstimatedRate = roi / 100 / 12;
		System.out.println("Expected estimated rate is " + expected_ActualEstimatedRate);
		return expected_ActualEstimatedRate;
	}

	public static double calcuteMonthlyPayment(double loanAmount,int period) {
		double value = (loanAmount * expected_ActualEstimatedRate) / (1 - Math.pow(1 + expected_ActualEstimatedRate, -1 * period));
		expected_MonthlyPayment = (double) Math.round(value * 100) / 100;
		System.out.println("Expected monthly payment is " + expected_MonthlyPayment);
		return expected_MonthlyPayment;
	}

	public static long noOfPaymentsDone(long loanStart, long current) {
		expected_Diff_NumberOfPayment = loanStart - current;
		System.out.println("Expected number Of Payment are: " + expected_Diff_NumberOfPayment);
		return expected_Diff_NumberOfPayment;
	}

	public static double remainingBalanceLeft() {
		// double firstValue=;
		expected_RemainingBalance = Math.ceil(
				expected_MonthlyPayment * (1 - 1 / (Math.pow(1 + expected_ActualEstimatedRate, expected_Diff_NumberOfPayment))) / expected_ActualEstimatedRate);
		System.out.println("Expected Remaining balance is " + expected_RemainingBalance);
		return expected_RemainingBalance;
	}

	public static void main(String[] ar) {
		Calculate.calcuteActualEstimatedRate(3.690);
		Calculate.calcuteMonthlyPayment(1000.00,360);
		Calculate.noOfPaymentsDone(360, 10);
		Calculate.remainingBalanceLeft();
		// Calculation.calculateTimePeriod();
	}

}
