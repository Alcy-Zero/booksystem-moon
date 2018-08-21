package com.hand.demo.infra.mapper;

import com.hand.demo.domain.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    List<Book> findAll();

    Book findById(Long id);

    void save(Book book);

    void update(Book book);

    Long delete(Long id);

}
