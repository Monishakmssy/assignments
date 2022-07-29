package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
	    EdgeDriver driver = new EdgeDriver();
	    driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
//		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("1");
//		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		WebElement lead1 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String lead1Id = lead1.getText();
		System.out.println("lead: "+lead1Id);
		lead1.click();
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		Thread.sleep(100);
		driver.findElement(By.partialLinkText("Find Leads")).click();//		15	Enter captured lead ID
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input")).sendKeys(lead1Id);//		16	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		WebElement searchResult = driver.findElement(By.xpath("//div[text()='No records to display']"));
		String expectedMsg = searchResult.getText();
		String actualMsg = "No records to display";
		if(expectedMsg.equalsIgnoreCase(actualMsg)) {
			System.out.println("Lead Id: "+ lead1Id + " is deleted successfully" );				
		}else {
			System.out.println("Lead Id: "+ lead1Id + " is not deleted successfully");
		}
		driver.close();
	    }

}
}
