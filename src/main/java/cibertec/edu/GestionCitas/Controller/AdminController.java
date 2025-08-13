package cibertec.edu.GestionCitas.Controller;

import cibertec.edu.GestionCitas.Service.MedicoService;
import cibertec.edu.GestionCitas.Service.PacienteService;
import cibertec.edu.GestionCitas.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PacienteService pacienteService;


    @GetMapping
    public String MostrarPanel(Model model) {
        return "Admin/Panel";
    }

    @GetMapping("/Usuarios")
    public String ListarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "Admin/Usuarios :: usuariosFragment";
    }

    @GetMapping("/Medicos")
    public String ListarMedicos(Model model) {
        model.addAttribute("medicos", medicoService.listarMedicos());
        return "Admin/Medicos :: medicosFragment";
    }

    @GetMapping("/Pacientes")
    public String ListarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.listarPacientes());
        return "Admin/Pacientes :: pacientesFragment";
    }

}
