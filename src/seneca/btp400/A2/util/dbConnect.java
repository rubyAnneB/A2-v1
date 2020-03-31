package seneca.btp400.A2.util;

import java.sql.*;

/**
 * This class takes care of connecting the application to
 * the database
 * @author Ruby Anne Bautista
 * @since 2020-03-18
 * @version 1.1
 */
public class dbConnect {

    private Connection connection;


    /**
     * Establishes connection with the database
     * @return Connection formed with the database
     */
    public Connection getConnection(){
        try{
            //connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/a2votingapp?serverTimezone=UTC","root","abcd");
           connection=  DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-01.cleardb.net:3306/heroku_748cc996cb3eb40","bf58891033afe3","aad37c0f");


        }catch(SQLException err){
            System.out.println("There was an error in connecting to the database");
            err.printStackTrace();
        }

        return connection;


    }


}
