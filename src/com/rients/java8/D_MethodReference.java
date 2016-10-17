package com.rients.java8;

import java.util.ArrayList;
import java.util.List;

/*
 * Method references help to point to methods by their names. A method reference is described using :: (double colon) symbol.
 *  A method reference can be used to point the following types of methods −

Static methods
Instance methods
Constructors using new operator (TreeSet::new)
 */
public class D_MethodReference {
	public static void main(String args[]){
	      List<String> names = new ArrayList<>();
			
	      names.add("Mahesh");
	      names.add("Suresh");
	      names.add("Ramesh");
	      names.add("Naresh");
	      names.add("Kalpesh");
			
	      //Here we have passed System.out::println method as a static method reference.
	      names.forEach(System.out::println);
	      names.forEach(D_MethodReference::print);
	   }
	
	private static void print(String var) {
		System.out.println(var);
	}
	}
