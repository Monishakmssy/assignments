package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("testleaf");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("coimbatore");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("chennai");
		WebElement market = driver.findElement(By.xpath("(//select[contains(@id,'createLead')])[2]"));
		Select drop2=new Select(market);
		drop2.selectByIndex(4); 
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		String title2 = driver.getTitle();
		System.out.println(title2);
		if(title1.equals(title2)) {
			System.out.println("title is same");
		}
		else {
			System.out.println("not same");
			List<WebElement> options = drop2.getOptions();
			int size = options.size();
			System.out.println(size);
			for(int i=0; i<size; i++) {
				WebElement dropOption = options.get(i);
				System.out.println(dropOption.getText());
			}
			
			for(WebElement WebElement:options) {
				System.out.println(WebElement.getText());				
	}
}
}
}