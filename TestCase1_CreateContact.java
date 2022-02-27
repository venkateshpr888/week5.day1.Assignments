package week5.day1.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1_CreateContact extends BaseClassForLeafTaps {
	@Test
	public void CreateContact () {
		System.out.println("hi");
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("venkatesh");
        driver.findElement(By.id("lastNameField")).sendKeys("Ravi");
	    driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewContact_firstName_sp")).getText();
	    System.out.println("First name = "+text+"   "+"Browser Title = "+driver.getTitle());
	   
	    
	    
	    
	}
}
