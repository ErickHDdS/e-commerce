# Projeto E-Commerce Qualidade de Software

Projeto realizado para a disciplina de Qualidade de Software, ministrado pela Professora Kecia Ferreira no CEFET-MG.
O objetivo do projeto é apresentar um e-commerce simples e funcional, e principalmente respeitar os princípios de Qualidade de Software.

## Links Importantes
- [Diagrama Final](https://github.com/ErickHDdS/e-coomerce/blob/main/uml_diagram_pdf_v_1_1.pdf)
- [Tópicos de Qualidade de Software Abordados no Projeto](https://github.com/ErickHDdS/e-coomerce/tree/main/ecommerce/src)

## Funcionalidades 

- Criar Usuários
- Listar todos os Usuários
- Criar Produtos
- Listar todos os Produtos
- Criar um Pedido com Produtos para um Usuário

## Pré-Requisitos - Execução

1. [Java JDK](https://www.oracle.com/br/java/)
2. [Java JRE](https://www.java.com/pt-BR/)
3. [Maven](https://maven.apache.org/)

## Passo a Passo - Execução

1. Clonar o Repositório através do terminal
   ```
   git clone https://github.com/ErickHDdS/e-coomerce
   ```
2. Entrar na pasta clonada
   ```
   cd e-coomerce/ecommerce
   ```
3. Executar o programa
   ```
   mvn spring-boot:run
   ```
4. Acesse o Banco de Dados para validar os cadastros realizados
   - http://localhost:8080/h2-console
   - **JDBC URL**: jdbc:h2:mem:ecommercedb 
   - **USER**: sa
   - **SENHA**: vazio

## Desenvolvedores

[Erick Henrique](https://github.com/ErickHDdS) <br />
[Júlia Nunes](https://github.com/Julia-Nunes) <br />
[Gabriel Schmidt](https://github.com/zgabrielschmidt) <br />
