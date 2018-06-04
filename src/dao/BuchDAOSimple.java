package dao;

import models.Book;

import java.util.LinkedList;
import java.util.List;

public class BuchDAOSimple implements BuchDAO {
   private List<Book> simpleBookStorage = new LinkedList<Book>();

   public Book getByBID(int bookId) {

      for(Book book : simpleBookStorage) {

         if(book.getBookId() == bookId)
            return book;
      }

      // if no book with the corresponding ID was found, return null
      return null;
   }

   public List<Book> getAll() {

      return new LinkedList<Book>(simpleBookStorage);
   }

   public void update(Book book) {

      boolean deleted = simpleBookStorage.remove(book);

      if(!deleted) {
         throw new RuntimeException("models.Book to update was not found in storage");
      }else {
         simpleBookStorage.add(book);
      }
   }

   public void insert(Book book) {
      if(simpleBookStorage.contains(book)) {
         throw new RuntimeException("models.Book to insert is already in storage");
      }else {
         simpleBookStorage.add(book);
      }
   }

   public void delete(int bookId) {

      for(Book book : simpleBookStorage) {
         if(book.getBookId() == bookId) {
            simpleBookStorage.remove(book);
            return;
         }
      }

      throw new RuntimeException("models.Book to delete was not found in storage");
   }
}
