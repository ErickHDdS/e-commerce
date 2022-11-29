# Tópicos de Qualidade de Software Abordados no Projeto

### Contrato de Classe
A classe fornecedora compromete-se a fornecer determinados serviços a partir de uma especificação do problema e publica a interface a ser utilizada por aquelas que precisarem utilizar os serviços.
Em nosso projeto é possível perceber que cada uma das classes modelos possui um serviço específico ou serviços do relacionamento entre elas.

### Modelo MVC
O MVC separa o código da interface de usuário (Visão + Controlador) e o código da lógica do domínio do problema (Modelo).
Em nosso projeto, apesar te termos somente o back-end, o código foi estruturado dessa forma, dando liberdade para o desenvolvimento de uma camada de Visão em cima da estrutura atual.

### SRP — Single Responsibility Principle
Esse princípio declara que uma classe deve ser especializada em um único assunto e possuir apenas uma responsabilidade dentro do software, ou seja, a classe deve ter uma única tarefa ou ação para executar.
Em nosso projeto todas as classes do modelo respeitam o princípio.

### ISP — Interface Segregation Principle
Princípio da Segregação da Interface — Uma classe não deve ser forçada a implementar interfaces e métodos que não irão utilizar. Esse princípio basicamente diz que é melhor criar interfaces mais específicas ao invés de termos uma única interface genérica.
Em nosso projeto todos os serviços são implementações das suas Interfaces.
