package ca.sait.itsd;

import java.io.Serializable;

/**
 *
 * @author Carlos J. Garcia Carmona
 */
public class Student implements Serializable {

    // Attributes
    private String name;
    private String id;
    private String email;

    // Constructors
    public Student() {
        name = "";
        id = "";
        email = "";
    }

    public Student(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
