package week5.day1.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase5_DeleteLead extends BaseClassForLeafTaps
{   @Test
	public  void DeleteLead() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/findLeads']")).click();
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9650392127");
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[6]")).click();
		Thread.sleep(3000);
		WebElement get = driver.findElement(By.xpath("(//a[@class='linktext'])[4]"));
		String captured = get.getText();
		System.out.println(captured);
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		driver.findElement(By.xpath("(//a[@href='javascript:document.deleteLeadForm.submit()'])")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/findLeads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(captured);
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[6]")).click();
	
		String noRec = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		String orginal="No records to display";
		System.out.println(noRec);
if (noRec.equals(orginal)) {
	System.out.println("Confirmation - Records Deleted");
} else {
	System.out.println("Confirmation - Records NOT Deleted");
}


	
	
	
	}

}