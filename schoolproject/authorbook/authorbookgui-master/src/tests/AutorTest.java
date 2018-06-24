package tests;

import dao.AutorDAO;
import dao.AutorDAOSimple;
import models.Author;

import java.util.Collections;
import java.util.List;

public class AutorTest {
   public static void main(String[] args) {
      
      Author a1 = new Author(100, "Meier", "Rolf", "D");
      Author a2 = new Author(101, "Brigger", "Eugen A.", "CH");
      Author a3 = new Author(102, "Famos", "Luisa", "CH");
      Author a4 = new Author(100, "Abgottspon", "Johann", "CH");
      
      AutorDAO autorData = new AutorDAOSimple();
      
      System.out.println("Alle Autoren: " + autorData.getAll() );
      
      autorData.insert( a1 );
      autorData.insert( a2 );
      autorData.insert( a3 );
      System.out.println("Alle Autoren: " + autorData.getAll() );
      
      System.out.println("L�schen von " + a1);
      autorData.delete(a1.getId());
      System.out.println("Alle Autoren: " + autorData.getAll() );
      
      System.out.println("�ndern von " + a2);
      autorData.update( new Author(101, "Brigger", "Eugen", "CH"));
      System.out.println("Alle Autoren: " + autorData.getAll() );
      
      System.out.println("Hinzuf�gen von " + a4);
      autorData.insert( a4 );
      System.out.println("Alle Autoren: " + autorData.getAll() );      
      
      List<Author> l = autorData.getAll();
      Collections.sort( l, Author.NAME_CMP );
      System.out.println("Alle Autoren (sortiert nach Name): " + l);
      
      
   }

}
