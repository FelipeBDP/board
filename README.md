### Projeto Board Desafio DIO

## Sobre
Criando um board para gerenciar projetos que usam metodologia Kanban foi implementado em Java pelo professor José Luiz Abreu Cardoso Junior e colocado no repositório da DIO.
Segue o link do repositório original:https://github.com/digitalinnovationone/board

## Minha contribuição

Utilizando a versão 24 do Java fiz algumas modificações no código original. Segue abaixo as modificações:

1. Classe SpaceConfig
 Centralizei a lógica de ler a String "5,true" em um único lugar, evitando que o código ficasse "sujo" com split e parseInt espalhados por todo o projeto.

2. Classe BoardService
 Refatorei para usar o novo SpaceConfig e adicionei métodos para mudar ou limpar valores.

3. Classe Main (CLI)
Substituí a referência direta ao Board pelo BoardService.

4. Classe  UIMain (Interface Gráfica)
Adicionei o suporte à variável de ambiente SUDOKU_CONFIG.

5. Classe NotifierService
Removi a inicialização antiga com chaves duplas {{ }} e usei um EnumMap.

6. Classe MainScreen
Apliquei Unnamed Variables (Java 21+). Troquei o parâmetro e dos botões (que não era usado) por _.
