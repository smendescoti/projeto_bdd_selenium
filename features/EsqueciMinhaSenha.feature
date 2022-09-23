#encoding: ISO-8859-1

Feature: Esqueci minha senha
	Como um usu�rio cadastrado no sistema
	Eu quero recuperar minha senha de acesso
	De modo que eu possa autenticar no sistema
	
Scenario: Recupera��o de senha com sucesso
	Recupera��o de senha do usu�rio bem sucedida
	
	Given Acessar a p�gina de recupera��o de senha do usu�rio
	And Informar o email cadastrado do usu�rio
	When Solicitar a recupera��o da senha
	Then Sistema informa que um email de recupera��o de senha foi enviado com sucesso
	
Scenario: Email inv�lido para recupera��o de senha
	Recupera��o de senha n�o permitida pois o email � inv�lido
	
	Given Acessar a p�gina de recupera��o de senha do usu�rio
	And Informar um email inv�lido
	When Solicitar a recupera��o da senha
	Then Sistema informa que o email � inv�lido para recupera��o da senha
	
Scenario: Campos obrigat�rios para recupera��o da senha
	Valida��o dos campos do formul�rio de recupera��o de senha
	
	Given Acessar a p�gina de recupera��o de senha do usu�rio
	And Preencher o email para recupera��o da senha com valor vazio
	When Solicitar a recupera��o da senha
	Then Sistema informa que o preenchimento do email � obrigat�rio