package EntryList;
import java.util.*;

import budgetgadget.BGDate;

public class MonthList extends Entry{
	Map<Integer, EntryList> entryMap;
	
	MonthList(String newDescription, BGDate newDate){
        super(0, newDescription, newDate);
        entryMap = new TreeMap<>();   
    }
	
	public void addEntry(double newCost, String newDescription, BGDate newDate){
		Entry newEntry = new Entry(newCost, newDescription, newDate);
		this.addEntry(newEntry);
	}
	
	public void addEntry(Entry newEntry){
		BGDate entryDate = newEntry.getDate();
		int key = entryDate.day;
		
		if(entryMap.containsKey(key)){
			entryMap.get(key).addEntry(newEntry);
		}
		else{
			String listDescription = "Entry list for a day";
			entryMap.put(key, new EntryList(listDescription, entryDate));
			entryMap.get(key).addEntry(newEntry);
		}
		
		super.increaseCost(newEntry.getCost());
	}
	
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
