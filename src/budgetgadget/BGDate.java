
package budgetgadget;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;

//created 9/1/2016 ~9 pm
//reason: the date class in java sucked
//allow easy access of current year, month and date

//TO DO
//add a time stamp xx:xx pm/am

/*
Date data formate used for Budget Gadget
*/

public class BGDate implements Serializable{

	private static final long serialVersionUID = 1L;
	public final int year, month, day;
    private final int currentYear;
    private final int MAX_YEAR_RANGE = 50;
    
    /**
     * if no arguments are passed the date defaults to today's date
     */
    public BGDate(){
        DateFormat dateFormate = new SimpleDateFormat("YYYYMMdd");
        Date date = new Date();
        String date_str = dateFormate.format(date);
        year = Integer.parseInt(date_str.substring(0, 4));
        currentYear = year;
        month = Integer.parseInt(date_str.substring(5, 6));
        day = Integer.parseInt(date_str.substring(7, 8));
    }
    
    /**
     * Set the date as the desired date passed
     * @param newYear - range: (current year +/- 100 years)
     * @param newMonth - range: (1~12)
     * @param newDay  - has to be a valid day in newMonth
     * throws an exception if one of the conditions above wasn't met
     */
    public BGDate(int newYear, int newMonth, int newDay) throws IllegalArgumentException{
    	DateFormat dateFormate = new SimpleDateFormat("YYYYMMdd");
        Date date = new Date();
        String date_str = dateFormate.format(date);
        
        currentYear = Integer.parseInt(date_str.substring(0, 4));
        
        if(invalidDate(newYear, newMonth, newDay)){
        	throw new IllegalArgumentException();
        }
        
        year = newYear;
        month = newMonth;
        day = newDay;
    }
    
    private boolean invalidDate(int newYear, int newMonth, int newDay){
    	if(newYear > (currentYear + MAX_YEAR_RANGE) || newYear < (currentYear - MAX_YEAR_RANGE))
    		return true;
    	
    	int daysInMonth = daysOfMonth(newYear, newMonth);
    	
    	if(daysInMonth == 40)
    		return true;
    	
    	if(newDay > daysInMonth || newDay < 0)
    		return true;
    	
    	return false;
    }
    
    //returns the days in a month
    //returns 40 if this month does not exist. i.e: month > 12 or month < 1
    private int daysOfMonth(int y, int m){
    	boolean leap = false;
    	
    	if(y % 4 == 0){
    		leap = true;
    	}
    	
    	switch(m){
    		case 1:
    			return 31;
    		case 2:
    			if(leap)
    				return 29;
    			else 
    				return 28;
    		case 3:
    			return 31;
    		case 4:
    			return 30;
    		case 5:
    			return 31;
    		case 6:
    			return 30;
    		case 7:
    			return 31;
    		case 8:
    			return 31;
    		case 9:
    			return 30;
    		case 10:
    			return 31;
    		case 11:
    			return 30;
    		case 12:
    			return 31;
    		default:
    			return 40;
    	}
    }
    
    /**
     * Set the stored date in the array passed
     * @param date array with date.length = 3;
     */
    public void getDate(int[] date){
        date[0] = year;
        date[1] = month;
        date[2] = day;
    }
    
    /**
     * 
     * @return String formated as "yyyy/mm/dd"; 
     */
    public String toString(){
        return String.format("%d/%d/%d", year, month, day);
    }
}
