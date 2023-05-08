package com.example.demo.service;

import com.example.demo.entities.Consultation;
import com.example.demo.entities.Medecin;
import com.example.demo.entities.Patient;
import com.example.demo.entities.RendezVous;
import com.example.demo.repository.ConsultationRepository;
import com.example.demo.repository.MedecinRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private MedecinRepository medecinRepository;

    private PatientRepository patientRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(MedecinRepository medecinRepository, PatientRepository patientRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.medecinRepository = medecinRepository;
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
