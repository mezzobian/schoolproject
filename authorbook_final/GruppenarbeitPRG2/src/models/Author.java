package models;

import javafx.beans.property.*;

import java.util.Comparator;

public class Author {
    private IntegerProperty id;
    private StringProperty lastname;
    private StringProperty firstname;
    private StringProperty country;

    public static Comparator<Author> NAME_CMP = new Comparator<Author>() { //sortiert nach Attribut lastname
        public int compare(Author a1, Author a2) {
            return a1.lastname.get().compareTo(a2.lastname.get());
        }
    };

    public Author(int id, String lastname, String firstname, String country) {
        this.id = new SimpleIntegerProperty(id);
        this.lastname = new SimpleStringProperty(lastname);
        this.firstname = new SimpleStringProperty(firstname);
        this.country = new SimpleStringProperty(country);
    }

    public int getId() {

        return id.get();
    }

    public ObjectProperty<Integer> idProperty() {
        return this.id.asObject();
    }

    public String getFirstname() {
        return this.firstname.get();
    }

    public StringProperty firstNameProperty() {
        return this.firstname;
    }

    public String getLastname() {

        return this.lastname.get();
    }

    public StringProperty lastNameProperty() {
        return this.lastname;
    }

    public String getCountry() {

        return this.country.get();
    }

    public StringProperty countryProperty() {
        return this.country;
    }

    public String toString() {

        return id.get() + " " + lastname.get() + " " + firstname.get() + " (" + country.get() + ")";
    }

    public int hashCode() {

        return id.get();
    }

    //für equals relevante Attribute: id (einziges Attribut)
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Author other = (Author) obj;
        return (id.get() == other.id.get());
    }
}
