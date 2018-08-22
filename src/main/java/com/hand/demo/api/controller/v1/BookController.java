package com.hand.demo.api.controller.v1;


import com.github.pagehelper.PageInfo;
import com.hand.demo.domain.entity.Book;
import com.hand.demo.api.service.BookService;
import com.hand.demo.domain.xxx.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/v1/books")
public class BookController {

    private static final String BOOK_FORM = "bookForm";
    private static final String BOOK_LIST = "bookList";
    private static final String REDIRECT_BOOK = "redirect:/v1/books/list";

    @Autowired
    BookService bookService;

    @GetMapping("/list")
    public String getBookList(ModelMap map,Page page) {
        List<Book> bookList = bookService.findAll(page);
        PageInfo pageInfo = new PageInfo(bookList);
        map.addAttribute("bookList", bookList);
        map.addAttribute("pageNum",page.getPageNum());
        map.addAttribute("lastPage",pageInfo.getLastPage());
        return BOOK_LIST;
    }

    /**
     * 获取创建 Book 表单
     */
    @GetMapping("/create")
    public String createBookForm(ModelMap map) {
        map.addAttribute("book", new Book());
        map.addAttribute("action", "create");
        return BOOK_FORM;
    }
    /**
     * 确定创建 Book，返回bookList界面
     */
    @PostMapping("/create")
    public String postBook(@ModelAttribute Book book) {
        bookService.insertByBook(book);
        return REDIRECT_BOOK;
    }

    /**
     * 获取更新 Book 表单
     * 处理 "/book/update/{id}" 的 GET 请求，通过 URL 中的 id 值获取 Book 信息
     */
    @GetMapping("/update/{id}")
    public String getForm(@PathVariable Long id, ModelMap map) {
        map.addAttribute("book", bookService.findById(id));
        map.addAttribute("action", "update");
        return BOOK_FORM;
    }
    /**
     * 确定更新 Book，返回bookList界面
     */
    @PostMapping("/update")
    public String putBook(@ModelAttribute Book book) {
        bookService.update(book);
        return REDIRECT_BOOK;
    }

    /**
     * 删除 Book,返回bookList界面
     */
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return REDIRECT_BOOK;
    }

}
