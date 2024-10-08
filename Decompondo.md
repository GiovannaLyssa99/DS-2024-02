## Etapas principais

1 - Implementar as duas versões do software propostas no artigo

2 - Comparar a qualidade e eficiência das duas versões segundo métricas pré-definidas

3 - Preparar e apresentar uma análise que apresenta os resultados dessa comparação

## Decomposição apresentada no artigo

### Primeiro modelo

1 - Input (Entrada)

Função: Recebe as linhas de entrada e as armazena na memória para processamento posterior.

2 - Circular Shift (Deslocamento Circular)

Função: Após o módulo de entrada, ele prepara um índice que indica o endereço do primeiro caractere de cada deslocamento circular de uma linha, sem realmente armazenar os deslocamentos circulares na memória. Ele armazena pares de dados (número da linha original e endereço inicial) para futuras operações.

3 - Alphabetising (Alfabetização)

Função: Usa as informações do módulo de deslocamento circular e reordena os deslocamentos circulares em ordem alfabética. O resultado é armazenado com a mesma estrutura usada no módulo anterior.

4 - Output (Saída)

Função: Usa os dados produzidos pelos módulos de entrada e alfabetização para gerar e exibir o resultado final.

5 - Master Control (Controle Mestre)

Função: Coordena a execução dos módulos anteriores, garantindo que os processos sejam chamados na ordem correta.

### Segundo Modelo

1 - Line Storage (Armazenamento de Linhas)

Função: Um módulo de armazenamento que define várias funções relacionadas a operações em uma linha, como adicionar caracteres, acessar caracteres em posições específicas e modificar o conteúdo de uma linha.

2 - Input (Entrada)

Função: Recebe as linhas de entrada e utiliza o módulo de armazenamento de linhas para armazenar essas linhas internamente.

3 - Circular Shifter (Deslocador Circular)

Função: Oferece funções que permitem obter os caracteres de uma linha em suas formas deslocadas circularmente.

4 - Alphabetiser (Alfabetizador)

Função: Contém funções para configurar a ordenação alfabética e obter o índice do deslocamento circular na ordem alfabética.

5 - Output (Saída)

Função: Gera a saída final, exibindo as linhas e seus deslocamentos circulares conforme necessário.

6 - Master Control (Controle Mestre)

Função: Coordena a interação entre os módulos e controla o fluxo de execução do sistema, semelhante ao primeiro modelo.

## Métricas de comparação

*Ainda sendo decididas*
