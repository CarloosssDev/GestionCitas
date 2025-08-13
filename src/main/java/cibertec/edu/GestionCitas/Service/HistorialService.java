package cibertec.edu.GestionCitas.Service;

import cibertec.edu.GestionCitas.Entity.Historial;
import cibertec.edu.GestionCitas.Repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HistorialService {
    @Autowired
    private HistorialRepository historialRepository;

    public Historial crearHistorial(Historial historial) {
        historial.setFecha(LocalDate.now());
        return historialRepository.save(historial);
    }

    public List<Historial> listarPorMedicoId(Long Id) {
        return historialRepository.findByMedicoId(Id);
    }
}
