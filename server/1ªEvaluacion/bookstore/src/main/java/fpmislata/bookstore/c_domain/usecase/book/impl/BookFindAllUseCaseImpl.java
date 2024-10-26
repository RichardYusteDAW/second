// package fpmislata.bookstore.c_domain.usecase.book.impl;

// import java.util.List;
// import lombok.AllArgsConstructor;
// import org.springframework.stereotype.Component;

// import fpmislata.bookstore.c_domain.model.Book;
// import fpmislata.bookstore.c_domain.service.interfaces.BookService;
// import fpmislata.bookstore.c_domain.usecase.book.interfaces.BookFindAllUseCase;

// @Component
// @AllArgsConstructor
// public class BookFindAllUseCaseImpl implements BookFindAllUseCase {

//     private final BookService bookService;

//     @Override
//     public List<Book> execute(Integer page, Integer pageSize) {
//         return bookService.findAll();
//     }
// }