package com.example.demo1.domain;

public class DateProgramari extends Entity<String>{
     private String username;
     private String locatie;
     private Integer pret;

    public DateProgramari(String username, String locatie, Integer pret) {
        super(username);
        this.username = username;
        this.locatie = locatie;
        this.pret = pret;
    }

    public String getUsername() {
        return username;
    }

    public String getLocatie() {
        return locatie;
    }

    public Integer getPret() {
        return pret;
    }

    @Override
    public String toString() {
        return "DateProgramari{" +
                "username='" + username + '\'' +
                ", locatie='" + locatie + '\'' +
                ", pret=" + pret +
                '}';
    }
}
