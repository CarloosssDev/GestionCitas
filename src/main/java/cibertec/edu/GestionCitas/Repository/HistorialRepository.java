package cibertec.edu.GestionCitas.Repository;

import cibertec.edu.GestionCitas.Entity.Historial;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistorialRepository extends CrudRepository<Historial, Long> {
    List<Historial> findByPacienteId(Long Id);
    List<Historial> findByMedicoId(Long Id);
}
