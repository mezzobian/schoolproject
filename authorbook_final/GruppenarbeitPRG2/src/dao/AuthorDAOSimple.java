package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import models.Author;

import java.util.LinkedList;
import java.util.List;

public class AuthorDAOSimple implements AuthorDAO {

    private ObservableList<Author> simpleAuthorStorage = FXCollections.observableArrayList();

    public static int authorIDCounter = 0;

    public AuthorDAOSimple() {

        simpleAuthorStorage.add(new Author(authorIDCounter++, "Meier", "Rolf", "Deutschland"));
        simpleAuthorStorage.add(new Author(authorIDCounter++, "Brigger", "Eugen A.", "Schweiz"));
        simpleAuthorStorage.add(new Author(authorIDCounter++, "Famos", "Luisa", "Schweiz"));
        simpleAuthorStorage.add(new Author(authorIDCounter++, "Super", "Ruedi", "Österreich"));
        simpleAuthorStorage.add(new Author(authorIDCounter++, "Shaqiri", "Bljerim", "Albanien"));
        simpleAuthorStorage.add(new Author(authorIDCounter++, "Schmid", "Robin", "CH"));
        simpleAuthorStorage.add(new Author(authorIDCounter++, "Rack", "Janis", "CH"));
        simpleAuthorStorage.add(new Author(authorIDCounter++, "Müller", "Sabrina", "CH"));
        simpleAuthorStorage.add(new Author(authorIDCounter++, "Muster", "Hans", "D"));
        simpleAuthorStorage.add(new Author(authorIDCounter++, "Mast", "Michel", "USA"));
        simpleAuthorStorage.add(new Author(authorIDCounter++, "Lehmann", "Rachel", "CH"));
        simpleAuthorStorage.add(new Author(authorIDCounter++, "Jäggi", "Marc", "A"));
        simpleAuthorStorage.add(new Author(authorIDCounter++, "Strub", "Dario", "CH"));
    }

    public Author getByID(int id) {

        for (Author x : simpleAuthorStorage) {

            if (x.getId() == id)
                return x;
        }

        return null;
    }

    public SortedList<Author> getAll() { //eine Kopie der Liste zurückgeben, nicht die Liste selbst!
        return new SortedList<Author>(simpleAuthorStorage);
        //'return simpleAuthorStorage;' wäre ungeschickt, da die Liste aussen manipulierbar wäre
    }

    public void update(Author a) {
        boolean deleted = simpleAuthorStorage.remove(a);
        if (!deleted) throw new RuntimeException("models.Author nicht vorhanden. " + a);
        simpleAuthorStorage.add(a);
    }

    public void insert(Author a) {
        if (simpleAuthorStorage.contains(a)) throw new RuntimeException("models.Author bereits vorhanden. " + a);
        simpleAuthorStorage.add(a);
    }

    public void delete(int id) {
        for (Author x : simpleAuthorStorage) {
            if (x.getId() == id) {
                simpleAuthorStorage.remove(x);
                return;
            }
        }
        throw new RuntimeException("models.Author nicht vorhanden. id=" + id);
    }
}
