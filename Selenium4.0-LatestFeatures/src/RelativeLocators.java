import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {
	/*
	 * import static org.openqa.selenium.support.locators.RelativeLocator.*; bu
	 * importu elimle kendim tanımlamam gerekiyor çünkü statik Relative locators
	 * kullanırken kendim elle yazacağım.
	 */
	public static void main(String[] args) {
	
		// above() --> üstünde
		// below() --> aşağıda
		// toLeftOf() --> solunda
		// toRightof() --> sağında
		/* near() -->   belirtilen öğeden en fazla 50 piksel uzakta bir öğe bulmamız gerektiğinde yararlıdır. */
		
		
		
		/*
		 * Göreceli konumlandırıcılar diye geçiyor. bazı metotlarla beraber bazı
		 * işlerimizi kolaylaştırabileceğiz.Örneğin <label xpath="1">Name</label> Name
		 * den başka bir şey yazmıyor e ben bunu nasıl tanımlandıracağım parents-child
		 * ilişkisiyle yapabilirim. Bunu above() metodu ile yapabilirim. Syntax-->
		 * driver.findElement(with(By.tagName()).above(nameEditbox))
		 * WebElement nameEditbox = buraya neyin üstündeki şeyi seçmek istiyorsam yolunu yazıyorum
		 * Örneğin login sayfam var yukarı kutuda email bi altında da password kutuları var
		 * Şifre alanının üstündeki e-posta adresi alanını bulmak istiyoruz.
		 * Bunu yapmak için, id aracılığıyla şifre alanını buluyoruz
		 * ve ardından yukarıdaki göreceli konumlandırıcıyı kullanıyoruz.
		 * 
		 */
	

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		System.out.println("----------------");
		/* buraya da emailin üstündeki name alanına Hüseyin yazdırdım*/
		WebElement emailBox=driver.findElement(By.cssSelector("[name='email']"));
		driver.findElement(with(By.tagName("input")).above(emailBox)).sendKeys("Hüseyin");
		driver.findElement(with(By.tagName("input")).below(nameEditBox)).sendKeys("example@gmail.com");
		
		WebElement employedButton=driver.findElement(By.id("inlineRadio2"));
		driver.findElement(with(By.tagName("input")).toLeftOf(employedButton)).click();
		
		WebElement studentButton=driver.findElement(By.id("inlineRadio1"));
		driver.findElement(with(By.tagName("input")).toRightOf(studentButton)).click();
		driver.findElement(with(By.tagName("input")).toLeftOf(employedButton)).click();
	}

}
