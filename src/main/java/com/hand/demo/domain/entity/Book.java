package com.hand.demo.domain.entity;

public class Book{

    private Long id = 100L;
    private String name = "asd";
    private String writer = "asd";
    private String introduction = "asd";

    public Book() {
        super();
    }

    public Book(Long id, String name, String writer, String introduction) {
        super();
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.introduction = introduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
