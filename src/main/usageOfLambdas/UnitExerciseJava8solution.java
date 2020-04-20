package usageOfLambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UnitExerciseJava8solution {
	public static void main(String args[]){
		List<Person> people = Arrays.asList(
				new Person ("Sheetal ", "Kachroo",37),
				new Person ("Myra ", "Gural",1),
				new Person ("Abishek ", "Kachroo",27)
				);
		//sorted the list by last name
		Collections.sort(people, (Person p1, Person p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
		
		//print the elements after comparator by creating the method
		printAll(people);
		
		printNameWhichStartsWithC(people);
		//prints with condition where lastname starts with K
		printConditionally(people, p -> p.getlastName().startsWith("K"));
		
		//prints the condition where age is greater than 20
		printConditionally(people,p -> p.getage()>20);
	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for(Person p: people){
			if(condition.TestPerson(p)){
				System.out.println(p);
			}
		}
	}
	private static void printNameWhichStartsWithC(List<Person> people) {
		for(Person p :people){
			if(p.getFirstName().startsWith("A")){
				System.out.println(p);
				System.out.println(p.getFirstName().startsWith("A"));
			}
		}
	}
	private static void printAll(List<Person> people) {
		for(Person p :people){
			System.out.println(p);
		}
	}
}

