package com.example.demo1;

import com.example.demo1.domain.DateProgramari;
import com.example.demo1.domain.Nota;
import com.example.demo1.repo.*;
import com.example.demo1.service.Service;

public class Main {
    public static void main(String[] args)  {

        Service service = new Service(new ClientDB(), new DoctorDB(), new ProgramareDB(), new DateProgramariDB(), new NotaDB());
        System.out.println(service.medie());
        System.out.println("gata");






    }

}

