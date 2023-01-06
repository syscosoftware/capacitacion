package cr.sysco.service;

import java.util.List;
import java.util.Optional;

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

    public Usuario buscar(Integer id){
        try{
            Optional<Usuario> lista = this.usuarioRepository.findById(id);
            if(lista!=null){
                return lista.get();
            }else{
                return null;
            } 
        }catch(Exception ex){
            ex.printStackTrace(); 
            return null;
        } 
    }

    public  List<Usuario> buscarSQL(Usuario usuario){
        try{
            List<Usuario> lista = this.usuarioRepository.buscarXNombreSQL(usuario.getNombre());

            
            if(lista!=null){
                return lista ;
            }else{
                return null;
            } 
        }catch(Exception ex){
            ex.printStackTrace(); 
            return null;
        } 
    }

    public  List<Usuario> buscarHQL(Usuario usuario){
        try{
            List<Usuario> lista = this.usuarioRepository.buscarXNombreHQL(usuario.getNombre());

            
            if(lista!=null){
                return lista ;
            }else{
                return null;
            } 
        }catch(Exception ex){
            ex.printStackTrace(); 
            return null;
        } 
    }



    public  List<Usuario> listar(){
        try{ 
            return this.usuarioRepository.findAll();
           
        }catch(Exception ex){
            ex.printStackTrace(); 
            return null;
        } 
    }

   
}
