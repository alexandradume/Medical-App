package com.example.demo1.domain;

public class Client extends Entity<String>{
    private String username;
    private String parola;
    private String Nume;
    private String Oras;

    public Client(String username, String parola, String nume, String oras) {
        super(username);
        this.username = username;
        this.parola = parola;
        Nume = nume;
        Oras = oras;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getOras() {
        return Oras;
    }

    public void setOras(String oras) {
        Oras = oras;
    }

    @Override
    public String toString() {
        return "Client{" +
                "username='" + username + '\'' +
                ", parola='" + parola + '\'' +
                ", Nume='" + Nume + '\'' +
                ", Oras='" + Oras + '\'' +
                '}';
    }
}
