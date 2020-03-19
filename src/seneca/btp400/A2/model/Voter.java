package seneca.btp400.A2.model;

public class Voter {

    private int id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private boolean voted;
    //TODO:password and verification need to be implemented

    public Voter(){
        this (0,"","","",true);
    }

    public Voter(int id, String fname, String lname, String email, boolean voted){
        setID(id);
        setFname(fname);
        setLname(lname);
        setEmail(email);
        setVoted(voted);
    }

    public void setID(int id){
        this.id=id;
    }

    public void setFname(String fname){
        this.fname=fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email){
        this.email= email;
    }

    public void setVoted(boolean voted){
        this.voted=voted;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public int getId(){
        return id;
    }

    public String getPassword(){
        return password;
    }
    public String getFullName(){
        return lname+", "+fname;
    }



    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", voted=" + voted +
                '}';
    }

    //todo: Implement the equals method and hashcode method
}
