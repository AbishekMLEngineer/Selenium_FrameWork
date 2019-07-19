package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.file.FileReader;

public class Trial {
	void productArray(int arr[], int n)  
    { 
        int i, temp = 1; 
          
        /* Allocate memory for the product array */
        int prod[] = new int[n]; 
  
        /* Initialize the product array as 1 */
        for(int j=0;j<n;j++) 
            prod[j]=1; 
  
        /* In this loop, temp variable contains product of 
           elements on left side excluding arr[i] */
        for (i = 0; i < n; i++)  
        { 
            prod[i] = temp; 
            temp *= arr[i]; 
        } 
  
        /* Initialize temp to 1 for product on right side */
        temp = 1; 
  
        /* In this loop, temp variable contains product of 
           elements on right side excluding arr[i] */
        for (i = n - 1; i >= 0; i--)  
        { 
            prod[i] *= temp; 
            temp *= arr[i]; 
        } 
  
        /* print the constructed prod array */
        for (i = 0; i < n; i++) 
            System.out.print(prod[i] + " "); 
  
        return; 
    }
	
	
	@Test
	public void test12(){
//		Trial pa = new Trial(); 
		int arr[] = {10, 3, 5, 6, 2}; 
        int n = arr.length; 
        System.out.println("The product array is : "+n); 
      //  pa.Trial(arr, n);
		
		int left[] = new int[n]; 
        int right[] = new int[n]; 
        int prod[] = new int[n]; 
  
        int i, j; 
  
        /* Left most element of left array is always 1 */
        left[0] = 1; 
  
        /* Rightmost most element of right array is always 1 */
        right[n - 1] = 1; 
  
        /* Construct the left array */
        for (i = 1; i < n; i++) 
            left[i] = arr[i - 1] * left[i - 1]; 
  
        /* Construct the right array */
        for (j = n - 2; j >= 0; j--) 
            right[j] = arr[j + 1] * right[j + 1]; 
  
        /* Construct the product array using 
           left[] and right[] */
        for (i = 0; i < n; i++) 
            prod[i] = left[i] * right[i]; 
  
        /* print the constructed prod array */
        for (i = 0; i < n; i++) 
            System.out.print(prod[i] + " "); 

	}
	
	public static int count_Words(String str)
    {
       int count = 0;
        if (!(" ".equals(str.substring(0, 1))) || !(" ".equals(str.substring(str.length() - 1))))
        {
            for (int i = 0; i < str.length(); i++)
            {
                if (str.charAt(i) == ' ')
                {
                    count++;
                }
            }
            count = count + 1; 
        }
        return count; // returns 0 if string starts or ends with space " ".
    }
	
	public void countEachWords(String fileNameWithPath , Map<String, Integer> words)throws FileNotFoundException{
		Scanner file = new Scanner(new File(fileNameWithPath));
		while(file.hasNext()){
			String word = file.next();
			Integer count = words.get(word);
			if(count != null){
				count++;
			}
			else {
				count =1;
				words.put(word, count+1);
				
			}
			
		}
	}
	
	
	public void countWordInAFile() throws Exception{
		Path path = Paths.get(System.getProperty("user.dir")).resolve("article.txt");
		BufferedReader reader = new BufferedReader(new java.io.FileReader(path.toFile()));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String line = reader.readLine();
		while(line !=null){
			System.out.println("this is "+line);
			
			if(!line.trim().equals("")){
				String [] words = line.split(" ");
				for(String word :words){
					if(word == null || word.trim().equals("")){
						continue;
					}
					String processed = word.toLowerCase();
					if(map.containsKey(processed)){
						map.put(processed, map.get(processed)+1);
					}
					else{
						map.put(processed, 1);
					}
				}
			}
			line = reader.readLine();
		}
		System.out.println(map);
		/**
		 * now here we will print the most recurring word 
		 */
		int mostFrequentlyUSed =0;
		String theWord =null;
		
		for(String word :map.keySet()){
			Integer theVal = map.get(word);
			if(theVal>mostFrequentlyUSed){
				theVal = mostFrequentlyUSed;
				theWord = word;
			}
			
		}
	}

}
/**
String sd = "adscddjbfvd";
System.out.println(sd.substring(sd.length()-1));

System.out.println(sd.length());
Boolean b =!(" ".equals(sd.substring(0, 1)));
if(b== true){
	System.out.println("yes");
}
int x =count_Words("I am ads  fdf   dffdfd   fdfd");
System.out.println("this is    "+x);**/