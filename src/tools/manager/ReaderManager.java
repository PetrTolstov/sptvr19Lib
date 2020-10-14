/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import tools.savers.ReaderSaver;
import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ReaderManager {
    public Reader createReader(){
        Reader reader = new Reader();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Создание читателя");
        
        System.out.println("Введите имя:");
        reader.setName(scanner.nextLine());
        
        System.out.println("Введите фамилию:");
        reader.setLastname(scanner.nextLine());
        
        
        System.out.println("Введите номер:");
        reader.setPhone(scanner.nextLine());
        return reader;
    }

    public void addReaderToArray(Reader reader, Reader[] readers) {
        for(int i = 0; i < readers.length; i++){
                        if(readers[i] == null){
                            readers[i] = reader;
                            ReaderSaver saver1 = new ReaderSaver();
                            saver1.saveReader(readers);
                            break;
                        }
                    }
    }

    public void printListReader(Reader[] readers) {
        int i = 0;
        for (Reader r : readers) {
                        if(r != null){
                            System.out.println(i+1+". "+r.toString());
                            i++;
                        }
                    }
    }
}

