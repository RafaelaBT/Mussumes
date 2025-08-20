import java.util.*;

public class MussumProgram {
   private static final Scanner _keyb = new Scanner(System.in);

   public static void main(String[] args) throws Exception {
      int idade, ano, i;
      float altura, peso;
      String saudacao, nome;
      boolean aprovado, maioridade;
      idade = Integer.parseInt(_keyb.nextLine());
      altura = Float.parseFloat(_keyb.nextLine());
      nome = _keyb.nextLine();
      aprovado = Boolean.parseBoolean(_keyb.nextLine());
      ano = idade + 10;
      peso = altura * 2.5f;
      saudacao = "Olá, ";
      aprovado = true;
      maioridade = (idade > 18) && aprovado;
      if (maioridade) {
         System.out.println("Pode entrar na sessão.");
      } else {
         if (aprovado) {
            System.out.println("Aprovado, mas menor de idade.");
         } else {
            System.out.println("Não aprovado.");
         }
      }
      System.out.println(saudacao);
      System.out.println(nome);
      System.out.println(" terá ");
      System.out.println(ano);
      System.out.println(" anos em 10 anos.");
      System.out.println(" Altura vezes 2.5: ");
      System.out.println(peso);
      System.out.println(" Aprovado? ");
      System.out.println(aprovado);
      System.out.println(" Maior de idade e aprovado? ");
      System.out.println(maioridade);
      peso = (idade + 2) * 1.1f;
      System.out.println("Peso ajustado: ");
      System.out.println(peso);
      while (idade < 18) {
         System.out.println("Idade ainda menor que 18");
         idade = idade + 1;
      }
      while (true) {
         System.out.println("Executando pelo menos uma vez");
         peso = peso + 0.5f;
         if (!(peso < 70)) {
            break;
         }
      }
      if (aprovado && maioridade) {
         System.out.println("Pode entrar na festa!");
      } else {
         if (aprovado) {
            System.out.println("Pode entrar, mas cuidado!");
         } else {
            System.out.println("Não pode entrar!");
         }
      }
      i = 0;
      while (i < 5) {
         System.out.println(i);
         i = i + 1;
      }
   }
}
