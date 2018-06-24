package gui;

import dao.AuthorDAO;
import dao.AuthorDAOSimple;
import dao.BookDAO;
import dao.BookDAOSimple;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import models.Author;
import models.Book;

import java.util.LinkedList;
import java.util.Random;

public class AuthorBookController {

    private BookDAO bookDAO;

    private AuthorDAO authorDAO;

    // The author table part
    @FXML
    private TableView<Author> authortable;
    @FXML
    private TableColumn<Author, Integer> author_id;
    @FXML
    private TableColumn<Author, String> author_firstname;
    @FXML
    private TableColumn<Author, String> author_lastname;
    @FXML
    private TableColumn<Author, String> author_country;

    // The book table part
    @FXML
    private TableView<Book> booktable;
    @FXML
    private TableColumn<Book, Integer> book_id;
    @FXML
    private TableColumn<Book, String> book_title;
    @FXML
    private TableColumn<Book, String> book_place;
    @FXML
    private TableColumn<Book, Integer> book_year;
    @FXML
    private TableColumn<Book, String> book_autor;

    // The registration of a new book
    @FXML
    private TextField reg_title;
    @FXML
    private TextField reg_place;
    @FXML
    private TextField reg_year;
    @FXML
    private ComboBox<Author> reg_author;
    @FXML
    private Button reg_save;

    // The registration of a new author
    @FXML
    private TextField reg_firstname;
    @FXML
    private TextField reg_country;
    @FXML
    private TextField reg_lastname;
    @FXML
    private Button reg_save_author;

    /**
     * The public constructor, to add some data
     */
    public AuthorBookController() {

        this.authorDAO = new AuthorDAOSimple();

        this.bookDAO = new BookDAOSimple();
    }

    @FXML
    void addBook(ActionEvent event) {

        int parsedYear = Integer.parseInt(reg_year.getText());

        LinkedList<Author> authors = new LinkedList<>();

        authors.add(reg_author.getSelectionModel().getSelectedItem());

        Book book = new Book(
                BookDAOSimple.bookIDCounter++,
                reg_title.getText(),
                parsedYear,
                reg_place.getText(),
                authors
        );

        // add the author to the list
        this.bookDAO.insert(book);

        // blank the text fields
        reg_title.setText("");
        reg_place.setText("");
        reg_year.setText("");
        reg_author.setValue(null);
    }

    @FXML
    void removeBook(ActionEvent event) {

        //remove a book
        Book bookToRemove = this.booktable.getSelectionModel().getSelectedItem();

        this.bookDAO.delete(bookToRemove.getBookId());
    }

    @FXML
    void editBook(ActionEvent event) {
        Book bookToEdit = this.booktable.getSelectionModel().getSelectedItem();

        reg_title.setText(bookToEdit.getTitle());
        reg_place.setText(bookToEdit.getPlace());
        reg_year.setText("" + bookToEdit.getYear());
        reg_author.setValue(bookToEdit.getAuthors().get(0));
    }

    @FXML
    void addAuthor(ActionEvent event) {

        // create the author
        Author author = new Author(
                AuthorDAOSimple.authorIDCounter++,
                reg_firstname.getText(),
                reg_lastname.getText(),
                reg_country.getText()
        );

        // add the author to the list
        this.authorDAO.insert(author);

        // blank the text fields
        reg_firstname.setText("");
        reg_lastname.setText("");
        reg_country.setText("");
    }

    @FXML
    void removeAuthor(ActionEvent event) {
        Author authorToRemove = this.authortable.getSelectionModel().getSelectedItem();

        this.authorDAO.delete(authorToRemove.getId());
    }

    @FXML
    private void initialize() {
        // Set up the author table
        author_id.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        author_firstname.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        author_lastname.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        author_country.setCellValueFactory(cellData -> cellData.getValue().countryProperty());

        SortedList<Author> sortedData = this.authorDAO.getAll();

        sortedData.comparatorProperty().bind(authortable.comparatorProperty());

        authortable.setItems(sortedData);

        // Set up the book table

        book_id.setCellValueFactory(cellData -> cellData.getValue().bookIdProperty());
        book_title.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        book_place.setCellValueFactory(cellData -> cellData.getValue().placeProperty());
        book_year.setCellValueFactory(cellData -> cellData.getValue().yearProperty());
        book_autor.setCellValueFactory(cellData -> cellData.getValue().authorsProperty());

        SortedList<Book> sortedDataBook = this.bookDAO.getAll();

        sortedDataBook.comparatorProperty().bind(booktable.comparatorProperty());

        booktable.setItems(sortedDataBook);


        // Set up the registration of books
        reg_author.setItems(authorDAO.getAll());
    }
}
