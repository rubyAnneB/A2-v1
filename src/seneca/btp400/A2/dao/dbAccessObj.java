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


    public dbAccessObj(){
        db = new dbConnect();
        statement = db.getStatement();
    }

    public ResultSet getVoterData(int ID) throws SQLException {
        return statement.executeQuery("select * from students where idStudent ="+ID);
    }

    public ResultSet getVoterData (String email) throws SQLException{
        return statement.executeQuery("select * from students where email like '%"+email+"%'");
    }

    public Voter buildVoter(int ID) throws SQLException{
        Voter voter = new Voter();
        resultSet = getVoterData(ID);
        if(resultSet.next()){
            voter.setID(ID);
            voter.setFname(resultSet.getString("fname"));
            voter.setLname(resultSet.getString("lname"));
            voter.setEmail(resultSet.getString("email"));
            voter.setVoted(resultSet.getBoolean("voted"));
        }
        return voter;
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

    public String getFullName(int ID){
        String result = "Student not found";

        try{
            resultSet= getVoterData(ID);
            if(resultSet.next()){
                result = resultSet.getString("lname")+ ", "+ resultSet.getString("fname");
            }
        }catch (SQLException err){
            System.out.println("Error in the getFullName");
            err.printStackTrace();
        }

        return result;
    }

    /**
     *
     * @param ID id of the student voting
     * @return whether the student with ID has voted or not, if student is not found, will return true
     */
    public boolean getVoted(int ID){
        boolean result= true;
        try{
            resultSet= getVoterData(ID);
            if(resultSet.next()){
                result = resultSet.getBoolean("voted");
            }else{
                System.out.println("Student not found");
            }

        } catch (SQLException e) {
            System.out.println("Error has occured in Voted method");
            e.printStackTrace();
        }
        return result;
    }

    //TODO: get all candidate names
    /*public String[] getCandidateNames(){
        try{
            resultSet=statement.executeQuery("select * from candidates");

        } catch (SQLException e) {
            System.out.println("Error in getCandidateNames");
            e.printStackTrace();
        }
        return
    }
*/

    //add votes to candidate


}
