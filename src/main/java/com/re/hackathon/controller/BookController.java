package com.re.hackathon.controller;


import com.re.hackathon.model.Book;
import com.re.hackathon.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping({"/","/books"})
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public String list(Model model,
                       @RequestParam(name = "keyword", defaultValue = "") String keyword){
        List<Book> allItems = service.getBookList();
        model.addAttribute("books", allItems);
        return "book-list";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("book", new Book()); // phải là "book"
        return "book-form";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable(name = "id") Long id, Model model) {
        Book book = service.getBookByID(id).orElse(new Book()); // tránh Optional rỗng
        model.addAttribute("book", book);
        return "book-form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book-form";
        }
        service.saveOrUpdate(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        service.deleteBook(id);
        return "redirect:/books";
    }
}

