package org.example.Data.MyData;

import org.example.Data.Entity.ELogin;

public class DLogin {


    private Integer user_ID;
    private String user_email;
    private String user_name;
    private String user_password;
    private String Msg;

    public DLogin(){}

    public DLogin(ELogin login){
        this.user_ID = login.getUser_ID();
        this.user_email = login.getUser_email();
        this.user_name = login.getUser_name();
        this.user_password = login.getUser_password();
    }

    public DLogin(String MailLogin, String Password){
        this.user_email = MailLogin;
        this.user_password = Password;
    }

    public DLogin(String Msg, int ID, String UserName){
        this.Msg = Msg;
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


    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
}
