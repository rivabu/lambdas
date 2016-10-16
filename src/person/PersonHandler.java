package person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.Person;
import domain.Person.Sex;

public class PersonHandler {

	public static void main(String[] args) {
		List<Person> gezin = new ArrayList<Person>();
		gezin.add(new Person("Rients", LocalDate.of(1968, 6, 15), Sex.MALE, "rientsvanburen@gmail.com"));
		gezin.add(new Person("Suzan", LocalDate.of(1972, 12, 15), Sex.FEMALE, "suzanevers@gmail.com"));
		gezin.add(new Person("Axel", LocalDate.of(2004, 3, 23), Sex.MALE, "axelvanburen@gmail.com"));
		gezin.add(new Person("Lana", LocalDate.of(2007, 8, 23), Sex.FEMALE, "lanavanburen@gmail.com"));

		gezin
			.stream()
			.filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 8 && p.getAge() <= 25)
			.map(p -> p.getEmailAddress())
			.forEach(email -> System.out.println(email));
		
		gezin
		.parallelStream()
		.filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 8 && p.getAge() <= 25)
		.map(p -> p.getEmailAddress())
		.forEach(email -> System.out.println(email));

		double average = gezin
			    .stream()
			    .filter(p -> p.getGender() == Person.Sex.MALE)
			    .mapToInt(Person::getAge)
			    .average()
			    .getAsDouble();
		
		System.out.println("average age: " + average);
		
		new PersonHandler().givenListContainsDuplicates_whenRemovingDuplicatesWithJava8_thenCorrect();

		
	}
	
	public void givenListContainsDuplicates_whenRemovingDuplicatesWithJava8_thenCorrect() {
	    List<Integer> listWithDuplicates = Arrays.asList(1, 1, 2, 2, 3, 3);
	    List<Integer> listWithoutDuplicates = 
	      listWithDuplicates.parallelStream().distinct().collect(Collectors.toList());
	    
	    System.out.println(listWithoutDuplicates);
	}

}
