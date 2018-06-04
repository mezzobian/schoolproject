package dao;

import models.Author;

import java.util.LinkedList;
import java.util.List;

public class AutorDAOSimple implements AutorDAO {
    private List<Author> intern_all = new LinkedList<Author>();

    public AutorDAOSimple() {
        intern_all.add(new Author(100, "Meier", "Rolf", "D"));
        intern_all.add(new Author(101, "Schmitt", "Regula", "CH"));
        intern_all.add(new Author(102, "Updike", "Johann", "USA"));
        intern_all.add(new Author(103, "Sutter", "Martin", "CH"));
    }

    public Author getByID(int id) {

        for (Author x : intern_all) {

            if (x.getId() == id)
                return x;
        }

        return null;
    }

    public List<Author> getAll() { //eine Kopie der Liste zurückgeben, nicht die Liste selbst!
        return new LinkedList<Author>(intern_all);
        //'return intern_all;' wäre ungeschickt, da die Liste aussen manipulierbar wäre
    }

    public void update(Author a) {
        boolean deleted = intern_all.remove(a);
        if (!deleted) throw new RuntimeException("models.Author nicht vorhanden. " + a);
        intern_all.add(a);
    }

    public void insert(Author a) {
        if (intern_all.contains(a)) throw new RuntimeException("models.Author bereits vorhanden. " + a);
        intern_all.add(a);
    }

    public void delete(int id) {
        for (Author x : intern_all) {
            if (x.getId() == id) {
                intern_all.remove(x);
                return;
            }
        }
        throw new RuntimeException("models.Author nicht vorhanden. id=" + id);
    }
}
