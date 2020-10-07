/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19library;


import entity.Reader;
import entity.Book;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tools.BookFactory;
import tools.BookSaver;
import tools.History;
import tools.HistorySaver;
import tools.ReaderFactory;
import tools.ReaderSaver;

/**
 *
 * @author sillamae kutsekool
 */
class App {
    private Book[] books = new Book[100];
    private Reader[] readers = new Reader[100];
    private History[] histories = new History[100];
    
    public App(){
        BookSaver saver = new BookSaver();
       books = saver.loadFile();
        
        ReaderSaver rsaver = new ReaderSaver();
        readers = rsaver.loadFile();
        
        HistorySaver hsaver = new HistorySaver();
        //histories = hsaver.loadFile();
    }
    
    public void run(){
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
                    BookFactory bookFactory = new BookFactory();
                    Book book = bookFactory.createBook();
                    
                    // создадим объект книги
                    for(int i = 0; i < books.length; i++){
                        if(books[i] == null){
                            books[i] = book;
                            BookSaver saver = new BookSaver();
                            saver.saveBook(books);
                            break;
                        }
                    }
                    
                    
                    break;
                case "2":
                    System.out.println("--- Cписок книг ---");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i]!= null){
                            System.out.printf("%3d. Название книги: %s%nАвтор: %s%n"
                                    ,i+1
                                    ,books[i].getName()
                                    ,books[i].getAuthor()
                            );
                            System.out.println("--------------------------------");
                            
                        }
                    }
                    break;
                case "3":
                    System.out.println("--- Зарегистрировать нового читателя ---");
                    ReaderFactory readerFactory = new ReaderFactory();
                    Reader reader = readerFactory.createReader();
                    
                    // создадим объект книги
                    for(int i = 0; i < readers.length; i++){
                        if(readers[i] == null){
                            readers[i] = reader;
                            ReaderSaver saver = new ReaderSaver();
                            saver.saveReader(readers);
                            break;
                        }
                    }
                    break;
                case "4":
                    System.out.println("--- Список читателей ---");
                    int i = 0;
                    for (Reader r : readers) {
                        if(r != null){
                            System.out.println(i+1+". "+r.toString());
                            i++;
                        }
                    }
                    break;
                case "5":
                    System.out.println("--- Cписок книг ---");
                    for (int j = 0; j < books.length; j++) {
                        if(books[j]!= null){
                            System.out.printf("%3d. Название книги: %s%nАвтор: %s%n"
                                    ,j+1
                                    ,books[j].getName()
                                    ,books[j].getAuthor()
                            );
                            System.out.println("--------------------------------");
                            
                        }
                    }
                    System.out.println("Выберете книгу: ");
                    int bookNumber = scanner.nextInt();
                    book = books[bookNumber-1];
                    
                    System.out.println("--- Список читателей ---");
                    int k = 0;
                    for (Reader r : readers) {
                        if(r != null){
                            System.out.println(k+1+". "+r.toString());
                            k++;
                        }
                    }
                    
                    System.out.println("Выберете Читателя: ");
                    int readerNumber = scanner.nextInt();
                    reader = readers[readerNumber-1];
                    Calendar c = new GregorianCalendar();
                    History history = new History();
                    history.setBook(book);
                    history.setReader(reader);
                    history.setTakeOnDate(c.getTime());
                    
                    
                    for(int h = 0; h < histories.length; h++){
                        if(histories[h] == null){
                            histories [h] = history;
                            
                            HistorySaver hsaver = new HistorySaver();
                            hsaver.saveBook(histories);
                            break;
                        }
                    }
                    break;
                case "6":
                    System.out.println("--- Cписок книг ---");
                    for (int j = 0; j < histories.length; j++) {
                        if(histories[j]!= null && histories[j].getReturnDate() == null){
                            System.out.printf("%3d. Название книги: %s%n"
                                    ,j+1
                                    ,histories[j].getBook().toString()
                                    
                            );
                            System.out.println("--------------------------------");
                            
                        }
                    }
                    System.out.println("Выберете книгу: ");
                    int bNumber = scanner.nextInt();
                    histories[bNumber-1] = null;
                    break;
                case "7":
                    System.out.println("--- Журнал ---");
                    for (int j = 0; j < histories.length; j++) {
                        if(histories[j] != null && histories[j].getReturnDate() == null){
                            System.out.printf("%3d. Читатель: %s%nНазвание книги: %s%nНачальная дата: %s%n Конечная дата: %s%n "
                                    ,j+1
                                    ,histories[j].getReader().getName()
                                    ,histories[j].getBook().getName()
                                    ,histories[j].getTakeOnDate()
                                    ,histories[j].getReturnDate()
                            );
                            System.out.println("--------------------------------");
                            
                        }
                    }
                    break;
                default:
                    System.out.println("Нет такой задачи.");
            }
        }while(repeat);
    }
}
