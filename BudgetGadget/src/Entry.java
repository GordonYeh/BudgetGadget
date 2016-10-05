package EntryList;
import budgetgadget.BGDate;
import java.io.*;

@SuppressWarnings("serial")
public class Entry implements Serializable{
    private double cost;
    private String description;
    private BGDate entryDate;
    
    public Entry(double newCost, String newDescription, BGDate newDate){
        setCost(newCost);
        setDescription(newDescription);
        setEntryDate(newDate);
    }
    
    public void setEntryDate(BGDate newDate){
        entryDate = newDate;
    }
    
    public void setDescription(String newDescription){
        description = newDescription;
    }
    
    public void setCost(double newCost){
        cost = newCost;
    }
    
    public double getCost(){
        return cost;
    }
    
    public BGDate getDate(){
    	return entryDate;
    }
    
    public void increaseCost(double increment){
        cost += increment;
    }
    
    public void decreaseCost(double decrement){
        cost -= decrement;
    }
    
    public void dispInfo(){
        System.out.printf("Price: %f\nDescription: %s\n Added on: %s\n", cost, description, entryDate);
    } 
}
