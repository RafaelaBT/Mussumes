package main;

import java.io.File;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import exceptions.SemanticException;
import parser.MussumesLexer;
import parser.MussumesParser;


/* Classe responsável por criar a interação com o usuário
 * instanciando o parse e apontando para o arquivo fonte.
 * 
 * Arquivo fonte: extensao .mussum
 * 
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("=================================== MUSSUMÊS =====================================");
        System.out.println("Bota 1 metro de cachacis aí pra viagem que quem manda na minha terra sou euzis!!");
        System.out.println("Quem num gosta di mé, boa gentis num é.");
        System.out.println("__________________________________________________________________________________");

        // Cria a pasta de arquivos se não existir
        String folderPath = "src/files";
        File folder = new File(folderPath);

        // Verifica se a pasta existe e se está vazia
        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("Erruvis: Pasta \"" + folderPath + "\" não existis.");
            return;
        }
        String[] files = folder.list((dir, name) -> name.endsWith(".mussum"));
        if (files == null || files.length == 0) {
            System.err.println("Erruvis: Nenhum arquivus .mussum encontradus na pasta \"" + folderPath + "\".");
            System.out.println("Si num tem leite então bota uma pinga aí cumpadi!");
            System.out.println("Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis.");
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
                System.out.println("Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo!");
                System.out.println("Mais vale um bebadis conhecidiss, que um alcoolatra anonimis.");
                parser.exibeComandos();
            } catch (SemanticException e) {
                // Exceção para erros semânticos
                System.err.println("Num tendi nada! Erruvis de semantiquis encontradus: " + e.getMessage());
                System.out.println("A ordem dos tratores altera o pão duris.");
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