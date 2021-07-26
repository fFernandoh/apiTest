#language: pt

@all
Funcionalidade: deve registrar um novo usuario com sucesso

  Cenario: deve registrar um novo usuario com sucesso
    Dado que passei email e a senha
      | email              | password |
      | eve.holt@reqres.in | pistol   |
    Entao deve me retornar uma msg com sucesso

