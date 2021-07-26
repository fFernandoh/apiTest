#language: pt

@all
Funcionalidade: Deletar usuário

  Cenario: deletar um usuário e retornar um status code 204
    Dado que fiz um delete
      | 2 |
    Entao deve me retornar um status code ok