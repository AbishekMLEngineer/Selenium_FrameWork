package usageOfLambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseJava7solution {
	public static void main(String args[]){
		List<Person> people = Arrays.asList(
				new Person ("Sheetal ", "Kachroo",37),
				new Person ("Myra ", "Gural",1),
				new Person ("Abishek ", "Kachroo",27)
				);
		//sorted the list by last name
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				o1.getlastName().compareTo(o2.getlastName());
				return 0;
			}
		});
		//print the elements after comparator by creating the method
		printAll(people);
		
		printNameWhichStartsWithC(people);
		//prints with condition where lastname starts with K
		printConditionally(people, new Condition(){
			@Override
			public boolean TestPerson(Person p) {
				// TODO Auto-generated method stub
				return p.getlastName().startsWith("K");
			}
		});
		
		//prints the condition where age is greater than 20
		printConditionally(people,new Condition(){
			@Override
			public boolean TestPerson(Person p) {
				return p.getage()>20;
			}
		}
				);
	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for(Person p: people){
			if(condition.TestPerson(p)){
				System.out.println(p.age);
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

interface Condition{
	boolean TestPerson(Person p);
}