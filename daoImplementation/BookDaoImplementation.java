/**BookDaoImplementation gives implementation for unimplemented methods present in BookDAO by implementing it*/

package com.tap.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.BookDAO;
import com.tap.model.Book;
import com.tap.util.MyConnector;

public class BookDaoImplementation implements BookDAO {
    
    Connection con;
    MyConnector myConnectionObj;
    PreparedStatement pstmtForInsert;
    PreparedStatement pstmtForDelete;
    PreparedStatement pstmtforfetch;
    PreparedStatement toUpdate;
    Statement stmt;
    Statement stmtforfecthBook;
    ResultSet result_Set;
    ResultSet resultSetforOneBook;

    
    public BookDaoImplementation(){
        myConnectionObj = MyConnector.getConnectorObj();
        con = myConnectionObj.getConnection();
     }
   
   
     @Override
    public int insertBook(Book obj) {
        
        try{
           
            pstmtForInsert = con.prepareStatement("insert into book (name) values(?)");
            pstmtForInsert.setString(1,obj.getName());
            return pstmtForInsert.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(pstmtForInsert!=null){
                    pstmtForInsert.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        return 0;
    }


    @Override
    public int deleteBook(int id) {
        
        try{
            pstmtForDelete = con.prepareStatement("delete from book where ISBN=?");
            pstmtForDelete.setInt(1,id);
            return pstmtForDelete.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(pstmtForDelete!=null){
                    pstmtForDelete.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
       return 0;

    }


    @Override
    public List<Book> fetchAllBooks() {
       List<Book> books_list= new ArrayList<>();
       Book book_obj = null;
        try{
            stmt = con.createStatement();
            
            result_Set =  stmt.executeQuery("select * from book");
            while(result_Set.next()){
                book_obj = new Book(result_Set.getInt(1), result_Set.getString(2));
                books_list.add(book_obj);
            }

            
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
        return books_list;
    }


    @Override
    public Book fetchBook(int id) {
        Book obj = null;
       try{
            pstmtforfetch = con.prepareStatement("select * from book where ISBN = ?");
            pstmtforfetch.setInt(1,id);
            resultSetforOneBook = pstmtforfetch.executeQuery();
            while(resultSetforOneBook.next()){
                obj = new Book(resultSetforOneBook.getInt(1), resultSetforOneBook.getString(2));
            }
            return obj;
            
       }
       catch(SQLException e){
            e.printStackTrace();
       }


       return null;
    }


    @Override
    public int update(int id, String name) {
        
        try{
            toUpdate = con.prepareStatement("update book set name=? where ISBN=?");
            con.setAutoCommit(false);
            toUpdate.setInt(2,id);
            toUpdate.setString(1, name);
            if(toUpdate.executeUpdate()>0){
                con.commit();
            }
            return toUpdate.executeUpdate();
        }
        catch(SQLException e){
            try{
                con.rollback();
            }
            catch(SQLException e2){
                e2.printStackTrace();
            }
            e.printStackTrace();
        }
        finally{
            try{
                con.setAutoCommit(true);
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return 0;
    }






}
