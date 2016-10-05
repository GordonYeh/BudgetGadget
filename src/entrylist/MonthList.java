package entrylist;
import java.util.*;

import budgetgadget.BGDate;

@SuppressWarnings("serial")
public class MonthList extends Entry{
	public static void main(String args[]){
		BGDate today = new BGDate();
		BGDate d1 = new BGDate(2016, 9, 1);
		BGDate d2 = new BGDate(2016, 9, 2);
		BGDate d3 = new BGDate(2016, 9, 3);
		try{
			BGDate d4 = new BGDate(2300, 4, 30);
		} catch(Exception e){
			System.out.println("illegal date");
		}
		
		MonthList sept = new MonthList(new BGDate());
		sept.addEntry(23.1, "l1", new BGDate());
		sept.addEntry(253.1, "l2", d1);
		sept.addEntry(0.23, "l3", d1);
		sept.addEntry(-102, "l4", d3);
		
		try{
			sept.addEntry(null);
		} catch(Exception e){
			System.out.println("couldn't be added");
		}
		
		List<Entry> entries = sept.getEntries(d1);
		for(Entry i: entries){
			System.out.println(i.toString());
		}
		
		sept.removeEntry(d1.day, 0);
		
		entries = sept.getEntries(d1);
		for(Entry i: entries){
			System.out.println(i.toString());
		}
		
	}
	
	private final Map<Integer, EntryList> entryMap;
	

	MonthList(BGDate newDate) throws RuntimeException{
        super(0, "Entry list for the month " + newDate.day, newDate);
        entryMap = new TreeMap<>();    
    }
	
	/**
	 * addes a new Entry into entry Map
	 * @param newCost cost of the Entry
	 * @param newDescription of the Entry
	 * @param newDate date the entry is added
	 */
	public void addEntry(double newCost, String newDescription, BGDate newDate){
		Entry newEntry = new Entry(newCost, newDescription, newDate);
		this.addEntry(newEntry);
	}
	
	/**
	 * adds newEntry into entryMap 
	 * @param newEntry Entry to be added into entryMap
	 * @throws RuntimeException if newEntry is null
	 */
	public void addEntry(Entry newEntry) throws RuntimeException{	
		BGDate entryDate = newEntry.getDate();
		int key = entryDate.day;
		
		if(entryMap.containsKey(key)){
			entryMap.get(key).addEntry(newEntry); //will throw exception if newEntry is null
		}
		else{
			String listDescription = "Entry list for a day";
			entryMap.put(key, new EntryList(listDescription, entryDate));
			entryMap.get(key).addEntry(newEntry);
		}
		
		super.increaseCost(newEntry.getCost());
	}
	
	/**
	 * remove the entry with a specified day and index
	 * day > 0 and day < # of days in this month
	 * @param day the entry is on
	 * @param ind the index of the entry
	 * @throws RuntimeException if there is no entries on this particular day
	 */
	public void removeEntry(int day, int ind) throws RuntimeException{
		int key = day;
		if(entryMap.containsKey(key)){
			EntryList currentList = entryMap.get(key);
			currentList.removeEntry(ind);
		} else{
			throw new IllegalArgumentException();
		}
		
			
	}
	/**
	 * returns a list of all the entries added on the date
	 * @param date
	 * @return a list of all the entries on the specific day
	 * @throws IllegalArgumentException when there are no entries on this day
	 */
	public List<Entry> getEntries(BGDate date) throws IllegalArgumentException{
		int key = date.day;
		if(entryMap.containsKey(key)){
			return entryMap.get(key).getEntryList();
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public double getTotalCost(){
		return super.getCost();
	}
	
	public int getMonth(){
		return super.getDate().month;
	}
	
}
