package com.intproject.DSOtool.data;


import com.intproject.DSOtool.data.enums.RoleEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Enumeration;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(nullable = false , unique = true)
    private String username;

    @NotNull
    @Column(nullable = false , unique = true)
    private String emailadress;

    @NotNull
    @Column(nullable = false)
    private String firstname;

    @NotNull
    @Column(nullable = false)
    private String lastname;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotNull
    @Column
    private Long role_id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles;

    public User( String username,
                 String emailadress,
                 String firstname,
                 String lastname,
                 String password,
                 Long role_id) {
        this.username = username;
        this.emailadress = emailadress;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.role_id = role_id;

    }

    public User() {
    }

    public User(User user) {
        this.emailadress = user.getEmailadress();
        this.username = user.getUsername();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.roles = user.getRoles();
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

    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Role role) {
        roles.add(role);
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}
