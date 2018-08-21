package com.hand.demo.api.service.impl;


import com.github.pagehelper.PageHelper;
import com.hand.demo.domain.entity.Book;
import com.hand.demo.api.service.BookService;
import com.hand.demo.domain.xxx.Page;
import com.hand.demo.infra.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> findAll(Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return bookMapper.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookMapper.findById(id);
    }

    @Override
    public void insertByBook(Book book) {
        bookMapper.save(book);
    }

    @Override
    public void update(Book book) {
        bookMapper.update(book);
    }

    @Override
    public Long delete(Long id) {
        bookMapper.delete(id);
        return id;
    }


}
