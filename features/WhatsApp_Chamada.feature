@tag
Feature: Executar chamadas pelo whatsapp
	Para executar uma chamada pelo whatsapp
	Como um usu�rio de whatsapp
	Eu quero selecionar um contato da minha lista de contatos do whatsapp e efetuar uma chamada para este contato

@tag1
Scenario: Iniciar a chamada de voz para contato do whatsApp
Given Que estou na p�gina de contatos do whatsApp
When Eu seleciono um contato na lista de contatos
	And Eu aciono o comando de efetuar chamada
	And Eu aciono a op��o de chamada de voz
Then O whatsapp inicia a chamada de voz para o contato

@tag2
Scenario: Encerrar a chamada de voz realizada para o contato do whatsApp
Given Que estou com a chamada de voz em andamento
When Eu seleciono a op��o encerrar chamada de voz
Then O whatsapp finaliza a chamada

@tag3
Scenario: Iniciar a chamada de video para contato do whatsApp
Given Que estou na p�gina de contatos do whatsApp
When Eu seleciono um contato na lista de contatos
	And Eu aciono o comando de efetuar chamada
	And Eu aciono a op��o de chamada de video
Then O whatsapp inicia a chamada de video para o contato

@tag4
Scenario: Encerrar a chamada de video realizada para o contato do whatsApp
Given Que estou com a chamada de video em andamento
When Eu seleciono a op��o encerrar chamada de video
Then O whatsapp finaliza a chamada