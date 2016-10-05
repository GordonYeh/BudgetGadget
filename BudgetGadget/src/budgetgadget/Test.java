package budgetgadget;
import java.io.*;

import java.util.Vector;

public class Test implements Serializable 
{
    private int a;
    private int[] arr = {1, 2, 3};
    private Vector vec;
    
    Test()
    {
        a = 25;
        vec = new Vector();
    }
    
    void AddToVec(String content)
    {
        vec.addElement(content);
    }

}
