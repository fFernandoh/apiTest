#language: pt

@all
Funcionalidade: Efetuar o login no sistema

  Cenario: logar na pagina e retonar o token
    Dado que passei o usuario e senha
      | username           | password   |
      | eve.holt@reqres.in | cityslicka |
    Entao devo logar no sistema e retornar um token
