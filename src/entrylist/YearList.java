package entrylist;
import budgetgadget.*;
import java.util.*;

public class YearList extends Entry{
	private final Map<Integer, MonthList> monthMap;
	
	YearList(BGDate date){
		super(0, "entry for the year " + date.year, date);
		monthMap = new TreeMap<>();
	}
	
	
	/**
	 * add newEntry to the list 
	 * @param newEntry the Entry to be added
	 * @throws RuntimeException if newEntry is null
	 */
	public void addEntry(Entry newEntry) throws RuntimeException{
		BGDate date = newEntry.getDate();
		int key = date.month;
		
		if(monthMap.containsKey(key)){
			MonthList entryMonthList = monthMap.get(key);
			entryMonthList.addEntry(newEntry);
		}
		else{
			MonthList entryMonthList = new MonthList(date);
			monthMap.put(key, entryMonthList);
			entryMonthList.addEntry(newEntry);
		}	
	}
	
	/**
	 * 
	 * @param cost
	 * @param description
	 * @param date
	 */
	public void addEntry(double cost, String description, BGDate date){
		Entry newEntry = new Entry(cost, description, date);
		this.addEntry(newEntry);
	}
}
