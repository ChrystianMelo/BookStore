# BookStore

## Membros do Grupo
- Chrystian Paulo Ferreira de Melo
- Sanny Cristiane Moreira de Sales

## Descrição do Sistema
Este projeto consiste em um sistema de gerenciamento de biblioteca. O sistema permite aos usuários realizar operações como adicionar, remover e pesquisar livros, bem como gerenciar informações dos usuários da biblioteca. A aplicação foi desenvolvida utilizando a linguagem Java, com o gerenciamento de dependências realizado pelo Maven e integração contínua configurada via GitHub Actions.

### Funcionalidades Principais:
- **Cadastrar Livro**: Permite adicionar novos livros ao catálogo da biblioteca.
- **Deletar Livro**: Permite remover livros existentes do catálogo.
- **Adicionar ao Carrinho**: Permite adicionar livros ao carrinho de compras.
- **Deletar do Carrinho**: Permite remover livros do carrinho de compras.
- **Fechar Carrinho**: Permite finalizar a compra dos livros presentes no carrinho.
- **Ver Livros Disponíveis**: Permite visualizar todos os livros disponíveis no catálogo.
- **Favoritar Item**: Permite marcar livros como favoritos para fácil acesso posterior.
- **Ver Detalhes sobre o Livro**: Permite visualizar detalhes específicos sobre um livro, como título, autor, ISBN, descrição e disponibilidade.

## Tecnologias Utilizadas

### Java
A linguagem principal utilizada para o desenvolvimento do sistema é o Java, uma linguagem de programação de propósito geral, orientada a objetos e amplamente utilizada para desenvolver aplicações robustas e seguras.

### Maven
Maven é uma ferramenta de automação de compilação e gerenciamento de dependências utilizada no projeto. O Maven facilita o processo de construção, documentação e gestão de projetos Java, garantindo que todas as bibliotecas necessárias estejam disponíveis e atualizadas.

#### Estrutura do Projeto com Maven
O projeto segue a estrutura padrão do Maven:
<pre>
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       └── java
├── pom.xml
└── README.md
</pre>


### GitHub Actions
GitHub Actions é uma plataforma de integração contínua e entrega contínua (CI/CD) que permite automatizar fluxos de trabalho de desenvolvimento de software diretamente no repositório GitHub. Neste projeto, GitHub Actions é usado para automatizar o processo de build e testes sempre que houver um push ou pull request no repositório.

#### Configuração do GitHub Actions
O arquivo de configuração do GitHub Actions ([maven.yml](.github/workflows/maven.yml)) está configurado para:
- Executar a build do projeto utilizando Maven.
- Executar testes automatizados para garantir que nenhuma funcionalidade existente seja quebrada com novas alterações.
