/** BookDAO interface 
 *      incomplete methods to insertBook :- insert/save book
 *                              delete boook :- delete book record
 *                              fetchAllBooks:- fetches all books from the table/database
 *                              fetchBook:- fetchOneBook based on id
 *                              update :- update a book record
 */                     


package com.tap.dao;
import java.util.List;

import com.tap.model.Book;

public interface BookDAO {
        
        int insertBook(Book obj);
        int deleteBook(int id);
        List<Book> fetchAllBooks();
        Book fetchBook(int id);
        int update(int id,String name);

}