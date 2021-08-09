import java.util.ArrayList;

public class C206_CaseStudy {
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE= 3;
	private static final int OPTION_UPDATE = 4;
	private static final int OPTION_QUIT = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Currencies> currenciesList = new ArrayList <Currencies> ();
		
		currenciesList.add(new Currencies("THB", "Thailand",0.041, 24.55));
		currenciesList.add(new Currencies("MYR", "Malaysia",0.32, 3.13));

		int option = 0;
			
		while (option != OPTION_QUIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				C206_CaseStudy.viewAllCurrencies(currenciesList);
			} else if (option == OPTION_ADD) {
				Currencies currency = inputCurrencies();
				C206_CaseStudy.addCurrencies(currenciesList, currency);
			} else if (option == OPTION_DELETE) {
				C206_CaseStudy.deleteCurrencies(currenciesList);
			} else if (option == OPTION_UPDATE) {
				C206_CaseStudy.updateCurrencies(currenciesList);
			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}

	}
	private static void menu() {
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. View Currencies");
		System.out.println("2. Add Currencies");
		System.out.println("3. Delete Currencies");
		System.out.println("4. Update Currencies");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	//================================= Option 1 View =================================
	public static String retrieveAllCurrencies(ArrayList<Currencies> currenciesList) {
		String output = "";

		for (int i = 0; i < currenciesList.size(); i++) {

			output += String.format("%-20s %-20s %-10.3f %-10.3f\n", currenciesList.get(i).getCurrencyISO(),
					currenciesList.get(i).getCurrencyname(), 
					currenciesList.get(i).getBuyRate(),currenciesList.get(i).getSellRate());
		}
		return output;
	}
	public static void viewAllCurrencies(ArrayList<Currencies> currenciesList) {
		C206_CaseStudy.setHeader("VIEW CURRENCIES LIST");
		String output = String.format("%-20s %-20s %-10s %-10s\n", "CURRENCY ISO", "CURRENCY NAME",
				"BUY RATE", "SELL RATE");
		 output += retrieveAllCurrencies(currenciesList);	
		System.out.println(output);
	}
	
	//================================= Option 2 Add =================================
	public static Currencies inputCurrencies() {
		String CurrencyISO = Helper.readString("Enter Currency ISO > ");
		String CurrencyName = Helper.readString("Enter Currency Name > ");
		double BuyRate = Helper.readDouble("Enter Buy Rate > ");
		double SellRate = Helper.readDouble("Enter Sell Rate > ");
		
		Currencies currency= new Currencies(CurrencyISO,CurrencyName,BuyRate,SellRate);
		
		return currency;
	}
	public static void addCurrencies(ArrayList<Currencies> currenciesList, Currencies currency) {
		String CurrencyISO = currency.getCurrencyISO();
		String CurrencyName = currency.getCurrencyname();
		double BuyRate = currency.getBuyRate();
		double SellRate = currency.getSellRate();
		
		if (CurrencyISO.isEmpty() | CurrencyName.isEmpty() | BuyRate == 0 | SellRate == 0) {
			System.out.println("Please fill in all the details for currency");
		} else {
			currenciesList.add(currency);
			System.out.println("Currency added");

		}
	}
	
	//================================= Option 3 Delete =================================
	public static void deleteCurrencies(ArrayList<Currencies> currenciesList) {
		C206_CaseStudy.viewAllCurrencies(currenciesList);
		String CurrencyISO = Helper.readString("Enter Currency ISO to delete > ");
		Boolean isDeleted = dodeleteCurrencies(currenciesList, CurrencyISO);
		
		if (isDeleted == false) {
			System.out.println("Currency Not Deleted");
		} else {
			System.out.println("Currency " + CurrencyISO + " deleted");
		}
	}
	public static boolean dodeleteCurrencies(ArrayList<Currencies> currenciesList,String ISO) {
		boolean isDelete = false;

		for (int i = 0; i < currenciesList.size(); i++) {
			String CurrencyISO = currenciesList.get(i).getCurrencyISO();
			if (ISO.equals(CurrencyISO)) {
				currenciesList.remove(i);
				isDelete = true;
			} 
		}
		return isDelete;
	}
	
	//================================= Option 4 Update =================================
	public static void updateCurrencies(ArrayList<Currencies> currenciesList) {
		C206_CaseStudy.viewAllCurrencies(currenciesList);
		String CurrencyISO = Helper.readString("Enter Currency ISO to update > ");
		Boolean isUpdated = doupdateCurrencies(currenciesList, CurrencyISO);
		if (isUpdated == false) {
			System.out.println("Currency Not Updated");
		} else {
			System.out.println("Currency " + CurrencyISO + " Updated");
		}
	}
	public static boolean doupdateCurrencies(ArrayList<Currencies> currenciesList,String ISO) {
		boolean isUpdate = false;
		double updateBuyRate = 0.0;
		double updateSellRate = 0.0;
		char doUpdateBuyRate = Helper.readChar("Do you want to update Buy Rate for " + ISO + " > ");
		if (doUpdateBuyRate == 'Y' | doUpdateBuyRate == 'y') {
			updateBuyRate = Helper.readDouble("Enter Updated Buy rate for " + ISO + " > ");
			for (int i = 0; i < currenciesList.size(); i++) {
				String CurrencyISO  = currenciesList.get(i).getCurrencyISO();
				if (ISO.equals(CurrencyISO)) {
					 currenciesList.get(i).setBuyRate(updateBuyRate);
					 isUpdate = true;
				} 
			}
		}
		char doUpdateSellRate = Helper.readChar("Do you want to update Sell Rate for " + ISO + " > ");
		if (doUpdateSellRate == 'Y' | doUpdateSellRate == 'y') {
			updateSellRate = Helper.readDouble("Enter Updated Sell rate for " + ISO + " > ");
			for (int i = 0; i < currenciesList.size(); i++) {
				String CurrencyISO = currenciesList.get(i).getCurrencyISO();
				if (ISO.equals(CurrencyISO)) {
					 currenciesList.get(i).setSellRate(updateSellRate);
					 isUpdate = true;
				} 
			}
		}
		return isUpdate;
	}
}

