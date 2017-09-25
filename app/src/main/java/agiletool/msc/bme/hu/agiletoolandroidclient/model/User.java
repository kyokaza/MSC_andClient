package agiletool.msc.bme.hu.agiletoolandroidclient.model;


import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;

    private String firstName;
    private String lastName;
    private String username;
    private String email;

    private String password;

    private List<String> roles;
    private List<String> projects;

    public User() {
        roles = new ArrayList<>();
        projects = new ArrayList<>();
    }

    public User(String firstName, String lastName, String username, String email, String password, List<String> roles, List<String> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.projects = projects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public void addRole(String... roles) {
        for(String role : roles) {
            this.roles.add(role);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", projects=" + projects +
                '}';
    }
}
