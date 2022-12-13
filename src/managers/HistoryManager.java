/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import entity.repository.BookFacade;
import entity.repository.HistoryFacade;
import entity.repository.ReaderFacade;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class HistoryManager {
    private final Scanner scanner = new Scanner(System.in);
    private final BookFacade bookFacade;
    private final ReaderFacade readerFacade;
    private final HistoryFacade historyFacade;

    public HistoryManager() {
        bookFacade = new BookFacade();
        readerFacade = new ReaderFacade();
        historyFacade = new HistoryFacade();
    }
    
    public void takeOnBook(){
//        BookFacade bookFacade = new BookFacade();
//        List<Book> books = bookFacade.findAll();
//        ReaderFacade readerFacade = new ReaderFacade();
//        List<Reader> readers = readerFacade.findAll();
        History history = new History();
        // Вывести нумерованный список читателей
        // Выбрать указанного читателя из массива
        // Выбрать нумерованный список книг
        // Выбрать указанную книгу из массива
        // Вставить читателя и книгу в history
        // Добавить дату выдачи книги в history
        System.out.println("Список читателей: ");
        ReaderManager readerManager = new ReaderManager();
        readerManager.printListReaders();
        System.out.print("Выберите номер читателя из списка: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        Reader reader = readerFacade.find((long) numberReader);
        System.out.println("Список книг: ");
        BookManager bookManager = new BookManager();
        bookManager.printListBooks();
        System.out.print("Выберите номер книги из списка: ");
        int numberBook = scanner.nextInt(); scanner.nextLine();
        Book book = bookFacade.find((long)numberBook);
        if(!book.countMinuss()){
            return;
        }
        history.setBook(book);
        history.setReader(reader);
        history.setTakeOnBook(new GregorianCalendar().getTime());
        historyFacade.save(history);
        
    }

    public void printListTakeOnBooks(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        List<History> histories = historyFacade.findAll();
        for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i).getReturnBook() == null && histories.get(i).getTakeOnBook() != null){
                try {
                    System.out.printf("%d. %s. Выдана: %s. Книгу читает: %s %s%n"
                        ,histories.get(i).getId()
                        ,histories.get(i).getBook().getTitle()
                        ,sdf.format(histories.get(i).getTakeOnBook())
                        ,histories.get(i).getReader().getFirstname()
                        ,histories.get(i).getReader().getLastname()
                    );
                } catch (Exception e) {
                    System.out.println("Неправильный формат даты!");
                    return;
                }
                
            }
        }
    }
    public void returnBook(){
        //Выбрать номер книги из списка выданных книг
        //В выбранную книгу добавить дату возврата
        System.out.println("Список выданных книг:");
        this.printListTakeOnBooks();
        System.out.print("Выберите номер книги для возврата: ");
        int numberToReturnBook = scanner.nextInt(); scanner.nextLine();
        History history = historyFacade.find((long)numberToReturnBook);
        if(history.getBook().countPluss()){
            history.setReturnBook(new GregorianCalendar().getTime());
        }else{
            System.out.println("Книга не возвращена");
        }
        historyFacade.save(history);
    }
    
}
