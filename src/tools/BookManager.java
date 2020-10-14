/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Book;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class BookManager {
        public void addBookToArra(Book book, Book[] books){
        for(int i = 0; i < books.length; i++){
                        if(books[i] == null){
                            books[i] = book;
                            break;
                        }
        }
    }

    public void printListBooks(Book[] books) {
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
    }
    public Book createBook(){
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Создание книги");
        
        System.out.println("Введите автора:");
        book.setAuthor(scanner.nextLine());
        
        System.out.println("Введите название:");
        book.setName(scanner.nextLine());
        
        
        System.out.println("Введите год:");
        book.setPublishedYear(scanner.nextInt());
        return book;
    }
}
