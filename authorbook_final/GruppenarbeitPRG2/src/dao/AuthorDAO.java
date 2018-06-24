package dao;

import javafx.collections.transformation.SortedList;
import models.Author;

import java.util.List;

public interface AuthorDAO {
   public Author getByID(int id);
   public SortedList<Author> getAll();
   public void update(Author a);
   public void insert(Author a);
   public void delete(int id);
}
