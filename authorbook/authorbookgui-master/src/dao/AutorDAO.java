package dao;

import models.Author;

import java.util.List;

public interface AutorDAO {
   public Author getByID(int id);
   public List<Author> getAll();
   public void update(Author a);
   public void insert(Author a);
   public void delete(int id);
}
