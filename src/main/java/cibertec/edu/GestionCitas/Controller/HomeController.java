package cibertec.edu.GestionCitas.Controller;

import cibertec.edu.GestionCitas.Entity.Medico;
import cibertec.edu.GestionCitas.Entity.Paciente;
import cibertec.edu.GestionCitas.Entity.Usuario;
import cibertec.edu.GestionCitas.Service.MedicoService;
import cibertec.edu.GestionCitas.Service.PacienteService;
import cibertec.edu.GestionCitas.Service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String Home() {
        return "redirect:/Paciente";
    }
}
