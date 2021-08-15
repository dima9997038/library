package epam.intoductoinjava.library.controller;

import epam.intoductoinjava.library.model.Book;
import epam.intoductoinjava.library.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BookController {
        @Autowired
        private BookRepository bookRepository;


    @GetMapping("/book")
    public String book ( Model model) {
        Iterable <Book> books=bookRepository.findAll();
        model.addAttribute("books",books);
        return "book";
    }

    @GetMapping("/book/add")
    public String bookAdd ( Model model) {
        return "book-add";
    }

    @PostMapping("/book/add")
    public String current_book_add (@RequestParam String title, @RequestParam String author, @RequestParam String anons,
                                    @RequestParam String genre, @RequestParam Integer year, @RequestParam Integer storage,Model model) {

        Book book=new Book(title,author,anons,genre,year,storage);
        bookRepository.save(book);
        return "redirect:/book";
    }

    @GetMapping("/book/{id}")
    public String bookDetails (@PathVariable(value = "id") long id, Model model) {
        Optional<Book> book= bookRepository.findById(id);
        ArrayList<Book> res=new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book",res);
        return "book-details";
    }

    @GetMapping("/book/{id}/edit")
    public String bookEdit (@PathVariable(value = "id") long id, Model model) {
        Optional<Book> book= bookRepository.findById(id);
        ArrayList<Book> res=new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book",res);
        return "book-edit";
    }

    @PostMapping("/book/{id}/edit")
    public String currentBookEdit (@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String author, @RequestParam String anons,
                                    @RequestParam String genre, @RequestParam Integer year, @RequestParam Integer storage,Model model) {

        Book book=bookRepository.findById(id).orElseThrow();
        book.setTitle(title);
        book.setAuthor(author);
        book.setAnons(anons);
        book.setGenre(genre);
        book.setYears(year);
        book.setStogage(storage);
        bookRepository.save(book);
        return "redirect:/book";
    }

    @PostMapping("/book/{id}/delete")
    public String currentBookDelete (
            @PathVariable(value = "id") long id,
            Model model) {

        Book book=bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
        return "redirect:/book";
    }
}
