package cibertec.edu.GestionCitas.Controller;

import cibertec.edu.GestionCitas.Entity.Cita;
import cibertec.edu.GestionCitas.Entity.Medico;
import cibertec.edu.GestionCitas.Entity.Paciente;
import cibertec.edu.GestionCitas.Entity.Usuario;
import cibertec.edu.GestionCitas.Service.CitaService;
import cibertec.edu.GestionCitas.Service.MedicoService;
import cibertec.edu.GestionCitas.Service.PacienteService;
import cibertec.edu.GestionCitas.Service.UsuarioService;
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
@RequestMapping("/Paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CitaService citaService;

    @GetMapping
    public String MostrarPanel(HttpSession httpSession, Model model) {
        insert(httpSession);
        Paciente paciente = (Paciente) httpSession.getAttribute("paciente");
        Medico medico = (Medico) httpSession.getAttribute("medico");
        model.addAttribute("paciente", paciente);
        model.addAttribute("medico", medico);
        return "redirect:/Auth";
    }

    @GetMapping("/Panel")
    public String Panel(HttpSession httpSession, Model model) {
        Paciente paciente = (Paciente) httpSession.getAttribute("paciente");
        Medico medico = (Medico) httpSession.getAttribute("medico");
        model.addAttribute("paciente", paciente);
        model.addAttribute("medico", medico);
        return "Paciente/Panel";
    }

    @GetMapping("/ReservarCita")
    public String MostrarReservarCita(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("medicos", medicoService.listarMedicos());
        return "Paciente/ReservarCita :: reservarCitaFragment";
    }

    @PostMapping("/ReservarCita")
    public String ReservarCita(@ModelAttribute Cita cita, HttpSession httpSession, Model model) {
        Paciente paciente = (Paciente) httpSession.getAttribute("paciente");
        if(paciente == null) {
            return "Auth/Acceder :: accederFragment";
        }
        citaService.crearCita(cita, paciente);
        List<Cita> citas = citaService.listarPorPacienteId(paciente.getId());
        model.addAttribute("citas", citas);
        return "Paciente/MisCitas";
    }

    @GetMapping("/MisCitas")
    public String MostrarMisCitas(HttpSession httpSession, Model model) {
        Paciente paciente = (Paciente) httpSession.getAttribute("paciente");
        if(paciente == null) {
            return "Auth/Acceder :: accederFragment";
        }
        List<Cita> citas = citaService.listarPorPacienteId(paciente.getId());
        model.addAttribute("citas", citas);
        return "Paciente/MisCitas :: citasFragment";
    }

    @GetMapping("/PerfilPaciente")
    public String PerfilPaciente(HttpSession httpSession, Model model) {
        Paciente paciente = (Paciente) httpSession.getAttribute("paciente");
        if(paciente == null) {
            return "Auth/Acceder :: accederFragment";
        }
        model.addAttribute("paciente", paciente);
        return "Paciente/PerfilPaciente :: perfilFragment";
    }

    @PostMapping("/ActualizarPerfil")
    public String ActualizarPerfil(@ModelAttribute Paciente paciente, HttpSession httpSession, Model model) {
        Paciente pacienteActualizado = pacienteService.actualizarPaciente(paciente);
        httpSession.setAttribute("paciente", pacienteActualizado);
        model.addAttribute("mensaje", "Actualizado correctamente");
        return "paciente/PerfilPaciente :: perfilFragment";
    }


    public void insert(HttpSession httpSession) {

        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setEmail("juan@gmail.com");
        usuario.setUsername("juanito");
        usuario.setPassword("juanito123");
        usuario.setRol(Usuario.RolType.Paciente);
        usuarioService.crearUsuario(usuario);

        Paciente paciente = new Paciente();
        paciente.setNombre(usuario.getNombre());
        paciente.setApellidos("Peréz");
        paciente.setEmail(usuario.getEmail());
        paciente.setDni("12345678");
        paciente.setTelefono("909909909");
        paciente.setUsername(usuario.getUsername());
        paciente.setUsuario(usuario);
        pacienteService.crearPaciente(paciente);

        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Pepe");
        usuario1.setEmail("pepe@gmail.com");
        usuario1.setUsername("pepe");
        usuario1.setPassword("admin123");
        usuario1.setRol(Usuario.RolType.Medico);
        usuarioService.crearUsuario(usuario1);

        Medico medico = new Medico();
        medico.setNombre(usuario1.getNombre());
        medico.setEmail(usuario1.getEmail());
        medico.setTelefono("980900901");
        medico.setEspecialidad("Ginecologo");
        medico.setUsuario(usuario1);
        medicoService.crearMedico(medico);
        Medico medicoSession =  medicoService.obtenerPorUsuarioId(usuario1.getId());
        httpSession.setAttribute("medico", medicoSession);
        Paciente pacienteSession = pacienteService.obtenerPorUsuarioId(usuario.getId());
        httpSession.setAttribute("paciente", pacienteSession);
        System.out.println(medicoSession);
        System.out.println(pacienteSession);
    }
}
