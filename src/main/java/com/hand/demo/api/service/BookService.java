package com.hand.demo.api.service;

import com.hand.demo.domain.entity.Book;
import com.hand.demo.domain.pojo.Page;

import java.util.List;

public interface BookService {

    List<Book> findAll(Page page);

    void insertByBook(Book book);

    void update(Book book);

    Long delete(Long id);

    Book findById(Long id);
}
