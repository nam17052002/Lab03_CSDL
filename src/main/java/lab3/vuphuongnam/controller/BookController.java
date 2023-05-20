package lab3.vuphuongnam.controller;

import lab3.vuphuongnam.entity.Book;
import lab3.vuphuongnam.service.BookService;
import lab3.vuphuongnam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books    = bookService.getALlBooks();
        model.addAttribute("books",books);
        return "Book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "Book/add";
    }
    @PostMapping("/add")
    public  String addBook(@ModelAttribute("book") Book book){
        bookService.addBook(book);
        return "redirect:/books";
    }
}
