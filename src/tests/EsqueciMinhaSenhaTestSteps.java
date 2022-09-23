package tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.ScreenshotHelper;
import helpers.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EsqueciMinhaSenhaTestSteps {

	WebDriver driver;
	
	@Given("Acessar a p�gina de recupera��o de senha do usu�rio")
	public void acessar_a_p�gina_de_recupera��o_de_senha_do_usu�rio() {

		driver = WebDriverHelper.getInstance();
		driver.get("http://sergiocontatos-001-site1.ftempurl.com/Jmeter/Exercicio06");
	}
	
	@Given("Informar o email cadastrado do usu�rio")
	public void informar_o_email_cadastrado_do_usuario() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		element.clear();
		element.sendKeys("testador@gmail.com");
	}

	@When("Solicitar a recupera��o da senha")
	public void solicitar_a_recupera��o_da_senha() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"btn_acesso\"]"));
		element.click();
	}

	@Then("Sistema informa que um email de recupera��o de senha foi enviado com sucesso")
	public void sistema_informa_que_um_email_de_recupera��o_de_senha_foi_enviado_com_sucesso() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"mensagem\"]"));
		
		String resultadoObtido = element.getText();
		String resultadoEsperado = "Sucesso! Voc� recebeu um email contendo um link para cadastrar uma nova senha.";
		
		assertEquals(resultadoEsperado, resultadoObtido);
		
		ScreenshotHelper.print(driver, "Sistema informa que um email de recupera��o de senha foi enviado com sucesso");
		
		driver.close();
		driver.quit();
	}

	@Given("Informar um email inv�lido")
	public void informar_um_email_inv�lido() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		element.clear();
		element.sendKeys("emailinvalido@gmail.com");
	}

	@Then("Sistema informa que o email � inv�lido para recupera��o da senha")
	public void sistema_informa_que_o_email_�_inv�lido_para_recupera��o_da_senha() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"mensagem\"]"));
		
		String resultadoObtido = element.getText();
		String resultadoEsperado = "Email inv�lido. Este email n�o est� cadastrado na aplica��o";
		
		assertEquals(resultadoEsperado, resultadoObtido);
		
		ScreenshotHelper.print(driver, "Sistema informa que o email � inv�lido para recupera��o da senha");
		
		driver.close();
		driver.quit();
	}

	@Given("Preencher o email para recupera��o da senha com valor vazio")
	public void preencher_o_email_para_recupera��o_da_senha_com_valor_vazio() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		element.clear();
	}

	@Then("Sistema informa que o preenchimento do email � obrigat�rio")
	public void sistema_informa_que_o_preenchimento_do_email_�_obrigat�rio() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div/div/div/form/div[1]/span"));
		
		String resultadoObtido = element.getText();
		String resultadoEsperado = "Por favor, informe o email.";
		
		assertEquals(resultadoEsperado, resultadoObtido);
		
		ScreenshotHelper.print(driver, "Sistema informa que o preenchimento do email � obrigat�rio");
		
		driver.close();
		driver.quit();
	}	
}
