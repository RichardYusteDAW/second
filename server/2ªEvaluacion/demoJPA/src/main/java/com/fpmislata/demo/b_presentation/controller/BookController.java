package com.fpmislata.demo.b_presentation.controller;

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

import com.fpmislata.demo.b_presentation.mapper.AuthorMapper;
import com.fpmislata.demo.b_presentation.mapper.BookMapper;
import com.fpmislata.demo.b_presentation.model.AuthorWebModel;
import com.fpmislata.demo.b_presentation.model.BookWebModel;
import com.fpmislata.demo.b_presentation.model.Paginator;
import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.usecase.author.interfaces.AuthorFindAllByBookIdUseCase;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookCreateUseCase;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookDeleteUseCase;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookFindAllUseCase;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookFindAllWithCountUseCase;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookFindByIdUseCase;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookUpdateUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(BookController.ENDPOINT)
public class BookController {

    private final BookFindAllUseCase bookFindAllUseCase;
    private final BookFindAllWithCountUseCase bookFindAllWithCountUseCase;
    private final BookFindByIdUseCase bookFindByIdUseCase;
    private final BookCreateUseCase bookCreateUseCase;
    private final BookUpdateUseCase bookUpdateUseCase;
    private final BookDeleteUseCase bookDeleteUseCase;
    private final AuthorFindAllByBookIdUseCase authorFindAllByBookIdUseCase;

    @Value("${URL}")
    private String URL;
    public static final String ENDPOINT = "/books";

    @GetMapping()
    public ResponseEntity<List<BookWebModel>> findAll() {
        List<Book> bookList = bookFindAllUseCase.execute();
        List<BookWebModel> bookWebModelList = BookMapper.INSTANCE.toBookWebModelList(bookList);

        return ResponseEntity.ok(bookWebModelList);
    }

    @GetMapping("/paginator")
    public ResponseEntity<Paginator<BookWebModel>> findAllAllWithCount(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        ListWithCount<Book> listWithCount = bookFindAllWithCountUseCase.execute(page, size);
        List<BookWebModel> bookWebModelList = BookMapper.INSTANCE.toBookWebModelList(listWithCount.getList());
        Integer total = listWithCount.getCount();
        String baseUrl = this.URL + ENDPOINT;

        Paginator<BookWebModel> paginator = new Paginator<>(bookWebModelList, total, page, size, baseUrl);

        return ResponseEntity.ok(paginator);
    }

    @GetMapping("/{id}/authors")
    public ResponseEntity<List<AuthorWebModel>> findAllByBookId(@PathVariable Integer id) {
        List<Author> authorList = authorFindAllByBookIdUseCase.execute(id);
        List<AuthorWebModel> authorWebModelList = AuthorMapper.INSTANCE.toAuthorWebModelList(authorList);

        return ResponseEntity.ok(authorWebModelList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        Book book = bookFindByIdUseCase.execute(id);

        return ResponseEntity.ok(book);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody Book book) {
        bookCreateUseCase.execute(book);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody Book book) {
        book.setId(id);
        bookUpdateUseCase.execute(book);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookDeleteUseCase.execute(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}