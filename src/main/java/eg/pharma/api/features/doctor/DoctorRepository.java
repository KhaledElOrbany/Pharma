package eg.pharma.api.features.doctor;

import eg.pharma.api.features.doctorClass.DoctorClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findAllByDoctorClass(DoctorClass doctorClass);
}
