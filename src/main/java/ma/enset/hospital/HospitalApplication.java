package ma.enset.hospital;

import ma.enset.hospital.entities.*;
import ma.enset.hospital.repositories.ConsultationRepository;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;
import ma.enset.hospital.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication{

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	//une methode qui utilise la notation Bean execute dans le demarrage de l'application
	@Bean

	CommandLineRunner start(
			PatientRepository patientRepository,
			MedecinRepository medecinRepository,
			RendezVousRepository rendezVousRepository,
			ConsultationRepository consultationRepository
	        ){
		return args -> {
			Stream.of("khaoula", "mohamed", "Omaima")
					.forEach(nom -> {
						Patient patient = new Patient();
						patient.setNom(nom);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						patientRepository.save(patient);
					});
			Stream.of("ahmed", "khadija", "fatima")
					.forEach(nom -> {
						Medecin medecin = new Medecin();
						medecin.setNom(nom);
						medecin.setSpecialite(Math.random()>0.5?"dentiste":"pediatre");
						medecinRepository.save(medecin);
					});
			Patient patient = patientRepository.findById(1L).orElse(null);
			Patient patient1 = patientRepository.findByNom("mohamed");
			Medecin medecin1 = medecinRepository.findByNom("ahmed");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(statusRDV.CANCELED);
			rendezVous.setMedecin(medecin1);
			rendezVous.setPatient(patient);
			rendezVousRepository.save(rendezVous);

			RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation (new Date());
			consultation.setRendezvous(rendezVous1);
			consultation.setRapport("Rapport de consultation");
			consultationRepository.save(consultation);
		};

	}
}
