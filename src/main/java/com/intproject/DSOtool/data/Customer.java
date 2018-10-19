package com.intproject.DSOtool.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String companyname;

    @NotNull
    @Column(nullable = false)
    private String emailadress;

    @Column
    private String phonenumber;

    @NotNull
    @Column(nullable = false)
    private String contact;

    public Customer( String companyname, String emailadress, String phonenumber, String contact) {
        this.companyname = companyname;
        this.emailadress = emailadress;
        this.phonenumber = phonenumber;
        this.contact = contact;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getEmailadress() {
        return emailadress;
    }

    public void setEmailadress(String emailadress) {
        this.emailadress = emailadress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
