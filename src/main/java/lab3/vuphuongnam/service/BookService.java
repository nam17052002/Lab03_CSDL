package lab3.vuphuongnam.service;

import lab3.vuphuongnam.entity.Book;
import lab3.vuphuongnam.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;

    public List<Book> getALlBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }
}
