package oo_patterns.template_method.java8;

import java.util.Date;
import java.util.function.Function;

public class Client {

	public static void main(String[] args) {
		ExpediaDelegate expedia = new ExpediaDelegate();
		Function<SearchParameters, Boolean> searchFunction = 
				FlightSearch.makeSearchAndBookCheapestFlight(expedia::searchFlights, expedia::bookFlight);
		searchFunction.apply(new SearchParameters("RIO", "HCL", new Date()));

	}

}
