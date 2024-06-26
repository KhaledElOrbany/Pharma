package eg.pharma.doctor;

import eg.pharma.doctor.dto.DoctorMapper;
import eg.pharma.doctor.dto.DoctorRequest;
import eg.pharma.doctor.dto.DoctorResource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorMapper doctorMapper, DoctorRepository doctorRepository) {
        this.doctorMapper = doctorMapper;
        this.doctorRepository = doctorRepository;
    }

    public DoctorResource getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
        return doctorMapper.toResource(doctor);
    }

    public List<DoctorResource> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctorMapper.toResourceList(doctors);
    }

    public DoctorResource createDoctor(DoctorRequest doctorRequest) {
        Doctor doctor = doctorMapper.toEntity(doctorRequest);
        doctor = doctorRepository.save(doctor);
        return doctorMapper.toResource(doctor);
    }

    public DoctorResource updateDoctor(Long id, DoctorRequest doctorRequest) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
        doctor = doctorMapper.updateEntity(doctor, doctorRequest);
        doctor = doctorRepository.save(doctor);
        return doctorMapper.toResource(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
