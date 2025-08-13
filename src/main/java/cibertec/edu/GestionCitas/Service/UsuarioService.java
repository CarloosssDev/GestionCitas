package cibertec.edu.GestionCitas.Service;

import cibertec.edu.GestionCitas.Entity.Medico;
import cibertec.edu.GestionCitas.Entity.Paciente;
import cibertec.edu.GestionCitas.Entity.Usuario;
import cibertec.edu.GestionCitas.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario) {
        if (existePorEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("El Email ya está registrado");
        }
        if (existePorUsername(usuario.getUsername())) {
            throw new IllegalArgumentException("El Username ya está registrado");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Long Id, Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario iniciarSesion(String username, String password) {
       return usuarioRepository.findByUsernameAndPassword(username, password);
    }

    public Boolean existePorEmail(String Email) {
        return usuarioRepository.existsByEmail(Email);
    }

    public Boolean existePorUsername(String Username) {
        return usuarioRepository.existsByUsername(Username);
    }

}
