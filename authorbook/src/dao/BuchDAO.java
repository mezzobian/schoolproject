package dao;

import models.Book;

import java.util.List;

public interface BuchDAO {
   public Book getByBID(int bookId);
   public List<Book> getAll();
   public void update(Book book);
   public void insert(Book book);
   public void delete(int bookId);
}
