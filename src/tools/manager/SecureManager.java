/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.User;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class SecureManager {
    private Scanner scanner = new Scanner(System.in);
    private UserManager userManager = new UserManager();
    
    public User checkTask(User[] users) {
        
        System.out.println("Задачи: ");
        System.out.println("0. Выход");
        
        System.out.println("1. Регестрация");
        System.out.println("2. Вход");
        System.out.println("Выберите задачу: ");
        int numTask = -1;
        do{
            String task = scanner.nextLine();
            try{
                numTask = Integer.parseInt(task);
                if (numTask >=0 && numTask <3){
                    if(numTask == 0){
                        System.out.println("Пока");
                        System.exit(0);
                        return null;
                    } else if(numTask == 1){
                        User user = userManager.addUser(users);
                        return user;
                        
                    }   else if(numTask == 2){
                        User user =  userManager.getUser(users);
                        return user;
                    }
                    
                }
                System.exit(0);
            }catch (Exception e){
                System.out.println(e);
                System.exit(0);
            }
           
        
}while(true);
        return null;
                }}