/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Author;
import entity.Book;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class BookManager {
    private Scanner scanner;

    public BookManager() {
        this.scanner = new Scanner(System.in);
    }
    
    public Book createBook(){
        Book book = new Book();
        System.out.print("Введите название книги: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Введите число авторов книги: ");
        int countAuthorsInBook = scanner.nextInt();
        scanner.nextLine();
        book.setAuthors(createAuthors(countAuthorsInBook));
        return book;
    }

    private Author[] createAuthors(int countAuthorsInBook) {
        Author[] authors = new Author[countAuthorsInBook];
        for (int i = 0; i < countAuthorsInBook; i++) {
            Author author = new Author();
            System.out.print("Имя автора "+(i+1)+": ");
            author.setFirstname(scanner.nextLine());
            System.out.print("Фамилия автора "+(i+1)+": ");
            author.setLastname(scanner.nextLine());
            authors[i] = author;
        }
        return authors;
    }
    
    public void printListBooks(Book[] books){
        for (int i = 0; i < books.length; i++) {
                        Book book = books[i];
                        System.out.printf(i+1+". Book{title = %s%n",book.getTitle());
                        System.out.print("\tAuthors = [\n\t\t");
                        for (int j = 0; j < book.getAuthors().length; j++) {
                            Author author = book.getAuthors()[j];
                            System.out.printf("%s %s%n"
                                    ,author.getFirstname(),author.getLastname());
                        }
                        System.out.println("\t]");
                    }
                    System.out.println("   }");
    }
}
