package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.Alert;
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
	
	

	@BeforeTest
	public void setUP() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(URL);

	}

	@Test(priority = 1, enabled = false)
	public void CustomerLogin() {
		WebElement btn = driver.findElement(By.cssSelector("div[class='borderM box padT20'] div:nth-child(1)"));
		btn.click();

	}

	@Test(priority = 2, enabled = false)
	public void AnyRandomName() {
		WebElement selector = driver.findElement(By.id("userSelect"));
		selector.sendKeys(CustomersName[CustomerID]);

	}

	@Test(priority = 3, enabled = false)
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

	@Test(priority = 4, enabled = false)
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
	
	@Test(priority = 5, enabled = false)
	public void checkBalance() {
		String ActualBalance = driver.findElement(By.xpath("//strong[normalize-space()='0']")).getText();
	    String expexted = "0"; 
	    assertEquals(ActualBalance, expexted);
	  
		
	}
	
	
	@Test(priority = 6 , enabled = true)
	public void BankManagerLogin() {
		WebElement ManagerLoginbtn = driver.findElement(By.cssSelector("button[ng-click='manager()']"));
		ManagerLoginbtn.click();
	}
	@Test(priority = 7 , enabled =true)
	public void AddOneCustomer() throws InterruptedException {
		WebElement Addcustomerbtn = driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass1']"));
		Addcustomerbtn.click();
		
		WebElement firstnameinput = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
		firstnameinput.sendKeys(firstNames[firstNameRandome]);
		
		WebElement lastNameinput = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
		lastNameinput.sendKeys(lastNames[lastNameRandome]);
		
		WebElement postCodeinput = driver.findElement(By.cssSelector("input[placeholder='Post Code']"));
		postCodeinput.sendKeys(postCode[postcodeRandom]);
		
		WebElement addcustomerbtn=driver.findElement(By.className("btn-default"));
		addcustomerbtn.click();
	    
	
		//test
        Alert alert = driver.switchTo().alert();
        String ActualText = alert.getText();
        assertEquals(ActualText.contains("Customer added successfully"), true);
        Thread.sleep(2000);
        alert.accept();
        


	}
	
	@Test(priority = 8 , enabled = true)
	public void openAccount() throws InterruptedException {
		WebElement openbtn = driver.findElement(By.xpath("//button[normalize-space()='Open Account']"));
		openbtn.click();
		
		WebElement customerinput = driver.findElement(By.id("userSelect"));
		customerinput.sendKeys(CustomersName[CustomerID]);
		
		WebElement currencyinput = driver.findElement(By.id("currency"));
		currencyinput.sendKeys(currency[carrencyRanom]);
		
		WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
		submit.click();
		//Test
		Alert alert = driver.switchTo().alert();
		String ActualalertText =alert.getText();
		assertEquals(ActualalertText.contains("Account created successfully"), true);
		Thread.sleep(2000);
		alert.accept();
		
		
	}
	@Test(priority = 9 , enabled = true)
	public void deleteCustomer() {
		WebElement Customerbtn = driver.findElement(By.xpath("//button[normalize-space()='Customers']"));
		Customerbtn.click();
		
		WebElement container = driver.findElement(By.className("marTop"));
		
		int deletbtns = container.findElements(By.tagName("button")).size();
		System.out.println(deletbtns);
		

	    container.findElements(By.tagName("button")).get(CustomerID).click();
    	System.out.println("deleted");
	
	}
	
	@org.testng.annotations.AfterTest
	public void AfterTest() {
	}

}
