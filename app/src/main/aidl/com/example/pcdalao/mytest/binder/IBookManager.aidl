package com.example.pcdalao.mytest.binder;

import com.example.pcdalao.mytest.binder.Book;

interface IBookManager{
    List<Book> getBookList();
    void addBook(in Book book);
}