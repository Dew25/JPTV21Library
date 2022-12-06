/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers.filemanagers;

import entity.Book;
import entity.History;
import entity.Reader;
import interfaces.DataPersistenceManage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Melnikov
 */
public class FileDataManager implements DataPersistenceManage{
    
    private final String BOOKS_FILE = "MyBooks";
    private final String READERS_FILE = "MyReaders";
    private final String HISTORIES_FILE = "MyHistories";
    
    @Override
    public void saveBooks(List<Book> books){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(BOOKS_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Нет MyBooks файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
        
    }

    @Override
    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(BOOKS_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            books = (List<Book>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE,"Нет файла MyBooks", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return books;
    }

    @Override
    public void saveReaders(List<Reader> readers) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(READERS_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(readers);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Нет MyReaders файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }

    @Override
    public List<Reader>loadReaders() {
        List<Reader> readers = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(READERS_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            readers = (List<Reader>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE,"Нет файла MyReaders", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return readers;
    }


    @Override
    public void saveHistories(List<History> histories) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(HISTORIES_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(histories);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Нет MyHistories файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода данных", ex);
        }
    }
    
    @Override
    public List<History> loadHistories() {
        List<History> histories = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(HISTORIES_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            histories = (List<History>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE,"Нет файла MyHistories", ex);
        } catch (IOException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileDataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return histories;
    }
}
