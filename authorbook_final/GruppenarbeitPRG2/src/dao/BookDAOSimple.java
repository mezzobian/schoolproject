package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import models.Author;
import models.Book;

import java.util.List;
import java.util.Random;

public class BookDAOSimple implements BookDAO {

    private ObservableList<Book> simpleBookStorage = FXCollections.observableArrayList();

    public static int bookIDCounter = 0;

    public BookDAOSimple() {
        simpleBookStorage.add(new Book(bookIDCounter++, "Java FX", 2018, "CH"));
        simpleBookStorage.add(new Book(bookIDCounter++, "My SQL", 2017, "USA"));
        simpleBookStorage.add(new Book(bookIDCounter++, "Network", 2016, "D"));
        simpleBookStorage.add(new Book(bookIDCounter++, "vmWare", 2015, "USA"));
        simpleBookStorage.add(new Book(bookIDCounter++, "Windows 10", 2018, "CH"));

        AuthorDAO authorsDAO = new AuthorDAOSimple();

        List<Author> authors = authorsDAO.getAll();

        Random randGen = new Random();

        // Add authors to all books
        for (Book book : simpleBookStorage) {

            // add 1 - 3 random authors of the authors list
            for (int i = 0; i < randGen.nextInt(3); i++) {
                book.addAuthor(authors.get(randGen.nextInt(authors.size())));
            }
        }
    }

    public Book getByBID(int bookId) {

        for (Book book : simpleBookStorage) {

            if (book.getBookId() == bookId)
                return book;
        }

        // if no book with the corresponding ID was found, return null
        return null;
    }

    public SortedList<Book> getAll() {

        return new SortedList<Book>(simpleBookStorage);
    }

    public void update(Book book) {

        boolean deleted = simpleBookStorage.remove(book);

        if (!deleted) {
            throw new RuntimeException("models.Book to update was not found in storage");
        } else {
            simpleBookStorage.add(book);
        }
    }

    public void insert(Book book) {
        if (simpleBookStorage.contains(book)) {
            throw new RuntimeException("models.Book to insert is already in storage");
        } else {
            simpleBookStorage.add(book);
        }
    }

    public void delete(int bookId) {

        for (Book book : simpleBookStorage) {
            if (book.getBookId() == bookId) {
                simpleBookStorage.remove(book);
                return;
            }
        }

        throw new RuntimeException("models.Book to delete was not found in storage");
    }
}
