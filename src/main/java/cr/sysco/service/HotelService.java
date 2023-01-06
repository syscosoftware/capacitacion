package cr.sysco.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.sysco.model.Hotel;
import cr.sysco.repository.HotelRepository;


@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    

    public String insertar(Hotel hotel){
        try{
            this.hotelRepository.save(hotel);
            
            return "success";
        }catch(Exception ex){
            ex.printStackTrace();
            return ex.getMessage();
        } 
    }


    public Hotel buscar(Integer id){
        try{
            Optional<Hotel> lista = this.hotelRepository.findById(id);
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

    public  List<Hotel> buscarSQL(Hotel hotel){
        try{
            List<Hotel> lista = this.hotelRepository.buscarXNombreSQL(hotel.getNombre());

            
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

    public  List<Hotel> buscarHQL(Hotel hotel){
        try{
            List<Hotel> lista = this.hotelRepository.buscarXNombreHQL(hotel.getNombre());

            
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

    public  List<Hotel> listar(){
        try{ 
            return this.hotelRepository.findAll();
           
        }catch(Exception ex){
            ex.printStackTrace(); 
            return null;
        } 
    }

    public String eliminar(Integer id){
        try{
             this.hotelRepository.deleteById(id);
            return "success";
        }catch(Exception ex){
            ex.printStackTrace(); 
            return ex.getMessage();
        } 
    }
}
