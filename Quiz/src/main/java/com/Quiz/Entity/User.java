package com.Quiz.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by c263 on 20.07.2015.
 */

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name", length = 45, nullable = false)
    private String first_name;
    @Column(name = "last_name", length = 45, nullable = false)
    private String last_name;
    @Column(name = "email", length = 65,unique = true, nullable = false)
    private String email;
    @Column(name = "password", length = 45, nullable = false)
    private String password;
    @Column(name = "birthday", nullable = true)
    private java.sql.Date birthday;
    @Column(name = "phone",length = 45, nullable = true)
    private String phone;
    @ManyToOne
    @Column(name="role_id")
    private long role_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }


}
