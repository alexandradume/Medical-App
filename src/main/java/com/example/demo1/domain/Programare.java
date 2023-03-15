package com.example.demo1.domain;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Programare extends Entity<Integer>{

    public String getUsername2() {
        return username2;
    }

    public String getLocatie() {
        return locatie;
    }

    public LocalDate getDataProgramare() {
        return dataProgramare;
    }

    public LocalTime getTimpProgramare() {
        return timpProgramare;
    }

    public Integer getPret() {
        return pret;
    }

    public Programare(Integer id, String username1, String username2, String locatie, LocalDate dataProgramare, LocalTime timpProgramare, Integer pret) {
        super(id);
        this.id = id;
        this.username1 = username1;
        this.username2 = username2;
        this.locatie = locatie;
        this.dataProgramare = dataProgramare;
        this.timpProgramare = timpProgramare;
        this.pret = pret;
    }

    private Integer id;
    private String username1;
    private String username2;
    private String locatie;
    private LocalDate dataProgramare;
    private LocalTime timpProgramare;
    private Integer pret;


    @Override
    public Integer getId() {
        return id;
    }

    public String getUsername1() {
        return username1;
    }

    @Override
    public String toString() {
        return "Programare{" +
                "id=" + id +
                ", username1='" + username1 + '\'' +
                ", username2='" + username2 + '\'' +
                ", locatie='" + locatie + '\'' +
                ", dataProgramare=" + dataProgramare +
                ", timpProgramare=" + timpProgramare +
                ", pret=" + pret +
                '}';
    }
}
