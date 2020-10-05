package com.qa.interestsmart.utils;
/**
 * @author Sarang
 *	This class holding up methods
 *	to pause the script for certain
 *	amount of time
 */
public class CommonUtil {
	
	/**
	 * This method will pause the script for 2000 milliseconds
	 */
	public static void nanoWait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will pause the script for 4000 milliseconds
	 */
	public static void shortWait() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will pause the script for 6000 milliseconds
	 */
	public static void MediumWait() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will pause the script for 10000 milliseconds
	 */
	public static void LongWait() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
