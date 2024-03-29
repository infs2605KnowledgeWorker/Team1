/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knowledgework.Resources;

/**
 *
 * @author aliso
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aliso
 */
public class Database{
  
public static Connection conn;
     public static void openConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:knowledgeworkDB.db");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
     
    public ResultSet getResultSet(String sqlstatement)throws SQLException{
        openConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sqlstatement);
        return rs;
    }
     
   
public static void createCategoryTable()throws SQLException{
    openConnection();

Statement st = conn.createStatement();

String createQuery = "CREATE TABLE IF NOT EXISTS Categories"
        +"(category_name TEXT NOT NULL"
        + ",colour TEXT NOT NULL);";
st.execute(createQuery);
st.close();
}

public static void createEntryTable()throws SQLException{
    openConnection();
    Statement st = conn.createStatement();
String createEntryQuery = "CREATE TABLE IF NOT EXISTS Entry"
        +"(start_time TEXT "
        + " ,end_time TEXT"
        + " ,duration TEXT"
        + " ,description TEXT NOT NULL"
        +",category_name TEXT NOT NULL);";
st.execute(createEntryQuery);

st.close();
}

public static void createTaskTable()throws SQLException{
    PreparedStatement createTaskTable = null;
    PreparedStatement insertData = null;
    ResultSet rs = null;
    openConnection();
Statement st = conn.createStatement();
String createTaskQuery = "CREATE TABLE IF NOT EXISTS Tasks"
        + "(title TEXT NOT NULL"
        + " ,description TEXT NOT NULL"
        +" ,do_date TEXT"
        +" ,due_date TEXT"
        +" ,priority INTEGER;";

st.execute(createTaskQuery);
  //create dummy data for table 

st.close();
}
}
