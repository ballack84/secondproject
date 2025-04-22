package standarduser;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class fifthsessiondemo {

	Random rand = new Random();
	WebDriver driver = new ChromeDriver();
	String MyWebSite = "https://www.saucedemo.com/v1/";
	String Username = "standard_user";
	String PasswordInput = "secret_sauce";

	@BeforeTest

	public void MySetup() {

		driver.get(MyWebSite);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)

	public void Login() {

		WebElement Usernameelement = driver.findElement(By.id("user-name"));
		WebElement Passwordelement = driver.findElement(By.id("password"));
		WebElement Loginelement = driver.findElement(By.id("login-button"));

		Usernameelement.sendKeys(Username);
		Passwordelement.sendKeys(PasswordInput);
		Loginelement.click();
	}

	// to add first two carts only and stop
	@Test(priority = 2, enabled = false)

	public void AddToCartItemfirsttwoonly() {

		List<WebElement> AddToCartItem = driver.findElements(By.className("btn_primary"));

		for (int c = 0; c < AddToCartItem.size(); c++) {
			if (c == 2) {
				break;

			}

			AddToCartItem.get(c).click(); // Adds item at index 0, 2, 4, etc.
		}
	}

	// to add items and skip no 3
	@Test(priority = 2, enabled = false)

	public void AddToCartItemskipnothree() {

		List<WebElement> AddToCartItem = driver.findElements(By.className("btn_primary"));

		for (int c = 0; c < AddToCartItem.size(); c++) {
			if (c == 2) {
				continue;

			}

			AddToCartItem.get(c).click(); // Adds item at index 0, 2, 4, etc.

		}
	}

	// to add items and skip no 1 and 3
	@Test(priority = 2, enabled = false)

	public void AddToCartItemskipnoneandthree() {

		List<WebElement> AddToCartItem = driver.findElements(By.className("btn_primary"));

		for (int c = 0; c < AddToCartItem.size(); c++) {
			if (c == 0 || c == 2) {
				continue;

			}

			AddToCartItem.get(c).click(); // Adds item at index 0, 2, 4, etc.

		}
	}

	// to print locally only the result on console
	@Test(priority = 2, enabled = false)

	public void AddToCartItemsname() {

		List<WebElement> AddToCartItem = driver.findElements(By.className("btn_primary"));
		List<WebElement> Addcartname = driver.findElements(By.className("inventory_item_name"));
		for (int c = 0; c < Addcartname.size(); c++) {

			System.out.print(Addcartname.get(c).getText());

		}
	}

	// add the items that start with suace

	@Test(priority = 2, enabled = false)

	public void AddToCartItemsbynamesauce() {

		List<WebElement> AddToCartItem = driver.findElements(By.className("btn_primary"));
		List<WebElement> Addcartname = driver.findElements(By.className("inventory_item_name"));
		for (int c = 0; c < Addcartname.size(); c++) {

			if (Addcartname.get(c).getText().startsWith("Sauce")) {
				AddToCartItem.get(c).click();

			}
		}

	}

	// add the items that start with suace

	@Test(priority = 2, enabled = false)

	public void skipToCartItemsbynamesauce() {

		List<WebElement> AddToCartItem = driver.findElements(By.className("btn_primary"));
		List<WebElement> Addcartname = driver.findElements(By.className("inventory_item_name"));
		for (int c = 0; c < Addcartname.size(); c++) {

			if (Addcartname.get(c).getText().startsWith("Sauce")) {
				continue;
			}
			AddToCartItem.get(c).click();

		}

	}

	@Test(priority = 2)

	public void addrandomitem() {

		List<WebElement> AddToCartItem = driver.findElements(By.className("btn_primary"));
		// to add item randomly
		int randomitem = rand.nextInt(AddToCartItem.size());
		// only to check on console the number of item
		System.out.println(randomitem);

		// double randomindex = Math.floor(Math.random()*AddToCartItem.size());
		// system.out.println(Math random()*AddToCartItem.size());
		// system.out.println(Math.floor(6.9));
		// system.out.println(Math.ceil(88.5));
		AddToCartItem.get(randomitem).click();

	}

	@Test(priority = 3)

	public void checkoutitems() {

		WebElement shopcart = driver.findElement(By.className("svg-inline--fa"));
		shopcart.click();
		WebElement checkoutbutton = driver.findElement(By.className("btn_action"));
		checkoutbutton.click();

		// array of first name by static
		String[] firstnames = { "Haitham", "Ahmad", "Khalid" };
		int randomfirstname = rand.nextInt(firstnames.length);
		// array of last name by static
		String[] lastnames = { "Joury", "Reem", "Salam" };
		int randomlastname = rand.nextInt(lastnames.length);
		String[] postalcodes = { "111", "222", "333" };
		int randompostalcode = rand.nextInt(postalcodes.length);

		WebElement firstnameinput = driver.findElement(By.id("first-name"));
		firstnameinput.sendKeys(firstnames[randomfirstname]);
		WebElement lastnameinput = driver.findElement(By.id("last-name"));
		lastnameinput.sendKeys(lastnames[randomlastname]);
		WebElement postalcodeinput = driver.findElement(By.id("postal-code"));
		postalcodeinput.sendKeys(postalcodes[randompostalcode]);
		
		WebElement contbutton = driver.findElement(By.className("btn_primary"));
		contbutton.click();
		WebElement finishbutton = driver.findElement(By.className("btn_action"));
		finishbutton.click();
	}
	//control shift f to align the code

	@AfterTest

	public void AfterMyTest() {

		// driver.quit();
	}

}