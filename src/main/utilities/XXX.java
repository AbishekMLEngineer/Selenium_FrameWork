package utilities;

import java.util.Scanner;

import org.testng.annotations.Test;

public class XXX {

//	@Test
	public void rotate(){
		int arr[] = {1,23,344,44,5,6,7};
		int temp;
		for(int i =0;i<2;i++){
			for(int j=arr.length-1;j>0;j--){
				temp = arr[j];
				arr[j]= arr[j-1];
				arr[j-1]= temp;
			}
		}
		
		for(int i = 0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		
		}
 	}
	@Test
	public void prime(){
		String s1 ="ac";
		String s2 ="ac";
		s1= "cs";
		System.out.println(s1);
		System.out.println(s2);
		Scanner s = new Scanner(System.in);
        int number = s.nextInt();  
        int arr[]= new int[number];
        // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");
        
        String y=arrayOfNumbers(number);
        System.out.println("No. is + "+ y);
        /*if(y!=0){
            System.out.println("No. is +"+ y);        	
        }*/
        
        

	}
	public int booleanPrime(int no){
		for(int i=2;i<no;i++){
			if(no%i==0){
				return 0;
			}
		}
		return no;
	}
	
	public String arrayOfNumbers(int arrNo){
		String str ="";
		for(int i=2;i<arrNo;i++){
			int x=booleanPrime(i);
			if(x!=0){
				str =str+" "+x+" ";
			}
		}
		
		return str;
	}


}
