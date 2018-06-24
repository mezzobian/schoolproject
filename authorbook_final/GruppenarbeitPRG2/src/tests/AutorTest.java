package tests;

import dao.AuthorDAO;
import dao.AuthorDAOSimple;
import javafx.collections.transformation.SortedList;
import models.Author;

import java.util.Collections;
import java.util.List;

public class AutorTest {
   public static void main(String[] args) {
      
      Author a1 = new Author(100, "Meier", "Rolf", "D");
      Author a2 = new Author(101, "Brigger", "Eugen A.", "CH");
      Author a3 = new Author(102, "Famos", "Luisa", "CH");
      Author a4 = new Author(100, "Abgottspon", "Johann", "CH");
      
      AuthorDAO autorData = new AuthorDAOSimple();
      
      System.out.println("Alle Autoren: " + autorData.getAll() );
      
      autorData.insert( a1 );
      autorData.insert( a2 );
      autorData.insert( a3 );
      System.out.println("Alle Autoren: " + autorData.getAll() );
      
      System.out.println("Löschen von " + a1);
      autorData.delete(a1.getId());
      System.out.println("Alle Autoren: " + autorData.getAll() );
      
      System.out.println("Ändern von " + a2);
      autorData.update( new Author(101, "Brigger", "Eugen", "CH"));
      System.out.println("Alle Autoren: " + autorData.getAll() );
      
      System.out.println("Hinzufügen von " + a4);
      autorData.insert( a4 );
      System.out.println("Alle Autoren: " + autorData.getAll() );

      SortedList<Author> l = autorData.getAll();
      System.out.println("Alle Autoren (sortiert nach Name): " + l);
      
      
   }

}
