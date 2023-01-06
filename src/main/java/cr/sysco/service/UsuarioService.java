package cr.sysco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.sysco.model.Rol;
import cr.sysco.model.Usuario;
import cr.sysco.repository.UsuarioRepository;
import cr.sysco.repository.RolRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;


    public String insertar(Usuario usuario){
        try{


            if(usuario.getRol() != null){
                Optional<Rol> lista = this.rolRepository.findById(usuario.getRol().getId()); 
                try{
                    if(lista.get() == null){ 
                        this.rolRepository.save(usuario.getRol());
                    } 
                }catch(Exception ex){
                    this.rolRepository.save(usuario.getRol());
                }
            } 

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

    public String eliminar(Integer id){
        try{
             this.usuarioRepository.deleteById(id);
            return "success";
        }catch(Exception ex){
            ex.printStackTrace(); 
            return ex.getMessage();
        } 
    }

   
}
