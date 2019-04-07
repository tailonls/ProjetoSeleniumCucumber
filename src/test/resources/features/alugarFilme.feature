#language: pt
@aluguel
Funcionalidade: Alugar filme
  
  Como um usuário
  Eu quero cadastrar alugueis de filmes
  Para controlar preços e datas de entregas

	@aluguel
  Cenario: Deve alugar um filme com sucesso
    Dado um filme
      | estoque |     2 |
      | preco   |     3 |
      | tipo    | comum |
    Quando alugar
    Então o preço do aluguel será de R$ 3
    E a data de entrega será em 1 dia
    E o estoque do filme será de 1 unidade

	@aluguel
  Cenario: Não deve alugar filme sem estoque
    Dado um filme com estoque de 0 unidades
    Quando alugar
    Então não será possivel por falta de estoque
    E o estoque do filme será de 0 unidade

	@aluguel
  Esquema do Cenário: Deve dar condições conforme tipo de aluguel
    Dado um filme com estoque de 2 unidades
    E que o preço do aluguel seja R$ <valor>
    E que o tipo de aluguel seja <tipo>
    Quando alugar
    Então o preço do aluguel será de R$ <valorTipo>
    E a data de entrega será em <qntDias> dias
    E a pontuação recebida será de <pontos> pontos

    Exemplos: 
      | valor | tipo      | valorTipo | qntDias | pontos |
      |     4 | extendido |         8 |       3 |      2 |
      |     4 | comum     |         4 |       1 |      1 |
      |     4 | semanal   |        12 |       7 |      3 |
