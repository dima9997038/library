package epam.intoductoinjava.library.repo;
import epam.intoductoinjava.library.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
