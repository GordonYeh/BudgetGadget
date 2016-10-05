package entrylist;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import budgetgadget.BGDate;

public class EntryTest {
	
	@Test
	public void monthListTest(){
		BGDate today = new BGDate();
		
		MonthList mList = new MonthList(today);
		
		mList.addEntry(20.0, "d1", today);
		Entry n2 = new Entry(25.0, "d2", today);
		mList.addEntry(n2);
		
		assertTrue("1) the total cost doesn't add up", mList.getCost() == 45.0);
		
		List<Entry> dList = mList.getEntries(today);
		assertTrue("get entry error", dList.get(1) == n2);

		BGDate another = new BGDate(2016, 10, 30);
		
		Entry n3 = new Entry(54.5, "d3", another);
		Entry n4 = new Entry(-26.1, "d4", another);
		Entry n5 = new Entry(10023.2, "d5", another);
		
		mList.addEntry(n3);
		mList.addEntry(n4);
		mList.addEntry(n5);
		
		assertTrue("2) the total cost doesn't add up", mList.getCost() == 45.0 + 54.5 - 26.1 + 10023.2);
		
		dList = mList.getEntries(another);
		assertTrue("get entry error", dList.get(1) == n4);
	}
	
}
