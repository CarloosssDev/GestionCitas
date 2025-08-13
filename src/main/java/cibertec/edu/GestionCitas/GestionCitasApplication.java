package cibertec.edu.GestionCitas;

import cibertec.edu.GestionCitas.Entity.Medico;
import cibertec.edu.GestionCitas.Entity.Paciente;
import cibertec.edu.GestionCitas.Entity.Usuario;
import cibertec.edu.GestionCitas.Service.MedicoService;
import cibertec.edu.GestionCitas.Service.PacienteService;
import cibertec.edu.GestionCitas.Service.UsuarioService;
import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionCitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionCitasApplication.class, args);
	}

}
