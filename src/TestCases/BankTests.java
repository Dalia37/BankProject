package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BankTests extends Parameters {
	WebDriver driver = new ChromeDriver();
	String URL = "https://globalsqa.com/angularJs-protractor/BankingProject/#/login";
	String authID = "captchacharacters";
	Parameters parameters = new Parameters();
	

	@BeforeTest
	public void setUP() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(URL);

	}

	@Test(priority = 1, enabled = true)
	public void CustomerLogin() {
		WebElement btn = driver.findElement(By.cssSelector("div[class='borderM box padT20'] div:nth-child(1)"));
		btn.click();

	}

	@Test(priority = 2, enabled = true)
	public void AnyRandomName() {
		WebElement selector = driver.findElement(By.id("userSelect"));
		selector.sendKeys(CustomersName[CustomerID]);

	}

	@Test(priority = 3, enabled = true)
	public void deposit() throws InterruptedException {
		driver.findElement(By.className("btn-default")).click();
		driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass2']")).click();
		WebElement inputamount = driver.findElement(By.className("form-control"));
		inputamount.sendKeys(RandomAmount + "");
		Thread.sleep(5000);

		driver.findElement(By.className("btn-default")).click();
		System.out.println(RandomAmount);
		String ActualText = driver.findElement(By.className("error")).getText();
		String ExpextedText = "Deposit Successful";
		assertEquals(ActualText, ExpextedText);
		Thread.sleep(5000);
		

	}

	@Test(priority = 4, enabled = true)
	public void Withdrawl() throws InterruptedException {
		driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass3']")).click();
		Thread.sleep(5000);

		WebElement Withdrawinput = driver.findElement(By.className("form-control"));
		Thread.sleep(5000);
		Withdrawinput.sendKeys(RandomAmount + "");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[normalize-space()='Withdraw']")).click();

		// Test
		String Actual = driver.findElement(By.className("error")).getText();
		String expected = "Transaction successful";
		assertEquals(Actual, expected);


	}
	
	@Test(priority = 5, enabled = true)
	public void checkBalance() {
		String ActualBalance = driver.findElement(By.xpath("//strong[normalize-space()='0']")).getText();
	    String expexted = "0"; 
	    assertEquals(ActualBalance, expexted);
	    System.out.println("Suuuupppppppppppper");
		
	}

	@org.testng.annotations.AfterTest
	public void AfterTest() {
	}

}
