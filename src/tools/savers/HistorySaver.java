/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.savers;

import entity.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import entity.History;

/**
 *
 * @author user
 */
public class HistorySaver {
    private String fileName = "history";
    

    

    public void saveBook(History[] histories) {
       FileOutputStream fos = null;
        ObjectOutputStream oos = null;
            
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(histories);
            oos.flush();
            System.out.print("Книга сохранена");
        } catch (FileNotFoundException ex) {
            System.out.print("Не найден файл");
        } catch (IOException ex) {
            System.out.print("Ошибка ввода-вывода");
        }
    }

    public History[] loadFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
            try {
                fis = new FileInputStream(fileName);
                ois = new ObjectInputStream(fis);
                return (History[]) ois.readObject();
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
    
    

