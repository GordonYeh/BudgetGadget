package budgetgadget;
import userinterface.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

//created 8/31/2016

// 9/1/2016 12:58 pm
// the entries are working 
// tested storing entries and displaying stored entries

//9/6/2016
//tested the get methods of EntryList
//works!!!

//TO DO
//XXXOrangize the class files into different packages
//XXXCreate a date class, BGDate
// * cleaned up tting current date from computer
// * crsome methods in the EntryList via passing BGDate
//XXXstoring data on hard drive
//?? work on Catagory class
//XXXreading stored data from hard drive
//research buttons and JFrame
//interfacing

public class BudgetGadget 
{
    private static String save_file = "save.dat";
    public static void main(String[] args) 
    {
        /* interface test*/
        //BGWindow mainWindow = new BGWindow();
        /* save file test 
        BGDate today = new BGDate();
        //User user1 = new User("gordon");
        User user1 = User.loadData(save_file);
        System.out.println(user1);
        user1.dispEntry(today, 0);
        //user1.addEntry(43.2);
        //user1.addEntry(23.1);
        //user1.addEntry(75.1);
        //if(!User.saveData(user1, save_file))
          // System.out.println("error"); */
       Map<Integer, String> map2 = new TreeMap<>();
       map2.put(1, "Gordon");
       map2.put(2, "Iris");
       Map<Integer, Map> map1 = new TreeMap<>();
       map1.put(1, map2);
       
       Map<Integer, String> copyMap2 = map2;
       copyMap2.put(1,"bob");
       
       System.out.println(map2.get(1));
              
       
        
        /* entries returning methods test
        User user = new User("Gordon", 250);
        BGDate today = new BGDate();
        BGDate day = new BGDate(2017, 12, 24);
        user.addEntry(23.4);
        user.addEntry(25.3, day, "nothing much");
        YearlyEntry year_e = user.getYearlyEntry(today);
        MonthlyEntry month_e = user.getMonthlyEntry(today);
        DailyEntry day_e = user.getDailyEntry(today);
        
        year_e.dispEntry(9, 6, 0);
        month_e.dispEntry(6, 0);
        day_e.dispEntry(0);*/
    }

    
    

    
    /*
    public static void save()
    {
        File save_file = new File("save.txt");
        if(!save_file.exists())
        {
            final Formatter new_file;
            try
            {
                new_file = new Formatter("save.txt");
            }
            catch(Exception e)
            {
                System.out.println("error");
            }
            System.out.println("new file created");
        }
        else
            System.out.println("file exist");
    }
    */
}
