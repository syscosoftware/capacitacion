package cr.sysco.service;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cr.sysco.model.Cliente;
import cr.sysco.repository.ClienteRepository;



@Service
public class ClienteService {
@Autowired    
private ClienteRepository clienteRepository ;

public String insertar(Cliente cliente){
try {
    this.clienteRepository.save(cliente);
    return "sucess";
} catch (Exception ex) {
    ex.printStackTrace();
    return ex.getMessage();
}

}

public Cliente buscar(Integer id){
    try{
        Optional<Cliente> lista = this.clienteRepository.findById(id);
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

public  List<Cliente> buscarSQL(Cliente cliente){
    try{
        List<Cliente> lista = this.clienteRepository.buscarXNombreSQL(cliente.getNombre());
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

public  List<Cliente> buscarHQL(Cliente cliente){
    try{
        List<Cliente> lista = this.clienteRepository.buscarXNombreHQL(cliente.getNombre());
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

public  List<Cliente> listar(){
    try{ 
        return this.clienteRepository.findAll();
       
    }catch(Exception ex){
        ex.printStackTrace(); 
        return null;
    } 
}

public String eliminar(Integer id){
    try{
         this.clienteRepository.deleteById(id);
        return "success";
    }catch(Exception ex){
        ex.printStackTrace(); 
        return ex.getMessage();
    } 
}

}



