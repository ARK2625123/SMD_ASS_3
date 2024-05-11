package com.example.smd_3;

public class pwd {
    private String uname,pass,url;

    public pwd(String uname, String pass, String url) {
        this.uname = uname;
        this.pass = pass;
        this.url = url;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
