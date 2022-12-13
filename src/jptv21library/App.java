/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv21library;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import entity.repository.BookFacade;
import entity.repository.ReaderFacade;
import interfaces.DataPersistenceManage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import managers.BookManager;
import managers.basemanager.DataBaseManager;
import managers.HistoryManager;
import managers.ReaderManager;
import managers.filemanagers.FileDataManager;

/**
 *
 * @author Melnikov
 */
public class App {
    public static boolean saveToBase = false;
    private final BookFacade bookFacade;
    //private Book[] books;
    //private List<Book> books;
    private final ReaderFacade readerFacade;
    //private Reader[] readers;
    //private List<Reader> readers;
    //private History[] histories;
    //private List<History> histories;
    private final BookManager bookManager;
    private final ReaderManager readerManager;
    private final HistoryManager historyManager;
    private final DataPersistenceManage dataManager;
    private final Scanner scanner;

    public App() {
        scanner = new Scanner(System.in);
        if(App.saveToBase){
            dataManager = new DataBaseManager();
        }else{
            dataManager = new FileDataManager();
        }
        bookFacade = new BookFacade();
        readerFacade = new ReaderFacade();
        //this.books = dataManager.loadBooks();
        //this.readers = dataManager.loadReaders();
        //this.histories = dataManager.loadHistories();
        //testAddBook();
        //testAddReader();
        bookManager = new BookManager();
        readerManager = new ReaderManager();
        historyManager = new HistoryManager();
        
    }
    
    public void run(){
        boolean repeat = true;
        do{
            System.out.println("Список задач: ");
            System.out.println("0. Закрыть приложение");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Выдать книгу");
            System.out.println("4. Вернуть книгу");
            System.out.println("5. Список книг");
            System.out.println("6. Редактирование книги");
            System.out.println("7. Список читателей");
            System.out.println("8. Список выданных книг");
            System.out.print("Выберите номер задачи: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            System.out.println("____________________");
            switch (task) {
                case 0:
                    repeat = false;
                    System.out.println("Задача 0. Закрыть приложение");
                    break;
                case 1:
                    System.out.println("Задача 1. Добавить книгу");
                    bookFacade.save(bookManager.createBook());
                    //books.add(bookManager.createBook());
                    //Сохранение массива с новой книгой в файл
                    //dataManager.saveBooks(this.books);
                    break;
                case 2:
                    System.out.println("Задача 2. Добавить читателя");
                    //this.readers.add(readerManager.createReader());
                    readerFacade.save(readerManager.createReader());
                    //Сохранение массива с новым читателем в файл
                    //dataManager.saveReaders(this.readers);
                    break;
                case 3:
                    System.out.println("Задача 3. Выдать книгу");
                    historyManager.takeOnBook();
                    //Сохранение массива с новой историей в файл
                    //dataManager.saveHistories(this.histories);
                    break;
                case 4:
                    System.out.println("Задача 4. Вернуть книгу");
                    historyManager.returnBook();
                    //Сохранение массива с измененной историей в файл
                    //dataManager.saveHistories(this.histories);
                    break;
                case 5:
                    System.out.println("Задача 5. Список книг");
                    bookManager.printListBooks();
                    break;
                case 6:
                    System.out.println("Задача 6. Редактирование книги");
                    bookManager.changeBook();
                    break;
                case 7:
                    System.out.println("Задача 7. Список читателей");
                    readerManager.printListReaders();
                    break;    
                case 8:
                    System.out.println("Задача 8. Список выданных книг");
                    historyManager.printListTakeOnBooks();
                    break;    
                default:
                    System.out.println("Выберите задачу из списка");
            }
            System.out.println("=======---------========");
        }while(repeat);
        System.out.println("Пока, ребята!");
    }

//    private void testAddBook() {
//        Book book = new Book();
//        book.setTitle("Book for editing");
//        Author author = new Author();
//        author.setFirstname("firstname");
//        author.setLastname("lastname");
//        List<Author> bookAuthors = new ArrayList<>();
//        bookAuthors.add(author);
//        book.setAuthors(bookAuthors);
//        this.books.add(book);
//        
//    }
//    private void testAddReader(){
//        Reader reader = new Reader("Ivan","Ivanov","54566556");
////        reader.setFirstname("Ivan");
////        reader.setLastname("Ivanov");
//        this.readers.add(reader);
//    }
}
