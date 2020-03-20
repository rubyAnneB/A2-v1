package seneca.btp400.A2.util;

import java.sql.*;

/**
 * This class takes care of connecting the application to
 * the database
 */
public class dbConnect {

    private Connection connection;


    public Connection getConnection(){
        try{
            connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/a2votingapp?serverTimezone=UTC","root","abcd");

        }catch(SQLException err){
            System.out.println("There was an error in connecting to the database");
            err.printStackTrace();
        }

        return connection;


    }


}
