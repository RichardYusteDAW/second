package fpmislata.bookstore.b_presentation.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fpmislata.bookstore.b_presentation.admin.mapper.BookMapper;
import fpmislata.bookstore.b_presentation.admin.model.BookCollection;
import fpmislata.bookstore.b_presentation.admin.model.BookDetail;
import fpmislata.bookstore.b_presentation.common.Paginator;
import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookCountAdminUseCase;
import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookCreateAdminUseCase;
import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookDeleteAdminUseCase;
import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookFindByIsbnAdminUseCase;
import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookGetAllAdminUseCase;
import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookUpdateAdminUseCase;
import fpmislata.bookstore.c_domain._2service.model.Book;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(BookController.ENDPOINT)
public class BookController {

    private final BookGetAllAdminUseCase bookGetAllAdminUseCase;
    private final BookFindByIsbnAdminUseCase bookFindByIsbnAdminUseCase;
    private final BookCreateAdminUseCase bookCreateAdminUseCase;
    private final BookUpdateAdminUseCase bookUpdateAdminUseCase;
    private final BookCountAdminUseCase bookCountAdminUseCase;
    private final BookDeleteAdminUseCase bookDeleteAdminUseCase;

    @Value("${url}")
    private String URL;
    public static final String ENDPOINT = "/api/admin/books";

    @GetMapping()
    public ResponseEntity<Paginator<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {

        List<Book> bookList = bookGetAllAdminUseCase.execute(page - 1, size);
        List<BookCollection> bookCollectionList = BookMapper.INSTANCE.toBookCollectionList(bookList);
        Integer total = bookCountAdminUseCase.execute();
        Paginator<BookCollection> paginator = new Paginator<>(bookCollectionList, total, page, size, URL + ENDPOINT);

        return ResponseEntity.ok(paginator);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDetail> findByIsbn(@PathVariable String isbn) {
        Book book = bookFindByIsbnAdminUseCase.execute(isbn);
        BookDetail bookDetail = BookMapper.INSTANCE.toBookDetail(book);

        return ResponseEntity.ok(bookDetail);
    }

    @PostMapping()
    public ResponseEntity<Long> create(@RequestBody Book book) {
        return new ResponseEntity<>(bookCreateAdminUseCase.execute(book), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Long> update(@RequestBody Book book) {
        return ResponseEntity.ok(bookUpdateAdminUseCase.execute(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookDeleteAdminUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}