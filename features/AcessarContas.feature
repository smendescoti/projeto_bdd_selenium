#encoding: ISO-8859-1

Feature: Acessar Conta
	Como um usu�rio cadastrado no sistema
	Eu quero acessar minha conta
	De modo que eu possa autenticar no sistema
	
Scenario: Acessar conta com sucesso
	Autentica��o de usu�rio bem sucedida
	
	Given Acessar a p�gina de autentica��o de conta de usu�rio
	And Informar o email do usu�rio
	And Informar a senha do usu�rio
	When Solicitar a realiza��o do acesso
	Then Sistema autentica o usu�rio com sucesso
	
Scenario: Acesso negado
	Acesso n�o autorizado de usu�rio
	
	Given Acessar a p�gina de autentica��o de conta de usu�rio
	And Informar um email de usu�rio inv�lido
	And Informar uma senha de usu�rio inv�lida
	When Solicitar a realiza��o do acesso
	Then Sistema informa que o acesso � negado
	
Scenario: Campos obrigat�rios para autentica��o
	Valida��o dos campos do formul�rio de acesso
	
	Given Acessar a p�gina de autentica��o de conta de usu�rio
	And Preencher o email com valor vazio
	And Preencher a senha com valor vazio
	When Solicitar a realiza��o do acesso
	When Sistema informa que email e senha s�o obrigat�rios
	