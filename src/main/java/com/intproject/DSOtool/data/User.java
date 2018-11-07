package com.intproject.DSOtool.data;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "user_name" ,nullable = false , unique = true)
    private String username;

    @NotNull
    @Column(name = "email_adress" ,nullable = false , unique = true)
    private String emailadress;

    @NotNull
    @Column(name = "first_name" ,nullable = false)
    private String firstname;

    @NotNull
    @Column(name = "last_name" ,nullable = false)
    private String lastname;

    @NotNull
    @Column(name = "password" ,nullable = false)
    private String password;

    @ManyToOne
    private Role role;

    public User( String username,
                 String emailadress,
                 String firstname,
                 String lastname,
                 String password) {
        this.username = username;
        this.emailadress = emailadress;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;

    }

    protected User() {
    }

    public User(User user) {
        this.emailadress = user.getEmailadress();
        this.username = user.getUsername();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        //this.roles = user.getRoles();
        this.password = user.getPassword();
        this.id = user.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailadress() {
        return emailadress;
    }

    public void setEmailadress(String emailadress) {
        this.emailadress = emailadress;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoles() {
        return role;
    }

    public void setRole(Role role) {
       this.role = role;
    }
}
