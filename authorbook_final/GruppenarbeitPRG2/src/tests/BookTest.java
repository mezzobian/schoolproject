package tests;

import models.Author;
import models.Book;

public class BookTest {

    public static void main(String[] args) {

        //Erstellen einer Buch-Instanz ohne Autoren
        Book book = new Book(100, "Datenbanksysteme", 2008, "Bern");

        //Erstellen der Autoren
        Author a1 = new Author(1, "Meier", "Ina", "CH");
        Author a2 = new Author(2, "Naumann", "Rolf", "D");

        //Hinzufügen der Autoren zum Buch
        book.addAuthor(a1);
        book.addAuthor(a2);

        System.out.println(book.getAuthorsString());
    }
}