/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.savers;

import entity.Book;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author user
 */
public class ReaderSaver {
    private String fileName = "readers";

    public void saveReader(Reader[] readers) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
            
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(readers);
            oos.flush();
            System.out.println("Пользователь сохранен");
        } catch (FileNotFoundException ex) {
            System.out.println("Не найден файл");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода-вывода");
        }
    }

    public Reader[] loadFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
            try {
                fis = new FileInputStream(fileName);
                ois = new ObjectInputStream(fis);
                return (Reader[]) ois.readObject();
            } catch (FileNotFoundException ex) {
                System.out.print("Не найден файл");
            } catch (IOException ex) {
                System.out.print("Ошибка ввода-вывода");
            } catch (ClassNotFoundException ex) {
                System.out.print("Ошибка не найден класс");
            }
        return null;
    }
    
}
