#language: pt

Funcionalidade: Adicionar usuários na lista

  Cenario: Adicionar usuários na lista com nome e a função
    Dado que eu passe alguns usuarios com nome e a funcao
      | firstName | job        |
      | Michael   | leader     |
      | Lindsay   | enginner   |
      | Tobias    | programmer |
      | Byron     | UX design  |
      | George    | QA         |
      | Rachel    | PO         |