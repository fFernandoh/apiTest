#language: pt

@all
Funcionalidade: não consegui efetuar o login por falta da senha

  Cenario: não conseguir efetuar o login devido a falta da senha
    Dado que informei o email
      | email       |
      | sydney@fife |
    Então deve me retornar uma mensagem de erro informando que falta a senha