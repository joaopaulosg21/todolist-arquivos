package main;

import interfaces.IToDoList;
import java.io.*;

public class ToDoList implements IToDoList{
    private String user;
    private String pathPendentes;
    private String pathConcluidas;

    public ToDoList(String user) {
        this.user = user;
        new File(this.user).mkdir();
        new File(this.user+"/pendentes").mkdir();
        new File(this.user+"/concluidas").mkdir();
        this.pathPendentes = this.user+"/pendentes/";
        this.pathConcluidas = this.user+"/concluidas/";
    }

    public void AddToDo(String data,String titulo,String desc) throws IOException{
        FileWriter fw = new FileWriter(this.pathPendentes + titulo + ".txt",true);
        fw.write("#"+data+"\n"+desc+"\n");
        fw.close();
    }

    public void getPendentes(){
        File f = new File(this.pathPendentes);
        for(String file:f.list()) {
            try{
                BufferedReader br = new BufferedReader(new FileReader(this.pathPendentes+file));
                while(br.ready()) {
                    System.out.println(br.readLine());
                }
                System.out.println();
                br.close();
            }catch(IOException exc) {
                System.out.println("ARQUIVO " + file + " NÃO EXISTE");
            }
        }
    }

    public void ConcluirToDo(String titulo){
        try{
            BufferedReader br = new BufferedReader(new FileReader(this.pathPendentes + titulo + ".txt"));
            FileWriter fw = new FileWriter(this.pathConcluidas + titulo + ".txt");
            while(br.ready()) {
                fw.write(br.readLine() + "\n");
            }
            new File(this.pathPendentes + titulo + ".txt").delete();
            fw.close();
            br.close();
            System.out.println();
            System.out.println("TAREFA " + titulo + " CONCLUIDA");
            System.out.println();
        }catch(IOException exc) {
            System.out.println();
            System.out.println("ARQUIVO " + titulo + " NÃO EXISTE");
            System.out.println();
        }
    }

    public void getConcluidas() {
        File f = new File(this.pathConcluidas);
        for(String file:f.list()) {
            try{
                BufferedReader br = new BufferedReader(new FileReader(this.pathConcluidas+file));
                while(br.ready()) {
                    System.out.println(br.readLine());
                }
                System.out.println();
                br.close();
            }catch(IOException exc) {
                System.out.println("ARQUIVO " + file + " NÃO EXISTE");
            }
        }
    }
}
