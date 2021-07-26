#language: pt

@all
Funcionalidade: Efetuar o login no sistema

  Cenario: logar na página e retonar o token
    Dado que passei o usuário e senha
      | username           | password   |
      | eve.holt@reqres.in | cityslicka |
    Então devo logar no sistema e retornar um token
