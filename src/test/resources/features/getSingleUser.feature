#language: pt

@api
Funcionalidade: deve retornar o usuário

  Esquema do Cenario: deve retornar o usuario
    Dado que passei o id <id> do usuario
    Entao deve me retornar os dados do usuario informado
    Exemplos:
      | id |
      | 5  |