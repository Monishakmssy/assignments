package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
public static void main(String[] args) {
	WebDriverManager.edgedriver().setup();
	EdgeDriver driver=new EdgeDriver();
	driver.get("http://en-gb.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.xpath("//a[contains(text(),'Create')]")).click();
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Monisha");
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Karthick");
	driver.findElement(By.name("reg_email__")).sendKeys("monisha602@gmail.com");
	driver.findElement(By.name("reg_passwd__")).sendKeys("iamhappy");
	WebElement date = driver.findElement(By.id("day"));
	Select drop1=new Select(date);
	drop1.selectByValue("6");
	WebElement month = driver.findElement(By.id("month"));
	Select drop2=new Select(month);
	drop2.selectByVisibleText("May");
	WebElement year = driver.findElement(By.id("year"));
	Select drop3=new Select(year);
	 drop3.selectByValue("1998");
	 driver.findElement(By.xpath("//label[text()='Female']")).click();	
}
}