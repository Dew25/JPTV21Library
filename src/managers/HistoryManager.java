/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class HistoryManager {
    
    private final Scanner scanner = new Scanner(System.in);

    public History takeOnBook(Book[] books,Reader[] readers){
        History history = new History();
        // Вывести нумерованный список читателей
        // Выбрать указанного читателя из массива
        // Выбрать нумерованный список книг
        // Выбрать указанную книгу из массива
        // Вставить читателя и книгу в history
        // Добавить дату выдачи книги в history
        System.out.println("Список читателей: ");
        ReaderManager readerManager = new ReaderManager();
        readerManager.printListReaders(readers);
        System.out.print("Выберите номер читателя из списка: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        
        System.out.println("Список книг: ");
        BookManager bookManager = new BookManager();
        bookManager.printListBooks(books);
        System.out.print("Выберите номер книги из списка: ");
        int numberBook = scanner.nextInt(); scanner.nextLine();
        if(!books[numberBook - 1].countMinuss()){
            return null;
        }
        history.setBook(books[numberBook - 1]);
        history.setReader(readers[numberReader - 1]);
        history.setDateTakeOnBook(new GregorianCalendar().getTime());
        return history;
    }

    public void printListTakeOnBooks(History[] histories){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < histories.length; i++) {
            if(histories[i].getDateReturnBook() == null && histories[i].getDateTakeOnBook() != null){
                try {
                    System.out.printf("%d. %s. Выдана: %s. Книгу читает: %s %s%n"
                        ,i+1
                        ,histories[i].getBook().getTitle()
                        ,sdf.format(histories[i].getDateTakeOnBook())
                        ,histories[i].getReader().getFirstname()
                        ,histories[i].getReader().getLastname()
                    );
                } catch (Exception e) {
                    System.out.println("Неправильный формат даты!");
                    return;
                }
                
            }
        }
    }
    public History[] returnBook(History[] histories){
        //Выбрать номер книги из списка выданных книг
        //В выбранную книгу добавить дату возврата
        System.out.println("Список выданных книг:");
        this.printListTakeOnBooks(histories);
        System.out.print("Выберите номер книги для возврата: ");
        int numberToReturnBook = scanner.nextInt(); scanner.nextLine();
        if(histories[numberToReturnBook - 1].getBook().countPluss()){
            histories[numberToReturnBook - 1].setDateReturnBook(new GregorianCalendar().getTime());
        }
        return histories;
    }

    public void printListDeptors(History[] histories) {
        //в цыкле проверить все history в массиве
        for (int i = 0; i < histories.length; i++) {
            History history = histories[i];
            // С каждой датой выдачи сравнить текущую дату:
            // если тедущаяя дата больше даты выдачи книги на 14 дней (100 секунд для теста), 
            // то допечатаем в строке вывода информации слово "должник"
            Date dateTakeOnBook = history.getDateTakeOnBook();
            long currentDate = new GregorianCalendar().getTimeInMillis();
            //тест 100 секунд
            long timeForDeptor = dateTakeOnBook.getTime() + 1000*100;
            //1000*60*60*24*14 - 14 суток
            // long timeForDeptor = dateTakeOnBook.getTime() + 1000*60*60*24*14;
            if(history.getDateReturnBook() == null && currentDate > timeForDeptor){
                System.out.printf("%d. %s. Выдана: %s. Книгу читает: %s %s (%s)%n"
                        ,i+1
                        ,history.getBook().getTitle()
                        ,history.getDateTakeOnBook()
                        ,history.getReader().getFirstname()
                        ,history.getReader().getLastname()
                        ,"Должник"
                ); 
            }
        }
    }
    
}
