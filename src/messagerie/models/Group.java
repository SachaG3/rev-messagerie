package messagerie.models;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Optional;
public class Group {
    private String name;
    private String description;
    private String email;
    private Set<User>users;
    public Group(String name){
        this.name = name;
        users = new HashSet<>();
    }
    public void addUsers(User...users){
        for (User u : users){
            if (this.users.add(u)){
                u.getGroups().add(this);
            }
        }
        this.users.addAll(Arrays.asList(users));
    }

    public boolean removeUsers(User user) {
        if(this.users.remove(user)){
            return user.getGroups().remove(this);
        }
        return false;


    }
    public int count() {
        return this.users.size();
    }
    public Set<User> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(!(obj instanceof Group)){
            return false;
        }
        return this.getName().equals(((Group) obj).name);
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name + "\n" + users.toString();
    }
}
