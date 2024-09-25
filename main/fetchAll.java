package com.tap.main;

import java.util.List;

import com.tap.daoImplementation.BookDaoImplementation;
import com.tap.model.Book;

public class fetchAll {
    
    public static void main(String [] args){
        System.out.println("display all books");
         BookDaoImplementation obj = new BookDaoImplementation();
         List<Book> books = obj.fetchAllBooks();

         for(Book book :books){
            System.out.println(book);
         }
    }

}
