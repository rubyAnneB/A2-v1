package seneca.btp400.A2.model;
/**
 * @author Daniel Derich
 * @since 2020-03-30
 */
public class Candidate extends Voter{
	private int numberOfVotes;
	
	public Candidate() {
		this(0,"","","",true, 0);
	}
	
	public Candidate(int id, String fname, String lname, String email, boolean voted, int votes) {
		super(id, fname, lname, email, voted);
		this.numberOfVotes = votes;
	}
	
	public int getNumberOfVotes() {
		return numberOfVotes;
	}
	
	@Override
    public String toString() {
        return "Candidate{" +
                "id=" + super.getId() +
                ", name='" + super.getFullName() + '\'' +
                ", votes=" + numberOfVotes + 
                '}';
    }
}
