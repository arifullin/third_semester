package ru.kpfu.entities;
import java.lang.Boolean;

public class User {
    private String soap;
    private String password;
    private boolean man;
    private boolean subscribe;

    public User(String soap, String password, boolean man, boolean subscribe) {
        this.soap = soap;
        this.password = password;
        this.man = man;
        this.subscribe = subscribe;
    }
    public boolean equals(User another){
        if ((this.soap.equals(another.getSoap()))&&
                (this.password.equals(another.getPassword()))&&
                        (this.man == another.isMan())){
            return true;
        }
        return false;
    }

    public String getSoap() {
        return soap;
    }

    public boolean isMan() {
        return man;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

    public String getPassword() {
        return password;
    }
    public static String[] toArray(User user){
        String[] x = new String[4];
        x[0] = user.getSoap();
        x[1] = user.getPassword();
        x[2] = new Boolean(user.isMan()).toString();
        x[3] = new Boolean(user.isSubscribe()).toString();
        return x;
    }
}
