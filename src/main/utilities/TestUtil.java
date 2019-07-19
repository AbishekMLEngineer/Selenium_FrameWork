package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	//*** this utility is used to find the broken links 
	public ArrayList<WebElement> findBrokenLink(String aTag, String hrefTag) throws MalformedURLException, IOException{
		List<WebElement> allLinks = driver.findElements(By.xpath(aTag));
		allLinks.addAll(driver.findElements(By.xpath(hrefTag)));
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		for(int i=0;i<allLinks.size();i++){
			if(allLinks.get(i).getAttribute(hrefTag)!=null && (! allLinks.get(i).getAttribute(aTag).contains("javaScript"))){
				activeLinks.add(allLinks.get(i));
			}
		}
		for(int j=0;j<activeLinks.size();j++){
			HttpURLConnection  connection= (HttpURLConnection) new URL(activeLinks.get(j).getAttribute(hrefTag)).openConnection();
			connection.connect();
			String resp = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute(hrefTag+"---->"+resp));
			
		}
		return (ArrayList<WebElement>) activeLinks;
		}
	
	public void screenShot(){
		
	}
	
	public void sendMail(){
		
	}
	
	
	static int segeratingArrayAndReturningCountofNonZeroNumbers(int []arr, int size){
		int j=0;
		for(int i=0; i<arr.length;i++){
			int temp;
			if(arr[i]<=0){
				temp = arr[i];
				arr[i] =arr[j];
				arr[j]=temp;
				j++;
			}
		}
		return j;
	}
	
	static int findMissing(int arr[], int size){
		int shift = segeratingArrayAndReturningCountofNonZeroNumbers(arr, size);
		int arr2[] = new int[size-shift];
		int j=0;
		for(int i= shift ; i<size;i++){
			arr2[j]=arr[i];
			j++;
		}
		return findMissing(arr2, size);
	}
	
	/*static findMissingPositive(int arr[], int size){
		return 
	}*/
	
	@Test
	public void now() throws IOException{
		countCharactersWordsSentencesWhiteSpaces("D:/SeleniumFrameWork/article.txt");
	}
	
	public void countCharactersWordsSentencesWhiteSpaces(String FilePathName) throws IOException{
//		FileInputStream is that one read data from character stream while other read data from a byte stream. The FileReader automatically converts the raw bytes into character by using platform's default character encoding. This means you should use this class if you are reading from a text file which has same character encoding as the default one.
//		. An InputStreamReader is a bridge between byte stream and character stream and can take a FileInputStream as a source	
		File file = new File(FilePathName);
		FileInputStream filstream= new FileInputStream(file);
		InputStreamReader input = new InputStreamReader(filstream);
		BufferedReader reader = new BufferedReader(input);
		String line ;
		// Initializing counters 
        int countWord = 0; 
        int sentenceCount = 0; 
        int characterCount = 0; 
        int paragraphCount = 1; 
        int whitespaceCount = 0; 
        
        while((line =reader.readLine())!=null){
        	if(line.equals("")){
        		sentenceCount+=1;
        	}
        	if(!(line.equals(""))){
        		characterCount += line.length();
        		String [] wordList = line.split("\\s+");
        		countWord += wordList.length;
        		whitespaceCount = countWord -1; 
                
              // [!?.:]+ is the sentence delimiter in java 
              String[] sentenceList = line.split("[!?.:]+"); 
                
              sentenceCount += sentenceList.length; 
        	}
        }
        System.out.println("Total word count = " + countWord); 
        System.out.println("Total number of sentences = " + sentenceCount); 
        System.out.println("Total number of characters = " + characterCount); 
        System.out.println("Number of paragraphs = " + paragraphCount); 
        System.out.println("Total number of whitespaces = " + whitespaceCount); 
	}
}
