
package EntryList;
import java.util.*;

import budgetgadget.BGDate;

@SuppressWarnings("serial")
public class EntryList extends Entry{
	List<Entry> entryList;
    
    EntryList(String newDescription, BGDate newDate){
        super(0, newDescription, newDate);
        entryList = new ArrayList<>();
    }
    
    public void addEntry(double newCost, String newDescription, BGDate newDate){
    	Entry newEntry = new Entry(newCost, newDescription, newDate);
    	this.addEntry(newEntry);
    }
    
    public void addEntry(Entry newEntry){
    	entryList.add(newEntry);
    	super.increaseCost(newEntry.getCost());
    }
    
    public void removeEntry(int ind) throws IndexOutOfBoundsException{
    	entryList.remove(ind);
    }
    
    public List<Entry> getEntryList(){
    	return entryList;
    }
    
    public double getTotalCost(){
    	return super.getCost();
    }
    
    public int getDay(){
    	return super.getDate().day;
    }
    
    public String toString(){
    	return super.toString();
    }
}
