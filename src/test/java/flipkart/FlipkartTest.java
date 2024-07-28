package flipkart;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartTest {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	@Test(description = "Verify that user able to buy a shoe.")
	public void launchBrowser() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String itemName = "shoes";
		String minPrice = "1000";
		String maxPrice = "2000";
		String brand = "PUMA";
		driver.get("https://www.flipkart.com/");
//		WebElement closeBtn = driver.findElement(By.xpath("//button[text()='✕']"));
//		if (closeBtn.isDisplayed()) {
//			driver.findElement(By.xpath("//button[text()='✕']")).click();
//		}

		WebElement searchBox = driver
				.findElement(By.xpath("//input[@placeholder=\"Search for Products, Brands and More\"]"));
		searchBox.sendKeys(itemName);
		searchBox.sendKeys(Keys.ENTER);
		WebElement searchTerm = driver.findElement(By.xpath("//span[contains(text(),'Showing')]/span"));

		System.out.println();

		Assert.assertEquals(searchTerm.getText(), itemName);
		// Filter Price

		// Filter Price

		WebElement minPriceSelectBox = driver
				.findElement(By.cssSelector("div[class='suthUA']  select[class='Gn+jFg']"));
		Select minSelectBox = new Select(minPriceSelectBox);
//        List<WebElement> options = minSelectBox.getOptions();
//        for (WebElement ele : options) {
//            System.out.println(ele.getText());
//            
//        }
		minSelectBox.selectByValue(minPrice);
		Thread.sleep(3000);
		WebElement maxPriceSelectBox = driver
				.findElement(By.cssSelector("div[class='tKgS7w']  select[class='Gn+jFg']"));
		Select maxSelectBox = new Select(maxPriceSelectBox);
		maxSelectBox.selectByValue(maxPrice);
		Thread.sleep(3000);
		int index = 1;
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='YcSYyC']")));
		String actualAppliedPriceFilter = driver.findElement(By.xpath("//div[@class='YcSYyC'][" + (index) + "]"))
				.getText();
		Assert.assertEquals(actualAppliedPriceFilter, "✕₹" + minPrice + "-₹" + maxPrice);

		// Filter Brand
		WebElement brandSearchBox = driver.findElement(By.xpath("//input[@placeholder='Search Brand']"));
		brandSearchBox.sendKeys(brand);
		WebElement brandCheckBox = driver.findElement(
				By.xpath("//div[@title='" + brand + "']//input[@type='checkbox']/following-sibling::div[1]"));
		brandCheckBox.click();
		Thread.sleep(3000);
		String appliedBrandFilter = driver.findElement(By.xpath("//div[@class='YcSYyC'][" + (index + 1) + "]"))
				.getText();
		Assert.assertEquals(appliedBrandFilter, "✕" + brand);

		String original_window = driver.getWindowHandle();

		int itemIndex = 1;
		driver.findElement(By.xpath("(//div[@class='_75nlfW']//img)[" + itemIndex + "]")).click();

		Set<String> tab = driver.getWindowHandles();
		for (String s : tab) {
			if (s != original_window) {
				driver.switchTo().window(s);

			}

		}

		String shoeSize = "6";
		WebElement shoeSizeButton = driver.findElement(By
				.xpath("//div/span[text()='Size- UK/India']/following-sibling::div//li/a[text()='" + shoeSize + "']"));
		shoeSizeButton.click();
		WebElement buyNowBtn = driver.findElement(By.xpath("//button[text()='Buy Now']"));
		if (buyNowBtn.isEnabled() && buyNowBtn.isDisplayed()) {
			buyNowBtn.click();
			
			// Login Page
			WebElement loginPageTitle = driver.findElement(By.xpath("//span[text()='Login or Signup']"));
			System.out.println(loginPageTitle.isDisplayed());
			Assert.assertTrue("Landed on Login Page", loginPageTitle.isDisplayed());
		} else {
			System.out.println("Out of stock");
		}
		

		
		

	}

}
