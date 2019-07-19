package utilities;

public class testClas2  extends testClass{
	
	public static  void hell(){ 
		System.out.println("in child");
	}
	
	
	public static void main(String args[]) {
		testClas2 obj = new testClas2();
		obj.hell();
		/*InterfaceX intr = (int x) -> System.out.println(2*x);
		intr.display(4);*/
	}

}
