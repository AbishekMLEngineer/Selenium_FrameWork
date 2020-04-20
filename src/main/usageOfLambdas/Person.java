package usageOfLambdas;

public class Person {
	public String  firstName ;
	public String  lastName ;
	public int age;
	
	public Person(String firstName, String lastName, int age){
		this.firstName =firstName;
		this.lastName =lastName;
		this.age = age;
	}
	
	public void setFirstName (String firstName){
		this.firstName = firstName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setlastName (String lastName){
		this.lastName = lastName;
	}
	
	public String getlastName(){
		return lastName;
	}
	
	public void setage (int age){
		this.age = age;
	}
	
	public int  getage(){
		return age ;
	}
	
	public static void main(String args[]){
		
	}
	@Override
	public String toString(){
		return "Person[firstName"+firstName+"LastName "+lastName+"Age is "+age;
	}

}
