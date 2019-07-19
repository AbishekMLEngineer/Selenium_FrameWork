package utilities;

//@FunctionalInterface
public interface InterfaceX {
public void display(int x);
	
	public default void test() {
		System.out.println("default method");
		}
	public default void test2() {
		System.out.println("default method");
		}
	
	public static void hello() {
		System.out.println("static method");
		}
	public default void test4() {
		System.out.println("default method");
		}
	

}
