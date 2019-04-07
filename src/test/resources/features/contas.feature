#language: pt
Funcionalidade: Cadastro de contas

  Como um usuário 
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada

  @contas
  Esquema do Cenário: Deve vaidar as regras
    Dado que estou acessando a aplicação
    Quando informo o usuário "projeto@basico.com.br"
    E a senha "projeto@basico.com.br"
    E seleciono entrar
    Então visualizo a página inicial
    Quando seleciono Contas
    E seleciono Adicionar
    E informo a conta "<Conta>"
    E seleciono Salvar
    Então recebo a mensagem "<Mensagem>"

    Exemplos: 
      | Conta          | Mensagem                           |
      | Conta de Teste | Conta adicionada com sucesso!      |
      |                | Informe o nome da conta            |
      | Conta de Teste | Já existe uma conta com esse nome! |
