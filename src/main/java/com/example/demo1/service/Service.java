package com.example.demo1.service;

import com.example.demo1.domain.*;
import com.example.demo1.repo.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Service {
    private final Repository<String, Client> clientRepository;
    private final Repository<String, Doctor> doctorRepository;
    private final Repository<Integer, Programare> programareRepository;

    private final Repository<String, DateProgramari> dateProgramariRepository;

    private final Repository<Integer, Nota> noteRepository;




    public Service(Repository<String, Client> clientRepository, Repository<String, Doctor> doctoriRepository, Repository<Integer, Programare> programareRepository, Repository<String, DateProgramari> dateProgramariRepository, Repository<Integer, Nota> noteRepository) {
        this.clientRepository = clientRepository;

        this.doctorRepository = doctoriRepository;
        this.programareRepository = programareRepository;
        this.dateProgramariRepository = dateProgramariRepository;
        this.noteRepository = noteRepository;
    }


    public Iterable<Client> getClienti() {
        return clientRepository.findAll();
    }


    public Iterable<Doctor> getDoctori() {
        return doctorRepository.findAll();
    }
    public Iterable<DateProgramari> getDateProgramari() {
        return dateProgramariRepository.findAll();
    }

    public Iterable<Programare> getProgramari() {
        return programareRepository.findAll();
    }


    public Iterable<Nota> getNote() {
        return noteRepository.findAll();
    }


    public Iterable<Programare> getProgramariForDoctor(String doctor){
        List<Programare> programari = new ArrayList<>();
        for(Programare programare:getProgramari()){
            if(Objects.equals(programare.getUsername2(), doctor)){
                System.out.println(programare.getUsername2());
                programari.add(programare);}
        }
        return programari;
    }

    public Iterable<Programare> getProgramariForClients(String client){
        List<Programare> programari = new ArrayList<>();
        for(Programare programare:getProgramari()){
            if(Objects.equals(programare.getUsername1(), client)){
                programari.add(programare);}
        }
        return programari;
    }



    public int addClient(String username, String parola,String nume, String oras)  {

        Client client = new Client (username,parola,nume,oras);
        if(Objects.equals(username, "") || Objects.equals(parola, "") || Objects.equals(nume, "") || Objects.equals(oras, ""))
            return -1;
        clientRepository.save(client);
        for(Client clientt: clientRepository.findAll()) {
            if (Objects.equals(clientt.getUsername(), username))
                return 1;
        }

        return 0;
    }
    public Client gasesteClient(String username){
        for(Client client: clientRepository.findAll())
            if(Objects.equals(client.getUsername(), username))
                return client;
        return null;
    }

    public DateProgramari gasesteDateProgramari(String username){
        for(DateProgramari date: dateProgramariRepository.findAll()){
            if(Objects.equals(date.getUsername(), username))
                return date;}
        return null;
    }
    public int addProgramare(String username, String specializare, LocalDate date , LocalTime time)  {

        Client client = gasesteClient(username);
        Doctor doctor = gasesteDoctor(client.getOras(), specializare);
        if(Objects.equals(doctor.getUsername(), "a"))
            return 1;
        if(!validateHour(doctor.getUsername(), time, date))
            return -1;
        DateProgramari dateProgramari= gasesteDateProgramari(doctor.getUsername());

        Programare programare = new Programare (maximId(),username,doctor.getUsername(),dateProgramari.getLocatie(), date, time ,dateProgramari.getPret());
        programareRepository.save(programare);

        return 0;
    }

    public Doctor gasesteDoctor(String oras, String specializare) {
        for(Doctor doctor: doctorRepository.findAll()){
            if(Objects.equals(doctor.getOras(), oras) && Objects.equals(specializare, doctor.getSpecializare()))
                return doctor;
            }
        return new Doctor("a", " ", " ", " ", " ");
    }


    public int addDoctor(String username, String parola,String nume, String oras, String specializare)  {

        Doctor doctor = new Doctor (username,parola,nume,oras,specializare);
        if(Objects.equals(username, "") || Objects.equals(parola, "") || Objects.equals(nume, "") || Objects.equals(oras, "") || Objects.equals(specializare, ""))
            return -1;
        for(Doctor doctorr: doctorRepository.findAll()) {
            if (Objects.equals(doctorr.getUsername(), username))
                return 1;
        }

        doctorRepository.save(doctor);
        return 0;
    }

    public boolean validate(String username, String password) {
        for(Doctor doctor: doctorRepository.findAll())
            if(Objects.equals(doctor.getUsername(), username) && Objects.equals(doctor.getParola(), password))
                return true;
        return false;
    }

    public int maximId(){
        int maxim = 0;
        for(Programare programare: getProgramari())
            if(programare.getId() > maxim)
                maxim = programare.getId();
        return maxim+1;
    }

    public int maximIdNote(){
        int maxim = 0;
        for(Nota nota: getNote())
            if(nota.getId() > maxim)
                maxim = nota.getId();
        return maxim+1;
    }
    public Programare removeProgramare(Integer id) {
        Integer programare = programareRepository.remove(id);
        return null;
    }

    public boolean validateClient(String username, String password) {
        for(Client client: clientRepository.findAll())
            if(Objects.equals(client.getUsername(), username) && Objects.equals(client.getParola(), password))
                return true;
        return false;
    }

    public boolean validateHour(String username, LocalTime time, LocalDate date){
        for(Programare programare: getProgramari())
            if(Objects.equals(programare.getUsername2(), username)  && Objects.equals(programare.getDataProgramare(), date) && Objects.equals(programare.getTimpProgramare(), time))
                return false;
        return true;
    }


    public Double medie(){
        int med = 0;
        Iterable<Nota> note = noteRepository.findAll();
        int numar = 0;
        for(Nota nota: note){
            med = med + nota.getValoare();
            numar++;}
        double m = med/numar;

        return m;
    }
    public int addNota(Integer valoare, String descriere)  {

        Nota nota = new Nota (maximIdNote(), valoare, descriere);
        noteRepository.save(nota);
        return 0;
    }

}