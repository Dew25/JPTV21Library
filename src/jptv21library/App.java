/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv21library;

import entity.Author;
import entity.Book;
import java.util.Arrays;
import java.util.Scanner;
import managers.BookManager;

/**
 *
 * @author Melnikov
 */
public class App {
    private Book[] books;
    private BookManager bookManager;

    public App() {
        this.books = new Book[0];
        bookManager = new BookManager();
    }
    
    public void run(){
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Список задач: ");
            System.out.println("0. Закрыть приложение");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Выдать книгу");
            System.out.println("4. Вернуть книгу");
            System.out.println("5. Список книг");
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
                    this.books = Arrays.copyOf(this.books, this.books.length+1);
                    this.books[this.books.length-1] = bookManager.createBook();
                    break;
                case 2:
                    System.out.println("Задача 2. Добавить читателя");
                    break;
                case 3:
                    System.out.println("Задача 3. Выдать книгу");
                    break;
                case 4:
                    System.out.println("Задача 4. Вернуть книгу");
                    break;
                case 5:
                    System.out.println("Задача 5. Список книг");
                    bookManager.printListBooks(books);
                    break;
                default:
                    System.out.println("Выберите задачу из списка");
            }
            System.out.println("=======---------========");
        }while(repeat);
        System.out.println("Пока, ребята!");
    }
}
