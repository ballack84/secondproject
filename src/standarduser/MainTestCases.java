package standarduser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTestCases {

	WebDriver driver = new ChromeDriver();
	String MyWebSite = "https://www.saucedemo.com/v1/";
	String Username = "standard_user";
	String PasswordInput = "secret_sauce";

	@BeforeTest

	public void MySetup() {

		driver.get(MyWebSite);
		driver.manage().window().maximize();
		// driver.manage().window().minimize();
		// driver.manage().window().fullscreen();
	}

	@Test(priority = 1)

	public void Login() {

		// driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(Username);
		// driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(PasswordInput);
		driver.findElement(By.id("user-name")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(PasswordInput);
		driver.findElement(By.id("login-button")).click();

	}

	@Test(priority = 2)

	public void AddToCartItem() throws InterruptedException {

		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")).click();
		//driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button")).click();
		
	//	driver.findElements(By.className("btn_primary")).get(0).click();
	//	driver.findElements(By.className("btn_primary")).get(1).click();
	//	driver.findElements(By.className("btn_primary")).get(2).click();
	//	driver.findElements(By.className("btn_primary")).get(3).click();
	//	driver.findElements(By.className("btn_primary")).get(4).click();
	//	driver.findElements(By.className("btn_primary")).get(5).click();
		
		
		List<WebElement> AddToCartItem = driver.findElements(By.className("btn_primary"));
		for(int i=0; i<AddToCartItem.size();i++) {
			AddToCartItem.get(i).click();
		}
	
	}

	@Test(priority = 3)

	public void RemoveCartItem() throws InterruptedException {

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")).click();
	}

	@AfterTest

	public void AfterMyTest() {
		
		driver.quit();
	}

}
