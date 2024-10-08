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

1 - Tempo de Execução

Utilidade: Avalia a eficiência do software em termos de tempo necessário para processar as entradas e gerar os resultados. É útil para comparar qual implementação é mais eficiente em termos de processamento, especialmente ao lidar com grandes volumes de dados.

Como medir: Medir o tempo que cada versão leva para processar uma lista de linhas e gerar o KWIC index.

2 - Uso de Memória

Utilidade: O primeiro modelo armazena as informações em formato mais cru (índices), enquanto o segundo encapsula os dados em estruturas de maior abstração. Comparar o uso de memória ajuda a entender o custo de abstração do segundo modelo.

Como medir: Observar o consumo de memória durante a execução de cada versão do software.

3 - Acoplamento

Utilidade: O acoplamento entre módulos reflete a dependência entre eles. Menos acoplamento é desejável, pois facilita a manutenção e a evolução do sistema.

Como medir: Calcular o número de dependências diretas entre os módulos e funções em cada versão.

4 - Coesão

Utilidade: Avalia o quanto um módulo tem uma responsabilidade única e bem definida. Alta coesão é desejável, pois melhora a compreensão e facilita a modificação de um módulo sem impacto em outros.

Como medir: Avaliar a coesão observando a especialização de cada módulo em sua tarefa.

5 - Complexidade Ciclomática

Utilidade: Mede a complexidade lógica do código, ou seja, o número de caminhos independentes que podem ser seguidos durante a execução. Menor complexidade indica um código mais fácil de manter e testar.

Como medir: Calcular a complexidade ciclomática analisando o diagrama de fluxo de controle do código.

6 - Facilidade de Manutenção

Utilidade: A manutenção do código envolve a facilidade de entender, modificar e corrigir problemas no software.

Como medir: Simular mudanças nas especificações do sistema e observar o número de módulos afetados.

7 - Facilidade de Testes Unitários

Utilidade: Um design modular bem feito deve facilitar a criação de testes unitários para cada módulo independentemente.

Como medir: Avaliar o esforço necessário para criar testes independentes para cada módulo e o número de dependências entre os testes.

8 - Escalabilidade

Utilidade: Avalia a capacidade de cada versão de lidar com aumentos no tamanho ou na complexidade dos dados de entrada.

Como medir: Testar cada versão com diferentes volumes de entrada e verificar o desempenho e a facilidade de adaptação a esses cenários.
