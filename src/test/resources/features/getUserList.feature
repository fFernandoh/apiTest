#language: pt

@all
Funcionalidade: deve retornar o usuário

  Esquema do Cenario: deve retornar a lista de usuarios
    Dado que passei o id <id> da pagina de usuarios
    Entao deve me retornar os dados dos usuarios da pagina
    Exemplos:
      | id |
      | 2  |