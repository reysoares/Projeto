Projeto: Sistema de Gerenciamento de Inventário de Loja
Descrição do Projeto:
Desenvolver um sistema para gerenciar o inventário de uma loja, permitindo a adição e remoção de produtos, visualização de estoque, e geração de relatórios sobre o inventário. O sistema também permitirá a visualização e atualização das informações em uma interface gráfica e se conectará a um banco de dados para armazenar as informações do inventário.

Padrões de Projeto Propostos:
Padrão Singleton:

Uso: Garantir que haja apenas uma instância do gerenciador de configuração do sistema, responsável por carregar e fornecer configurações globais, como parâmetros de conexão ao banco de dados e configurações de interface.
Padrões Comportamentais:

Observer: Notificar os usuários ou administradores quando o estoque de um produto atinge um nível crítico ou quando um produto é atualizado.
Command: Encapsular operações de adição e remoção de produtos no inventário, possibilitando desfazer e refazer essas operações.
Strategy: Implementar diferentes estratégias de cálculo de preços ou descontos, permitindo flexibilidade na aplicação de regras de preços.
Padrões de Criação:

Factory Method: Criar diferentes tipos de produtos e categorias de produtos. Por exemplo, uma fábrica de produtos pode criar objetos de diferentes tipos de produtos, como eletrônicos, roupas, etc.
Builder: Construir objetos complexos de produtos, como produtos com várias opções e especificações. Por exemplo, um produto eletrônico pode ter diferentes configurações que são construídas passo a passo.
Interface Gráfica:

Descrição: Desenvolver uma interface gráfica utilizando JavaFX ou Swing para permitir a interação do usuário com o sistema. A interface deve incluir funcionalidades para adicionar e remover produtos, visualizar o estoque atual, e gerar relatórios de inventário.
Conexão com Banco de Dados (JDBC):

Descrição: Implementar a conexão com um banco de dados usando JDBC para armazenar informações sobre produtos, categorias e histórico de transações. O banco de dados deve suportar operações de consulta, inserção, atualização e exclusão de dados relacionados ao inventário.
Estrutura do Projeto:
Padrão Singleton:

Classe ConfigurationManager: Gerencia a configuração global do sistema, como parâmetros de conexão ao banco de dados e preferências do usuário.
Padrões Comportamentais:

Observer:
Classe StockObserver: Observa mudanças no estoque e notifica os administradores.
Command:
Classe AddProductCommand e RemoveProductCommand: Encapsula as operações de adicionar e remover produtos do inventário.
Strategy:
Classe PricingStrategy: Interface para diferentes estratégias de cálculo de preços. Implementações podem incluir DiscountPricingStrategy, SeasonalPricingStrategy, etc.
Padrões de Criação:

Factory Method:
Classe ProductFactory: Cria diferentes tipos de produtos com base nas necessidades do sistema.
Builder:
Classe ProductBuilder: Permite a construção de produtos com várias especificações e opções.
Interface Gráfica:

Classe InventoryUI: Interface gráfica desenvolvida usando JavaFX ou Swing para interagir com o sistema de inventário, permitindo operações como adicionar produtos, visualizar estoque, e gerar relatórios.
Conexão com Banco de Dados (JDBC):

Classe DatabaseManager: Gerencia a conexão com o banco de dados e realiza operações CRUD (Create, Read, Update, Delete) sobre os dados do inventário.
Entregáveis:
Slide da Apresentação:

Definições dos padrões de projeto utilizados.
Diagramas (diagrama de classes, diagrama de sequência, diagrama de estado) mostrando a aplicação dos padrões.
Trechos de código para ilustrar a implementação dos padrões.
Link do Repositório no GitHub:

Código fonte completo do projeto.
Documentação detalhada sobre a estrutura do sistema, configuração do banco de dados, e instruções para execução.


