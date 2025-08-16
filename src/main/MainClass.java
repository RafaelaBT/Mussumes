package main;

import java.io.File;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.MussumesLexer;
import parser.MussumesParser;


/* Classe responsável por criar a interação com o usuário
 * instanciando o parse e apontando para o arquivo fonte.
 * 
 * Arquivo fonte: extensao .musum
 * 
 */
public class MainClass {
    public static void main(String[] args) {

        String folderPath = "src/files";
        File folder = new File(folderPath);

        // Verifica se a pasta existe e se está vazia
        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("Erruvis: Pasta \"" + folderPath + "\" não existis.");
            return;
        }
        String[] files = folder.list((dir, name) -> name.endsWith(".musum"));
        if (files == null || files.length == 0) {
            System.err.println("Erruvis: Nenhum arquivus .musum encontradus na pasta \"" + folderPath + "\".");
            return;
        }

        for (String fileName : files) {
            String filePath = folderPath + "/" + fileName;
            try {
                // Cria o lexer a partir do arquivo fornecido
                MussumesLexer lexer = new MussumesLexer(CharStreams.fromFileName(filePath));

                // Cria o parser com o token stream do lexer
                MussumesParser parser = new MussumesParser(new CommonTokenStream(lexer)); 
                
                // Inicia o parsing do arquivo
                parser.prog();
                System.out.println("Arquivus " + fileName + " processadus com sucessis!");

            } catch (java.io.IOException e) {
                // Exceção para erros de leitura de arquivo
                System.err.println("Erruvis ao levis arquivus: " + e.getMessage());
            } catch (Exception e) {
                // Exceção para outros erros durante o parsing
                System.err.println("Erruvis ao processadus arquivus: " + e.getMessage());
            }
        }
    }
}