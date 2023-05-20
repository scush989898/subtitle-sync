# Sincronizador de Legendas

Esse foi um projeto que eu fiz para uso pessoal e acabei gostando bastante do resultado final. Basicamente ele pode ser bem útil pra quem está com problema em legendas atrasadas ou adiantadas de algum conteúdo.

## Como rodar o projeto:

1. Primeiro de tudo, clone esse repositório.
2. Entre na pasta raiz do projeto pelo terminal.
3. No arquivo "App.java" altere o valor da variável "filepath" para o path absoluto da legenda que você quer alterar, deixei um exemplo fictício de preenchimento. Altere o valor da variável "offsetInMiliseconds" para o valor em milisegundos que você deseja alterar.
4. Após mudar os valores acima, rode o script.
5. Será gerado um arquivo shifted.srt na pasta output no próprio diretório da aplicação.
6. Aqui já vai do jeito que você organiza suas coisas, eu gosto de copiar o resultado para a pasta do conteúdo e renomear o arquivo srt com o mesmo nome do contéudo para que o player identifique e já deixe habilitado a visualização.

## Observações finais:

Não testei no Sistema Operacional linux e também não testei para outros tipos de extensões de legenda.
Só testei para srt e no Sistema Operacional windows. 
Eu estou partindo do pressuposto que você já saiba ou esteja bem próximo do valor de atraso da legenda, se você não tiver idéia do valor, pode ir tentando até descobrir ou usar algum player de vídeo pra ir testando.
Também estou partindo do princípio que você atenda os requisitos pra rodar o programa, como a JVM e um editor pra mudar os nomes das variáveis.


