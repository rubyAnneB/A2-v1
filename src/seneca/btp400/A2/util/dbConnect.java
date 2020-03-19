package seneca.btp400.A2.util;

import java.sql.*;

/**
 * This class takes care of connecting the application to
 * the database
 */
public class dbConnect {

    private Connection connection;
    private Statement statement; // consider just returning  a connection

    //rewrite this so that you can return a connection instead ?
    public dbConnect(){
        try{
            connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/a2votingapp?serverTimezone=UTC","root","abcd");
            statement= connection.createStatement();
        }catch(SQLException err){
            System.out.println("There was an error in connecting to the database");
            err.printStackTrace();
        }
    }

    public Statement getStatement(){
        return statement;
    }

}
