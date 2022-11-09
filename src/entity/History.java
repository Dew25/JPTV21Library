/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Melnikov
 */
public class History implements Serializable{
    private Book book;
    private Reader reader;
    private Date dateTakeOnBook;
    private Date datReturnBook;

    public History() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getDateTakeOnBook() {
        return dateTakeOnBook;
    }

    public void setDateTakeOnBook(Date dateTakeOnBook) {
        this.dateTakeOnBook = dateTakeOnBook;
    }

    public Date getDateReturnBook() {
        return datReturnBook;
    }

    public void setDateReturnBook(Date dateReturnBook) {
        this.datReturnBook = dateReturnBook;
    }

    @Override
    public String toString() {
        return "History{" 
                + "book=" + book 
                + ", reader=" + reader 
                + ", takeOnBook=" + dateTakeOnBook 
                + ", returnBook=" + datReturnBook 
                + '}';
    }
    
}
