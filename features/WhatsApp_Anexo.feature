@tag
Feature: Enviar anexos a contatos pelo whatsapp
	Para enviar um anexo pelo whatsapp
	Como um usuário de whatsapp
	Eu quero selecionar um contato da minha lista de contatos do whatsapp e enviar um anexo para este contato

@tag1
Scenario: Enviar documento para contato do whatsApp
Given Que estou na página de contatos do whatsApp
When Eu seleciono um contato na lista de contatos
	And Eu aciono o comando de anexar
	And Eu seleciono o anexo do tipo Documento
	And Eu seleciono o documento desejado
	And Eu seleciono a opção de enviar anexo
Then O whatsapp envia o anexo para o contato
	And O whatsApp exibe o sinal de documento enviado
	And O whatsApp exibe o segundo sinal de documento recebido

@tag2
Scenario: Enviar foto para contato do whatsApp
Given Que estou na página de contatos do whatsApp
When Eu seleciono um contato na lista de contatos
	And Eu aciono o comando de anexar
	And Eu seleciono o anexo do tipo Galeria
	And Eu seleciono a imagem desejado
	And Eu seleciono a opção de enviar anexo
Then O whatsapp envia o anexo para o contato
	And O whatsApp exibe o sinal de imagem enviado
	And O whatsApp exibe o segundo sinal de imagem recebido

@tag3
Scenario: Enviar Contato para contato do whatsApp
Given Que estou na página de contatos do whatsApp
When Eu seleciono um contato na lista de contatos
	And Eu aciono o comando de anexar
	And Eu seleciono o anexo do tipo Contato
	And Eu seleciono o contato desejado
	And Eu seleciono a opção de enviar anexo
Then O whatsapp envia o anexo para o contato
	And O whatsApp exibe o sinal de contato enviado
	And O whatsApp exibe o segundo sinal de contato recebido