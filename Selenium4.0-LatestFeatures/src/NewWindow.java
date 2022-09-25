import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// Switching window
		driver.switchTo().newWindow(WindowType.TAB);// yeni sekmede boş bir sayfa açar
//driver.switchTo().newWindow(WindowType.WINDOW);--> YENİ PENCERE DE SAYFA AÇAR boş sayfa
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(childWindowID);
		driver.get("https://rahulshettyacademy.com/");// açılan yeni sekme/sayfanormalde boş ama bu url açılır bu kodla

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();
		driver.switchTo().window(parentWindowID);
		WebElement emailBox = driver.findElement(By.cssSelector("[name='email']"));
		WebElement nameBox = driver.findElement(with(By.tagName("input")).above(emailBox));
		nameBox.sendKeys(courseName);

		/*
		 * namebox alanının sadece ekran görüntüsünü aldım. alınan ekran görüntüsü
		 * projeye sağ tık properity sonra simgeye tıkla lokasyonun yanında simge
		 */
		File file = nameBox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));

		// driver.quit();
		
		/* seçilen çerçevenin yükseklik(height) ve genişlik(width) veren otomasyon kodu */
		
		System.out.println(nameBox.getRect().getDimension().getHeight()); //yükseklik verir
		System.out.println(nameBox.getRect().getDimension().getWidth());  //genişlik verir
		

	}

}
