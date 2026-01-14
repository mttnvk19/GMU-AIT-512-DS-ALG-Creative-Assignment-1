/**
 * Module 1 - Creative Assignment
 * Test for Autonomous Vehicle Linked List Bag
 */
package m1ac;

import java.util.Date;

/**
 * Testing class for various types of bags.
 * <T> is a generic data type
 * @author Matthew Novak
 */
public class m1actest {
	public static <T> void testBag(Bagm1ac<T> bag, T[] items) {
		System.out.println("Ratings for the day: " + bag.toString());
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		for (T item: items) {
			System.out.println("A customer gave a rating of: " + item.toString() + " stars");
			try {
				bag.add(item);
				System.out.println("Ratings for the day: " + bag.toString());
				System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			} catch (Exception e) {
				System.out.println("Error adding an element to the bag: "+e.getMessage());
			}			
		}
	}
	public static class Mode<T> {
		public final T value;
		public final int count;
		public Mode(T value, int count) {
			this.value = value;
			this.count = count;
		}
	}
	
	/**
	 * Calculating the mode of the ratings and recording the most frequent rating
	 * "<T>" is a generic data type
	 * @param <T>
	 * @param bag
	 * @return
	 */
	public static <T> Mode<T> RatingMaxFrequency(Bagm1ac<T> bag) {
		T freqVal = null;
		int freqCount = 0;
		
		for (T x: bag) {
			int count = 0;
			for (T y: bag) {
				if (x == null ? y == null : x.equals(y)) {
					count++;
				}
			}
			if (count > freqCount) {
				freqCount = count;
				freqVal = x;
			}
		}
		return (freqVal ==null)? null: new Mode<>(freqVal, freqCount);
	}
	/**
	 * ".NaN" means not a number
	 * This is calculating the average of all of the ratings
	 * Must be a double
	 * @param bag
	 * @return
	 */
	public static double average(Bagm1ac<Double> bag) {
		double sum = 0.0;
		int n = 0;
		for (Double r : bag) {
			if (r != null) {sum += r; n++;}
		}
		return n == 0? Double.NaN : sum / n;
	}
	
	/**
	 * This is testing the maximum frequency of the rating and returning the rating with the highest frequency
	 * @param <T>
	 * @param bag
	 */
	public static <T> void testMaxFrequency(Bagm1ac<T> bag) {
		System.out.println("Ratings for the day: " + bag.toString());
		Mode<T> mode = RatingMaxFrequency(bag);
		if (mode != null) {
			System.out.println("The rating you recieved the most today was: " + mode.value +" stars." + " You recieved that rating " + mode.count + " times today.");
		} else {
			System.out.println("No reviews have been posted yet.");
		}
		//System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
	}
	
	/**
	 * This is testing the average of the rates
	 * @param bag
	 */
	public static void tesAvgRate(Bagm1ac<Double> bag) {
		double avg = average(bag);
		if (Double.isNaN(avg)) {
			System.out.println("No reviews have been posted yet.");
		} else {
		System.out.println("Your average rating for the day was: " + String.format("%.1f", avg) + " stars.");
		}
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
	}
	/**
	 * Main method performing all the tests.
	 * 
	 * @param args - not used
	 */
	public static void main(String[] args) {
		System.out.println("Creative Assignment - M1A-C - by Matthew Novak");
		Date date = new Date();
		System.out.println("Executed on: " + date.toString());
		System.out.println("Customer Ratings for the day from 0.0 stars to 5.0 stars");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		Double[] doubleItems = {3.5,5.0,4.3,1.1,4.5,3.5,2.5,5.0,3.5,4.5,2.0};
		Bagm1ac<Double> CustomerRating = new m1aclinkedlistbag<Double>();
		testBag(CustomerRating,doubleItems);
		testMaxFrequency(CustomerRating);
		tesAvgRate(CustomerRating);
	}}

