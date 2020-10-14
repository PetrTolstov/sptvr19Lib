/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19library;


import tools.manager.SecureManager;
import tools.manager.HistoryManager;
import entity.Reader;
import entity.Book;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tools.savers.BookSaver;
import entity.History;
import entity.User;
import tools.savers.HistorySaver;

import tools.manager.ReaderManager;
import tools.savers.ReaderSaver;
import tools.manager.BookManager;
import tools.savers.UserSaver;
/**
 *
 * @author sillamae kutsekool
 */
class App {
    private Book[] books = new Book[100];
    private Reader[] readers = new Reader[100];
    private History[] histories = new History[100];
    private  User[] users = new User[100];
    private SecureManager securiteManager = new SecureManager();
    ReaderManager readerManager = new ReaderManager();
    HistoryManager hMan = new HistoryManager();

    private User loginUser;
    
    
    public App(){
        BookSaver saver = new BookSaver();
       books = saver.loadFile();
        
        ReaderSaver rsaver = new ReaderSaver();
        //readers = rsaver.loadFile();
        
        HistorySaver hsaver = new HistorySaver();
        //histories = hsaver.loadFile();
        
        UserSaver usaver = new UserSaver(); 
        users = usaver.loadFile();
    }
    
    public void run(){
        this.loginUser = securiteManager.checkTask(users);
       
        UserSaver usaver = new UserSaver();
        
        usaver.saveUser(users);
        System.out.println("--- Библиотека ---");
        boolean repeat = true;
        do{
            System.out.println("Список задач: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Посмотреть список книг");
            System.out.println("3. Зарегистрировать нового читателя");
            System.out.println("4. Список читателей");
            
            System.out.println("5. Выдать книгу читателю");
            System.out.println("6. Вернуть книгу в библиотеку");
            System.out.println("7. Журнал");
            System.out.print("Выберите задачу: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("---- Конец программы ----");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("---- Добавить новую книгу ----");
                    
                    BookManager man = new BookManager();
                    Book book = man.createBook();

                    man.addBookToArra(book, books);
                    BookSaver saver = new BookSaver();
                    saver.saveBook(books);
                    break;     
                    
                case "2":
                    System.out.println("--- Cписок книг ---");
                    BookManager man1 = new BookManager();
                    man1.printListBooks(books);
                    break;
                    
                case "3":
                    System.out.println("--- Зарегистрировать нового читателя ---");
                    
                    Reader reader = readerManager.createReader();
                    readerManager.addReaderToArray(reader,  readers);
                    break;
                    
                case "4":
                    System.out.println("--- Список читателей ---");
                    readerManager.printListReader(readers);
                    break;
                    
                case "5":
                    System.out.println("--- Cписок книг ---");
                    BookManager man2 = new BookManager();
                    man2.printListBooks(books);
                    
                    System.out.println("Выберете книгу: ");
                    int bookNumber = scanner.nextInt();
                    book = books[bookNumber-1];
                    
                    System.out.println("--- Список читателей ---");
                    int k = 0;
                    readerManager.printListReader(readers);

                    
                    System.out.println("Выберете Читателя: ");
                    int readerNumber = scanner.nextInt();
                    reader = readers[readerNumber-1];
                    Calendar c = new GregorianCalendar();
                    History history = new History();
                    history.setBook(book);
                    history.setReader(reader);
                    history.setTakeOnDate(c.getTime());

                    hMan.saveHistory(history, histories);
                    break;
                    
                case "6":
                    System.out.println("--- Cписок книг ---");
                   
                   BookManager Bman = new BookManager();
                    Bman.printListBooks(books);
                    System.out.println("Выберете книгу: ");
                    int bNumber = scanner.nextInt();
                    histories[bNumber-1] = null;
                    break;
                    
                case "7":
                    System.out.println("--- Журнал ---");
                    
                    hMan.printListHistory(histories);
              
                    break;
                default:
                    System.out.println("Нет такой задачи.");
            }
        }while(repeat);
    }
}
