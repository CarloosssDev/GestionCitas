package cibertec.edu.GestionCitas.Controller;
import cibertec.edu.GestionCitas.Entity.*;
import cibertec.edu.GestionCitas.Service.CitaService;
import cibertec.edu.GestionCitas.Service.HistorialService;
import cibertec.edu.GestionCitas.Service.MedicoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private CitaService citaService;
    @Autowired
    private HistorialService historialService;

    @GetMapping()
    public String MostrarPanel(HttpSession httpSession, Model model) {
        Medico medico = (Medico) httpSession.getAttribute("medico");
        model.addAttribute("medico", medico);
        return "Medico/Panel";
    }

    @GetMapping("/CitasMedico")
    public String CitasMedico(HttpSession httpSession, Model model) {
        Medico medico =  (Medico) httpSession.getAttribute("medico");
        if(medico == null) {
            return "Auth/Acceder :: accederFragment";
        }
        List<Cita> citas = citaService.listarPorMedicoId(medico.getId());
        model.addAttribute("citas", citas);
        return "Medico/CitasMedico :: citasFragment";
    }

    @GetMapping("/HistorialMedico")
    public String HistorialMedico(HttpSession httpSession, Model model) {
        Medico medico =  (Medico) httpSession.getAttribute("medico");
        if(medico == null) {
            return "Auth/Acceder :: accederFragment";
        }
        List<Historial> historiales = historialService.listarPorMedicoId(medico.getId());
        model.addAttribute("historiales", historiales);
        return "Medico/HistorialMedico :: historialesFragment";
    }

    @GetMapping("/RegistrarHistorial")
    public String MostrarRegistrarHistorial(HttpSession httpSession, Model model) {
        Medico medico =  (Medico) httpSession.getAttribute("medico");
        List<Paciente> pacientes = citaService.listarPacientesPorMedicoId(medico.getId());
        System.out.println(pacientes);
        if(pacientes.isEmpty()) {
            model.addAttribute("mensaje", "No tienes ningún paciente");
            return "Medico/HistorialMedico :: historialesFragment";
        }
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("historial", new Historial());
        return "Medico/RegistrarHistorial :: registrarHistorialFragment";
    }

    @PostMapping("/RegistrarHistorial")
    public String RegistrarHistorial(@ModelAttribute Historial historial, HttpSession httpSession, Model model) {
        Medico medico =  (Medico) httpSession.getAttribute("medico");
        historial.setMedico(medico);
        historialService.crearHistorial(historial);
        List<Historial> historiales = historialService.listarPorMedicoId(medico.getId());
        model.addAttribute("historiales", historiales);
        return "Medico/HistorialMedico :: historialesFragment";
    }

    @GetMapping("/PerfilMedico")
    public String MostrarPerfilMedico(HttpSession httpSession, Model model) {
        Medico medico =  (Medico) httpSession.getAttribute("medico");
        if(medico == null) {
            return "Auth/Acceder :: accederFragment";
        }
        model.addAttribute("medico", medico);
        return "Medico/PerfilMedico :: perfilMedicoFragment";
    }

    @PostMapping("/ActualizarPerfil")
    public String ActualizarPerfil(@ModelAttribute Medico medico, HttpSession httpSession, Model model) {
        Medico medicoActualizado = medicoService.actualizarMedico(medico);
        httpSession.setAttribute("medico", medicoActualizado);
        model.addAttribute("mensaje", "Actualizado correctamente");
        return "Medico/PerfilMedico :: perfilMedicoFragment";
    }
}
