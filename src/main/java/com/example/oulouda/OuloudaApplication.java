package com.example.oulouda;

import com.example.oulouda.entities.Patient;
import com.example.oulouda.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class OuloudaApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(OuloudaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       for (int i=0;i<50;i++)
       {
           patientRepository.save(new Patient(null,"aymen"+i,new Date(),Math.random()>0.5?true:false,(int)(Math.random()*1000))) ;
       }

        Page<Patient> patients =patientRepository.findAll(PageRequest.of(1,5));
        System.out.println("totaL pages="+patients.getTotalPages());
        System.out.println("totaL elements="+patients.getTotalElements());
        System.out.println("number"+patients.getNumber());

        System.out.println(patients.getTotalElements());
        System.out.println(patients.getNumber());
        List<Patient> content =patients.getContent();
        List<Patient> byMalade=patientRepository.findByMalade(true);
        Page<Patient> byMalade1= patientRepository.findByMalade(true, PageRequest.of(0,5));
        List<Patient> patientList=patientRepository.chercherPatient("%z%",100);
        byMalade1.forEach(patient -> {
            System.out.println("********************************");
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getScore());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.isMalade());
        });
        System.out.println("********************************");
        Patient patient=patientRepository.findById(new Long(1)).orElse(null);
                if(patient!=null){
                    System.out.println(patient.getNom());
                    System.out.println(patient.isMalade());
                }
                patient.setScore(800);
                patientRepository.save(patient);
                patientRepository.deleteById(1l);


    }
}
