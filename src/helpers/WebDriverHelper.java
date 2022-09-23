package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHelper {

	// fun��o para retornar a configura��o do navegador utilizado para os testes
	public static WebDriver getInstance() {

		// definindo o local do driver do navegador
		System.setProperty("webdriver.chrome.driver", "c:\\chrome\\chromedriver.exe");

		// abrindo o navegador
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		return driver;
	}
}
