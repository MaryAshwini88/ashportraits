package com.ash.portraits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class demo {
  
  
    public static void main(String[] args) {
      
//      Comparator<Employee> col = new Comparator<Employee>() {
//        public int compare (Employee i, Employee j) {
//          if (i.age > j.age) {
//            return 1;
//          } else {
//            return -1;
//          }
//        }
//      };

      
    List<Employee> nums = new ArrayList<Employee>();
    nums.add(new Employee(20,"Ashwini", 40000,"IT"));
    nums.add(new Employee(35,"ren", 66677,"Mech"));
    nums.add(new Employee(29,"tewa", 87787,"IT"));
    nums.add(new Employee(28,"jai", 434546,"Mech"));
    nums.add(new Employee(40,"yeshwi", 56775, "CS"));
    
   Optional<Employee> old = nums.stream().max(Comparator.comparingInt(p-> p.age));
   
   Map<String, List<Employee>> dep = nums.stream().collect(Collectors.groupingBy(a-> a.dep));
    
    Comparator<Employee> col = (i,j) -> i.name.length() > j.name.length()? 1: -1;
    Collections.sort(nums,col);
    
    List<Employee> t = nums.stream().filter(e-> e.salary>45555).collect(Collectors.toList());
    
    List<Integer> numbers = Arrays.asList(2, 4, 7, 9, 10, 13, 16);
    Optional<Integer> sum  = numbers.stream().reduce((i, j)-> i+j );
    Optional<Integer> e  = numbers.stream().max(Comparator.naturalOrder());
    Optional<Integer> u  = numbers.stream().sorted(Comparator.reverseOrder()).findFirst();
    Optional<Integer> u8  = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
    

    List<String> words = Arrays.asList("java", "stream", "api", "filter", "map", "collect");
    List<String> s = words.stream().filter(a -> a.length()>4).collect(Collectors.toList());
    
    List<String> items = Arrays.asList("pen", "notebook", "bottle", "marker");
    
    Optional<String> l = items.stream().sorted((i,j) -> j.length()-i.length()).findFirst();
    Optional<String> longest = items.stream()
            .max(Comparator.comparing(String::length));
    List<String> names = Arrays.asList("alice", "bob", "anna", "brian", "alex");
    
    Map<Character,List<String>> map = names.stream().collect(Collectors.groupingBy(a-> a.charAt(0)));
   List<String> mu8 = names.stream().filter(b -> (b.length()%2 == 0)).collect(Collectors.toList());
    
    List<List<String>> nested = Arrays.asList(
    	    Arrays.asList("a", "b"),
    	    Arrays.asList("b", "c", "d"),
    	    Arrays.asList("a", "e")
    	);
    List<String> flat = nested.stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());
    
    List<String> name2s = Arrays.asList("Alice", "Bob", "Anna", "Alex", "David");
    List<String> words5 = Arrays.asList("apple", "bat", "banana", "car", "dog", "elephant");
    Map<Integer, List<String>> ma3p = words5.stream().collect(Collectors.groupingBy(a-> a.length()));
    
    String str = name2s.stream().collect(Collectors.joining(" "));
    
    Map<Character,List<String>> map2 = name2s.stream().collect(Collectors.groupingBy(a-> a.charAt(0)));
    
    for (Character i : map2.keySet()) {
    	  System.out.println("key: " + i + " value: " + map2.get(i).size());
    	}
    List<List<Integer>> nested2 = Arrays.asList(
    	    Arrays.asList(5, 2),
    	    Arrays.asList(9, 1, 7),
    	    Arrays.asList(3)
    	);
    
    List<Integer> iti = nested2.stream().flatMap(Collection::stream).distinct().sorted().collect(Collectors.toList());
    
    List<String> word5s = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
    Map<String, Long> rees= word5s.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
   String r = "Ash";
   r= "asss";
    System.out.println(r);
    
  }
}