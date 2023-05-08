package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.repository.ConsultationRepository;
import com.example.demo.repository.MedecinRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.RendezVousRepository;
import com.example.demo.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {
@Autowired
    PatientRepository patientRepository;
@Autowired
    MedecinRepository medecinRepository;
@Autowired
    RendezVousRepository rendezVousRepository  ;
@Autowired
    ConsultationRepository consultationRepository;
@Autowired
    IHospitalService hospitalService;
public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Mohamed","Hassan","Najet").forEach(name->{
            Patient patient=new Patient();
            patient.setNom(name);
            patient.setDateNaissance(new Date());
            patient.setMalade(false);
            hospitalService.savePatient(patient);
        });

        Stream.of("aymane","Hanane","yasmine").forEach(name->{
            Medecin medecin =new Medecin();
            medecin.setNom(name);
            medecin.setSpecialite(Math.random()>0.?"cardio":"Dentiste");
            medecin.setEmail(name+"@gmail.com");
            hospitalService.saveMedecin(medecin);
        });
        Patient patient=patientRepository.findById(1L).orElse(null);
        Patient patient1=patientRepository.findByNom("Mohamed");
        Medecin medecin=medecinRepository.findByNom("yasmine");
        RendezVous rendezVous=new RendezVous();
        rendezVous.setDate(new Date());
        rendezVous.setStatus(StatusRDV.PENDING);
        rendezVous.setPatient(patient);
        rendezVous.setMedecin(medecin);

hospitalService.saveRDV(rendezVous);
RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
        Consultation consultation=new Consultation();
        consultation.setDateConsultation(new Date());
        consultation.setRapport("Rapport de la consultation");
        consultation.setRendezVous(rendezVous1);
        hospitalService.saveConsultation(consultation);

    }
}
