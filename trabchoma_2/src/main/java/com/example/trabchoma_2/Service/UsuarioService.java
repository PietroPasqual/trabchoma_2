package com.example.trabchoma_2.Service;
import com.example.trabchoma_2.Model.Usuario;
import com.example.trabchoma_2.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll (){
        return usuarioRepository.findAll();
    }
 
    public boolean getUser(String nome) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public String registrar(Usuario usuario) {
        if (getUser(usuario.getNome())) {
            return "já existe esse Usuario:\n" + usuario.toString();
        }
        else{
            usuarioRepository.save(usuario);
            return "Usuário foi adicionado:\n" + usuario.toString();
        }
    }



}
