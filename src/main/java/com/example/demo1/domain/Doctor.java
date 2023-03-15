package com.example.demo1.domain;

public class Doctor extends Entity<String>{
    private String username;
    private String parola;
    private String Nume;
    private String Oras;
    private String specializare;

    public Doctor(String username, String parola, String nume, String oras, String specializare) {
        super(username);
        this.username = username;
        this.parola = parola;
        Nume = nume;
        Oras = oras;
        this.specializare = specializare;
    }

    public String getUsername() {
        return username;
    }

    public String getParola() {
        return parola;
    }

    public String getNume() {
        return Nume;
    }

    public String getOras() {
        return Oras;
    }

    public String getSpecializare() {
        return specializare;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "username='" + username + '\'' +
                ", parola='" + parola + '\'' +
                ", Nume='" + Nume + '\'' +
                ", Oras='" + Oras + '\'' +
                ", specializare='" + specializare + '\'' +
                '}';
    }
}
