/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Book;
import entity.Reader;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author user
 */
public class History implements Serializable{
    private Book book;
    private Reader reader;
    private Date takeOnDate;
    private Date returnDate;

    public History() {
    }

    public History(Book book, Reader reader, Date takeOnDate, Date returnDate) {
        this.book = book;
        this.reader = reader;
        this.takeOnDate = takeOnDate;
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public Date getTakeOnDate() {
        return takeOnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setTakeOnDate(Date takeOnDate) {
        this.takeOnDate = takeOnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "History{" + "book=" + book.getName() + ", reader=" + reader.getName() + ", takeOnDate=" + takeOnDate + ", returnDate=" + returnDate + '}';
    }

    

    
}
