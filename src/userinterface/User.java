package userinterface;
import EntryList.Entry;
import budgetgadget.BGDate;
import java.io.*;
import java.util.*;

//Last modified 9/7/2016 6:00pm
//moved save file methods to this class

//created 9/1/2016 10:30 pm
//a solution to saving data on hard drive
//class AllEntries couldn't implement Serializable
//so this class containing a instance of AllEntries was created


//*Flaws
//displaying entries method is a bit redundant

//*TO DO
// DONE- add displaying methods
// DONE - hard drive storing method
// DONE read link: http://www.javacoffeebreak.com/text-adventure/tutorial3/tutorial3b.html

public class User implements Serializable
{
    private String userName;
    private Map<Integer, Map> entryLog = new TreeMap<>();
    private BGDate creationDate;
    private BGDate currentDate;
    private double budget;
   
    /**
     * Basic constructor
     * @param newUserName
     * @param newBudget 
     */
    public User(String newUserName, double newBudget){
        userName = newUserName;
        budget = newBudget;
    }
    
    public void addEntry(double cost, String description){
        currentDate = new BGDate();
        if(entryLog.containsKey(currentDate.year)){
            Map<Integer, Map> currentYearMap = entryLog.get(currentDate.year);
            
            if(currentYearMap.containsKey(currentDate.month)){
                Map<Integer, Map> currentMonthMap = currentYearMap.get(currentDate.month);
                
                if(currentMonthMap.containsKey(currentDate.date)){
                    Map<Integer, Set> currentDateMap = currentMonthMap.get(currentDate.date);
                }
            }
        }else{
            Map<Integer, Map> monthlyMap = new TreeMap<>();
            Map<Integer, Set> dailyMap = new TreeMap<>();
            Set<Entry> entrySet = new TreeSet<>();
            entrySet.add(new Entry(cost, description, currentDate));
            dailyMap.put(currentDate.date, entrySet);
            monthlyMap.put(currentDate.month, entryLog);
            entryLog.put(currentDate.year, monthlyMap);
        }
    }
    
    /**
     * Used to save user's record on the hard drive
     * @param obj 
     * @param filename
     * @return true or false depending if there is an error
     */
    public static boolean saveData(User obj, String filename){
        try
        {
            FileOutputStream out = new FileOutputStream(filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(out);
            objectOut.writeObject(obj);
            objectOut.close();
            System.out.println("Data saved");
            return true;
        }
        catch(Exception e)
        {
            System.out.println("Error: data saving");
            return false;
        }
    }
    /**
     * Used to read saved data from hard drive returns a User obj with the saved data
     * @param filename
     * @return User obj
     */
    public static User loadData(String filename){
        try
        {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream objectIn = new ObjectInputStream(fin);
            User loaded_user = (User) objectIn.readObject();
            return loaded_user;
        }
        catch(Exception e)
        {
            System.out.println("Error while reading data");
            return null;
        }
    }
}
