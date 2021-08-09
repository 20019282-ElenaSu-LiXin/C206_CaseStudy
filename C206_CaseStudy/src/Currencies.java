
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20032049, 31 Jul 2021 2:27:59 pm
 */

public class Currencies {
	
	private String CurrencyISO;
	private String Currencyname;
	private double BuyRate;
	private double SellRate;

	public Currencies(String currencyISO, String currencyname, double buyRate, double sellRate) {
		CurrencyISO = currencyISO;
		Currencyname = currencyname;
		BuyRate = buyRate;
		SellRate = sellRate;
	}

	public String getCurrencyISO() {
		return CurrencyISO;
	}

	public String getCurrencyname() {
		return Currencyname;
	}

	public double getBuyRate() {
		return BuyRate;
	}

	public double getSellRate() {
		return SellRate;
	}

	public void setBuyRate(double buyRate) {
		BuyRate = buyRate;
	}
	public void setSellRate(double sellRate) {
		SellRate = sellRate;
	}
	
	

}
