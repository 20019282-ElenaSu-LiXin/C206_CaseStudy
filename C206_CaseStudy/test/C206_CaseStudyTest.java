import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Currencies currency1;
	private Currencies currency2;
	
	private ArrayList<Currencies> currenciesList;
	
	
	@Before
	public void setUp() throws Exception {
		currency1 = new Currencies("THB", "Thailand",0.041, 24.55);
		currency2 = new Currencies("MYR", "Malaysia",0.32, 3.13);
		currenciesList = new ArrayList <Currencies> ();
		
	}

	@After
	public void tearDown() throws Exception {
		currency1 = null;
		currency2 = null;
		currenciesList = null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void retrieveAllCurrenciesTest() {
		// Test if Currencies list is not null but empty -boundary
		assertNotNull("Test if there is valid Currencies arraylist to retrieve item", currenciesList);
		
		//test if the list of Currencies retrieved from the C206_CaseStudy is empty - boundary
		String allCurrencies= C206_CaseStudy.retrieveAllCurrencies(currenciesList);
		String testOutput = "";
		assertEquals("Check that ViewAllCurrencieslist", testOutput, allCurrencies);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCurrencies(currenciesList, currency1);
		C206_CaseStudy.addCurrencies(currenciesList, currency2);
		assertEquals("Test that Currencies arraylist size is 2", 2, currenciesList.size());
		
		//test if the expected output string same as the list of Currencies retrieved from the C206_CaseStudy	
		allCurrencies= C206_CaseStudy.retrieveAllCurrencies(currenciesList);
		testOutput = String.format("%-20s %-20s %-10s %-10s\n", "THB", "Thailand","0.041", "24.550");
		testOutput +=  String.format("%-20s %-20s %-10s %-10s\n", "MYR", "Malaysia","0.320", "3.130");
	
		assertEquals("Test that ViewAllCurrencieslist", testOutput, allCurrencies);
	}
	@Test
	public void addCurrenciesTest() {
		// Currencies list is not null, so that can add a new Currency - boundary
		assertNotNull("Test if there is valid Currencies arraylist to add to", currenciesList);
		
		//Given an empty list, after adding 1 Currency, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addCurrencies(currenciesList, currency1);		
		assertEquals("Test that Currencies arraylist size is 1", 1, currenciesList.size());
		assertSame("Test that Currencies is added", currency1, currenciesList.get(0));
		
		//Add another Currency. test The size of the list is 2? - normal
		//The Currency just added is as same as the second item of the list
		C206_CaseStudy.addCurrencies(currenciesList, currency2);
		assertEquals("Test that Currencies arraylist size is 2", 2, currenciesList.size());
		assertSame("Test that Currencies is added", currency2, currenciesList.get(1));
		
		//error
		// Test that if Currency ISO and Currency Name is empty, currency cannot be added
		Currencies currency3 = new Currencies("", "",0.74, 1.35);
		C206_CaseStudy.addCurrencies(currenciesList, currency3);
		assertEquals("Test that Currencies arraylist size is 2", 2, currenciesList.size());
	}
	@Test
	public void dodeleteCurrenciesTest() {
		// Currencies list is not null, so that can add a new Currency - boundary
		assertNotNull("Test if there is valid Currencies arraylist to add to", currenciesList);
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCurrencies(currenciesList, currency1);
		C206_CaseStudy.addCurrencies(currenciesList, currency2);
		assertEquals("Test that Currencies arraylist size is 2", 2, currenciesList.size());
		
		// Test that Currencies ISO SGD is deleted
		Boolean isDeleted = C206_CaseStudy.dodeleteCurrencies(currenciesList, "THB");
		// Test that after deleting 1 Currency, the size of the list is 1 - normal
		assertEquals("Test that Currencies arraylist size is 1", 1, currenciesList.size());	
		// Test that Currencies ISO MYR is deleted
		isDeleted = C206_CaseStudy.dodeleteCurrencies(currenciesList, "MYR");
		// Test that after deleting 1 Currency, the size of the list is 0 - normal
		assertEquals("Test that Currencies arraylist size is 0", 0, currenciesList.size());
		
		//error
		// Test that non-existing Currency is not deleted
		isDeleted = C206_CaseStudy.dodeleteCurrencies(currenciesList, "USD");
		assertFalse("Test if non-existing Currency USD is returned - false?", isDeleted);
	}
	@Test 
	public void doupdateCurrenciesTest() {
		// Currencies list is not null, so that can add a new Currency - boundary
		assertNotNull("Test if there is valid Currencies arraylist to add to", currenciesList);
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCurrencies(currenciesList, currency1);
		C206_CaseStudy.addCurrencies(currenciesList, currency2);
		assertEquals("Test that Currencies arraylist size is 2", 2, currenciesList.size());
		// Test that Currencies ISO THB Buy Rate and Sell Rate is updated.
		Boolean isUpdated = C206_CaseStudy.doupdateCurrencies(currenciesList, "THB");
		currency1.setBuyRate(0.05);
		currency1.setSellRate(25.00);
		assertTrue("Test if Currency THB is updated - true?", isUpdated);
		//Test that Currencies ISO MYR Buy Rate and Sell Rate is not updated.
		isUpdated = C206_CaseStudy.doupdateCurrencies(currenciesList, "MYR");
		assertFalse("Test if Currency ISO MYR is not updated - false?", isUpdated);
		
		//test if the expected output string same as the list of Currencies retrieved from the C206_CaseStudy	
		String allCurrencies= C206_CaseStudy.retrieveAllCurrencies(currenciesList);
		String testOutput = "";
		testOutput = String.format("%-20s %-20s %-10s %-10s\n", "THB", "Thailand","0.050", "25.000");
		testOutput +=  String.format("%-20s %-20s %-10s %-10s\n", "MYR", "Malaysia","0.320", "3.130");
	
		assertEquals("Test that ViewAllCurrencieslist", testOutput, allCurrencies);
	}
}
