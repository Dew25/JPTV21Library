/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Melnikov
 */
public class Book implements Serializable{
    private String title;
    private List<Author> authors;
    private int qusntity;
    private int count;

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    
    public void addAuthor(Author auhtor){
        this.authors.add(auhtor);
    }
    
    public void removeAuthor(int numberOfAuthor){
        this.authors.remove(numberOfAuthor);
    }
    @Override
    public String toString() {
        return "Book{" 
                + "title=" + title 
                + ", authors=" + Arrays.toString(authors.toArray()) 
                + ", quantity="+ qusntity
                + ", count=" + count
                + '}';
    }

    public int getQusntity() {
        return qusntity;
    }

    public void setQusntity(int qusntity) {
        this.qusntity = qusntity;
        this.count = qusntity;
    }

    public int getCount() {
        return count;
    }

    public  void setCount(int count) {
        this.count = count;
    }
    public boolean countPluss(){
        if(count < qusntity){
            count++;
            return true;
        }
        return false;
    }
    public boolean countMinuss(){
        if(count > 0){
            count--;
            return true;
        }
        return false;
    }

    public void quantityPluss(int number) {
        qusntity += number;
        count += number;
    }

    public void quantityMinus(int number) {
        qusntity -= number;
    }
    
}
