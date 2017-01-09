package Calendar;

import java.util.Calendar;

public class Date implements Comparable<Date>{
	
	private int month; //The month of the date (1-12)
	private int day; //The day of the date (depends on the month/year)
	private int year; //The year of the date
	
	/**
	 * This is the constructor method. The month, day and year are instantiated.
	 * This method also throws errors depending on the input
	 * @param m- the date's month
	 * @param d- the date's day
	 * @param y- the date's year
	 */
	public Date(int m, int d, int y){
		month = m;
		day = d;
		year = y;
		if(month<1||month>12)
			throw new IllegalArgumentException("Invalid month");
		if(day<1||day>maxDay())
			throw new IllegalArgumentException("Invalid day");
		if(year<1)
			throw new IllegalArgumentException("Invalid year");
	}
	/**
	 * This method gets the max number of days in the current month
	 * @return- the number of days in the month
	 */
	private int maxDay() {
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
				return 31;
		case 4:
		case 6:
		case 9:
		case 11:
				return 30;
		case 2:	if(leapYear())
					return 29;
				return 28;
		}
		return -1;
	}
	/**
	 * This method determines if the current year is a leap year
	 * @return - true if the year is a leap year
	 * 			 false if the year is not a leap year
	 */
	private boolean leapYear() {
        return ((year % 400 == 0) || (year % 4 == 0 && (year % 100 != 0))) ? true: false;
	}
	
	/**
	 * This method gets the month
	 * @return the date's month
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * This method gets the day
	 * @return the date's day
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * This method gets the year
	 * @return the date's year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * This method compares two different dates to each other
	 * @param- the other date to check
	 * @return- returns negative if this date comes before the passed in one
	 * 					positive if this date comes after
	 * 					0 if the dates are equivalent
	 */
	public int compareTo(Date o) {
		int y = o.getYear();
		int d = o.getDay();
		int m = o.getMonth();
		
		if(year-y==0){
			if(month-m == 0){
				return day-d;
			}
			return month-m;
		}
		return year-y;
			
	}
	/**
	 * This method gets the string representation of the date
	 * @return- the date in string form
	 */
	public String toString(){
		return month+"/"+day+"/"+year;
	}

}
