package models;

import javafx.beans.property.*;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Book {
    private IntegerProperty bookId;               //models.Book-ID
    private StringProperty title;          //Buchtitel
    private IntegerProperty year;              //Erscheinungsjahr
    private List<Author> authors;   //Liste aller Autoren
    private StringProperty place;            //Erscheinungsort
    private StringProperty authorsString;

    public static Comparator<Book> TITLE_CMP = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {

            return book1.getTitle().compareToIgnoreCase(book2.getTitle());
        }
    };

    public static Comparator<Book> AUTHOR_CMP = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {

            String authorBook1 = book1.getAuthors().get(0).getLastname();

            String authorBook2 = book2.getAuthors().get(0).getLastname();

            return authorBook1.compareToIgnoreCase(authorBook2);

        }
    };

    /**
     * Constructor for a book without author
     */
    public Book(int bookId, String title, int year, String place) {
        this.bookId = new SimpleIntegerProperty(bookId);
        this.title = new SimpleStringProperty(title);
        this.year = new SimpleIntegerProperty(year);
        this.place = new SimpleStringProperty(place);

        this.authors = new LinkedList<>();

        this.authorsString = new SimpleStringProperty(this.getAuthorsString());
    }

    /**
     * Constructor for 1 author
     */
    public Book(int bookId, String title, int year, String place, Author author) {
        this.bookId = new SimpleIntegerProperty(bookId);
        this.title = new SimpleStringProperty(title);
        this.year = new SimpleIntegerProperty(year);
        this.place = new SimpleStringProperty(place);

        List<Author> authors = new LinkedList<>();
        authors.add(author);
        this.authors = authors;

        this.authorsString = new SimpleStringProperty(this.getAuthorsString());
    }

    /**
     * Constructor for multiple authors
     */
    public Book(int bookId, String title, int year, String place, LinkedList<Author> authors) {
        this.bookId = new SimpleIntegerProperty(bookId);
        this.title = new SimpleStringProperty(title);
        this.year = new SimpleIntegerProperty(year);
        this.place = new SimpleStringProperty(place);
        this.authors = authors;

        this.authorsString = new SimpleStringProperty(this.getAuthorsString());
    }

    public int getBookId() {

        return bookId.get();
    }

    public ObjectProperty<Integer> bookIdProperty() {
        return this.bookId.asObject();
    }
    /*
    public void setBookId(int bookId) {

        this.bookId = bookId;
    }*/

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return this.title;
    }

    /*
    public void setTitle(String title) {
        this.title = title;
    }*/

    public int getYear() {
        return year.get();
    }

    public ObjectProperty<Integer> yearProperty(){

        return this.year.asObject();
    }

    /*
    public void setYear(int year) {
        this.year = year;
    }
    */

    public String getPlace() {
        return this.place.get();
    }

    public StringProperty placeProperty(){

        return this.place;
    }

    public StringProperty authorsProperty() {

        return this.authorsString;
    }

    /*
    public void setPlace(String place) {
        this.place = place;
    }*/

    public void addAuthor(Author author) {

        if (!authors.contains(author)) {
            authors.add(author);
        }
    }

    public void deleteAutor(Author author) {
        authors.remove(author);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String getAuthorsString() {
        String authorsString = "";

        boolean isFirst = true;

        for(Author author : this.authors) {

            if(! isFirst) {
                authorsString += ", ";
            }

            authorsString += author.toString();

            isFirst = false;
        }

        return authorsString;
    }

    public int hashCode() {
        return this.bookId.get();
    }

    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Book other = (Book) obj;

        return (bookId.get() == other.bookId.get());
    }
}
