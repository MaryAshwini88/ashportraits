package com.ash.portraits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ashh {

	public static void main(String[] args) {
	    List<String> cities = new ArrayList<>();
	    cities.add("Delhi");
	    cities.add("Mumbai");
	    cities.add("Goa");
	    cities.add("Pune");
//	    
//	    Consumer<String> printConsumer= city-> System.out.println(city);    
//	    cities.forEach(printConsumer);


//	    Predicate<String> filterCity = city -> city.equals("Mumbai");
//	    cities.stream().filter(filterCity).forEach(System.out::println);
	    
	    Function<String, Character> getFirstCharFunction = city -> {
	        return city.charAt(0);
	    };
	    cities.stream().map(getFirstCharFunction)
	                   .forEach(System.out::println);
	    



	        Supplier<String[]> citySupplier = () -> {
	            return new String[]{"Mumbai", "Delhi", "Goa", "Pune"};
	        };
	        Arrays.asList(citySupplier.get()).forEach(System.out::println);


	}

}
