package assignment;

import java.io.PrintWriter;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {
		PrintWriter p=new PrintWriter(System.out);
		
		//setting up the webdriver
		System.setProperty("webdriver.chrome.driver","D://chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		
		//getting the link on which we have to test
		driver.get("https://www.google.com/");
		
		//maximize the chrome window
		driver.manage().window().maximize();
		
		//wait for 2 seconds
		Thread.sleep(2000);
		
		//we are searching for "january" so we find the html element by its name
		driver.findElement(By.name("q")).sendKeys("january");
		
		//wait fror 6 seconds
		Thread.sleep(6000);
		
		
		//we find the keys associated with january using the xpath
		List<WebElement> list=driver.findElements(By.xpath
				("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
		
		
		//printing the number of keys found
		p.println(list.size());
		
		
		//searching for a specific key
		for(int i=0;i<list.size();i++) {
			String item=list.get(i).getText();
			p.println(item);
			if(item.contains("30 special day")) {
				p.println("found what we were looking for");
				break;
			}
		}
		p.close();
		
	}

}
