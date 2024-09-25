package com.tap.main;

import java.util.Scanner;

import com.tap.daoImplementation.BookDaoImplementation;
import com.tap.model.Book;

public class fetchOneBook {

    public static void main(String[] args) {
        System.out.println("fetch one book based on id of the book");
        BookDaoImplementation fetch_one_Book = new BookDaoImplementation();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the book id:- ");
        Book obj = fetch_one_Book.fetchBook(sc.nextInt());
        System.out.println(obj!=null?obj:"book not exsist");
        sc.close();

    }
    
}
