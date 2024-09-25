package com.tap.main;

import java.util.Scanner;

import com.tap.daoImplementation.BookDaoImplementation;

public class UpdateBook {
    public static void main(String[] args) {
        System.out.println("updates a book");
        Scanner sc = new Scanner(System.in);
        BookDaoImplementation updateobj = new BookDaoImplementation();
        System.out.println("enter the id of book:- ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("enter the book name:- ");
        String bookName = sc.nextLine();
        System.out.println(updateobj.update(id,bookName)>0?"book name is updated":"wrong id");
        sc.close();
    }
}
