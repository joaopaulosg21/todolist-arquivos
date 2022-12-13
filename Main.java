import java.io.*;
import java.util.Scanner;

import main.ToDoList;

public class Main {
    public static void main(String[] args) throws IOException{
        ToDoList lista = new ToDoList("user");
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite a opção desejada: ");
        System.out.println("1 - Adicionar nova tarefa");
        System.out.println("2 - Concluir tarefa");
        System.out.println("3 - Ver pendentes");
        System.out.println("4 - Ver concluidas");
        System.out.println("5 - Para sair");
        System.out.print("opcao: ");
        int opcao = scan.nextInt();

        while(opcao != 5) {
            switch(opcao) {
                case 1:
                    System.out.print("Digite a data: ");
                    String data = br.readLine();
                    System.out.print("O titulo: ");
                    String titulo = br.readLine();
                    System.out.println("Descrição: ");
                    String desc = br.readLine();
                    lista.AddToDo(data,titulo,desc);
                break;

                case 2:
                    System.out.print("Digite o titulo: ");
                    titulo = br.readLine();
                    lista.ConcluirToDo(titulo);
                break;
                
                case 3:
                    System.out.println();
                    System.out.println("TAREFAS PENDENTES: \n");
                    lista.getPendentes();
                    System.out.println("FIM DAS PENDENTES.\n");
                break;

                case 4:
                    System.out.println();
                    System.out.println("TAREFAS CONCLUIDAS: \n");
                    lista.getConcluidas();
                    System.out.println("FIM DAS CONCLUIDAS.\n");
                    break;
            }
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Adicionar nova tarefa");
            System.out.println("2 - Concluir tarefa");
            System.out.println("3 - Ver pendentes");
            System.out.println("4 - Ver concluidas");
            System.out.println("5 - Para sair");
            System.out.print("opcao: ");
            opcao = scan.nextInt();
        }
        scan.close();
    }
}
