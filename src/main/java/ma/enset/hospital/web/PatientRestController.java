package ma.enset.hospital.web;

import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PatientRestController {
    //@Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patients") //il s'agit d'un controlleur qui navique la liste des patients
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }
}
