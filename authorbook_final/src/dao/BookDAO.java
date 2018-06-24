package dao;

import javafx.collections.transformation.SortedList;
import models.Book;

import java.util.List;

public interface BookDAO {
   public Book getByBID(int bookId);
   public SortedList<Book> getAll();
   public void update(Book book);
   public void insert(Book book);
   public void delete(int bookId);
}
