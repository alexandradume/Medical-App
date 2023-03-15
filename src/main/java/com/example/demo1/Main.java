package com.example.demo1;

import com.example.demo1.domain.DateProgramari;
import com.example.demo1.repo.ClientDB;
import com.example.demo1.repo.DateProgramariDB;
import com.example.demo1.repo.DoctorDB;
import com.example.demo1.repo.ProgramareDB;
import com.example.demo1.service.Service;

public class Main {
    public static void main(String[] args)  {

        Service service = new Service(new ClientDB(), new DoctorDB(), new ProgramareDB(), new DateProgramariDB());
        for(DateProgramari programari: service.getDateProgramari())
            System.out.println(programari);
        service.removeProgramare(2);
        System.out.println("gata");





    }

}

