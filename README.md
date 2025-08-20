# MUSSUMES

## Introdução

A Mussumes é a linguagem de programação baseada nas falas do ilustre personagem Mussum, interpretado por Antônio Carlos Bernardes Gomes, grande humorista, ator, músico e compositor brasileiro.
Baseado no mussumipsum.com de Diego Esteves, o melhor lorem ipsum do mundis!

## Estrutura do Projeto

O projeto é composto dos seguintes conteúdos:

- `src`: contém o código-fonte principal do projeto.
  - `files`: arquivos de entrada com extensão `.musum` que serão interpretados pelo projeto.
  - `main`: arquivo Java responsável pela execução principal do interpretador.
  - `parser`: aquivos gerados pelo ANTLR a partir da gramática, responsáveis pelo reconhecimento da linguagem.
- `lib`: biblioteca necessária para o funcionamento do ANTLR (por exemplo, `antlr-4.13.2-complete.jar`).
- `bin`: arquivos compilados (.class) do projeto.
- `Mussumes.g4`: arquivo de gramática que define as regras da linguagem Mussumes.

## Como executar (Windows/VSCode)
- Baixe o Visual Studio Code;
  Link: https://code.visualstudio.com/docs/setup/windows#_install-vs-code-on-windows
- Baixe e instale o JDK, coloque-o nas variáveis de ambiente;
  Link: https://www.oracle.com/java/technologies/downloads/#jdk24-windows
  Path: C:\Program Files\Java\jdk-24\bin
- Baixe e instale o Coding Pack for Java;
  Link: https://code.visualstudio.com/docs/java/java-tutorial
- Instale as extensões Code Runner e Extension Pack for Java no VSCode;
- Baixe o antlr-4.13.2-complete.jar e insira-o na pasta lib;
  Link: https://www.antlr.org/download/antlr-4.13.2-complete.jar
- Coloque os arquivos a serem interpretados em `files`;
- Execute o arquivo MainClass.java com o Code Runner.

## Como editar a Gramática (Windows)
- Faça edições no arquivo `Mussumes.g4` e execute o comando abaixo:
  java -cp ".;lib/antlr-4.13.2-complete.jar" org.antlr.v4.Tool .\Mussumes.g4 -package parser -o .\src\parser\

## Como editar a Gramática (MacOS/Linux) e gerar/regenerar o parser/lexer
- Faça edições no arquivo `Mussumes.g4` e execute o comando abaixo:
  java -cp "./lib/antlr-4.13.2-complete.jar" org.antlr.v4.Tool -Dlanguage=Java -visitor -package parser -o ./src/parser   ./Mussumes.g4

## Como recompilar o compilador (MacOS/Linux)
- Execute o comando abaixo:
  mkdir bin
  javac -cp "./lib/antlr-4.13.2-complete.jar:./src" -d ./bin $(find ./src -name "*.java")

## Como Gerar o código do programa mussum -> Java
- Execute o comando:
  java -cp "./lib/antlr-4.13.2-complete.jar:./bin" main.MainClass

## Como compilar/rodar o programa gerado
- Execute os comandos em sequência:
  javac MussumProgram.java
  java MussumProgram