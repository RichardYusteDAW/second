package fpmislata.bookstore.b_presentation.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fpmislata.bookstore.b_presentation.admin.mapper.BookMapper;
import fpmislata.bookstore.b_presentation.admin.model.BookCollection;
import fpmislata.bookstore.b_presentation.common.Paginator;
import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookGetAllAdminUseCase;
import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookInsertAdminUseCase;
import fpmislata.bookstore.c_domain._2service.model.Book;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookGetAllAdminUseCase bookGetAllAdminUseCase;
    private final BookInsertAdminUseCase bookInsertAdminUseCase;

    @Value("${url}")
    private String url;

    @GetMapping("/api/books")
    public ResponseEntity<Paginator<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(required = false) Integer size) {

        try {
            List<Book> bookList = bookGetAllAdminUseCase.execute(0, 10);
            List<BookCollection> bookCollectionList = BookMapper.INSTANCE.toBookCollectionList(bookList);
            Paginator<BookCollection> paginator = new Paginator<>(bookCollectionList, 20, page, size, url + "/books");
            return ResponseEntity.ok(paginator);

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/api/books")
    public ResponseEntity<Long> insert(@RequestBody Book book) {
        try {
            Long bookId = bookInsertAdminUseCase.execute(book);
            return ResponseEntity.ok(bookId);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}