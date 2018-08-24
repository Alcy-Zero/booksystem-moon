package com.hand.demo.api.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.demo.domain.entity.Book;
import com.hand.demo.api.service.BookService;
import com.hand.demo.domain.pojo.Page;
import com.hand.demo.infra.mapper.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> findAll(Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<Book> list = bookMapper.findAll();
        //用PageInfo对结果进行包装
        PageInfo pageinfo = new PageInfo(list);
        //测试PageInfo全部属性
        //PageInfo包含了非常全面的分页属性
        logger.info("PageNum:"+(pageinfo.getPageNum()));
        logger.info("PageSize:"+(pageinfo.getPageSize()));
        logger.info("getStartRow:"+(pageinfo.getStartRow()));
        logger.info("getEndRow:"+pageinfo.getEndRow());
        logger.info("getTotal:"+(pageinfo.getTotal()));
        logger.info("getPages:"+(pageinfo.getPages()));
        logger.info("getFirstPage:"+(pageinfo.getFirstPage()));
        logger.info("getLastPage:"+(pageinfo.getLastPage()));
        logger.info("isHasPreviousPage:"+(pageinfo.isHasPreviousPage()));
        logger.info("isHasNextPage:"+(pageinfo.isHasNextPage()));
        return list;
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
