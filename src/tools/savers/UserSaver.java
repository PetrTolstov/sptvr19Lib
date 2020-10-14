/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.savers;

import entity.Reader;
import entity.User;
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
public class UserSaver {
    private String fileName = "readers";

    public void saveUser(User[] users) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
            
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.flush();
            System.out.println("Пользователь сохранен");
        } catch (FileNotFoundException ex) {
            System.out.println("Не найден файл");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода-вывода");
        }
    }

    public User[] loadFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
            try {
                fis = new FileInputStream(fileName);
                ois = new ObjectInputStream(fis);
                return (User[]) ois.readObject();
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

