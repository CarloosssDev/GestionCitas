package cibertec.edu.GestionCitas.Repository;

import cibertec.edu.GestionCitas.Entity.Cita;
import cibertec.edu.GestionCitas.Entity.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CitaRepository extends CrudRepository<Cita, Long> {
    @Query("SELECT DISTINCT c.paciente FROM Cita c WHERE c.medico.id = :Id")
    List<Paciente> findPacienteByMedicoId(Long Id);
    List<Cita> findByPacienteId(Long Id);
    List<Cita> findByMedicoId(Long Id);
}
