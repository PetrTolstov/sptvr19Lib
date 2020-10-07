/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class BookSaver {
        private String fileName = "books";

    public void saveBook(Book[] books) {
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.flush();
            System.out.print("Книга сохранена");
        } catch (FileNotFoundException ex) {
            System.out.print("Не найден файл");
        } catch (IOException ex) {
            System.out.print("Ошибка ввода-вывода");
        }
    }
    
    public Book[] loadFile(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
            try {
                fis = new FileInputStream("books");
                ois = new ObjectInputStream(fis);
                return (Book[]) ois.readObject();
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
