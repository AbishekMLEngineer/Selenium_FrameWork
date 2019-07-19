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

public class WordsCount {
	
	int arr[] = new int[]{1, 5, 7, -1, 5} ;
	//Means to check the sum of 2 no.s in an array is equal to the desired sum and to count the occurence of the pairs
	public int getPairCOuntInArray(int n , int sum){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++){
			if(!map.containsKey(arr[i])){
				map.put(arr[i], 0);
			}
			else{
				map.put(arr[i], map.get(arr[i] +1));
			}
		}
		int twiceCount =0;
		for (int i=0; i<n; i++) 
        { 
            if(map.get(sum-arr[i]) != null) 
            	twiceCount += map.get(sum-arr[i]); 
  
            // if (arr[i], arr[i]) pair satisfies the condition, 
            // then we need to ensure that the count is 
            // decreased by one such that the (arr[i], arr[i]) 
            // pair is not considered 
            if (sum-arr[i] == arr[i]) 
            	twiceCount--; 
        } 
  
        // return the half of twice_count 
        return twiceCount/2;
		
	}
	
	public void countCharacterWordsInString(String str){
		HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
		char[] strArray = str.toCharArray();
		for(char c :strArray){
			if(charCount.containsKey(c)){
				charCount.put(c, charCount.get(c)+1);
			}
			else{
				charCount.put(c, 1);
			}
		}
		System.out.println(charCount);
		//Another way to write hashMap
		for(Map.Entry<Character, Integer> entry :charCount.entrySet() ){
			System.out.println(entry);
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
	
	
	public void countWordsInAFile(File obj){
		
	}
	
	/**
	 * in Java, the \s is a character class to detect space including tabs, since \ needs to be escaped in Java, it becomes \\s and because there could be multiple spaces between words we made this regular expression greedy by adding +, hence \\s+ will find one more space and split the String accordingly
	 */
	
	public static int countWordsUsingSplit(String input) {
	    if (input == null || input.isEmpty()) {
	      return 0;
	    }

	    String[] words = input.split("\\s+");
	    return words.length;
	  }
	
	
	//EasyWay
	public Integer countWordsInString1(String str){
		str =str.trim();
		String[] words = str.split(str);
		return words.length;
 	}
	
	public void countWordsInString2(String str){
		
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
	
	
	
	
	@Test
	public void try1(){
		countCharacterWordsInString("I am basajda   edhbjb  adsbdhsbdj jfdjdvndfheufhw");
	}
}

	