package messagerie.models;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {
    private String firstname;
    private String lastname;
    private LocalDate bDate;
    private String login;
    private String password;
    private String email;
    private Set<Group>groups;
    public User(){
        this("","",null);
    }
    public User(String firstname, String lastname, LocalDate bDate ){
        this.firstname = firstname;
        this.lastname = lastname;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.bDate = bDate;
        this.groups = new HashSet<>();

    }
    public User(String firstname, String lastname){
        this(firstname, lastname,null);

    }


    public boolean removeFrom(Group group){
        if(this.groups.add(group)){
            group.removeUsers(this);
            return true;
        }
        return false;
    }
    public boolean addIn(Group group) {
        if(this.groups.add(group)){
            group.addUsers(this);
            return true;
        }
        return false;
    }

    public String getFormattedBirthDate(String format) {

    }

    public Date getAge() {
        return Period.between(bDate,LocalDate.now()).getYear();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public User(String email) {
        this.email = email;
    }

    public String getEmail(){
        return lastname+"."+ firstname;
    }


    public Set<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return firstname +" "+ lastname +" ("+ getFormattedBirthDate("dd/MM/yyyy") +")";

    }
    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(!(obj instanceof User)){
            return false;
        }
        return this.getEmail().equals(((User) obj).getEmail());
    }
    @Override
    public int hashCode(){
        return getEmail().hashCode();
    }

}
