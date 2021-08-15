package epam.intoductoinjava.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private  String title;
    private  String author;
    private  String anons;
    private  String genre;
    private int years;
    private int stogage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getStogage() {
        return stogage;
    }

    public void setStogage(int stogage) {
        this.stogage = stogage;
    }

    public Book(String title, String author, String anons, String genre, int years, int stogage) {
        this.title = title;
        this.author = author;
        this.anons = anons;
        this.genre = genre;
        this.years = years;
        this.stogage = stogage;
    }

    public Book() {
    }
}
