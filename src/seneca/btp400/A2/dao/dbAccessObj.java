package seneca.btp400.A2.dao;
import java.sql.*;

import seneca.btp400.A2.util.dbConnect;

/**
 * @author Ruby Anne Bautista, Daniel Derich
 * @since 2020-03-21
 * @version 2.0
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

    /**
     *
     * @return All Candidate's id, first name and last name
     * @throws SQLException
     */
    public ResultSet getCandidates () throws SQLException{
        return statement.executeQuery("Select idCandidate, fname, lname from candidates;");
    }

    /**
     * Changes voter's status to true
     * @param ID
     * @throws SQLException
     */
    public void setVotedTrue(int ID) throws SQLException{
        statement.execute("update students set voted = true where idStudent ="+ ID);
    }

	// ADMINISTRATOR STATEMENTS

	// add new voter
	public void newVoter(int pst, String first, String last, String pEmail, String ppass) throws SQLException {
		statement.execute(
				"insert into students (idStudent, fname, lname, email, password, voted) values (" + pst + ", " + "'"
						+ first + "', '" + last + "', '" + pEmail + "', '" + ppass + "', " + false + ");");
	}

	// add new voter, compares user input to databsae
	public ResultSet compareVoter(int pst, String pEmail) throws SQLException {
		return statement
				.executeQuery("select * from students where email like '" + pEmail + "' OR idStudent = " + pst + ";");
	}

	public ResultSet getVotingResults() throws SQLException { // for Admin
		return statement.executeQuery("select * " + 
				"from candidates c join students s " + 
				"where s.idStudent = c.idCandidate;");
	}

	public ResultSet getAdmin(String email) throws SQLException {
		return statement.executeQuery("select * from admins where email like '" + email + "';");
	}
	
	public void setNewAdminPassword(int pId, String newPass) throws SQLException {
		statement.execute("update admins set password ='" + newPass + "' where idAdmin =" + pId + ";");
	}
}