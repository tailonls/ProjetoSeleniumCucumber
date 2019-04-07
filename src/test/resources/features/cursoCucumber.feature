#language: pt
Funcionalidade: curso cucumber

  Cenario: Deve executar a especificação
    Dado que criei  arquivo corretamente
    Quando executa-lo
    Então a especificação deve finalizar com sucesso

	@curso
  Cenario: Deve incrementar contador
    Dado que o valor do contador é 15
    Quando incrementar o valor em 3
    Então o valor do contador será 18

	@curso
  Cenario: Deve incrementar contador reaproveitando cenario anterior
    Dado que o valor do contador é 150
    Quando incrementar o valor em 8
    Então o valor do contador será 158

	@curso
  Cenario: Deve calcular o atraso da entrega
    Dado que a entrega é  dia 05/04/2018
    Quando a entrega atrasar em 2 dias
    Então a entrega deverá ser efetuada em 07/04/2018

  Cenario: Deve calcular o atraso da entrega na china
    Dado que a entrega é  dia 05/04/2018
    Quando a entrega atrasar em 2 meses
    Então a entrega deverá ser efetuada em 05/06/2018

	@curso
  Cenário: Deve criar steps genéricos para estes passos
    Dado que o ticket é AF345
    E que o valor da passagem é R$ 230,45
    E que o nome do passageiro é "Fulano da Silva"
    E que o telefone do passageiro é 9999-9999
    Quando criar os steps
    Então o teste vai funcionar

	@curso
  Cenário: Deve reaproveitar os steps "Dado" do cenário anterior
    Dado que o ticket é AB167
    E que o ticket especial é AB167
    E que o valor da passagem é R$ 1120,23
    E que o nome do passageiro é "Cicrano de Oliveira"
    E que o telefone do passageiro é 9888-8888

  @ignore
  Cenário: Deve NEGAR todos os steps "Dado" dos cenários anteriores
    Dado que o ticket é CD123
    E que o ticket é AG1234
    E que o valor da passagem é R$ 1.1345,56
    E que o nome do passageiro é "Beltrano Souza Matos de Alcântara Azevedo"
    E que o telefone do passageiro é 1234-5678
    E que o telefone do passageiro é 999-2223
