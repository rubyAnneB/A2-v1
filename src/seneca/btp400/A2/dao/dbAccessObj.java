package seneca.btp400.A2.dao;
import java.sql.*;

import seneca.btp400.A2.model.Voter;
import seneca.btp400.A2.util.dbConnect;

/**
 * @author Ruby Anne Bautista
 * @since 2020-03-21
 * @version 1.0
 *
 * Takes care of any operations that must be performed on the database such as
 * retrieving voter/student information
 */
public class dbAccessObj {

    private dbConnect db;
    private Statement statement;


    /**
     * creates a new dbConnect object;
     * @throws SQLException if there is any problems connecting to the database
     */
    public dbAccessObj() throws SQLException {
        db = new dbConnect();
        statement = db.getConnection().createStatement();
    }

    /**
     * Searches the database for student with the email passed
     * @param email the email the user has- this is a unique value
     * @return ResultSet of the executed query
     * @throws SQLException if any issue selecting * from students
     */
    public ResultSet getVoterData (String email) throws SQLException{
        return statement.executeQuery("select * from students where email like '"+email+"'");
    }


    /**
     * Increments the candidate with the passed ID
     * @param ID candidate's ID
     * @throws SQLException
     */
    public void AddVote(int ID) throws SQLException {
        statement.execute("update candidates set votes=votes+1 where idCandidate ="+ID);
    }

    public ResultSet getCandidates () throws SQLException{
        return statement.executeQuery("Select idCandidate, fname, lname from candidates;");
    }




}
