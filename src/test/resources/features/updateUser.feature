#language: pt

@all
Funcionalidade: devo atualizar os dados do usuario

  Esquema do Cenario: devo atualizar os dados do usuario
    Dado que informei a pagina <id> onde deve ser atualizado
    Entao deve me retornar uma msg com o nome, trabalho e a data da atualizacao
    Exemplos:
      | id |
      | 2  |