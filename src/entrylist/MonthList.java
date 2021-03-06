package entrylist;
import java.util.*;

import budgetgadget.BGDate;

@SuppressWarnings("serial")
public class MonthList extends Entry{
	private final Map<Integer, EntryList> entryMap;
	
	MonthList(BGDate newDate) throws RuntimeException{
        super(0, "Entry list for the month of " + newDate.day, newDate);
        entryMap = new TreeMap<>();    
    }
	
	/**
	 * adds a new Entry into entry Map
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
