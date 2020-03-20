package seneca.btp400.A2.dao;
import java.sql.*;

import seneca.btp400.A2.model.Voter;
import seneca.btp400.A2.util.dbConnect;

/**
 * This class takes care of any operations that have to be
 * performed on the database
 */
public class dbAccessObj {

    private dbConnect db;
    private ResultSet resultSet;
    private Statement statement;//review what this is


    public dbAccessObj() throws SQLException {
        db = new dbConnect();
        statement = db.getConnection().createStatement();
    }


    public ResultSet getVoterData (String email) throws SQLException{
        return statement.executeQuery("select * from students where email like '"+email+"'");
    }


    public Voter buildVoter (String email) throws SQLException{
        Voter voter = new Voter();
        resultSet = getVoterData(email);
        if(resultSet.next()){
            voter.setID(resultSet.getInt("idStudent"));
            voter.setFname(resultSet.getString("fname"));
            voter.setLname(resultSet.getString("lname"));
            voter.setEmail(email);
            voter.setVoted(resultSet.getBoolean("voted"));
            voter.setPassword(resultSet.getString("password"));
        }
        return voter;
    }

    public void AddVote(int ID) throws SQLException {

        statement.execute("update candidates set votes=votes+1 where idCandidate ="+ID);


    }




}
