package cr.sysco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.sysco.model.Reservacion;
import cr.sysco.repository.ReservacionRepository;

@Service
public class ReservacionService {
        
    @Autowired
    private ReservacionRepository reservacionRepository;

    public String insertar (Reservacion reservacion){
        try {
            this.reservacionRepository.save(reservacion);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    
    public Optional<Reservacion> obtenerUno (Integer id){
        try {
            return this.reservacionRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public List<Reservacion> listar (){
        try {
            return this.reservacionRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public String actualizar (Reservacion reservacion){
        try {
            this.reservacionRepository.save(reservacion);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


    
    public String eliminar (Integer id){
        try {
            this.reservacionRepository.deleteById(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
