package com.tap.main;

import java.util.Scanner;

import com.tap.daoImplementation.BookDaoImplementation;
import com.tap.model.Book;


public class deleteBook {
    
    
    
    public static void main(String[] args) {
        System.out.println();
        System.out.println("deletes on record of book");
        Scanner sc = new Scanner(System.in);
        Book obj = new Book();
        System.out.println("enter book id:- ");
        obj.setISBN(sc.nextInt());
        BookDaoImplementation delete_obj = new BookDaoImplementation();
        System.out.println(delete_obj.deleteBook(obj.getISBN())!=0?"book deleted":"wrong ISBN NUmber");
    
        sc.close();
    
    }




}
