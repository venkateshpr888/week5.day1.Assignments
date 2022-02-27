package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign2_ServiceNow {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev68967.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@id ='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id ='user_password']")).sendKeys("Qwerty@123");
		driver.findElement(By.xpath("//button[@id ='sysverb_login']")).click();
		driver.findElement(By.xpath("//input[@id= 'filter']")).sendKeys("incident");
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("winHAndles "+windowHandles);
		ArrayList<String> arrayList = new ArrayList<String>(windowHandles);
	driver.switchTo().window(arrayList.get(1));
	driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
	driver.switchTo().window(arrayList.get(0));
	Thread.sleep(2000);
	driver.switchTo().frame("gsft_main");
	
	driver.findElement(By.xpath("//a[@id='lookup.incident.short_description']")).click();

	Set<String> windowHandles1 = driver.getWindowHandles();
	System.out.println("winHAndles "+windowHandles1);
	ArrayList<String> arrayList1 = new ArrayList<String>(windowHandles1);
driver.switchTo().window(arrayList1.get(1));
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='New employee hire']")).click();
	Thread.sleep(2000);
	driver.switchTo().window(arrayList1.get(0));
	Thread.sleep(2000);
	//System.out.println("hi");
	driver.switchTo().frame("gsft_main");
	String value= driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
	System.out.println("incident number is = "+value);
	driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
	Thread.sleep(2000);
	WebElement state2 = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
	Select select2 = new Select(state2);
	select2.selectByVisibleText("Number");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(value,Keys.ENTER);
	Thread.sleep(2000);
	String text = driver.findElement(By.xpath("//td[@class='vt']//a")).getText();
	System.out.println("After Submit by searching Incident Num is "+text);
	if (value.equals(text)) {
		System.out.println("Verified incident created Successfully");
	}else
	{
		System.out.println("Verified incident NOT created Successfully");
	}
	driver.findElement(By.xpath("//td[@class='vt']//a")).click();
	Thread.sleep(2000);
	File src = driver.getScreenshotAs(OutputType.FILE);
	File dest=new File("./Snaps/"+value+".jpg");
	FileUtils.copyFile(src, dest);
	
	}

}


//Thread.sleep(2000);
//driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Application is not working");
//String incNumber= driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
//System.out.println("Incident number is :: "+incNumber);
//driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
//Set<String> windowHandles = driver.getWindowHandles();
////System.out.println(windowHandles);
//List<String>list=new ArrayList<String>(windowHandles);
//System.out.println("Current URL is :: "+ driver.getCurrentUrl());
//driver.switchTo().window(list.get(1)); 
//driver.findElement(By.linkText("Abel Tuter")).click();
//Thread.sleep(2000);
//driver.switchTo().window(list.get(0)) ;
//System.out.println( driver.getCurrentUrl());
//System.out.println(list.get(0));
//driver.switchTo().frame("gsft_main");
//driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();//submit button
//Thread.sleep(2000);
//driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incNumber);
//driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Keys.ENTER);
//Thread.sleep(2000);
//String SearchIncNumber = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
//System.out.println("In search incident number is :: "+SearchIncNumber);
//if(incNumber.equals(SearchIncNumber))
//{
//	System.out.println("Incident number is created and verified successfully");
//}
//
//driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
//Thread.sleep(2000);
//File source=driver.getScreenshotAs(OutputType.FILE);
//String imageFileName = "./src/main/resources/snapshot/"+incNumber+ ".png";
//File dest=new File(imageFileName);
//FileUtils.copyFile(source, dest);