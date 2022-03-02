package org.example.Data.Entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "\"users\"")
public class ELogin implements Serializable{

    @Id
    @Column(name = "\"id\"")
    private Integer user_ID;

    @Column(name = "\"email\"")
    private String user_email;

    @Column(name = "\"name\"")
    private String user_name;

    @Column(name = "\"password\"")
    private String user_password;

    public ELogin(){}

    public ELogin(String MailLogin, String Password){

        this.user_email = MailLogin;
        this.user_password = Password;
    }

    public ELogin(int ID, String UserName){

        this.user_ID = ID;
        this.user_name = UserName;
    }

    public Integer getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Integer user_ID) {
        this.user_ID = user_ID;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
