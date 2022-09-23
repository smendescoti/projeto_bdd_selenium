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

public class AcessarContasTestSteps {

	WebDriver driver; // selenium web driver

	@Given("Acessar a página de autenticação de conta de usuário")
	public void acessar_a_página_de_autenticação_de_conta_de_usuário() {

		driver = WebDriverHelper.getInstance();		
		driver.get("http://sergiocontatos-001-site1.ftempurl.com/Jmeter/Exercicio05");
	}

	@Given("Informar o email do usuário")
	public void informar_o_email_do_usuário() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		element.clear();
		element.sendKeys("testador@gmail.com");
	}

	@Given("Informar a senha do usuário")
	public void informar_a_senha_do_usuário() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Senha\"]"));
		element.clear();
		element.sendKeys("@Teste2022");
	}

	@When("Solicitar a realização do acesso")
	public void solicitar_a_realização_do_acesso() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"btn_acesso\"]"));
		element.click();
	}

	@Then("Sistema autentica o usuário com sucesso")
	public void sistema_autentica_o_usuário_com_sucesso() {

		String urlAtual = driver.getCurrentUrl();
		String urlEsperada = "http://sergiocontatos-001-site1.ftempurl.com/JMeter/AreaRestrita";
		
		assertEquals(urlEsperada, urlAtual);
		
		ScreenshotHelper.print(driver, "Sistema autentica o usuário com sucesso");
		
		driver.close();
		driver.quit();
	}

	@Given("Informar um email de usuário inválido")
	public void informar_um_email_de_usuário_inválido() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		element.clear();
		element.sendKeys("emailinvalido@gmail.com");
	}

	@Given("Informar uma senha de usuário inválida")
	public void informar_uma_senha_de_usuário_inválida() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Senha\"]"));
		element.clear();
		element.sendKeys("@Senha123");
	}

	@Then("Sistema informa que o acesso é negado")
	public void sistema_informa_que_o_acesso_é_negado() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"mensagem\"]"));
		
		String resultadoObtido = element.getText();
		String resultadoEsperado = "Acesso Negado";
		
		assertEquals(resultadoEsperado, resultadoObtido);
		
		ScreenshotHelper.print(driver, "Sistema informa que o acesso é negado");
		
		driver.close();
		driver.quit();
	}

	@Given("Preencher o email com valor vazio")
	public void preencher_o_email_com_valor_vazio() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		element.clear();
	}

	@Given("Preencher a senha com valor vazio")
	public void preencher_a_senha_com_valor_vazio() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Senha\"]"));
		element.clear();
	}

	@When("Sistema informa que email e senha são obrigatórios")
	public void sistema_informa_que_email_e_senha_são_obrigatórios() {

		WebElement erroEmail = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div/div/div/form/div[1]/span"));
		WebElement erroSenha = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div/div/div/div/form/div[2]/span"));
		
		String erroEmailObtido = erroEmail.getText();
		String erroEmailEsperado = "Por favor, informe o email.";
		
		String erroSenhaObtido = erroSenha.getText();
		String erroSenhaEsperado = "Por favor, informe a senha.";
		
		assertEquals(erroEmailEsperado, erroEmailObtido);
		assertEquals(erroSenhaEsperado, erroSenhaObtido);
		
		ScreenshotHelper.print(driver, "Sistema informa que email e senha são obrigatórios");
		
		driver.close();
		driver.quit();
	}

}
