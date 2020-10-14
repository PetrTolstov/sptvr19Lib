/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.Reader;
import entity.User;
import java.util.Scanner;
import tools.savers.UserSaver;

/**
 *
 * @author user
 */
 class UserManager {
    Scanner scanner = new Scanner(System.in);   
    public User addUser(User[] users) {
        ReaderManager readerManager = new ReaderManager();
        Reader reader = readerManager.createReader();
 
        User user = new User();
        
        
        System.out.println("Создание User");
        
        System.out.println("Введите login:");
        user.setLogin(scanner.nextLine());
        
        System.out.println("Введите password:");
        user.setPassword(scanner.nextLine());

        user.setReader(reader);
        addUserToArray(user, users);
        return user;
    }
    public User getUser(User[] users) {
        for (int i = 0; i < 3; i++){
            if(i!= 0){
                System.out.println("Неправильно, попробуйте ещё раз:");
            }
            System.out.println("Введите login:");
            String userName = scanner.nextLine();
            User us;
            us = isQuil(users, userName);
            if(us == null){
                break;
            }
            
            
            System.out.println("Введите password:");
            String password = scanner.nextLine();
            
            if(!(password == us.getPassword())){
                break;
            }
            return us;
            
        }
        return null;
    }
    public void addUserToArray(User user, User[] users) {
        for(int i = 0; i < users.length; i++){
                        if(users[i] == null){
                            users[i] = user;
                            UserSaver saver1 = new UserSaver();
                            saver1.saveUser(users);
                            break;
                        }
                    }
    }
 public User isQuil(User[] users,String login) {
        int i = 0;
        for (User u : users) {
            if(u!= null){
                        if(u.getLogin() == login){
                            return u;
                        }
                    }}
        return null;
        
    }
}


