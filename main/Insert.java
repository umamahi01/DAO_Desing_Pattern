package com.tap.main;

import java.util.Scanner;

import com.tap.daoImplementation.BookDaoImplementation;
import com.tap.model.Book;



public class Insert {
    
    public static void main(String [] args){
        System.out.println("save a book");
        Scanner sc = new Scanner(System.in);
        Book obj = new Book();
        BookDaoImplementation insertObj = new BookDaoImplementation();
        System.out.println("enter book name :- ");
        obj.setName(sc.nextLine());
        System.out.println(insertObj.insertBook(obj)!=0?"Data Inserted":"No changes In database");
        sc.close();

    }
    
       

}
