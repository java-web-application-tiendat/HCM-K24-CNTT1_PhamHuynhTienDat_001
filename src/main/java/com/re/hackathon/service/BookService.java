package com.re.hackathon.service;

import com.re.hackathon.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final List<Book> bookList = new ArrayList<>();

    public BookService() {
        bookList.add(new Book(1L, "Java Basics", "Nguyen Van A", 10, "https://via.placeholder.com/80"));
        bookList.add(new Book(2L, "Spring Boot", "Tran Thi B", 5, "https://via.placeholder.com/80"));
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void saveOrUpdate(Book book) {
        if (book == null) return;

        if (book.getId() == null) {
            long newId = bookList.size() + 1;
            book.setId(newId);
            bookList.add(book);
        } else {
            getBookByID(book.getId()).ifPresent(old -> {
                old.setTitle(book.getTitle());
                old.setAuthor(book.getAuthor());
                old.setQuantity(book.getQuantity());
                old.setCoverImage(book.getCoverImage());
            });
        }
    }

    public Optional<Book> getBookByID(Long id) {
        return bookList.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    public void deleteBook(Long id) {
        bookList.removeIf(b -> b.getId().equals(id));
    }
}
