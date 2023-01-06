package cr.sysco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.sysco.model.Usuario;
import cr.sysco.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;


    public String insertar(Usuario usuario){
        try{
            this.usuarioRepository.save(usuario);
            return "success";
        }catch(Exception ex){
            ex.printStackTrace();
            return ex.getMessage();
        } 
    }

   
}
