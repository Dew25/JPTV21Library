/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Author;
import entity.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class BookManager {
    private final Scanner scanner;

    public BookManager() {
        this.scanner = new Scanner(System.in);
    }
    
    public Book createBook(){
        Book book = new Book();
        System.out.print("Введите название книги: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Введите количество экземпляров книги: ");
        book.setQusntity(scanner.nextInt());scanner.nextLine();
        System.out.print("Введите число авторов книги: ");
        int countAuthorsInBook = scanner.nextInt();
        scanner.nextLine();
        book.setAuthors(createAuthors(countAuthorsInBook));
        return book;
    }

    private List<Author> createAuthors(int countAuthorsInBook) {
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < countAuthorsInBook; i++) {
            Author author = new Author();
            System.out.print("Имя автора "+(i+1)+": ");
            author.setFirstname(scanner.nextLine());
            System.out.print("Фамилия автора "+(i+1)+": ");
            author.setLastname(scanner.nextLine());
            authors.add(author);
        }
        return authors;
    }
    
    public void printListBooks(List<Book> books){
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if(book.getCount() < 1) continue;
            System.out.printf(i+1+". Book{title = %s%n",book.getTitle());
            System.out.print("\tAuthors = [\n");
            for (int j = 0; j < book.getAuthors().size(); j++) {
                Author author = book.getAuthors().get(i);
                System.out.printf("\t\t%s %s%n"
                        ,author.getFirstname(),author.getLastname());
            }
            System.out.println("\t]");
        }
        System.out.println("   }");
    }

    public List<Book> changeBook(List<Book> books) {
        System.out.println("Список книг: ");
        this.printListBooks(books);
        System.out.print("Выберите номер книги для редактирования: ");
        int numBookForEdit = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Авторов у книги "+books.get(numBookForEdit - 1).getAuthors().size());
        System.out.println("Изменение авторов? (y/n)");
        String edit = scanner.nextLine();
        if(edit.equals("y")){// Меняем количество авторов
            System.out.print("Введите новое количество авторов: ");
            int newCountAuthorsInBook = scanner.nextInt();
            scanner.nextLine();
         // количество авторов может быть больше или меньше.
            if(newCountAuthorsInBook < books.get(numBookForEdit - 1).getAuthors().size()){
              //если меньше, выводим нумерованный список авторов и просим указать какого удалить
               // вычисляем на сколько меньше 
                int deltaAuthors = books.get(numBookForEdit - 1).getAuthors().size() - newCountAuthorsInBook;
                for (int n = 0; n < deltaAuthors; n++) {
                    //удаляем лишних (deltaAuthors) авторов из книги
                    books.get(numBookForEdit - 1).getAuthors().remove(n);
                }
            }else{
                for (int i = 0; i < newCountAuthorsInBook; i++) {
                    //если счетчик больше количесвтва авторов
                    if(i >= books.get(numBookForEdit - 1).getAuthors().size()){
                        // добаляем нового автора в книгу
                        Author newAuthor = new Author();
                        System.out.print("Введите имя автора "+(i+1)+": ");
                        newAuthor.setFirstname(scanner.nextLine());
                        System.out.print("Введите фамилию атора "+(i+1)+": ");
                        newAuthor.setLastname(scanner.nextLine());
                        books.get(numBookForEdit - 1).addAuthor(newAuthor);
                    }else if(i < books.get(numBookForEdit - 1).getAuthors().size()){
                        // изменяем существующих авторов книги
                        System.out.println(i+1+"-й автор: "
                            +books.get(numBookForEdit - 1).getAuthors().get(i).getFirstname()+" "+
                                   books.get(numBookForEdit - 1).getAuthors().get(i).getLastname());
                        System.out.print("Изменить имя автора? (y/n)");
                        edit = scanner.nextLine();
                        if(edit.equals("y")){
                            System.out.print("Введите новое имя атора: ");
                            books.get(numBookForEdit - 1).getAuthors().get(i).setFirstname(scanner.nextLine());
                        }    
                        System.out.print("Изменить фамилию автора? (y/n)");
                        edit = scanner.nextLine();
                        if(edit.equals("y")){
                            System.out.print("Введите новую фамилию атора: ");
                            books.get(numBookForEdit - 1).getAuthors().get(i).setLastname(scanner.nextLine());
                        }    
                    }
                }
            }
        }
        System.out.println("Название книги: "+ books.get(numBookForEdit - 1).getTitle());
        System.out.println("Изменить название книги? (y/n)");
        edit = scanner.nextLine();
        if(edit.equals("y")){// Меняем название
            System.out.print("Введите другое название книги: ");
            books.get(numBookForEdit - 1).setTitle(scanner.nextLine());
        }
        System.out.println("Количество экземпляров книги: "+ books.get(numBookForEdit - 1).getQusntity());
        System.out.println("Изменить количество книг? (y/n)");
        edit = scanner.nextLine();
        if(edit.equals("y")){// Меняем количество
            System.out.println("Добаляем или уменьшаем количество? +/-");
            String znak = scanner.nextLine();
            if("+".equals(znak)){
                System.out.print("Введите количество добавляемых экземпляров книги: ");
                int number = scanner.nextInt();scanner.nextLine();
                books.get(numBookForEdit - 1).quantityPluss(number);
            }
            if("+".equals(znak)){
                System.out.print("Введите количество добавляемых экземпляров книги: ");
                int number = scanner.nextInt();scanner.nextLine();
                books.get(numBookForEdit - 1).quantityMinus(number);
            }
        }
        
        return books;
    }


   

}
