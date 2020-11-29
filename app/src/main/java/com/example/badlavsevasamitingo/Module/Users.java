package com.example.badlavsevasamitingo.Module;

public class Users {
    private  String username,emailaddress,password,ngocode;
    public Users()
    {

    }

    public Users(String username, String emailaddress, String password, String ngocode) {
        this.username = username;
        this.emailaddress = emailaddress;
        this.password = password;
        this.ngocode = ngocode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNgocode() {
        return ngocode;
    }

    public void setNgocode(String ngocode) {
        this.ngocode = ngocode;
    }
}
