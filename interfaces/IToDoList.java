package interfaces;

import java.io.*;

public interface IToDoList {
    public void getPendentes();
    
    public void AddToDo(String data,String titulo,String desc) throws IOException;

    public void ConcluirToDo(String titulo);

    public void getConcluidas();
}