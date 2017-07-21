package oo_patterns.template_method.java8;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;



public abstract class FlightSearch {

	public static enum FlightSearchProvider 
		{ 
		EXPEDIA, 
		SKYSCANNER 
		};
	
	public static Function<SearchParameters, Boolean> makeSearchAndBookCheapestFlight(FlightSearchProvider provider) {
		return null;
	}
	
	public static Function<SearchParameters, Boolean> 
		makeSearchAndBookCheapestFlight(Function<SearchParameters,List<SearchResult> > searchFunction,
				Function<SearchResult,Boolean> bookFunction) {
		return (sp) -> {
			List<SearchResult> searchResults = searchFunction.apply(sp);
			double cheapestPrice = Double.MAX_VALUE;
			SearchResult cheapestFlight = null;
			
			for (SearchResult result: searchResults) {
				if (result.getPrice()<cheapestPrice) {
					cheapestFlight = result;
					cheapestPrice = result.getPrice();
				}
			}
			return bookFunction.apply(cheapestFlight);

		};
		
	}
	
	
}
