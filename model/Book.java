package com.tap.model;
/**pojo class for books */


public class Book{
    private int ISBN;
    private String name;
    public int getISBN() {
        return ISBN;
    }
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Book(int ISBN, String name) {
        this.ISBN = ISBN;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Book ISBN: " + ISBN + " , name: "  + name ;
    }
    public Book(){};

    

}