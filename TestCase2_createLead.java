package week5.day1.Assignments;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2_createLead extends BaseClassForLeafTaps {
@Test
	public void createLead() {
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();	
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("venkatesh");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ravi");
		driver.findElement(By.xpath("//input[@id='createLeadForm_birthDate']")).sendKeys("9/9/93");

		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("venkatesh@gmail.com");
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryPhoneNumber']")).sendKeys("9650392127");
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalToName']")).sendKeys("Venkatesh R");
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalAddress1']")).sendKeys("Mattuthavani");	
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalAddress2']")).sendKeys("Avaniyapuram");
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalCity']")).sendKeys("Madurai");
		WebElement state1 = driver.findElement(By.xpath("//select[@id='createLeadForm_generalCountryGeoId']"));
		Select select1 = new Select(state1);
		select1.selectByVisibleText("India");
	
		WebElement state = driver.findElement(By.xpath("//select[@id='createLeadForm_generalStateProvinceGeoId']"));
		Select select = new Select(state);
		select.selectByVisibleText("TAMILNADU");
		driver.findElement(By.xpath("//input[@id='createLeadForm_generalPostalCode']")).sendKeys("625009");
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
	}

}
