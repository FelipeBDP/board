### Projeto Board Desafio DIO

## Sobre
Criando um board para gerenciar projetos que usam metodologia Kanban foi implementado em Java pelo professor José Luiz Abreu Cardoso Junior e colocado no repositório da DIO.
Segue o link do repositório original:https://github.com/digitalinnovationone/board

## Minha contribuição

Utilizando a versão 24 do Java fiz algumas modificações no código original. Segue abaixo as modificações:

1) MigrationStrategy
O construtor recebia uma Connection mas o método criava outra via getConnection(). Toda vez que o app subia, eram abertas duas conexões ao banco — a injetada ficava ociosa e fechada logo após, enquanto a segunda executava as migrations.

2) CardService
 sem a validação de CANCEL, o método executava moveToColumn(...) mesmo com o card já cancelado — resultado: UPDATE silencioso no banco sem erro para o usuário. O Stream.filter removido era lógica copiada de moveToNextColumn() (busca por "próxima coluna por ordem") que não faz sentido semântico em cancel(), onde o destino é sempre a coluna CANCEL independente de ordem.

3) BlockDAO
unblock_reason pode ser NULL num bloqueio já encerrado (quando o usuário não forneceu motivo de desbloqueio). Filtrar por unblock_reason IS NULL atingiria registros já fechados, corrompendo o histórico. A coluna correta é unblocked_at IS NULL: se tem valor, o bloqueio foi encerrado; se é NULL, ainda está ativo.

4) BoardDAO e CardDAO
sem final, o campo pode ser reatribuído. @AllArgsConstructor gera construtor para todos os campos sem garantir imutabilidade. @requiredargsconstructor gera construtor apenas para campos final/@nonnull — padrão já usado por BoardColumnDAO e BlockDAO. Consistência previne uma classe inteira de bugs silenciosos.

5) BoardColumnKindEnum
Enum.valueOf() usa o HashMap interno da JVM construído na inicialização da classe — lookup O(1). O Stream.of(values()).filter() é busca linear O(n) com alocação de Stream a cada chamada. Este método é invocado em cada linha lida do banco (findByBoardId, findByBoardIdWithDetails, findById).
